//Carrega as variáveis globais
var c = document.querySelector("#valorFinanciado");
var n = document.querySelector("#numeroParcelas");
var i = document.querySelector("#porcentagemJuros");
var montante = document.querySelector("#montanteFinal");
var valorParcelas = document.querySelector("#valorParcelas");
var corpoTabela = document.querySelector("#tableBody");
var botao = document.querySelector("#botao");
var template = document.querySelector("#templateLinhas"); //Template é uma tabela invisível

//Criando botões botão delete e update para remover linhas da tabela
var btDelete = document.createElement("button");
btDelete.innerText = "Excluir";
var btUpdate = document.createElement("button");
btUpdate.innerText = "Alterar";

//Função para calcular os Juros (apenas Compostos)
function jurosCompostos(){
    var m = parseFloat(parseFloat(c.value) * Math.pow(1+parseFloat(i.value)/100,parseInt(n.value))).toFixed(2);
    var p = parseFloat(m / parseInt(n.value)).toFixed(2);
    montante.setAttribute("value", m);
    valorParcelas.setAttribute("value", p);
}

//Função que acrescenta valores a uma tabela, utilizando um template
function criaLinhasTemplate(event){
    event.preventDefault(); //Executa com o do DOM padrão já carregado. Senão a págia é recarregada.
    if(c.value != "" && n.value != "" && i.value != ""){
        lista = template.content.querySelectorAll("td"); //Inicia uma lista de colunas <TD>
        lista[0].textContent = c.value;
        lista[1].textContent = n.value;
        lista[2].textContent = i.value;
        lista[3].textContent = montante.value;
        lista[4].textContent = valorParcelas.value;
        btUpdate.setAttribute("onclick","alterarLinha(this)");
        btDelete.setAttribute("onclick","excluirLinha(this)");
        lista[5].appendChild(btUpdate);
        lista[5].appendChild(btDelete);
        var novaLinha = document.importNode(template.content, true); //Junta as colunas em uma linha
        corpoTabela.appendChild(novaLinha); //Transfere o template para a tabela visível
        c.value = "";//Limpa o campo do formulário
        n.value = "";//Limpa o campo do formulário
        i.value = "";//Limpa o campo do formulário
    } else {
        alert("Preencha os campos obrigatórios para registrar a simulação.");
    }
}

//Função para alterar o conteúdo de linhas da tabela
function alterarLinha(elemento){
    c.value = elemento.parentNode.parentNode.cells[0].innerHTML;
    n.value = elemento.parentNode.parentNode.cells[1].innerHTML;
    i.value = elemento.parentNode.parentNode.cells[2].innerHTML;
    jurosCompostos(); //Chama a função para calcular novamente os Juros
    elemento.parentNode.parentNode.remove();
}

//Função para excluir linhas de uma tabela
function excluirLinha(elemento){
    elemento.parentNode.parentNode.remove();
}

//Eventos principais
i.addEventListener("keyup",jurosCompostos);
botao.addEventListener("click",criaLinhasTemplate);

