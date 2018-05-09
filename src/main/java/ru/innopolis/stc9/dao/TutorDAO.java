package ru.innopolis.stc9.dao;

import ru.innopolis.stc9.pojo.Tutor;

import java.sql.SQLException;

public interface TutorDAO {
    public boolean addTutor(Tutor tutor);
    public Tutor getTutorById(int id) throws SQLException;
    public Tutor getTutorByLogin(String login) throws SQLException;
    public boolean updateTutor(Tutor tutor);
    public boolean deleteTutorById (int id);
}
