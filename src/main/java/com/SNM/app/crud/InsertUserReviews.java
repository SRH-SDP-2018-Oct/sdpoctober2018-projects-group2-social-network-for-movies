package com.SNM.app.crud;

import com.SNM.app.pojo.CompositeKeyUserReview;
import com.SNM.app.pojo.UserReview;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import com.SNM.app.utils.HibernateUtil;
import java.util.Date;
import java.util.List;

public class InsertUserReviews {
    private Session sessionObj;
    HibernateUtil hibernateUtil = new HibernateUtil();
    private static InsertUserReviews insertUserReviews;
    public static String email_ID;

    public InsertUserReviews() {
    }

    public static InsertUserReviews getInsertUserReviewsinstance()
    {
        if(insertUserReviews == null)
        {
            insertUserReviews = new InsertUserReviews();

        }
        return insertUserReviews;
    }
    public static void setemail_ID(String email){
        email_ID = email;
    }

    public void fetchUserReviews(int movie_ID)
    {
        try
        {
            sessionObj = hibernateUtil.buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            String sql = "Select email_ID,timestamp,review FROM userreview  Where movie_ID = :movie_ID";
            SQLQuery query = sessionObj.createSQLQuery(sql).setParameter("movie_ID", movie_ID);
            List<Object[]> list = (List<Object[]>)query.list();
            for (Object[] aList : list)
            {
                System.out.println((String) aList[0] + "@" + (java.sql.Timestamp)aList[1] + ":\t" +(String)aList[2]);
            }
            sessionObj.getTransaction().commit();
        }
        catch (Exception sqlException)
        {
            if (null != sessionObj.getTransaction())
            {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        }
        finally
        {
            if (sessionObj != null)
            {
                sessionObj.close();
            }
        }
    }
    public void setUserReviews(int movieID, String review, Date timestamp)
    {
        UserReview addreview = new UserReview();

        try {
            sessionObj = hibernateUtil.buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            addreview.setCompositeKeyUserReview(new CompositeKeyUserReview(email_ID, movieID,timestamp));
            addreview.setReview(review);
            sessionObj.save(addreview);
            sessionObj.flush();
            sessionObj.getTransaction().commit();
            System.out.println("Thanks for your review!!");
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }

            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null)
            {
                sessionObj.close();
            }
        }
    }

}