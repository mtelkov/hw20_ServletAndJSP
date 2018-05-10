<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<%@ include file="aside.jsp" %>

<div class="main">
  <div class="main_content">
    <a href="${pageContext.request.contextPath}/student/dashboard/subjects">Посмотреть список всех посещенных предметов</a><br><br>
    <a href="${pageContext.request.contextPath}/student/dashboard/lessons">Посмотреть список всех занятий в Университете</a>
  </div>
</div>

<%@ include file="footer.jsp" %>
