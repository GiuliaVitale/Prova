<%@page import="com.azienda.catalogoProdotti.model.Utente"%>
<%@page import="com.azienda.catalogoProdotti.Util.Costanti"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<%
		String utente=(String)request.getAttribute(Costanti.CHIAVE_FALLITO);
		if(utente==null){	
	%>

	<form action="/CatalogoProdotti/loginServlet" method="post">
	<div align="center">
		<table border="1">
			<tr>
				<th>Login</th>
			</tr>
			<tr>
				<td> Username: 
				<input type="text" name="<%=Costanti.CHIAVE_USR%>">
				</td>
			</tr>
			<tr>
				<td> Password: 
				<input type="password" name="<%=Costanti.CHIAVE_PW%>">
				</td>
			</tr>
			<tr>
				<td> 
				<input type="submit" value="Entra">
				</td>
			</tr>
		</table>
	</div>
</form>
		<%
			}
			else{
		%>
<form action="/CatalogoProdotti/loginServlet" method="post">
	<p align="center"> Utente non trovato</p>
	<div align="center">
		<table border="1">
			<tr>
				<th>Login</th>
			</tr>
			<tr>
				<td> Username: 
				<input type="text" name="<%=Costanti.CHIAVE_USR%>">
				</td>
			</tr>
			<tr>
				<td> Password: 
				<input type="password" name="<%=Costanti.CHIAVE_PW%>">
				</td>
			</tr>
			<tr>
				<td> 
				<input type="submit" value="Entra">
				</td>
			</tr>
		</table>
	</div>
</form>
		<%
			}
		%>
</body>
</html>