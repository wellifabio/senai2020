//Pegar os elementos do Formulário
const nome = document.getElementById("nome");
const idade = document.getElementById("idade");
const classificadoComo = document.getElementById("classificado");
const botao = document.getElementById("botao"); //Botão Adicionar
const corpoT = document.getElementById("corpoTabela"); //Elemento da tabela de destino

//Função básica de classificação de idade
function classifica() {
  if (idade.value < 10) {
    classificadoComo.value = "Criança";
  } else if (idade.value < 15) {
    classificadoComo.value = "Adolescente";
  } else if (idade.value < 25) {
    classificadoComo.value = "Jovem";
  } else if (idade.value < 40) {
    classificadoComo.value = "Adulto";
  } else {
    classificadoComo.value = "Passou da idade";
  }
}

function adicioarLinhas() {
  if (classificadoComo.value != "") {
    //Cria os elementos HTML (TR e TD) Linhas e Colunas
    const linha = document.createElement("tr");
    const col1 = document.createElement("td");
    const col2 = document.createElement("td");
    const col3 = document.createElement("td");
    const col4 = document.createElement("td");
    //Atribui valores entre as colunas TD
    col1.innerText = nome.value;
    col2.innerText = idade.value;
    col3.innerText = classificadoComo.value;
    col4.innerHTML =
      "<input type='button' value=' Alterar ' onclick='alterarLinhas(this)'/>";
    col4.innerHTML +=
      "<input type='button' value=' Del ' onclick='excluirLinhas(this)'/>";
    //Inclui objetos HTML filhos para a linha TR (as colunas)
    linha.appendChild(col1);
    linha.appendChild(col2);
    linha.appendChild(col3);
    linha.appendChild(col4);
    //Acrescenta a linha ao corpo da Tabela
    corpoT.appendChild(linha);
    //Limpar os Campos do Formulário
    nome.value = "";
    idade.value = "";
    classificadoComo.value = "";
  }
}

function excluirLinhas(elemento) {
  elemento.parentNode.parentNode.remove();
}

function alterarLinhas(elemento) {
  elemento.parentNode.parentNode.cells[0].setAttribute(
    "contenteditable",
    "true"
  );
  elemento.parentNode.parentNode.cells[1].setAttribute(
    "contenteditable",
    "true"
  );
  elemento.parentNode.parentNode.cells[2].setAttribute(
    "contenteditable",
    "true"
  );
  //Remove o botão alterar, porque estamos editando a linha
  elemento.parentNode.parentNode.cells[3].innerHTML =
    "</td>" +
    "<input type='button' value=' Concluir ' onclick='concluirEdicao(this)'/>" +
    "</td>";
}

function concluirEdicao(elemento) {
  elemento.parentNode.parentNode.cells[0].setAttribute(
    "contenteditable",
    "false"
  );
  elemento.parentNode.parentNode.cells[1].setAttribute(
    "contenteditable",
    "false"
  );
  elemento.parentNode.parentNode.cells[2].setAttribute(
    "contenteditable",
    "false"
  );
  //Ao concluir a edição devolve o botão
  elemento.parentNode.parentNode.cells[3].innerHTML =
    "<td><input type='button' value=' Alterar ' onclick='alterarLinhas(this)'/>" +
    "<input type='button' value=' Del ' onclick='excluirLinhas(this)'/></td>";
}

idade.addEventListener("keyup", classifica);
botao.addEventListener("click", adicioarLinhas);
