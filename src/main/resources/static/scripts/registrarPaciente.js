window.addEventListener("load", function () {
  const form = document.forms[0];
  const nombre = document.querySelector("#inputName");
  const apellido = document.querySelector("#inputLasName");
  const dni = document.querySelector("#inputDni");
  const fechaAlta = document.querySelector("#inputDate");
  const calle = document.querySelector("#inputCalle");
  const numero = document.querySelector("#inputNumero");
  const localidad = document.querySelector("#inputLocalidad");
  const provincia = document.querySelector("#inputProvincia");
  const url = "https://localhost:8081";

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

  function realizarRegistro(settings) {
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

  // script.js

  // document.addEventListener('DOMContentLoaded', function () {
  //     // Llama a la función para obtener datos del backend y mostrarlos en la página
  //     fetchDataAndRender();
  // });

  // async function fetchDataAndRender() {
  //     try {
  //         // Realiza una solicitud al backend para obtener datos de la API
  //         const data = await fetchBackendData();

  //         // Renderiza los datos en la página
  //         renderData(data);
  //     } catch (error) {
  //         console.error('Error al obtener datos del backend:', error);
  //     }
  // }

  // async function fetchBackendData() {
  //     // Realiza una solicitud al backend que, a su vez, se comunica con la API
  //     const response = await fetch('http://localhost:3000/api/data'); // Ajusta la ruta según tu configuración
  //     const data = await response.json();
  //     return data;
  // }

  // function renderData(data) {
  //     // Modifica el DOM para mostrar los datos en la página
  //     const resultContainer = document.getElementById('result-container');
  //     resultContainer.innerHTML = '';

  //     data.forEach(item => {
  //         const listItem = document.createElement('div');
  //         listItem.textContent = item.name; // Ajusta esto según la estructura de tus datos
  //         resultContainer.appendChild(listItem);
  //     });
  // }
});
