package view.impl;

import dao.impl.PacketDAOImpl;
import dao.impl.UserDAOImpl;
import entity.Packet;
import view.UserDialog;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Date;

/**
 * Created by unike on 08.05.2017.
 */
public class CreateLoadPacketDialog extends UserDialog{

    private TextField path;
    private TextField packetName;
    private final UserDAOImpl userDAO;
    private final PacketDAOImpl packetDAO;


    public CreateLoadPacketDialog(UserDAOImpl userDAO, PacketDAOImpl packetDAO){
        this.userDAO = userDAO;
        this.packetDAO = packetDAO;
        initComponents();
    }

    private void initComponents() {
        initLabels();
        initTextFields();
    }

    @Override
    public Packet getEntity() {
        Packet packet = createPacket();
        clearFields();
        return packet;
    }

    private void clearFields() {
        path.setText("");
        packetName.setText("");
    }

    private Packet createPacket() {
        File file = new File(path.getText());
        if (null == file) {
            System.out.println("File not found");
            return null;
        }
        Packet packet = new Packet(packetName.getText(),new Date(), userDAO.mainUser, userDAO.mainUser, file);
        return packet;
    }

    private void initLabels() {
        JLabel path = new JLabel("Enter full path:");
        JLabel name = new JLabel("Enter name:");

        path.setBounds(30, 0, 100, 25);
        name.setBounds(30, 35, 100, 25);

        panel.add(path);
        panel.add(name);
    }

    private void initTextFields() {
        path = new TextField();
        packetName = new TextField();

        path.setBounds(135, 0, 100, 25);
        packetName.setBounds(135, 35, 100, 25);

        panel.add(path);
        panel.add(packetName);
    }

}
