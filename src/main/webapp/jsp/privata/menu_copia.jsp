<%@page import="com.azienda.catalogoProdotti.model.Utente"%>
<%@page import="com.azienda.catalogoProdotti.businessLogic.BusinessLogic"%>
<%@page import="com.azienda.catalogoProdotti.Util.Costanti"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
</head>
<body>

<div align="center">
	<table>
		<tr>
			<th>Menu</th>
		</tr>
		<tr>
			<th><a href="<%=request.getContextPath()+"/jsp/privata/ricerca.jsp"%>">Ricerca</a></th>
		</tr>
		<%
				BusinessLogic businessLogic = (BusinessLogic) request.getServletContext().getAttribute(Costanti.CHIAVE_CONTEXT);
				Utente utenteInSessione = (Utente) request.getSession().getAttribute(Costanti.CHIAVE_UTENTE);
				if(businessLogic.isAdmin(utenteInSessione.getUsername(), utenteInSessione.getPassword())) {
			%>
		<tr>
			<th><a href="<%=request.getContextPath()+"/jsp/privata/admin/creaProdotti.jsp"%>">Crea</a></th>
		</tr>
		<tr>
			<th><a href="<%=request.getContextPath()+"/jsp/privata/admin/ricercaAggiornamento.jsp"%>">Aggiorna</a></th>
		</tr>
		<%
		
				}
		%>
		<tr>
			<th><a href="<%=request.getContextPath()+"/jsp/privata/logout.jsp"%>">Logout</a></th>
		</tr>
	
	</table>
</div>

</body>
</html>