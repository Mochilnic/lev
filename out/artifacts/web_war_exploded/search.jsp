<%@ page contentType="text/html;charset=UTF-16" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Знайдені квартири</title>
</head>
<body>

    <p><a href="controller?action=main">Main page</a></p>

    <p>${sessionScope.user.name}
        <a href="controller?action=logout">Logout</a>
    </p>

    <form method="post" action="controller?action=search">
        <p><input type="text" name="search" placeholder="Пошук за паратетрами (Через кому)"/>
            <input type="submit" value="Search"/></p>
    </form>

    <jstl:forEach items="${requestScope.searchApartments}" var="apartment">
        <form method="post" action="controller?action=go_to_apartment">
            <p>
                <jstl:out value="${apartment.header}, seller: ${apartment.creator.name}"/>
                <input type="hidden" name="apartment" value="${apartment.header}" readonly>
                <input type="submit" value="View"/>
            </p>
        </form>
    </jstl:forEach>

</body>
</html>
