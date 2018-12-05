package com.SNM.app.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import com.SNM.app.pojo.*;

public class HibernateUtil
{
    static Session sessionObj;
    static SessionFactory sessionFactoryObj;
    public static SessionFactory buildSessionFactory()
    {
        Configuration configObj = new Configuration().configure();
        //configObj.configure("hibernate.cfg.xml");
        configObj.addAnnotatedClass(UserProfile.class).addAnnotatedClass(MovieDetails.class).addAnnotatedClass(UserReview.class).addAnnotatedClass(Watchlist.class).addAnnotatedClass(TrendingMovies.class).addAnnotatedClass(LanguageList.class).addAnnotatedClass(GroupDetail.class).addAnnotatedClass(GroupComment.class).addAnnotatedClass(GenreList.class).addAnnotatedClass(CompositeKeyGenre.class).addAnnotatedClass(CompositeKeyLanguage.class);
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();
        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactoryObj;
    }
}