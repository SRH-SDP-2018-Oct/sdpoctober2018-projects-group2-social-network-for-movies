package com.SNM.app.crud;

import com.SNM.app.pojo.CompositeKeyWatchList;
import com.SNM.app.pojo.Watchlist;
import com.SNM.app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;

import java.util.List;

public class FetchWatchList

{
    private Session sessionObj;
    private SessionFactory sessionFactoryObj;
    HibernateUtil hibernateUtil = new HibernateUtil();
    private static FetchWatchList fetchWatchList;
    private static String email_ID,movie_ID;

    private FetchWatchList() {
    }

    public static FetchWatchList getFetchWatchListInstance()
    {
        if(fetchWatchList == null)
        {
            fetchWatchList = new FetchWatchList();

        }
        return fetchWatchList;
    }
    public static void setemail_ID(String email){
        email_ID = email;
    }

    public void fetchWatchList()
    {
        Watchlist watchlist=new Watchlist();

        try
        {
            sessionObj = hibernateUtil.buildSessionFactory().openSession();
            sessionObj.beginTransaction();

            String sql ="select distinct m.movie_name from moviedetail m join watchlist w on w.email_ID= :email and w.movie_ID= m.movie_ID";
            List list = sessionObj.createSQLQuery(sql).setParameter("email",email_ID).list();
            System.out.println("list: " + list);
            for (Object aList : list)
            {
                System.out.println(aList);
            }
            sessionObj.getTransaction().commit();
        }

        catch(Exception sqlException)
        {
            if(null != sessionObj.getTransaction())
            {
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

    public void setWatchlist(int movieID)
    {
        Watchlist addtolist = new Watchlist();

        try
        {
            sessionObj = hibernateUtil.buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            addtolist.setCompositeKeyWatchList(new CompositeKeyWatchList(email_ID,movieID));
            sessionObj.save(addtolist);
            sessionObj.flush();
            sessionObj.getTransaction().commit();
            System.out.println("Movie added to your watchlist");

        }

        catch(ConstraintViolationException sqlException)
        {
            System.out.println("Movie already in your watchlist");
        }
        catch(Exception sqlException) {
            if(null != sessionObj.getTransaction())
        {
            System.out.println("Movie already in your watchlist");
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
