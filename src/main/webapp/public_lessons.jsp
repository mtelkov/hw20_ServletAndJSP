<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="ru.innopolis.stc9.pojo.Lesson" %>
<%@ page import="ru.innopolis.stc9.service.LessonService" %>
<%@ page import="java.util.ArrayList" %>

<%@ include file="header.jsp" %>
<%@ include file="aside.jsp" %>
<div class="main">
    <div class="main_content">
        <table border="1" cellspacing="0" cellpadding="3" align="center">
            <tr>
                <th>ID</th>
                <th>Date</th>
                <th>Subject</th>
                <th>Tutor</th>
            </tr>
            <%
                LessonService lessonService = new LessonService();
                String stringLsnId = request.getParameter("lsnId");
                request.setAttribute("lsnId", stringLsnId);
            %>
            <c:if test="${lsnId != null}">
                <c:if test="${lsnId.equals(\"all\")}">
                    <%
                        ArrayList<Lesson> arrayLsn = lessonService.getAllLessons();
                        request.setAttribute("arrayLsn", arrayLsn);
                    %>
                    <c:forEach var="lesson" items="${arrayLsn}" >
                        <tr>
                            <td>${lesson.lsn_id}</td>
                            <td>${lesson.lsn_date}</td>
                            <td>${lesson.subjectImpl.name}</td>
                            <td>${lesson.tutorImpl.grade} ${" "} ${lesson.tutorImpl.FIO}</td>
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${!lsnId.equals(\"all\")}">
                    <%
                        Lesson lesson = lessonService.getLessonById(Integer.valueOf(stringLsnId));
                        request.setAttribute("lesson", lesson);
                    %>
                    <tr>
                        <td>${lesson.lsn_id}</td>
                        <td>${lesson.lsn_date}</td>
                        <td>${lesson.subjectImpl.name}</td>
                        <td>${lesson.tutorImpl.grade} ${" "} ${lesson.tutorImpl.FIO}</td>
                    </tr>
                </c:if>
            </c:if>
            <c:if test="${lsnId == null}">
                <tr>
                    <td>null</td>
                    <td>null</td>
                    <td>null</td>
                    <td>null</td>
                </tr>
            </c:if>
        </table>
    </div>
</div>
<%@ include file="footer.jsp" %>
