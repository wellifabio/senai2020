//Carrega as variáveis globais
var c = document.querySelector("#valorFinanciado");
var n = document.querySelector("#numeroParcelas");
var i = document.querySelector("#porcentagemJuros");
var montante = document.querySelector("#montanteFinal");
var valorParcelas = document.querySelector("#valorParcelas");
var botao = document.querySelector("#botao");

//Funções para calcular os Juros (Simples e Compostos)
function jurosSimples(){
    var m = parseFloat(c.value) + parseFloat(c.value) * parseFloat(i.value) / 100 * parseInt(n.value);
    var p = (m / parseInt(n.value)).toFixed(2);
    montante.setAttribute("value", m);
    valorParcelas.setAttribute("value", p);
}
function jurosCompostos(){
    var m = parseFloat(parseFloat(c.value) * Math.pow(1+parseFloat(i.value)/100,parseInt(n.value))).toFixed(2);
    var p = parseFloat(m / parseInt(n.value)).toFixed(2);
    montante.setAttribute("value", m);
    valorParcelas.setAttribute("value", p);
}

//Eventos principais
i.addEventListener("keyup",jurosSimples);
botao.addEventListener("click",jurosCompostos);











