package ru.innopolis.stc9.service;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.dao.LessonDAO;
import ru.innopolis.stc9.dao.LessonDAOImpl;
import ru.innopolis.stc9.dao.pojo.*;

import java.util.ArrayList;

public class LessonService {
    private final static Logger logger = Logger.getLogger(LessonService.class);

    LessonDAO lessonDao = new LessonDAOImpl();

    public boolean addLesson(Lesson lesson){
        logger.info("Обращение к сервису");
        return lessonDao.addLesson(lesson);
    }

    public Lesson getLessonById(int id) {
        logger.info("Обращение к сервису");
        return lessonDao.getLessonById(id);
    }

    public ArrayList<Lesson> getAllLessons() {
        logger.info("Обращение к сервису");
        return lessonDao.getAllLessons();
    }

    public ArrayList<LessonAndMark> getStudentVisitedLessonsWithMark(int subjectId, int stud_id){
        logger.info("Обращение к сервису");
        return lessonDao.getStudentVisitedLessonsWithMark(subjectId, stud_id);
    }

    public ArrayList<SubjectAndMark> getStudentVisitedSubjectsWithTotalMark(int stud_id){
        logger.info("Обращение к сервису");
        return lessonDao.getStudentVisitedSubjectsWithTotalMark(stud_id);
    }
}
