package view;

import view.impl.AdminPanel;

import javax.swing.*;

/**
 * Created by unike on 04.05.2017.
 */
public class TabbedPanel extends JTabbedPane implements Action {
    @Override
    public void create() {
        AdminPanel panel = (AdminPanel) getSelectedComponent();
        panel.create();
    }

    @Override
    public void read() {
        AdminPanel panel = (AdminPanel) getSelectedComponent();
        panel.read();
    }

    @Override
    public void update() {
        AdminPanel panel = (AdminPanel) getSelectedComponent();
        panel.update();
    }

    @Override
    public void delete() {
        AdminPanel panel = (AdminPanel) getSelectedComponent();
        panel.delete();
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
