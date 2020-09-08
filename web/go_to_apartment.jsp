<%@ page contentType="text/html;charset=UTF-16" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Квартира ${requestScope.apartment.header}</title>
</head>
<body>

    <p><a href="controller?action=main">Main page</a></p>

    <p>${requestScope.apartment.header}</p>
    <p>Seller: ${requestScope.apartment.creator.name}</p>
    <p>${requestScope.apartment.description}</p>
    <p>Parameters:
        <jstl:forEach items="${requestScope.apartment.parameters}" var="parameter">
            <jstl:out value="${parameter.parameter}, "/>
        </jstl:forEach>
    </p>
    <p>Cost: ${requestScope.apartment.cost}</p>

    <jstl:if test="${requestScope.apartment.creator.equals(sessionScope.user)}">
        <form method="post" action="controller?action=change_apartment">
            <p>
                <input type="hidden" name="apartment" value="${requestScope.apartment.header}" readonly/>
                <input type="submit" value="Edit information"/>
            </p>
        </form>

        <form method="post" action="controller?action=delete">
            <p>
                <input type="hidden" name="apartment" value="${requestScope.apartment.header}">
                <input type="submit" value="Delete"/>
            </p>
        </form>
    </jstl:if>

</body>
</html>
