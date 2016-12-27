import javax.swing.*;

/**
 * Created by java on 27.12.2016.
 */
public class Menu {

    private JMenuBar menuBar;

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public Menu() {
        menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem fileOpen = new JMenuItem("File Open");
        JMenuItem fileClose = new JMenuItem("File Close");
        menuFile.add(fileOpen);
        menuFile.add(fileClose);
        menuBar.add(menuFile);
        JMenu menuEdit = new JMenu("Edit");
        JMenuItem editCopy = new JMenuItem("Copy");
        JMenuItem editPaste = new JMenuItem("Paste");
        menuEdit.add(editCopy);
        menuEdit.add(editPaste);
        menuBar.add(menuEdit);
    }
}

