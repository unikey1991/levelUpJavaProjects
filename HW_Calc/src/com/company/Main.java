package com.company;


import com.company.Panels.*;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static String bufer1 = "";
    public static String bufer2 = "";

    public static void main(String[] args) throws InterruptedException {


        JFrame frameLoading = new JFrame();
        frameLoading.setLocationRelativeTo(null);
        frameLoading.setResizable(false);
        frameLoading.setLayout(new GridBagLayout());
        Loading loading = new Loading();
        frameLoading.setUndecorated(true);
        frameLoading.add(loading);
        frameLoading.pack();

        JProgressBar progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setMinimum(0);
        progressBar.setMaximum(10);


        loading.add(progressBar);
        frameLoading.setVisible(true);
        for (int i = progressBar.getMinimum(); i <= progressBar.getMaximum(); i++ ){
            Thread.sleep(100);
            progressBar.setValue(i);
        }


        frameLoading.setVisible(false);


        //forma
        JFrame frame = new JFrame("Calc by unikey");

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(new GridBagLayout());
        MainPanel mainPanel = new MainPanel();
        mainPanel.setBackground(Color.red);
        frame.add(mainPanel);
        frame.setVisible(true);
        frame.pack();
    }

}


