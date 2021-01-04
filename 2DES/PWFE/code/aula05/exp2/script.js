//Carrega as variáveis globais
const c = document.querySelector("#valorFinanciado"); //Entrada
const n = document.querySelector("#numeroParcelas"); //Entrada
const i = document.querySelector("#porcentagemJuros"); //Entrada
const montante = document.querySelector("#montanteFinal"); //Saída
const valorParcelas = document.querySelector("#valorParcelas"); //Saída
const corpoTabela = document.querySelector("#tableBody"); //Saída
const botao = document.querySelector("#botao");
c; //Processamento

//Função para calcular os Juros Compostos
function jurosCompostos() {
  //Processamento, variáveis locais
  let m = parseFloat(
    parseFloat(c.value) *
      Math.pow(1 + parseFloat(i.value) / 100, parseInt(n.value))
  ).toFixed(2);
  let p = parseFloat(m / parseInt(n.value)).toFixed(2);
  montante.setAttribute("value", m); //Saída em variáveis globais
  valorParcelas.setAttribute("value", p); //Saída em variáveis globais
}

function adicionar() {
  if (c.value != "" && n.value != "" && i.value != "") {
    //Cria os elementos HTML (TR e TD) Linhas e Colunas
    const tr = document.createElement("tr");
    const td1 = document.createElement("td");
    const td2 = document.createElement("td");
    const td3 = document.createElement("td");
    const td4 = document.createElement("td");
    const td5 = document.createElement("td");
    //Atribui valores entre as colunas TD
    td1.innerText = c.value;
    td2.innerText = n.value;
    td3.innerText = i.value;
    td4.innerText = montante.value;
    td5.innerText = valorParcelas.value;
    //Inclui objetos HTML filhos para a linha TR (as colunas)
    tr.appendChild(td1);
    tr.appendChild(td2);
    tr.appendChild(td3);
    tr.appendChild(td4);
    tr.appendChild(td5);
    corpoTabela.appendChild(tr); //Acrescente o filho TR ao corpo TBODY
    //Limpar os inputs de entrada no formulário
    c.value = "";
    n.value = "";
    i.value  = "";
  }
}

//Eventos principais
i.addEventListener("keyup", jurosCompostos); //Processamento
botao.addEventListener("click", adicionar); //Processamento
