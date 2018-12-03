package com.SNM.app.userinput;

import com.SNM.app.validations.HibernateUtil;
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
    PasswordHash ph = new PasswordHash();


    public ExistingUser() {

        Scanner useremailID = new Scanner(System.in);
        System.out.println("Enter EmailID to LogIn");
        this.emailID = useremailID.next();
        this.getDetails();
        System.out.println("Enter the password");
        this.password = useremailID.next();
        System.out.println(password );
        hashPassword = ph.HashPassword(password);
        System.out.println(hashPassword);
        if (!(hashPasswordDb.equals(hashPassword)) ) {
            System.out.println("Authentication failed.");
        } else {
            System.out.println("Done for the day...");
        }
    }
    public void getDetails()
    {
        UserProfile emp;
        try {
            sessionObj = hibernateUtil.buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            String hql = "FROM UserProfile emp WHERE emp.email_ID= :email_ID";
            //String hql = "FROM UserProfile emp";
            Query query = sessionObj.createQuery(hql).setParameter("email_ID", emailID);
            List results = query.list();
            if (results.isEmpty())
            {
                System.out.println("Email ID not found please try again:");
                System.exit(-2);
            }
            for (Object aList : results)
            {
                emp = (UserProfile) aList;
                this.hashPasswordDb = emp.getPassword();
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
