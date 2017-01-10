package com.company.Panels;

import javax.swing.*;
import java.awt.*;

/**
 * Created by unike on 09.01.2017.
 */
public class Loading extends JPanel{

    public Loading() throws InterruptedException {
        JLabel label = new JLabel("Загрузка вычислительных мощностей");
        add(label, new GridBagConstraints(0,0,2,1,1,1,
                GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),1,1));
        setPreferredSize(new Dimension(300,70));
        setBackground(Color.cyan);
    }
}
