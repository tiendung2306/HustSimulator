package MainMenu;

import main.Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Tutorial {
    private BufferedImage background, intro, intro1, left, right, exitImg, exitImg1, back, tutorialtitle, wasd, wasd1, p, p1, f, f1, b ,b1, f_img, f_img1, b_img, b_img1, p_img, p_img1;
    private String check = "";
    public static boolean isIntro = true;
    private String b_string = "", p_string = "", f_string = "", wasd_string = "";
    public Tutorial() {
        getImage();
    }
    public void getImage() {
        try {
            background = ImageIO.read(new FileInputStream("res/MainmenuImage/NextMainMenuMo.png"));
            intro = ImageIO.read(new FileInputStream("res/MainmenuImage/INTRO.png"));
            left = ImageIO.read(new FileInputStream("res/Phone/arrow_left.png"));
            right = ImageIO.read(new FileInputStream("res/Phone/arrow_right.png"));
            exitImg1 = ImageIO.read(new FileInputStream("res/player/character_move_left (1).png"));
            back = ImageIO.read(new FileInputStream("res/MainmenuImage/backicon.png"));
            tutorialtitle = ImageIO.read(new FileInputStream("res/MainmenuImage/tutorialtitle.png"));
            wasd1 = ImageIO.read(new FileInputStream("res/MainmenuImage/wasd.png"));
            p1 = ImageIO.read(new FileInputStream("res/MainmenuImage/p.png"));
            f1 = ImageIO.read(new FileInputStream("res/MainmenuImage/f.png"));
            b1 = ImageIO.read(new FileInputStream("res/MainmenuImage/b.png"));
            f_img1 = ImageIO.read(new FileInputStream("res/MainmenuImage/f_img.png"));
            p_img1 = ImageIO.read(new FileInputStream("res/Phone/phone_icon.png"));
            b_img1 = ImageIO.read(new FileInputStream("res/inventory/InventoryIcon.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Init() {
        isIntro = true;
        check = "";
    }
    public void tutorialreturn() {check = "return";}
    public void tutorialrollback() {
        check = "";
    }
    public void update() {
        if(isIntro)
        {
            intro1 = intro;
            wasd = null;
            p = null;
            f = null;
            b = null;
            f_img = null;
            b_img = null;
            p_img = null;
            b_string = ""; p_string = ""; f_string = ""; wasd_string = "";
        } else
        {
            intro1 = null;
            wasd = wasd1;
            p = p1;
            b = b1;
            f = f1;
            f_img = f_img1;
            b_img = b_img1;
            p_img = p_img1;
            b_string = "Mở balo"; p_string = "Mở điện thoại"; f_string = "Tương tác với vật"; wasd_string = "Di chuyển";
        }
        if (check == "return")
            exitImg = exitImg1;
        else exitImg = null;
    }
    public void draw(Graphics2D g2) {
        g2.drawImage(background, 0, 0, (int) (768 * Main.ex), (int) (576 * Main.ey), null);
        g2.drawImage(intro1, (int) (100 * Main.ex), (int) (105 * Main.ex), (int) (560 * Main.ex), (int) (400 * Main.ey), null);
        g2.drawImage(right, (int) (690 * Main.ex), (int) (260 * Main.ex), (int) (30 * Main.ex), (int) (40 * Main.ey), null);
        g2.drawImage(left, (int) (45 * Main.ex), (int) (260 * Main.ex), (int) (30 * Main.ex), (int) (40 * Main.ey), null);
        g2.drawImage(exitImg, (int) (60 * Main.ex), (int) (12 * Main.ey), (int) (40 * Main.ex), (int) (40 * Main.ey), null);
        g2.drawImage(back, (int) (10 * Main.ex), (int) (10 * Main.ey), (int) (40 * Main.ex), (int) (40 * Main.ey), null);
        g2.drawImage(tutorialtitle, (int) (230 * Main.ex), (int) (15 * Main.ey), (int) (300 * Main.ex), (int) (85 * Main.ey), null);
        g2.setFont(new Font("Arial", Font.BOLD, (int) (25 * Main.ex)));
        g2.setColor(Color.black);
        g2.drawImage(wasd, (int) (135 * Main.ex), (int) (95 * Main.ey), (int) (250 * Main.ex), (int) (250 * Main.ey), null);
        g2.drawString(wasd_string, (float) (420 * Main.ex), (float) (235 * Main.ey));
        g2.drawImage(p, (int) (230 * Main.ex), (int) (335 * Main.ey), (int) (50 * Main.ex), (int) (50 * Main.ey), null);
        g2.drawString(p_string, (float) (420 * Main.ex), (float) (365 * Main.ey));
        g2.drawImage(p_img, (int) (360 * Main.ex), (int) (325 * Main.ey), (int) (40 * Main.ex), (int) (70 * Main.ey), null);
        g2.drawImage(b, (int) (230 * Main.ex), (int) (405 * Main.ey), (int) (50 * Main.ex), (int) (50 * Main.ey), null);
        g2.drawString(b_string, (float) (420 * Main.ex), (float) (435 * Main.ey));
        g2.drawImage(b_img, (int) (350 * Main.ex), (int) (395 * Main.ey), (int) (60 * Main.ex), (int) (60 * Main.ey), null);
        g2.drawImage(f, (int) (230 * Main.ex), (int) (475 * Main.ey), (int) (50 * Main.ex), (int) (50 * Main.ey), null);
        g2.drawString(f_string, (float) (420 * Main.ex), (float) (505 * Main.ey));
        g2.drawImage(f_img, (int) (350 * Main.ex), (int) (465 * Main.ey), (int) (60 * Main.ex), (int) (70 * Main.ey), null);
    }


}
