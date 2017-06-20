package ua.dp.levelup.dao.impl;

import ua.dp.levelup.User;
import ua.dp.levelup.dao.UserDAO;

import java.io.*;
import java.util.List;

/**
 * Created by java on 20.06.2017.
 */
public class UserFileDaoImpl implements UserDAO {


    private final String filePath;

    public UserFileDaoImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<User> getAllUsers() {
        File file = new File(filePath);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public void createUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }
}
