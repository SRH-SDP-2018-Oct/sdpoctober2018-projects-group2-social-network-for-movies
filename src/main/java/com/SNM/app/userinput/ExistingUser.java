package com.SNM.app.userinput;

import com.SNM.app.utils.HibernateUtil;
import com.SNM.app.validations.PasswordHash;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;
import com.SNM.app.pojo.*;

public class ExistingUser
{
    private String emailID,password,hashPasswordDb,hashPassword;
    private Session sessionObj;
    private SessionFactory sessionFactoryObj;
    public HibernateUtil hibernateUtil = new HibernateUtil();
    PasswordHash passwordhash = new PasswordHash();


    public ExistingUser() {

        Scanner useremailID = new Scanner(System.in);
        System.out.println("Enter your EmailID to LogIn");
        this.emailID = useremailID.next();
        this.getDetails();
        System.out.println("Enter the password");
        this.password = useremailID.next();
        System.out.println(password );
        hashPassword = passwordhash.HashPassword(password);
        System.out.println(hashPassword);
        if (!(hashPasswordDb.equals(hashPassword)) ) {
            System.out.println("Authentication failed.");
        } else {
            System.out.println("Successfully LoggedIn");
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
                System.exit(-2);
            }
            for (Object aList : results)
            {
                userprofile = (UserProfile) aList;
                this.hashPasswordDb = userprofile.getPassword();
                System.out.println(hashPasswordDb);
            }
            sessionObj.getTransaction().commit();
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
