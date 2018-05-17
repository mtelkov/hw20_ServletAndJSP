package ru.innopolis.stc9.dao;

import ru.innopolis.stc9.dao.pojo.Admin;

import java.sql.SQLException;

public interface AdminDAO {
    public boolean addAdmin(Admin admin);
    public Admin getAdminById(int id) throws SQLException;
    public Admin getAdminByLogin(String login) throws SQLException;
    public boolean updateAdmin(Admin admin);
    public boolean deleteAdminById (int id);
}
