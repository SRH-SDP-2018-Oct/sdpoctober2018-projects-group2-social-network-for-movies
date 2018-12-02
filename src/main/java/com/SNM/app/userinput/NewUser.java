package com.SNM.app.userinput;

import com.SNM.app.databasedetails.InserUserDetails;
import com.SNM.app.validations.CredentialsValidation;
import java.util.Scanner;


public class NewUser extends InserUserDetails
{
    String username,first_name,last_name,email_ID,date;
    String password;
    int age;


    Scanner userinput = new Scanner(System.in);

    public NewUser()
    {

        System.out.println("Welcome !! Register and experience the best");

        System.out.println("Enter your First Name");
        this.first_name = userinput.nextLine();
        System.out.println("Enter your Last Name");
        this.last_name = userinput.nextLine();
        this.enterEmailID();
        System.out.println("Enter DOB (DD/MM/YY): ");
        date = userinput.next();
        System.out.println("Enter your age");
        this.age = userinput.nextInt();
        int num1 = (Integer.parseInt(date.substring(0,2))+Integer.parseInt(date.substring(3,5))/Integer.parseInt(date.substring(7)));
        //day + month / year in order to give unique digit

        int num2 = Integer.parseInt(date.substring(1,2));
        //to ensure username is unique

        username = last_name.substring(0,(last_name.length()-1)) + first_name.charAt(0) + num1 + num2;
        System.out.println("Your Username Is: " + username);

        addUser(username,first_name,last_name,age,email_ID,password);
    }

    public NewUser(String first_name, String last_name, String email_ID, String password,String uname)
    {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email_ID = email_ID;
        this.password = password;
        this.username=uname;
        this.enterEmailID();
    }

    public void enterEmailID()
        {
            NewUser reference = this;
            Scanner userinput = new Scanner(System.in);
            System.out.println("Enter your EmailID");
            String email_ID = userinput.nextLine();
            CredentialsValidation object3 = new CredentialsValidation(email_ID, reference);
        }


}
