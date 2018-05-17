package ru.innopolis.stc9.service;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.ConnectionManager.CryptoUtils;
import ru.innopolis.stc9.dao.*;
import ru.innopolis.stc9.dao.pojo.User;
import ru.innopolis.stc9.dao.pojo.UserTypes;

import java.sql.SQLException;

public class UserService {
    private final static Logger logger = Logger.getLogger(LessonService.class);
    private static AdminDAO adminDao = new AdminDAOImpl();
    private static TutorDAO tutorDao = new TutorDAOImpl();
    private static StudentDAO studentDao = new StudentDAOImpl();

    public User checkAuth(String userType, String login, String password) throws SQLException {
        if(userType==null || login==null || password==null) throw new NullPointerException();
        User user = null;
        int user_type = 0;
        try{
            user_type = Integer.valueOf(userType);
        }catch(Exception ex){
            logger.error("Error userType parameter",ex);
            return null;
        }
        switch (user_type){
            case UserTypes.USER_ADMIN: user = adminDao.getAdminByLogin(login);break;
            case UserTypes.USER_TUTOR: user = tutorDao.getTutorByLogin(login);break;
            case UserTypes.USER_STUDENT: user = studentDao.getStudentByLogin(login);break;
        }
        if(user != null){
            String inputHash = "";
            try {
                inputHash = CryptoUtils.byteArrayToHexString(CryptoUtils.computeHash(password));
            } catch (Exception ex) {
                logger.error("Error to get Hash from input password",ex);
                return null;
            }
            if(inputHash.equals(user.getPassw()))return user;
        }
        return null;
    }
}
