<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 14/09/2023
  Time: 2:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Chuyển đổi tiền tệ</h1>

<form action="/currency/result" method="post">
  <input name="usd" type="number" placeholder="USD">
  <button type="submit">Kết quả</button>
</form>
<p>Result = ${result}</p>
</body>
</html>
