<%@ page import="ru.innopolis.stc9.pojo.UserTypes" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Authorization</title>
</head>
    <body>
        <%=("authErr".equals(request.getParameter("errorMsg"))) ? "<b>Неверное имя пользователя/пароль</b><br><br>" : ""%>
        <%=("noAuth".equals(request.getParameter("errorMsg"))) ? "<b>Пройдите авторизацию</b><br><br>" : ""%>
        Войти как:<br>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <input type="radio" name="usertype" value=<%=UserTypes.USER_ADMIN%> checked="true"> Администратор<BR>
            <input type="radio" name="usertype" value=<%=UserTypes.USER_TUTOR%>> Преподаватель<BR>
            <input type="radio" name="usertype" value=<%=UserTypes.USER_STUDENT%>> Студент<BR>
            <br>
            <table border="0">
                <caption>Введите данные для авторизации</caption>
                <tr>
                    <td>Логин</td>
                    <td><input type="text" name="user" width="30"></td>
                </tr>
                <tr>
                    <td>Пароль</td>
                    <td><input type="password" name="password" width="30"></td>
                </tr>
            </table>
            <input type="submit" value="OK">
        </form>
    </body>
</html>