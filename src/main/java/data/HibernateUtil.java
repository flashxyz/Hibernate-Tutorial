package data;

import data.entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by elya on 13/02/2017.
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try{
            Configuration configuration = new Configuration();

            configuration.addAnnotatedClass(User.class);
            return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error Building Session Factory");
        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
