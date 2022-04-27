package lab02.prob2;

import hutils.HibernateUtils;
import org.hibernate.*;

import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.sql.Date;
import java.time.Instant;
import java.util.*;

public class AppPerson {
    private  static final SessionFactory sessionFactory;

    static {
        sessionFactory = HibernateUtils.getSessionFactory(Collections.singletonList(Person.class));
    }

    public static void main(String[] args) {
        createPersons();
        printPersons();
        updateAndDelete();
        System.out.println("after deleting");
        printPersons();
        sessionFactory.close();
    }

    public static void updateAndDelete() {
        System.out.println("Printing  people from db");
        List<Person> people = new ArrayList<>();
        Optional<Session> session = Optional.empty();
        Optional<Transaction> tx = Optional.empty();
        try {
            session = Optional.of(sessionFactory.openSession());
            tx = Optional.of(session.get().beginTransaction());
            CriteriaBuilder cb = session.get().getCriteriaBuilder();
            CriteriaQuery<Person> criteriaQuery = cb.createQuery(Person.class);
            criteriaQuery.from(Person.class);
            people = session.get().createQuery(criteriaQuery).list();
            people.forEach(System.out::println);
            Iterator<Person> iterator = people.iterator();
            Person bookForUpdate = iterator.next();
            Person bookForDelete = iterator.next();
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
    public static void printPersons() {
        System.out.println("Printing  people from db");
        List<Person> people = new ArrayList<>();
        Optional<Session> session = Optional.empty();
        Optional<Transaction> tx = Optional.empty();
        try {
            session = Optional.of(sessionFactory.openSession());
            tx = Optional.of(session.get().beginTransaction());
            CriteriaBuilder cb = session.get().getCriteriaBuilder();
            CriteriaQuery<Person> criteriaQuery = cb.createQuery(Person.class);
            criteriaQuery.from(Person.class);
            people = session.get().createQuery(criteriaQuery).list();
            people.forEach(System.out::println);
            tx.ifPresent(EntityTransaction::commit);
        } catch (HibernateException e) {
            tx.ifPresent(EntityTransaction::rollback);
            e.printStackTrace();
        } finally {
            session.ifPresent(SharedSessionContract::close);
        }
    }
    public static void createPersons() {
        System.out.println("Creating 3 people to db");
        Collection<Person> people = generate(3);
        Optional<Session> session = Optional.empty();
        Optional<Transaction> tx = Optional.empty();
        for (Person book : people) {
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
    public static Collection<Person> generate(int k) {
        Collection<Person> people = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Person thePerson = new Person();
            thePerson.setFirstName("Person "+ i + "Name");
            thePerson.setLastName("Person " +i +" Last Name");
            thePerson.setDateOfBirth(Date.from(Instant.now()));
            people.add(thePerson);
        }
        return people;
    }
}
