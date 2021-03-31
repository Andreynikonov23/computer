package ru.sapteh.Implements;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Computer;

import java.util.List;

public class ComputerImpl implements DAO<Computer, Integer> {
    private final SessionFactory factory;
    public ComputerImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Computer computer) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(computer);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Computer computer) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(computer);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Computer computer) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(computer);
            session.getTransaction().commit();
        }
    }

    @Override
    public Computer read(Integer id) {
        try(Session session = factory.openSession()) {
            return session.get(Computer.class, id);
        }
    }

    @Override
    public List<Computer> findByAll() {
        try(Session session = factory.openSession()) {
            Query<Computer> query = session.createQuery("FROM Computer");
            return query.list();
        }
    }
}
