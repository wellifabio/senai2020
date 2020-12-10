<?php

	header("Content-type: application/json; charset=utf-8");
	header("Access-Control-Allow-Origin: http://localhost/");
	header("Access-Control-Allow-Methods: GET, PUT, POST, DELETE");

	$_PUT = array();
	if (!strcasecmp($_SERVER['REQUEST_METHOD'], 'PUT')) {
		parse_str(file_get_contents('php://input'), $_PUT);
	}

	$_DELETE = array();
	if (!strcasecmp($_SERVER['REQUEST_METHOD'], 'DELETE')) {
		parse_str(file_get_contents('php://input'), $_DELETE);
	}

/*UTF-8 é uma codificação multibyte que pode representar qualquer caractere Unicode.
**ISO 8859-1 é uma codificação de byte único que pode representar os primeiros 256 caracteres Unicode.
**Ambos codificam ASCII exatamente da mesma maneira*/
//echo mb_detect_encoding($servico->getDescricao(),'UTF-8,ISO-8859-1');
//echo utf8_decode("UTF-8, para ISO-8859-1");
//echo utf8_encode("ISO-8859-1, para UTF-8");