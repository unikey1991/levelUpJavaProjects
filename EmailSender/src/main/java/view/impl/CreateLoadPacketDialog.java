package view.impl;

import dao.impl.PacketDAOImpl;
import dao.impl.UserDAOImpl;
import entity.Packet;
import view.PacketTableModel;
import view.UserDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;

/**
 * Created by unike on 08.05.2017.
 */
public class CreateLoadPacketDialog extends JFrame{

    private final UserDAOImpl userDAO;
    private final PacketDAOImpl packetDAO;
    private final JFileChooser fileChooser;
    private final PacketTableModel packetTableModel;
    private final JTable table;



    public CreateLoadPacketDialog(UserDAOImpl userDAO, PacketDAOImpl packetDAO, PacketTableModel packetTableModel, JTable jTable){
        this.userDAO = userDAO;
        this.packetDAO = packetDAO;
        this.packetTableModel = packetTableModel;
        this.table = jTable;
        this.fileChooser = new JFileChooser();
        initComponents();

    }

    private void initComponents() {
        setBounds(0,0,800,600);
        setLocationRelativeTo(null);
        fileChooser.setFileFilter(new FileFilter(".csv",""));
        add(fileChooser);
        fileChooser.addActionListener(evt -> fileChooserActionPerformed(evt));
    }

    public Packet getEntity() {
        Packet packet = createPacket();
        return packet;
    }



    private Packet createPacket() {
        File file = fileChooser.getSelectedFile();
        if (null == file) {
            System.out.println("File not found");
            return null;
        }
        Packet packet = new Packet(file.getName(),new Date(), userDAO.mainUser, userDAO.mainUser, file);
        return packet;
    }



    private void fileChooserActionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(javax.swing.JFileChooser.APPROVE_SELECTION)) {
            System.out.println("approve selection");
            Packet packet = getEntity();
            packetTableModel.getPacketList().add(packet);
            packetDAO.create(packet);
            table.updateUI();
            System.out.println("packet loaded");
        } else if (e.getActionCommand().equals(javax.swing.JFileChooser.CANCEL_SELECTION)) {
            System.out.println("cancel selection");
        }
        dispose();
    }

}
