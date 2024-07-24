<%--
  Created by IntelliJ IDEA.
  User: EQUIPE01
  Date:
  Time:
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
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

        input, button, a {
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

        a {
            color: blue;
            text-decoration: none;
            text-align: center;
            display: block;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 style="padding: 5px; text-align: center;">
        Login
    </h1>
    <form action="login" method="post" style="width: 100%; display: flex; flex-direction: column;">
        <label for="email">Email</label>
        <input type="email" id="email" name="email" required />
        <label for="password">Password</label>
        <input type="password" id="password" name="password" required />
        <button type="submit">Login</button>
    </form>
    <a href="/index">Home</a>
</div>
</body>
</html>
