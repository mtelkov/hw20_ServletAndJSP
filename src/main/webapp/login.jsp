<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="ru.innopolis.stc9.pojo.UserTypes" %>

<%@ include file="header.jsp" %>
<%@ include file="aside.jsp" %>
<div class="main">
    <div class="main_login">
        <%=("authErr".equals(request.getParameter("errorMsg"))) ?
                "<div style=\"color: Red;\">" +
                    "<b>Неверное имя пользователя/пароль</b>" +
                "</div>" +
                "<br><br>" : ""%>
        <%=("noAuth".equals(request.getParameter("errorMsg"))) ?
                "<div style=\"color: Red;\">" +
                     "<b>Пройдите авторизацию</b>" +
                "</div>" +
                "<br><br>" : ""%>
        <p>Введите данные для авторизации:</p>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <table border="2" align="center" cellspacing="5" cellpadding="13" rules="none">
                <tr>
                    <td align="left">Войти как:</td>
                    <td>
                        <select name="usertype" size="1" required>
                            <option selected value=<%=UserTypes.USER_ADMIN%>>Администратор</option>
                            <option value=<%=UserTypes.USER_TUTOR%>>Преподаватель</option>
                            <option value=<%=UserTypes.USER_STUDENT%>>Студент</option>
                        </select>
                    </td>
                </tr>
                <tr/>
                <tr>
                    <td align="left">Логин</td>
                    <td><input type="text" name="user" width="25"></td>
                </tr>
                <tr/>
                <tr>
                    <td align="left">Пароль</td>
                    <td><input type="password" name="password" width="25"></td>
                </tr>
            </table>
            <br>
            <input type="submit" value="Войти">
        </form>
    </div>
</div>
<%@ include file="footer.jsp" %>