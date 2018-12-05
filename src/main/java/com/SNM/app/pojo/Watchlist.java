package com.SNM.app.pojo;

import javax.persistence.*;

@Entity
@Table(name = "watchlist")
public class Watchlist
{
    @EmbeddedId
   public
   CompositeKeyWatchList compositeKeyWatchList;

    public CompositeKeyWatchList getCompositeKeyWatchList() {
        return compositeKeyWatchList;
    }

    public void setCompositeKeyWatchList(CompositeKeyWatchList compositeKeyWatchList) {
        this.compositeKeyWatchList = compositeKeyWatchList;
    }
//    @EmbeddedId
//    private CompositeKeyWatchList email_ID;
//    private  CompositeKeyWatchList movie_ID;
//
//    public CompositeKeyWatchList getEmail_ID() {
//        return email_ID;
//    }
//
//    public void setEmail_ID(CompositeKeyWatchList email_ID) {
//        this.email_ID = email_ID;
//    }
//
//    public CompositeKeyWatchList getMovie_ID() {
//        return movie_ID;
//    }
//
//    public void setMovie_ID(CompositeKeyWatchList movie_ID) {
//        this.movie_ID = movie_ID;
//    }
}
