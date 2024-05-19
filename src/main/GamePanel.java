package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Collision.Collision;
import Content.Chapter;
import Content.Chapter1;
import Content.Chapter2;
import Content.Chapter3;
import GUI.DirectionIndicator;
import GUI.MissionDescription;
import Inventory.Inventory;
import Keyboard.KeyboardManager;
import LoadSaveGame.LoadSaveGameSystem;
import MainMenu.AudioSetting;
import MainMenu.KeySetting;
import MainMenu.LoadGame;
import MainMenu.LoadGame2;
import MainMenu.Main_Menu;
import MainMenu.MouseListener_Mainmenu;
import MainMenu.MouseMotionListener_Mainmenu;
import MainMenu.NextMainMenu;
import MainMenu.PauseGame;
import MainMenu.Setting;
import MainMenu.Toturial;
import MainMenu.VideoSetting;
import Mouse.MouseManager;
import area.ComputerRoom;
import area.MyRoom;
import area.NormalClassroom;
import area.Section_1;
import area.Section_2;
import area.Section_3;
import area.Stadium;
import area.C2.C2_hall;
import area.C2.C2_hallway;
import area.D3.D3_hallway;
import area.D3.D3_secondfloor_hallway;
import area.D3_5.D3_5_hallway_secondfloor;
import area.Library.Firstfloor_library;
import area.Library.Library;
import entity.Player;
import map.Map;
import phone.Phone;
import section_selection.Section_selection;
import sound.Sound;
import sound.SoundManager;
import tile.TileManager;
import time.TimeSystem;

public class GamePanel extends JPanel implements Runnable {

    // SCREEN SETTINGS
    public static double scale = 3 * Main.ex;
    public static double screenWidth = 256 * scale;
    public static double screenHeight = 192 * scale;

    // =================================================================================================================
    // MAP SETTINGS

    public TileManager tileManager = new TileManager(this);
    Thread gameThread;
    public SoundManager soundManager = new SoundManager();
    public TimeSystem timeSystem = new TimeSystem();

    public static Main_Menu mainMenu = new Main_Menu();
    public static NextMainMenu nextMainMenu = new NextMainMenu();
    public static Setting setting = new Setting();
    public static AudioSetting audioSetting = new AudioSetting();
    public static KeySetting keySetting = new KeySetting();
    public static VideoSetting videoSetting = new VideoSetting();
    public static LoadGame loadGame = new LoadGame();
    public static PauseGame pauseGame = new PauseGame();
    public static LoadGame2 loadGame2 = new LoadGame2();
    public static Toturial toturial = new Toturial();

    MouseListener_Mainmenu mouseListenerMainmenu = new MouseListener_Mainmenu(this);
    MouseMotionListener_Mainmenu mouseMotionListenerMainmenu = new MouseMotionListener_Mainmenu(this, mainMenu,
            nextMainMenu, setting, audioSetting, keySetting, videoSetting, loadGame, pauseGame, loadGame2);
    // public Section_3 section_3 = new Section_3(this);

    // =================================================================================================
    public static double next_screenWidth = 256 * scale;
    public static double next_screenHeight = 192 * scale;
    public static double prev_screenWidth = 256 * scale;
    public static double prev_screenHeight = 192 * scale;
    public static double next_scale = 3;
    public static double prev_scale = 3;

    // ==============================================================================================

    public MouseManager mouseManager = new MouseManager(this);
    public Map currentMap = null;

    KeyboardManager keyboardManager = new KeyboardManager();
    public UI ui = new UI(this);
    public Phone phone = new Phone(this);
    public MissionDescription missionDescription = new MissionDescription(this);
    public DirectionIndicator directionIndicator = new DirectionIndicator(this);
    public KeyHandler keyH = new KeyHandler(this);
    public Collision collision = new Collision(this);
    public Player player = new Player(this, keyH, tileManager, ui);
    public Inventory inventory = new Inventory(this);

    public Section_selection section_selection = new Section_selection(this);
    public Section_3 section_3 = new Section_3(this);
    public Section_2 section_2 = new Section_2(this);
    public Section_1 section_1 = new Section_1(this);
    public boolean isRunning = false;
    public NormalClassroom normalClassroom = new NormalClassroom(this);
    public ComputerRoom computerRoom = new ComputerRoom(this);
    public Library library = new Library(this);
    public Stadium stadium = new Stadium(this);
    public MyRoom myRoom = new MyRoom(this);
    public C2_hall c2_hall = new C2_hall(this);
    public C2_hallway c2_hallway = new C2_hallway(this);
    public D3_hallway d3_hallway = new D3_hallway(this);
    public D3_secondfloor_hallway d3_secondfloor_hallway = new D3_secondfloor_hallway(this);
    public D3_5_hallway_secondfloor d3_5_hallway_secondfloor = new D3_5_hallway_secondfloor(this);

