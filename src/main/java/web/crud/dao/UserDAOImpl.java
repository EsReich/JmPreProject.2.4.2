package web.crud.dao;

import org.springframework.stereotype.Repository;
import web.crud.entity.User;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        em.persist(user);
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public void deleteUser(User user) {
        em.remove(em.contains(user) ? user : em.merge(user));
    }

    @Override
    public User getUserById(Integer id) {
        return em.find(User.class, id);
    }

    @Override
    public User getUserByEmail(String email) {

        Query query = em.createQuery("from User u where u.email = :userEmail");
        query.setParameter("userEmail", email);

        return (User)query.getSingleResult();
    }
}
