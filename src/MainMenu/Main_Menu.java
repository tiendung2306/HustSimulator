package MainMenu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Main_Menu extends JPanel implements Runnable {

    Thread gameThread;
    public BufferedImage imgBackGround, HUST, simulator, play, exit, setting;
    public BufferedImage play1, exit1, playerImg, playImg, exitImg, setting1;
    public BufferedImage play2, exit2, setting2;
    private int x_player = 999;
    private int y_player = 999;
    private int x_size = 48, y_size = 48;
    public Main_Menu()
    {
        getPlayerImage();
    }
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {
        while (gameThread != null) {
            update();
            repaint();
        }
    }
    public String c_check;
    public void rollback()
    {
        c_check = null;
    }
    public void buttonPlayEnter()
    {
        c_check = "buttonPlayEnter";
    }
    public void buttonExitEnter() {
        c_check = "buttonExitEnter";
    }
    public void buttonSettingEnter() {
        c_check = "buttonSettingEnter";
    }
    public void getPlayerImage(){
        try {
            imgBackGround = ImageIO.read(new FileInputStream("res/MainmenuImage/BackGround.png"));
            HUST = ImageIO.read(new FileInputStream("res/MainmenuImage/HUST.png"));
            simulator = ImageIO.read(new FileInputStream("res/MainmenuImage/Simulator.png"));
            play1 = ImageIO.read(new FileInputStream("res/MainmenuImage/play.png"));
            exit1 = ImageIO.read(new FileInputStream("res/MainmenuImage/exit.png"));
            play2 = ImageIO.read(new FileInputStream("res/MainmenuImage/play1.png"));
            exit2 = ImageIO.read(new FileInputStream("res/MainmenuImage/exit1.png"));
            playImg = ImageIO.read(new FileInputStream("res/player/character_move_right (1).png"));
            exitImg = ImageIO.read(new FileInputStream("res/player/character_move_left (1).png"));
            setting1 = ImageIO.read(new FileInputStream("res/MainmenuImage/settingbutton1.png"));
            setting2 = ImageIO.read(new FileInputStream("res/MainmenuImage/settingbutton2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void update() {
        if (c_check == "buttonPlayEnter")
        {
            play = play2;
            x_size = 50;
            y_size = 50;
            x_player = 455;
            y_player = 417;
            playerImg = playImg;
        }
        else if (c_check == "buttonExitEnter")
        {
            exit = exit2;
            x_size = 30;
            y_size = 30;
            x_player = 308;
            y_player = 475;
            playerImg = exitImg;

        } else if (c_check == "buttonSettingEnter") {
            setting = setting2;

        } else {
            play = play1;
            exit = exit1;
            setting = setting1;
            x_player = 999;
            y_player = 999;
        }
    }
    public void draw(Graphics2D g2) {
        g2.drawImage(imgBackGround, 0, 0, 768, 576, null);
        g2.drawImage(HUST,281, 20, 200,50, null);
        g2.drawImage(simulator,350, 65, 233,82, null);
        g2.drawImage(play,311, 425, 145,40, null);
        g2.drawImage(exit,340, 480, 80,24, null);
        g2.drawImage(playerImg,x_player, y_player, x_size, y_size, null);
        g2.drawImage(setting,710, 13, 40,40, null);
        super.paintComponent(g2);
    }
}


