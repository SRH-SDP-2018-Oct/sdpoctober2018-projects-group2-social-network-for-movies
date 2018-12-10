package com.SNM.app.userinput;

import com.SNM.app.validations.PasswordHashTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExistingUserTest {
    public ExistingUserTest() {
        enterEmail();
    }

    public static String emailID;
    String hashPasswordDb,hashPassword;
    private String password;
    private String userPw;
    PasswordHashTest passwordHashTest = new PasswordHashTest();
    @Test
    public void enterEmail() {
        emailID = "test@test.com";
        getDetails();
        enterPassword();
    }

    @Test
    public void enterPassword() {
        this.userPw = "password";
        this.hashPassword=passwordHashTest.HashPassword(userPw);
        //change to hash pw and compare
        assertEquals(hashPasswordDb,hashPassword);
        try {
            HomePageTest h = new HomePageTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getDetails() {
        //fetch email Id corresponding hash pw from db
        this.password = "password";
        this.hashPasswordDb=passwordHashTest.HashPassword(password);
    }
}