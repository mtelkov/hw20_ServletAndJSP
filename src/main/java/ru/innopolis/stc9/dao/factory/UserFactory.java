package ru.innopolis.stc9.dao.factory;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.dao.pojo.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserFactory {
    private final static Logger logger = Logger.getLogger(UserFactory.class);

    public User createUser(int userType, ResultSet resultSet){
        User user = null;
        switch (userType){
            case UserTypes.USER_ADMIN:
                try{
                    user = new Admin(
                            resultSet.getInt("adm_id"),
                            resultSet.getString("fio"),
                            resultSet.getString("login"),
                            resultSet.getString("passw"));
                }catch (SQLException ex) {
                    logger.error("Error to create new Subject",ex);
                    return null;
                }
                break;
            case UserTypes.USER_TUTOR:
                try{
                    user = new Tutor(
                            resultSet.getInt("tutor_id"),
                            resultSet.getString("fio"),
                            resultSet.getString("login"),
                            resultSet.getString("passw"),
                            resultSet.getString("grade"),
                            resultSet.getInt("subj_id"));
                }catch (SQLException ex) {
                    logger.error("Error to create new Tutor",ex);
                    return null;
                }
                break;
            case UserTypes.USER_STUDENT:
                try {
                    user = new Student(
                            resultSet.getInt("stud_id"),
                            resultSet.getString("fio"),
                            resultSet.getString("login"),
                            resultSet.getString("passw"),
                            resultSet.getInt("num_zk"),
                            resultSet.getFloat("avr_mark"));
                }catch (SQLException ex) {
                    logger.error("Error to create new Student",ex);
                    return null;
                }
                break;
        }
        return user;
    }
}
