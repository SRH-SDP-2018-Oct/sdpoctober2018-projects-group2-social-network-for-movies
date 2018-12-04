package com.SNM.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "genrelist")
public class GenreList
{
    @Id
    @Column(name = "genre")
    private String genre;

    @Column(name = "movie_ID")
    private int movie_ID;

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public int getMovie_ID()
    {
        return movie_ID;
    }

    public void setMovie_ID(int movie_ID)
    {
        this.movie_ID = movie_ID;
    }
}
