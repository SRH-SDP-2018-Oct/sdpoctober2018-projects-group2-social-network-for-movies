package com.SNM.app.userinput;

import com.SNM.app.validations.CredentialsValidation;
import java.util.Scanner;


public class NewUser
{
    String first_name,last_name,email_ID;
    String password;
    String membership_ID;


    public NewUser()
    {

        System.out.println("Welcome !! Register and experience the best");
        Scanner userinput = new Scanner(System.in);
        System.out.println("Enter your First Name");
        this.first_name = userinput.nextLine();
        System.out.println("Enter your Last Name");
        this.last_name = userinput.nextLine();
        this.enterEmailID();
    }

    public NewUser(String first_name, String last_name, String email_ID, String password,String membership_ID)
    {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email_ID = email_ID;
        this.password = password;
        this.membership_ID=membership_ID;
        this.enterEmailID();
    }

    public void enterEmailID()
        {
            NewUser ref = this;
            Scanner userinput = new Scanner(System.in);
            System.out.println("Enter your EmailID");
            String email_ID = userinput.nextLine();
            CredentialsValidation object3 = new CredentialsValidation(email_ID, ref);
        }

}
