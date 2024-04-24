package MainMenu;

import Keyboard.KeyboardManager;
import main.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class LoadGame extends JPanel {
    private BufferedImage LoadGameBackGround, back, exitImg, exitImg1, select, rectengle_1, rectengle_2, rectengle_3, rectengle1, rectengle2, chap1, chap2, chap3;

    public LoadGame() {
        getImage();
    }


    public void getImage() {
        try {
            LoadGameBackGround = ImageIO.read(new FileInputStream("res/MainmenuImage/settingbackgroundmo.png"));
            back = ImageIO.read(new FileInputStream("res/MainmenuImage/backicon.png"));
            exitImg1 = ImageIO.read(new FileInputStream("res/player/character_move_left (1).png"));
            select = ImageIO.read(new FileInputStream("res/MainmenuImage/selectsavedgame.png"));
            rectengle1 = ImageIO.read(new FileInputStream("res/MainmenuImage/rectengle.png"));
            rectengle2 = ImageIO.read(new FileInputStream("res/MainmenuImage/Rectangle_1.png"));
            chap1 = ImageIO.read(new FileInputStream("res/MainmenuImage/chap1.png"));
            chap2 = ImageIO.read(new FileInputStream("res/MainmenuImage/chap2.png"));
            chap3 = ImageIO.read(new FileInputStream("res/MainmenuImage/chap3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean check1_loadgame = true, check2_loadgame = false, check3_loadgame = false;
    private String check = "null";
    public void LoadGamerollback() {
        check = "null";
    }
    public void buttonLoadGameReturnEnter() {
        check = "buttonReturnEnter";
    }

    public void update() {
       if (check == "buttonReturnEnter")
           exitImg = exitImg1;
       else {
           exitImg = null;
       }
       if (check1_loadgame) rectengle_1 = rectengle2;
       else rectengle_1 = rectengle1;
       if (check2_loadgame) rectengle_2 = rectengle2;
       else rectengle_2 = rectengle1;
       if (check3_loadgame) rectengle_3 = rectengle2;
       else rectengle_3 = rectengle1;
    }
    public void Init() {
        check = "";
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(LoadGameBackGround, 0, 0, (int) (768 * Main.ex), (int) (576 * Main.ey), null);
        g2.drawImage(back, (int) (10 * Main.ex), (int) (10 * Main.ey), (int) (40 * Main.ex), (int) (40 * Main.ey), null);
        g2.drawImage(exitImg, (int) (60 * Main.ex), (int) (12 * Main.ey), (int) (40 * Main.ex), (int) (40 * Main.ey), null);
        g2.drawImage(select, (int) (210 * Main.ex), (int) (60 * Main.ey), (int) (350 * Main.ex), (int) (70 * Main.ey), null);
        g2.setFont(new Font("Arial", Font.ITALIC, (int) (25 * Main.ex)));
        g2.setColor(Color.gray);
        g2.drawString("Empty", (float) (345 * Main.ex), (float) (210 * Main.ey));
        g2.drawString("Empty", (float) (345 * Main.ex), (float) (340 * Main.ey));
        g2.drawString("Empty", (float) (345 * Main.ex), (float) (470 * Main.ey));
        g2.drawImage(rectengle_1, (int) (214 * Main.ex), (int) (150 * Main.ey), (int) (340 * Main.ex), (int) (110 * Main.ey), null);
        g2.drawImage(rectengle_2, (int) (214 * Main.ex), (int) (280 * Main.ey), (int) (340 * Main.ex), (int) (110 * Main.ey), null);
        g2.drawImage(rectengle_3, (int) (214 * Main.ex), (int) (410 * Main.ey), (int) (340 * Main.ex), (int) (110 * Main.ey), null);
        g2.drawImage(chap1, (int) (235 * Main.ex), (int) (170 * Main.ey), (int) (210 * Main.ex), (int) (70 * Main.ey), null);
        super.paintComponent(g2);
    }

}
