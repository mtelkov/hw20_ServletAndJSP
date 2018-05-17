package ru.innopolis.stc9.dao.pojo;

public class LessonAndMark {
    private Lesson lesson;
    private float mark;

    public LessonAndMark(Lesson lesson, float mark){
        if (lesson == null) throw new NullPointerException();
        this.lesson = lesson;
        this.mark = mark;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public float getMark() {
        return mark;
    }

    public void setLesson(Lesson lesson) {
        if (lesson == null) throw new NullPointerException();
        this.lesson = lesson;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }
}
