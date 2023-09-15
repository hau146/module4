<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1>Select spices</h1>
<br/>
<form action="/spice/list" method="post">
  <input type="checkbox" name="condiment" value="Lettuce">
  <p>Lettuce</p>
  <input type="checkbox" name="condiment" value="Tomato">
  <p>Tomato</p>
  <input type="checkbox" name="condiment" value="Mustard">
  <p>Mustard</p>
  <input type="checkbox" name="condiment" value="Sprouts">
  <p>Sprouts</p>
  <button type="submit">Save</button>
</form>
</body>
</html>