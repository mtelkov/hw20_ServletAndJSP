package ru.innopolis.stc9.dao;

import ru.innopolis.stc9.pojo.Lesson;
import ru.innopolis.stc9.pojo.Student;
import ru.innopolis.stc9.pojo.Subject;

import java.util.ArrayList;

public interface LessonDAO {
    public boolean addLesson(Lesson lesson);
    public Lesson getLessonById(int id);
    public ArrayList<Lesson> getAllLessons();
    public boolean updateLesson(Lesson lesson);
    public boolean deleteLessonById (int id);
    public ArrayList<Subject> getDistinctSubjectsLessonsForStudent(int stud_id);
}
