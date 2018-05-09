<%@ page import="ru.innopolis.stc9.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Student area</title>
  </head>
  <body>
    <% User user = (User) session.getAttribute("user"); %>
    <p>Вы вошли как: <i><%= user.getFIO()%></i></p>
    <br>
    <a href="${pageContext.request.contextPath}/student/dashboard/subjects">Посмотреть список всех посещенных предметов</a><br>
    <a href="${pageContext.request.contextPath}/student/dashboard/lessons?lsnId=all">Посмотреть список всех занятий в Университете</a>
  </body>
</html>
