<%--
  Created by IntelliJ IDEA.
  User: EQUIPE01
  Date: 7/21/2024
  Time: 8:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Book</title>
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
            width: 25vw;
            padding: 20px;
        }

        input, button {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button {
            color: white;
            background-color: blue;
            cursor: pointer;
        }

        label {
            margin-top: 10px;
        }

        a {
            display: inline-block;
            margin-top: 10px;
            color: blue;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Editar Livro</h2>
    <form action="editBook" method="post">
        <input type="hidden" name="id" value="${book.id}">
        <label>Título</label>
        <input type="text" name="title" value="${book.title}" required><br>
        <label>Autor</label>
        <input type="text" name="author" value="${book.author}" required><br>
        <label>Preço</label>
        <input type="number" step="0.01" name="price" value="${book.price}" required><br>
        <button type="submit">Atualizar</button>
    </form>
    <a href="books">Voltar</a>
</div>
</body>
</html>

