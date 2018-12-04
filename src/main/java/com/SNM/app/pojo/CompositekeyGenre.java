package com.SNM.app.pojo;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CompositekeyGenre implements Serializable {

    private String genre;
    private int movie_ID;

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre;}
    public int getMovie_ID() { return movie_ID; }
    public void setMovie_ID(int movie_ID) {this.movie_ID = movie_ID;}
}
