package ru.innopolis.stc9.pojo;

public class SubjectAndMark {
    private Subject subject;
    private float avrMark;

    public SubjectAndMark(Subject subject, float avrMark){
        if (subject == null) throw new NullPointerException();
        this.subject = subject;
        this.avrMark = avrMark;
    }

    public Subject getSubject() {
        return subject;
    }

    public float getAvrMark() {
        return avrMark;
    }
}
