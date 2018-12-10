package com.SNM.app.userinput;

import com.SNM.app.pojo.CompositeKeyPrefrences;
import com.SNM.app.pojo.Preferences;
import com.SNM.app.utils.HibernateUtil;
import org.hibernate.Session;

public class SetPreferences

{
    private Session sessionObj;
    HibernateUtil hibernateUtil = new HibernateUtil();
    private String email_ID;

    public void setPreference(String genre, String email)
    {
        email_ID = email;
        Preferences preferences = new Preferences();

        try
        {
            sessionObj = HibernateUtil.buildSessionFactory().openSession();
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
