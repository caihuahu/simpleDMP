package com.wzq.demo.bean;

import java.sql.Date;

/**
 * @author wzq
 * @create 2023-02-13 21:50
 */
public class Paper {

    private Long id;
    private Date date;
    private String des;

    public Paper() {
    }

    public Paper(Long id, Date date, String des) {
        this.id = id;
        this.date = date;
        this.des = des;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id +
                ", date=" + date +
                ", des='" + des + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
