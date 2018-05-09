package ru.innopolis.stc9.pojo;

public class Tutor extends User{
    private String grade;
    private int subj_id;
    private Subject subjectImpl;

    public Tutor(int id, String fio, String login, String passw, String grade, int subj_id) {
        super(id, fio, login, passw);
        this.grade = grade;
        this.subj_id = subj_id;
    }

    public Tutor(int id, String fio, String login, String passw, String grade, Subject subjectImpl) {
        super(id, fio, login, passw);
        this.grade = grade;
        this.subjectImpl = subjectImpl;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getSubj_id() {
        return subj_id;
    }

    public void setSubj_id(int subj_id) {
        this.subj_id = subj_id;
    }

    public Subject getSubjectImpl() {
        return subjectImpl;
    }

    public void setSubjectImpl(Subject subjectImpl) {
        this.subjectImpl = subjectImpl;
    }
}
