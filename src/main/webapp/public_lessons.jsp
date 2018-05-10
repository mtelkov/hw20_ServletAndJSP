<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="ru.innopolis.stc9.pojo.Lesson" %>
<%@ page import="ru.innopolis.stc9.service.LessonService" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.innopolis.stc9.pojo.User" %>
<%@ page import="ru.innopolis.stc9.service.SubjectService" %>

<%@ include file="header.jsp" %>
<%@ include file="aside.jsp" %>
<div class="main">
    <div class="main_content">
        <%
            LessonService lessonService = new LessonService();
            String stringLsnId = request.getParameter("lsnId");
            request.setAttribute("lsnId", stringLsnId);
            String stringSubjId = request.getParameter("subjectId");
            request.setAttribute("subjectId", stringSubjId);
        %>
        <c:if test="${lsnId != null}" var="isLsn" scope="page"><p>Информация по выбранному занятию: </p></c:if>
        <c:if test="${subjectId != null}" var="isSubj" scope="page">
            <%
                SubjectService subjectService = new SubjectService();
                String subjectName = subjectService.getSubjectById(Integer.valueOf(stringSubjId)).getName();
                request.setAttribute("subjectName", subjectName);
            %>
            <p>Информация по занятиям выбранного предмета (${subjectName}): </p>
        </c:if>
        <c:if test="${!pageScope.isLsn && !pageScope.isSubj}"><p>Информация по всем занятиям: </p></c:if>
        <table border="1" cellspacing="0" cellpadding="3" align="center">
            <tr>
                <th>ID</th>
                <th>Date</th>
                <th>Subject</th>
                <th>Tutor</th>
                <th>Mark</th>
            </tr>
            <c:if test="${lsnId != null}">
                <!--вывести занятие по ID-->
                <%
                    Lesson lesson = lessonService.getLessonById(Integer.valueOf(stringLsnId));
                    request.setAttribute("lesson", lesson);
                %>
                <c:if test="${lesson != null}">
                    <tr>
                        <td>${lesson.lsn_id}</td>
                        <td>${lesson.lsn_date}</td>
                        <td>${lesson.subjectImpl.name}</td>
                        <td>${lesson.tutorImpl.grade} ${" "} ${lesson.tutorImpl.FIO}</td>
                        <td>---</td>
                    </tr>
                </c:if>
                <c:if test="${lesson == null}">
                    <tr>
                        <td>null</td><td>null</td><td>null</td><td>null</td>
                    </tr>
                </c:if>
            </c:if>

            <c:if test="${lsnId == null}">
                <c:if test="${subjectId != null}">
                    <!--вывести занятия по предмету для студента-->
                    <%
                        User user =  (User)request.getSession().getAttribute("user");
                        ArrayList<Lesson> arrayLsn = lessonService.getStudentVisitedLessonsWithMark(Integer.valueOf(stringSubjId), user.getId());
                        request.setAttribute("arrayLsn", arrayLsn);
                    %>
                    <c:if test="${arrayLsn.size() > 0}">
                        <c:forEach var="lesson" items="${arrayLsn}" >
                            <tr>
                                <td>${lesson.lsn_id}</td>
                                <td>${lesson.lsn_date}</td>
                                <td>${lesson.subjectImpl.name}</td>
                                <td>${lesson.tutorImpl.grade} ${" "} ${lesson.tutorImpl.FIO}</td>
                                <td>mark</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${arrayLsn.size() == 0}">
                        <tr>
                            <td>null</td><td>null</td><td>null</td><td>null</td>
                        </tr>
                    </c:if>

                </c:if>
                <c:if test="${subjectId == null}">
                    <!--вывести все занятия-->
                    <%
                        ArrayList<Lesson> arrayLsn = lessonService.getAllLessons();
                        request.setAttribute("arrayLsn", arrayLsn);
                    %>
                    <c:if test="${arrayLsn.size() > 0}">
                        <c:forEach var="lesson" items="${arrayLsn}" >
                            <tr>
                                <td>${lesson.lsn_id}</td>
                                <td>${lesson.lsn_date}</td>
                                <td>${lesson.subjectImpl.name}</td>
                                <td>${lesson.tutorImpl.grade} ${" "} ${lesson.tutorImpl.FIO}</td>
                                <td>---</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${arrayLsn.size() == 0}">
                        <tr>
                            <td>null</td><td>null</td><td>null</td><td>null</td><td>null</td>
                        </tr>
                    </c:if>
                </c:if>
            </c:if>
        </table>
    </div>
</div>
<%@ include file="footer.jsp" %>
