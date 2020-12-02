<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF8">
<link rel="shortcut icon" href="./estilo/icone.png">
<link rel="stylesheet" type="text/css" href="./estilo/estilo.css" />
<title>Hortelino Compras</title>
</head>
<body>
	<div>
		<p class="titulo">Bem vindo ao Hortelino Web, verifique seus relatórios</p>
	</div>
	<div class="mainForm">
		<form action="produtos.jsp">
			<input type="submit" value="Relatório de Produtos">
		</form>
		<form action="compras.jsp">
			<input type="text" name="data" placeholder="Preencha a data dd/mm/aaaa">
			<input type="submit" value="Relatório de Compras">
		</form>
	</div>
</body>
</html>