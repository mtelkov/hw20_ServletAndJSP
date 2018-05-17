package ru.innopolis.stc9.dao;

import ru.innopolis.stc9.dao.pojo.*;

import java.util.ArrayList;

public interface LessonDAO {
    public boolean addLesson(Lesson lesson);
    public Lesson getLessonById(int id);
    public ArrayList<Lesson> getAllLessons();
    public ArrayList<LessonAndMark> getStudentVisitedLessonsWithMark(int subjectId, int stud_id);
    public boolean updateLesson(Lesson lesson);
    public boolean deleteLessonById (int id);
    public ArrayList<SubjectAndMark> getStudentVisitedSubjectsWithTotalMark(int stud_id);
}
