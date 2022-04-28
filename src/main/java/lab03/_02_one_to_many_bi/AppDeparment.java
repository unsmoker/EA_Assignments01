package lab03._02_one_to_many_bi;

import hutils.HibernateUtils;
import lab03.AppUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.util.Arrays;


public class AppDeparment {

    private static final SessionFactory sessionFactory;

    static {
        // If there is more than one entity, you will have to pass them as a comma delimited argument list to the method below
        sessionFactory = HibernateUtils.getSessionFactory (Arrays.asList(Employee.class, Department.class));
    }


    public static void main(String[] args) {
        Department department = new Department();
        department.setName("sales");
        Employee emp = new Employee(department);
        emp.setName("John");
        Employee emp2 = new Employee(department);
        emp2.setName("Smith");

        AppUtils<Employee> test = new AppUtils<>();
        test.saveConsumer.accept(sessionFactory, Arrays.asList(emp, emp2));
        test.print.accept(sessionFactory, " Department");
        test.print.accept(sessionFactory, " Employee");
        sessionFactory.close();
        System.exit(0);
    }
}
