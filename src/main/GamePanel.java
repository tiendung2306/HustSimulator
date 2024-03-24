package main;

import entity.Player;
import sound.Sound;
// import tile.TileManager;
import sound.SoundManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    //SCREEN SETTINGS
    public final int originalTileSize = 16;
    public final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;


    //=================================================================================================================

    // TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this, keyH);
    SoundManager soundManager = new SoundManager();

    Main_Menu mainMenu = new Main_Menu();
    NextMainMenu nextMainMenu = new NextMainMenu();
    Setting setting = new Setting();
    MouseListener mouseListener = new MouseListener(this);
    MouseMotionListener mouseMotionListener = new MouseMotionListener(this, mainMenu, nextMainMenu);
    double FPS = 60;

    //=================================================================================================================
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        this.Mouse();
    }

    public void Mouse() {
        this.addMouseMotionListener(mouseMotionListener);
        this.addMouseListener(mouseListener);
    }


    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public void run(){
        soundManager.addSound(new Sound("piano_music", "res/sound/pianos-by-jtwayne-7-174717.wav"));
        // soundManager.loopSound("piano_music");

        soundManager.addSound(new Sound("guitar_music", "res/sound/acoustic-guitar-loop-f-91bpm-132687.wav"));
        // soundManager.loopSound("guitar_music");
        
        double drawInterval = 1000000000 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while(gameThread != null){

            update();

            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime /= 1000000;

                if (remainingTime < 0){
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //=================================================================================================================
    public void update() {
        player.update();
        if (Main.Gametime == "MainMenu")
        {
            mainMenu.update();
        }
        else if (Main.Gametime == "NextMainMenu")
        {
            nextMainMenu.update();
        } else if (Main.Gametime == "Setting") {
            setting.update();
        }
    }
    //=================================================================================================================

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        // tileM.draw(g2);

        player.draw(g2);
        if (Main.Gametime == "MainMenu")
        {
            mainMenu.draw(g2);
        }
        else if (Main.Gametime == "NextMainMenu")
        {
            nextMainMenu.draw(g2);
        }else if (Main.Gametime == "Setting")
            setting.draw(g2);

        g2.dispose();
    }
}