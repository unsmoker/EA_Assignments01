package lab03._03_many_to_one_uni_without_null;

import hutils.HibernateUtils;

import lab03.AppUtils;
import org.hibernate.SessionFactory;

import java.util.Arrays;


public class AppPublisher {

    private static final SessionFactory sessionFactory;

    static {
        // If there is more than one entity, you will have to pass them as a comma delimited argument list to the method below
        sessionFactory = HibernateUtils.getSessionFactory (Arrays.asList(Book.class, Publisher.class));
    }


    public static void main(String[] args) {
        Publisher publisher = new Publisher();
        publisher.setName("John");
        Book book1 = new Book();
        book1.setPublisher(publisher);
        book1.setAuthor("Jjlk1");
        book1.setPrice(200.0);
        AppUtils<Book> test = new AppUtils<>();
        test.saveConsumer.accept(sessionFactory, Arrays.asList(book1));
        test.print.accept(sessionFactory, "Book");
        sessionFactory.close();
        System.exit(0);
    }
}
