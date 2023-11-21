package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ServerRun extends JFrame {
    private static final int WINDOW_POSX = 100;
    private static final int WINDOW_POSY = 100;
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_HEIGHT = 300;
    JButton btnStart = new JButton("Start Server");
    JButton btnExit = new JButton("Stop Server");
    boolean isServisWorking;

    ServerRun(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Server");
        setResizable(false);
        setLayout(new GridLayout(1,2));
        add(btnStart);
        add(btnExit);
        setVisible(true);
        btnStart.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(!isServisWorking){
                    isServisWorking = true;
                    System.out.println("ServerIsWorking: "+ isServisWorking);
                }
            }
        });
        btnExit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(isServisWorking){
                    isServisWorking = false;
                    System.out.println("ServerIsWorking: "+ isServisWorking);
                }
            }
        });
    }

}
