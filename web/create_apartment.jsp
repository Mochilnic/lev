<%@ page contentType="text/html;charset=UTF-16" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Виставити квартиру на продаж</title>
</head>
<body>
<p><a href="controller?action=main">Main page</a></p>
<form method="post" action="controller?action=create_apartment">
    <p><input type="text" name="header" size="150" placeholder="Header"/></p>
    <p><input type="text" name="parameters" size="150" placeholder="Tags (через кому)"/></p>
    <p><input type="text" name="cost" size="150" placeholder="Cost"/></p>
    <p><textarea name="apartment" cols="150" rows="15" placeholder="Description"></textarea></p>
    <p><input type="submit" value="Виставити на продаж"/></p>
</form>
</body>
</html>
