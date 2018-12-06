package com.SNM.app.crud;

import com.SNM.app.pojo.CompositeKeyUserReview;
import com.SNM.app.pojo.UserReview;
import org.hibernate.Session;
import com.SNM.app.utils.HibernateUtil;
import org.hibernate.exception.ConstraintViolationException;
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
        UserReview userReview;

        try
        {
            sessionObj = hibernateUtil.buildSessionFactory().openSession();
            sessionObj.beginTransaction();

            String sql = ":FROM UserReview userReview where userReview.movie_ID=:movie_ID";
            List list = sessionObj.createSQLQuery(sql).setParameter("movie_ID", movie_ID).list();
            System.out.println("list: " + list);
            for (Object aList : list)
            {
                System.out.println(aList);

            }
            sessionObj.getTransaction().commit();
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
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
        } catch (ConstraintViolationException sqlException) {
            System.out.println("Movie already in your watchlist");
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