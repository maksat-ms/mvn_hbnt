package hbnte;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class hbnt_test {

    public static void main(String[] args)
    {
        delete();
        //update();
        //hql();
        //insert();
        //select();
    }

    public static void hql()
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(FIOList.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            List<FIOList> fios = session.createQuery("from FIOList where fio = 'Peter3' and id > 1 ").getResultList();

            for (FIOList fio: fios)
            {
                System.out.println(fio.toString());
            }

            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }

    }

    public static void select()
    {
        SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(FIOList.class)
            .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            FIOList fioList = session.get(FIOList.class, 2);
            session.getTransaction().commit();
            System.out.println(fioList.toString());
        }
        finally {
            factory.close();
        }
    }

    public static void insert()
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(FIOList.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            FIOList fioList;
            session.beginTransaction();
            fioList = new FIOList(1, "Peter1");
            session.save(fioList);
            fioList = new FIOList(2, "Peter2");
            session.save(fioList);
            fioList = new FIOList(3, "Peter3");
            session.save(fioList);

            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }

    public static void update()
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(FIOList.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            //FIOList fioList = session.get(FIOList.class, 2);
            //fioList.setFio("John Smith");

            session.createQuery("update FIOList set fio = 'Black' where id = 1 ").executeUpdate();

            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }

    public static void delete()
    {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(FIOList.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            //FIOList fioList = session.get(FIOList.class, 2);
            //session.delete(fioList);
            session.createQuery("delete FIOList where fio = 'Black'").executeUpdate();

            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }
    }
}
