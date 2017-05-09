package view.impl;

import dao.impl.PacketDAOImpl;
import dao.impl.UserDAOImpl;
import email.EmailMessage;
import entity.Packet;
import view.UserDialog;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Date;

/**
 * Created by unike on 09.05.2017.
 */
public class CreateEmailSendDialog extends UserDialog {
    private TextField email;
    private TextField theme;
    private TextField text;
    private final UserDAOImpl userDAO;
    private final PacketDAOImpl packetDAO;


    public CreateEmailSendDialog(UserDAOImpl userDAO, PacketDAOImpl packetDAO){
        this.userDAO = userDAO;
        this.packetDAO = packetDAO;
        super.setBounds(300,400,800,600);
        super.panel.setBounds(0,0,800,600);
        super.ok.setBounds(30,105,80,30);
        super.ok.setText("Send");
        super.cancel.setBounds(30,140,80,30);
        initComponents();
    }

    private void initComponents() {
        initLabels();
        initTextFields();
    }

    @Override
    public EmailMessage getEntity() {
        EmailMessage emailMessage = new EmailMessage(email.getText(),text.getText(),theme.getText());
        clearFields();
        return emailMessage;
    }

    private void clearFields() {
        email.setText("");
        theme.setText("");
        text.setText("");
    }

    /*private Packet email() { //todo Email
        File file = new File(path.getText());
        if (null == file) {
            System.out.println("File not found");
            return null;
        }
        Packet packet = new Packet(packetName.getText(),new Date(), userDAO.mainUser, userDAO.mainUser, file);
        return packet;
    }*/

    private void initLabels() {
        JLabel email = new JLabel("Enter email:");
        JLabel theme = new JLabel("Enter theme:");
        JLabel text = new JLabel("Enter theme:");

        email.setBounds(30, 0, 120, 25);
        theme.setBounds(30, 35, 120, 25);
        text.setBounds(30, 70, 120, 25);

        panel.add(email);
        panel.add(theme);
        panel.add(text);
    }

    private void initTextFields() {
        email = new TextField();
        theme = new TextField();
        text = new TextField();

        email.setBounds(150, 0, 200, 25);
        theme.setBounds(150, 35, 200, 25);
        text.setBounds(150, 70, 600, 400);

        panel.add(email);
        panel.add(theme);
        panel.add(text);
    }
}
