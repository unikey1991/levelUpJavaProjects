package ua.dp.levelup.service.impl;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import ua.dp.levelup.Profiling;
import ua.dp.levelup.User;
import ua.dp.levelup.dao.UserDAO;
import ua.dp.levelup.service.UserService;

import java.util.List;

/**
 * Created by java on 16.06.2017.
 */
public class UserServiceImpl implements InitializingBean, DisposableBean, UserService {


    private UserDAO userDAO;

    public UserServiceImpl() {
        System.out.println("UserService constructor colled");
        doMagic();
    }

    public void destroy() throws Exception {
        System.out.println("bye bye chepushilo");
        doMagic();
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("hello chepushilo");
        doMagic();
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Profiling
    public void doMagic() {
        System.out.println("UserService does magic");
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public void createUser(User user) {
        userDAO.createUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }
}
