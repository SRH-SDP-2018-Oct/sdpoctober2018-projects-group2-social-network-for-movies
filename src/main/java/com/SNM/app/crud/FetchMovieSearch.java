package com.SNM.app.crud;

import com.SNM.app.pojo.MovieDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import com.SNM.app.utils.HibernateUtil;


import java.util.List;
import java.util.Scanner;

public class FetchMovieSearch {
    static Session sessionob;
    static SessionFactory sessionFactoryOb;
    HibernateUtil hibernateUtil=new HibernateUtil();
    Scanner scanner = new Scanner(System.in);
    private int movieID;
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
                movieID = movies.getMovie_ID();
                System.out.println("MovieName\t\t\t:" + movie);
                System.out.println("Description\t\t\t:" + movies.getDescription());
                System.out.println("CastAndCrew\t\t    :" + movies.getCast_and_crew());
                System.out.println("UserRating\t\t    :" + movies.getUser_rating());
                System.out.println("CriticsReview\t\t:" + movies.getCritics_review());
                System.out.println("ReleaseDetails\t\t:" + movies.getRelease_details());
                System.out.println("CensorBoardRating\t:" + movies.getCensorboard_ratings());
                System.out.println("Add to watchlist : Y/N");
                String choice=scanner.next();
                if(choice.equals("Y"))
                {
                    FetchWatchList addwatchlist= FetchWatchList.getFetchWatchListInstance();
                    addwatchlist.setWatchlist(this.movieID);
                }
                else
                    {}
                }
           // sessionob.getTransaction().commit();
        } catch (Exception sqlException) {
//            if (null != sessionob.getTransaction()) {
//                System.out.println("Transaction is being rollback");
//                sessionob.getTransaction().rollback();
//            }
            sqlException.printStackTrace();
        } finally {
            if (sessionob != null){
                sessionob.close();
            }
        }
    }
}
