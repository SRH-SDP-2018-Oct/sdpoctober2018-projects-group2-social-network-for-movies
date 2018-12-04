package com.SNM.app.pojo;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CompositeKeyLanguage implements Serializable {

     private String language;
     private int movie_ID;

    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public int getMovie_ID() {
        return movie_ID;
    }
    public void setMovie_ID(int movie_ID) {
        this.movie_ID = movie_ID;
    }
}
