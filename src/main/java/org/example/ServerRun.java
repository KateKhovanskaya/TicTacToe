package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class ServerRun extends JFrame implements Listener{
    private static final int WINDOW_POSX = 100;
    private static final int WINDOW_POSY = 100;
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_HEIGHT = 300;
    JButton btnStart = new JButton("Start Server");
    JButton btnExit = new JButton("Stop Server");
    JButton showLog = new JButton("Show Log");
    ButtonsListener chatServer = new ChatServer(this);
//    boolean isServisWorking;
    ArrayList<String> log = new ArrayList<>();


    ServerRun(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Server");
        setResizable(false);
        setLayout(new GridLayout(2,1));
        JPanel btnPanel = new JPanel(new GridLayout(1,2));
        btnPanel.add(btnStart);
        btnPanel.add(btnExit);
        add(btnPanel);
        add(showLog);
        setVisible(true);
        btnStart.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                chatServer.listeningButtonCommands(true);
            }
        });
        btnExit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                chatServer.listeningButtonCommands(false);
            }
        });
        showLog.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println(log);
            }
        });
    }
    @Override
    public void  messageRes(String message){
//        System.out.println(message);
        log.add(String.format("\n" + message));
    }
}
