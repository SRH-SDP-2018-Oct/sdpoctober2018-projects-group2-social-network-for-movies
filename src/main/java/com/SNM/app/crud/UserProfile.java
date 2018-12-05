package com.SNM.app.crud;
import com.SNM.app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import java.util.List;

public class UserProfile {
    private Session sessionObj;
    private SessionFactory sessionFactoryObj;
    HibernateUtil hibernateUtil = new HibernateUtil();
    public void fetchDetails(String email)
    {
        com.SNM.app.pojo.UserProfile emp;
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
                emp = (com.SNM.app.pojo.UserProfile) aList;
                System.out.println("Name\t" + emp.getFirst_name());
                System.out.println("Age\t" + emp.getAge());
                System.out.println("Password\t" + emp.getPassword());
            }
            sessionObj.getTransaction().commit();
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction())
            {
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
    public void setUserDetails(String email, String fname, String lname, String password, int age) {
        com.SNM.app.pojo.UserProfile usr = new com.SNM.app.pojo.UserProfile();
        try {
            sessionObj = hibernateUtil.buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            usr.setAge(age);
            usr.setEmail_ID(email);
            usr.setFirst_name(fname);
            usr.setLast_name(lname);
            usr.setPassword(password);
            sessionObj.save(usr);
            sessionObj.flush();
            sessionObj.getTransaction().commit();
        } catch(Exception sqlException) {
//            if(null != sessionObj.getTransaction()) {
//                System.out.println("\n.......Transaction Is Being Rolled Back.......");
//                sessionObj.getTransaction().rollback();}
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
    }
 }
