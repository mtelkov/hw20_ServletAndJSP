package ru.innopolis.stc9.dao;

import ru.innopolis.stc9.pojo.Subject;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SubjectDAO {
    public boolean addSubject(Subject subject);
    public Subject getSubjectById(int id);
    public ArrayList<Subject> getAllSubjects();
    public boolean updateSubject(Subject subject);
    public boolean deleteSubjectById (int id);
}
