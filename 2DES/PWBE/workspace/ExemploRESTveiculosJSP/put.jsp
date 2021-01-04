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
			Veiculo veiculo;  //Cria um onjeto veículo
			VeiculoDAO vd = new VeiculoDAO(); //cria um objeto DAO
			ArrayList<Veiculo> veiculos = vd.open(); //Cria uma lista com todos os dados do arquivo

			//Verifica e preenche os atributos caso hara requisição no objeto request
			String placa = request.getParameter("placa");
			String marca = request.getParameter("marca");
			String modelo = request.getParameter("modelo");
			int ano = 0;
			float km = 0;
			if (request.getParameter("ano") != null) { //Verifica antes de converter
				ano = Integer.parseInt(request.getParameter("ano"));
			}
			if (request.getParameter("km") != null) { //Verifica antes de converter
				km = Float.parseFloat(request.getParameter("km"));
			}

			//Valida se todos os campos foram preenchidos e executa o UPDATE (Atualização)
			if (placa != null && marca != null && modelo != null && ano != 0 && km != 0) {
				veiculo = new Veiculo();
				veiculo.setPlaca(placa);
				veiculo.setMarca(marca);
				veiculo.setModelo(modelo);
				veiculo.setAno(ano);
				veiculo.setKm(km);
				if (veiculos.contains(veiculo)) {
					//Faz a alteração da lista local
					veiculos.set(veiculos.indexOf(veiculo), veiculo);
				} else {
					out.print("Veículo não encontrado.");
				}
				vd.save(veiculos); //Utiliza o método save do obj DAO para enviar a lista atualizada
			} else {
				out.print("Aguardando dados para alteração.");
			}
			%>

		</tbody>
	</table>
</body>
</html>