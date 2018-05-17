package ru.innopolis.stc9.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.ConnectionManager.ConnectionManager;
import ru.innopolis.stc9.ConnectionManager.ConnectionManagerJDBCImpl;
import ru.innopolis.stc9.dao.factory.UserFactory;
import ru.innopolis.stc9.dao.pojo.Student;
import ru.innopolis.stc9.dao.pojo.UserTypes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAOImpl implements StudentDAO{
    private static ConnectionManager connectionManager = ConnectionManagerJDBCImpl.getInstance();
    private final static Logger logger = Logger.getLogger(StudentDAOImpl.class);
    private UserFactory userFactory = new UserFactory();

    public boolean addStudent(Student student){return false;}

    public Student getStudentById(int id){
        Student student = null;
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * " +
                    "FROM students WHERE stud_id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                student = (Student) userFactory.createUser(UserTypes.USER_STUDENT, resultSet);
            }
            connection.close();
        }catch (SQLException ex) {
            logger.error("Error to get Student by id",ex);
        }
        return student;
    }

    public Student getStudentByLogin(String login){
        Student student = null;
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * " +
                    "FROM students WHERE login = ?");
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                student = (Student) userFactory.createUser(UserTypes.USER_STUDENT, resultSet);
            }
            connection.close();
        }catch (SQLException ex) {
            logger.error("Error to get Student by login",ex);
        }
        return student;
    }

    public boolean updateStudent(Student student){return false;}

    public boolean deleteStudentById (int id){return false;}
}
