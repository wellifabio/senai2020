const listProd = document.querySelector("#listProd");
const url = "http://localhost/orders/src/prod_list.php";
//AJAX (Asynchronous JavaScript and XML) ou JavaScript e XML Assíncronos
//fetch é uma função assíncrona AJAX que busca dados em uma URL
fetch(url)
  .then(function (resp) {
    //Obtem a resposta da URL no formato JSON
    if (!resp.ok)
      throw new Error("Erro ao executar requisição: " + resp.status);
    return resp.json();
  })
  .then(function (data) {
    //Se obteve a resposta explora os dados recebidos
    data.forEach((val) => {
      let row = document.createElement("tr");
      row.innerHTML = `<tr><td>${val.id_prod}</td>`;
      row.innerHTML += `<td>${val.name}</td>`;
      row.innerHTML += `<td>${val.quantity}</td>`;
      row.innerHTML += `<td>
      <img src='http://localhost/orders/src/get_picture.php?id=${val.id_prod}' width='100px'>
      </td></tr>`;
      listProd.appendChild(row);
    });
  }) //Se obteve erro no processo exibe no console do navegador
  .catch(function (error) {
    console.error(error.message);
  });
