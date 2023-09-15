<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 15/09/2023
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Caculator</h1>
<br>
<form action="/caculator/calculate" method="post">
    <input type="number" name="number1">
    <input type="number" name="number2">
    <button type="submit" name="sign" value="+">Addition(+)</button>
    <button type="submit" name="sign" value="-">Subtraction(-)</button>
    <button type="submit" name="sign" value="*">Multiplication(X)</button>
    <button type="submit" name="sign" value="/">Division(/)</button>
</form>
<p>Result Division: ${result}</p>
</body>
</html>
