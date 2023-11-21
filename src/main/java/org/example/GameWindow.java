package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static final int WINDOW_POSX = 100;
    private static final int WINDOW_POSY = 100;
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_HEIGHT = 300;
    Map map = new Map();

    GameWindow(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TicTacToe");
        setResizable(false);

        JPanel panBottom = new JPanel(new GridLayout(1,2));
        JButton btnStart = new JButton("New Game");
        JButton btnExit = new JButton("Exit");
        panBottom.add(btnStart);
        panBottom.add(btnExit);
        add(panBottom, BorderLayout.SOUTH);
        add(map);
        SettingsWindow settings = new SettingsWindow(this);
        settings.setVisible(true);
        btnExit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        btnStart.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                settings.setVisible(true);
            }
        });
        setVisible(true);
    }

    void startNewGame(int mode, int fSzX, int fSzY, int wLen){

        map.startNewGame(mode, fSzX, fSzY, wLen);
    }

}
