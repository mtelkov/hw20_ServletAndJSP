<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="header.jsp" %>
<%@ include file="aside.jsp" %>
<div class="main">
    <div class="main_login">
        <p>Введите данные для создания занятия:</p>
        <form action="${pageContext.request.contextPath}/admin/dashboard/add_lesson" method="post">
            <table border="2" align="left" cellspacing="5" cellpadding="13" rules="none">
                <tr>
                    <td align="left">Выберите предмет:</td>
                    <td>
                        <select name="subjId" size="1" required>
                            <option selected value=<%=1%>>1</option>
                            <option value=<%=2%>>2</option>
                            <option value=<%=3%>>3</option>
                        </select>
                    </td>
                </tr>
                <tr/>
                <tr>
                    <td align="left">Назначьте преподавателя:</td>
                    <td>
                        <select name="tutorId" size="1" required>
                            <option selected value=<%=1%>>1</option>
                            <option value=<%=2%>>2</option>
                            <option value=<%=3%>>3</option>
                        </select>
                    </td>
                </tr>
                <tr/>
                <tr>
                    <td align="left">Дата занятия:</td>
                    <td><input type="date" name="dateLsn"></td>
                </tr>
                <tr/>
                <tr>
                    <td align="left"><input type="reset" value="Сбросить"></td>
                    <td align="right"><input type="submit" value="Добавить"></td>
                </tr>
            </table>
            <br>
        </form>
    </div>
</div>
<%@ include file="footer.jsp" %>