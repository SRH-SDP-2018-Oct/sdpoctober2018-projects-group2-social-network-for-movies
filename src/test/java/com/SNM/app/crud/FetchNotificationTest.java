package com.SNM.app.crud;

import com.SNM.app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FetchNotificationTest {

    private String email;
    private Session sessionob;
    private HibernateUtil hibernateUtil = new HibernateUtil();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate now = LocalDate.now();
    LocalDate weekAgo = LocalDate.now().minusDays(7);
    LocalDate thirtyDaysAgo = LocalDate.now().minusDays(30);
    LocalDate nextweek = LocalDate.now().plusDays(7);
    LocalDate nextMonth = LocalDate.now().plusDays(30);

    public void FetchNotification() {
        this.email = "gauri@gmail.com";
        System.out.println(email);
        getPastWeek();
    }
private String lastweekmovie="Kal ho na ho";
    @Test
    public void getPastWeek() {
        System.out.println("Test case for Last week");
        try
        {
            sessionob = hibernateUtil.buildSessionFactory().openSession();
            sessionob.beginTransaction();
            String sql = "SELECT movie_name FROM test.genrelist g ,test.preferences p,test.moviedetail m where p.genre = g.genre and g.movie_ID= m.movie_ID and m.releasedate between :weekAgo and :now and p.email_ID = :email";
            Query query = sessionob.createSQLQuery(sql).setParameter("now", now).setParameter("weekAgo",weekAgo).setParameter("email",this.email);
            List results = query.list();
            sessionob.getTransaction().commit();
            //Assert.assertTrue(!(results.isEmpty()));
            Assert.assertEquals(query,lastweekmovie);
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

    @Test
    public void getPast30days() {

    }

    @Test
    public void getNextweek() {
    }

    @Test
    public void getNextMonth() {
    }
}