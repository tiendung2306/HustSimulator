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
    private BufferedImage SettingBackGround, back, exitImg, exitImg1, resolution, down, right1, left1, right, left, save, save1, save2;
    private String check = "";
    public static boolean checkResolution = false;
    public static String resolutionstr = "768 x 576";
    public static String x2304x1728 = "", x1792x1344 = "", x1280x960 = "", x1024x768 = "", x768x576 = "", x1536x1152 = "";
    public static double resolutionstrX = 356 * Main.ex;
    private int leftX, leftY, rightX, rightY;
    public VideoSetting() {
        getImage();
    }
    public void getImage() {
        try {
            SettingBackGround = ImageIO.read(new FileInputStream("res/MainmenuImage/settingbackgroundmo.png"));
            back = ImageIO.read(new FileInputStream("res/MainmenuImage/backicon.png"));
            exitImg1 = ImageIO.read(new FileInputStream("res/player/character_move_left (1).png"));
            resolution = ImageIO.read(new FileInputStream("res/MainmenuImage/resolution.png"));
            down = ImageIO.read(new FileInputStream("res/Phone/arrow_down.png"));
            right1 = ImageIO.read(new FileInputStream("res/Phone/arrow_right.png"));
            left1 = ImageIO.read(new FileInputStream("res/Phone/arrow_left.png"));
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
    public void x2304x1728enter(){
        check = "x2304x1728";
    }
    public void x1792x1344enter(){
        check = "x1792x1344";
    }
    public void x1280x960enter(){
        check = "x1280x960";
    }
    public void x1024x768enter(){
        check = "x1024x768";
    }
    public void x1536x1152enter(){
        check = "x1536x1152";
    }
    public void x768x576enter(){
        check = "x768x576";
    }
    public void Init() {
        check = "";
        exitImg = null;
        resolutionstr = (int)GamePanel.screenWidth + " x " + (int)GamePanel.screenHeight;
        checkResolution = false;
        Main.next_ex = Main.prev_ex; Main.next_ey = Main.prev_ey;
        GamePanel.next_screenWidth = GamePanel.prev_screenWidth;
        GamePanel.next_screenHeight = GamePanel.prev_screenHeight;
        GamePanel.next_scale = GamePanel.prev_scale;
    }
    public void buttonSaveEnter() {
        check = "buttonSaveEnter";
    }
    public void update() {
        if (check == "buttonReturnEnter") {
            exitImg = exitImg1;
        } else if (check == "buttonSaveEnter") {
            save = save2;
        } else if (check == "x768x576") {
            right = right1;
            rightX = 231;
            rightY = 313;
        } else if (check == "x1024x768") {
            right = right1;
            rightX = 231;
            rightY = 352;
        } else if (check == "x1536x1152") {
            right = right1;
            rightX = 231;
            rightY = 395;
        } else if (check == "x1280x960") {
            left = left1;
            leftX = 635;
            leftY = 313;
        } else if (check == "x1792x1344") {
            left = left1;
            leftX = 635;
            leftY = 352;
        } else if (check == "x2304x1728") {
            left = left1;
            leftX = 635;
            leftY = 395;
        } else {
            exitImg = null;
            save = save1;
            right = null;
            left = null;
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(SettingBackGround, 0, 0, (int) (768 * Main.ex), (int) (576 * Main.ey), null);
        g2.drawImage(back, (int) (10 * Main.ex), (int) (10 * Main.ey), (int) (40 * Main.ex), (int) (40 * Main.ey), null);
        g2.drawImage(exitImg, (int) (60 * Main.ex), (int) (12 * Main.ey), (int) (40 * Main.ex), (int) (40 * Main.ey), null);

        g2.setFont(new Font("Arial", Font.BOLD, (int) (34 * Main.ex)));
        g2.setColor(Color.black);
        g2.drawImage(resolution, (int) (140 * Main.ex), (int) (220 * Main.ey), (int) (70 * Main.ex), (int) (70 * Main.ey), null);
        g2.drawString(resolutionstr, (int) (resolutionstrX * Main.ex), (int) (265 * Main.ey));
        g2.drawImage(down, (int) (421 * Main.ex), (int) (284 * Main.ey), (int) (25 * Main.ex), (int) (15 * Main.ey), null);
        g2.drawImage(right, (int) (rightX * Main.ex), (int) (rightY * Main.ey), (int) (15 * Main.ex), (int) (25 * Main.ey), null);
        g2.drawImage(left, (int) (leftX * Main.ex), (int) (leftY * Main.ey), (int) (15 * Main.ex), (int) (25 * Main.ey), null);
        g2.drawImage(save, (int) (600 * Main.ex), (int) (30 * Main.ey), (int) (130 * Main.ex), (int) (50 * Main.ey), null);

        g2.setFont(new Font("Arial", Font.BOLD, (int) (24 * Main.ex)));
        g2.drawString(x768x576, (int) (260 * Main.ex), (int) (335 * Main.ey));
        g2.drawString(x1024x768, (int) (260 * Main.ex), (int) (375 * Main.ey));
        g2.drawString(x1536x1152, (int) (260 * Main.ex), (int) (415 * Main.ey));
        g2.drawString(x1280x960, (int) (485 * Main.ex), (int) (335 * Main.ey));
        g2.drawString(x1792x1344, (int) (485 * Main.ex), (int) (375 * Main.ey));
        g2.drawString(x2304x1728, (int) (485 * Main.ex), (int) (415 * Main.ey));
        super.paintComponent(g2);
    }



}
