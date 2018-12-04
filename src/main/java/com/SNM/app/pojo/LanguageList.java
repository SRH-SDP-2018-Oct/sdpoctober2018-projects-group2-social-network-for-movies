package com.SNM.app.pojo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "languagelist")
public class LanguageList {
    @Id
    CompositekeyLang compositekeyLang;

    public CompositekeyLang getCompositekeyLang() {
        return compositekeyLang;
    }

    public void setCompositekeyLang(CompositekeyLang compositekeyLang) {
        this.compositekeyLang = compositekeyLang;
    }
}
