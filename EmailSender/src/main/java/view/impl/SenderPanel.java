package view.impl;

import dao.impl.PacketDAOImpl;
import dao.impl.UserDAOImpl;
import email.EmailMessage;
import entity.AccountType;
import entity.Packet;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;

/**
 * Created by unike on 06.05.2017.
 */
public class SenderPanel extends JPanel implements view.Action {

    private final JTable table;
    private final PacketTableModel packetTableModel;
    private final PacketDAOImpl packetDAO;
    private final UserDAOImpl userDAO;
    private final CreateLoadPacketDialog dialog;
    private final CreateEmailSendDialog sendDialog;
    private final java.util.List<EmailMessage> messageList;


    private final static long MAX_MESSAGES_FOR_USER = 100;
    private final JLabel messagesLeftValue = new JLabel("0");
    private final JLabel messagesLeftLabel = new JLabel("Message left:");

    public SenderPanel(PacketDAOImpl packetDAO, UserDAOImpl userDAO) {
        this.userDAO = userDAO;
        this.packetTableModel = new PacketTableModel();
        this.table = new JTable(packetTableModel);
        this.packetDAO = packetDAO;
        this.dialog = new CreateLoadPacketDialog(userDAO, packetDAO, packetTableModel, table);
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
        //checkMessageCounter();
        messagesLeftLabel.setBounds(600, 0, 65, 25);
        messagesLeftValue.setBounds(600, 35, 65, 25);

        add(messagesLeftLabel);
        add(messagesLeftValue);
    }

    public void checkMessageCounter() {
        if (null != userDAO.mainUser.getDateOfStartMessgesCounter()) {
            long difference = new Date().getTime() - userDAO.mainUser.getDateOfStartMessgesCounter().getTime();
            int days = (int) (difference / (24 * 60 * 60 * 1000));
            if (days > 7) {
                userDAO.mainUser.setQuantityOfMessagesLeftToSendInMounth(MAX_MESSAGES_FOR_USER);
                userDAO.mainUser.setDateOfStartMessgesCounter(new Date());
                userDAO.update(userDAO.mainUser);
            }
        } else {
            userDAO.mainUser.setQuantityOfMessagesLeftToSendInMounth(MAX_MESSAGES_FOR_USER);
            userDAO.mainUser.setDateOfStartMessgesCounter(new Date());
            userDAO.update(userDAO.mainUser);
        }
        updateMessageCounter();
    }

    private void updateMessageCounter() {
        messagesLeftValue.setText(String.valueOf(userDAO.mainUser.getQuantityOfMessagesLeftToSendInMounth()));
        revalidate();
    }


    @Override
    public void create() {

    }

    @Override
    public void read() {
        if (userDAO.mainUser.getAccountType() == AccountType.ADMIN) {
            packetTableModel.setPacketList(packetDAO.read());
        } else {
            ArrayList<Packet> packetArrayList = packetDAO.read();
            for (Packet p : packetArrayList) {
                if (p.getAssignedTo().getId() == userDAO.mainUser.getId()) {
                    System.out.println(p.getAssignedTo());
                    System.out.println(userDAO.mainUser);
                    packetTableModel.addPacketToList(p);
                }
            }
        }
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
        if (packetDAO.senderFromFileList.getMessages().size() > userDAO.mainUser.getQuantityOfMessagesLeftToSendInMounth()) {

            System.out.println("This action will exceed the available quantity");
            return;
        } else {
            sendDialog.setVisible(true);
            if (sendDialog.isOkPressed()) {
                EmailMessage emailMessage = sendDialog.getEntity();
                messageList.add(emailMessage);
                packetDAO.producer.sendMessage(messageList);
                userDAO.mainUser.setQuantityOfMessagesLeftToSendInMounth(userDAO.mainUser.getQuantityOfMessagesLeftToSendInMounth() - 1);
                userDAO.update(userDAO.mainUser);
                updateMessageCounter();
            }
        }
    }

    @Override
    public void loadPacket() {
        dialog.setVisible(true);
    }

    @Override
    public void packetSend() throws InterruptedException, IOException {
        Packet packet = packetTableModel.getSelectedRowData(table.getSelectedRow());
        packetDAO.currentPacket = packet.getFile();
        packetDAO.senderFromFileList.readFromFile(packetDAO.currentPacket);
        if (packetDAO.senderFromFileList.getMessages().size() > userDAO.mainUser.getQuantityOfMessagesLeftToSendInMounth()) {

            System.out.println("This action will exceed the available quantity");
            return;
        } else {
            packetDAO.senderFromFileList.startSender();
            userDAO.mainUser.setQuantityOfMessagesLeftToSendInMounth(userDAO.mainUser.getQuantityOfMessagesLeftToSendInMounth() - packetDAO.senderFromFileList.getMessages().size());
            userDAO.update(userDAO.mainUser);
            updateMessageCounter();
        }
    }
}
