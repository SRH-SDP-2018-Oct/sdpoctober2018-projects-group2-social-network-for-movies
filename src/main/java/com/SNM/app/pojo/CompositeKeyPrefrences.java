package com.SNM.app.pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CompositeKeyPrefrences implements Serializable {

    @Column(name = "email_ID")
    private String email_ID;
    @Column(name = "genre")
    private String genre;

    public CompositeKeyPrefrences(){}
    public CompositeKeyPrefrences(String email_ID, String genre)
    {this.email_ID=email_ID;
     this.genre = genre;
    }
    public String getEmail_ID() {
        return email_ID;
    }

    public void setEmail_ID(String email_ID) {
        this.email_ID = email_ID;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompositeKeyPrefrences)) return false;
        CompositeKeyPrefrences that = (CompositeKeyPrefrences) o;
        return Objects.equals(getEmail_ID(), that.getEmail_ID()) &&
                Objects.equals(getGenre(), that.getGenre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail_ID(), getGenre());
    }
}
