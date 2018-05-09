package ru.innopolis.stc9.service;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.dao.*;
import ru.innopolis.stc9.pojo.User;
import ru.innopolis.stc9.pojo.UserTypes;

import java.sql.SQLException;

public class UserService {
    private final static Logger logger = Logger.getLogger(LessonService.class);
    private static AdminDAO adminDao = new AdminDAOImpl();
    private static TutorDAO tutorDao = new TutorDAOImpl();
    private static StudentDAO studentDao = new StudentDAOImpl();

    public User checkAuth(String userType, String login, String password) {
        if(userType==null || login==null || password==null) return null;
        User user = null;
        try {
            switch (Integer.valueOf(userType)){
                case UserTypes.USER_ADMIN: user = adminDao.getAdminByLogin(login);break;
                case UserTypes.USER_TUTOR: user = tutorDao.getTutorByLogin(login);break;
                case UserTypes.USER_STUDENT: user = studentDao.getStudentByLogin(login);break;
            }
        } catch (SQLException ex) {
            logger.error("Error to check user",ex);
            return null;
        }
        if((user != null) && (user.getPassw().equals(password)))
            return user;
        else return null;
    }
}
