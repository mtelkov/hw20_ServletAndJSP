<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="ru.innopolis.stc9.service.LessonService" %>
<%@ page import="ru.innopolis.stc9.pojo.User" %>
<%@ page import="ru.innopolis.stc9.pojo.SubjectAndMark" %>
<%@ page import="java.util.ArrayList" %>

<%@ include file="header.jsp" %>
<%@ include file="aside.jsp" %>
<div class="main">
    <div class="main_content">
        <p style="alignment: center;">Вы посетили следующие предметы: </p>
        <table border="1" cellspacing="0" cellpadding="3" align="center">
            <tr>
                <th>Subject name</th>
                <th>Total Mark</th>
            </tr>
            <%
                LessonService lessonService = new LessonService();
                User user = (User) request.getSession().getAttribute("user");
                ArrayList<SubjectAndMark> arrayData = lessonService.getStudentVisitedSubjectsWithTotalMark(user.getId());
                request.setAttribute("arrayData", arrayData);
            %>
            <c:if test="${arrayData.size() > 0}">
                <c:forEach var="data" items="${arrayData}" >
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/student/dashboard/lessons?subjectId=${data.subject.subj_id}">${data.subject.name}</a></td>
                        <td>${data.totalMark}</td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${arrayData.size() == 0}">
                <tr>
                    <td>null</td>
                    <td>null</td>
                </tr>
            </c:if>
        </table>
    </div>
</div>
<%@ include file="footer.jsp" %>
