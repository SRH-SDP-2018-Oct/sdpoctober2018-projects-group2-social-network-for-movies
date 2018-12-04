package com.SNM.app.validations;

import com.SNM.app.userinput.NewUser;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CredentialsValidation
{
    int random_ID;
    String membership_ID;
    public CredentialsValidation(String input, NewUser ref)
    {
            String regex = "^(.+)@(.+)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            boolean result = matcher.find();
            while (!result)
            {
                System.out.println("Email ID validation failed.Please re-try\n");
                ref.enterEmailID();
            }

            Random r=new Random();
            Scanner logininput =new Scanner(System.in);
            Scanner passwordinput = new Scanner(System.in);
            System.out.println("Enter Password");
            System.out.print("NOTE:The password should be minimum of 8 characters,contain atleast 1 special character,uppercase letter\n");
            String password = passwordinput.next();
            System.out.println("Re-Enter Password to confirm : ");
            String confirm_password = passwordinput.next();
            boolean condition;
            condition = isValid(password);


            while ((!password.equals(confirm_password)) || (!condition))
            {
                System.out.println("Password invalid");
                System.out.print("Please enter the password again :\n");
                password = passwordinput.next();
                System.out.print("Re-Enter Password to confirm :\n");
                confirm_password = passwordinput.next();
                condition = this.isValid(password);

            }

        return;

    }

    public  boolean isValid (String password)
    {
        Boolean atleastOneUpper = false;
        Boolean atleastOneLower = false;
        Boolean atleastOneDigit = false;

        if (password.length() < 8) {
            return false;
        }

        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                atleastOneUpper = true;
            } else if (Character.isLowerCase(password.charAt(i))) {
                atleastOneLower = true;
            } else if (Character.isDigit(password.charAt(i))) {
                atleastOneDigit = true;
            }
        }
        return (atleastOneUpper && atleastOneLower && atleastOneDigit);

    }




}
