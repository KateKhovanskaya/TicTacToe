package org.example;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;
    JButton btnStart = new JButton("Start Game");
    JPanel settingsPanel;
    JSlider fieldSizeSlider;
    JSlider winLengthSlider;
    JRadioButton humanVsAi;
    JRadioButton humanVsHuman;
    SettingsWindow(GameWindow gameWindow){
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        btnStart.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                gameWindow.startNewGame(
                        humanVsAi.isSelected()?0:1,
                        fieldSizeSlider.getValue(),
                        fieldSizeSlider.getValue(),
                        winLengthSlider.getValue());
                setVisible(false);
            }
        });
        settingsPanel = new JPanel(new GridLayout(8,1));
        JLabel modeLabel = new JLabel("Выберите режим игры");
        settingsPanel.add(modeLabel);
        humanVsAi = new JRadioButton("Человек против компьютера");
        humanVsAi.setSelected(true);
        humanVsHuman = new JRadioButton("Человек против человека");
        ButtonGroup modeGroup = new ButtonGroup();
        modeGroup.add(humanVsAi);
        modeGroup.add(humanVsHuman);
        settingsPanel.add(humanVsAi);
        settingsPanel.add(humanVsHuman);
        JLabel fieldSizeLabel = new JLabel("Установленный размер поля:");
        settingsPanel.add(fieldSizeLabel);
        fieldSizeSlider = new JSlider(3,10);
        fieldSizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                fieldSizeLabel.setText("Установленный размер поля: " + fieldSizeSlider.getValue());
            }
        });
        settingsPanel.add(fieldSizeSlider);
        JLabel winLengthLabel = new JLabel("Установленная длина для победы:");
        settingsPanel.add(winLengthLabel);
        winLengthSlider = new JSlider(3,10);
        winLengthSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                winLengthLabel.setText("Установленная длина для победы: " + winLengthSlider.getValue());
            }
        });
        settingsPanel.add(winLengthSlider);
        settingsPanel.add(btnStart);
        add(settingsPanel);
    }
}
