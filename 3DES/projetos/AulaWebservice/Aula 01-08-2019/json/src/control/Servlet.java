package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		out.println("{\"nome\":\"Fulano\",\"RA\":30}");
		
		/*ConnectionDB con = new ConnectionDB();
		
		String query = "SELECT * FROM aluno";
		
		try {
			PreparedStatement ps = con.getConnection().prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("Nome - " + rs.getString(1));
				System.out.println("RA - " + rs.getString(2));
			}
			ps.close();
			rs.close();
			con.getConnection().close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//out.println("Bem vindo ao Servlet");
	}

}
