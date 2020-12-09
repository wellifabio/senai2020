<?php

	class Profissional {
		var $cpf;
		var $nome;
		var $funcao;
		var $valorHora;
		var $foto;

		function getCpf(){
			return $this->cpf;
		}
		function setCpf($cpf){
			$this->cpf = $cpf;
		}

		function getNome(){
			return $this->nome;
		}
		function setNome($nome){
			$this->nome = $nome;
		}

		function getFuncao(){
			return $this->funcao;
		}
		function setFuncao($funcao){
			$this->funcao = $funcao;
		}

		function getValorHora(){
			return $this->valorHora;
		}
		function setValorHora($valorHora){
			$this->valorHora = $valorHora;
		}

		function getFoto(){
			return $this->foto;
		}
		function setFoto($foto){
			$this->foto = $foto;
		}
	}

	class ProfissionalDAO {
		function create($profissional) {
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
