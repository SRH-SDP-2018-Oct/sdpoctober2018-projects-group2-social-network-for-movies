package com.SNM.app.userinput;

import com.SNM.app.validations.PasswordHash;
import com.SNM.app.crud.UserProfile;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class NewUser
{
    private String first_name,last_name,email_ID;
    private String password,hashPassword;
    private int age;
    private SetPreferences setPreferences = new SetPreferences();

    private Scanner userinput = new Scanner(System.in);

    public NewUser()
    {
        PasswordHash hash= new PasswordHash();
        UserProfile user = new UserProfile();
        System.out.println("Welcome ! Register and experience the best");
        System.out.println("Enter your First Name : ");
        this.first_name = userinput.nextLine();
        System.out.println("Enter your Last Name : ");
        this.last_name = userinput.nextLine();
        this.enterEmailID();
        this.userPrefrence();
        this.password = enterPassword();
        this.hashPassword= hash.HashPassword(password);
        System.out.println("Enter your age : ");
        this.age = userinput.nextInt();
        user.setUserDetails(email_ID,first_name,last_name,hashPassword,age);
        System.out.println("User registration successful ! Please login with your email-id and password\n");
        new ExistingUser();
        System.exit(0);

    }

    public void userPrefrence(){

        System.out.println("Enter preferred Genre:\nAction\nAdventure\nBiography\nComedy\nCrime\nDrama\nFamily\nFantasy\nHistory\nRomance\nSport\nWar\nor 0 to finish choices");
        String preferdGenre = userinput.next();
        if(!(preferdGenre.equals("0"))){
            setPreferences.setPreference(preferdGenre,this.email_ID);
            userPrefrence();
        }

    }

    public void enterEmailID() {
        Scanner userinput = new Scanner(System.in);
        System.out.println("Enter your EmailID");
        this.email_ID = userinput.nextLine();
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email_ID);
        boolean result = matcher.find();
        while (!result) {
            System.out.println("Please enter a valid email ID:\n");
            enterEmailID();
        }

    }

    public String enterPassword()
    {
        System.out.println("Enter Password");
        System.out.print("NOTE:The password must be 8 characters long, contain 1 Upper case, 1 number and 1 special character\n");
        String password = userinput.next();
        System.out.println("Confirm password: ");
        String confirm_password = userinput.next();
        boolean condition = isValid(password);
        while ((!password.equals(confirm_password)) || (!condition))
        {
            System.out.println("Password invalid");
            System.out.print("Please enter the password again :\n");
            password = userinput.next();
            System.out.print("Confirm password:\n");
            confirm_password = userinput.next();
            condition = isValid(password);
        }
        return password;
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
