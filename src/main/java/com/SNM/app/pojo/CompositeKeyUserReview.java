package com.SNM.app.pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class
CompositeKeyUserReview implements Serializable
{
    @Column(name = "email_ID")
    private String email_ID;
    @Column(name="movie_ID")
    private int movie_ID;
    @Column(name="timestamp")
    private Date timestamp;

    public CompositeKeyUserReview(){}
    public CompositeKeyUserReview(String email_ID, int movie_ID, Date timestamp)
    {
        this.email_ID=email_ID;
        this.movie_ID=movie_ID;
        this.timestamp=timestamp;
    }

    public String getEmail_ID() {
        return email_ID;
    }

    public void setEmail_ID(String email_ID) {
        this.email_ID = email_ID;
    }

    public int getMovie_ID() {
        return movie_ID;
    }

    public void setMovie_ID(int movie_ID) {
        this.movie_ID = movie_ID;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompositeKeyUserReview)) return false;
        CompositeKeyUserReview that = (CompositeKeyUserReview) o;
        return Objects.equals(getEmail_ID(), that.getEmail_ID()) &&
                Objects.equals(getMovie_ID(), that.getMovie_ID()) &&
                Objects.equals(getTimestamp(), that.getTimestamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail_ID(), getMovie_ID(),getTimestamp());
    }
}
