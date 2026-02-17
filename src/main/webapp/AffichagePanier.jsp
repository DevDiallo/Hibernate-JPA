<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Bienvenue dans votre panier </h3>
<table border="1">
	<tr>
		<th>Poids</th>
		<th>Prix</th>
	</tr>
	<c:forEach var="p" items="${PouletsList}">
            <tr>
                <td>${p.poids}</td>
                <td>${p.prix}</td>
                
            </tr>
     </c:forEach>
</table>
</body>
</html>