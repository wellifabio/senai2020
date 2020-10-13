<?php
//Recebendo a imagem
$imagem = null;
if (empty($_FILES["picture"])) {
    echo "Não recebida imagem<br>";
} else {
    $imagem = $_FILES["picture"];
}
//Preparando a conexão com o Banco de dados
$host = "localhost";
$username = "root";
$password = "";
$db = "orders";

if (empty($_POST)) {
    echo "Não recebi nada, aguardando requisição pelo verbo POST";
} else {
    //Recebendo e exibindo os dados de texto
    $name = $_POST["name"];
    $quantity = $_POST["quantity"];
    echo "Nome do produto: " . $name . "<br>";
    echo "Quantidade: " . $quantity . "<br>";

    if ($imagem != null) { //Se receber a imagem
        $tipoArquivo = explode("/", $imagem["type"])[1]; //Obtem o tipo de arquivo
        $nomeArquivo = time() . "." . $tipoArquivo; //Manta o nome do arquivo pegando a hora do sistema e o tipo do arquivo
        echo "Nome do arquivo: " . $nomeArquivo; //Mostra na tela o nome do arquivo
        if (move_uploaded_file($imagem['tmp_name'], $nomeArquivo)) { //Move o arquivo recebido para o diretório do servidor temporariamente
            $tamanhoImg = filesize($nomeArquivo); //Descobre o tamanho do arquivo
            $mysqlBlob = addslashes(fread(fopen($nomeArquivo, "r"), $tamanhoImg)); //Pega o arquivo e converte para o formato BLOB do Banco de dados
            $connection = mysqli_connect($host, $username, $password) or die("Impossível Conectar ao SGBD"); //Conecta no SGBD MySQL
            @mysqli_select_db($connection, $db) or die("Impossível Conectar ao BD"); //Conecta no Banco de dados "ORDERS"
            //Executa a QUERY
            mysqli_query($connection, "INSERT INTO products VALUES (default,'$name','$quantity','$mysqlBlob')") or die("O sistema não foi capaz de executar a query");
            mysqli_close($connection); //Fecha a conexão com o Banco de dados
            unlink($nomeArquivo); //Remove o arquivo temporário de imagem do diretório
        } else {
            echo "Erro ao enviar imagem para o BD";
        }
    }
}
