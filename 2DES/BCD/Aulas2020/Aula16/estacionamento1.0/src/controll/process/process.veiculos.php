<?php

	require("../../domain/connection.php");
	require("../../domain/Veiculos.php");

	class VeiculosProcess {
		var $vd;

		function doGet($arr){
			$vd = new VeiculosDAO();
			if(isset($arr["placa"])) {
				$return = $vd->read($arr["placa"]);
			}else{
				$return = $vd->readAll();
			}
			http_response_code(200);
			echo json_encode($return);
		}


		function doPost($arr){
			$vd = new VeiculosDAO();
			if(
					isset($arr["placa"]) &&	$arr["placa"] != ""	&&			
					isset($arr["modelo"]) && $arr["modelo"] != ""	&&				
					isset($arr["marca"]) &&	$arr["marca"] != ""
				) {
				$veiculo = new Veiculos();
				$veiculo->setPlaca($arr["placa"]);
				$veiculo->setModelo($arr["modelo"]);
				$veiculo->setMarca($arr["marca"]);
				$veiculo->setObs($arr["obs"]);
				$return = $vd->create($veiculo);
			}else {
				$return["err"] = "Dados incompletos";
			}
			http_response_code(200);
			echo json_encode($return);
		}


		function doPut($arr){
			$vd = new VeiculosDAO();
			if(
					isset($arr["placa"]) &&	$arr["placa"] != ""	&&			
					isset($arr["modelo"]) && $arr["modelo"] != ""	&&				
					isset($arr["marca"]) &&	$arr["marca"] != "" &&
					isset($arr["oldplaca"]) &&	$arr["oldplaca"] != ""
				) {
				$veiculo = new Veiculos();
				$veiculo->setPlaca($arr["placa"]);
				$veiculo->setModelo($arr["modelo"]);
				$veiculo->setMarca($arr["marca"]);
				$veiculo->setObs($arr["obs"]);
				$placaAntiga = $arr["oldplaca"];
				$return = $vd->update($placaAntiga, $veiculo);
			}else {
				$return["err"] = "Dados incompletos";
			}
			http_response_code(200);
			echo json_encode($return);
		}


		function doDelete($arr){
			$vd = new VeiculosDAO();
			if(isset($arr["placa"])) {
				$return = $vd->delete($arr["placa"]);
			}else{
				$return["err"] = "Dados incompletos";
			}
			http_response_code(200);
			echo json_encode($return);
		}
	}