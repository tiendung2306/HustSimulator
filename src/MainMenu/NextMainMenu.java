package MainMenu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class NextMainMenu extends JPanel implements Runnable {
    Thread gameThread;
    public BufferedImage exitImg, exitImg1, NextBackGround, tutorial, tutorial1, tutorial2, newgame, newgame1, newgame2, setting, setting1, setting2, playImg, player, back, tutorialicon, tutorialicon1, Continue, Continue1, Continue2, continueicon, continueicon1;
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
            NextBackGround = ImageIO.read(new FileInputStream("res/MainmenuImage/NextMainMenu.png"));
            tutorial1 = ImageIO.read(new FileInputStream("res/MainmenuImage/tutorial1.png"));
            tutorial2 = ImageIO.read(new FileInputStream("res/MainmenuImage/tutorial2.png"));
            newgame1 = ImageIO.read(new FileInputStream("res/MainmenuImage/newgame1.png"));
            newgame2 = ImageIO.read(new FileInputStream("res/MainmenuImage/newgame2.png"));
            setting1 = ImageIO.read(new FileInputStream("res/MainmenuImage/settingbutton1.png"));
            setting2 = ImageIO.read(new FileInputStream("res/MainmenuImage/settingbutton2.png"));
            playImg = ImageIO.read(new FileInputStream("res/player/character_move_right (1).png"));
            back = ImageIO.read(new FileInputStream("res/MainmenuImage/backicon.png"));
            tutorialicon1 = ImageIO.read(new FileInputStream("res/MainmenuImage/tutorialicon.png"));
            Continue1 = ImageIO.read(new FileInputStream("res/MainmenuImage/continue1.png"));
            Continue2 = ImageIO.read(new FileInputStream("res/MainmenuImage/continue2.png"));
            continueicon1 = ImageIO.read(new FileInputStream("res/MainmenuImage/continueicon.png"));
            exitImg1 = ImageIO.read(new FileInputStream("res/player/character_move_left (1).png"));

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
    public void buttonReturnEnter() {
        check = "buttonReturnEnter";
    }
    public void buttonContinueEnter() {
        check = "buttonContinueEnter";
    }
    public void rollbacknext()
    {
        check = null;
    }
    public void update() {
        if (check == "buttonTutorialEnter")
        {
            tutorial = tutorial2;
            tutorialicon = tutorialicon1;
        } else if (check == "buttonNewgameEnter") {
            newgame = newgame2;
            player = playImg;
        } else if (check == "buttonSettingEnter") {
            setting = setting2;
        } else if (check == "buttonContinueEnter") {
            Continue = Continue2;
            continueicon = continueicon1;
        }else if (check == "buttonReturnEnter") {
            exitImg = exitImg1;
        } else {
            tutorial = tutorial1;
            newgame = newgame1;
            setting = setting1;
            Continue = Continue1;
            player = null;
            tutorialicon = null;
            continueicon = null;
            exitImg = null;
        }
    }
    public void draw(Graphics2D g2) {
        g2.drawImage(NextBackGround, 0, 0, 768, 576, null);
        g2.drawImage(tutorial, 260, 330, 247,40, null);
        g2.drawImage(newgame, 240, 210, 287,45, null);
        g2.drawImage(setting,710, 13, 40,40, null);
        g2.drawImage(player,530, 200, 60,60, null);
        g2.drawImage(back, 10, 10, 40, 40, null);
        g2.drawImage(exitImg, 60, 12, 40, 40, null);
        g2.drawImage(tutorialicon, 520, 330, 40,40, null);
        g2.drawImage(Continue, 260, 270, 247,45, null);
        g2.drawImage(continueicon, 520, 270, 45,45, null);
        super.paintComponent(g2);
    }



}
