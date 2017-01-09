import javax.swing.*;
import java.awt.*;

/**
 * Created by java on 27.12.2016.
 */
public class LabelPanel extends JPanel {

    public LabelPanel(){
        JLabel plaintLabel = new JLabel("Plain Small Label");
        add(plaintLabel);

        JLabel fancyLabel = new JLabel("Димон говорит привет");

        Font fancyFont = new Font("Serif", Font.BOLD | Font.ITALIC, 32);

        fancyLabel.setFont(fancyFont);
        fancyLabel.setSize(200,200);

        Icon icon = new ImageIcon("images.jpg");

        fancyLabel.setIcon(icon);


        fancyLabel.setHorizontalAlignment(JLabel.RIGHT);

        add(fancyLabel);
    }
}
