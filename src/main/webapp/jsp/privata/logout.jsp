<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logout</title>
</head>
<body>
	
<div style="float:left">
 <jsp:include page="/jsp/privata/menu.jsp"></jsp:include>
</div>

<div align="center" style="float:center">

	<form action="/CatalogoProdotti/logoutServlet" method="post">
		<p align="center">
			<input type="submit" value="Logout" id="bottoni" >
		</p>
	</form>
</div>
</body>
</html>