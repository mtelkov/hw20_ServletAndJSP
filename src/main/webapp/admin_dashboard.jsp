<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<%@ include file="aside.jsp" %>

<div class="main">
  <div class="main_content">
      <a href="${pageContext.request.contextPath}/admin/dashboard/lessons">Посмотреть список всех занятий</a>
        <form method="get" action="${pageContext.request.contextPath}/admin/dashboard/lessons">
            <p>Просмотреть информацию о занятии:<br>
            Введите ID занятия ->
            <input type="text" name ="lsnId" size="10">
            <input type="submit" value="Просмотреть">
            </p>
        </form>
      <br>
      <a href="${pageContext.request.contextPath}/admin/dashboard/add_lesson">Добавить занятие</a>
  </div>
</div>
<%@ include file="footer.jsp" %>
