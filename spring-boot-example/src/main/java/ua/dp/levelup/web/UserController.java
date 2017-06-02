package ua.dp.levelup.web;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ua.dp.levelup.dao.UserDao;
import ua.dp.levelup.model.User;

import javax.servlet.http.HttpServletResponse;

/**
 * A class to test interactions with the MySQL database using the UserDao class.
 *
 * @author Shegeda Alexandr (https://www.luxoft.com).
 */
@Controller
public class UserController {

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    @Autowired
    private UserDao userDao;

    @Value("${file.storage.path}")
    private String fileStorage;
    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    /**
     * /create  --> Create a new user and save it in the database.
     *
     * @param email User's email
     * @param name  User's name
     * @return A string describing if the user is succesfully created or not.
     */
    @RequestMapping("/create")
    @ResponseBody
    public String create(String email, String name) {
        User user = null;
        try {
            user = new User(email, name);
            userDao.save(user);
        } catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created! (id = " + user.getId() + ")";
    }

    /**
     * /delete  --> Delete the user having the passed id.
     *
     * @param id The id of the user to delete
     * @return A string describing if the user is succesfully deleted or not.
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(long id) {
        try {
            User user = new User(id);
            userDao.delete(user);
        } catch (Exception ex) {
            return "Error deleting the user: " + ex.toString();
        }
        return "User succesfully deleted!";
    }

    /**
     * /get-by-email  --> Return the id for the user having the passed email.
     *
     * @param email The email to search in the database.
     * @return The user id or a message error if the user is not found.
     */
    @RequestMapping("/get-by-email")
    @ResponseBody
    public String getByEmail(String email) {
        String userId;
        try {
            User user = userDao.findByEmail(email);
            userId = String.valueOf(user.getId());
        } catch (Exception ex) {
            return "User not found";
        }
        return "The user id is: " + userId;
    }

    /**
     * /update  --> Update the email and the name for the user in the database
     * having the passed id.
     *
     * @param id    The id for the user to update.
     * @param email The new email.
     * @param name  The new name.
     * @return A string describing if the user is succesfully updated or not.
     */
    @RequestMapping("/update")
    @ResponseBody
    public String updateUser(long id, String email, String name) {
        try {
            User user = userDao.findOne(id);
            user.setEmail(email);
            user.setName(name);
            userDao.save(user);
        } catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User succesfully updated!";
    }

    @ResponseBody
    @RequestMapping("/users")
    public List<User> getUserList() {
        return Arrays.asList(
                new User(1, "user1@yopmail.com", "user1"),
                new User(2, "user2@yopmail.com", "user2"),
                new User(3, "user3@yopmail.com", "user3"),
                new User(4, "user4@yopmail.com", "user4"),
                new User(5, "user5@yopmail.com", "user5")
        );
    }

    @RequestMapping("/user")
    public ModelAndView getUserInfoPage() {
        return new ModelAndView("user-info");
    }

    @RequestMapping(value = "/user/avatar", method = RequestMethod.POST)
    public ResponseEntity uploadAvatar(@RequestParam(name = "file") MultipartFile avatar, HttpServletResponse response){

        response.addHeader("Access-Control-Allow-Origin","*");

        File file = new File(fileStorage, avatar.getOriginalFilename());
        try (BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(file));){
            os.write(avatar.getBytes());
            return new ResponseEntity("Image upload successfully", HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity("Image not uploaded", HttpStatus.BAD_REQUEST);
        }
    }

} // class UserController
