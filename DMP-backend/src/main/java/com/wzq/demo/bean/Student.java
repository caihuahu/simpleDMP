package com.wzq.demo.bean;

/**
 * @author wzq
 * @create 2023-02-13 22:20
 */
public class Student {

    private Integer sid;
    private String sname;
    private String simg;
    private String sdegree;
    private String smajor;
    private Integer sgrade;
    private String sinterest;
    private String semail;
    private Integer sdone;
    private String swhere;

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", simg='" + simg + '\'' +
                ", sdegree='" + sdegree + '\'' +
                ", smajor='" + smajor + '\'' +
                ", sgrade=" + sgrade +
                ", sinterest='" + sinterest + '\'' +
                ", semail='" + semail + '\'' +
                ", sdone=" + sdone +
                ", swhere='" + swhere + '\'' +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSimg() {
        return simg;
    }

    public void setSimg(String simg) {
        this.simg = simg;
    }

    public String getSdegree() {
        return sdegree;
    }

    public void setSdegree(String sdegree) {
        this.sdegree = sdegree;
    }

    public String getSmajor() {
        return smajor;
    }

    public void setSmajor(String smajor) {
        this.smajor = smajor;
    }

    public Integer getSgrade() {
        return sgrade;
    }

    public void setSgrade(Integer sgrade) {
        this.sgrade = sgrade;
    }

    public String getSinterest() {
        return sinterest;
    }

    public void setSinterest(String sinterest) {
        this.sinterest = sinterest;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public Integer getSdone() {
        return sdone;
    }

    public void setSdone(Integer sdone) {
        this.sdone = sdone;
    }

    public String getSwhere() {
        return swhere;
    }

    public void setSwhere(String swhere) {
        this.swhere = swhere;
    }

    public Student() {
    }

    public Student(Integer sid, String sname, String simg, String sdegree, String smajor, Integer sgrade, String sinterest, String semail, Integer sdone, String swhere) {
        this.sid = sid;
        this.sname = sname;
        this.simg = simg;
        this.sdegree = sdegree;
        this.smajor = smajor;
        this.sgrade = sgrade;
        this.sinterest = sinterest;
        this.semail = semail;
        this.sdone = sdone;
        this.swhere = swhere;
    }
}
