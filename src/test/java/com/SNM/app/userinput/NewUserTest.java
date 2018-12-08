package com.SNM.app.userinput;

import org.junit.Test;
import java.lang.String;

import static org.junit.Assert.*;

public class NewUserTest {

    @Test
    public void enterEmailID() {

    }

    @Test
    public void enterPassword() {
        String password=" ";
        String confirmPassword=" ";
        assertEquals("Passwords must be similar",password,confirmPassword);
    }

    @Test
    public void pwdLength(){
        String pwd="abcdefghi";
        boolean res = pwd.length()>8 ? true:false;
        assertTrue("Check if there are 8 characters", res);

        }


    }
