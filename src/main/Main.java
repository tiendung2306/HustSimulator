package main;

import DeveloperTest.Khai;
import DeveloperTest.Son;
import DeveloperTest.Thai;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.Stack;

public class Main{
    public static Stack<String> GameState = new Stack<>();
    public static void pushGameState(String a){
        GameState.push(a);
    }
    public static String popGameState(){
        return GameState.pop();
    }
    public static String topGameState(){
        return GameState.peek();
    }


    public static void main(String[] args) {
        pushGameState("MainMenu");
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Chọn nguồn code");
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

         JButton button3 = new JButton("Khai");
         window.add(button3);
         button3.addActionListener(new ButtonClicked(button3.getText(), gamePanel));

         JButton button4 = new JButton("Tuan");
         window.add(button4);
         button4.addActionListener(new ButtonClicked(button4.getText(), gamePanel));

         JButton button5 = new JButton("Son");
         window.add(button5);
         button5.addActionListener(new ButtonClicked(button5.getText(), gamePanel));


        // window.add(gamePanel);
        // window.pack();
        // window.setSize(400, 400);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        //gamePanel.startGameThread();
    }

}

 class ButtonClicked implements ActionListener {

     String buttonName = "";
     GamePanel gamePanel = new GamePanel();

     public ButtonClicked(String buttonName, GamePanel gamePanel) {
         this.buttonName = buttonName;
         this.gamePanel = gamePanel;
     }

     public void actionPerformed(ActionEvent e) {
         if (this.buttonName == "Thai") {
             JFrame window = new JFrame();
             window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             window.setResizable(false);
             window.setTitle("2D Adventure");
             window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
             Thai thai = new Thai();
             window.add(thai);
             window.pack();
             window.setLocationRelativeTo(null);
             window.setVisible(true);
             thai.startGameThread();
         } else if (this.buttonName == "Dung") {
             JFrame window = new JFrame();
             window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             window.setResizable(false);
             window.setTitle("2D Adventure");
             window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
             Thai thai = new Thai();
             window.add(thai);
             window.pack();
             window.setLocationRelativeTo(null);
             window.setVisible(true);
             thai.startGameThread();
         } else if (this.buttonName == "Khai") {
             JFrame window = new JFrame();
             window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             window.setResizable(false);
             window.setTitle("2D Adventure");
             window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
             Thai thai = new Thai();
             window.add(thai);
             window.pack();
             window.setLocationRelativeTo(null);
             window.setVisible(true);
             thai.startGameThread();
         } else if (this.buttonName == "Tuan") {
             JFrame window = new JFrame();
             window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             window.setResizable(false);
             window.setTitle("2D Adventure");
             window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
             Thai thai = new Thai();
             window.add(thai);
             window.pack();
             window.setLocationRelativeTo(null);
             window.setVisible(true);
             thai.startGameThread();
         } else if (this.buttonName == "Son") {
             JFrame window = new JFrame();
             window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             window.setResizable(false);
             window.setTitle("2D Adventure");
             window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
             Thai thai = new Thai();
             window.add(thai);
             window.pack();
             window.setLocationRelativeTo(null);
             window.setVisible(true);
             thai.startGameThread();
         }
     }
 }