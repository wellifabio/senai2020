//O Java Script (Linguagem de Programação) assume o controle dos elementos HTML
var botao = document.querySelector("#botao");
var quadro = document.querySelector("#quadro");

//Alterar os atributos e eventos dos elementos HTML
//Atributos e eventos do botão
botao.setAttribute("src","link1.png"); //Atributo
botao.setAttribute("class","botoes"); //Atributo
botao.addEventListener("click",click); //Evento = Método com um comportamento
//Atributos e eventos do quadro
quadro.setAttribute("class","quadros");
quadro.setAttribute("src","pag0.html");

//Função que realmente muda ou cria um novo comportamento (Evento)
function aleatorio(){
    var aleatorio = Math.floor(Math.random() * 4);
    return aleatorio;
}

function click(){
    quadro.setAttribute("src","pag"+aleatorio()+".html");
}
