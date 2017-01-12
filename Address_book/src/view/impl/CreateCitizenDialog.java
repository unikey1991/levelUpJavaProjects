package view.impl;

import javax.swing.*;
import java.awt.*;
import java.util.LongSummaryStatistics;

import entity.Citizen;
import view.Dialog;

/**
 * Created by java on 10.01.2017.
 */
public class CreateCitizenDialog extends Dialog{

    private JTextField firstName;
    private JTextField lastName;
    private JTextField age;
    private JTextField streetId;

    public CreateCitizenDialog(){
        initComponent();
    }

    @Override
    public Citizen getEntity() {
        Citizen citizen = createCitizen();
        return citizen;
    }

    private void clearFields(){
        firstName.setText("");
        lastName.setText("");
        age.setText("");
        streetId.setText("");
    }

    private Citizen createCitizen(){
        String fName = firstName.getText();
        String lName = lastName.getText();
        int age = Integer.parseInt(this.age.getText());
        String sId = this.streetId.getText();
        Long streetId = sId.isEmpty()? null:Long.parseLong(sId);
        return new Citizen(fName, lName, age, streetId);

    }

    private void initComponent() {
        initLabels();
        initTextFields();
    }

    private void initLabels() {
        JLabel firstName = new JLabel("First Name");
        JLabel lastName = new JLabel("Last Name");
        JLabel age = new JLabel("Age");
        JLabel streetID = new JLabel("Street id:");

        firstName.setBounds(30,0,65,25);
        lastName.setBounds(30,35,65,25);
        age.setBounds(30,70,65,25);
        streetID.setBounds(30,105,65,25);

        panel.add(firstName);
        panel.add(lastName);
        panel.add(age);
        panel.add(streetID);
    }

    private void initTextFields(){
        firstName = new JTextField();
        lastName = new JTextField();
        age = new JTextField();
        streetId = new JTextField();

        firstName.setBounds(110,0,100,25);
        lastName.setBounds(110,35,100,25);
        age.setBounds(110,70,100,25);
        streetId.setBounds(110,105,100,25);

        panel.add(firstName);
        panel.add(lastName);
        panel.add(age);
        panel.add(streetId);
    }
}
