package ru.innopolis.stc9.dao;

import ru.innopolis.stc9.pojo.Subject;

import java.sql.SQLException;

public interface SubjectDAO {
    public boolean addSubject(Subject subject);
    public Subject getSubjectById(int id) throws SQLException;
    public boolean updateSubject(Subject subject);
    public boolean deleteSubjectById (int id);
}
