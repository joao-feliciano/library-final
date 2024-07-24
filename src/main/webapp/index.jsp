<%--
  Created by IntelliJ IDEA.
  User: EQUIPE01
  Date: 7/21/2024
  Time: 8:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Sistema de Gestão de Biblioteca</title>
    </head>
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
            height: 45vh;
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 20px;
        }
    </style>
    <body>
        <div style="display:flex; width: 100vw; height: 100vh; flex-direction: column; justify-content: center; align-items: center">
        <div class="container">
            <h1 style="padding: 5px; text-align: center;">
                Sistema de Gestão de Biblioteca
            </h1>
            <br/>
            <div style="display:flex; flex-direction: column; width: 100%;">
                <a href="/login.jsp" style="padding: 10px; color: white; background: blue; border-radius: 8px; text-align: center;">Login</a>
                <a href="addNewClient.jsp" style="padding: 10px; margin-top: 8px; color: white; background: blue; border-radius: 8px; text-align: center;">Novo usuário</a>
            </div>
            </div>
        </div>
    </body>
</html>