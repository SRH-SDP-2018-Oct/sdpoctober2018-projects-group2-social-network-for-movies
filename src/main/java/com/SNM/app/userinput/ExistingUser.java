package com.SNM.app.userinput;

import java.util.Scanner;

public class ExistingUser
{
    public ExistingUser()
    {
        Scanner useremailID=new Scanner(System.in);
        System.out.println("Enter EmailID to LogIn");
        String email_ID=useremailID.next();
        System.out.println("Enter the password");
        String password=useremailID.next();
        HomePage userview=new HomePage();
    }

//check from db whether password matches or not;if not then pop the message and redirect to homepage
}
