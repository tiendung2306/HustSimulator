package MainMenu;

import main.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class KeySetting extends JPanel {

    Thread gameThread;
    private BufferedImage SettingBackGround, back, exitImg, exitImg1, keyboardimg;

    public KeySetting() {
        getImage();
    }

    public void run() {
        while (gameThread != null) {
            update();
            repaint();
        }
    }

    public void getImage() {
        try {
            SettingBackGround = ImageIO.read(new FileInputStream("res/MainmenuImage/settingbackgroundmo.png"));
            back = ImageIO.read(new FileInputStream("res/MainmenuImage/backicon.png"));
            exitImg1 = ImageIO.read(new FileInputStream("res/player/character_move_left (1).png"));
            keyboardimg = ImageIO.read(new FileInputStream("res/MainmenuImage/keyboardimg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String check = null;

    public void keysettingrollback() {
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

    public void Init() {
        check = "";
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(SettingBackGround, 0, 0, 768 * Main.ex, 576 * Main.ex, null);
        g2.drawImage(back, 10 * Main.ex, 10 * Main.ex, 40 * Main.ex, 40 * Main.ex, null);
        g2.drawImage(exitImg, 60 * Main.ex, 12 * Main.ex, 40 * Main.ex, 40 * Main.ex, null);
        g2.setFont(new Font("Arial", Font.BOLD, 25 * Main.ex));
        g2.setColor(Color.black);
        g2.drawImage(keyboardimg, 184 * Main.ex, 207 * Main.ex, 400 * Main.ex, 200 * Main.ex, null);
        g2.drawRect(70 * Main.ex, 90 * Main.ex, 30 * Main.ex, 30 * Main.ex);
        g2.drawString("UP",130 * Main.ex,115 * Main.ex);
        g2.drawRect(670 * Main.ex, 90 * Main.ex, 30 * Main.ex, 30 * Main.ex);
        g2.drawString("LEFT",560 * Main.ex,115 * Main.ex);
        g2.drawRect(70 * Main.ex, 140 * Main.ex, 30 * Main.ex, 30 * Main.ex);
        g2.drawString("DOWN",130 * Main.ex,165 * Main.ex);
        g2.drawRect(670 * Main.ex, 140 * Main.ex, 30 * Main.ex, 30 * Main.ex);
        g2.drawString("RIGHT",560 * Main.ex,165 * Main.ex);
        g2.drawRect(70 * Main.ex, 450 * Main.ex, 30 * Main.ex, 30 * Main.ex);
        g2.drawRect(670 * Main.ex, 450 * Main.ex, 30 * Main.ex, 30 * Main.ex);
        g2.setFont(new Font("Arial", Font.ITALIC, 25 * Main.ex));
        g2.drawString("W",70 * Main.ex,115 * Main.ex);
        g2.drawString("A",672 * Main.ex,115 * Main.ex);
        g2.drawString("S",70 * Main.ex,165 * Main.ex);
        g2.drawString("D",672 * Main.ex,165 * Main.ex);
        super.paintComponent(g2);
    }
}
