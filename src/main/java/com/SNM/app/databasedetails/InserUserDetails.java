package com.SNM.app.databasedetails;

import com.SNM.app.pojo.UserProfile;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class InserUserDetails

{
    static Session sessionObj;
    static SessionFactory sessionFactoryObj;

    public void addUser(String username, String firstname, String lastname, int age, String emailID, String password )

    {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration().configure();
        //configObj.configure("hibernate.cfg.xml");
        configObj.addAnnotatedClass(com.SNM.app.pojo.UserProfile.class);
        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

        // Creating Hibernate SessionFactory Instance
        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        Session session = sessionFactoryObj.openSession();
        Transaction tx = null;
        try
        {
            tx = session.beginTransaction();
            UserProfile user = new UserProfile();
           user.setFirst_name(firstname);
           user.setLast_name(lastname);
           user.setAge(age);
            user.setEmail_ID(emailID);
            user.setPassword(password);
            tx.commit();
        } catch (   Exception e) {
            if (tx!=null) tx.rollback();

        } finally {
            session.close();
        }
        System.out.println("your profile is created successfully");
    }

}
