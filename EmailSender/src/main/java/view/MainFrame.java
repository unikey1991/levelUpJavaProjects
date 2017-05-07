package view;

import dao.impl.PacketDAOImpl;
import dao.impl.UserDAOImpl;
import entity.AccountType;
import view.impl.AdminPanel;
import view.impl.CreateLoginDialog;
import view.impl.SenderPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by unike on 03.05.2017.
 */
public class MainFrame extends JFrame {

    private CreateLoginDialog dialog;


    public MainFrame() throws HeadlessException, InterruptedException {
        init();
    }

    private void init() throws InterruptedException {


        Container container = getContentPane();
        TabbedPanel tabbedPanel = new TabbedPanel();
        UserDAOImpl userDAO = new UserDAOImpl();
        PacketDAOImpl packetDAO = new PacketDAOImpl();
        dialog = new CreateLoginDialog(userDAO);
        AdminPanel adminPanel = new AdminPanel(userDAO);
        adminPanel.read();
        SenderPanel senderPanel = new SenderPanel(packetDAO);
        senderPanel.read();


        //tabbedPanel.add(loginPanel);
        container.add(tabbedPanel, BorderLayout.CENTER);

        setBounds(0, 0, 800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        while (true){
            if (dialog.isLogged())break;
            Thread.sleep(2000);
        }


        tabbedPanel.add(senderPanel);
        senderPanel.add(new SenderToolPanel(tabbedPanel, userDAO), BorderLayout.PAGE_END);
        revalidate();
        repaint();
        if (userDAO.mainUser.getAccountType() == AccountType.ADMIN ){
            tabbedPanel.add(adminPanel);
            adminPanel.add(new AdminToolPanel(tabbedPanel), BorderLayout.PAGE_END);
        }


        setVisible(true);
    }




}
