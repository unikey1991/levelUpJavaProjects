package view.impl;

import dao.impl.UserDAOImpl;
import entity.User;
import view.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by unike on 06.05.2017.
 */
public class AdminPanel extends JPanel implements view.Action {

    private final JTable table;
    private final UserTableModel userTableModel;
    private final CreateUserDialog dialog = new CreateUserDialog();
    private UserDAOImpl userDAO;


    public AdminPanel(UserDAOImpl userDAO) {
        this.userTableModel = new UserTableModel();
        this.table = new JTable(userTableModel);
        this.userDAO = userDAO;
        setName("Admin panel");
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
        dialog.setVisible(true);
        if (dialog.isOkPressed()) {
            User user = dialog.getEntity();
            userTableModel.getUserList().add(user);
            userDAO.create(user);
            table.updateUI();
        }
    }

    @Override
    public void read() {
        userTableModel.setUserList(userDAO.read());
        table.updateUI();
    }

    @Override
    public void update() {
        User user = userTableModel.getSelectedRowData(table.getSelectedRow());
        userDAO.update(user);

    }

    @Override
    public void delete() {
        User user = userTableModel.getSelectedRowData(table.getSelectedRow());
        userTableModel.getUserList().remove(user);
        userDAO.delete(user);
        table.updateUI();
    }

    @Override
    public void sendMesage() {

    }

    @Override
    public void loadPacket() {

    }

    @Override
    public void packetSend() {

    }
}
