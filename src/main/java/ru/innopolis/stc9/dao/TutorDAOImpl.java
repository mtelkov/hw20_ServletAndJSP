package ru.innopolis.stc9.dao;

import ru.innopolis.stc9.ConnectionManager.ConnectionManager;
import ru.innopolis.stc9.ConnectionManager.ConnectionManagerJDBCImpl;
import ru.innopolis.stc9.pojo.Tutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TutorDAOImpl implements TutorDAO{
    private static ConnectionManager connectionManager = ConnectionManagerJDBCImpl.getInstance();

    public boolean addTutor(Tutor tutor){return false;}

    public Tutor getTutorById(int id){
        Tutor tutor = null;
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * " +
                    "FROM tutors WHERE tutor_id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                tutor = new Tutor(
                        resultSet.getInt("tutor_id"),
                        resultSet.getString("fio"),
                        resultSet.getString("login"),
                        resultSet.getString("passw"),
                        resultSet.getString("grade"),
                        resultSet.getInt("subj_id"));
            }
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return tutor;
    }

    public Tutor getTutorByLogin(String login){
        Tutor tutor = null;
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * " +
                    "FROM tutors WHERE login = ?");
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                tutor = new Tutor(
                        resultSet.getInt("tutor_id"),
                        resultSet.getString("fio"),
                        resultSet.getString("login"),
                        resultSet.getString("passw"),
                        resultSet.getString("grade"),
                        resultSet.getInt("subj_id"));
            }
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return tutor;
    }

    public boolean updateTutor(Tutor tutor){return false;}

    public boolean deleteTutorById (int id){return false;}
}
