<?php

	class Vagas {
		var $placa;
		var $data;
		var $entrada;
		var $saida;
		var $n_vaga;

		function getPlaca(){
			return $this->placa;
		}
		function setPlaca($placa){
			$this->placa = $placa;
		}

		function getData(){
			return $this->data;
		}
		function setData($data){
			$this->data = $data;
		}

		function getEntrada(){
			return $this->entrada;
		}
		function setEntrada($entrada){
			$this->entrada = $entrada;
		}

		function getSaida(){
			return $this->saida;
		}
		function setSaida($saida){
			$this->saida = $saida;
		}

		function getN_vaga(){
			return $this->n_vaga;
		}
		function setN_vaga($n_vaga){
			$this->n_vaga = $n_vaga;
		}
	}

	class VagasDAO {
		function create($vagas) {
			$result = array();

			try {
				$query = "INSERT INTO registros (placa, data, entrada, n_vaga) VALUES ('".$vagas->getPlaca()."', CURDATE(), CURTIME(), ".$vagas->getN_vaga().")";

				$con = new Connection();

				if(Connection::getInstance()->exec($query) >= 1){
					$result[] = $vagas;
				}else {
					$result["err"] = "Falha ao inserir";
				}

				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}

			return $result;
		}

		function read() {
			$result = array();

			try {
				$query = "SELECT n_vaga, placa, obs, entrada, total FROM vw_estacionados_agora";

				$con = new Connection();

				$resultSet = Connection::getInstance()->query($query);

				while($row = $resultSet->fetchObject()){
					$result[] = $row;
				}

				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}

			return $result;
		}

		function readAll() {
			$result = array();

			try {
				$query = "SELECT * FROM vw_registros";

				$con = new Connection();

				$resultSet = Connection::getInstance()->query($query);

				while($row = $resultSet->fetchObject()){
					$result[] = $row;
				}

				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}

			return $result;
		}

		function update($placa) {
			$result = array();

			try {
				$query = "UPDATE registros SET saida = CURTIME() WHERE placa = '".$placa."' AND saida IS NULL";

				$con = new Connection();

				$status = Connection::getInstance()->prepare($query);

				if($status->execute()){
					$result["msg"] = "Alterado com Sucesso";
				}else {
					$result["err"] = "Falha na alteracao";
				}

				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}

			return $result;
		}

		function delete() {
			$result = array();

			try {
				$query = "DELETE FROM table_name WHERE condition";

				$con = new Connection();

				if(Connection::getInstance()->exec($query) >= 1){
				}

				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}

			return $result;
		}
	}
