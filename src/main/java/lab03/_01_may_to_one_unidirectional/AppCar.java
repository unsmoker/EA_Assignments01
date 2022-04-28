package lab03._01_may_to_one_unidirectional;

import hutils.HibernateUtils;
import lab03.AppUtils;
import org.hibernate.SessionFactory;

import java.util.Arrays;


public class AppCar {

    private static final SessionFactory sessionFactory;

    static {
        // If there is more than one entity, you will have to pass them as a comma delimited argument list to the method below
        sessionFactory = HibernateUtils.getSessionFactory (Arrays.asList(Car.class, Owner.class));
    }

    public static void main(String[] args) {
        AppUtils<Car> test = new AppUtils<>();
        Owner owner1 = new Owner("John", "IA Fairfield 4th North Street");
        Car car1 = new Car("Toyota", "Highlander", 8000.0);
        car1.setOwner(owner1);
        Car car2 = new Car("Toyota", "LandCrouser", 18000.0);
        car2.setOwner(owner1);

        test.saveConsumer.accept(sessionFactory, Arrays.asList(car1, car2));
        test.print.accept(sessionFactory, "Car");
        test.print.accept(sessionFactory, "Owner");

        sessionFactory.close();
        System.exit(0);
    }
}
