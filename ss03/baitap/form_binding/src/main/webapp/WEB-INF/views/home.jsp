<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 18/09/2023
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Mail</h1>
<table border="1px">
    <tr>
        <th>STT</th>
        <th>id</th>
        <th>languages</th>
        <th>page size</th>
        <th>Spams filter</th>
        <th>signature</th>
        <th>Settings</th>
    </tr>
    <c:forEach var="mail" items="${mailList}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${mail.id}</td>
            <td>${mail.languages}</td>
            <td>${mail.pageSize}</td>
            <c:if test="${mail.spams == false}">
                <td>Turn off</td>
            </c:if>
            <c:if test="${mail.spams == true}">
                <td>Turn on</td>
            </c:if>

            <td>${mail.signature}</td>
            <td>
                <a href="/mail/settings/${mail.id}">Settings mail</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
