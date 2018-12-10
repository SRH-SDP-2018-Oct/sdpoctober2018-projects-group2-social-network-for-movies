package com.SNM.app.userinput;

import com.SNM.app.crud.FetchWatchList;
import com.SNM.app.crud.InsertUserReviews;
import com.SNM.app.pojo.UserProfile;
import com.SNM.app.utils.HibernateUtil;
import com.SNM.app.validations.PasswordHash;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

//import com.SNM.app.crud.InsertUserReviews;

public class ExistingUser
{
    public static String emailID;
    private String password,hashPasswordDb,hashPassword;
    private Session sessionObj;
    private SessionFactory sessionFactoryObj;
    public HibernateUtil hibernateUtil = new HibernateUtil();
    PasswordHash passwordhash = new PasswordHash();


    public ExistingUser() {
        this.enterEmail();
    }

    public void enterEmail(){
        Scanner useremailID = new Scanner(System.in);
        System.out.println("Enter your email-ID to login :");
        this.emailID = useremailID.next();
        this.getDetails();
        this.enterPassword();

    }

    int countDown =2;
public void enterPassword(){
    Scanner useremailID = new Scanner(System.in);
    System.out.println("Enter your password :");
    this.password = useremailID.next();
    System.out.println(password );
    hashPassword = passwordhash.HashPassword(password);
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
            HomePage homePage = new HomePage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
    public void getDetails()
    {
        UserProfile userprofile;
        try {
            sessionObj = hibernateUtil.buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            String hql = "FROM UserProfile userprofile WHERE userprofile.email_ID= :email_ID";
            Query query = sessionObj.createQuery(hql).setParameter("email_ID", emailID);
            List results = query.list();
            if (results.isEmpty())
            {
                System.out.println("Email ID not found!!Please try again:");
//                System.exit(-2);
                this.enterEmail();
            }
            for (Object aList : results)
            {
                userprofile = (UserProfile) aList;
                this.hashPasswordDb = userprofile.getPassword();
                System.out.println(hashPasswordDb);
                FetchWatchList watchList = FetchWatchList.getFetchWatchListInstance();
                watchList.setemail_ID(userprofile.getEmail_ID());
                InsertUserReviews.email_ID=userprofile.getEmail_ID();
            }
            //sessionObj.getTransaction().commit();
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
