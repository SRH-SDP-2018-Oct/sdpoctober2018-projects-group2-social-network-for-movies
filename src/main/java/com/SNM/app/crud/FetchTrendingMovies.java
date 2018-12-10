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
            String sql = "select  movie_name from moviedetail order by rating/ratecount desc,ratecount desc limit 10";
            List list = sessionObj.createSQLQuery(sql).list();
            System.out.println("list: " + list);
            int i=1;
            for (Object aList : list) {
                String str = (String) aList;
                System.out.println("Rank:"+i+"\t\t"+"Movie Name:"+str);
                i++;
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
