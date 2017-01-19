package view;

import entity.Citizen;
import view.impl.CitizenTablePanel;

import javax.swing.*;
import java.util.List;

/**
 * Created by unike on 12.01.2017.
 */
public class TabbedPane extends JTabbedPane implements Action {

    @Override
    public void create() {
        CitizenTablePanel panel = (CitizenTablePanel) getSelectedComponent();
        panel.create();
    }

    @Override
    public List<Citizen> read() {
        CitizenTablePanel panel = (CitizenTablePanel) getSelectedComponent();
        return panel.read();
    }

    @Override
    public void update() {
        CitizenTablePanel panel = (CitizenTablePanel) getSelectedComponent();
        panel.update();
    }

    @Override
    public void delete() {
        CitizenTablePanel panel = (CitizenTablePanel) getSelectedComponent();
        panel.delete();
    }

}
