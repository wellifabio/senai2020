<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.net.*"
    import="java.io.*"
    import="org.json.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		
		String nome = request.getParameter("name");
		String id = request.getParameter("id");
		
		if((nome != null) && (id != null)){
						
			URL url = new URL("http://localhost:8080/servlet/server?name="+nome+"&id="+id);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			
			int respCode = con.getResponseCode();
			
			if(respCode == HttpURLConnection.HTTP_OK){
				
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				
				String line = "";
				String apnd = "";
								
				while( (line = br.readLine()) != null){
					apnd += line;
				}

				
				JSONObject json = new JSONObject(apnd);
				
				out.println("Response - " + json.toString());
				
			}
			
		}
	
	%>

	<form method="post" action="#">
		<input type="text" name="name">
		<input type="text" name="id">
		<input type="submit">
	</form>

</body>
</html>