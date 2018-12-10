package com.SNM.app.crud;
import com.SNM.app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class FetchMoviesLanguageTest {
    private Session sessionObj;
    private SessionFactory sessionFactoryObj;
    HibernateUtil hibernateUtil = new HibernateUtil();
    private String language;

    public void FetchMoviesLanguage() {
        this.language = "ka";
        fetchMoviesLanguage();
    }
    @Test
    public void fetchMoviesLanguage() {
        try {
            sessionObj = hibernateUtil.buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            String sql = "select distinct m.movie_name from moviedetail m join languagelist l on l.language= :lang and l.movie_ID= m.movie_ID";
            List list = sessionObj.createSQLQuery(sql).setParameter("lang", "ka").list();
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