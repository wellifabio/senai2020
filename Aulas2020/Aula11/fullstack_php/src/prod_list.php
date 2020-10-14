<?php
//Exemplo com programação estrutural, Esta classe funciona como um Controller MVC
//Comportamento de Listar em um CRUD
//Dados para conexão ao Banco de dados
$host = "localhost";
$username = "root";
$password = "";
$db = "orders";
//Realizando a conexão efetiva ao SGBD e ao Banco de dados
$connection = mysqli_connect($host, $username, $password) or die("Impossível conectar ao SGBD.");
@mysqli_select_db($connection, $db) or die("Impossível conectar ao BD.");
$result = mysqli_query($connection,"SELECT id_prod,name,quantity FROM products") or die("Impossível executar a query");
$saida = array();
while($row=mysqli_fetch_object($result)) {
    array_push($saida, $row);
}
mysqli_close($connection); //Encerra a conexão
header("Content-type: application/json");//Define o conteúdo do retorno
header("Access-Control-Allow-Origin:http://127.0.0.1:5500"); //COncede acesso CORS para url local "Live Server"
echo json_encode($saida); //Converte a saída para JSON array