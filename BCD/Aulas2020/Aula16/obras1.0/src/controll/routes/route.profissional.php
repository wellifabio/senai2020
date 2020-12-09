<?php

	require("../process/process.profissional.php");

	include("configs.php");

	$pp = new ProfissionalProcess();

	switch($_SERVER['REQUEST_METHOD']) {
		case "GET":
			$pp->doGet($_GET);
			break;

		case "POST":
			$pp->doPost($_POST);
			break;

		case "PUT":
			$pp->doPut($_PUT);
			break;

		case "DELETE":
			$pp->doDelete($_DELETE);
			break;
	}