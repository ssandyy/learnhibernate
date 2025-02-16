package org.feb2025;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Avatar av1 = new Avatar();
        av1.setAid(001);
        av1.setAname("Valentine");
        av1.setTech("Human");


        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(org.feb2025.Avatar.class);
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.merge(av1); // Use merge() instead of persist()
        session.getTransaction().commit();

        session.close();

    }
}
