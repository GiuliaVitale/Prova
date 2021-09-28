<%@page import="com.azienda.catalogoProdotti.Util.Costanti"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Errore</title>
</head>
<body>

<p>Errore: <%=request.getAttribute(Costanti.CHIAVE_ERRORE) %></p>
	

</body>
</html>