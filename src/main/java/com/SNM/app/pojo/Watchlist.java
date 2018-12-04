package com.SNM.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "watchlist")
public class Watchlist
{

   @Id
   @Column (name = "email_ID")
    private String email_ID;
   @Column (name = "movie_ID")
    private String movie_ID;

    public String getEmail_ID() {
        return email_ID;
    }

    public void setEmail_ID(String email_ID) {
        this.email_ID = email_ID;
    }

    public String getMovie_ID() {
        return movie_ID;
    }

    public void setMovie_ID(String movie_ID) {
        this.movie_ID = movie_ID;
    }
}
