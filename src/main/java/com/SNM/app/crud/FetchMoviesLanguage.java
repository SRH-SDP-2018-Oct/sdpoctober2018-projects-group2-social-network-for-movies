package com.SNM.app.crud;

import com.SNM.app.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

public class FetchMoviesLanguage {

    private Session sessionObj;
    HibernateUtil hibernateUtil = new HibernateUtil();
    private String language;

    public FetchMoviesLanguage(String languageofchoice) {
        this.language = languageofchoice;
        fetchMoviesLanguage();
    }

    public void fetchMoviesLanguage(){

        try {
            sessionObj = hibernateUtil.buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            String sql ="select distinct m.movie_name from moviedetail m join languagelist l on l.language= :lang and l.movie_ID= m.movie_ID";
            List list = sessionObj.createSQLQuery(sql).setParameter("lang", language).list();
            for (Object aList : list) {
                System.out.println(aList);
            }
            System.out.println("Enter the movie of your choice:");
            Scanner input = new Scanner(System.in);
            String search = input.nextLine();
            new FetchMovieSearch(search);
            sessionObj.getTransaction().commit();
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
