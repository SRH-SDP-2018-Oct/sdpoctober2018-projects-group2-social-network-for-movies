package com.SNM.app.fetchdetails;

import com.SNM.app.pojo.LanguageList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import com.SNM.app.sessionconnection.HibernateUtil;

import java.util.List;

public class fetchMoviesLang {

    private Session sessionObj;
    private SessionFactory sessionFactoryObj;
    HibernateUtil hibernateUtil = new HibernateUtil();


    public void fetchMoviesLang(String lang){
        LanguageList l;
        try {
            sessionObj = hibernateUtil.buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            String hql = "FROM LanguageList l WHERE l.compositekeyLang.movie_I D= :movie_ID";
//            String hql = "FROM MovieDetails m JOIN LanguageList l"+
//                    "ON l.movie_ID = m.movie_ID" +
//                    "AND l.language= ka";
            Query query = sessionObj.createQuery(hql).setParameter("lang", lang);
           // Query query = sessionObj.createQuery(hql);
            List results = query.list();
            System.out.println("list: " + results);
            for (Object aList : results)
            {
                l = (LanguageList) aList;
                System.out.println("Language\t" + l.getCompositekeyLang().getLanguage());
                System.out.println("Movie\t" + l.getCompositekeyLang().getMovie_ID());
                //System.out.println("Name\t"+);
            }
            sessionObj.getTransaction().commit();
        } catch(Exception sqlException) {
//            if(null != sessionObj.getTransaction()) {
//                System.out.println("\n.......Transaction Is Being Rolled Back.......");
//                sessionObj.getTransaction().rollback();
//            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
    }

}
