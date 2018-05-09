package ru.innopolis.stc9.dao;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.ConnectionManager.ConnectionManager;
import ru.innopolis.stc9.ConnectionManager.ConnectionManagerJDBCImpl;
import ru.innopolis.stc9.pojo.Lesson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        }catch (SQLException e) {
            e.printStackTrace();
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
            statement.setString(1, String.valueOf(lesson.getSubj_id()));
            statement.setString(2, String.valueOf(lesson.getTutor_id()));
            statement.setString(3, String.valueOf(lesson.getAdm_id()));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            statement.setString(3, sdf.format(lesson.getLsn_date()));
            result = statement.executeUpdate();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
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
        }catch (SQLException e) {
            e.printStackTrace();
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
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM lessons");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                arrayLessons.add(createNewLesson(resultSet));
            }
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayLessons;
    }

    public boolean updateLesson(Lesson lesson){
        return false;
    }

    public boolean deleteLessonById (int id){
        return false;
    }
}
