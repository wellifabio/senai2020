/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.24
 * Generated at: 2020-10-09 13:57:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import controllers.FuncionarioServlet;
import domains.Funcionario;

public final class funcionario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("domains.Funcionario");
    _jspx_imports_classes.add("controllers.FuncionarioServlet");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<title>Funcionários</title>\r\n");
      out.write("<style>\r\n");
      out.write("form {\r\n");
      out.write("\tdisplay: flex;\r\n");
      out.write("\tflex-direction: row;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("form input {\r\n");
      out.write("\tpadding: 10px;\r\n");
      out.write("\tborder-radius: 4px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("form input[type=text] {\r\n");
      out.write("\twidth: 130px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("form select {\r\n");
      out.write("\twidth: 160px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("form input[type=number] {\r\n");
      out.write("\twidth: 80px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("table {\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("table th {\r\n");
      out.write("\tborder: 1px solid #ccc;\r\n");
      out.write("\tborder-radius: 5px;\r\n");
      out.write("\tpadding: 10px;\r\n");
      out.write("\tmargin: 10px;\r\n");
      out.write("\tfont-family: Verdana, Geneva, Tahoma, sans-serif;\r\n");
      out.write("\tfont-size: 14px;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tbackground-color: #eee;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("table td {\r\n");
      out.write("\tborder: 1px solid #ccc;\r\n");
      out.write("\tborder-radius: 5px;\r\n");
      out.write("\tpadding: 10px;\r\n");
      out.write("\tmargin: 10px;\r\n");
      out.write("\tfont-family: Verdana, Geneva, Tahoma, sans-serif;\r\n");
      out.write("\tfont-size: 14px;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".msg {\r\n");
      out.write("\tborder: 1px solid #ccc;\r\n");
      out.write("\tborder-radius: 5px;\r\n");
      out.write("\twidth: 1050px;\r\n");
      out.write("\tpadding: 10px;\r\n");
      out.write("\tmargin: 10px;\r\n");
      out.write("\tfont-family: Verdana, Geneva, Tahoma, sans-serif;\r\n");
      out.write("\tfont-size: 14px;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<form method=\"POST\" action=\"funcionarios\">\r\n");
      out.write("\t\t<input type=\"text\" name=\"nome\" placeholder=\"Nome\" /> <input\r\n");
      out.write("\t\t\ttype=\"text\" onfocus=\"(this.type='date')\" name=\"nascimento\" placeholder=\"Nascimento\" />\r\n");
      out.write("\t\t<input type=\"text\" name=\"endereco\" placeholder=\"Endereço\" /> <input\r\n");
      out.write("\t\t\ttype=\"text\" name=\"especialidade\" placeholder=\"Especialidade\" /> <input\r\n");
      out.write("\t\t\ttype=\"text\" name=\"competencias\"\r\n");
      out.write("\t\t\tplaceholder=\"Competências separadas por vírcula,\" /> <select\r\n");
      out.write("\t\t\tname=\"periodo\"><option>Escolha o período</option>\r\n");
      out.write("\t\t\t<option>Manhã</option>\r\n");
      out.write("\t\t\t<option>Tarde</option>\r\n");
      out.write("\t\t\t<option>Noite</option></select> <input type=\"number\" name=\"valorHora\"\r\n");
      out.write("\t\t\tplaceholder=\"Valor Hora\" /> <input type=\"submit\" value=\"Enviar\">\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<div class=\"msg\">\r\n");
      out.write("\t\t");

			//Mensagens do sistema
		if (request.getParameter("mensagem") != null) {
			out.print(request.getParameter("mensagem"));
			out.print("<script>setTimeout(() => {window.location.href='funcionario.jsp'}, 3000);</script>");
		} else {
			out.print("Mensagens do sistema.");
		}
		
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<table>\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>Id</th>\r\n");
      out.write("\t\t\t\t<th>Nome</th>\r\n");
      out.write("\t\t\t\t<th>Nascimento</th>\r\n");
      out.write("\t\t\t\t<th>Endereco</th>\r\n");
      out.write("\t\t\t\t<th>Especialidade</th>\r\n");
      out.write("\t\t\t\t<th>Competências</th>\r\n");
      out.write("\t\t\t\t<th>Periodo</th>\r\n");
      out.write("\t\t\t\t<th>ValorHora</th>\r\n");
      out.write("\t\t\t\t<th>Ações</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t\t<tbody>\r\n");
      out.write("\t\t\t");

				//Corpo da tabela
			for (Funcionario f : FuncionarioServlet.getFuncionarios()) {
				out.print("<tr>");
				out.print(f.toHTML());
				out.print("<td>");
				out.print("<button onclick='del(this)'>Excluir</button>");
				out.print("<button onclick='put(this)'>Alterar</button>");
				out.print("</td>");
				out.print("</tr>");
			}
			
      out.write("\r\n");
      out.write("\t\t</tbody>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t//Funções JavaScript para Alterar e Excluir\r\n");
      out.write("\t\tfunction del(e) {\r\n");
      out.write("\t\t\tlet id = e.parentNode.parentNode.cells[0].innerText;\r\n");
      out.write("\t\t\t//Abre uma janela confirmando a edição\r\n");
      out.write("\t\t\tif (window.confirm(\"Confirma Exclusão do id \" + id + \"?\")) {\r\n");
      out.write("\t\t\t\t//Envia a requisição de DELETE via XML utilizando o verbo correto \"DELETE\"\r\n");
      out.write("\t\t\t\tlet xhr = new XMLHttpRequest();\r\n");
      out.write("\t\t\t\txhr\r\n");
      out.write("\t\t\t\t\t\t.addEventListener(\r\n");
      out.write("\t\t\t\t\t\t\t\t\"readystatechange\",\r\n");
      out.write("\t\t\t\t\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tif (this.readyState === this.DONE) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\twindow.location.href = \"funcionario.jsp?mensagem=Excluído com sucesso\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t//window.location.reload();\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t//alert(this.responseText); \r\n");
      out.write("\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\tlet url = \"funcionarios?id=\" + id; //Monta a URL concatenando o ID\r\n");
      out.write("\t\t\t\txhr.open(\"DELETE\", url);\r\n");
      out.write("\t\t\t\txhr.send(); //Envia a requisição ao Servlet REST\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction put(e) {\r\n");
      out.write("\t\t\te.parentNode.parentNode.cells[1].setAttribute(\"contenteditable\",\r\n");
      out.write("\t\t\t\t\t\"true\");\r\n");
      out.write("\t\t\te.parentNode.parentNode.cells[2].setAttribute(\"contenteditable\",\r\n");
      out.write("\t\t\t\t\t\"true\");\r\n");
      out.write("\t\t\te.parentNode.parentNode.cells[3].setAttribute(\"contenteditable\",\r\n");
      out.write("\t\t\t\t\t\"true\");\r\n");
      out.write("\t\t\te.parentNode.parentNode.cells[4].setAttribute(\"contenteditable\",\r\n");
      out.write("\t\t\t\t\t\"true\");\r\n");
      out.write("\t\t\te.parentNode.parentNode.cells[5].setAttribute(\"contenteditable\",\r\n");
      out.write("\t\t\t\t\t\"true\");\r\n");
      out.write("\t\t\te.parentNode.parentNode.cells[6].setAttribute(\"contenteditable\",\r\n");
      out.write("\t\t\t\t\t\"true\");\r\n");
      out.write("\t\t\te.parentNode.parentNode.cells[7].setAttribute(\"contenteditable\",\r\n");
      out.write("\t\t\t\t\t\"true\");\r\n");
      out.write("\t\t\te.parentNode.parentNode.cells[8].innerHTML = \"<button onclick='send(this)'>Concluir</button>\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction send(e) {\r\n");
      out.write("\t\t\tlet id = e.parentNode.parentNode.cells[0].innerText;\r\n");
      out.write("\t\t\tlet nome = e.parentNode.parentNode.cells[1].innerText;\r\n");
      out.write("\t\t\tlet nascimento = e.parentNode.parentNode.cells[2].innerText;\r\n");
      out.write("\t\t\tlet endereco = e.parentNode.parentNode.cells[3].innerText;\r\n");
      out.write("\t\t\tlet especialidade = e.parentNode.parentNode.cells[4].innerText;\r\n");
      out.write("\t\t\tlet competencias = e.parentNode.parentNode.cells[5].innerText;\r\n");
      out.write("\t\t\tlet periodo = e.parentNode.parentNode.cells[6].innerText;\r\n");
      out.write("\t\t\tlet valorHora = e.parentNode.parentNode.cells[7].innerText;\r\n");
      out.write("\t\t\tlet url = \"funcionarios?id=\" + id + \"&nome=\" + nome\r\n");
      out.write("\t\t\t\t\t+ \"&nascimento=\" + nascimento + \"&endereco=\" + endereco\r\n");
      out.write("\t\t\t\t\t+ \"&especialidade=\" + especialidade + \"&competencias=\"\r\n");
      out.write("\t\t\t\t\t+ competencias + \"&periodo=\" + periodo + \"&valorHora=\"\r\n");
      out.write("\t\t\t\t\t+ valorHora;\r\n");
      out.write("\t\t\tlet xm = new XMLHttpRequest();\r\n");
      out.write("\t\t\txm\r\n");
      out.write("\t\t\t\t\t.addEventListener(\r\n");
      out.write("\t\t\t\t\t\t\t\"readystatechange\",\r\n");
      out.write("\t\t\t\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\t\t\t\tif (this.readyState === this.DONE) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\twindow.location.href = \"funcionario.jsp?mensagem=Alterado com sucesso\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t//window.location.reload();\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\txm.open(\"PUT\", url);\r\n");
      out.write("\t\t\txm.send();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
