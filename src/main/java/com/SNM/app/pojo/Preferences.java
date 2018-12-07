package com.SNM.app.pojo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "preferences")
public class Preferences {
    @EmbeddedId
    public
    CompositeKeyPrefrences compositeKeyPrefrences;

    public CompositeKeyPrefrences getCompositeKeyPrefrences() {
        return compositeKeyPrefrences;
    }

    public void setCompositeKeyPrefrences(CompositeKeyPrefrences compositeKeyPrefrences) {
        this.compositeKeyPrefrences = compositeKeyPrefrences;
    }
}

