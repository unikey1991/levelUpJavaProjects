package view.impl;

import entity.AccountType;
import entity.User;
import view.UserDialog;

import javax.swing.*;
import java.awt.*;

/**
 * Created by unike on 06.05.2017.
 */
public class CreateUserDialog extends UserDialog {

    private TextField email;
    private TextField password;
    private TextField name;
    private TextField lastName;
    private JComboBox<AccountType> accountType = new JComboBox<>(AccountType.values());

    public CreateUserDialog() {
        initComponents();
    }

    @Override
    public User getEntity() {
        setLocationRelativeTo(null);
        User citizen = createUser();
        clearFields();
        return citizen;
    }

    private void createAccountType(){
        accountType.setBounds(110,140,65,25);
        panel.add(accountType);
    }



    private void clearFields() {
        email.setText("");
        password.setText("");
        name.setText("");
        lastName.setText("");
    }

    private User createUser() {
        String em = email.getText();
        String pas = password.getText();
        String nam = name.getText();
        String lastN = lastName.getText();
        AccountType type = (AccountType) accountType.getSelectedItem();
        return new User(em,pas,nam,lastN,type);
    }

    private void initComponents() {
        initLabels();
        initTextFields();
        createAccountType();
    }

    private void initLabels() {
        JLabel email = new JLabel("Email:");
        JLabel password = new JLabel("Password:");
        JLabel name = new JLabel("Name:");
        JLabel lastName = new JLabel("Last Name:");
        JLabel accountType = new JLabel("Account type:");

        email.setBounds(30, 0, 65, 25);
        password.setBounds(30, 35, 65, 25);
        name.setBounds(30, 70, 65, 25);
        lastName.setBounds(30, 105, 65, 25);
        accountType.setBounds(30, 140, 65, 25);

        panel.add(email);
        panel.add(password);
        panel.add(name);
        panel.add(lastName);
        panel.add(accountType);
    }

    private void initTextFields() {
        email = new TextField();
        password = new TextField();
        name = new TextField();
        lastName = new TextField();

        email.setBounds(110, 0, 100, 25);
        password.setBounds(110, 35, 100, 25);
        name.setBounds(110, 70, 100, 25);
        lastName.setBounds(110, 105, 100, 25);

        panel.add(email);
        panel.add(password);
        panel.add(name);
        panel.add(lastName);
    }
}
