<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 15/09/2023
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>spice selected</h1>
<c:forEach var="spice" items="${condiment}">
    ${spice}
</c:forEach>
<a href="/index.jsp">Home</a>
</body>
</html>
