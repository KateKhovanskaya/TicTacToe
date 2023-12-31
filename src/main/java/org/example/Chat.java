package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.text.Format;
import java.util.Date;

public class Chat extends JFrame {
    private static final int WINDOW_POSX = 100;
    private static final int WINDOW_POSY = 100;
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 500;
    private FileHandler fileHandler= new FileHandler();
    JLabel lbLogin;
    JTextField loginField;
    JLabel lbPassword;
    JTextField passwordField;
    JTextField messageField;
    JTextArea messagesArea;
    JButton sendMessageButton;
    Chat(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Chat");
        setResizable(true);
        JPanel serverPanel = new JPanel(new GridLayout(4,1));
        lbLogin = new JLabel("Login");
        serverPanel.add(lbLogin);
        loginField = new JTextField();
        serverPanel.add(loginField);
        lbPassword = new JLabel("Password");
        serverPanel.add(lbPassword);
        passwordField = new JTextField();
        serverPanel.add(passwordField);
        setLayout(new GridLayout(2,1));
        add(serverPanel);
        JPanel clientPanel = new JPanel(new GridLayout(5,1));
        JLabel lbChatArea = new JLabel("Chat");
        clientPanel.add(lbChatArea);
        messagesArea = new JTextArea();
        clientPanel.add(messagesArea);
        JLabel lbNewMessage = new JLabel("Your message:");
        clientPanel.add(lbNewMessage);
        messageField = new JTextField();
        clientPanel.add(messageField);
        sendMessageButton = new JButton("Send");
        clientPanel.add(sendMessageButton);
        add(clientPanel);
        sendMessageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        messageField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    sendMessage();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        try{
            for (String mess:fileHandler.load("chatLog.txt")) {
                messagesArea.append(prepareLoadingMessageForChat(mess));
            }
        }catch(IOException e){}

        setVisible(true);
    }

    private void sendMessage(){
        String sendingMessage = loginField.getText() + ": " + messageField.getText() + "\n";
        messagesArea.append(sendingMessage);
        String logMessage = String.format("Date/time: %s, User: %s, message: %s\n", new Date(), loginField.getText(), messageField.getText());
        messageField.setText("");
        System.out.printf(logMessage);
        fileHandler.save(logMessage, "chatLog.txt");
    }

    private String prepareLoadingMessageForChat(String loadingLine){
        int userStart = loadingLine.indexOf("User: ");
        int messageIndex = loadingLine.indexOf(", message: ");
        String rezult = loadingLine.substring(userStart+6, messageIndex) + loadingLine.substring(messageIndex+9)+"\n";
        return rezult;
    }
}
