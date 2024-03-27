package main;

import MainMenu.*;
import entity.Player;
import sound.Sound;
import tile.TileManager;
import sound.SoundManager;
import phong_hoc.Classroom01;
import phong_hoc.Classroom02;
import phong_hoc.Svd;
import phong_hoc.Thu_vien;
import java.awt.image.BufferedImage;


import javax.imageio.ImageIO;
import javax.swing.*;

import Keyboard.KeyboardManager;
import java.awt.event.KeyEvent;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

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
    //MAP SETTINGS
    public final int maxMapCol = 50;
    public final int maxMapRow = 50;
    public final int mapWidth = tileSize * maxMapCol;
    public final int mapHeight = tileSize * maxMapRow;

    public TileManager tileManager = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    public CollisionPlayer collisionPlayer = new CollisionPlayer(this);
    Thread gameThread;
    SoundManager soundManager = new SoundManager();

     Main_Menu mainMenu = new Main_Menu();
     NextMainMenu nextMainMenu = new NextMainMenu();
     Setting setting = new Setting();
     MouseListener_Mainmenu mouseListenerMainmenu = new MouseListener_Mainmenu(this);
     MouseMotionListener_Mainmenu mouseMotionListenerMainmenu = new MouseMotionListener_Mainmenu(this, mainMenu, nextMainMenu, setting);
     //Khai báo lớp Classroom01 vào GamePanel
     Classroom01 classroom01 = new Classroom01(this);
     Classroom02 classroom02 = new Classroom02(this);
     Thu_vien thuVien = new Thu_vien(this);
     Svd svd = new Svd(this);
    public Player player = new Player(this, keyH, null); 
    KeyboardManager keyboardManager = new KeyboardManager();

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
    public void run(){
        soundManager.addSound(new Sound("piano_music", "res/sound/pianos-by-jtwayne-7-174717.wav"));
        // soundManager.loopSound("piano_music");

        soundManager.addSound(new Sound("guitar_music", "res/sound/acoustic-guitar-loop-f-91bpm-132687.wav"));
        // soundManager.loopSound("guitar_music");
        Init();
        
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

         soundManager.update();
         if (Main.nguoncode == 1)
         {
             if (Main.topGameState() == "MainMenu")
             {
                 mainMenu.update();
             }
             else if (Main.topGameState() == "NextMainMenu")
             {
                 nextMainMenu.update();
             } else if (Main.topGameState() == "Setting") {
                 setting.update();
             }
         }

    }
    //=================================================================================================================

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

         if (Main.nguoncode == 1)
         {
             if (Main.topGameState() == "MainMenu")
             {
                 mainMenu.draw(g2);
             }
             else if (Main.topGameState() == "NextMainMenu")
             {
                 nextMainMenu.draw(g2);
             }else if (Main.topGameState() == "Setting")
                 setting.draw(g2);
         }
        if (Main.nguoncode == 5)
        {
            classroom01.draw(g2);
            player.draw(g2);

        }


        
        
        
        g2.dispose();
    }
}