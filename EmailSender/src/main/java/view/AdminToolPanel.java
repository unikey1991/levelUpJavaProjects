package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by unike on 06.05.2017.
 */
public class AdminToolPanel extends JPanel {


    private final TabbedPanel tabbedPanel;

    private static final int ACTION_BTN_W = 75;
    private static final int ACTION_BTN_H = 50;
    private static final int BTN_Y = 310;
    private static final int BTN_X_STEP = 100;

    public AdminToolPanel(TabbedPanel tabbedPanel) {
        this.tabbedPanel = tabbedPanel;
        initLayout();
    }

    private void initLayout() {
        setSize( new Dimension(200, 400));
        setVisible(true);
        initButtons();
    }

    private void initButtons() {
        createActionButtons();
    }


    private void createActionButtons() {
        JButton[] actionButtons = {new JButton("create"),
                new JButton("read"),
                new JButton("update"),
                new JButton("delete")};
        ActionListener[] listeners = {createListener(),
                readListener(),
                updateListener(),
                deleteListener()};

        for (int i = 0; i < actionButtons.length; i++) {
            JButton button = actionButtons[i];
            button.addActionListener(listeners[i]);
            button.setBounds(200 + BTN_X_STEP * i, BTN_Y, ACTION_BTN_W, ACTION_BTN_H);
            add(button);
        }
    }
    private ActionListener createListener() {
        return e -> tabbedPanel.create();
    }

    private ActionListener readListener() {
        return e -> tabbedPanel.read();
    }

    private ActionListener updateListener() {
        return e -> tabbedPanel.update();
    }

    private ActionListener deleteListener() {
        return e -> tabbedPanel.delete();
    }


}
