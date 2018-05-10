package ru.innopolis.stc9.dao;

import ru.innopolis.stc9.pojo.Lesson;
import ru.innopolis.stc9.pojo.Student;
import ru.innopolis.stc9.pojo.Subject;
import ru.innopolis.stc9.pojo.SubjectAndMark;

import java.util.ArrayList;

public interface LessonDAO {
    public boolean addLesson(Lesson lesson);
    public Lesson getLessonById(int id);
    public ArrayList<Lesson> getAllLessons();
    public ArrayList<Lesson> getStudentVisitedLessonsWithMark(int subjectId, int stud_id);
    public boolean updateLesson(Lesson lesson);
    public boolean deleteLessonById (int id);
    public ArrayList<SubjectAndMark> getStudentVisitedSubjectsWithTotalMark(int stud_id);
}
