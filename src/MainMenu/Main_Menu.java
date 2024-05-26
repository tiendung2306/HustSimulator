package MainMenu;

import main.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Main_Menu {
    Thread gameThread;
    private BufferedImage imgBackGround, HUST, simulator, play, exit, setting;
    private BufferedImage play1, exit1, playerImg, playImg, exitImg, setting1;
    private BufferedImage play2, exit2, setting2;
    private double x_player = 999 * Main.ex;
    private double y_player = 999 * Main.ey;
    private double x_size = 48 * Main.ex, y_size = 48 * Main.ey;

    public Main_Menu() {
        getImage();
    }

    public String c_check;

    public void rollback() {
        c_check = null;
    }

    public void buttonPlayEnter() {
        c_check = "buttonPlayEnter";
    }

    public void buttonExitEnter() {
        c_check = "buttonExitEnter";
    }

    public void buttonSettingEnter() {
        c_check = "buttonSettingEnter";
    }

    public void getImage() {
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
        if (c_check == "buttonPlayEnter") {
            play = play2;
            x_size = 50 * Main.ex;
            y_size = 50 * Main.ey;
            x_player = 455 * Main.ex;
            y_player = 417 * Main.ey;
            playerImg = playImg;
        } else if (c_check == "buttonExitEnter") {
            exit = exit2;
            x_size = 30 * Main.ex;
            y_size = 30 * Main.ey;
            x_player = 308 * Main.ex;
            y_player = 475 * Main.ey;
            playerImg = exitImg;

        } else if (c_check == "buttonSettingEnter") {
            setting = setting2;

        } else {
            play = play1;
            exit = exit1;
            setting = setting1;
            x_player = 999 * Main.ex;
            y_player = 999 * Main.ey;
        }
    }

    public void draw(Graphics2D g2) {
        g2.scale(1, 1);
        g2.drawImage(imgBackGround, 0, 0, (int) (768 * Main.ex), (int) (576 * Main.ey), null);
        g2.drawImage(HUST, (int) (281 * Main.ex), (int) (20 * Main.ey), (int) (200 * Main.ex), (int) (50 * Main.ey),
                null);
        g2.drawImage(simulator, (int) (350 * Main.ex), (int) (65 * Main.ey), (int) (233 * Main.ex),
                (int) (82 * Main.ey), null);
        g2.drawImage(play, (int) (311 * Main.ex), (int) (425 * Main.ey), (int) (145 * Main.ex), (int) (40 * Main.ey),
                null);
        g2.drawImage(exit, (int) (340 * Main.ex), (int) (480 * Main.ey), (int) (80 * Main.ex), (int) (24 * Main.ey),
                null);
        g2.drawImage(playerImg, (int) x_player, (int) y_player, (int) x_size, (int) y_size, null);
        g2.drawImage(setting, (int) (710 * Main.ex), (int) (13 * Main.ey), (int) (40 * Main.ex), (int) (40 * Main.ey),
                null);
    }
}
