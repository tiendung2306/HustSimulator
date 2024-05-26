package Content;

import Mouse.MouseManager;
import main.GamePanel;
import main.Main;
import map.Map;
import sound.SoundManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class EndChapter{
    public BufferedImage endChapter,continue1,exit1,continue2,exit2,continue3,exit3,endChapter2,endChapter3;
    GamePanel gamePanel;
    public static String checkChapter = "";
    public EndChapter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        getImage();
    }
    public void getImage() {
        try {
            endChapter = ImageIO.read(new FileInputStream("res/congratulation/Chuyen_chap.png"));
            endChapter2 = ImageIO.read(new FileInputStream("res/congratulation/Chuyen_chap2.png"));
            endChapter3 = ImageIO.read(new FileInputStream("res/congratulation/Chuyen_chap3.png"));
            continue1 = ImageIO.read(new FileInputStream("res/tile/no_thing.png"));
            exit1 = ImageIO.read(new FileInputStream("res/tile/no_thing.png"));
            continue2 = ImageIO.read(new FileInputStream("res/congratulation/tieptuc2.png"));
            exit2 = ImageIO.read(new FileInputStream("res/congratulation/thoat2.png"));
            continue3 = ImageIO.read(new FileInputStream("res/tile/no_thing.png"));
            exit3 = ImageIO.read(new FileInputStream("res/tile/no_thing.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2,String checkChapter) {
        g2.scale(1,1);
        if(checkChapter.equals("1")) {
            g2.drawImage(endChapter, 0, 0, (int) (768 * Main.ex), (int) (576 * Main.ey), null);
            g2.drawImage(continue1, (int) (96 * Main.ex), (int) (442 * Main.ey), (int) (244 * Main.ex), (int) (48 * Main.ey), null);
            g2.drawImage(exit1, (int) (83 * Main.ex), (int) (512 * Main.ey), (int) (246 * Main.ex), (int) (47 * Main.ey), null);
        }
        if(checkChapter.equals("2")) {
            g2.drawImage(endChapter2, 0, 0, (int) (768 * Main.ex), (int) (576 * Main.ey), null);
            g2.drawImage(continue1, (int) (96 * Main.ex), (int) (442 * Main.ey), (int) (244 * Main.ex), (int) (48 * Main.ey), null);
            g2.drawImage(exit1, (int) (83 * Main.ex), (int) (512 * Main.ey), (int) (246 * Main.ex), (int) (47 * Main.ey), null);
        }
        if(checkChapter.equals("3")) {
            g2.drawImage(endChapter3, 0, 0, (int) (768 * Main.ex), (int) (576 * Main.ey), null);
            g2.drawImage(continue1, (int) (96 * Main.ex), (int) (442 * Main.ey), (int) (244 * Main.ex), (int) (48 * Main.ey), null);
        }

    }

    public void MouseClick() {
        if(MouseManager.lastReleasedX>= (int) (88 * Main.ex) && MouseManager.lastReleasedX <= (int) (335 * Main.ex) && MouseManager.lastReleasedY >= (int) (441 * Main.ey) && MouseManager.lastReleasedY <=  (int) (490 * Main.ey)) {
            Main.popGameState();
            SoundManager.playSound("click");
            SoundManager.stopSound("xong_chapter");
            if(checkChapter.equals("3")) {
                Main.pushGameState("EndGame");
            }
        }
        if(MouseManager.lastReleasedX>= (int) (88 * Main.ex) && MouseManager.lastReleasedX <= (int) (335 * Main.ex) && MouseManager.lastReleasedY >= (int) (513 * Main.ey) && MouseManager.lastReleasedY <=  (int) (561 * Main.ey)) {
            Main.emptyGameState();
            Main.pushGameState("MainMenu");
            SoundManager.playSound("click");
            SoundManager.stopAllSound();
        }
    }

    public void HoverCheck() {
        if(gamePanel.mouseManager.mouseCurrentX() >= (int) (88 * Main.ex) && gamePanel.mouseManager.mouseCurrentX() <= (int) (335 * Main.ex) && gamePanel.mouseManager.mouseCurrentY() >= (int) (441 * Main.ey) && gamePanel.mouseManager.mouseCurrentY() <=  (int) (490 * Main.ey)) {
            continue1 = continue2;
        }
        else  {
            continue1 = continue3;
        }
        if(gamePanel.mouseManager.mouseCurrentX() >= (int) (88 * Main.ex) && gamePanel.mouseManager.mouseCurrentX() <= (int) (335 * Main.ex) && gamePanel.mouseManager.mouseCurrentY() >= (int) (513 * Main.ey) && gamePanel.mouseManager.mouseCurrentY() <=  (int) (561 * Main.ey)) {
            exit1 = exit2;
        }
        else {
            exit1 = exit3;
        }

    }
}
