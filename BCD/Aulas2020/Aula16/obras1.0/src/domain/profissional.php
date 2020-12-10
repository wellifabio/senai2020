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
			$cpf = $profissional->getCpf();
			$nome = $profissional->getNome();
			$funcao = $profissional->getFuncao();
			$val = $profissional->getValorHora();
			$foto = $profissional->getFoto();
			$query = "INSERT INTO profissionais(cpf, nome, funcao_principal, valor_hora_servico, foto) VALUES ";
			$query .= "('$cpf','$nome','$funcao','$val','$foto')";
			try {
				$con = new Connection();
				if(Connection::getInstance()->exec($query) >= 1){
					$result = $profissional;
				}else{
					$result["err"] = "Não foi possível cadastrar, verifique se este CPF já está registrado.";
				}
				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}
			return $result;
		}

		function read($cpf) {
			$result = array();
			if($cpf=="0"){
				$query = "SELECT * FROM profissionais";
			} else {
				$query = "SELECT * FROM profissionais WHERE cpf = '$cpf'";
			}
			try {
				$con = new Connection();
				$resultSet = Connection::getInstance()->query($query);
				while($row = $resultSet->fetchObject()){
					$profi = new Profissional();
					$profi->setCpf($row->cpf);
					$profi->setNome($row->nome);
					$profi->setFuncao($row->funcao_principal);
					$profi->setValorHora($row->valor_hora_servico);
					$profi->setFoto($row->foto);
					$result[] = $profi;
				}
				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}
			return $result;
		}

		function update($profissional) {
			$result = array();
			$cpf = $profissional->getCpf();
			$nome = $profissional->getNome();
			$funcao = $profissional->getFuncao();
			$val = $profissional->getValorHora();
			$foto = $profissional->getFoto();
			$query = "UPDATE profissionais SET nome = '$nome', funcao_principal = '$funcao',";
			$query .= "valor_hora_servico = $val, foto = '$foto'";
			$query .= "WHERE cpf = '$cpf'";
			try {
				$con = new Connection();
				$status = Connection::getInstance()->prepare($query);
				if($status->execute()){
					$result = $profissional;
				} else {
					$result["err"] = "Não foi possível alterar dados no BD";
				}
				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}
			return $result;
		}

		function delete($cpf) {
			$result = array();
			$query = "DELETE FROM profissionais WHERE cpf = '$cpf'";
			try {
				$con = new Connection();
				if(Connection::getInstance()->exec($query) >= 1){
					$result["suss"] = "profissional cpf = $cpf excluído com sucesso";
				}else{
					$result["err"] = "Não foi possível excluir este profissional, ou cpf não encontrado.";
				}
				$con = null;
			}catch(PDOException $e) {
				$result["err"] = $e->getMessage();
			}
			return $result;
		}
	}
