package web.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.crud.dao.RoleDAO;
import web.crud.entity.Role;

import javax.transaction.Transactional;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Transactional
    @Override
    public Set<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }
}
