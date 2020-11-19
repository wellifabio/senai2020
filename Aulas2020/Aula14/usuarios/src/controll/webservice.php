<?php

    require("../domain/usuario.php");
	$ud = new UsuarioDAO();
	
	header("Access-Control-Allow-Origin:*");
	header('Access-Control-Allow-Methods: GET, PUT, POST, DELETE, OPTIONS');
	header('Access-Control-Max-Age: 1000');
	header('Access-Control-Allow-Headers: Content-Type, Authorization, X-Requested-With');
	header("Content-type: application/json; charset=UTF-8");

	$method = $_SERVER['REQUEST_METHOD'];
	switch($method) {
        case 'GET' :
			echo '{"msg":"Chegou por GET"}';
            break;
        case 'POST' :
			$postdata = file_get_contents("php://input");
			$request = json_decode($postdata);
			if(isset($request->login)&&isset($request->senha)){
				$login = $request->login;
				$senha = $request->senha;
				$status = $ud->login($login,$senha);
				echo json_encode($status);
			}
            break;
        case 'PUT' :
			echo '{"msg":"Chegou por PUT"}';
            break;
        case 'DELETE' :
			echo '{"msg":"Chegou por DELETE"}';
            break;
        default:
			echo '{"msg":"Chegou por OTHER"}';
            http_response_code(405);
            break;
    }

?>