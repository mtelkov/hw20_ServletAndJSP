package ru.innopolis.stc9.dao;

import ru.innopolis.stc9.ConnectionManager.ConnectionManager;
import ru.innopolis.stc9.ConnectionManager.ConnectionManagerJDBCImpl;
import ru.innopolis.stc9.pojo.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAOImpl implements StudentDAO{
    private static ConnectionManager connectionManager = ConnectionManagerJDBCImpl.getInstance();

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
                student = new Student(
                        resultSet.getInt("stud_id"),
                        resultSet.getString("fio"),
                        resultSet.getString("login"),
                        resultSet.getString("passw"),
                        resultSet.getInt("num_zk"),
                        resultSet.getFloat("avr_mark"));
            }
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
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
                student = new Student(
                        resultSet.getInt("stud_id"),
                        resultSet.getString("fio"),
                        resultSet.getString("login"),
                        resultSet.getString("passw"),
                        resultSet.getInt("num_zk"),
                        resultSet.getFloat("avr_mark"));
            }
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public boolean updateStudent(Student student){return false;}

    public boolean deleteStudentById (int id){return false;}
}
