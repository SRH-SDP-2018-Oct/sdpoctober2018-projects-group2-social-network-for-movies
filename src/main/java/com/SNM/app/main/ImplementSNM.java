package com.SNM.app.main;

import com.SNM.app.userinput.ExistingUser;
import com.SNM.app.userinput.NewUser;
import java.util.Scanner;

public class ImplementSNM {

    public static void main(String[] args)

    {
        System.out.println(".......Social Network for Movies.......\n");
//        UserProfile user = new UserProfile();
        appStart();
    }


    public static void appStart()
    {
        Scanner userinput = new Scanner(System.in);
        System.out.println("Select an option:\n 1. for Existing User.\n 2. for New User");
        String choice = userinput.next();
        if(choice.equals("2"))
        {
            NewUser newuser = new NewUser();
        }
        else if(choice.equals("1"))
        {
            ExistingUser existinguser = new ExistingUser();
        }
        else{
            appStart();
        }
    }
}