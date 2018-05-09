package ru.innopolis.stc9.pojo;

import java.util.Date;

public class Lesson {
    private int lsn_id;
    private int subj_id;
    private Subject subjectImpl;
    private int tutor_id;
    private Tutor tutorImpl;
    private int adm_id;
    private Admin adminImpl;
    private Date lsn_date;

    public Lesson(int lsn_id, int subj_id, int tutor_id, int adm_id, Date lsn_date) {
        this.lsn_id = lsn_id;
        this.subj_id = subj_id;
        this.tutor_id = tutor_id;
        this.adm_id = adm_id;
        this.lsn_date = lsn_date;
    }

    public Lesson(int lsn_id, Subject subjectImpl, Tutor tutorImpl, Admin adminImpl, Date lsn_date) {
        this.lsn_id = lsn_id;
        this.subjectImpl = subjectImpl;
        this.tutorImpl = tutorImpl;
        this.adminImpl = adminImpl;
        this.lsn_date = lsn_date;
    }

    public int getLsn_id() {
        return lsn_id;
    }

    public void setLsn_id(int lsn_id) {
        this.lsn_id = lsn_id;
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

    public int getTutor_id() {
        return tutor_id;
    }

    public void setTutor_id(int tutor_id) {
        this.tutor_id = tutor_id;
    }

    public Tutor getTutorImpl() {
        return tutorImpl;
    }

    public void setTutorImpl(Tutor tutorImpl) {
        this.tutorImpl = tutorImpl;
    }

    public int getAdm_id() {
        return adm_id;
    }

    public void setAdm_id(int adm_id) {
        this.adm_id = adm_id;
    }

    public Admin getAdminImpl() {
        return adminImpl;
    }

    public void setAdminImpl(Admin adminImpl) {
        this.adminImpl = adminImpl;
    }

    public Date getLsn_date() {
        return lsn_date;
    }

    public void setLsn_date(Date lsn_date) {
        this.lsn_date = lsn_date;
    }
}
