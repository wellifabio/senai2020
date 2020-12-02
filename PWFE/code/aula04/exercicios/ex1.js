//
var nome = document.querySelector("#nome");
var sobrenome = document.querySelector("#sobre");
var juntar = document.querySelector("#join");

//A função é chamada a cada evento "keyup" quando soltamos uma tecla do teclado. 
sobrenome.addEventListener("keyup",nomeCompleto);

function nomeCompleto(){
    juntar.setAttribute("value",nome.value+" "+sobre.value);
}