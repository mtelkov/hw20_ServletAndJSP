package ru.innopolis.stc9.controller;

import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentSubjectController  extends HttpServlet {
    private final static Logger logger = Logger.getLogger(StudentSubjectController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        logger.info("Входящий запрос: " + req.getRequestURI());
        req.getRequestDispatcher("/student_subjects.jsp").forward(req, resp);
        logger.info("Запрос обработан и отправлен ответ");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
