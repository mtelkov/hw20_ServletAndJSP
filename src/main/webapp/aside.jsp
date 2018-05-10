<%@ page import="ru.innopolis.stc9.pojo.UserTypes" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    request.setAttribute("user_admin", UserTypes.USER_ADMIN);
    request.setAttribute("user_tutor", UserTypes.USER_TUTOR);
    request.setAttribute("user_student", UserTypes.USER_STUDENT);
%>

<div class="sidebar">
    <p><b>МЕНЮ:</b></p>
    <ul>
    <c:if test="${sessionScope.usertype != null}">
        <c:if test="${sessionScope.usertype == user_admin}">
            <li><a href="${pageContext.request.contextPath}/admin/dashboard">Главная</a></li>
        </c:if>
        <c:if test="${sessionScope.usertype == user_tutor}">
            <li><a href="${pageContext.request.contextPath}/tutor/dashboard">Главная</a></li>
        </c:if>
        <c:if test="${sessionScope.usertype == user_student}">
            <li><a href="${pageContext.request.contextPath}/student/dashboard">Главная</a></li>
        </c:if>
    </c:if>
    </ul>
</div>
