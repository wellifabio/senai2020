<?php

	class Veiculos {
		var $placa;
		var $modelo;
		var $marca;
		var $obs;

		function getPlaca(){
			return $this->placa;
		}
		function setPlaca($placa){
			$this->placa = $placa;
		}

		function getModelo(){
			return $this->modelo;
		}
		function setModelo($modelo){
			$this->modelo = $modelo;
		}

		function getMarca(){
			return $this->marca;
		}
		function setMarca($marca){
			$this->marca = $marca;
		}

		function getObs(){
			return $this->obs;
		}
		function setObs($obs){
			$this->obs = $obs;
		}
	}

	class VeiculosDAO {
		function create($veiculo) {
			$result = array();

			try {                                                                   
				$query = "INSERT INTO veiculos (placa, modelo, marca, obs) VALUES ('".$veiculo->getPlaca()."', '".$veiculo->getModelo()."', '".$veiculo->getMarca()."', '".$veiculo->getObs()."')";
			
				$con = new Connection();

				if(Connection::getInstance()->exec($query) >= 1){
					$result[] = $veiculo;
				}else {
					$result["err"] = "Falha ao inserir";
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
				$query = "SELECT placa, marca, modelo, obs FROM veiculos";

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

		function read($placa) {
			$result = array();

			try {
				$query = "SELECT * FROM veiculos WHERE placa = '$placa'";

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

		function update($placaAntiga, $veiculo) {
			$result = array();

			try {
				$query = "UPDATE veiculos SET " .
								 "placa = '".$veiculo->getPlaca()."', " .
								 "marca = '".$veiculo->getMarca()."', " .
								 "modelo = '".$veiculo->getModelo()."', " .
								 "obs = '".$veiculo->getObs()."' " .
								 "WHERE placa = '".$placaAntiga."'";

				$con = new Connection();

				$status = Connection::getInstance()->prepare($query);

				if($status->execute()){
					$result[] = $veiculo;
				}else {
					$result["err"] = "Falha ao atualizar";
				}

				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}

			return $result;
		}

		function delete($placa) {
			$result = array();

			try {
				$query = "DELETE FROM veiculos WHERE placa = '$placa'";
				
				$con = new Connection();

				if(Connection::getInstance()->exec($query) >= 1){
					$result["msg"] = "Veiculo excluido com sucesso";
				}else {
					$result["err"] = "Falha ao excluir o veiculo";
				}

				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}

			return $result;
		}
	}
