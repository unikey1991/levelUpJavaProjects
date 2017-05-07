package view.impl;

import dao.impl.UserDAOImpl;
import entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import lombok.Getter;
import org.hibernate.query.Query;
import view.LoginDialog;

/**
 * Created by unike on 03.05.2017.
 */

@Getter
public class CreateLoginDialog extends LoginDialog {

    JLabel label = new JLabel("Введите данные");
    private TextField login;
    private JPasswordField password;
    private final UserDAOImpl userDAO;
    private boolean logged = false;

    public CreateLoginDialog(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
        initComponents();
    }



    private void clearFields() {
        login.setText("");
        password.setText("");
    }

    @Override
    public User getUser() {
        String log = login.getText();
        StringBuilder builder = new StringBuilder();
        String pass = new String(this.password.getPassword());
        return new User(log, pass,null,null,null);
    }

    @Override
    public ActionListener getButtonListener() {
        return e -> {
            if(e.getActionCommand().equals("login")) {
                User user = getUser();
                String log = user.getEmail();
                String pass = user.getPassword();
                Query<User> userQuery = userDAO.session.createQuery("from User where email = :email and password = :password", User.class);
                userQuery.setParameter("email", log);
                userQuery.setParameter("password", pass);
                User user1 = userQuery.uniqueResult();
                if (null == user1){
                    label.setText("пользователь не найден");
                    label.setForeground(Color.RED);
                    revalidate();
                }
                if (null != user1){
                    userDAO.setMainUser(user1);
                    logged = true;
                    dispose();
                }
            }
            if (e.getActionCommand().equals("exit")){
                System.exit(0);
            }

        };
    }

    private void initComponents() {
        initLabels();
        initTextFields();
    }

    private void initLabels() {

        JLabel login = new JLabel("Email:");
        JLabel password = new JLabel("Password:");

        label.setBounds(20,0,200,25);
        login.setBounds(30, 35, 65, 25);
        password.setBounds(30, 70, 65, 25);

        panel.add(label);
        panel.add(login);
        panel.add(password);
    }

    private void initTextFields() {
        login = new TextField();
        password = new JPasswordField();

        login.setBounds(110, 35, 100, 25);
        password.setBounds(110, 70, 100, 25);

        panel.add(login);
        panel.add(password);
    }
}
