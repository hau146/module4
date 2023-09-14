<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 14/09/2023
  Time: 3:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Chuyển đổi từ điển</h1>

<form action="/dictionary/result" method="post">
  <input type="text" name="dictionary" placeholder="nhập từ vựng">
  <button type="submit">dịch</button>
</form>
<p>${result}</p>
</body>
</html>
