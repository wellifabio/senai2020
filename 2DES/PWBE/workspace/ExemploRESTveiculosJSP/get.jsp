<%@page import="java.util.ArrayList"%>
<%@page import="model.Veiculo"%>
<%@page import="model.dao.VeiculoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF8">
<title>Veiculos</title>
</head>
<body>
	<table>
		<tbody>
			<%
				//Cabeçalho
			VeiculoDAO vd = new VeiculoDAO();
			
			//(READ) utiliza for each para percorrer a lista obtida da classe DAO 
			for (Veiculo v : vd.open()) {
				out.print("<tr>" + v.toHtmlTr() + "</tr>");
			}
			%>
			
		</tbody>
	</table>
</body>
</html>