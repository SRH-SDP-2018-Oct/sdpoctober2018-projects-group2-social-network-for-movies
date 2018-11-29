package com.SNM.app.main;

import com.SNM.app.fetchdetails.FetchDetails;
import com.SNM.app.userinput.*;

import java.util.Scanner;

public class ImplementSNM {

    public static void main(String[] args)

    {

        Scanner userinput=new Scanner(System.in);
        System.out.println("Press : 1 for Existing User.\n 2 for New User");
        int choice = userinput.nextInt();
        if(choice == 2)
        {
            NewUser user1 = new NewUser();
        }
        else
        {
            ExistingUser user2 = new ExistingUser();
        }

    }
}
