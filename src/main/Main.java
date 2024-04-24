package main;

//import DeveloperTest.Thai;

import MainMenu.AudioSetting;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*;

import java.awt.*;
import java.util.Stack;

// import static com.sun.org.apache.xerces.internal.util.DOMUtil.setVisible;

public class Main {
    public static int nguoncode;
    public static double next_ex = 1;
    public static double next_ey = 1;
    public static double prev_ex = 1;
    public static double prev_ey = 1;
    public static double ex = 1;
    public static double ey = 1;
    public static Stack<String> GameState = new Stack<>();
    public static String[] states = { "MainMenu", "PlayMenu", "Setting", "AudioSetting", "KeySetting", "VideoSetting",
            "Tutorial", "GamePlay", "GamePause", "Dialogue", "Inventory", "Dialog", "LoadGame" };

    public static void pushGameState(String a) {
        GameState.push(a);
    }

    public static void popGameState() {
        GameState.pop();
    }

    public static String topGameState() {
        return GameState.peek();
    }

    public static void emptyGameState() {
        while (!GameState.empty())
            popGameState();
    }
    public static JFrame window1;
    public static JFrame window;
    public static void main(String[] args) {
        pushGameState("MainMenu");
        window1 = new JFrame();
        window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window1.setResizable(false);
        window1.setTitle("Chon nguon code");
        window1.setPreferredSize(new Dimension(900, 900));
        window1.setBackground(Color.black);
        window1.setLayout(new BoxLayout(window1.getContentPane(), BoxLayout.Y_AXIS));
        GamePanel gamePanel = new GamePanel();
        JButton button1 = new JButton("Thai");
        window1.add(button1);
        button1.addActionListener(new ButtonClicked(button1.getText(), gamePanel));

        JButton button2 = new JButton("Dung");
        window1.add(button2);
        button2.addActionListener(new ButtonClicked(button2.getText(), gamePanel));

        JButton button3 = new JButton("Tuan");
        window1.add(button3);
        button3.addActionListener(new ButtonClicked(button3.getText(), gamePanel));

        JButton button4 = new JButton("NormalClassRoom");
        window1.add(button4);
        button4.addActionListener(new ButtonClicked(button4.getText(), gamePanel));

        JButton button5 = new JButton("ComputerRoom");
        window1.add(button5);
        button5.addActionListener(new ButtonClicked(button5.getText(), gamePanel));

        JButton button6 = new JButton("Stadium");
        window1.add(button6);
        button6.addActionListener(new ButtonClicked(button6.getText(), gamePanel));

        JButton button7 = new JButton("Library");
        window1.add(button7);
        button7.addActionListener(new ButtonClicked(button7.getText(), gamePanel));

        JButton button8 = new JButton("MyRoom");
        window1.add(button8);
        button8.addActionListener(new ButtonClicked(button8.getText(), gamePanel));

        JButton button9 = new JButton("Section_3");
        window1.add(button9);
        button9.addActionListener(new ButtonClicked(button9.getText(), gamePanel));

        JButton button10 = new JButton("Section_2");
        window1.add(button10);
        button10.addActionListener(new ButtonClicked(button10.getText(), gamePanel));
        // window.add(gamePanel);
        // window.pack();
        // window.setSize(400, 400);
        window1.pack();

        window1.setSize(400, 400);
        // window.pack();
        window1.setLocationRelativeTo(null);
        window1.setVisible(true);
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
        Main.window = new JFrame();
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
            case "Section_3": {
                Main.nguoncode = 9;
                break;
            }
            case "Section_2": {
                Main.nguoncode = 10;
            }
        }
        Main.window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Main.window.setResizable(false);
        Main.window.setTitle("2D Adventure");
        Main.window.setLayout(new BoxLayout(Main.window.getContentPane(), BoxLayout.Y_AXIS));


        WindowListener listener = new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                // Frame frame = (Frame) evt.getSource();
                // System.out.println("Closing = " + frame.getTitle());
                gamePanel.isRunning = false;
                Main.emptyGameState();
                Main.pushGameState("MainMenu");
            }
        };
        Main.window.add(gamePanel);
        Main.window.addWindowListener(listener);
        Main.window.pack();
        Main.window.setLocationRelativeTo(null);
        Main.window.setVisible(true);
        gamePanel.startGameThread();
    }
}