package view;

import dao.impl.PacketDAOImpl;
import dao.impl.UserDAOImpl;
import email.EmailSenderFromFileList;
import entity.AccountType;
import view.impl.AdminPanel;
import view.impl.CreateLoginDialog;
import view.impl.SenderPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by unike on 03.05.2017.
 */
public class MainFrame extends JFrame {

    private CreateLoginDialog dialog;


    public MainFrame() throws HeadlessException, InterruptedException, IOException {
        init();
    }

    private void init() throws InterruptedException, IOException {


        Container container = getContentPane();
        TabbedPanel tabbedPanel = new TabbedPanel();
        UserDAOImpl userDAO = new UserDAOImpl();
        PacketDAOImpl packetDAO = new PacketDAOImpl();
        dialog = new CreateLoginDialog(userDAO);
        AdminPanel adminPanel = new AdminPanel(userDAO);

        SenderPanel senderPanel = new SenderPanel(packetDAO,userDAO);



        //tabbedPanel.add(loginPanel);
        container.add(tabbedPanel, BorderLayout.CENTER);

        setBounds(0, 0, 600, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        if (dialog.isLogged()) {
            tabbedPanel.add(senderPanel);
            senderPanel.add(new SenderToolPanel(userDAO, senderPanel), BorderLayout.PAGE_END);
            revalidate();
            repaint();
            if (userDAO.mainUser.getAccountType() == AccountType.ADMIN) {
                tabbedPanel.add(adminPanel);
                adminPanel.add(new AdminToolPanel(adminPanel), BorderLayout.PAGE_END);
            }


            setVisible(true);
        }
        adminPanel.read();
        senderPanel.read();
        senderPanel.checkMessageCounter();
    }


}