    // ==========================================================

    public Chapter currentChapter = new Chapter();

    public Chapter1 chapter1 = new Chapter1(this);
    public Chapter2 chapter2 = new Chapter2(this);
    public Chapter3 chapter3 = new Chapter3(this);

    public LoadSaveGameSystem loadSaveGameSystem = new LoadSaveGameSystem(this);
    // =========================================================

    double FPS = 60;

    public GamePanel() {
        this.setPreferredSize(new Dimension((int) screenWidth, (int) screenHeight));
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

    public void initSound() {
        soundManager.addSound(new Sound("loot_item", "res/sound/item-equip-6904.wav"));
        soundManager.addSound(new Sound("open_door", "res/sound/open-door-1-14550.wav"));
        soundManager.addSound(new Sound("foot_step", "res/sound/am_thanh_di_tren_duong.wav"));
        soundManager.addSound(new Sound("footstep_down_stairs", "res/sound/di_xuong_bac_thang.wav"));
        soundManager.addSound(new Sound("footstep_up_stairs", "res/sound/di_len_bac_thang.wav"));
        soundManager.addSound(new Sound("piano_music", "res/sound/pianos-by-jtwayne-7-174717.wav"));
        soundManager.addSound(new Sound("nhac_nen01", "res/sound/nhac_nen_1.wav"));
        soundManager.addSound(new Sound("nhac_nen02", "res/sound/nhac_nen_2.wav"));
        soundManager.addSound(new Sound("gap_gv", "res/sound/am_thanh_chap2.wav"));
        soundManager.addSound(new Sound("tra_loi_sai", "res/sound/nhac_tra_loi_sai.wav"));
        soundManager.addSound(new Sound("an_mi", "res/sound/an_mi.wav"));
    }

    public void screenResize() {
        missionDescription.screenResize();
        myRoom.resetTile();
        normalClassroom.resetTile();
        computerRoom.resetTile();
        library.resetTile();
        stadium.resetTile();
        currentMap.loadMap(this);
        missionDescription.screenResize();
        player.reSize();
        currentMap.reSizeMap();
        inventory.ScreenResize();
        phone.screenResize();
        ui.screenResize();
        section_selection.screenResize();

    }

    public void Init() {
        newGame();
        initSound();
        currentChapter = chapter1;
        currentMap.loadMap(this);
        keyboardManager.init();
        keySetting.init();
    }

    private void stopThread() {
        SoundManager.stopAllSound();
    }

    public void run() {
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
            // //test
            // if(true) {
            // if(TimeSystem.getCurrentSystemTimeInMilliseconds() - prevTime >= 5500) {
            // prevTime = TimeSystem.getCurrentSystemTimeInMilliseconds();
            // SoundManager.pauseSound("piano_music");
            // isPause = true;
            // }
            // if(TimeSystem.getCurrentSystemTimeInMilliseconds() - prevTime >= 3000 &&
            // isPause) {
            // System.out.println("panikkk");
            // SoundManager.resumeSound("piano_music");
            // isPause = false;
            // isDone = true;
            // }

            // }
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
        if (TimeSystem.getCurrentSystemTimeInMilliseconds() - Collision.prevTime >= 1300 && Collision.resumeSound) {
            SoundManager.resumeSound("nhac_nen01", true);
            System.out.println("Meos chayj");
            Collision.resumeSound = false;
        }
        timeSystem.update();
        soundManager.update();
        tileManager.update();
        currentChapter.update();
        phone.update();
        player.update();
        inventory.update();
        missionDescription.update();
        directionIndicator.update();
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
        else if (Main.topGameState().equals(Main.states[12]))
            loadGame.update();
        else if (Main.topGameState().equals("PauseGame"))
            pauseGame.update();
        else if (Main.topGameState().equals(Main.states[16]))
            loadGame2.update();
        else if (Main.topGameState().equals("Tutorial"))
            toturial.update();
        if (Main.topGameState().equals("GamePlay")) {
            if (keyH.isInteract) {
                if (player.ButtonInteract)
                    collision.update();
                else
                    keyH.isInteract = false;
            }
            if (keyH.isPhonePressed) {
                if (inventory.isExist("Iphone 100 ProMax")) {
                    KeyboardManager.resetReleasedKey();
                    phone.isDrawPhone = !phone.isDrawPhone;
                    phone.setPhoneState("Screen Saver");
                }
                keyH.isPhonePressed = false;
            }
        } else {
            if (keyH.isPhonePressed) {
                keyH.isPhonePressed = false;
            }
        }

        if (Main.topGameState().equals("Loading")) {
            if (!currentMap.map_exchange_effect.isRunning())
                Main.popGameState();
        }
    }
    // =================================================================================================================

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        // RenderingHints rh1 = new RenderingHints(
        // RenderingHints.KEY_RENDERING,
        // RenderingHints.VALUE_RENDER_SPEED);
        // g2.setRenderingHints(rh1);

        if (Main.topGameState().equals(Main.states[0]))
            mainMenu.draw(g2);
        else if (Main.topGameState().equals(Main.states[1]))
            nextMainMenu.draw(g2);
        else if (Main.topGameState().equals(Main.states[2]))
            setting.draw(g2);
        else if (Main.topGameState().equals(Main.states[3]))
            audioSetting.draw(g2);
        else if (Main.topGameState().equals(Main.states[4]))
            keySetting.draw(g2);
        else if (Main.topGameState().equals(Main.states[5]))
            videoSetting.draw(g2);
        else if (Main.topGameState().equals(Main.states[12]))
            loadGame.draw(g2);
        else if (Main.topGameState().equals("PauseGame"))
            pauseGame.draw(g2);
        else if (Main.topGameState().equals(Main.states[16]))
            loadGame2.draw(g2);
        else if (Main.topGameState().equals("Tutorial"))
            toturial.draw(g2);
        if (Main.topGameState().equals("GamePlay") || Main.topGameState().equals("Dialog")
                || Main.topGameState().equals("GamePlay")
                || Main.topGameState().equals("Inventory")
                || Main.topGameState().equals("Dialogue")) {
            if (currentChapter != chapter1 || chapter1.IntroFinished) {
                drawMap(g2);
                directionIndicator.drawArrow(g2);
                player.draw(g2);
                inventory.draw(g2);
                missionDescription.draw(g2);
                phone.draw(g2);
            }
        }
        ui.draw(g2);

        if (Main.topGameState().equals("Map")) {
            section_selection.operation(g);
        }

        else if (Main.topGameState().equals("Loading")) {
            currentMap.map_exchange_effect.operation(g);
        }

    }

