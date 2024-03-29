package MainMenu;

import main.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class VideoSetting extends JPanel implements Runnable {
    Thread gameThread;
    private BufferedImage SettingBackGround, back, exitImg, exitImg1;
    public VideoSetting()
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
    public void getPlayerImage(){
        try {
            SettingBackGround = ImageIO.read(new FileInputStream("res/MainmenuImage/settingbackground.png"));
            back = ImageIO.read(new FileInputStream("res/MainmenuImage/backicon.png"));
            exitImg1 = ImageIO.read(new FileInputStream("res/player/character_move_left (1).png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String check = null;
    public void Keysettingrollback() {
        check = null;
    }
    public void buttonReturnEnter() {
        check = "buttonReturnEnter";
    }
    public void update() {
        if (check == "buttonReturnEnter") {
            exitImg = exitImg1;
        } else {
            exitImg = null;
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(SettingBackGround, 0, 0, 768*Main.ex, 576*Main.ex, null);
        g2.drawImage(back, 10*Main.ex, 10*Main.ex, 40*Main.ex, 40*Main.ex, null);
        g2.drawImage(exitImg, 60*Main.ex, 12*Main.ex, 40*Main.ex, 40*Main.ex, null);
        g2.setFont(new Font("Arial", Font.BOLD, 14*Main.ex));
        g2.setColor(Color.white);

        super.paintComponent(g2);
    }
}



