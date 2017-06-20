package ua.dp.levelup.dao.impl;

import ua.dp.levelup.User;
import ua.dp.levelup.dao.UserDAO;

import java.util.*;

/**
 * Created by java on 20.06.2017.
 */
public class UserDAOImpl implements UserDAO {

    private Map<Long, User> userByIdMap = new HashMap<>();
    private Map<String, Long> idByEmailMap = new HashMap<>();

    public void init() {
        List<User> users = Arrays.asList(
                new User(1L,"as1@yopmail.com","John","Doe"),
                new User(2L,"as1@yopmail.com","Bob","Dilan"),
                new User(3L,"as1@yopmail.com","Tom","Riddle"),
                new User(4L,"as1@yopmail.com","Harry","Potter"),
                new User(5L,"as1@yopmail.com","Sara","Connor"),
                new User(6L,"as1@yopmail.com","Donald","Trump")
        );


        Random random = new Random();

        for (User u : users){
            u.increaseBalance(random.nextInt(100)+25);

            createUser(u);
        }
    }


    @Override
    public List<User> getAllUsers() {
        return (List<User>) userByIdMap.values();
    }

    @Override
    public User getUserByEmail(String email) {
        return userByIdMap.get(idByEmailMap.get(email));
    }

    @Override
    public User getUserById(Long id) {
        return userByIdMap.get(id);
    }

    @Override
    public void createUser(User user) {
        userByIdMap.put(user.getId(), user);
        idByEmailMap.put(user.getEmail(),user.getId());
    }

    @Override
    public void deleteUser(User user) {
        userByIdMap.remove(user.getId());
        idByEmailMap.remove(user.getEmail());
    }

    @Override
    public void updateUser(User user) {
        userByIdMap.put(user.getId(),user);
        idByEmailMap.put(user.getEmail(),user.getId());

    }
}
