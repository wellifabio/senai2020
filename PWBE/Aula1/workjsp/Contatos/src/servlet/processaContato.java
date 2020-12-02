package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contatos;
import model.Contato;

@WebServlet("/servletContato")
public class processaContato extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PrintWriter out;
	private Contatos cs = new Contatos();
	private Contato c;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		out = resp.getWriter();
		c = new Contato();
		c.setNome(req.getParameter("nome"));
		c.setTelefone(req.getParameter("telefone"));
		cs.addContato(c);

		out.println("<table><tr><th>Nome</th><th>Telefone</th></tr>");
		for (Contato l : cs.getContatos()) {
			out.println("<tr><td>" + l.getNome() + "</td><td>" + l.getTelefone() + "</td></tr>");
		}
		out.println("</table>");
	}
}
