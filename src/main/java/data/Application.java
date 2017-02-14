package data;

import data.entities.User;
import org.hibernate.Session;

import java.util.Date;

/**
 * Created by elya on 14/02/2017.
 */
public class Application {
    public static void main(String[] args){

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        User user = new User();
        user.setBirthDate(new Date());
        user.setCreatedDate(new Date());
        user.setCreatedBy("Flash");
        user.setEmailAddress("asd@asd.com");
        user.setFirstName("BLa");
        user.setLastName("momo");
        user.setLastUpdatedBy("Flash");
        user.setLastUpdatedDate(new Date());

        session.save(user);

        session.getTransaction().commit();
        session.close();

    }
}
