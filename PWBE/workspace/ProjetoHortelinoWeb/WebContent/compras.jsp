<%@page import="controllers.ProcessaCompra"%>
<%@page import="models.Compra"%>
<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF8">
<link rel="shortcut icon" href="./estilo/icone.png">
<link rel="stylesheet" type="text/css" href="./estilo/estilo.css" />
<title>Relatório de Compras</title>
</head>
<body>
	<div class="tableResult">
		<table>
			<thead>
				<th>Num</th>
				<th>Data</th>
				<th>Hora</th>
				<th>Produto</th>
				<th>Quantidade</th>
				<th>Subtotal</th>
			</thead>
			<tbody>
				<%
					if (request.getParameter("data") != null) {
					String data = request.getParameter("data");
					if (data.isEmpty()) {

						for (Compra c : ProcessaCompra.getCompras()) {
					out.print("<tr>");
					out.print("<td>" + c.getNum() + "</td>");
					out.print("<td>" + c.getData() + "</td>");
					out.print("<td>" + c.getHora() + "</td>");
					out.print("<td>" + c.getProduto().getPreco() + "</td>");
					out.print("<td>" + c.getQuantidade() + "</td>");
					out.print("<td>" + String.format("%.2f", c.getSubtotal()) + "</td>");
					out.print("</tr>");
						}
						out.print("<tfoot><tr>");
						out.print("<th colspan='2'>Total de Ítens</th><td>" + ProcessaCompra.getTotalItens() + "</td>");
						out.print("<th colspan='2'>Total em Dinheiro</th><td>"
						+ String.format("%.2f", ProcessaCompra.getTotalDinheiro()) + "</td>");
						out.print("</tr></tfoot>");

					} else {
						for (Compra c : ProcessaCompra.getCompras()) {
					if (data.equals(c.getData())) {
						out.print("<tr>");
						out.print("<td>" + c.getNum() + "</td>");
						out.print("<td>" + c.getData() + "</td>");
						out.print("<td>" + c.getHora() + "</td>");
						out.print("<td>" + c.getProduto().getPreco() + "</td>");
						out.print("<td>" + c.getQuantidade() + "</td>");
						out.print("<td>" + String.format("%.2f", c.getSubtotal()) + "</td>");
						out.print("</tr>");
					}
						}
						out.print("<tfoot><tr>");
						out.print("<th colspan='2'>Total de Ítens</th><td>" + ProcessaCompra.getTotalItens(data) + "</td>");
						out.print("<th colspan='2'>Total em Dinheiro</th><td>"
						+ String.format("%.2f", ProcessaCompra.getTotalDinheiro(data)) + "</td>");
						out.print("</tr></tfoot>");
					}
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>