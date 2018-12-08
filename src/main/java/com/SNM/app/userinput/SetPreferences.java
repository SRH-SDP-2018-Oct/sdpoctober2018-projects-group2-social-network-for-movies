package com.SNM.app.userinput;

import com.SNM.app.pojo.CompositeKeyPrefrences;
import com.SNM.app.pojo.Preferences;
import com.SNM.app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SetPreferences

{
    private Session sessionObj;
    private SessionFactory sessionFactoryObj;
    HibernateUtil hibernateUtil = new HibernateUtil();
    private String email_ID,movie_ID;

    public void setPreference(String genre, String email)
    {
        email_ID = email;
        Preferences preferences = new Preferences();

        try
        {
            sessionObj = hibernateUtil.buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            preferences.setCompositeKeyPrefrences(new CompositeKeyPrefrences(email_ID,genre));
            sessionObj.save(preferences);
            sessionObj.flush();
            sessionObj.getTransaction().commit();
        }

        catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();}

            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
    }
}
