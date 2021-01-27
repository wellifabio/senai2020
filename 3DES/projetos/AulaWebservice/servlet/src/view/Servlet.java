package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/server")
public class Servlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.service(req, resp);
		
		String nome = req.getParameter("name");
		String id = req.getParameter("id");
				
		PrintWriter out = resp.getWriter();
		
		JSONObject json = new JSONObject();
		json.put("id", id);
		json.put("name", nome);
		
		out.println(json.toString());
		
	}
	
}
