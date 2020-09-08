<%@ page contentType="text/html;charset=UTF-16" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Сайт оренди квартир</title>
</head>
<body>

<jstl:choose>

    <jstl:when test="${not empty sessionScope.user}">

        <p>${sessionScope.user.name}
            <a href="controller?action=logout">Logout</a>
        </p>

        <form method="post" action="create_apartment.jsp">
            <input type="submit" value="Create new apartment"/>
        </form>

        <form method="post" action="controller?action=search">
            <p><input type="text" name="search" placeholder="Пошук за паратетрами (Через кому)" size="50"/>
                <input type="submit" value="Search"/></p>
        </form>

        <jstl:forEach items="${requestScope.apartments}" var="apartment">
            <form method="post" action="controller?action=go_to_apartment">
                <p>
                    <jstl:out value="${apartment.header}, seller: ${apartment.creator.name}"/>
                    <input type="hidden" name="apartment" value="${apartment.header}" readonly>
                    <input type="submit" value="View"/>
                </p>
            </form>
        </jstl:forEach>

    </jstl:when>

    <jstl:otherwise>

        <p><a href="register.jsp">РЕЄСТРАЦІЯ</a></p>
        <p><a href="login.jsp">ВХІД</a></p>

    </jstl:otherwise>
</jstl:choose>

</body>
</html>

