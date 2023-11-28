window.addEventListener("load", function () {
  const form = document.forms[0];
  const matricula = document.querySelector("#inputMatricula");
  const nombre = document.querySelector("#inputName");
  const apellido = document.querySelector("#inputLastName");
  const url = "http://localhost:8081";

  form.addEventListener("submit", function (event) {
    event.preventDefault();

    const registro = {
      matricula: matricula.value,
      nombre: nombre.value,
      apellido: apellido.value
    };

    const settings = {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(registro),
    };

    registrarOdontologo(settings);

    form.reset();
  });

  function registrarOdontologo(settings) {
    console.log("Lanzando consulta a la API...");
    fetch(`${url}/odontologos/registrar`, settings)
      .then((response) => {
        console.log(response);
        
        if (response.ok != true) {
          alert("Alguno de los datos es incorrecto.");
        }

        return response.json();
      })

      .then((data) => {
        console.log("Promesa cumplida: ");
        console.log(data);

        if (data.jwt) {
          localStorage.setItem("jwt", JSON.stringify(data.jwt));

          location.replace("./index.html");
        }
      })
      .catch((error) => {
        console.log("Promesa rechazada: ");
        console.log(error);
      });
  }
});
