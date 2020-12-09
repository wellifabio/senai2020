<?php

	require("../../domain/connection.php");
	require("../../domain/Os.php");

	class OsProcess {
		var $od;

		function doGet($arr){
			$od = new OsDAO();
			$sucess = "use to result to DAO";
			http_response_code(200);
			echo json_encode($sucess);
		}


		function doPost($arr){
			$od = new OsDAO();
			$sucess = "use to result to DAO";
			http_response_code(200);
			echo json_encode($sucess);
		}


		function doPut($arr){
			$od = new OsDAO();
			$sucess = "use to result to DAO";
			http_response_code(200);
			echo json_encode($sucess);
		}


		function doDelete($arr){
			$od = new OsDAO();
			$sucess = "use to result to DAO";
			http_response_code(200);
			echo json_encode($sucess);
		}
	}