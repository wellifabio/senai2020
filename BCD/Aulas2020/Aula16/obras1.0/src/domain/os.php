<?php

	class Os {
		var $num_os;
		var $id_servico;
		var $profissional;
		var $dataInicio;
		var $dataConclusao;
		var $tempoTotal;

		function getNum_os(){
			return $this->num_os;
		}
		function setNum_os($num_os){
			$this->num_os = $num_os;
		}

		function getId_servico(){
			return $this->id_servico;
		}
		function setId_servico($id_servico){
			$this->id_servico = $id_servico;
		}

		function getProfissional(){
			return $this->profissional;
		}
		function setProfissional($profissional){
			$this->profissional = $profissional;
		}

		function getDataInicio(){
			return $this->dataInicio;
		}
		function setDataInicio($dataInicio){
			$this->dataInicio = $dataInicio;
		}

		function getDataConclusao(){
			return $this->dataConclusao;
		}
		function setDataConclusao($dataConclusao){
			$this->dataConclusao = $dataConclusao;
		}

		function getTempoTotal(){
			return $this->tempoTotal;
		}
		function setTempoTotal($tempoTotal){
			$this->tempoTotal = $tempoTotal;
		}
	}

	class OsDAO {
		function create($os) {
			$result = array();

			try {
				$query = "INSERT INTO table_name (column1, column2) VALUES (value1, value2)";

				$con = new Connection();

				if(Connection::getInstance()->exec($query) >= 1){
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
				$query = "SELECT column1, column2 FROM table_name WHERE condition";

				$con = new Connection();

				$resultSet = Connection::getInstance()->query($query);

				while($row = $resultSet->fetchObject()){
				}

				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}

			return $result;
		}

		function update() {
			$result = array();

			try {
				$query = "UPDATE table_name SET column1 = value1, column2 = value2 WHERE condition";

				$con = new Connection();

				$status = Connection::getInstance()->prepare($query);

				if($status->execute()){
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
