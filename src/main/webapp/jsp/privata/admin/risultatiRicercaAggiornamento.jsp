<%@page import="com.azienda.catalogoProdotti.Util.Costanti"%>
<%@page import="com.azienda.catalogoProdotti.model.Prodotto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>risultati aggiornamento</title>
</head>
<body>

	<div style="float:left">
	 	<jsp:include page="/jsp/privata/menu.jsp"></jsp:include>
	</div>

	<div align="center" style="float:center">
		<%
			List<Prodotto> lista=(List<Prodotto>)request.getAttribute(Costanti.RISULTATO_OPERAZIONE);
			if(lista!=null){
		%>
			<form action="<%=request.getContextPath() + "/ProdottoServlet"%>" method="post">
		
		<%
			}
		%>
	</div>
</body>
</html>