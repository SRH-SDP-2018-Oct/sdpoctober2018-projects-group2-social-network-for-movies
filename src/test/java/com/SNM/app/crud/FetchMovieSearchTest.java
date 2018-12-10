package com.SNM.app.crud;

import com.SNM.app.pojo.MovieDetails;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FetchMovieSearchTest {


    @Test
    public void testFetchMovieDetails() {
        MovieDetails mv=new MovieDetails();
        int movie_id=1, censorBoardRatings=4, rating=3,rateCount=1;
        String movieDescription="Bahubali-- Is a movie based on History";
        Assert.assertNotEquals("Movie ID display fails:",mv.getMovie_ID(),movie_id);
        Assert.assertNotEquals("movie description",mv.getDescription(),movieDescription);
        Assert.assertEquals("Cast and Crew display",null,mv.getCast_and_crew());
        Assert.assertEquals("Critics Review",null,mv.getCritics_review());
        Assert.assertNotEquals("Censor board Rating method fails",mv.getCensorboard_ratings(),censorBoardRatings);
    }
}