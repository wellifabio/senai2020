<?php

	class Os {
		var $numOs;
		var $idServico;
		var $profissional;
		var $dataInicio;
		var $dataConclusao;
		var $tempoTotal;

		function getNumOs(){
			return $this->numOs;
		}
		function setNumOs($numOs){
			$this->numOs = $numOs;
		}

		function getIdServico(){
			return $this->idServico;
		}
		function setIdServico($idServico){
			$this->idServico = $idServico;
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
			$idSer = $os->getIdServico();
			$profi = $os->getProfissional();
			if($os->getDataInicio() != null){
				$dataI = $os->getDataInicio();
				$query = "INSERT INTO ordens_de_servico(id_servico, profissional,data_inicio) VALUES";
				$query .= "($idSer, '$profi', '$dataI')";
			} else {
				$query = "INSERT INTO ordens_de_servico(id_servico, profissional,data_inicio) VALUES";
				$query .= "($idSer, '$profi', curdate())";
			}
			try {
				$con = new Connection();
				if(Connection::getInstance()->exec($query) >= 1){
					$result = $os;
				}else{
					$result["err"] = "Não foi possível cadastrar OS";
				}
				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}
			return $result;
		}

		function read($num) {
			$result = array();
			if($num != "0"){
				$query = "SELECT * FROM ordens_de_servico WHERE num_os = $num";
			} else {
				$query = "SELECT * FROM ordens_de_servico";
			}
			try {
				$con = new Connection();
				$resultSet = Connection::getInstance()->query($query);
				while($row = $resultSet->fetchObject()){
					$os = new Os();
					$os->setNumOs($row->num_os);
					$os->setIdServico($row->id_servico);
					$os->setProfissional($row->profissional);
					$os->setDataInicio($row->data_inicio);
					$os->setDataConclusao($row->data_conclusao);
					$os->setTempoTotal($row->tempo_total_horas);
					$result[] = $os;
				}
				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}
			return $result;
		}

		function update($os) {
			$result = array();
			$num = $os->getNumOs();
			$idSer = $os->getIdServico();
			$profi = $os->getProfissional();
			$dataI = $os->getDataInicio();
			$dataC = $os->getDataConclusao();
			$tempo = $os->getTempoTotal();
			$query = "UPDATE ordens_de_servico SET id_servico = $idSer, profissional = '$profi', data_inicio = '$dataI', data_conclusao = '$dataC', tempo_total_horas = $tempo WHERE num_os = $num";
			try {
				$con = new Connection();
				$status = Connection::getInstance()->prepare($query);
				if($status->execute()){
					$result = $os;
				}else{
					$result["err"] = "Não foi possível alterar OS";
				}
				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}
			return $result;
		}

		function darBaixaOs($os) {
			$result = array();
			$num = $os->getNumOs();
			$dataC = $os->getDataConclusao();
			$tempo = $os->getTempoTotal();
			if($os->getDataConclusao() != null){
				$dataC = $os->getDataConclusao();
				$query = "UPDATE ordens_de_servico SET data_conclusao = '$dataC', tempo_total_horas = $tempo WHERE num_os = $num";
			}else{
				$query = "UPDATE ordens_de_servico SET data_conclusao = curdate(), tempo_total_horas = $tempo WHERE num_os = $num";
			}
			try {
				$con = new Connection();
				$status = Connection::getInstance()->prepare($query);
				if($status->execute()){
					$result = $os;
				}else{
					$result["err"] = "Não foi possível alterar OS";
				}
				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}
			return $result;
		}

		function delete($num) {
			$result = array();
			$query = "DELETE FROM ordens_de_servico WHERE num_os = $num";
			try {
				$con = new Connection();
				if(Connection::getInstance()->exec($query) >= 1){
					$result["suss"] = "Ordem de serviço num = $num excluída com sucesso";
				}else{
					$result["err"] = "Não foi possível excluir esta ordem de serviço.";
				}
				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}
			return $result;
		}
	}
