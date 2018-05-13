package ru.innopolis.stc9.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.ConnectionManager.ConnectionManager;
import ru.innopolis.stc9.ConnectionManager.ConnectionManagerJDBCImpl;
import ru.innopolis.stc9.pojo.*;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class LessonDAOImpl implements LessonDAO{
    private static ConnectionManager connectionManager = ConnectionManagerJDBCImpl.getInstance();
    private final static Logger logger = Logger.getLogger(LessonDAOImpl.class);

    /**
     * Создать занятие на основе данных в ResultSet
     * @param resultSet - источник данных
     * @return Lesson - занятие
     */
    private Lesson createNewLesson(ResultSet resultSet){
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

    /**
     * Добавить занятие в БД
     * @param lesson - добавляемое занятие
     * @return boolean результат обработки
     */
    public boolean addLesson(Lesson lesson){
        if(getLessonById(lesson.getLsn_id()) != null)return false;
        String sqlRequest = "INSERT INTO lessons (subj_id,tutor_id,adm_id,lsn_date) VALUES(?,?,?,?)";
        int result = 0;
        Connection connection = connectionManager.getConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(sqlRequest);
            statement.setInt(1, lesson.getSubj_id());
            statement.setInt(2, lesson.getTutor_id());
            statement.setInt(3, lesson.getAdm_id());
            java.sql.Date dateL =Date.valueOf(lesson.getLsn_date().toString());
            statement.setDate(4, dateL);
            result = statement.executeUpdate();
            connection.close();
        }catch (SQLException ex) {
            logger.error("Error add lesson operation to DB",ex);
            return false;
        }
        if(result > 0)return true;
        else return false;
    }

    /**
     * Метод возвращает занятие по id
     * @param id
     * @return
     */
    public Lesson getLessonById(int id){
        logger.info("Обращение к DAO");
        Lesson lesson = null;
        Connection connection = connectionManager.getConnection();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * " +
                    "FROM lessons WHERE lsn_id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                lesson = createNewLesson(resultSet);
            }
            connection.close();
        }catch (SQLException ex) {
            logger.error("Error to get lesson",ex);
        }
        return lesson;
    }

    /**
     * Метод возвращает все занятия
     * @return список занятий
     */
    public ArrayList<Lesson> getAllLessons(){
        logger.info("Обращение к DAO");
        Connection connection = connectionManager.getConnection();
        ArrayList<Lesson> arrayLessons = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM lessons ORDER BY lsn_date, subj_id");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                arrayLessons.add(createNewLesson(resultSet));
            }
            connection.close();
        }catch (SQLException ex) {
            logger.error("Error get all lesson",ex);
        }
        return arrayLessons;
    }

    /**
     * Метод возвращает все занятия по указанному предмету для указанного студента
     * @param subjectId - ID предмета
     * @param stud_id - ID студента
     * @return список занятий
     */
    public ArrayList<LessonAndMark> getStudentVisitedLessonsWithMark(int subjectId, int stud_id){
        logger.info("Обращение к DAO");
        Connection connection = connectionManager.getConnection();
        ArrayList<LessonAndMark> arrayLessons = new ArrayList<>();
        LessonAndMark lessonAndMark = null;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT ln.*, v.mark FROM lessons ln " +
                    "INNER JOIN subjects s on ln.subj_id = s.subj_id " +
                    "INNER JOIN lesson_visitors v on ln.lsn_id = v.lsn_id " +
                    "WHERE s.subj_id = ? and v.stud_id = ? " +
                    "ORDER BY ln.lsn_date");
            statement.setInt(1, subjectId);
            statement.setInt(2, stud_id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                lessonAndMark = new LessonAndMark(createNewLesson(resultSet), resultSet.getFloat("mark"));
                arrayLessons.add(lessonAndMark);
            }
            connection.close();
        }catch (SQLException ex) {
            logger.error("Error to get lessons for student and subject",ex);
        }
        return arrayLessons;
    }

    public boolean updateLesson(Lesson lesson){
        return false;
    }

    public boolean deleteLessonById (int id){
        return false;
    }

    /**
     * Метод возвращает список предметов, на которых присутствовал студент
     * @param stud_id - ID студента
     * @return список предметов
     */
    public ArrayList<SubjectAndMark> getStudentVisitedSubjectsWithTotalMark(int stud_id){
        logger.info("Обращение к DAO");
        Connection connection = connectionManager.getConnection();
        ArrayList<SubjectAndMark> arrayData = new ArrayList<>();
        Subject subject = null;
        SubjectAndMark subjectAndMark = null;
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT s.subj_id, s.name, SUM(v.mark) FROM lessons ln " +
                    "INNER JOIN subjects s on ln.subj_id = s.subj_id " +
                    "INNER JOIN lesson_visitors v on ln.lsn_id = v.lsn_id " +
                    "WHERE v.stud_id = ? " +
                    "GROUP BY s.subj_id, s.name " +
                    "ORDER BY s.name");
            statement.setInt(1, stud_id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                subject = new Subject(
                        resultSet.getInt("subj_id"),
                        resultSet.getString("name")
                );
                subjectAndMark = new SubjectAndMark(subject, resultSet.getFloat(3));
                arrayData.add(subjectAndMark);
            }
            connection.close();
        }catch (SQLException ex) {
            logger.error("Error to get visited subjects",ex);
        }
        return arrayData;
    }
}
