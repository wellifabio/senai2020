package controll;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.ReceitaDAO;
import model.Receita;

@MultipartConfig(maxFileSize = 16177215)
@WebServlet("/procreceitas")
public class ProcessaReceitas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Receita r;
	private ReceitaDAO rd = new ReceitaDAO();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Processa o recebimento da imagen
		Part file = req.getPart("foto");
		String fileName = file.getSubmittedFileName();
		
		String acao = req.getParameter("action");
		
		if (acao == null) {
			Mensagem.addMensagem("Nenhuma a��o enviada");
			resp.sendRedirect("receitas.jsp");
		} else {
			switch (acao) {
			case "create":
				r = new Receita();
				r.setNome(req.getParameter("nome").toString());
				r.setIngredientes(req.getParameter("ingredientes").toString());
				r.setModoDeFazer(req.getParameter("modo_de_fazer").toString());
				// Processa a imagen
				if (!fileName.isEmpty()) {
					InputStream is = file.getInputStream();
					r.setFoto(is);
				}
				try {
					if (rd.create(r)) {
						Mensagem.addMensagem("Receita e imagem enviadas com sucesso!");
					} else
						Mensagem.addMensagem("Erro ao enviar receita!");
				} catch (SQLException e) {
					Mensagem.addMensagem("Erro: " + e);
				}
				resp.sendRedirect("receitas.jsp");
				break;
			case "update":
				r = new Receita();
				r.setId(Integer.parseInt(req.getParameter("id").toString()));
				r.setNome(req.getParameter("nome").toString());
				r.setIngredientes(req.getParameter("ingredientes").toString());
				r.setModoDeFazer(req.getParameter("modo_de_fazer").toString());
				try {
					//Processa a imagem
					if (!fileName.isEmpty()) {
						InputStream is = file.getInputStream();
						r.setFoto(is);
					}
					if (rd.update(r))
						Mensagem.addMensagem("Receita e imagem atualizadas com sucesso!");
					else
						Mensagem.addMensagem("Erro ao processar altera��o!");
				} catch (SQLException e) {
					Mensagem.addMensagem("Erro: " + e);
				}
				resp.sendRedirect("receitas.jsp");
				break;
			case "delete":
				int id = Integer.parseInt(req.getParameter("id").toString());
				try {
					if (rd.delete(id))
						Mensagem.addMensagem("Receita excluida com sucesso!");
					else
						Mensagem.addMensagem("Erro ao processar exclus�o!");
				} catch (SQLException e) {
					Mensagem.addMensagem("Erro: " + e);
				}
				resp.sendRedirect("receitas.jsp");
				break;
			default:
				Mensagem.addMensagem("A��o inv�lida");
				resp.sendRedirect("receitas.jsp");
				break;
			}
		}
	}
}
