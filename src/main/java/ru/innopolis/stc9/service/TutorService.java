package ru.innopolis.stc9.service;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.dao.TutorDAO;
import ru.innopolis.stc9.dao.TutorDAOImpl;
import ru.innopolis.stc9.pojo.Tutor;

import java.util.ArrayList;

public class TutorService {
    private final static Logger logger = Logger.getLogger(SubjectService.class);
    TutorDAO tutorDAO = new TutorDAOImpl();

    public ArrayList<Tutor> getAllTutors(){return tutorDAO.getAllTutors();}

}
