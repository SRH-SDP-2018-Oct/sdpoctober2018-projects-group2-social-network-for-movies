package com.SNM.app.pojo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "languagelist")
public class LanguageList {
    @Id
    CompositeKeyLanguage compositeKeyLanguage;

    public CompositeKeyLanguage getCompositeKeyLanguage() {
        return compositeKeyLanguage;
    }

    public void setCompositeKeyLanguage(CompositeKeyLanguage compositeKeyLanguage) {
        this.compositeKeyLanguage = compositeKeyLanguage;
    }
}
