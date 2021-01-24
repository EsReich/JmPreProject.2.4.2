package web.crud.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.crud.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    EntityManagerFactory entityManagerFactory;
//    @PersistenceContext
//    EntityManager em;

    @Override
    public List<User> getAllUsers() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void saveUser(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.unwrap(Session.class).save(user);
    }

    @Override
    public void updateUser(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Session session = entityManager.unwrap(Session.class);
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("UPDATE User set name = :userName, " +
                "surname = :userSurname, age = :userAge where id = :userId");

        query.setParameter("userName", user.getName());
        query.setParameter("userSurname", user.getSurname());
        query.setParameter("userAge", user.getAge());
        query.setParameter("userId", user.getId());
        query.executeUpdate();

        transaction.commit();
        session.close();
    }

//    @Override
//    public void saveOrUpdateUser(User user) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        entityManager.unwrap(Session.class).saveOrUpdate(user);
//    }

    @Override
    public void deleteUser(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Session session = entityManager.unwrap(Session.class);

        Transaction transaction = session.beginTransaction();

        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));

        transaction.commit();
        session.close();
    }

    @Override
    public User getUser(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Session session = entityManager.unwrap(Session.class);

        return session.load(User.class, id);
    }
}
