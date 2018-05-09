package ru.innopolis.stc9.controller;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.pojo.Lesson;
import ru.innopolis.stc9.service.LessonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AdminLessonController extends HttpServlet {
    private final static Logger logger = Logger.getLogger(AdminLessonController.class);
    private LessonService lessonService = new LessonService();

    /**
     * Метод формирует строку для ответа
     * @param lesson - информация по занятию
     * @return String - строка ответа
     */
    private String getAnswerStr(Lesson lesson){
        if(lesson == null) return "NULL";
        return "ID = " + lesson.getLsn_id() + ", Date: " + lesson.getLsn_date() +
                ", Subject: " + lesson.getSubjectImpl().getName() +
                ", Tutor: " + lesson.getTutorImpl().getGrade() + " " + lesson.getTutorImpl().getFIO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Входящий запрос: " + req.getRequestURI());
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println("<html><body>");
        String lessonId = req.getParameter("lsnId");
        if (lessonId != null) {
            if(lessonId.equalsIgnoreCase("all")){
                ArrayList<Lesson> arrayLsn = lessonService.getAllLessons();
                for (Lesson lesson : arrayLsn) {
                    resp.getWriter().println(getAnswerStr(lesson));
                    resp.getWriter().println("<br>");
                }
            }else {
                resp.getWriter().println(getAnswerStr(lessonService.getLessonById(Integer.parseInt(lessonId))));
            }
        }else {
            resp.getWriter().println("Nothing");
        }
        resp.getWriter().println("</body></html>");
        logger.info("Запрос обработан и отправлен ответ");
    }
}
