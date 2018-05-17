package ru.innopolis.stc9.service;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.dao.SubjectDAO;
import ru.innopolis.stc9.dao.SubjectDAOImpl;
import ru.innopolis.stc9.dao.pojo.Subject;

import java.util.ArrayList;

public class SubjectService {
    private final static Logger logger = Logger.getLogger(SubjectService.class);

    SubjectDAO subjectDAO = new SubjectDAOImpl();

    public Subject getSubjectById(int id){
        return subjectDAO.getSubjectById(id);
    }

    public ArrayList<Subject> getAllSubjects(){return subjectDAO.getAllSubjects();}
}
