<?php

	require("../../domain/connection.php");
	require("../../domain/Vagas.php");

	class VagasProcess {
		var $vd;

		function doGet($arr){
			$vd = new VagasDAO();
			if(!isset($arr["tipo"])) {
				$sucess = $vd->read();
			}else {
				$sucess = $vd->readAll();
			} 
			http_response_code(200);
			echo json_encode($sucess);
		}


		function doPost($arr){
			$vd = new VagasDAO();
			if(
				isset($arr["placa"]) &&
				isset($arr["n_vaga"])
			){
				$registro = new Vagas();
				$registro->setPlaca($arr["placa"]);
				$registro->setN_vaga($arr["n_vaga"]);
				$return = $vd->create($registro);
			}else {
				$return["err"] = "Dados incompletos";
			}
			http_response_code(200);
			echo json_encode($return);
		}


		function doPut($arr){
			$vd = new VagasDAO();
			if(
				isset($arr["placa"])
			){
				$return = $vd->update($arr["placa"]);
			}else {
				$return["err"] = "Dados incompletos";
			}
			http_response_code(200);
			echo json_encode($return);
		}


		function doDelete($arr){
			$vd = new VagasDAO();
			$sucess = "use to result to DAO";
			http_response_code(200);
			echo json_encode($sucess);
		}
	}