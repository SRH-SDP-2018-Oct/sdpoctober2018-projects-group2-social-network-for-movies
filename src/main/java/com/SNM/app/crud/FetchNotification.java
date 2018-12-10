package com.SNM.app.crud;

import com.SNM.app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FetchNotification {

    private String email;
    private Session sessionob;
   private HibernateUtil hibernateUtil = new HibernateUtil();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate now = LocalDate.now();
    LocalDate weekAgo = LocalDate.now().minusDays(7);
    LocalDate thirtyDaysAgo = LocalDate.now().minusDays(30);
    LocalDate nextweek = LocalDate.now().plusDays(7);
    LocalDate nextMonth = LocalDate.now().plusDays(30);

    public FetchNotification(String email) {
        this.email = email;
        System.out.println(email);
    }

    public void getPastWeek()
    {
        System.out.println("Last week");
        try
        {
            sessionob = hibernateUtil.buildSessionFactory().openSession();
            sessionob.beginTransaction();
            String sql = "SELECT distinct movie_name FROM SNM_Final.genrelist g ,SNM_Final.preferences p,SNM_Final.moviedetail m where p.genre = g.genre and g.movie_ID= m.movie_ID and m.releasedate between :weekAgo and :now and p.email_ID = :email";
            Query query = sessionob.createSQLQuery(sql).setParameter("now", now).setParameter("weekAgo",weekAgo).setParameter("email",this.email);
            List results = query.list();
            System.out.println(results);
            for (Object aList : results) {
                System.out.println(aList);
            }
            sessionob.getTransaction().commit();
        }

        catch(Exception sqlException) {
            if(null != sessionob.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionob.getTransaction().rollback();}

            sqlException.printStackTrace();
        } finally {
            if(sessionob != null) {
                sessionob.close();
            }
        }
    }

    public void getPast30days()
    {
        System.out.println("Last month");
        try
        {
            sessionob = hibernateUtil.buildSessionFactory().openSession();
            sessionob.beginTransaction();
            String sql = "SELECT distinct movie_name FROM SNM_Final.genrelist g ,SNM_Final.preferences p,SNM_Final.moviedetail m where p.genre = g.genre and g.movie_ID= m.movie_ID and m.releasedate between :thirtyDaysAgo and :now and p.email_ID = :email";
            Query query = sessionob.createSQLQuery(sql).setParameter("now", now).setParameter("thirtyDaysAgo",thirtyDaysAgo).setParameter("email",email);
            List results = query.list();
            System.out.println(results);
            for (Object aList : results) {
                System.out.println(aList);
            }
            sessionob.getTransaction().commit();
        }

        catch(Exception sqlException) {
            if(null != sessionob.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionob.getTransaction().rollback();}

            sqlException.printStackTrace();
        } finally {
            if(sessionob != null) {
                sessionob.close();
            }
        }
    }

    public void getNextweek()
    {
        System.out.println("Next week");
        //System.out.println(nextweek);
        //System.out.println();
        try
        {
            sessionob = hibernateUtil.buildSessionFactory().openSession();
            sessionob.beginTransaction();
            String sql = "SELECT distinct movie_name FROM genrelist g ,preferences p, moviedetail m where p.genre = g.genre and g.movie_ID= m.movie_ID and m.releasedate between :now and :nextweek and p.email_ID = :email";
            Query query = sessionob.createSQLQuery(sql).setParameter("now", now).setParameter("nextweek",nextweek).setParameter("email",email);
            List results = query.list();
            System.out.println(results);
            for (Object aList : results) {
                System.out.println(aList);
            }
            sessionob.getTransaction().commit();
        }
        catch(Exception sqlException) {
            if(null != sessionob.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionob.getTransaction().rollback();}

            sqlException.printStackTrace();
        } finally {
            if(sessionob != null) {
                sessionob.close();
            }
        }
    }
    public void getNextMonth()
    {
        System.out.println("Next Month");

        try
        {
            sessionob = hibernateUtil.buildSessionFactory().openSession();
            sessionob.beginTransaction();
            String sql = "SELECT distinct movie_name FROM genrelist g ,preferences p, moviedetail m where p.genre = g.genre and g.movie_ID= m.movie_ID and m.releasedate between :now and :nextMonth and p.email_ID = :email";
            Query query = sessionob.createSQLQuery(sql).setParameter("now", now).setParameter("nextMonth",nextMonth).setParameter("email",email);
            List results = query.list();
            System.out.println(results);
            for (Object aList : results) {
                System.out.println(aList);
            }
            sessionob.getTransaction().commit();
        }
        catch(Exception sqlException) {
            if(null != sessionob.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionob.getTransaction().rollback();}
            sqlException.printStackTrace();
        } finally {
            if(sessionob != null) {
                sessionob.close();
            }
        }
    }

}