    public void drawMap(Graphics2D g2) {
        if (currentMap == myRoom) {
            myRoom.draw(g2);
        }
        if (currentMap == normalClassroom) {
            normalClassroom.draw(g2);
        }
        if (currentMap == computerRoom) {
            computerRoom.draw(g2);
        }
        if (currentMap == library) {
            library.draw(g2);
        }
        if (currentMap == stadium) {
            stadium.draw(g2);
        }
        if (currentMap == section_1) {
            section_1.draw(g2);
        }
        if (currentMap == section_2) {
            section_2.draw(g2);
        }
        if (currentMap == section_3) {
            section_3.draw(g2);
        }
        if (currentMap == c2_hall) {
            c2_hall.draw(g2);
        }
        if (currentMap == c2_hallway) {
            c2_hallway.draw(g2);
        }
        if (currentMap == d3_hallway) {
            d3_hallway.draw(g2);
        }
        if (currentMap == d3_secondfloor_hallway) {
            d3_secondfloor_hallway.draw(g2);
        }
        if (currentMap == d3_5_hallway_secondfloor) {
            d3_5_hallway_secondfloor.draw(g2);
        }
    }

    public void newGame() {
        currentMap = myRoom;
        currentChapter = chapter1;
        chapter1.currentTimeline = 0;
        chapter1.IntroFinished = false;
        chapter1.completedAct = 0;
    }

    public void loadChapter(String chapter) {
        if (chapter.equals("chap 1")) {
            currentMap = myRoom;
            currentChapter = chapter1;
            chapter1.currentTimeline = 0;
            chapter1.IntroFinished = false;
            chapter1.completedAct = 0;
        }
        if (chapter.equals("chap 2")) {
            currentMap = myRoom;
            currentChapter = chapter2;
            chapter2.currentTimeline = 0;
            chapter2.completedAct = 0;
        }
        // if (chapter.equals("chap3")) {
        // currentMap = myRoom;
        // currentChapter = chapter3;
        // chapter3.currentTimeline = 0;
        // chapter3.IntroFinished = false;
        // chapter3.completedAct = 0;
        // }
        Main.GameState.push("GamePlay");
    }
}
