import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by java on 27.12.2016.
 */
public class OperationPanel extends JPanel {

    public OperationPanel(){

        GridLayout gridLayout = new GridLayout(3,2, 5, 5);

        String[] opS = {"/", "*","+","-","=","C"};

        JButton button;
        for (String s : opS){
            button = new JButton(s);
            button.addActionListener(getClickListener());
            gridLayout.addLayoutComponent(s, button);
            add(button);
        }

        setLayout(gridLayout);

    }

    public ActionListener getClickListener() {
        return  new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
            }
        };
    }
}
