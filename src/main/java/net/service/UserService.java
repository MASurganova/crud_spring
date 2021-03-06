package net.service;

import net.dao.userDAO.UsersDAO;
import net.model.User;

import java.util.List;

public interface UserService {

    User getUser(long id);

    User getUser(String login);

    void addUser(User user);

    void deleteUser(long id);

    void upDateUser(User user);

    List<User> getUsersDataTable();
}
