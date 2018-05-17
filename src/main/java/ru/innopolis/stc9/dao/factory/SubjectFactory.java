package ru.innopolis.stc9.dao.factory;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.dao.pojo.Subject;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectFactory {
    private final static Logger logger = Logger.getLogger(SubjectFactory.class);

    public Subject createSubject(ResultSet resultSet){
        Subject subject = null;
        try{
            subject = new Subject(
                    resultSet.getInt("subj_id"),
                    resultSet.getString("name"));
        }catch (SQLException ex) {
            logger.error("Error to create new Subject",ex);
            return null;
        }
        return subject;
    }
}
