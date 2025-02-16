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
        av1.setAid(4);
        av1.setAname("Valentina");
        av1.setTech("Humanaya");


        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(org.feb2025.Avatar.class);
        configuration.configure();

        //or
//        SessionFactory sessionFactory = new Configuration()
//                                            .buildSessionFactory()
//                                            .addAnnotatedClass(org.feb2025.Avatar.class)
//                                            .configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
            session.beginTransaction();

        //to push data
            session.merge(av1); // to post data and update data
            session.getTransaction().commit();

        // to get data (fetch)
            //Avatar avsearch = session.get(Avatar.class, 001); // Eager fetching
            //Avatar avsearch = session.byId(Avatar.class).load(002);  // lazy fetching
            //Avatar avsearch = session.byId(Avatar.class).getReference(002); // lazy fetching
            Avatar avsearch = session.find(Avatar.class, 001);  // Eager fetching
            System.out.println(avsearch);

//            Avatar avsearch2 = session.find(Avatar.class, 003);
//            session.remove(avsearch2);


        session.close();

    }
}
