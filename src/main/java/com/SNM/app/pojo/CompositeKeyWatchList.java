package com.SNM.app.pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class CompositeKeyWatchList implements Serializable{

    @Column(name = "email_ID")
    private String email_ID;
    @Column(name = "movie_ID")
    private int movie_ID;

    public CompositeKeyWatchList(){}
    public CompositeKeyWatchList(String email_ID,int movie_ID)
    {this.email_ID=email_ID;
     this.movie_ID=movie_ID;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompositeKeyWatchList)) return false;
        CompositeKeyWatchList that = (CompositeKeyWatchList) o;
        return Objects.equals(getEmail_ID(), that.getEmail_ID()) &&
                Objects.equals(getMovie_ID(), that.getMovie_ID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail_ID(), getMovie_ID());
    }
}
