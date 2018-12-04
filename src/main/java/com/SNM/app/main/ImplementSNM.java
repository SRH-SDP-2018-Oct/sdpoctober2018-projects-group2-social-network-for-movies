package com.SNM.app.main;

import com.SNM.app.userinput.ExistingUser;
import com.SNM.app.userinput.NewUser;
import com.SNM.app.crud.UserProfile;

import java.util.Scanner;

public class ImplementSNM {

    public static void main(String[] args)

    {
        System.out.println(".......Social Network for Movies.......\n");

        UserProfile user = new UserProfile();
        Scanner userinput=new Scanner(System.in);
        System.out.println("Select an option:\n 1. for Existing User.\n 2. for New User");
        int choice = userinput.nextInt();
        if(choice == 2)
        {
            NewUser newuser = new NewUser();
        }
        else
        {
            ExistingUser user2 = new ExistingUser();
        }
        System.out.println("Ignore");
    }
}