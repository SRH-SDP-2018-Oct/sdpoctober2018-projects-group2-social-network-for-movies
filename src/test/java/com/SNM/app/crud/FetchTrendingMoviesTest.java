package com.SNM.app.crud;

import com.SNM.app.pojo.TrendingMovies;
import com.SNM.app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FetchTrendingMoviesTest {

    private Session sessionObj;
    private SessionFactory sessionFactoryObj;
    private HibernateUtil hibernateUtil = new HibernateUtil();
    @Test
    public void fetchTrendingMovies() {
        try {
            TrendingMovies t;
            sessionObj = hibernateUtil.buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            String sql = "select  movie_name from moviedetail order by rating/ratecount desc,ratecount desc limit 10";
            List list = sessionObj.createSQLQuery(sql).list();
            sessionObj.getTransaction().commit();
            Assert.assertTrue(!(list.isEmpty()));
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }
}
