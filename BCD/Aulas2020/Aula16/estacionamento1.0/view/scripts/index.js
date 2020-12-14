const xhr = new XMLHttpRequest();

const urlBase = "../../src/controll/routes/";

const tbodyCars = document.getElementById("tbodyCars");

const listaCadastrados = document.getElementById("listaCadastrados");
const listaVagas = document.getElementById("listaVagas");

var inpMarca = document.getElementById("marca");
var inpModelo = document.getElementById("modelo");
var inpObs = document.getElementById("obs");

var placabold = document.getElementById("placabold");

var vagasvagas = new Array();

function listCurrent() {
  for(let i = 1; i < 19; i++) {
    vagasvagas.push(i);
  }

  fetch(urlBase+"route.vagas.php")
    .then((resp)=>{
      if (!resp.ok)
        throw new Error("Erro ao executar requisição: " + resp.status);
      return resp.json();
    })
    .then((data)=>{
      data.forEach((val) => {
        let row = document.createElement("tr");
        for (let [key, value] of Object.entries(val)) {
          let col = document.createElement("td");
          if(key == "total") value = "R$ " + value;
          col.innerHTML = value;
          row.appendChild(col);
        }      

        row.setAttribute("data-toggle", "modal");
        row.setAttribute("data-target", "#modalExit");
        row.onclick = () => {
          placabold.innerHTML = val.placa;
        }

        tbodyCars.appendChild(row);
        
        let pos = vagasvagas.indexOf(parseInt(val.n_vaga));
        vagasvagas.splice(pos, 1);
      })
      
      vagasvagas.forEach((item) => {
        let option = document.createElement("option");    
        option.innerHTML = item;
        listaVagas.appendChild(option);
      })
    })
    .catch((err)=>{
      console.error(err.message);
    })

  fetch(urlBase+"route.veiculos.php")
    .then((resp)=>{
      if (!resp.ok)
        throw new Error("Erro ao executar requisição: " + resp.status);
      return resp.json();
    })
    .then((data)=>{
      data.forEach((val) => {
        let option = document.createElement("option");
        option.innerHTML = val.placa;
        localStorage.setItem(val.placa, JSON.stringify(val));
        listaCadastrados.appendChild(option);
      })
    })
    .catch((err)=>{
      console.error(err.message);
    })

}

function sendData(e) {

  let method = ""
  let dados = new FormData();

  if(e.innerHTML == "Salvar") {
    method = "POST";
    
    dados.append("placa", listaCadastrados.value);
    dados.append("n_vaga", listaVagas.value);
  }else {
    method = "PUT";

    dados = "placa=" + placabold.innerHTML;
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
  xhr.open(method, urlBase+"route.vagas.php");
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

function loadForm() {
  let obj = JSON.parse(localStorage.getItem(listaCadastrados.value));
  inpMarca.value = obj.marca;
  inpModelo.value = obj.modelo;
  if(obj.obs === null) obj.obs = " ";
  inpObs.value = obj.obs;
}
