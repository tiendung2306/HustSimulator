package main;

//import DeveloperTest.Thai;

import MainMenu.AudioSetting;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*;

import java.awt.*;
import java.util.Stack;

public class Main {
    public static int nguoncode;
    public static int ex = 1;
    public static Stack<String> GameState = new Stack<>();
    public static String[] states = { "MainMenu", "PlayMenu", "Setting", "AudioSetting", "KeySetting", "VideoSetting",
            "Tutorial", "GamePlay", "GamePause", "Dialogue", "Inventory"};

    public static void pushGameState(String a) {
        GameState.push(a);
    }

    public static void popGameState() {
        GameState.pop();
    }

    public static String topGameState() {
        return GameState.peek();
    }

    public static void emptyGameState() {while(!GameState.empty())  popGameState();}

    public static void main(String[] args) {
        pushGameState("MainMenu");
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Chon nguon code");
        window.setPreferredSize(new Dimension(500, 500));
        window.setBackground(Color.black);
        window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
        GamePanel gamePanel = new GamePanel();
        JButton button1 = new JButton("Thai");
        window.add(button1);
        button1.addActionListener(new ButtonClicked(button1.getText(), gamePanel));

        JButton button2 = new JButton("Dung");
        window.add(button2);
        button2.addActionListener(new ButtonClicked(button2.getText(), gamePanel));

        JButton button3 = new JButton("Tuan");
        window.add(button3);
        button3.addActionListener(new ButtonClicked(button3.getText(), gamePanel));

        JButton button4 = new JButton("NormalClassRoom");
        window.add(button4);
        button4.addActionListener(new ButtonClicked(button4.getText(), gamePanel));

        JButton button5 = new JButton("ComputerRoom");
        window.add(button5);
        button5.addActionListener(new ButtonClicked(button5.getText(), gamePanel));

        JButton button6 = new JButton("Stadium");
        window.add(button6);
        button6.addActionListener(new ButtonClicked(button6.getText(), gamePanel));

        JButton button7 = new JButton("Library");
        window.add(button7);
        button7.addActionListener(new ButtonClicked(button7.getText(), gamePanel));

        JButton button8 = new JButton("MyRoom");
        window.add(button8);
        button8.addActionListener(new ButtonClicked(button8.getText(), gamePanel));
        // window.add(gamePanel);
        // window.pack();
        // window.setSize(400, 400);
        window.pack();

        window.setSize(400, 400);
        // window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        // gamePanel.startGameThread();
    }
}

class ButtonClicked implements ActionListener {
    String buttonName;
    GamePanel gamePanel;

    public ButtonClicked(String buttonName, GamePanel gamePanel) {
        this.buttonName = buttonName;
        this.gamePanel = gamePanel;
    }

    public void actionPerformed(ActionEvent e) {
        JFrame window = new JFrame();
        switch (this.buttonName) {
            case "Thai": {
                Main.nguoncode = 1;
                // if (Main.topGameState().equals(Main.states[3]))
                // window.add(Main.audioSetting);
                break;
            }
            case "Dung": {
                Main.nguoncode = 2;
                break;
            }
            case "Tuan": {
                Main.nguoncode = 3;
                break;
            }
            case "NormalClassRoom": {
                Main.nguoncode = 4;
                break;
            }
            case "ComputerRoom": {
                Main.nguoncode = 5;
                break;
            }
            case "Stadium": {
                Main.nguoncode = 6;
                break;
            }
            case "Library": {
                Main.nguoncode = 7;
                break;
            }
            case "MyRoom": {
                Main.nguoncode = 8;
                break;
            }
        }

        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Adventure");
        window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
        window.add(gamePanel);

        WindowListener listener = new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                // Frame frame = (Frame) evt.getSource();
                // System.out.println("Closing = " + frame.getTitle());
                gamePanel.isRunning = false;
                Main.emptyGameState();
                Main.pushGameState("MainMenu");
            }
        };
        window.addWindowListener(listener);

        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gamePanel.startGameThread();
    }
}
