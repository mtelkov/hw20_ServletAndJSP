package ru.innopolis.stc9.controller;

import ru.innopolis.stc9.pojo.User;
import ru.innopolis.stc9.pojo.UserTypes;
import ru.innopolis.stc9.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String login = req.getParameter("user");
        String password = req.getParameter("password");
        String userType = req.getParameter("usertype");
        User user;
        if ((user=userService.checkAuth(userType, login, password)) != null) {
            req.getSession().setAttribute("user", user);
            req.getSession().setAttribute("usertype", userType);
            switch (Integer.valueOf(userType)){
                case UserTypes.USER_ADMIN: resp.sendRedirect(req.getContextPath() + "/admin/dashboard");break;
                case UserTypes.USER_TUTOR: resp.sendRedirect(req.getContextPath() + "/tutor/dashboard");break;
                case UserTypes.USER_STUDENT: resp.sendRedirect(req.getContextPath() + "/student/dashboard");break;
            }

        } else {
            resp.sendRedirect(req.getContextPath() + "/login?errorMsg=authErr");
        }
    }
}
