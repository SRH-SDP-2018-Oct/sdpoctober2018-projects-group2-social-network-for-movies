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
}
