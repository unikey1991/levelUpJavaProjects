import view.impl.CitizenTablePanel;
import view.impl.CreateCitizenDialog;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(600,500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        CitizenTablePanel tablePanel = new CitizenTablePanel();
        tablePanel.setVisible(true);

        frame.add(tablePanel);
        frame.setVisible(true);
    }
}
