package com.SNM.app.fetchdetails;

import com.SNM.app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class getMoviesGenre {

    private Session sessionObj;
    private SessionFactory sessionFactoryObj;
    private HibernateUtil hibernateUtil = new HibernateUtil();
    private String genre;
    public getMoviesGenre(String genreofchoice) {
        this.genre= genreofchoice;
        fetchMoviesGenre();
    }


    public void fetchMoviesGenre(){
        try {
            sessionObj = hibernateUtil.buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            String sql ="select distinct m.movie_name from moviedetail m join genrelist g on g.genre= :genre and g.movie_ID= m.movie_ID";
            List list = sessionObj.createSQLQuery(sql).setParameter("genre",genre).list();
            System.out.println("list: " + list);
            for (Object aList : list) {
                System.out.println(aList);
            }
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
