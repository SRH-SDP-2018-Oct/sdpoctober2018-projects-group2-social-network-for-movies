package com.SNM.app.crud;
import com.SNM.app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class FetchMoviesGenreTest {
    private String genre;
    private Session sessionObj;
    private SessionFactory sessionFactoryObj;
    private HibernateUtil hibernateUtil = new HibernateUtil();

    public FetchMoviesGenreTest() {
        this.genre = "action";
        fetchMoviesGenre();
    }
    @Test
    public void fetchMoviesGenre() {
        try
        {
            sessionObj = hibernateUtil.buildSessionFactory().openSession();
            sessionObj.beginTransaction();
            String sql ="select distinct m.movie_name from moviedetail m join genrelist g on g.genre= :genre and g.movie_ID= m.movie_ID";
            List list = sessionObj.createSQLQuery(sql).setParameter("genre",genre).list();
            sessionObj.getTransaction().commit();
            assertTrue(!(list.isEmpty()));
        } catch(Exception sqlException) {
            if(null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally
        {
            if(sessionObj != null)
            {
                sessionObj.close();
            }
        }
    }
}
