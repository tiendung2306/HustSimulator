package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class NextMainMenu extends JPanel implements Runnable {
    Thread gameThread;
    public BufferedImage NextBackGround, tutorial, tutorial1, tutorial2, newgame, newgame1, newgame2, setting, setting1, setting2, playImg, player, back;
    private String check = null;
    public NextMainMenu()
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
    public String c_check;
    public void rollback()
    {
        c_check = null;
    }
    public void getPlayerImage(){
        try {
            NextBackGround = ImageIO.read(getClass().getResourceAsStream("/tile/NextMainMenu.png"));
            tutorial1 = ImageIO.read(getClass().getResourceAsStream("/tile/tutorial1.png"));
            tutorial2 = ImageIO.read(getClass().getResourceAsStream("/tile/tutorial2.png"));
            newgame1 = ImageIO.read(getClass().getResourceAsStream("/tile/newgame1.png"));
            newgame2 = ImageIO.read(getClass().getResourceAsStream("/tile/newgame2.png"));
            setting1 = ImageIO.read(getClass().getResourceAsStream("/tile/settingbutton1.png"));
            setting2 = ImageIO.read(getClass().getResourceAsStream("/tile/settingbutton2.png"));
            playImg = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
            back = ImageIO.read(getClass().getResourceAsStream("/tile/backicon.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void buttonTutorialEnter() {
        check = "buttonTutorialEnter";
    }
    public void buttonNewgameEnter() {
        check = "buttonNewgameEnter";
    }
    public void buttonSettingEnter() {
        check = "buttonSettingEnter";
    }
    public void rollbacknext()
    {
        check = null;
    }
    public void update() {
        if (check == "buttonTutorialEnter")
        {
            tutorial = tutorial2;
        } else if (check == "buttonNewgameEnter") {
            newgame = newgame2;
            player = playImg;

        } else if (check == "buttonSettingEnter") {
            setting = setting2;
        } else {
            tutorial = tutorial1;
            newgame = newgame1;
            setting = setting1;
            player = null;
        }
    }
    public void draw(Graphics2D g2) {
        g2.drawImage(NextBackGround, 0, 0, 768, 576, null);
        g2.drawImage(tutorial, 260, 300, 247,40, null);
        g2.drawImage(newgame, 240, 240, 287,45, null);
        g2.drawImage(setting,710, 13, 40,40, null);
        g2.drawImage(player,540, 240, 40,40, null);
        g2.drawImage(back, 10, 10, 40, 40, null);

        super.paintComponent(g2);
    }
}
