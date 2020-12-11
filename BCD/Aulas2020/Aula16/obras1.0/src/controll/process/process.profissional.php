<?php

	require("../../domain/connection.php");
	require("../../domain/Profissional.php");

	class ProfissionalProcess {
		
		var $pd;

		function doGet($arr){
			$pd = new ProfissionalDAO();
			if(isset($arr["cpf"])){
				$sucess = $pd->read($arr["cpf"]);
			}else {
				$sucess = $pd->read("0");
			}
			http_response_code(200);
			echo json_encode($sucess);
		}

		function doPost($arr){
			$pd = new ProfissionalDAO();
			$prof = new Profissional();
			if(isset($arr["cpf"])) $prof->setCpf($arr["cpf"]);
			if(isset($arr["nome"])) $prof->setNome($arr["nome"]);
			if(isset($arr["funcao"])) $prof->setFuncao($arr["funcao"]);
			if(isset($arr["valorHora"])) $prof->setValorHora($arr["valorHora"]);
			if(isset($arr["foto"])) $prof->setFoto($arr["foto"]);
			$sucess = $pd->create($prof);
			if(is_object($sucess)){
				http_response_code(201);
			}else{
				http_response_code(200);
			}
			echo json_encode($sucess);
		}

		function doPut($arr){
			$pd = new ProfissionalDAO();
			$prof = new Profissional();
			if(isset($arr["cpf"])) $prof->setCpf($arr["cpf"]);
			if(isset($arr["nome"])) $prof->setNome($arr["nome"]);
			if(isset($arr["funcao"])) $prof->setFuncao($arr["funcao"]);
			if(isset($arr["valorHora"])) $prof->setValorHora($arr["valorHora"]);
			if(isset($arr["foto"])) $prof->setFoto($arr["foto"]);
			$sucess = $pd->update($prof);
			if(is_object($sucess)){
				http_response_code(202);
			}else{
				http_response_code(400);
			}
			echo json_encode($sucess);
		}

		function doDelete($arr){
			$pd = new ProfissionalDAO();
			if(isset($arr["cpf"])){
				$sucess = $pd->delete($arr["cpf"]);
				if(isset($sucess["err"])){
					http_response_code(405);
				}else{
					http_response_code(200);
				}
				echo json_encode($sucess);
			}
		}
	}