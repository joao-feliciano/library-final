<%--
  Created by IntelliJ IDEA.
  User: EQUIPE01
  Date: 07/07/2024
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome!</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            color: #333;
            padding: 20px;
        }
        a {
            color: #007bff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
        h1 {
            color: #333;
        }
    </style>
</head>
<body>
<header>
    <c:choose>
        <c:when test="${not empty client}">
            <p>Usuário autenticado: ${client.name}</p>
            <a href="logout">Logout</a>
        </c:when>
        <c:otherwise>
            <p>Usuário não autenticado</p>
            <a href="login">Login</a>
        </c:otherwise>
    </c:choose>
</header>
<h1>Bem vindo ${client.name}, seu email é ${client.email}</h1>
<a href="/books">Veja livros</a>
</body>
</html>

