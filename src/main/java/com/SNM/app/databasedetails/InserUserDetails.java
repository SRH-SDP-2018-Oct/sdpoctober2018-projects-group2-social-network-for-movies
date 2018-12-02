package com.SNM.app.databasedetails;

import com.SNM.app.pojo.UserProfile;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import com.mysql.cj.xdevapi.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;



public class InserUserDetails
{
    private static final SessionFactory sessionFactory;
    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }


    public void addUser(String username, String firstname, MysqlxDatatypes.Scalar.String lastname, int age, MysqlxDatatypes.Scalar.String emailID, String password )

    {
        Session session = sessionFactory.openSession();
        Transaction tx = null;


        try
        {
            tx = session.beginTransaction();
            UserProfile user = new UserProfile();
            user.setUser_name(username);
           user.setFirst_name(firstname);
           user.setLast_name(lastname);
           user.setAge(age);
            user.setEmail_ID(emailID);
            user.setPassword(password);
            tx.commit();
        } catch (   Exception e) {
            if (tx!=null) tx.rollback();

        } finally {
            session.close();
        }
        System.out.println("your profile is created successfully");
    }

}
