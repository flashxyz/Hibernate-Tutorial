package data;

import data.entities.User;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by elya on 14/02/2017.
 */

public class Application {
    public static void main(String[] args){

        //Session session = HibernateUtil.getSessionFactory().openSession();
        //session.getTransaction().begin();

        //JPA
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("infinite-finances");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        User user = new User();
        user.setBirthDate(new Date());
        user.setCreatedDate(new Date());
        user.setCreatedBy("eliya Bar On test");
        user.setEmailAddress("asd@asd.com");
        user.setFirstName("Morgane - JPA");
        user.setLastName("Mohr - JPA");
        user.setLastUpdatedBy("Flash");
        user.setLastUpdatedDate(new Date());


        em.persist(user);
        tx.commit();
        em.close();
        emf.close();

        //session.save(user);

        //session.getTransaction().commit();
        //session.close();

    }
}
