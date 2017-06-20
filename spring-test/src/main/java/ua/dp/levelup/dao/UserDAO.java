package ua.dp.levelup.dao;

import ua.dp.levelup.User;

import java.util.List;

/**
 * Created by java on 20.06.2017.
 */
public interface UserDAO {

    List<User> getAllUsers();

    User getUserByEmail(String email);

    User getUserById(Long id);

    void createUser(User user);

    void deleteUser(User user);

    void updateUser(User user);

}
