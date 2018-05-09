package ru.innopolis.stc9.controller;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.pojo.Student;
import ru.innopolis.stc9.pojo.Subject;
import ru.innopolis.stc9.pojo.User;
import ru.innopolis.stc9.service.LessonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class StudentSubjectController  extends HttpServlet {
    private final static Logger logger = Logger.getLogger(StudentSubjectController.class);
    private LessonService lessonService = new LessonService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Входящий запрос: " + req.getRequestURI());
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println("<html>");
        resp.getWriter().println("<head><title>Student area</title></head>");
        resp.getWriter().println("<body>");
        resp.getWriter().println("<h3>Вы посетили следующие предметы:</h3><br>");
        User user = (User)req.getSession().getAttribute("user");
        ArrayList<Subject> arraySubjects = lessonService.getDistinctSubjectsLessonsForStudent(user.getId());
        if(arraySubjects.size() > 0){
            for (Subject subject : arraySubjects) {
                    resp.getWriter().println(subject.getName());
                    resp.getWriter().println("<br>");
            }
        }else {
            resp.getWriter().println("Nothing");
        }
        resp.getWriter().println("</body></html>");
        logger.info("Запрос обработан и отправлен ответ");
    }
}
