package MainMenu;

import main.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class VideoSetting extends JPanel {
    private BufferedImage SettingBackGround, back, exitImg, exitImg1, line, player, comment, comment1, fpsimg, mutecmt, mutecmt1;
    private int i;

    public static int qualitysliderpointX = 230 * Main.ex;

    public static boolean checkenterslider = false;

    private String check = "";

    public VideoSetting() {
        getImage();
    }
    public String c_check;
    public void getImage() {
        try {
            SettingBackGround = ImageIO.read(new FileInputStream("res/MainmenuImage/settingbackgroundmo.png"));
            back = ImageIO.read(new FileInputStream("res/MainmenuImage/backicon.png"));
            exitImg1 = ImageIO.read(new FileInputStream("res/player/character_move_left (1).png"));
            line = ImageIO.read(new FileInputStream("res/MainmenuImage/straightline.png"));
            comment1 = ImageIO.read(new FileInputStream("res/MainmenuImage/comment.png"));
            player = ImageIO.read(new FileInputStream("res/player/character_move_down (4).png"));
            fpsimg = ImageIO.read(new FileInputStream("res/MainmenuImage/fpsimg.png"));
            mutecmt1 = ImageIO.read(new FileInputStream("res/MainmenuImage/comment.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void qualitysliderpointX(int i) {
        check = "volumesliderpointclick";
        this.i = i;
    }
    public void checkcomment() {
        check = "checkcomment";
    }
    public void audiorollback() {
        check = null;
    }
    public void buttonReturnEnter() {
        check = "buttonReturnEnter";
    }
    public void muteEnter() {
        check = "muteEnter";
    }
    public void Init() {
        check = "";
        comment = null;
        exitImg = null;
        mutecmt = null;
    }
    public void update() {
        if (check == "volumesliderpointclick") {
            qualitysliderpointX = i;
        } else if (check == "checkcomment") {
            comment = comment1;
        } else if (check == "buttonReturnEnter") {
            exitImg = exitImg1;
        } else if (check == "muteEnter") {
            mutecmt = mutecmt1;
        } else {
            comment = null;
            exitImg = null;
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(SettingBackGround, 0, 0, 768 * Main.ex, 576 * Main.ex, null);
        g2.drawImage(back, 10 * Main.ex, 10 * Main.ex, 40 * Main.ex, 40 * Main.ex, null);
        g2.drawImage(exitImg, 60 * Main.ex, 12 * Main.ex, 40 * Main.ex, 40 * Main.ex, null);
        g2.drawImage(line, 240 * Main.ex, 250 * Main.ex, 360 * Main.ex, 60 * Main.ex, null);
        g2.drawImage(player, qualitysliderpointX, 250 * Main.ex, 50 * Main.ex, 50 * Main.ex, null);
        g2.setFont(new Font("Arial", Font.BOLD, 14 * Main.ex));
        g2.setColor(Color.white);
        g2.drawImage(comment, qualitysliderpointX + 9 * Main.ex, 215 * Main.ex, 30 * Main.ex, 30 * Main.ex, null);
        g2.drawImage(fpsimg, 170 * Main.ex, 254 * Main.ex, 50 * Main.ex, 50 * Main.ex, null);
        g2.drawImage(mutecmt, 153 * Main.ex, 205 * Main.ex, 60 * Main.ex, 50 * Main.ex, null);
        super.paintComponent(g2);
    }

}
