package view.impl;

import dao.impl.PacketDAOImpl;
import dao.impl.UserDAOImpl;
import email.EmailMessage;
import entity.Packet;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;

/**
 * Created by unike on 06.05.2017.
 */
public class SenderPanel extends JPanel implements view.Action{

    private final JTable table;
    private final PacketTableModel packetTableModel;
    //private final CreateUserDialog dialog = new CreateUserDialog(); //todo
    private final PacketDAOImpl packetDAO;
    private final UserDAOImpl userDAO;
    private final CreateLoadPacketDialog dialog;
    private final CreateEmailSendDialog sendDialog;
    private final java.util.List<EmailMessage> messageList;


    public SenderPanel(PacketDAOImpl packetDAO, UserDAOImpl userDAO) {
        this.userDAO = userDAO;
        this.packetTableModel = new PacketTableModel();
        this.table = new JTable(packetTableModel);
        this.packetDAO = packetDAO;
        this.dialog = new CreateLoadPacketDialog(userDAO, packetDAO);
        this.sendDialog = new CreateEmailSendDialog(userDAO, packetDAO);
        this.messageList = new ArrayList<>();
        setName("Sender panel");
        init();
    }

    private void init() {
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setSize(new Dimension(595, 300));
        add(scrollPane);
        setSize(new Dimension(595, 300));
    }


    @Override
    public void create() {

    }

    @Override
    public void read() {
        packetTableModel.setPacketList(packetDAO.read());
        table.updateUI();
    }

    @Override
    public void update() {
        Packet packet = packetTableModel.getSelectedRowData(table.getSelectedRow());
        packetDAO.update(packet);
    }

    @Override
    public void delete() {
        Packet packet = packetTableModel.getSelectedRowData(table.getSelectedRow());
        packetTableModel.getPacketList().remove(packet);
        packetDAO.delete(packet);
        table.updateUI();
    }

    @Override
    public void sendMesage() {
        sendDialog.setVisible(true);
        if (sendDialog.isOkPressed()){
            EmailMessage emailMessage = sendDialog.getEntity();
            messageList.add(emailMessage);
            packetDAO.producer.sendMessage(messageList);
        }
    }

    @Override
    public void loadPacket() {
        dialog.setVisible(true);
        if (dialog.isOkPressed()){
            Packet packet = dialog.getEntity();
            packetTableModel.getPacketList().add(packet);
            packetDAO.create(packet);
            table.updateUI();
            System.out.println("packet loaded");
        }
    }

    @Override
    public void packetSend() throws InterruptedException, IOException {
        Packet packet = packetTableModel.getSelectedRowData(table.getSelectedRow());
        packetDAO.currentPacket=packet.getFile();
        packetDAO.senderFromFileList.startSender(packetDAO.currentPacket);
    }
}
