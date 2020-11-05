<?php
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