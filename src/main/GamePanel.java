package main;

import Collision.Collision;
import Inventory.Inventory;
import ItemInteract.ItemInteract;
import MainMenu.*;
import animation.Animation_player;
import area.*;
import entity.Player;
import map.Map;
import sound.Sound;
import tile.TileManager;
import sound.SoundManager;
import Mouse.MouseManager;
import phone.Phone;
import section_selection.Section_selection;

import javax.swing.*;

import Keyboard.KeyboardManager;
import tileWorldMap.TileWorldMapManager;
import worldMap.Section_3;

import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // SCREEN SETTINGS
    public final int originalTileSize = 16;
    public final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = maxScreenCol * tileSize;
    public final int screenHeight = maxScreenRow * tileSize;

    // =================================================================================================================
    // MAP SETTINGS
    public int maxMapCol;
    public int maxMapRow;
    public int mapWidth; 
    public int mapHeight; 

    public TileManager tileManager = new TileManager(this);
    public TileWorldMapManager tileWorldMapManager = new TileWorldMapManager(this);
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
    MyRoom myRoom = new MyRoom(this);
    Section_3 section_3 = new Section_3(this);

    // =================================================================================================
    int a, b, c, d;

    // ==============================================================================================

    public MouseManager mouseManager = new MouseManager(this);
    public Map currentMap = null; // map hien tai
    Section_2 section_2 = new Section_2(this);

    KeyboardManager keyboardManager = new KeyboardManager();
    public UI ui = new UI(this);
    public KeyHandler keyH = new KeyHandler();
    public Collision collision = new Collision(this);
    public Player player = new Player(this, keyH, tileManager, ui);
    public Inventory inventory = new Inventory(this);
    public Phone phone = new Phone(this);
    ItemInteract itemInteract = new ItemInteract(this);

    public Section_selection section_selection = new Section_selection(this);

    public boolean isRunning = false;
    boolean isDrawPhone = false;

    // ==================================================================================================================

    public void setSizeMap(int x, int y) {
        maxMapCol = x;
        maxMapRow = y;
        mapWidth = tileSize * maxMapCol;
        mapHeight = tileSize * maxMapRow;
    }

    // ===========================================================

    public void setSizePlayer(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;

    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public int getD() {
        return d;
    }

    // =========================================================

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
                newGame();
                break;
            }
            case 2: {
                newGame();
                break;
            }
            case 4: {
                if (Main.GameState.empty() || !Main.topGameState().equals("GamePlay"))
                    Main.pushGameState("GamePlay");
                currentMap = normalClassroom;
                break;
            }
            case 5: {
                if (Main.GameState.empty() || !Main.topGameState().equals("GamePlay"))
                    Main.pushGameState("GamePlay");
                currentMap = computerRoom;
                break;
            }
            case 6: {
                if (Main.GameState.empty() || !Main.topGameState().equals("GamePlay"))
                    Main.pushGameState("GamePlay");
                currentMap = stadium;
                break;
            }
            case 7: {
                if (Main.GameState.empty() || !Main.topGameState().equals("GamePlay"))
                    Main.pushGameState("GamePlay");
                currentMap = library;
                break;
            }
            case 8: {
                if (Main.GameState.empty() || !Main.topGameState().equals("GamePlay"))
                    Main.pushGameState("GamePlay");
                currentMap = myRoom;
                break;
            }
            case 9: {
                if (Main.GameState.empty() || !Main.topGameState().equals("GamePlay"))
                    Main.pushGameState("GamePlay");
                currentMap = section_3;
                break;
            }
            case 10: {
                if (Main.GameState.empty() || !Main.topGameState().equals("GamePlay"))
                    Main.pushGameState("GamePlay");
                currentMap = section_2;
                break;
            }
        }
        keyboardManager.init();
        keySetting.init();
    }

    private void stopThread() {
        SoundManager.stopAllSound();
    }

    public void run() {
        soundManager.addSound(new Sound("piano_music", "res/sound/pianos-by-jtwayne-7-174717.wav"));
        // SoundManager.loopSound("piano_music");

        soundManager.addSound(new Sound("guitar_music", "res/sound/acoustic-guitar-loop-f-91bpm-132687.wav"));
        // soundManager.loopSound("guitar_music");
        Init();

        double drawInterval = 1000000000 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while (gameThread != null) {
            if (!isRunning) {
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
        if(isDrawPhone) {
            phone.update();
        }
        itemInteract.update();

        if (Main.nguoncode == 1) {
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
        }
        if (Main.topGameState().equals("Inventory"))
            inventory.update();
        else inventory.currentIndex = 0;
        if (Main.topGameState().equals("GamePlay")) {
            if (keyH.isInteract) {
                if (player.ButtonInteract)
                    collision.update();
                else keyH.isInteract = false;
            }
        } else if (Main.topGameState().equals("Dialogue")) {
            if (!keyH.isInteract)
                Main.popGameState();
        }

        if (Main.topGameState().equals("GamePlay")) {
            if (keyH.isPhonePressed) {
                // System.out.println("phone-kun xin chao tat ca cac ban");
                isDrawPhone = !isDrawPhone;
                keyH.isPhonePressed = false;
            }
        }

    }
    // =================================================================================================================

    public void paintComponent(Graphics g) {
        setSizePlayer(0,-13,0,0);
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
            }
            case 3: {
                section_selection.operation(g);
                break;
            }
            case 4: {
                setSizePlayer(0,-13,0,0);
                setSizeMap(21,18);
                normalClassroom.draw(g2);
                break;
            }
            case 5: {
                setSizeMap(21,18);
                computerRoom.draw(g2);
                break;
            }
            case 6: {
                setSizeMap(21,18);
                stadium.draw(g2);
                break;
            }
            case 7: {
                setSizeMap(21,18);
                library.draw(g2);
                break;
            }
            case 8: {
                setSizePlayer(-33,-70,60,60);
                setSizeMap(36,23);
                myRoom.draw(g2);
                break;
            }
            case 9: {
//                setSizeMap(82,86);
                setSizeMap(64,65);
                section_3.draw(g2);
                break;
            }
            case 10: {
                setSizeMap(64,65);
                section_2.draw(g2);
            }
        }

        if (Main.topGameState().equals(Main.states[7]) || Main.topGameState().equals("Dialogue") || Main.topGameState().equals("Inventory") || Main.topGameState().equals("GamePause")) {
            if (currentMap == normalClassroom) {
                setSizeMap(21,18);
                normalClassroom.draw(g2);
            } else if (currentMap == myRoom) {
                setSizePlayer(-33,-70,60,60);
                setSizeMap(36,23);
                myRoom.draw(g2);
            }
            player.draw(g2);
            ui.draw(g2);
            inventory.draw(g2);
        }

        if (isDrawPhone) {
            phone.draw(g2);
            // isDrawPhone = false;
        }
        g2.dispose();
    }

    public void newGame() {
        currentMap = myRoom;
    }
}

