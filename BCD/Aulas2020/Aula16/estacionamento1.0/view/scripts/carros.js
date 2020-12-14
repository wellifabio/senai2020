const xhr = new XMLHttpRequest();

const urlBase = "../../src/controll/routes/route.veiculos.php";

const tbodyCars = document.getElementById("tbodyCars");

var inpPlaca = document.getElementById("placa");
var inpMarca = document.getElementById("marca");
var inpModelo = document.getElementById("modelo");
var inpObs = document.getElementById("obs");
var inpType = document.getElementById("type");
var inpOldPlaca = document.getElementById("placaantiga");

var buttonModal = document.getElementById("buttonModal");
var buttonDelete = document.getElementById("buttonDelete");

function listCars() {
  fetch(urlBase)
    .then((resp) => {
      if (!resp.ok)
        throw new Error("Erro ao executar requisição: " + resp.status);
      return resp.json();
    })
    .then((data) => {
      data.forEach((val) => {
        let row = document.createElement("tr");
        for (let [key, value] of Object.entries(val)) {
          let col = document.createElement("td");
          col.innerHTML = value;
          row.appendChild(col);
        }        
        
        row.setAttribute("data-toggle", "modal");
        row.setAttribute("data-target", "#modalRegister");
        
        row.onclick = () => {
          inpOldPlaca.value = val.placa;
          inpPlaca.value = val.placa;
          inpMarca.value = val.marca;
          inpModelo.value = val.modelo;
          if(val.obs === null) val.obs = " ";
          inpObs.value = val.obs;
          inpType.value = "update";
          buttonDelete.style.display = "block";
        }
        tbodyCars.appendChild(row);
      })
    })
    .catch((err) => {
      console.error(err.message);
    })
}

function sendData(e) {
  let method = "";
  let dados;

  if(e.innerHTML == "Salvar") {
    if(inpType.value == "insert") {
      method = "POST";
      dados = new FormData();
      dados.append("placa", inpPlaca.value);
      dados.append("marca", inpMarca.value);
      dados.append("modelo", inpModelo.value);
      dados.append("obs", inpObs.value);
    }else {
      method = "PUT";
      dados = "placa=" + inpPlaca.value;
      dados += "&marca=" + inpMarca.value;
      dados += "&modelo=" + inpModelo.value;
      dados += "&obs=" + inpObs.value;
      dados += "&oldplaca=" + inpOldPlaca.value;
    }
  }else {
    let response = prompt("Para confirmar a exclusao digite: EXCLUIR");

    if(response === "EXCLUIR") {
      method = "DELETE";
      dados = "placa=" + inpPlaca.value;
    }else {
      return;
    }
  }
  
  xhr.addEventListener("readystatechange", function () {
    if (this.readyState === this.DONE) {
      let resp = JSON.parse(this.responseText);
      if (resp.hasOwnProperty("err")) {
        alert(resp.err);
      }else {
        setTimeout(() => { window.location.reload(); }, 1000);
      }
    }
  });
  xhr.open(method, urlBase);
  xhr.send(dados);
}

function buscacarro(e) {
  let busca = e.value.toUpperCase();
  tbodyCars.childNodes.forEach((child) => {
    if(child.innerHTML.toUpperCase().includes(busca)) {
      child.style.display = "table-row";
    }else {
      child.style.display = "none";
    }
  })
}

function cleanModal() {
  inpPlaca.value = "";
  inpModelo.value = "";
  inpMarca.value = "";
  inpObs.value = "";
  inpType.value = "insert";
  buttonDelete.style.display = "none";
}
