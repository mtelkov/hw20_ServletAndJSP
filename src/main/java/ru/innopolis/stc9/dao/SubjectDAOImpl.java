package ru.innopolis.stc9.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.ConnectionManager.ConnectionManager;
import ru.innopolis.stc9.ConnectionManager.ConnectionManagerJDBCImpl;
import ru.innopolis.stc9.dao.factory.SubjectFactory;
import ru.innopolis.stc9.dao.pojo.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubjectDAOImpl implements SubjectDAO {
    private static ConnectionManager connectionManager = ConnectionManagerJDBCImpl.getInstance();
    private final static Logger logger = Logger.getLogger(SubjectDAOImpl.class);
    private SubjectFactory subjectFactory = new SubjectFactory();

    public boolean addSubject(Subject subject){
        return false;
    }

    public Subject getSubjectById(int id){
        Subject subject = null;
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * " +
                "FROM subjects WHERE subj_id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                subject = subjectFactory.createSubject(resultSet);
            }
            connection.close();
        }catch (SQLException ex) {
            logger.error("Error to get Subject",ex);
        }
        return subject;
    }

    /**
     * Получить список всех предметов
     * @return ArrayList<Subject>
     */
    public ArrayList<Subject> getAllSubjects(){
        logger.info("Обращение к DAO");
        Connection connection = connectionManager.getConnection();
        ArrayList<Subject> arrSubj = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM subjects ORDER BY name");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                arrSubj.add(subjectFactory.createSubject(resultSet));
            }
            connection.close();
        }catch (SQLException ex) {
            logger.error("Error get all subjects",ex);
        }
        return arrSubj;
    }

    public boolean updateSubject(Subject subject){
        return false;
    }

    public boolean deleteSubjectById (int id){
        return false;
    }
}
