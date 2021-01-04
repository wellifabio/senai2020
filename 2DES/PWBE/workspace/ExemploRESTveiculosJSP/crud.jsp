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
		<thead>
			<tr>
				<td>Placa</td>
				<td>Marca</td>
				<td>Modelo</td>
				<td>Ano</td>
				<td>Km</td>
			</tr>
		</thead>
		<tbody>
			<%
				//Cabeçalho
			Veiculo veiculo;
			VeiculoDAO vd = new VeiculoDAO();
			ArrayList<Veiculo> veiculos = vd.open();

			//Verifica e preenche os atributos caso hara requisição no objeto request
			String placa = request.getParameter("placa");
			String marca = request.getParameter("marca");
			String modelo = request.getParameter("modelo");
			int ano = 0;
			float km = 0;
			if (request.getParameter("ano") != null) {
				ano = Integer.parseInt(request.getParameter("ano"));
			}
			if (request.getParameter("km") != null) {
				km = Float.parseFloat(request.getParameter("km"));
			}

			//CRUD São as 4 funcionalidades básicas de uma página dinâmica
			//(CREATE e UPDATE) Cadastro
			if (placa != null && marca != null && modelo != null && ano != 0 && km != 0) {
				veiculo = new Veiculo();
				veiculo.setPlaca(placa);
				veiculo.setMarca(marca);
				veiculo.setModelo(modelo);
				veiculo.setAno(ano);
				veiculo.setKm(km);
				if(veiculos.contains(veiculo)){
					veiculos.set(veiculos.indexOf(veiculo),veiculo);
				} else {
					veiculos.add(veiculo);
				}
				vd.save(veiculos);
			}

			//(READ)
			for (Veiculo v : veiculos) {
				out.print("<form method='GET'>");
				out.print("<input type='hidden' name='delete' value='"+v.getPlaca()+"'>");
				out.print("<tr>"+v.toHtmlTr()+"<td><input type='submit' value='-'/></td></tr>");
				out.print("</form>");
			}
			//(DELETE)
			if (request.getParameter("delete")!=null){
				String delete = request.getParameter("delete");
				veiculo = new Veiculo();
				veiculo.setPlaca(delete);
				if(veiculos.contains(veiculo)){
					veiculos.remove(veiculos.indexOf(veiculo));
				}
				vd.save(veiculos);
				response.sendRedirect("./");
			}
			%>
			
		</tbody>
	</table>
</body>
</html>