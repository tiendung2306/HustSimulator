package MainMenu;

import main.GamePanel;
import main.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class VideoSetting extends JPanel {
    private BufferedImage SettingBackGround, back, exitImg, exitImg1, fullscreenimg, resolution, down, right, left, save, save1, save2;
    private String check = "";
    public static boolean checkResolution = false;
    public static String fullscreenstr = "WINDOW", resolutionstr = "768 x 576";
    public static String x2560x1440 = "", x1920x1080 = "", x1280x720 = "", x1024x768 = "", x768x576 = "", x1536x1152 = "";
    public static double fullscreenstrX = 358, resolutionstrX = 358 * Main.ex;
    public VideoSetting() {
        getImage();
    }
    public void getImage() {
        try {
            SettingBackGround = ImageIO.read(new FileInputStream("res/MainmenuImage/settingbackgroundmo.png"));
            back = ImageIO.read(new FileInputStream("res/MainmenuImage/backicon.png"));
            exitImg1 = ImageIO.read(new FileInputStream("res/player/character_move_left (1).png"));
            fullscreenimg = ImageIO.read(new FileInputStream("res/MainmenuImage/fullscreen.png"));
            resolution = ImageIO.read(new FileInputStream("res/MainmenuImage/resolution.png"));
            down = ImageIO.read(new FileInputStream("res/Phone/arrow_down.png"));
            right = ImageIO.read(new FileInputStream("res/Phone/arrow_right.png"));
            left = ImageIO.read(new FileInputStream("res/Phone/arrow_left.png"));
            save1 = ImageIO.read(new FileInputStream("res/MainmenuImage/savechange1.png"));
            save2 = ImageIO.read(new FileInputStream("res/MainmenuImage/savechange2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void videorollback() {
        check = null;
    }
    public void buttonvideoReturnEnter() {
        check = "buttonReturnEnter";
    }
    public void Init() {
        exitImg = null;
        resolutionstr = GamePanel.screenWidth + " x " + GamePanel.screenHeight;
    }
    public void buttonSaveEnter() {
        check = "buttonSaveEnter";
    }
    public void update() {
        if (check == "buttonReturnEnter") {
            exitImg = exitImg1;
        } else if (check == "buttonSaveEnter") {
            save = save2;
        } else {
            exitImg = null;
            save = save1;
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(SettingBackGround, 0, 0, (int) (768 * Main.ex), (int) (576 * Main.ey), null);
        g2.drawImage(back, (int) (10 * Main.ex), (int) (10 * Main.ey), (int) (40 * Main.ex), (int) (40 * Main.ey), null);
        g2.drawImage(exitImg, (int) (60 * Main.ex), (int) (12 * Main.ey), (int) (40 * Main.ex), (int) (40 * Main.ey), null);

        g2.setFont(new Font("Arial", Font.BOLD, (int) (34 * Main.ex)));
        g2.setColor(Color.black);
        g2.drawImage(fullscreenimg, (int) (140 * Main.ex), (int) (180 * Main.ey), (int) (70 * Main.ex), (int) (70 * Main.ey), null);
        g2.drawImage(resolution, (int) (140 * Main.ex), (int) (330 * Main.ey), (int) (70 * Main.ex), (int) (70 * Main.ey), null);
        g2.drawString(fullscreenstr, (int) (fullscreenstrX * Main.ex), (int) (225 * Main.ey));
        g2.drawString(resolutionstr, (int) (resolutionstrX * Main.ex), (int) (375 * Main.ey));
        g2.drawImage(down, (int) (421 * Main.ex), (int) (394 * Main.ey), (int) (25 * Main.ex), (int) (15 * Main.ey), null);
        g2.drawImage(right, (int) (557 * Main.ex), (int) (201 * Main.ey), (int) (15 * Main.ex), (int) (25 * Main.ey), null);
        g2.drawImage(left, (int) (288 * Main.ex), (int) (201 * Main.ey), (int) (15 * Main.ex), (int) (25 * Main.ey), null);
        g2.drawImage(save, (int) (600 * Main.ex), (int) (30 * Main.ey), (int) (130 * Main.ex), (int) (50 * Main.ey), null);

        g2.setFont(new Font("Arial", Font.BOLD, (int) (24 * Main.ex)));
        g2.drawString(x768x576, (int) (260 * Main.ex), (int) (445 * Main.ey));
        g2.drawString(x1024x768, (int) (260 * Main.ex), (int) (485 * Main.ey));
        g2.drawString(x1536x1152, (int) (260 * Main.ex), (int) (525 * Main.ey));
        g2.drawString(x1280x720, (int) (485 * Main.ex), (int) (445 * Main.ey));
        g2.drawString(x1920x1080, (int) (485 * Main.ex), (int) (485 * Main.ey));
        g2.drawString(x2560x1440, (int) (485 * Main.ex), (int) (525 * Main.ey));
        super.paintComponent(g2);
    }



}
