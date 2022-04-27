package lab02;

import hutils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Arrays;


public class AppCar {

    public static final SessionFactory sessionfactory;

    static {
        sessionfactory = HibernateUtils.getSessionFactory(Arrays.asList(Car.class));
    }

    public static void main(String[] args) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionfactory.openSession();
            transaction = session.beginTransaction();

            Car car = new Car("toyota", 2009, 7500.0);
            session.persist(car);

            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            System.out.println(sessionfactory.isClosed());
            sessionfactory.close();
        }
    }
}
