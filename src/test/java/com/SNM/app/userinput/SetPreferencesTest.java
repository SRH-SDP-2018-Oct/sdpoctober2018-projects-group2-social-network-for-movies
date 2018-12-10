package com.SNM.app.userinput;

import com.SNM.app.utils.HibernateUtil;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SetPreferencesTest {

    HibernateUtil hibernateUtil = new HibernateUtil();
    private String email_ID,movie_ID;
@Test
    public void setPreference(String genre, String email)
    {
        email_ID = email;
        assertTrue(!(genre.equals("")));
    }


}