<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="sidebar">
    <strong>Меню:</strong><BR>

    <c:if test="${10 > 9}">
        <p>True</p>
    </c:if>

    <c:if test="${10 < 9}">
        <p>False</p>
    </c:if>

    <c:forEach var="num" items="${list}">
        <p>${num}</p>
    </c:forEach>

</div>
