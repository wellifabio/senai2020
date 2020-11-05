<?php
    require("../domain/pessoa.php");
	header("Content-type: application/json");
	$pd = new PessoaDAO();

	if(!empty($_GET)){
		echo json_encode($pd->readAll());
	}
	
	if(!empty($_POST)){
		$pessoa = new Pessoa();
		$pessoa->setNome($_POST["nome"]);
		$pessoa->setTelefone($_POST["telefone"]);
		echo json_encode($pd->create($pessoa));
	}
	
?>
	

