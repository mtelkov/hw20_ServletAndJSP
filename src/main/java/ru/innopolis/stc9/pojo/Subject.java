package ru.innopolis.stc9.pojo;

public class Subject {
    private int subj_id;
    private String name;

    public Subject(int subj_id, String name) {
        this.subj_id = subj_id;
        this.name = name;
    }

    public int getSubj_id() {
        return subj_id;
    }

    public String getName() {
        return name;
    }

    public void setSubj_id(int subj_id) {
        this.subj_id = subj_id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
