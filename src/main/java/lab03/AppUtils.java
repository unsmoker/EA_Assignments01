package lab03;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Collection;
import java.util.Optional;
import java.util.function.BiConsumer;


public class AppUtils<T> {
    public BiConsumer<SessionFactory, Collection<T>> saveConsumer = (sessionFactory1, list) -> {
        Session session = sessionFactory1.openSession();
        Optional<Transaction> tx = Optional.empty();
        try {
            tx = Optional.of(session.beginTransaction());
            list.forEach(session::persist);
            tx.ifPresent(EntityTransaction::commit);
        } catch (HibernateException e) {
            tx.ifPresent(EntityTransaction::rollback);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    };

    public final BiConsumer<SessionFactory, String> print = (sessionFactory1, query) -> {
        Session session = sessionFactory1.openSession();
        Optional<Transaction> tx = Optional.empty();
        try {
            tx = Optional.of(session.beginTransaction());
            Query q = session.createQuery("From " + query);
            q.getResultList().forEach(System.out::println);
            tx.ifPresent(EntityTransaction::commit);
        } catch (HibernateException e) {
            tx.ifPresent(EntityTransaction::rollback);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    };
}