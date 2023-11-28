window.addEventListener("load", function () {
  const form = document.forms[0];
  const nombre = document.querySelector("#inputName");
  const apellido = document.querySelector("#inputLastName");
  const dni = document.querySelector("#inputDni");
  const fechaAlta = document.querySelector("#inputDate");
  const calle = document.querySelector("#inputCalle");
  const numero = document.querySelector("#inputNumero");
  const localidad = document.querySelector("#inputLocalidad");
  const provincia = document.querySelector("#inputProvincia");
  const url = "http://localhost:8081";

  form.addEventListener("submit", function (event) {
    event.preventDefault();

    const registro = {
      nombre: nombre.value,
      apellido: apellido.value,
      dni: dni.value,
      fechaAlta: fechaAlta.value,
      domicilioEntradaDto: {
        calle: calle.value,
        numero: numero.value,
        localidad: localidad.value,
        provincia: provincia.value,
      },
    };

    const settings = {
      method: "POST",
      body: JSON.stringify(registro),
      headers: {
        "Content-Type": "application/json",
      },
    };

    registrarPaciente(settings);

    form.reset();
  });

  function registrarPaciente(settings) {
    console.log("Lanzando consulta a la API...");
    fetch(`${url}/pacientes/registrar`, settings)
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
