<%@page import="com.azienda.catalogoProdotti.Util.Costanti"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>esito</title>
</head>
<body>

<div style="float:left">
 <jsp:include page="/jsp/privata/menu.jsp"></jsp:include>
</div>

<div align="center" style="float:center">
<%
	String esito=(String)request.getAttribute(Costanti.RISULTATO_OPERAZIONE);
	String errore=(String) request.getAttribute(Costanti.CHIAVE_ERRORE);
	if(errore!=null){
%>
	<p>errore:<%=errore %></p>

<%
	}else{
%>
	<p>esito:<%=esito %></p>
<%
	}
%>
</div>


</body>
</html>