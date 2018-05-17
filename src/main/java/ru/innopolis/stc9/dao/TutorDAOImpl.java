package ru.innopolis.stc9.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.ConnectionManager.ConnectionManager;
import ru.innopolis.stc9.ConnectionManager.ConnectionManagerJDBCImpl;
import ru.innopolis.stc9.dao.factory.UserFactory;
import ru.innopolis.stc9.dao.pojo.Tutor;
import ru.innopolis.stc9.dao.pojo.UserTypes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TutorDAOImpl implements TutorDAO{
    private static ConnectionManager connectionManager = ConnectionManagerJDBCImpl.getInstance();
    private final static Logger logger = Logger.getLogger(TutorDAOImpl.class);
    private UserFactory userFactory = new UserFactory();

    public boolean addTutor(Tutor tutor){return false;}

    /**
     * Метод возвращает преподавателя из БД
     * @param id - идентификатор преподавателя
     * @return Tutor
     */
    public Tutor getTutorById(int id){
        Tutor tutor = null;
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * " +
                    "FROM tutors WHERE tutor_id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                tutor = (Tutor) userFactory.createUser(UserTypes.USER_TUTOR, resultSet);
            }
            connection.close();
        }catch (SQLException ex) {
            logger.error("Error get tutor by id",ex);
        }
        return tutor;
    }

    /**
     * Метод возвращает преподавателя из БД
     * @param login логин преподавателя
     * @return Tutor
     */
    public Tutor getTutorByLogin(String login){
        Tutor tutor = null;
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * " +
                    "FROM tutors WHERE login = ?");
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                tutor = (Tutor) userFactory.createUser(UserTypes.USER_TUTOR, resultSet);
            }
            connection.close();
        }catch (SQLException ex) {
            logger.error("Error get tutor by login",ex);
        }
        return tutor;
    }

    /**
     * Получить список всех преподавателей
     * @return ArrayList<Tutor>
     */
    public ArrayList<Tutor> getAllTutors(){
        logger.info("Обращение к DAO");
        Connection connection = connectionManager.getConnection();
        ArrayList<Tutor> arrTutors = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM tutors ORDER BY fio");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                arrTutors.add((Tutor)userFactory.createUser(UserTypes.USER_TUTOR, resultSet));
            }
            connection.close();
        }catch (SQLException ex) {
            logger.error("Error get all tutors",ex);
        }
        return arrTutors;
    }


    public boolean updateTutor(Tutor tutor){return false;}

    public boolean deleteTutorById (int id){return false;}
}
