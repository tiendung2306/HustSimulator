package main;

import java.util.Stack;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class Main {
    public static double next_ex = 1;
    public static double next_ey = 1;
    public static double prev_ex = 1;
    public static double prev_ey = 1;
    public static double ex = 1;
    public static double ey = 1;
    public static Stack<String> GameState = new Stack<>();
    public static String[] states = { "MainMenu", "PlayMenu", "Setting", "AudioSetting", "KeySetting", "VideoSetting",
            "Tutorial", "GamePlay", "GamePause", "Dialogue", "Inventory", "Dialog", "LoadGame", "Map", "Section", "PauseGame", "LoadGame2" };

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
    public static JFrame window;
    public static void main(String[] args) {
        pushGameState("MainMenu");
        GamePanel gamePanel = new GamePanel();
        Main.window = new JFrame();
        Main.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main.window.setResizable(false);
        Main.window.setTitle("2D Adventure");
        Main.window.setLayout(new BoxLayout(Main.window.getContentPane(), BoxLayout.Y_AXIS));
        Main.window.add(gamePanel);
        Main.window.pack();
        Main.window.setLocationRelativeTo(null);
        Main.window.setVisible(true);
        gamePanel.startGameThread();
    }
}
