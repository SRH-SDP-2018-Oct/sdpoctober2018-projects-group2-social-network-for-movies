package com.SNM.app.crud;

import com.SNM.app.pojo.MovieDetails;
import com.SNM.app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class FetchMovieSearch {
    static Session sessionob;
    static SessionFactory sessionFactoryOb;
    HibernateUtil hibernateUtil=new HibernateUtil();
    Scanner scanner = new Scanner(System.in);
    private int movieID;
    private int mov;
    public FetchMovieSearch(String movie_name) {


        fetchMovieDetails(movie_name);
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
                System.out.println("Please Enter Valid Movie Name");
                System.out.println("Movie not found, please try again:");
                String mov = scanner.next();
                fetchMovieDetails(mov);
            }
            for (Object aList : results) {
                movies = (MovieDetails) aList;
                System.out.println("MovieID\t\t\t    :" + movies.getMovie_ID());
                this.mov=movies.getMovie_ID();
                movieID = movies.getMovie_ID();
                System.out.println("MovieName\t\t\t:" + movie);
                System.out.println("Description\t\t\t:" + movies.getDescription());
                System.out.println("CastAndCrew\t\t    :" + movies.getCast_and_crew());
                System.out.println("UserRating\t\t    :" + movies.getRating());
                System.out.println("CriticsReview\t\t:" + movies.getCritics_review());
                System.out.println("ReleaseDetails\t\t:" + movies.getRelease_details());
                System.out.println("CensorBoardRating\t:" + movies.getCensorboard_ratings());
                System.out.println("UserRating\t\t    :" + (movies.getRating()/movies.getRatecount()));
                System.out.println("No. of people rated:"+movies.getRatecount());
            }
            Scanner userchoice= new Scanner(System.in);
            System.out.println("Enter your choice:\n1: Add to watch list\n2: Rate Movie");
            int userChoice=userchoice.nextInt();
            switch(userChoice) {
                case (1):
                    FetchWatchList addwatchlist= FetchWatchList.getFetchWatchListInstance();
                    addwatchlist.setWatchlist(this.movieID);
                    break;
                case (2):
                    rateMovie();
                    break;
                default:
                    System.out.println("Application exit");
                    System.exit(0);

            } //sessionob.getTransaction().commit();
        } catch (Exception sqlException) {
            if (null != sessionob.getTransaction()) {
                System.out.println("Transaction is being rollback");
                //sessionob.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionob != null){
                sessionob.close();
            }
        }
    }

    private void rateMovie() {

        System.out.println("Enter the value between 0-5:");
        Scanner scanner = new Scanner(System.in);
        int rate = scanner.nextInt();
        if(rate<0 || rate>5){
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
            query1.setParameter("movie_ID", mov);
            int r = query1.executeUpdate();
            System.out.println("rows affected\t" + r);
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