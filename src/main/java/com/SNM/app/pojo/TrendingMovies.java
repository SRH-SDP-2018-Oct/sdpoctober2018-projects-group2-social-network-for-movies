package com.SNM.app.pojo;
import javax.persistence.*;
@Entity
@Table(name = "trendingmovies")
public class TrendingMovies {

    @Id
    @GeneratedValue
    @Column(name = "sl_no")
    private int sl_no;
    @Column(name = "movie_ID")
    private String movie_ID;

    public int getSl_no() {
        return sl_no;
    }

    public void setSl_no(int sl_no) {
        this.sl_no = sl_no;
    }

    public String getMovie_ID() {
        return movie_ID;
    }

    public void setMovie_ID(String movie_ID) {
        this.movie_ID = movie_ID;
    }
}
