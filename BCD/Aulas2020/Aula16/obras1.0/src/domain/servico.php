<?php

	class Servico {
		var $id;
		var $nome;
		var $descricao;
		var $local;
		var $tempoEstimado;
		var $antes;
		var $depois;

		function getId(){
			return $this->id;
		}
		function setId($id){
			$this->id = $id;
		}

		function getNome(){
			return $this->nome;
		}
		function setNome($nome){
			$this->nome = $nome;
		}

		function getDescricao(){
			return $this->descricao;
		}
		function setDescricao($descricao){
			$this->descricao = $descricao;
		}

		function getLocal(){
			return $this->local;
		}
		function setLocal($local){
			$this->local = $local;
		}

		function getTempoEstimado(){
			return $this->tempoEstimado;
		}
		function setTempoEstimado($tempoEstimado){
			$this->tempoEstimado = $tempoEstimado;
		}

		function getAntes(){
			return $this->antes;
		}
		function setAntes($antes){
			$this->antes = $antes;
		}

		function getDepois(){
			return $this->depois;
		}
		function setDepois($depois){
			$this->depois = $depois;
		}
	}

	class ServicoDAO {
		function create($servico) {
			$result = array();
			$nome = $servico->getNome();
			$descricao = $servico->getDescricao();
			$local = $servico->getLocal();
			$tempoEstimado = $servico->getTempoEstimado();
			$antes = $servico->getAntes();
			$depois = $servico->getDepois();
			try {
				$query = "INSERT INTO servicos (nome_obra, descricao, localizacao, tempo_estimado_horas, img_antes, img_depois)";
				$query .= "VALUES ('$nome', '$descricao','$local','$tempoEstimado','$antes','$depois')";
				$con = new Connection();
				if(Connection::getInstance()->exec($query) >= 1){
					$servico->setId(Connection::getInstance()->lastInsertId());
					$result = $servico;
				}
				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}

			return $result;
		}

		function read($id) {
			$result = array();
			try {
				if($id != "0"){
					$query = "SELECT * FROM servicos WHERE id_servico = $id";
				} else {
					$query = "SELECT * FROM servicos";
				}
				$con = new Connection();
				$resultSet = Connection::getInstance()->query($query);
				while($row = $resultSet->fetchObject()){
					$servico = new Servico();
					$servico->setId($row->id_servico);
					$servico->setNome(utf8_decode($row->nome_obra));
					$servico->setDescricao(utf8_decode($row->descricao));
					$servico->setLocal(utf8_decode($row->localizacao));
					$servico->setTempoEstimado($row->tempo_estimado_horas);
					$servico->setAntes($row->img_antes);
					$servico->setDepois($row->img_depois);
					$result[] = $servico;
				}
				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}

			return $result;
		}
		
		function readFinished() {
			$result = array();
			try {
				$query = "SELECT * FROM vw_servicos_concluidos";
				$con = new Connection();
				$resultSet = Connection::getInstance()->query($query);
				while($row = $resultSet->fetchObject()){
					$servicoc = array();
					$servicoc["id"] = $row->id_servico;
					$servicoc["nome"] = utf8_decode($row->nome_obra);
					$servicoc["descricao"] = utf8_decode($row->descricao);
					$servicoc["local"] = utf8_decode($row->localizacao);
					$servicoc["tempoHoras"] = $row->tempo_total_horas;
					$servicoc["profissional"] = utf8_decode($row->nome);
					$servicoc["funcao"] = utf8_decode($row->funcao_principal);
					$servicoc["custo"] = utf8_decode($row->custo_do_servico);
					$servicoc["antes"] = utf8_decode($row->img_antes);
					$servicoc["depois"] = utf8_decode($row->img_depois);
					$servicoc["imgProf"] = utf8_decode($row->foto);
					$servicoc["dataConclusao"] = utf8_decode($row->data_conclusao);
					$result[] = $servicoc;
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
