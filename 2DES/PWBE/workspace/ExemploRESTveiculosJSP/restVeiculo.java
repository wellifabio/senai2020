package controll;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Veiculo;
import model.dao.VeiculoDAO;

@WebServlet("/rest")
public class restVeiculo extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Veiculo veiculo;
	private VeiculoDAO vd = new VeiculoDAO();
	private ArrayList<Veiculo> veiculos = vd.open();
	private PrintWriter out;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		out = resp.getWriter();
		// Recebe os dados via request
		String placa = req.getParameter("placa");
		String marca = req.getParameter("marca");
		String modelo = req.getParameter("modelo");
		int ano = 0;
		float km = 0;
		if (req.getParameter("ano") != null) {
			ano = Integer.parseInt(req.getParameter("ano"));
		}
		if (req.getParameter("km") != null) {
			km = Float.parseFloat(req.getParameter("km"));
		}

		// (CREATE)
		if (placa != null && marca != null && modelo != null && ano != 0 && km != 0) {
			veiculo = new Veiculo();
			veiculo.setPlaca(placa);
			veiculo.setMarca(marca);
			veiculo.setModelo(modelo);
			veiculo.setAno(ano);
			veiculo.setKm(km);
			if (veiculos.contains(veiculo)) {
				// Se o veículo já estiver cadastrado informa
				out.print("Este veículo já está cadastrado");
			} else {
				veiculos.add(veiculo);
				out.print("Veículo cadastrado com sucesso.");
			}
			vd.save(veiculos);
		} else {
			out.print("Dados incompletos, verifique se algum campo não foi preenchido.");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		out = resp.getWriter();
		for (Veiculo v : veiculos) {
			out.print(v.toCSV().toString());
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		out = resp.getWriter();
		// Verifica e preenche os atributos caso hara requisição no objeto request
		String placa = req.getParameter("placa");
		String marca = req.getParameter("marca");
		String modelo = req.getParameter("modelo");
		int ano = 0;
		float km = 0;
		if (req.getParameter("ano") != null) { // Verifica antes de converter
			ano = Integer.parseInt(req.getParameter("ano"));
		}
		if (req.getParameter("km") != null) { // Verifica antes de converter
			km = Float.parseFloat(req.getParameter("km"));
		}

		// (UPDATE)
		if (placa != null && marca != null && modelo != null && ano != 0 && km != 0) {
			veiculo = new Veiculo();
			veiculo.setPlaca(placa);
			veiculo.setMarca(marca);
			veiculo.setModelo(modelo);
			veiculo.setAno(ano);
			veiculo.setKm(km);
			if (veiculos.contains(veiculo)) {
				// Faz a alteração da lista local
				veiculos.set(veiculos.indexOf(veiculo), veiculo);
				out.print("Veículo atualizado com sucesso.");
			} else {
				out.print("Veículo não encontrado.");
			}
			vd.save(veiculos); // Utiliza o método save do obj DAO para enviar a lista atualizada
		}else {
			out.print("Dados incompletos, verifique se algum campo não foi preenchido.");
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		out = resp.getWriter();
		//(DELETE)
		if (req.getParameter("placa")!=null){
			String placa = req.getParameter("placa");
			veiculo = new Veiculo();
			veiculo.setPlaca(placa);
			if(veiculos.contains(veiculo)){
				//Se a lista local contiver um veículo com a placa informada, é removido
				veiculos.remove(veiculos.indexOf(veiculo));
				//O método save do objeto DAO salva a nova lista
				if(vd.save(veiculos)){
					out.print("Veículo removido com sucesso.");
				}
			}else{
				out.print("Veículo não encontrado no cadastro.");
			}
		}else {
			out.print("Dados incompletos, é necessário preencher a placa.");
		}
	}
}
