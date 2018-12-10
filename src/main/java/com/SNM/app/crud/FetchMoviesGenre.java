package com.SNM.app.crud;

import com.SNM.app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Scanner;

public class FetchMoviesGenre {

    private Session sessionObj;
    private HibernateUtil hibernateUtil = new HibernateUtil();
    private String genre;
    public FetchMoviesGenre(String genreofchoice)
    {
        this.genre= genreofchoice;
        fetchMoviesGenre();
    }

    String search;
    public void fetchMoviesGenre(){
        try {
            sessionObj = hibernateUtil.buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            String sql ="select distinct m.movie_name from moviedetail m join genrelist g on g.genre= :genre and g.movie_ID= m.movie_ID";
            List list = sessionObj.createSQLQuery(sql).setParameter("genre",genre).list();
            for (Object aList : list) {
                System.out.println(aList);
            }
            sessionObj.getTransaction().commit();
            System.out.println("Enter the movie of your choice;");
            Scanner input = new Scanner(System.in);
            search = input.nextLine();
            new FetchMovieSearch(search);
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
    }

}
