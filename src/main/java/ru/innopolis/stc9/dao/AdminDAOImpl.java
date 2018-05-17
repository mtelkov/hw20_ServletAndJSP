package ru.innopolis.stc9.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.ConnectionManager.ConnectionManager;
import ru.innopolis.stc9.ConnectionManager.ConnectionManagerJDBCImpl;
import ru.innopolis.stc9.dao.factory.UserFactory;
import ru.innopolis.stc9.dao.pojo.Admin;
import ru.innopolis.stc9.dao.pojo.UserTypes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAOImpl implements AdminDAO{
    private static ConnectionManager connectionManager = ConnectionManagerJDBCImpl.getInstance();
    private final static Logger logger = Logger.getLogger(AdminDAOImpl.class);
    private UserFactory userFactory = new UserFactory();

    /**
     * Метод добавляет нового админа
     * @param admin
     * @return
     */
    public boolean addAdmin(Admin admin){
        if(getAdminById(admin.getId()) != null)return false;
        String sqlRequest = "INSERT INTO admins (fio,login,passw) VALUES(?,?,?)";
        int result = 0;
        Connection connection = connectionManager.getConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(sqlRequest);
            statement.setString(1, admin.getFIO());
            statement.setString(2, admin.getLogin());
            statement.setString(3, admin.getPassw());
            result = statement.executeUpdate();
            connection.close();
        }catch (SQLException ex) {
            logger.error("Error to add Admin",ex);
            return false;
        }
        if(result > 0)return true;
        else return false;
    }

    /**
     * Метод получает админа по id
     * @param id
     * @return
     */
    public Admin getAdminById(int id) {
        Admin admin = null;
        String sqlRequest = "SELECT * FROM admins WHERE adm_id = ?";
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sqlRequest);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                admin = (Admin)userFactory.createUser(UserTypes.USER_ADMIN, resultSet);
            }
            connection.close();
        }catch (SQLException ex) {
            logger.error("Error to get Admin by ID",ex);
        }
        return admin;
    }

    /**
     * Метод получает админа по логину
     * @param login
     * @return
     */
    public Admin getAdminByLogin(String login) {
        Admin admin = null;
        String sqlRequest = "SELECT * FROM admins WHERE login = ?";
        Connection connection = connectionManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sqlRequest);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                admin = (Admin)userFactory.createUser(UserTypes.USER_ADMIN, resultSet);
            }
            connection.close();
        }catch (SQLException ex) {
            logger.error("Error to get Admin by login",ex);
        }
        return admin;
    }

    /**
     * Метод обновляет админа в БД
     * @param admin
     * @return
     */
    public boolean updateAdmin(Admin admin){
        String sqlRequest = "UPDATE admins SET fio = ?, login = ?, passw = ? WHERE adm_id = ?";
        int result = 0;
        Connection connection = connectionManager.getConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(sqlRequest);
            statement.setString(1, admin.getFIO());
            statement.setString(2, admin.getLogin());
            statement.setString(3, admin.getPassw());
            statement.setInt(4, admin.getId());
            result = statement.executeUpdate();
            connection.close();
        }catch (SQLException ex) {
            logger.error("Error to update Admin",ex);
            return false;
        }
        if(result > 0)return true;
        else return false;
    }

    /**
     * Метод удаялет админа по id
     * @param id
     * @return
     */
    public boolean deleteAdminById (int id){
        String sqlRequest = "DELETE FROM admins " +
                "WHERE adm_id = ?";
        int result = 0;
        Connection connection = connectionManager.getConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(sqlRequest);
            statement.setInt(1, id);
            result = statement.executeUpdate();
            connection.close();
        }catch (SQLException ex) {
            logger.error("Error to delete Admin",ex);
            return false;
        }
        if(result > 0)return true;
        else return false;
    }
}
