package main;

import MainMenu.*;
import entity.Player;
import map.Map;
import sound.Sound;
import tile.TileManager;
import sound.SoundManager;
import Mouse.MouseManager;
import area_selection.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import area.NormalClassroom;
import area.ComputerRoom;
import area.Stadium;
import area.Library;

import javax.swing.*;

import Keyboard.KeyboardManager;

import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // SCREEN SETTINGS
    public final int originalTileSize = 16;
    public final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    // =================================================================================================================
    // MAP SETTINGS
    public final int maxMapCol = 50;
    public final int maxMapRow = 50;
    public final int mapWidth = tileSize * maxMapCol;
    public final int mapHeight = tileSize * maxMapRow;

    public TileManager tileManager = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    public CollisionPlayer collision = new CollisionPlayer(this);
    Thread gameThread;
    SoundManager soundManager = new SoundManager();

    public static Main_Menu mainMenu = new Main_Menu();
    public static NextMainMenu nextMainMenu = new NextMainMenu();
    public static Setting setting = new Setting();
    public static AudioSetting audioSetting = new AudioSetting();
    public static KeySetting keySetting = new KeySetting();
    public static VideoSetting videoSetting = new VideoSetting();

    MouseListener_Mainmenu mouseListenerMainmenu = new MouseListener_Mainmenu(this);
    MouseMotionListener_Mainmenu mouseMotionListenerMainmenu = new MouseMotionListener_Mainmenu(this, mainMenu,
            nextMainMenu, setting, audioSetting, keySetting, videoSetting);
    // Khai báo lớp NormalClassroom vào GamePanel
    NormalClassroom normalClassroom = new NormalClassroom(this);
    ComputerRoom computerRoom = new ComputerRoom(this);
    Library library = new Library(this);
    Stadium stadium = new Stadium(this);

    MouseManager mouseManager = new MouseManager();
    public Map presentMap = null;
    KeyboardManager keyboardManager = new KeyboardManager();
    public UI ui = new UI(this);
    public Player player = new Player(this, keyH, tileManager, ui);

    public boolean isRunning = false;

    //==================================================================================================================

    double FPS = 60;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setSize(400, 400);
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        this.Mouse();
    }

    public void Mouse() {
        this.addMouseMotionListener(mouseMotionListenerMainmenu);
        this.addMouseListener(mouseListenerMainmenu);
        this.addMouseListener(mouseManager);

        this.addKeyListener(keyboardManager);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
        isRunning = true;
    }

    public void Init() {

        switch (Main.nguoncode) {
            case 1: {
                presentMap = normalClassroom;
                break;
            }
            case 2: {
                presentMap = normalClassroom;
                break;
            }
            case 4: {
                if (Main.GameState.empty() || !Main.topGameState().equals("GamePlay"))
                    Main.pushGameState("GamePlay");
                presentMap = normalClassroom;
                break;
            }
            case 5: {
                if (Main.GameState.empty() || !Main.topGameState().equals("GamePlay"))
                    Main.pushGameState("GamePlay");
                presentMap = computerRoom;
                break;
            }
            case 6: {
                if (Main.GameState.empty() || !Main.topGameState().equals("GamePlay"))
                    Main.pushGameState("GamePlay");
                presentMap = stadium;
                break;
            }
            case 7: {
                if (Main.GameState.empty() || !Main.topGameState().equals("GamePlay"))
                    Main.pushGameState("GamePlay");
                presentMap = library;
                break;
            }
        }
        keyboardManager.init();
    }

    private void stopThread() {
        SoundManager.stopAllSound();
    }

    public void run() {
        soundManager.addSound(new Sound("piano_music", "res/sound/pianos-by-jtwayne-7-174717.wav"));
        SoundManager.loopSound("piano_music");

        soundManager.addSound(new Sound("guitar_music", "res/sound/acoustic-guitar-loop-f-91bpm-132687.wav"));
        // soundManager.loopSound("guitar_music");
        Init();

        double drawInterval = 1000000000 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while (gameThread != null) {
            if (isRunning == false) {
                stopThread();
                break;
            }

            update();

            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime /= 1000000;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    // =================================================================================================================
    public void update() {
        // System.out.println(MouseManager.lastClickedX);
        // System.out.println(MouseManager.lastClickedY);
        soundManager.update();

        player.update();

        if (Main.nguoncode == 1) {
            player.update();
            if (Main.topGameState().equals(Main.states[0])) {
                mainMenu.update();
            } else if (Main.topGameState().equals(Main.states[1])) {
                nextMainMenu.update();
            } else if (Main.topGameState().equals(Main.states[2])) {
                setting.update();
            } else if (Main.topGameState().equals(Main.states[3])) {
                audioSetting.update();
            } else if (Main.topGameState().equals(Main.states[4]))
                keySetting.update();
            else if (Main.topGameState().equals(Main.states[5]))
                videoSetting.update();
        } else if (Main.nguoncode == 2) {
            player.update();
            if (Main.topGameState().equals(Main.states[0])) {
                mainMenu.update();
            } else if (Main.topGameState().equals(Main.states[1])) {
                nextMainMenu.update();
            } else if (Main.topGameState().equals(Main.states[2])) {
                setting.update();
            } else if (Main.topGameState().equals(Main.states[3])) {
                audioSetting.update();
            } else if (Main.topGameState().equals(Main.states[4]))
                keySetting.update();
            else if (Main.topGameState().equals(Main.states[5]))
                videoSetting.update();
        } else {
            if (Main.topGameState().equals("GamePlay")) {
                if (player.ButtonInteract && keyH.interactShow){
                    player.collisionHandling();
                    Main.pushGameState("Dialogue");
                } else player.update();
            }
            else if (Main.topGameState().equals("Dialogue")){
                if (!keyH.interactShow)
                    Main.popGameState();
            }
        }
    }
    // =================================================================================================================

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        switch (Main.nguoncode) {
            case 1: {
                if (Main.topGameState().equals(Main.states[0])) {
                    mainMenu.draw(g2);
                } else if (Main.topGameState().equals(Main.states[1])) {
                    nextMainMenu.draw(g2);
                } else if (Main.topGameState().equals(Main.states[2]))
                    setting.draw(g2);
                else if (Main.topGameState().equals(Main.states[3]))
                    audioSetting.draw(g2);
                else if (Main.topGameState().equals(Main.states[4]))
                    keySetting.draw(g2);
                else if (Main.topGameState().equals(Main.states[5]))
                    videoSetting.draw(g2);
                else if (Main.topGameState().equals(Main.states[7])) {
                    if (presentMap == normalClassroom) {
                        normalClassroom.draw(g2);
                        player.draw(g2);
                    }
                    break;
                }
            }
            case 2: {
                if (Main.topGameState().equals(Main.states[0])) {
                    mainMenu.draw(g2);
                } else if (Main.topGameState().equals(Main.states[1])) {
                    nextMainMenu.draw(g2);
                } else if (Main.topGameState().equals(Main.states[2]))
                    setting.draw(g2);
                else if (Main.topGameState().equals(Main.states[3]))
                    audioSetting.draw(g2);
                else if (Main.topGameState().equals(Main.states[4]))
                    keySetting.draw(g2);
                else if (Main.topGameState().equals(Main.states[5]))
                    videoSetting.draw(g2);
                else if (Main.topGameState().equals(Main.states[7])) {
                    if (presentMap == normalClassroom) {
                        normalClassroom.draw(g2);
                        player.draw(g2);
                    }
                    break;
                }
            }
            case 3: {
                //====
                break;
            }
            case 4: {
                normalClassroom.draw(g2);
                player.draw(g2);
                ui.draw(g2);
                break;
            }
            case 5: {
                computerRoom.draw(g2);
                player.draw(g2);
                ui.draw(g2);
                break;
            }
            case 6: {
                stadium.draw(g2);
                player.draw(g2);
                ui.draw(g2);
                break;
            }
            case 7: {
                library.draw(g2);
                player.draw(g2);
                ui.draw(g2);
                break;
            }
        }
        g2.dispose();
    }

    public void newGame() {
        presentMap = normalClassroom;
    }
}