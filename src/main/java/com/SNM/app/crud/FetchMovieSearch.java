package com.SNM.app.crud;

import com.SNM.app.pojo.MovieDetails;
import com.SNM.app.userinput.GlobalSearch;
import com.SNM.app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
public class FetchMovieSearch {
    static Session sessionob;
    static SessionFactory sessionFactoryOb;
    HibernateUtil hibernateUtil=new HibernateUtil();
    Scanner scanner = new Scanner(System.in);
    private int movieID;
    private int movie;
    InsertUserReviews viewreview=new InsertUserReviews();
    public FetchMovieSearch(String movie_name)
    {
        fetchMovieDetails(movie_name);
    }


    public FetchMovieSearch() {
    }

    public void fetchMovieDetails(String movie) {
        MovieDetails movies;
        try {
            String smallLetters = movie.toLowerCase();
            sessionob = hibernateUtil.buildSessionFactory().openSession();
            sessionob.beginTransaction();
            String hql = "FROM MovieDetails movies WHERE movies.movie_name= :UserInputMovie";
            Query query = sessionob.createQuery(hql).setParameter("UserInputMovie", movie);
            List results = query.list();
            if (results.isEmpty())
            {
                System.out.println("Movie not found, please try our global search option");
                new GlobalSearch();
            }
            else{
            for (Object aList : results) {
                movies = (MovieDetails) aList;
                System.out.println("MovieID\t\t\t    :" + movies.getMovie_ID());
                this.movie=movies.getMovie_ID();
                movieID = movies.getMovie_ID();
                System.out.println("MovieName\t\t\t:" + movie);
                System.out.println("Description\t\t\t:" + movies.getDescription());
                System.out.println("CastAndCrew\t\t    :" + movies.getCast_and_crew());
                System.out.println("CriticsReview\t\t:" + movies.getCritics_review());
                System.out.println("ReleaseDetails\t\t:" + movies.getRelease_details());
                System.out.println("CensorBoardRating\t:" + movies.getCensorboard_ratings());
                System.out.println("UserRating\t\t    :" + movies.getRating()/movies.getRatecount());
                System.out.println("No. of people rated:"+movies.getRatecount());
                System.out.println("Genres\t\t\t    :"+movies.getGenres());
                System.out.println("Languages\t\t\t:"+movies.getLanguages());
                String rdate=movies.getReleasedate().toString();
                String[] date = rdate.split(" ");
                System.out.println("ReleaseDate\t\t    :"+date[0]);
            }
            Scanner userchoice= new Scanner(System.in);
            System.out.println("Enter your choice:\n1: Add to watch list\n2: Rate Movie\n3: View Reviews\n4: Give Reviews\n5: Go back to homepage");
            int userChoice=userchoice.nextInt();
            switch(userChoice) {
                case (1):
                    FetchWatchList addwatchlist= FetchWatchList.getFetchWatchListInstance();
                    addwatchlist.setWatchlist(this.movieID);
                    break;
                case (2):
                    rateMovie();
                    break;
                case (3):
                    viewreview.fetchUserReviews(this.movieID);
                    break;
                case(4):
                    Date date= new Date();
                    long time = date.getTime();
                    Timestamp timestamp = new Timestamp(time);
                    System.out.println("Type review");
                    String review=getContent();
                    InsertUserReviews adduserreview=InsertUserReviews.getInsertUserReviewsinstance();
                    adduserreview.setUserReviews(this.movieID,review,timestamp);
                    break;
            }}
        } catch (Exception sqlException) {
            if (null != sessionob.getTransaction()) {
                System.out.println("Transaction is being rollback");

            }
            sqlException.printStackTrace();
        } finally {
            if (sessionob != null){
                sessionob.close();
            }
        }

    }
    public String getContent()
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String content = null;
        try {
            content = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
    private void rateMovie() {

        System.out.println("Enter the value between 0-10:");
        Scanner scanner = new Scanner(System.in);
        float rate = scanner.nextFloat();
        if(rate<0 || rate>10){
            System.out.println("Please enter a valid value");
            rateMovie();
        }
        try {
            sessionob = hibernateUtil.buildSessionFactory().openSession();
            sessionob.beginTransaction();
            String hql1 = "UPDATE moviedetail set rating = rating+ :rate, ratecount = 1+ratecount " +
                    "WHERE movie_ID = :movie_ID";
            Query query1 = sessionob.createSQLQuery(hql1);
            query1.setParameter("rate", rate);
            query1.setParameter("movie_ID", movie);
            int r = query1.executeUpdate();
            if (r>0){
                //System.out.println("rows affected\t" + r);
                System.out.println("Thanks for your rating!!");
            }
            sessionob.getTransaction().commit();
        } catch (Exception sqlException) {
            if (null != sessionob.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionob.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionob != null) {
                sessionob.close();
            }
        }
    }

}