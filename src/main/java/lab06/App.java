package lab06;

import hutils.HibernateUtils;
import org.hibernate.SessionFactory;

import java.util.Arrays;

public class App {
    private static final SessionFactory sessionFactory;

    static {
        sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Appointment.class, Patient.class, Doctor.class, Payment.class));
    }

    public static void main(String[] args) {
        sessionFactory.openSession();

        sessionFactory.close();
    }


}
