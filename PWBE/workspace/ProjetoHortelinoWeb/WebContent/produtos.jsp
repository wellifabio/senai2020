<%@page import="controllers.ProcessaProduto"%>
<%@page import="models.Produto"%>
<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF8">
<link rel="shortcut icon" href="./estilo/icone.png">
<link rel="stylesheet" type="text/css" href="./estilo/estilo.css" />
<title>Relatório de Produtos</title>
</head>
<body>
	<div class="tableResult">
		<table>
			<thead>
				<th>Código</th>
				<th>Nome</th>
				<th>Descricao</th>
				<th>Preço</th>
				<th>Quantidade</th>
				<th>Subtotal</th>
			</thead>
			<tbody>
				<%
					for (Produto p: ProcessaProduto.getProdutos()) {
					out.print("<tr>");
					out.print("<td>" + p.getCodigo() + "</td>");
					out.print("<td>" + p.getNome() + "</td>");
					out.print("<td>" + p.getDescricao() + "</td>");
					out.print("<td>" + p.getPreco() + "</td>");
					out.print("<td>" + p.getQuantidade() + "</td>");
					out.print("<td>" + String.format("%.2f",p.getSubtotal()) + "</td>");
					out.print("</tr>");
				}
				out.print("<tfoot><tr>");
				out.print("<th colspan='2'>Total de Ítens</th><td>" + ProcessaProduto.getTotalItens() + "</td>");
				out.print("<th colspan='2'>Total em Dinheiro</th><td>" + String.format("%.2f",ProcessaProduto.getTotalDinheiro()) + "</td>");
				out.print("</tr></tfoot>");
				%>
			</tbody>
		</table>
	</div>
</body>
</html>