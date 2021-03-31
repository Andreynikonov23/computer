package ru.sapteh.Implements;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Computer;
import ru.sapteh.models.Users;

import java.util.List;

public class UsersImpl implements DAO<Users, Integer> {
    private final SessionFactory factory;

    public UsersImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Users users) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(users);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Users users) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(users);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Users users) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(users);
            session.getTransaction().commit();
        }
    }

    @Override
    public Users read(Integer id) {
        try(Session session = factory.openSession()) {
            return session.get(Users.class, id);
        }
    }

    @Override
    public List<Users> findByAll() {
        try(Session session = factory.openSession()) {
            Query<Users> query = session.createQuery("FROM Users");
            return query.list();
        }
    }
}
