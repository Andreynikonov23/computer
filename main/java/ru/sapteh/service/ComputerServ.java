package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import ru.sapteh.dao.DAO;
import ru.sapteh.model.Computer;

import java.util.List;

public class ComputerServ implements DAO<Computer, Integer> {
    private final SessionFactory factory;

    public ComputerServ(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Computer computer) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(computer);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Computer computer) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(computer);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Computer computer) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(computer);
            session.getTransaction().commit();
        }
    }

    @Override
    public Computer read(Integer id) {
        try (Session session = factory.openSession()) {
            return session.get(Computer.class, id);
        }
    }

    @Override
    public List<Computer> findByAll() {
        try(Session session = factory.openSession()) {
            String sql = "SELECT * FROM computer";
            Query Query = session.createNativeQuery(sql).addEntity(Computer.class);
            return Query.getResultList();
        }
    }
}
