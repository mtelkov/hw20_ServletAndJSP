package ru.innopolis.stc9.pojo;

public class User {
    private int id;
    private String fio;
    private String login;
    private String passw;

    public User(int id, String fio, String login, String passw) {
        this.id = id;
        this.fio = fio;
        this.login = login;
        this.passw = passw;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFIO() {
        return fio;
    }

    public void setFIO(String FIO) {
        this.fio = FIO;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }
}
