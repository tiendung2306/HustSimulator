package main;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;

public class Main{
    public static String Gametime = "MainMenu";
    public static String Backtime;
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Adventure");
        GamePanel gamePanel = new GamePanel();

        window.add(gamePanel);
        // window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
        // JButton button1 = new JButton("Start Loop Song 1");
        // window.add(button1);
        // button1.addActionListener(new ButtonClicked(button1.getText(), gamePanel));

        // JButton button2 = new JButton("Start Loop Song 2");
        // window.add(button2);
        // button2.addActionListener(new ButtonClicked(button2.getText(), gamePanel));

        // JButton button3 = new JButton("Stop");
        // window.add(button3);
        // button3.addActionListener(new ButtonClicked(button3.getText(), gamePanel));

        // JButton button4 = new JButton("Volume Up");
        // window.add(button4);
        // button4.addActionListener(new ButtonClicked(button4.getText(), gamePanel));

        // JButton button5 = new JButton("Volume Down");
        // window.add(button5);
        // button5.addActionListener(new ButtonClicked(button5.getText(), gamePanel));

        // JButton button6 = new JButton("Volume Mute");
        // window.add(button6);
        // button6.addActionListener(new ButtonClicked(button6.getText(), gamePanel));

        // window.pack();

        // window.setSize(400, 400);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gamePanel.startGameThread();
    }

}

// class ButtonClicked implements ActionListener {

//     String buttonName = "";
//     GamePanel gamePanel = new GamePanel();

//     public ButtonClicked(String buttonName, GamePanel gamePanel) {
//         this.buttonName = buttonName;
//         this.gamePanel = gamePanel;
//     }

//     public void actionPerformed(ActionEvent e) {
//         if (this.buttonName == "Start Loop Song 1") {
//             this.gamePanel.soundManager.loopSound("piano_music");
//             // System.out.println("start loop");
//         } else if (this.buttonName == "Start Loop Song 2") {
//             this.gamePanel.soundManager.loopSound("guitar_music");
//             // System.out.println("start loop");
//         } else if (this.buttonName == "Stop") {
//             this.gamePanel.soundManager.stopAllSound();
//             // System.out.println("stop");
//         } else if (this.buttonName == "Volume Up") {
//             this.gamePanel.soundManager.volumeUp();
//         } else if (this.buttonName == "Volume Down") {
//             this.gamePanel.soundManager.volumeDown();
//         } else if (this.buttonName == "Volume Mute") {
//             this.gamePanel.soundManager.volumeMute();
//         }
//         System.out.println("You have clicked the ACTIVE button " + this.buttonName);
//     }
// }