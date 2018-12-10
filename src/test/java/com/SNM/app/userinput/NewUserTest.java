package com.SNM.app.userinput;

import org.junit.Test;
import java.lang.String;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NewUserTest {

    private Scanner userinput = new Scanner(System.in);

    public NewUserTest() {
        enterEmailID();
    }

    @Test
    public void enterEmailID() {
        System.out.println("Enter Password");
        System.out.print("NOTE:The password should be minimum of 8 characters,contain at least 1 special character and 1 uppercase letter\n");
                Scanner mockScanner = mock(Scanner.class);
        //set up the scanner
        when(mockScanner.nextLine()).thenReturn("nithin@gmail.com");

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
