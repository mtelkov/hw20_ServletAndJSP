<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="ru.innopolis.stc9.dao.pojo.Subject" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.innopolis.stc9.service.SubjectService" %>
<%@ page import="ru.innopolis.stc9.dao.pojo.Tutor" %>
<%@ page import="ru.innopolis.stc9.service.TutorService" %>

<%@ include file="header.jsp" %>
<%@ include file="aside.jsp" %>
<div class="main">
    <div class="main_login">
        <%=("addErr".equals(request.getParameter("result"))) ?
                "<div style=\"color: Red;\">" +
                        "<b>Ошибка при добавлении занятия. Првоерьте корреткность введенных данных</b>" +
                        "</div>" +
                        "<br><br>" : ""
        %>
        <%=("findClone".equals(request.getParameter("result"))) ?
                "<div style=\"color: Red;\">" +
                        "<b>Такое занятие уже существует</b>" +
                        "</div>" +
                        "<br><br>" : ""
        %>
        <%=("ok".equals(request.getParameter("result"))) ?
                "<div style=\"color: Green;\">" +
                        "<b>Занятие успешно добавлено</b>" +
                        "</div>" +
                        "<br><br>" : ""
        %>
        <p>Введите данные для создания занятия:</p>
        <form action="${pageContext.request.contextPath}/admin/dashboard/add_lesson" method="post">
            <table border="2" align="left" cellspacing="5" cellpadding="13" rules="none">
                <tr>
                    <td align="left">Выберите предмет:</td>
                    <td align="left">
                        <select name="subjId" size="1" required>
                            <%
                                SubjectService subjectService = new SubjectService();
                                ArrayList<Subject> arrSubj = subjectService.getAllSubjects();
                                request.setAttribute("arrSubj", arrSubj);
                            %>
                            <c:forEach var="data" items="${arrSubj}" >
                                <option value=${data.subj_id}>${data.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr/>
                <tr>
                    <td align="left">Назначьте преподавателя:</td>
                    <td align="left">
                        <select name="tutorId" size="1" required>
                            <%
                                TutorService tutorService = new TutorService();
                                ArrayList<Tutor> arrTutors = tutorService.getAllTutors();
                                request.setAttribute("arrTutors", arrTutors);
                            %>
                            <c:forEach var="data" items="${arrTutors}" >
                                <option value=${data.id}>${data.grade}${" "}${data.FIO}</option>
                            </c:forEach>
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