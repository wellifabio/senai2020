<?php

	require("../../domain/connection.php");
	require("../../domain/Profissional.php");

	class ProfissionalProcess {
		var $pd;

		function doGet($arr){
			$pd = new ProfissionalDAO();
			$sucess = "use to result to DAO";
			http_response_code(200);
			echo json_encode($sucess);
		}


		function doPost($arr){
			$pd = new ProfissionalDAO();
			$sucess = "use to result to DAO";
			http_response_code(200);
			echo json_encode($sucess);
		}


		function doPut($arr){
			$pd = new ProfissionalDAO();
			$sucess = "use to result to DAO";
			http_response_code(200);
			echo json_encode($sucess);
		}


		function doDelete($arr){
			$pd = new ProfissionalDAO();
			$sucess = "use to result to DAO";
			http_response_code(200);
			echo json_encode($sucess);
		}
	}