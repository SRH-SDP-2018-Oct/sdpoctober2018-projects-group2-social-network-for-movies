package com.SNM.app.pojo;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "genrelist")
public class GenreList
{
    @Id
    CompositeKeyGenre compositekeyGenre;
    @OneToMany(cascade=CascadeType.ALL)

    @JoinColumns({
            @JoinColumn(name="genre"),
            @JoinColumn(name = "movie_ID")
    })
    private Set<MovieDetails> movies;
    public Set<MovieDetails> getMovies() { return movies; }
    public void setMovies(Set<MovieDetails> movies) { this.movies = movies; }

    public CompositeKeyGenre getCompositekeyGenre() { return compositekeyGenre; }
    public void setCompositekeyGenre(CompositeKeyGenre compositekeyGenre) { this.compositekeyGenre = compositekeyGenre;}
}
