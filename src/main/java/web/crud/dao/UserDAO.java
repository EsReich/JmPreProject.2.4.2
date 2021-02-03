package web.crud.dao;

import web.crud.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();
    public void saveUser(User user);
    public void updateUser(User user);
    public void deleteUser(User user);
    public User getUserById(Integer id);
    public User getUserByEmail(String email);
}
