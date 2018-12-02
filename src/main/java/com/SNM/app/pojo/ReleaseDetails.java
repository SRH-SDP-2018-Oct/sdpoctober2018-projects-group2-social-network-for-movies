package com.SNM.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "releasedetail")
public class ReleaseDetails
{
    @Id

    @Column(name = "movie_ID")
    private int movie_ID;
    @Column(name = "releasedetails")
    private String releasedetails;

    public int getMovie_ID() {
        return movie_ID;
    }

    public void setMovie_ID(int movie_ID) {
        this.movie_ID = movie_ID;
    }

    public String getReleasedetails() {
        return releasedetails;
    }

    public void setReleasedetails(String releasedetails) {
        this.releasedetails = releasedetails;
    }
}
