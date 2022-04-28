package lab05;

import hutils.HibernateUtils;
import net.bytebuddy.asm.Advice;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.function.Consumer;

public class App {
    private static final SessionFactory sessionFactory;

    static {
        sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Customer.class, Order.class, OrderLine.class, Product.class, DVD.class, CD.class, Book.class));
    }

    public static void saveDatas () {
        Customer customer = new Customer("John", "Smidth");
        Order order = new Order();
        order.setData(LocalDate.now());
        customer.addOrder(order);
        performTask(session ->  session.persist(order));
        performTask(session ->  session.persist(customer));
    }

    public static void main(String[] args) {
        sessionFactory.openSession();
//        saveDatas();
        sessionFactory.close();
    }

    public static void performTask (Consumer<Session> sessionConsumer){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        sessionConsumer.accept(session);
        tx.commit();
    };
}
