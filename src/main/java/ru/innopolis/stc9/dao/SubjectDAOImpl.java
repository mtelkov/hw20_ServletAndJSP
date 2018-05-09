package ru.innopolis.stc9.dao;

import ru.innopolis.stc9.ConnectionManager.ConnectionManager;
import ru.innopolis.stc9.ConnectionManager.ConnectionManagerJDBCImpl;
import ru.innopolis.stc9.pojo.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectDAOImpl implements SubjectDAO {
    private static ConnectionManager connectionManager = ConnectionManagerJDBCImpl.getInstance();

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
                subject = new Subject(
                    resultSet.getInt("subj_id"),
                    resultSet.getString("name"));
            }
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return subject;
    }

    public boolean updateSubject(Subject subject){
        return false;
    }

    public boolean deleteSubjectById (int id){
        return false;
    }
}
