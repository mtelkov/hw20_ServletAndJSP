<%@ page import="ru.innopolis.stc9.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Admin area</title>
  </head>
  <body>
    <% User user = (User) session.getAttribute("user"); %>
    <p>Вы вошли как: <i><%= user.getFIO()%></i></p>
    <br>
    <a href="${pageContext.request.contextPath}/admin/dashboard/lessons?lsnId=all">Посмотреть список всех занятий</a>
    <form method="get" action="${pageContext.request.contextPath}/admin/dashboard/lessons">
      <p>Введите ID занятия ->
        <input type="text" name ="lsnId" size="10">
        <input type="submit" value="Просмотреть">
      </p>
    </form>
  </body>
</html>
