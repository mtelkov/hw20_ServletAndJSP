package ru.innopolis.stc9.controller;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.pojo.Lesson;
import ru.innopolis.stc9.pojo.User;
import ru.innopolis.stc9.service.LessonService;
import ru.innopolis.stc9.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class AddLessonController extends HttpServlet {
    private final static Logger logger = Logger.getLogger(AddLessonController.class);

    private LessonService lessonService = new LessonService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("/add_lesson.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String subjId = req.getParameter("subjId");
        String tutorId = req.getParameter("tutorId");
        String dateLsn = req.getParameter("dateLsn");
        User user = (User)req.getSession().getAttribute("user");
        Lesson lesson = null;
        try{
            lesson = new Lesson(-1,Integer.valueOf(subjId),Integer.valueOf(tutorId),user.getId(), Date.valueOf(dateLsn));
            boolean result = lessonService.addLesson(lesson);
            if(result){
                resp.sendRedirect(req.getContextPath() + "/admin/dashboard/add_lesson?result=ok");
            }else{
                resp.sendRedirect(req.getContextPath() + "/admin/dashboard/add_lesson?result=addErr");
            }
        }catch(Exception ex){
            logger.error("Error to add lesson",ex);
            resp.sendRedirect(req.getContextPath() + "/admin/dashboard/add_lesson?result=addErr");
        }
    }
}
