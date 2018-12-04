package com.SNM.app.pojo;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "languagelist")
public class LanguageList {
    @Id
    CompositekeyLang compositekeyLang;
    @OneToMany(cascade=CascadeType.ALL)

    @JoinColumns({
            @JoinColumn(name="language"),
            @JoinColumn(name = "movie_ID")
    })
    private Set<MovieDetails> movies;
    public Set<MovieDetails> getMovies() { return movies; }
    public void setMovies(Set<MovieDetails> movies) { this.movies = movies; }

    public CompositekeyLang getCompositekeyLang() {return compositekeyLang;}
    public void setCompositekeyLang(CompositekeyLang compositekeyLang) {this.compositekeyLang = compositekeyLang;}
}
