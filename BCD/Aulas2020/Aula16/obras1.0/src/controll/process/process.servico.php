<?php

	require("../../domain/connection.php");
	require("../../domain/Servico.php");

	class ServicoProcess {
		var $sd;

		function doGet($arr){
			$sd = new ServicoDAO();
			if(isset($arr["finished"])){
				$sucess = $sd->readFinished();
			} else {
				if(isset($arr["id"])){
					$sucess = $sd->read($arr["id"]);
				}else{
					$sucess = $sd->read("0");
				}	
			}
			http_response_code(200);
			echo json_encode($sucess);
		}


		function doPost($arr){
			$sd = new ServicoDAO();
			$servico = new Servico();
			if(isset($arr["nome"]))$servico->setNome($arr["nome"]);
			if(isset($arr["descricao"]))$servico->setDescricao($arr["descricao"]);
			if(isset($arr["localizacao"]))$servico->setLocal($arr["localizacao"]);
			if(isset($arr["tempo_estimado"]))$servico->setTempoEstimado($arr["tempo_estimado"]);
			if(isset($arr["antes"]))$servico->setAntes($arr["antes"]);
			if(isset($arr["depois"]))$servico->setDepois($arr["depois"]);
			$sucess = $sd->create($servico);
			if(is_object($sucess)){
				http_response_code(201);
			}else{
				http_response_code(200);
			}
			echo json_encode($sucess);
		}


		function doPut($arr){
			$sd = new ServicoDAO();
			$sucess = "use to result to DAO";
			http_response_code(200);
			echo json_encode($sucess);
		}


		function doDelete($arr){
			$sd = new ServicoDAO();
			$sucess = "use to result to DAO";
			http_response_code(200);
			echo json_encode($sucess);
		}
	}