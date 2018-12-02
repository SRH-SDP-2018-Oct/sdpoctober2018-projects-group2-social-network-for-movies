package com.SNM.app.databasedetails;

import com.SNM.app.pojo.UserProfile;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.SessionFactory;


public class InserUserDetails

{
    SessionFactory factory;

    public void addUser(String username, String firstname, String lastname, int age, String emailID, String password )

    {
        Session session = factory.openSession();
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
