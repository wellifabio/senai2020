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
	<%
		//Cabeçalho
	Veiculo veiculo; //Cria um onjeto veículo
	VeiculoDAO vd = new VeiculoDAO(); //cria um objeto DAO
	ArrayList<Veiculo> veiculos = vd.open(); //Cria uma lista com todos os dados do arquivo

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

	//Valida se todos os campos foram preenchidos e executa o (CREATE)
	if (placa != null && marca != null && modelo != null && ano != 0 && km != 0) {
		veiculo = new Veiculo();
		veiculo.setPlaca(placa);
		veiculo.setMarca(marca);
		veiculo.setModelo(modelo);
		veiculo.setAno(ano);
		veiculo.setKm(km);
		if (veiculos.contains(veiculo)) {
			//Se o veículo já estiver cadastrado informa
			out.print("Este veículo já está cadastrado");
		} else {
			veiculos.add(veiculo);
			out.print("Veículo cadastrado com sucesso.");
		}
		vd.save(veiculos);
	} else {
		out.print("Aguardando dados para cadastro.");
	}
	%>
</body>
</html>