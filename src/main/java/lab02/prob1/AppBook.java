package lab02.prob1;


import hutils.HibernateUtils;
import org.hibernate.*;

import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.sql.Date;
import java.time.Instant;
import java.util.*;

public class AppBook {

    private  static final SessionFactory sessionFactory;

    static {
        sessionFactory = HibernateUtils.getSessionFactory(Collections.singletonList(Book.class));
    }

    public static void main(String[] args) {
        createBooks();
        printBooks();
        updateAndDelete();
        System.out.println("after deleting");
        printBooks();
        sessionFactory.close();
    }

    public static void updateAndDelete() {
        System.out.println("Printing  books from db");
        List<Book> books = new ArrayList<>();
        Optional<Session> session = Optional.empty();
        Optional<Transaction> tx = Optional.empty();
        try {
            session = Optional.of(sessionFactory.openSession());
            tx = Optional.of(session.get().beginTransaction());
            CriteriaBuilder cb = session.get().getCriteriaBuilder();
            CriteriaQuery<Book> criteriaQuery = cb.createQuery(Book.class);
            criteriaQuery.from(Book.class);
            books = session.get().createQuery(criteriaQuery).list();
            books.forEach(System.out::println);
            Iterator<Book> iterator = books.iterator();
            Book bookForUpdate = iterator.next();
            Book bookForDelete = iterator.next();
            tx.ifPresent(EntityTransaction::commit);
            //update
            tx = Optional.of(session.get().beginTransaction());
            session.get().update(bookForUpdate);
            tx.ifPresent(EntityTransaction::commit);
            tx = Optional.of(session.get().beginTransaction());
            session.get().delete(bookForDelete);
            tx.ifPresent(EntityTransaction::commit);
        } catch (HibernateException e) {
            tx.ifPresent(EntityTransaction::rollback);
            e.printStackTrace();
        } finally {
            session.ifPresent(SharedSessionContract::close);
        }
    };
    public static void printBooks() {
        System.out.println("Printing  books from db");
        List<Book> books = new ArrayList<>();
        Optional<Session> session = Optional.empty();
        Optional<Transaction> tx = Optional.empty();
        try {
            session = Optional.of(sessionFactory.openSession());
            tx = Optional.of(session.get().beginTransaction());
            CriteriaBuilder cb = session.get().getCriteriaBuilder();
            CriteriaQuery<Book> criteriaQuery = cb.createQuery(Book.class);
            criteriaQuery.from(Book.class);
            books = session.get().createQuery(criteriaQuery).list();
            books.forEach(System.out::println);
            tx.ifPresent(EntityTransaction::commit);
        } catch (HibernateException e) {
            tx.ifPresent(EntityTransaction::rollback);
            e.printStackTrace();
        } finally {
            session.ifPresent(SharedSessionContract::close);
        }
    }
    public static void createBooks() {
        System.out.println("Creating 3 books to db");
        Collection<Book> books = generate(3);
        Optional<Session> session = Optional.empty();
        Optional<Transaction> tx = Optional.empty();
        for (Book book : books) {
            try {
                session = Optional.ofNullable(sessionFactory.openSession());
                if (session.isPresent()) {
                    tx = Optional.ofNullable(session.get().beginTransaction());
                    session.get().persist(book);
                    tx.ifPresent(EntityTransaction::commit);
                }
            } catch (HibernateException e) {
                tx.ifPresent(EntityTransaction::rollback);
                e.printStackTrace();
            } finally {
                session.ifPresent(SharedSessionContract::close);
            }
        }
    }
    public static Collection<Book> generate(int k) {
        Collection<Book> books = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Book theBook = new Book();
            theBook.setTitle("The book #" + i + " title");
            theBook.setAuthor("The Author of book #" +i +" Jim Josuah");
            theBook.setPrice(22.5*i);
            theBook.setISBN("CCND00234-234"+i);
            theBook.setPublish_date(Date.from(Instant.now()));
            books.add(theBook);
        }
        return books;
    }
}
