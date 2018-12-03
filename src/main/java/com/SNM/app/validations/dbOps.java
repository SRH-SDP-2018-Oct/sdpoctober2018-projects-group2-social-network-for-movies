package com.SNM.app.validations;

import com.SNM.app.pojo.UserProfile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class dbOps {


    private Session sessionObj;
    private SessionFactory sessionFactoryObj;
    HibernateUtil hibernateUtil = new HibernateUtil();


    public void fetchDetails(String email){
        UserProfile emp;
        try {
            sessionObj = hibernateUtil.buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            String hql = "FROM UserProfile emp WHERE emp.email_ID= :email";
            //String hql = "FROM UserProfile emp";
            Query query = sessionObj.createQuery(hql).setParameter("email", email);
            List results = query.list();
            System.out.println("list: " + results);
            for (Object aList : results)
            {
                emp = (UserProfile) aList;
                System.out.println("Name\t" + emp.getFirst_name());
                System.out.println("Age\t" + emp.getAge());
                System.out.println("Password\t" + emp.getPassword());
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

    public void setUserDetails(String email, String uname, String fname, String lname, String password, int age) {
        UserProfile usr = new UserProfile();
        try {
            sessionObj = hibernateUtil.buildSessionFactory().openSession();
            sessionObj.beginTransaction();

            usr.setAge(25);
            usr.setEmail_ID(email);
            usr.setFirst_name(fname);
            usr.setLast_name(lname);
            usr.setUser_name(uname);
            usr.setPassword(password);

            sessionObj.save(usr);
            sessionObj.flush();

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


