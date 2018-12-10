package com.SNM.app.main;

import com.SNM.app.userinput.ExistingUser;
import com.SNM.app.userinput.NewUser;

import java.util.Scanner;

public class ImplementSNM {
    public static void main(String[] args)
    {
        System.out.println("........................................\n");
        System.out.println("       Social Network for Movies        \n");
        System.out.println("........................................\n");
        appStart();
    }
    private static void appStart()
    {
        Scanner userinput = new Scanner(System.in);
        System.out.println("Select an option:\n1. For Existing User\n2. For New User");
        String choice = userinput.next();
        switch (choice) {
            case "2":
                new NewUser();
                break;
            case "1":
                new ExistingUser();
                break;
            default:
                appStart();
                break;
        }
    }
}