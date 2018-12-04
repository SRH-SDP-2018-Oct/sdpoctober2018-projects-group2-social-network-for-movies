package com.SNM.app.utils;

import com.SNM.app.pojo.MovieDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import com.SNM.app.pojo.UserProfile;

public class HibernateUtil
{
    static Session sessionObj;
    static SessionFactory sessionFactoryObj;
    public static SessionFactory buildSessionFactory()
    {
        Configuration configObj = new Configuration().configure();
        configObj.configure("hibernate.cfg.xml");
        configObj.addAnnotatedClass(UserProfile.class).addAnnotatedClass(MovieDetails.class);
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();
        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactoryObj;
    }
}