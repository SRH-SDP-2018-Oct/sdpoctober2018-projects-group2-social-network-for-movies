package com.SNM.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "moviedetail")

public class MovieDetails {
    @Id

    @Column(name = "movie_ID")
    private int movie_ID;
    @Column(name = "movie_name")
    private String movie_name;
    @Column (name = "description")
    private String description;
    @Column(name = "cast_and_crew")
    private String cast_and_crew;
    @Column(name = "user_rating")
    private String user_rating;
    @Column(name = "critics_review")
    private String critics_review;
    @Column(name = "release_details")
    private String release_details;
    @Column(name = "censorboard_ratings")
    private String censorboard_ratings;

    public int getMovie_ID() {
        return movie_ID;
    }

    public void setMovie_ID(int movie_ID) {
        this.movie_ID = movie_ID;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCast_and_crew() {
        return cast_and_crew;
    }

    public void setCast_and_crew(String cast_and_crew) {
        this.cast_and_crew = cast_and_crew;
    }

    public String getUser_rating() {
        return user_rating;
    }

    public void setUser_rating(String user_rating) {
        this.user_rating = user_rating;
    }

    public String getCritics_review() {
        return critics_review;
    }

    public void setCritics_review(String critics_review) {
        this.critics_review = critics_review;
    }

    public String getRelease_details() {
        return release_details;
    }

    public void setRelease_details(String release_details) {
        this.release_details = release_details;
    }

    public String getCensorboard_ratings() {
        return censorboard_ratings;
    }

    public void setCensorboard_ratings(String censorboard_ratings) {
        this.censorboard_ratings = censorboard_ratings;
    }
}
