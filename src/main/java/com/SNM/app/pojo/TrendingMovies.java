package com.SNM.app.pojo;

import javax.persistence.*;

@Entity
@Table(name = "trendingmovies")
public class TrendingMovies
{
    @Id
    @GeneratedValue
    @Column(name = "sl_no")
    private int sl_no;
    @Column(name = "movie_name")
    private String movie_name;

    public int getSl_no() {
        return sl_no;
    }
    public void setSl_no(int sl_no) {
        this.sl_no = sl_no;
    }
    public String getmovie_name() {
        return movie_name;
    }
    public void setmovie_name(String movie_ID) {
        this.movie_name = movie_name;
    }
}
