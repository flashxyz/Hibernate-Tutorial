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

             //No need for that line, we set it on hibernate.cfg.xml
            configuration.addAnnotatedClass(User.class);
            return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());

            //this settings are for the hibernate.cfg.xml file
            //return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error Building Session Factory");
        }
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
