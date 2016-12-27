

import com.sun.glass.ui.Size;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by java on 27.12.2016.
 */
public class MyFrame extends JFrame {

    public MyFrame() throws InterruptedException {
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setTitle("This is my title");
        frame.add(new LabelPanel());
        Menu menu = new Menu();

        frame.add(menu.getMenuBar(), BorderLayout.PAGE_START);

        //frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.setExtendedState(MAXIMIZED_BOTH);
        Thread.sleep(2000);
        frame.setExtendedState(NORMAL);

        JButton button = new JButton("Click me");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("vot eto povorot");
            }
        });




        frame.add(button);
        button.setSize(30,10);

        frame.setVisible(true);

    }
}
