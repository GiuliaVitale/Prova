<%@page import="com.azienda.catalogoProdotti.Util.Costanti"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aggiornamento</title>
</head>
<body>

<div style="float:left">
 <jsp:include page="/jsp/privata/menu.jsp"></jsp:include>
</div>

<div align="center" style="float:center">
	<form action="/CatalogoProdotti/prodottoServlet" method="post">
		
		<table>
			<tr>
				<th>Ricerca</th>
			</tr>
			<tr>
				<td> Nome: 
					<input type="text" name="<%=Costanti.CHIAVE_NOMEPRODOTTO%>">
				</td>
			</tr>
			<tr>
				<td> Prezzo: 
					<input type="text" name=<%=Costanti.CHIAVE_PREZZOPRODOTTO%>>
				</td>
			</tr>
		</table>
		<input type="submit" value="Cerca">
		
		<input type="hidden" name="<%=Costanti.CHIAVE_OPERAZIONI%>" value="<%=Costanti.VALORE_MODIFICA%>">
		</form>
		
	</div>
</body>
</html>