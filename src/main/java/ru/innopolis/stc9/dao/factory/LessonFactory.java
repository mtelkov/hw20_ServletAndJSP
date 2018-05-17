package ru.innopolis.stc9.dao.factory;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.dao.AdminDAOImpl;
import ru.innopolis.stc9.dao.SubjectDAOImpl;
import ru.innopolis.stc9.dao.TutorDAOImpl;
import ru.innopolis.stc9.dao.pojo.Lesson;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LessonFactory {
    private final static Logger logger = Logger.getLogger(LessonFactory.class);

    public Lesson createLesson(ResultSet resultSet){
        Lesson lesson = null;
        try{
            lesson = new Lesson(
                    resultSet.getInt("lsn_id"),
                    resultSet.getInt("subj_id"),
                    resultSet.getInt("tutor_id"),
                    resultSet.getInt("adm_id"),
                    resultSet.getDate("lsn_date"));
            lesson.setAdminImpl(new AdminDAOImpl().getAdminById(lesson.getAdm_id()));
            lesson.setTutorImpl(new TutorDAOImpl().getTutorById(lesson.getTutor_id()));
            lesson.setSubjectImpl(new SubjectDAOImpl().getSubjectById(lesson.getSubj_id()));
        }catch (SQLException ex) {
            logger.error("Error to create new Lesson",ex);
            return null;
        }
        return lesson;
    }
}
