package main;

import MainMenu.*;
import entity.Player;
import sound.Sound;
import tile.TileManager;
import sound.SoundManager;
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

    Main_Menu mainMenu = new Main_Menu();
    NextMainMenu nextMainMenu = new NextMainMenu();
    Setting setting = new Setting();
    AudioSetting audioSetting = new AudioSetting();
    KeySetting keySetting = new KeySetting();
    VideoSetting videoSetting = new VideoSetting();
    MouseListener_Mainmenu mouseListenerMainmenu = new MouseListener_Mainmenu(this);
    MouseMotionListener_Mainmenu mouseMotionListenerMainmenu = new MouseMotionListener_Mainmenu(this, mainMenu,
            nextMainMenu, setting, audioSetting, keySetting, videoSetting);
    // Khai báo lớp NormalClassroom vào GamePanel
    NormalClassroom normalClassroom = new NormalClassroom(this);
    ComputerRoom computerRoom = new ComputerRoom(this);
    Library library = new Library(this);
    Stadium stadium = new Stadium(this);
    public Player player = new Player(this, keyH, stadium, tileManager);
    KeyboardManager keyboardManager = new KeyboardManager();

    double FPS = 60;

    // =================================================================================================================
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setSize(320, 240);
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        this.Mouse();
    }

    public void Mouse() {
        this.addMouseMotionListener(mouseMotionListenerMainmenu);
        this.addMouseListener(mouseListenerMainmenu);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void Init() {
        keyboardManager.init();
    }

    public void run() {
        soundManager.addSound(new Sound("piano_music", "res/sound/pianos-by-jtwayne-7-174717.wav"));
        // soundManager.loopSound("piano_music");

        soundManager.addSound(new Sound("guitar_music", "res/sound/acoustic-guitar-loop-f-91bpm-132687.wav"));
        // soundManager.loopSound("guitar_music");
        Init();

        double drawInterval = 1000000000 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while (gameThread != null) {

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
        player.update();

        soundManager.update();
        if (Main.nguoncode == 1) {
            if (Main.topGameState().equals("MainMenu")) {
                mainMenu.update();
            } else if (Main.topGameState().equals("NextMainMenu")) {
                nextMainMenu.update();
            } else if (Main.topGameState().equals("Setting")) {
                setting.update();
            } else if (Main.topGameState().equals("audiosetting"))
                audioSetting.update();
            else if (Main.topGameState().equals("keysetting"))
                keySetting.update();
            else if (Main.topGameState().equals("videosetting"))
                videoSetting.update();
        }
    }
    // =================================================================================================================

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        switch (Main.nguoncode) {
            case 1 -> {
                if (Main.topGameState().equals("MainMenu")) {
                    mainMenu.draw(g2);
                } else if (Main.topGameState().equals("NextMainMenu")) {
                    nextMainMenu.draw(g2);
                } else if (Main.topGameState().equals("Setting"))
                    setting.draw(g2);
                else if (Main.topGameState().equals("audiosetting"))
                    audioSetting.draw(g2);
                else if (Main.topGameState().equals("keysetting"))
                    keySetting.draw(g2);
                else if (Main.topGameState().equals("videosetting"))
                    videoSetting.draw(g2);
            }
            case 2 -> {

            }
            case 3 -> {

            }
            case 4 -> {
                normalClassroom.draw(g2);
                player.draw(g2);
            }
            case 5 -> {
                computerRoom.draw(g2);
                player.draw(g2);
            }
            case 6 -> {
                stadium.draw(g2);
                player.draw(g2);
            }
            case 7 -> {
                library.draw(g2);
                player.draw(g2);
            }
        }
        g2.dispose();
    }
}