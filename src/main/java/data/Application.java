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


        //JPA as interface - Hibernate as implementation
        EntityManagerFactory factory = null;
        EntityManager em = null;
        EntityTransaction tx = null;
        try{
            factory = Persistence.createEntityManagerFactory("infinite-finances");
            em = factory.createEntityManager();
            tx = em.getTransaction();
            tx.begin();

            // Here we start creating entities/getting entities from DB...
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

            //commit to DB
            tx.commit();

        }catch (Exception e){
            // If we have a problem - roll back to the start.
            tx.rollback();
        }finally {
            em.close();
            factory.close();
        }


        //session.save(user);

        //session.getTransaction().commit();
        //session.close();

    }
}
