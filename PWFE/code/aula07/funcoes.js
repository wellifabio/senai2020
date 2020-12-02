//Funções Clássicas JavaScript
//Palavra chave function
//Nome da função
//Parâmetros entre parênteses
//Corpo da função
//Opcional: Retorno com a palavra chave return

function fazLogo(){
    let v1 = document.getElementById("v1").value;
    let v2 = document.getElementById("v2").value;
    let saida = document.getElementById("saida");
    saida.value = soma(v1,v2);
}

//Mais Verboso
function somaAntiga(parametro1, parametro2){
    return parseInt(parametro1) + parseInt(parametro2);
}
//Menos Verboso
const soma = (parametro1, parametro2) => parseInt(parametro1) + parseInt(parametro2);

