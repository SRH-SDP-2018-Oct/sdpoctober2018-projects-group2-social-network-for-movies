package com.SNM.app.crud;

import com.SNM.app.pojo.TrendingMovies;
import com.SNM.app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class FetchTrendingMovies {

    private Session sessionObj;
    private SessionFactory sessionFactoryObj;
    private HibernateUtil hibernateUtil = new HibernateUtil();

    public void fetchTrendingMovies() {
        try {
            TrendingMovies t;
            sessionObj = hibernateUtil.buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            String sql = "FROM TrendingMovies";
            List list = sessionObj.createQuery(sql).list();
            System.out.println("list: " + list);
            for (Object aList : list) {
                t = (TrendingMovies)aList;
                System.out.println("Rank:"+t.getSl_no()+"\t\t"+"Movie Name:"+t.getmovie_name());
            }
            sessionObj.getTransaction().commit();
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
