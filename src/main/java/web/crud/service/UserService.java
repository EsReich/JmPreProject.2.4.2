package web.crud.service;

import web.crud.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
//    public void saveOrUpdateUser(User user);
    public void saveUser(User user);
    public void updateUser(User user);
    public void deleteUser(User user);
    public User getUser(Integer id);
}
