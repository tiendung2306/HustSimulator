package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class NextMainMenu extends JPanel implements Runnable {
    Thread gameThread;
    public BufferedImage NextBackGround, tutorial, tutorial1, tutorial2, newgame, newgame1, newgame2, setting, setting1, setting2, playImg, player, back, tutorialicon, tutorialicon1, Continue, Continue1, Continue2, continueicon, continueicon1;
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
            NextBackGround = ImageIO.read(new FileInputStream("res/tile/NextMainMenu.png"));
            tutorial1 = ImageIO.read(new FileInputStream("res/tile/tutorial1.png"));
            tutorial2 = ImageIO.read(new FileInputStream("res/tile/tutorial2.png"));
            newgame1 = ImageIO.read(new FileInputStream("res/tile/newgame1.png"));
            newgame2 = ImageIO.read(new FileInputStream("res/tile/newgame2.png"));
            setting1 = ImageIO.read(new FileInputStream("res/tile/settingbutton1.png"));
            setting2 = ImageIO.read(new FileInputStream("res/tile/settingbutton2.png"));
            playImg = ImageIO.read(new FileInputStream("res/player/boy_right_2.png"));
            back = ImageIO.read(new FileInputStream("res/tile/backicon.png"));
            tutorialicon1 = ImageIO.read(new FileInputStream("res/tile/tutorialicon.png"));
            Continue1 = ImageIO.read(new FileInputStream("res/tile/continue1.png"));
            Continue2 = ImageIO.read(new FileInputStream("res/tile/continue2.png"));
            continueicon1 = ImageIO.read(new FileInputStream("res/tile/continueicon.png"));
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
        } else {
            tutorial = tutorial1;
            newgame = newgame1;
            setting = setting1;
            Continue = Continue1;
            player = null;
            tutorialicon = null;
            continueicon = null;
        }
    }
    public void draw(Graphics2D g2) {
        g2.drawImage(NextBackGround, 0, 0, 768, 576, null);
        g2.drawImage(tutorial, 260, 330, 247,40, null);
        g2.drawImage(newgame, 240, 210, 287,45, null);
        g2.drawImage(setting,710, 13, 40,40, null);
        g2.drawImage(player,540, 210, 40,40, null);
        g2.drawImage(back, 10, 10, 40, 40, null);
        g2.drawImage(tutorialicon, 520, 330, 40,40, null);
        g2.drawImage(Continue, 260, 270, 247,40, null);
        g2.drawImage(continueicon, 520, 270, 45,45, null);
        super.paintComponent(g2);
    }


}
