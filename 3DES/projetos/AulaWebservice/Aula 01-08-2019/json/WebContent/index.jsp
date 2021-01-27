<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.HttpURLConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="control.Json"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
		//Json j = new Json();
	
		URL url = new URL("http://localhost:8080/json/Servlet");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.connect();
		
		BufferedReader br;
		InputStream in = con.getInputStream();
		br = new BufferedReader(new InputStreamReader(in));
		
		String linha = "";
		
		while((linha = br.readLine()) != null){
			out.println(linha);
		}
	%>
</body>
</html>
