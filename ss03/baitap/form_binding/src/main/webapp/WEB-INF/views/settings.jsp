<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 18/09/2023
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Settings</h1>
<br>
<p>${mess}</p>
<form:form action="/mail/settings" method="post" modelAttribute="mail">
    <label>id</label>
    <form:input path="id"/> <br>
    <label>languages</label>
    <form:select path="languages">
        <form:options items="${listLanguages}"/>
    </form:select> <br>
    <label>pageSize</label>
    <form:select path="pageSize">
        <form:options items="${listPageSize}"/>
    </form:select> <br>
    <label>Spams filter</label>
    <form:checkbox path="spams"/> Enable spams filter <br>
    <label>signature</label>
    <form:input path="signature"/> <br>
    <form:button>Update</form:button>
    <button><a style="text-decoration: none; color: black" href="/mail/home">Cancel</a></button>
</form:form>
</body>
</html>
