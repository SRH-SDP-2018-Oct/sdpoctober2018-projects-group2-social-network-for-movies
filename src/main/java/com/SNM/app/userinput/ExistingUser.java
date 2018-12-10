package com.SNM.app.userinput;

import com.SNM.app.crud.FetchWatchList;
import com.SNM.app.crud.InsertUserReviews;
import com.SNM.app.pojo.UserProfile;
import com.SNM.app.utils.HibernateUtil;
import com.SNM.app.validations.PasswordHash;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

//import com.SNM.app.crud.InsertUserReviews;

public class ExistingUser
{
    public static String emailID;
    private String hashPasswordDb;
    private Session sessionObj;
    public HibernateUtil hibernateUtil = new HibernateUtil();
    private PasswordHash passwordhash = new PasswordHash();


    public ExistingUser() {
        this.enterEmail();
    }

    private void enterEmail(){
        Scanner useremailID = new Scanner(System.in);
        System.out.println("Enter your email-ID to login :");
        emailID = useremailID.next();
        this.getDetails();
        this.enterPassword();

    }

    private int countDown =2;
private void enterPassword(){
    Scanner useremailID = new Scanner(System.in);
    System.out.println("Enter your password :");
    String password = useremailID.next();
    System.out.println(password);
    String hashPassword = passwordhash.HashPassword(password);
    System.out.println(hashPassword);
    if (!(hashPasswordDb.equals(hashPassword)) ) {
        if(countDown == 0){
            System.out.println("Authentication failed, Please contact your admin!");
            System.exit(-2);
        }
        System.out.println("Authentication failed. Please try again you have "+ this.countDown +" more chances:");
        countDown--;
        enterPassword();
    } else {
        System.out.println("Login Successful!");
        try {
            new HomePage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
    public void getDetails()
    {
        UserProfile userprofile;
        try {
            sessionObj = HibernateUtil.buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            String hql = "FROM UserProfile userprofile WHERE userprofile.email_ID= :email_ID";
            Query query = sessionObj.createQuery(hql).setParameter("email_ID", emailID);
            List results = query.list();
            if (results.isEmpty())
            {
                System.out.println("Email ID not found!!Please try again:");
                this.enterEmail();
            }
            for (Object aList : results)
            {
                userprofile = (UserProfile) aList;
                this.hashPasswordDb = userprofile.getPassword();
                System.out.println(hashPasswordDb);
                FetchWatchList.getFetchWatchListInstance();
                FetchWatchList.setemail_ID(userprofile.getEmail_ID());
                InsertUserReviews.email_ID=userprofile.getEmail_ID();
            }

        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
    }

}
