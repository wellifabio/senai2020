<?php
	require("conexao.php");
	class Pessoa{
		//Atributos
		var $idPessoa;
		var $nome;
		var $telefone;
		
		//Métodos GETs && SETs
		function getIdPessoa(){
			return $this->idPessoa;
		}
		function setIdPessoa($idPessoa){
			$this->idPessoa = $idPessoa;
		}
		function getNome(){
			return $this->nome;
		}
		function setNome($nome){
			$this->nome = $nome;
		}
		function getTelefone(){
			return $this->telefone;
		}
		function setTelefone($telefone){
			$this->telefone = $telefone;
		}
	}
	
	class PessoaDAO{
		
		function create(){
			$resultado = array();
            $query = "INSERT INTO pessoas VALUES (default,'".$pessoa->getNome()."')";
            try{
                $con = new Conexao();
                if(Conexao::getInstance()->exec($query) >= 1){
                    $resultado["id"] = Conexao::getInstance()->lastInsertId();
                    $resultado["nome"] = $pessoa->getNome();
                    if($pessoa->getTelefone()!=null){
                        $resultado["telefone"] = $pessoa->getTelefone();
                        $query = "INSERT INTO telefones VALUES (".$resultado["id"].",'".$resultado["telefone"]."')";
                        Conexao::getInstance()->exec($query);
                    }
                }
                $con = null;
            } catch (PDOException $e) {
                $resultado["erro"] = "Erro ao conectar ao BD";
            }
            return $resultado;
		}
		function readAll(){
			$pessoas = [];
			$query = "SELECT * FROM vw_pessoas";
			try{
				$con = new Conexao();
				$resultSet = Conexao::getInstancia()->query($query);
				while($linha = $resultSet->fetchObject()){
					$pessoa = new Pessoa();
					$pessoa->setIdPessoa($linha->id_pessoa);
					$pessoa->setNome($linha->nome);
					$pessoa->setTelefone($linha->telefone);
					$pessoas[] = $pessoa;
				}
				$con = null;
			}catch(PDOException $e){
				$pessoas["erro"] = "Erro de conexão com BD";
			}
			return $pessoas;
		}
		function update(){}
		function del(){}
	}