package com.SNM.app.main;

import com.SNM.app.userinput.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import java.util.Scanner;

public class ImplementSNM {
    static Session sessionObj;
    static SessionFactory sessionFactoryObj;

    private static SessionFactory buildSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration().configure();
        //configObj.configure("hibernate.cfg.xml");
        configObj.addAnnotatedClass(com.SNM.app.pojo.UserProfile.class);
        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

        // Creating Hibernate SessionFactory Instance
        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactoryObj;
    }
    public static void main(String[] args)

    {

        Scanner userinput=new Scanner(System.in);
        System.out.println("Press : 1 for Existing User.\n 2 for New User");
        int choice = userinput.nextInt();
        if(choice == 2)
        {
            NewUser user1 = new NewUser();
        }
        else
        {
            ExistingUser user2 = new ExistingUser();
        }

    }
}