package ru.innopolis.stc9.pojo;

public class SubjectAndMark {
    private Subject subject;
    private float totalMark;

    public SubjectAndMark(Subject subject, float totalMark){
        if (subject == null) throw new NullPointerException();
        this.subject = subject;
        this.totalMark = totalMark;
    }

    public Subject getSubject() {
        return subject;
    }

    public float getTotalMark() { return totalMark; }

    public void setSubject(Subject subject) {
        if (subject == null) throw new NullPointerException();
        this.subject = subject;
    }

    public void setTotalMark(float totalMark) {
        this.totalMark = totalMark;
    }
}
