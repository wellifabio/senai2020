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

@WebServlet("/service")
public class serviceVeiculo extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private VeiculoDAO vd = new VeiculoDAO();
	private ArrayList<Veiculo> veiculos = vd.open();
	private PrintWriter out;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		out = resp.getWriter();
		for (Veiculo v : veiculos) {
			out.print(v.toHtmlTr());
		}
	}
}
