package com.company.Panels;

import javax.swing.*;
import java.awt.*;

/**
 * Created by unike on 07.01.2017.
 */
public class MainPanel extends JPanel{
    private static JTextField textArea;
    private NumsPanel numsPanel;
    private OperationPanel operationPanel;


    public MainPanel(){
        setLayout(new GridBagLayout());
        textArea = new JTextField(12);
        textArea.setPreferredSize(new Dimension(300,50));
        textArea.setFont(new Font("times_new_roman",Font.BOLD,20));
        textArea.setEditable(false);
        //textArea.setBackground(Color.black);
        add(textArea, new GridBagConstraints(0,0,2,1,1,1,
                GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),1,1));


        numsPanel = new NumsPanel();
        numsPanel.setBackground(Color.black);
        add(numsPanel, new GridBagConstraints(0,1,1,1,1,1,
                GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),1,1));

        operationPanel = new OperationPanel();
        operationPanel.setBackground(Color.black);
        add(operationPanel, new GridBagConstraints(1,1,1,1,1,1,
                GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),1,1));
    }

    public static String getTextFromTextArea() {
        return textArea.getText();
    }

    public static void setTextInTextArea(String textArea) {
        MainPanel.textArea.setText(textArea);
    }
}
