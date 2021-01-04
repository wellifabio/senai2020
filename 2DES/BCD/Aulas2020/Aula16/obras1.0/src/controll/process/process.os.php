<?php

	require("../../domain/connection.php");
	require("../../domain/Os.php");

	class OsProcess {
		
		var $od;

		function doGet($arr){
			$od = new OsDAO();
			if(isset($arr["num"])){
				$sucess = $od->read($arr["num"]);
			}else {
				$sucess = $od->read("0");
			}
			http_response_code(200);
			echo json_encode($sucess);
		}

		function doPost($arr){
			$od = new OsDAO();
			$os = new Os();
			if(isset($arr["id_servico"])) $os->setIdServico($arr["id_servico"]);
			if(isset($arr["profissional"])) $os->setProfissional($arr["profissional"]);
			if(isset($arr["data_inicio"])) $os->setDataInicio($arr["data_inicio"]);
			$sucess = $od->create($os);
			if(is_object($sucess)){
				http_response_code(201);
			}else{
				http_response_code(200);
			}
			echo json_encode($sucess);
		}

		function doPut($arr){
			$od = new OsDAO();
			$os = new Os();
			if(isset($arr["num_os"])) $os->setNumOs($arr["num_os"]);
			if(isset($arr["id_servico"])) $os->setIdServico($arr["id_servico"]);
			if(isset($arr["profissional"])) $os->setProfissional($arr["profissional"]);
			if(isset($arr["data_inicio"])) $os->setDataInicio($arr["data_inicio"]);
			if(isset($arr["data_conclusao"])) $os->setDataConclusao($arr["data_conclusao"]);
			if(isset($arr["tempo_total_horas"])) $os->setTempoTotal($arr["tempo_total_horas"]);
			if(isset($arr["baixaos"])){
				$sucess = $od->darBaixaOs($os);
			} else {
				$sucess = $od->update($os);
			}
			if(is_object($sucess)){
				http_response_code(202);
			}else{
				http_response_code(400);
			}
			echo json_encode($sucess);		
		}

		function doDelete($arr){
			$od = new OsDAO();
			if(isset($arr["num"])){
				$sucess = $od->delete($arr["num"]);
				if(isset($sucess["err"])){
					http_response_code(405);
				}else{
					http_response_code(200);
				}
				echo json_encode($sucess);
			}
		}
	}