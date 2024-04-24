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
    private BufferedImage LoadGameBackGround, back, exitImg, exitImg1, select, rectengle;

    public LoadGame() {
        getImage();
    }


    public void getImage() {
        try {
            LoadGameBackGround = ImageIO.read(new FileInputStream("res/MainmenuImage/settingbackgroundmo.png"));
            back = ImageIO.read(new FileInputStream("res/MainmenuImage/backicon.png"));
            exitImg1 = ImageIO.read(new FileInputStream("res/player/character_move_left (1).png"));
            select = ImageIO.read(new FileInputStream("res/MainmenuImage/selectsavedgame.png"));
            rectengle = ImageIO.read(new FileInputStream("res/MainmenuImage/rectengle.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
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
    }
    public void Init() {
        check = "";
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(LoadGameBackGround, 0, 0, (int) (768 * Main.ex), (int) (576 * Main.ey), null);
        g2.drawImage(back, (int) (10 * Main.ex), (int) (10 * Main.ey), (int) (40 * Main.ex), (int) (40 * Main.ey), null);
        g2.drawImage(exitImg, (int) (60 * Main.ex), (int) (12 * Main.ey), (int) (40 * Main.ex), (int) (40 * Main.ey), null);
        g2.drawImage(select, (int) (210 * Main.ex), (int) (60 * Main.ey), (int) (350 * Main.ex), (int) (70 * Main.ey), null);
        g2.drawImage(rectengle, (int) (104 * Main.ex), (int) (150 * Main.ey), (int) (560 * Main.ex), (int) (150 * Main.ey), null);
        g2.drawImage(rectengle, (int) (104 * Main.ex), (int) (280 * Main.ey), (int) (560 * Main.ex), (int) (150 * Main.ey), null);
        g2.drawImage(rectengle, (int) (104 * Main.ex), (int) (410 * Main.ey), (int) (560 * Main.ex), (int) (150 * Main.ey), null);
        g2.setFont(new Font("Arial", Font.ITALIC, (int) (25 * Main.ex)));
        g2.setColor(Color.gray);
        g2.drawString("Empty", (float) (345 * Main.ex), (float) (235 * Main.ey));
        g2.drawString("Empty", (float) (345 * Main.ex), (float) (365 * Main.ey));
        g2.drawString("Empty", (float) (345 * Main.ex), (float) (490 * Main.ey));
        super.paintComponent(g2);
    }

}
