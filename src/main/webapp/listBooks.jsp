<%--
  Created by IntelliJ IDEA.
  User: EQUIPE01
  Date: 7/21/2024
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>List of Books</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #eee;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .container {
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 8px;
            width: 80vw;
            padding: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        a {
            color: blue;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        .add-button {
            display: inline-block;
            padding: 10px 20px;
            margin-top: 10px;
            background-color: blue;
            color: white;
            text-align: center;
            border-radius: 4px;
            text-decoration: none;
        }

        .add-button:hover {
            background-color: darkblue;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Lista de livros</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Título</th>
            <th>Autor</th>
            <th>Preço</th>
            <th>Ações</th>
        </tr>
        <c:if test="${not empty books}">
            <c:forEach items="${books}" var="book">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.price}</td>
                    <td>
                        <a href="editBook?id=${book.id}">Edit</a>
                        <a href="deleteBook?id=${book.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
    <a href="addBook.jsp" class="add-button">Adicionar novo livro</a>
</div>
</body>
</html>