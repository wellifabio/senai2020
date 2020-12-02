var campo1 = document.querySelector("#valor1");
var campo2 = document.querySelector("#valor2");
var botao = document.querySelector("#botao");
var adicao = document.querySelector("#adicao");
var subtracao = document.querySelector("#subtracao");
var multiplicacao = document.querySelector("#multiplicacao");
var divisao = document.querySelector("#divisao");

botao.addEventListener("click",calcular);

function calcular(){

    var soma = parseInt(campo1.value) + parseInt(campo2.value);
    var menos = parseInt(campo1.value) - parseInt(campo2.value);
    var mult = parseInt(campo1.value) * parseInt(campo2.value);
    var div = parseInt(campo1.value) / parseInt(campo2.value);
    
    adicao.setAttribute("value",soma);
    subtracao.setAttribute("value",menos);
    multiplicacao.setAttribute("value",mult);
    divisao.setAttribute("value",div);

}