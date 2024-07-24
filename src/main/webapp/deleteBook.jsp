<%--
  Created by IntelliJ IDEA.
  User: EQUIPE01
  Date: 7/21/2024
  Time: 8:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Deletar Livro</title>
</head>
<body>
<h2>Deletar Livro</h2>
<p>Tem certeza que desejar deletar o livro "${book.title}" de ${book.author}?</p>
<form action="deleteBook" method="post">
    <input type="hidden" name="id" value="${param.id}">
    <input type="submit" value="Deletar">
</form>
<a href="books">Voltar</a>
</body>
</html>