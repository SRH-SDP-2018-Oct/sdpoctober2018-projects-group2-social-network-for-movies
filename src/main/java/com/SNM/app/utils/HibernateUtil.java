package com.SNM.app.utils;

import com.SNM.app.pojo.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.logging.Level;

public class HibernateUtil
{
    static Session sessionObj;
    static SessionFactory sessionFactoryObj;
    public static SessionFactory buildSessionFactory()
    {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

        Configuration configObj = new Configuration().configure();
        //configObj.configure("hibernate.cfg.xml");
        configObj.addAnnotatedClass(UserProfile.class).addAnnotatedClass(MovieDetails.class).addAnnotatedClass(UserReview.class).addAnnotatedClass(Watchlist.class).addAnnotatedClass(TrendingMovies.class).addAnnotatedClass(LanguageList.class).addAnnotatedClass(GroupDetail.class).addAnnotatedClass(GroupComment.class).addAnnotatedClass(GenreList.class).addAnnotatedClass(CompositeKeyGenre.class).addAnnotatedClass(CompositeKeyLanguage.class).addAnnotatedClass(CompositeKeyWatchList.class).addAnnotatedClass(CompositeKeyUserReview.class).addAnnotatedClass(MovieDetails.class).addAnnotatedClass(CompositeKeyWatchList.class).addAnnotatedClass(Watchlist.class).addAnnotatedClass(UserProfile.class).addAnnotatedClass(Preferences.class).addAnnotatedClass(CompositeKeyPrefrences.class);
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();
        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactoryObj;
    }
}