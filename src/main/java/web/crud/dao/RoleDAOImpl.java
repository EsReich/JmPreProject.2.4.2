package web.crud.dao;

import org.springframework.stereotype.Repository;
import web.crud.entity.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Set<Role> getAllRoles() {
        return em.createQuery("from Role", Role.class)
                .getResultStream().collect(Collectors.toSet());
    }
}
