package com.company.Panels;

import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by unike on 07.01.2017.
 */
public class OperationPanel extends JPanel {

    static String operator = "";

    private String buttonsTitle[] = new String[]{"C", "*", "+", "/", "-", "="};

    public OperationPanel() {
        setLayout(new GridLayout(4, 2));
        JButton button;
        for (String x : buttonsTitle) {
            button = new JButton(x);
            Font font = new Font("Arial", Font.BOLD, 30);
            button.setFont(font);
            //button.setPreferredSize(new Dimension(50, 50));
            button.addActionListener(new OperationPanel.Buttonlistener());
            add(button);
        }
    }

    public class Buttonlistener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton) {
                String nameButton = (((JButton) e.getSource()).getText());
                switch (nameButton) {
                    case "C":
                        clear();
                        MainPanel.setTextInTextArea("");
                        break;
                    case "=":
                        if (!operator.equals("")) {
                            calc(operator);
                        }
                        break;
                    case "*":
                        if ("" == operator && !MainPanel.getTextFromTextArea().equals("")) operator = "*";
                        else if ("" == operator) {
                            operator = "*";
                            Main.bufer1 = "0";
                        }
                        break;
                    case "+":
                        if ("" == operator && !MainPanel.getTextFromTextArea().equals("")) operator = "+";
                        else if ("" == operator) {
                            operator = "+";
                            Main.bufer1 = "0";
                        }
                        break;
                    case "/":
                        if ("" == operator && !MainPanel.getTextFromTextArea().equals("")) operator = "/";
                        else if ("" == operator) {
                            operator = "/";
                            Main.bufer1 = "0";
                        }
                        break;
                    case "-":
                        if ("" == operator && !MainPanel.getTextFromTextArea().equals("")) operator = "-";
                        else if ("" == operator) {
                            operator = "-";
                            Main.bufer1 = "0";
                        }
                        break;
                }
            }
        }
    }

    public void clear() {
        Main.bufer1 = "";
        Main.bufer2 = "" +
                ;
        operator = "";
    }

    public void calc(String operator) {
        Main.bufer2 = MainPanel.getTextFromTextArea().substring(MainPanel.getTextFromTextArea().indexOf(operator) + 1);
        if (Main.bufer1.equals("")) Main.bufer1 = "0";
        if (!Main.bufer2.equals("")) {
            switch (operator) {
                case "*":
                    MainPanel.setTextInTextArea(Double.toString(Double.parseDouble(Main.bufer1) * Double.parseDouble(Main.bufer2)));
                    clear();
                    break;
                case "+":
                    MainPanel.setTextInTextArea(Double.toString(Double.parseDouble(Main.bufer1) + Double.parseDouble(Main.bufer2)));
                    clear();
                    break;
                case "/":
                    if (Double.parseDouble(Main.bufer2) == 0.0) MainPanel.setTextInTextArea("ERROR!!!!111");
                    else
                        MainPanel.setTextInTextArea(Double.toString(Double.parseDouble(Main.bufer1) / Double.parseDouble(Main.bufer2)));
                    clear();
                    break;
                case "-":
                    MainPanel.setTextInTextArea(Double.toString(Double.parseDouble(Main.bufer1) - Double.parseDouble(Main.bufer2)));
                    clear();
                    break;
            }
        }
    }

    public static String getOperator() {
        return operator;
    }
}
