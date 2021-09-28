<%@page import="com.azienda.catalogoProdotti.model.Prodotto"%>
<%@page import="java.util.List"%>
<%@page import="com.azienda.catalogoProdotti.Util.Costanti"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Risultati ricerca</title>
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
		<table border="1">
			<tr>
				<td>Prodotti</td>
			</tr>
		<%
		for(Prodotto s:lista){
		%>
			<tr>
				<td><%=s%></td>
			</tr>
		<%
			}
		%>
		</table>
		<%
			} else {
		%>
		<p>Non sono stati trovati risultati</p>
		<%
			}
		%>
		<a href="<%=request.getContextPath()+"/jsp/privata/ricerca.jsp"%>">Torna indietro</a>
		
		<br><br>
		 <jsp:include page="/jsp/privata/menu.jsp"></jsp:include>
	
</div>
</body>
</html>