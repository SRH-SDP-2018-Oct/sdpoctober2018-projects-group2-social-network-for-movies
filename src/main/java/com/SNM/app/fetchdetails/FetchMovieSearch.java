package com.SNM.app.fetchdetails;

import com.SNM.app.pojo.MovieDetails;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import com.SNM.app.utils.HibernateUtil;


import java.util.List;

public class FetchMovieSearch {
    static Session sessionob;
    static SessionFactory sessionFactoryOb;
    HibernateUtil hibernateUtil=new HibernateUtil();

    public FetchMovieSearch(String movie_name) {

        fetchMovieDetails(movie_name);
    }


    public void fetchMovieDetails(String movie) {
        MovieDetails movies;
        try {

            sessionob = hibernateUtil.buildSessionFactory().openSession();
            sessionob.beginTransaction();
            String hql = "FROM MovieDetails movies WHERE movies.movie_name= :UserInputMovie";
            Query query = sessionob.createQuery(hql).setParameter("UserInputMovie", movie);
            List results = query.list();
           // System.out.println("list: " + results);
            for (Object aList : results) {
                movies = (MovieDetails) aList;
                System.out.println("movieID:\t" + movies.getMovie_ID());
                System.out.println("moviename:\t" + movies.getMovie_name());
                System.out.println("description:\t" + movies.getDescription());
                System.out.println("castandcrew:\t" + movies.getCast_and_crew());
                System.out.println("userrating:\t" + movies.getUser_rating());
                System.out.println("criticsreview:\t" + movies.getCritics_review());
                System.out.println("releasedetails:\t" + movies.getRelease_details());
                System.out.println("censorboardrating:\t" + movies.getCensorboard_ratings());

            }
            sessionob.getTransaction().commit();
        } catch (Exception sqlException) {
//            if (null != sessionob.getTransaction()) {
//                System.out.println("Transaction is being rollback");
//                sessionob.getTransaction().rollback();
//            }
            sqlException.printStackTrace();
        } finally {
            if (sessionob != null) {
                sessionob.close();
            }
        }
    }
}
