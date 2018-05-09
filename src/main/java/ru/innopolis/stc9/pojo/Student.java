package ru.innopolis.stc9.pojo;

public class Student extends User{
    private int num_zk;
    private float avr_mark;

    public Student(int id, String fio, String login, String passw, int num_zk, float avr_mark) {
        super(id, fio, login, passw);
        this.num_zk = num_zk;
        this.avr_mark = avr_mark;
    }

    public int getNum_zk() {
        return num_zk;
    }

    public void setNum_zk(int num_zk) {
        this.num_zk = num_zk;
    }

    public float getAvr_mark() {
        return avr_mark;
    }

    public void setAvr_mark(float avr_mark) {
        this.avr_mark = avr_mark;
    }
}
