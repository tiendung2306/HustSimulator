package main;

import entity.Player;
import phong_hoc.Classroom01;
import phong_hoc.Classroom02;
import phong_hoc.Svd;
import phong_hoc.Thu_vien;

import javax.swing.JPanel;
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

    // Khai báo lớp Classroom01 vào GamePanel
    Classroom01 tileM = new Classroom01(this);
    Classroom02 tileM2 = new Classroom02(this);
    Thu_vien tileM3 = new Thu_vien(this);
    Svd tileM4 = new Svd(this);

    double FPS = 60;

    //=================================================================================================================
    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }
    public void run(){

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
    }
    //=================================================================================================================

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        //tileM.draw(g2);
        //tileM2.draw(g2);
       // tileM3.draw(g2);
        tileM4.draw(g2);

        player.draw(g2);

        g2.dispose();
    }
}