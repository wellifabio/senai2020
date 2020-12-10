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
			$nome = utf8_decode($servico->getNome());
			$descricao = utf8_decode($servico->getDescricao());
			$local = utf8_decode($servico->getLocal());
			$tempoEstimado = $servico->getTempoEstimado();
			$antes = $servico->getAntes();
			$depois = $servico->getDepois();
			$query = "INSERT INTO servicos (nome_obra, descricao, localizacao, tempo_estimado_horas, img_antes, img_depois)";
			$query .= "VALUES ('$nome', '$descricao','$local','$tempoEstimado','$antes','$depois')";
			try {
				$con = new Connection();
				if(Connection::getInstance()->exec($query) >= 1){
					$servico->setId(Connection::getInstance()->lastInsertId());
					$result = $servico;
				}else{
					$result["err"] = "Não foi possível enviar dados ao BD";	
				}
				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}
			return $result;
		}

		function read($id) {
			$result = array();
			if($id != "0"){
				$query = "SELECT * FROM servicos WHERE id_servico = $id";
			} else {
				$query = "SELECT * FROM servicos";
			}
			try {
				$con = new Connection();
				$resultSet = Connection::getInstance()->query($query);
				while($row = $resultSet->fetchObject()){
					$servico = new Servico();
					$servico->setId($row->id_servico);
					$servico->setNome(utf8_encode($row->nome_obra));
					$servico->setDescricao(utf8_encode($row->descricao));
					$servico->setLocal(utf8_encode($row->localizacao));
					$servico->setTempoEstimado($row->tempo_estimado_horas);
					$servico->setAntes($row->img_antes);
					$servico->setDepois($row->img_depois);
					$result[] = $servico;
				}
				$con = null;
			}catch(PDOException $e) {
				$result["err"] = "Erro ao conectar com o SGBD";
				$result["err"] = $e->getMessage();
			}
			return $result;
		}
		
		function readFinished() {
			$result = array();
			$query = "SELECT * FROM vw_servicos_concluidos";
			try {
				$con = new Connection();
				$resultSet = Connection::getInstance()->query($query);
				while($row = $resultSet->fetchObject()){
					$servicoc = array();
					$servicoc["id"] = $row->id_servico;
					$servicoc["nome"] = utf8_encode($row->nome_obra);
					$servicoc["descricao"] = utf8_encode($row->descricao);
					$servicoc["local"] = utf8_encode($row->localizacao);
					$servicoc["tempoHoras"] = $row->tempo_total_horas;
					$servicoc["profissional"] = utf8_encode($row->nome);
					$servicoc["funcao"] = utf8_encode($row->funcao_principal);
					$servicoc["custo"] = utf8_encode($row->custo_do_servico);
					$servicoc["antes"] = utf8_encode($row->img_antes);
					$servicoc["depois"] = utf8_encode($row->img_depois);
					$servicoc["imgProf"] = utf8_encode($row->foto);
					$servicoc["dataConclusao"] = utf8_encode($row->data_conclusao);
					$result[] = $servicoc;
				}
				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}

			return $result;
		}		

		function update($servico) {
			$result = array();
			$id = $servico->getId();
			$nome = utf8_decode($servico->getNome());
			$descricao = utf8_decode($servico->getDescricao());
			$local = utf8_decode($servico->getLocal());
			$tempoEstimado = $servico->getTempoEstimado();
			$antes = $servico->getAntes();
			$depois = $servico->getDepois();
			$query = "UPDATE servicos SET nome_obra = '$nome', descricao = '$descricao', localizacao = '$local',";
			$query .= "tempo_estimado_horas = '$tempoEstimado', img_antes = '$antes', img_depois = '$depois'";
			$query .= "WHERE id_servico = $id";
			try {
				$con = new Connection();
				$status = Connection::getInstance()->prepare($query);
				if($status->execute()){
					$result = $servico;
				} else {
					$result["err"] = "Não foi possível alterar dados no BD";
				}
				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}
			return $result;
		}

		function delete($id) {
			$result = array();
			$query = "DELETE FROM servicos WHERE id_servico=$id";
			try {
				$con = new Connection();
				if(Connection::getInstance()->exec($query) >= 1){
					$result["suss"] = "Registro id = $id excluído com sucesso";
				} else {
					$result["err"] = "Não foi possível excluir dados no BD";
				}
				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}

			return $result;
		}
	}
