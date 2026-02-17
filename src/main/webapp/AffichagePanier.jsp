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
<form action="controller" method="POST">

<h3>Bienvenue dans votre panier</h3>

<table border="1">
    <tr>
        <th>Choix</th>
        <th>Poids</th>
        <th>Prix</th>
    </tr>

    <c:forEach var="p" items="${PouletsList}" varStatus="status">
        <tr>
            <td>
                <!-- On envoie l'index -->
                <input type="radio" name="selectedIndex" 
                       value="${status.index}" required>
            </td>
            <td>${p.poids}</td>
            <td>${p.prix}</td>
        </tr>
    </c:forEach>
</table>

<br>
<input name="btn-supprimer" type="submit" value="Supprimer">

</form>

</body>
</html>