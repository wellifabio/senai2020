const pokemon = document.querySelector("#pokemon");
const wellington = document.querySelector("#wellington");
//CORS (Cross-Origin Resource Sharing) - Primeiro precisamos entender o CORS
//Que bloqueia requisições feitas por domínio diferentes
//Ex. http://wellifabio.com:80 para http://localhost:8080
const url1 = "https://pokeapi.co/api/v2/pokemon/1"; //CORS - livre para qualquer endereço
console.log(url1); //Mostra a URL no console
//AJAX (Asynchronous JavaScript and XML) ou JavaScript e XML Assíncronos
//Explicação AJAX em (https://www.hostinger.com.br/tutoriais/o-que-e-ajax/)
fetch(url1, { method: "GET" })
  .then(function (resposta) {
    if (!resposta.ok)
      throw new Error("Erro ao executar requisição: " + resposta.status);
    return resposta.json();
  })
  .then(function (dados) {
    console.log(dados);
    pokemon.innerHTML = `<p>Nome: ${dados.name}</p>`;
    pokemon.innerHTML += `<p>Id: ${dados.id}</p>`;
    pokemon.innerHTML += `<img src='${dados.sprites.front_default}'/>`;
  })
  .catch(function (erro) {
    console.error(erro.message);
  });

const url2 = "http://wellifabio.000webhostapp.com/src/controllers"; //CORS bloqueado por segurança
const url3 = "http://localhost/site/src/controllers/"; //CORS desbloqueada Localmente
console.log(url2);
console.log(url3);
fetch(url3)
  .then(function (resposta) {
    if (!resposta.ok)
      throw new Error("Erro ao executar requisição: " + resposta.status);
    return resposta.json();
  })
  .then(function (dados) {
    console.log(dados);
    dados.forEach((val) => {
      let linha = document.createElement("tr");
      linha.innerHTML = `<tr><td>${val.nome}</td>`;
      linha.innerHTML += `<td>${val.email}</td>`;
      linha.innerHTML += `<td>${val.tipo}</td>`;
      linha.innerHTML += `<td>${val.situacao}</td></tr>`;
      wellington.appendChild(linha);
    });
  })
  .catch(function (erro) {
    console.error(erro.message);
  });

//A sulução correta é configurar o cabeçalho da API no BackEnd header("Access-Control-Allow-Origin:dominios permitidos");
//header("Access-Control-Allow-Origin:* para todos");
//Uma outra solução para bloqueio por CORS utilizando seria utilizando PROXY
//O que é PROXY (https://www.welivesecurity.com/br/2019/12/20/o-que-e-um-proxy-e-para-que-serve/)
