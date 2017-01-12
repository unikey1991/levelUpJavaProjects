package com.company.Panels;

import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by unike on 07.01.2017.
 */
public class NumsPanel extends JPanel {

    private String buttonsTitle[] = new String[]{"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", "."};

    public NumsPanel() {
        setLayout(new GridLayout(4, 3));
        JButton button;
        for (String x : buttonsTitle) {
            button = new JButton(x);
            Font font = new Font("Arial",Font.BOLD,30);
            button.setFont(font);
            //button.setPreferredSize(new Dimension(50, 50));
            button.addActionListener(new Buttonlistener());
            add(button);
        }
    }

    public class Buttonlistener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton) {
                String nameButton = (((JButton) e.getSource()).getText());
                System.out.println(nameButton);
                if (nameButton.equals(".")) {
                    if (!MainPanel.getTextFromTextArea().contains(".") && !MainPanel.getTextFromTextArea().equals(""))
                        MainPanel.setTextInTextArea(MainPanel.getTextFromTextArea() + nameButton);
                }
                else if (OperationPanel.operator.equals("")) MainPanel.setTextInTextArea(MainPanel.getTextFromTextArea() + nameButton);
                else if (Main.bufer1.equals("")) {
                    Main.bufer1 = MainPanel.getTextFromTextArea();
                    MainPanel.setTextInTextArea(Main.bufer2 + nameButton);
                }
                else MainPanel.setTextInTextArea(MainPanel.getTextFromTextArea() + nameButton);
            }
        }
    }

}
