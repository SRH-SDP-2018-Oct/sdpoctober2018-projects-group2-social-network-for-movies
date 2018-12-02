package com.SNM.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "userreview")
public class UserReview {
    @Id
    @Column(name = "serial_no")
    private int serial_no;
    @Column(name = "user_name")
    private String user_name;
    @Column(name = "movie_ID")
    private int movie_ID;
    @Column(name = "review")
    private String review;
    @Column(name = "timestamp")
    private Date timestamp;

    public int getSerial_no() {
        return serial_no;
    }

    public void setSerial_no(int serial_no) {
        this.serial_no = serial_no;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getMovie_ID() {
        return movie_ID;
    }

    public void setMovie_ID(int movie_ID) {
        this.movie_ID = movie_ID;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
