package com.SNM.app.pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "languagelist")
public class LanguageList {
    @Id
    @Column(name = "language")
    private String language;
    @Column(name = "movies")
    private String movies;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getMovies() {
        return movies;
    }

    public void setMovies(String movies) {
        this.movies = movies;
    }
}
