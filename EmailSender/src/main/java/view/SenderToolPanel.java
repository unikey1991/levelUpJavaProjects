package view;

import dao.impl.UserDAOImpl;
import entity.AccountType;
import view.impl.SenderPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by unike on 06.05.2017.
 */
public class SenderToolPanel extends JPanel {

    private final UserDAOImpl userDAO;
    private final SenderPanel senderPanel;

    private static final int ACTION_BTN_W = 75;
    private static final int ACTION_BTN_H = 50;
    private static final int BTN_Y = 310;
    private static final int BTN_X_STEP = 100;

    public SenderToolPanel(UserDAOImpl userDAO, SenderPanel senderPanel) {
        this.userDAO = userDAO;
        this.senderPanel = senderPanel;
        initLayout();
    }

    private void initLayout() {
        setSize(new Dimension(200,400));
        setVisible(true);
        initButtons();
    }

    private void initButtons(){
        createActionButtons();
    }

    private void createActionButtons() {
        JButton[] actionButtons = {new JButton("send message"),
                new JButton("load packet"),
                new JButton("packet send"),};
        ActionListener[] listeners = {sendMessageListener(),
        loadPacketListener(),
        packetSendListener()};

        for (int i = 0; i < actionButtons.length; i++){
            JButton button = actionButtons[i];
            button.addActionListener(listeners[i]);
            button.setBounds(200 + BTN_X_STEP * i, BTN_Y, ACTION_BTN_W, ACTION_BTN_H);
            add(button);
        }

        if (userDAO.mainUser.getAccountType() == AccountType.ADMIN){
            JButton[] adminButtons = {new JButton("delete packet"),
            new JButton("set assign")};
            ActionListener[] adminListeners = {deletePacket(), setAssign()};
            for (int i = 0; i < adminButtons.length; i++){
                JButton button = adminButtons[i];
                button.addActionListener(adminListeners[i]);
                button.setBounds(200 + BTN_X_STEP * i + BTN_X_STEP*actionButtons.length, BTN_Y, ACTION_BTN_W, ACTION_BTN_H);
                add(button);
            }
        }

    }

    private ActionListener sendMessageListener() {
        return e -> senderPanel.sendMesage();
    }

    private ActionListener loadPacketListener() {
        return e -> senderPanel.loadPacket();
    }

    private ActionListener packetSendListener() {
        return e -> {
            try {
                senderPanel.packetSend();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        };
    }

    private ActionListener deletePacket() {return  e -> senderPanel.delete();}

    private ActionListener setAssign() {return  e -> senderPanel.update();}
}
