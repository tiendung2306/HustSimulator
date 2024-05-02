package MainMenu;

import main.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class PauseGame extends JPanel {
    Thread gameThread;
    private BufferedImage NextBackGround, tutorial, tutorial1, tutorial2,
            setting, setting1, setting2, tutorialicon, tutorialicon1, Continue, Continue1,
            Continue2, continueicon, continueicon1,Back, back1, back2, backiconimg, backiconimg1;

    private String check = null;

    public PauseGame() {
        getImage();
    }
    public void getImage() {
        try {
            NextBackGround = ImageIO.read(new FileInputStream("res/MainmenuImage/NextMainMenu.png"));
            tutorial1 = ImageIO.read(new FileInputStream("res/MainmenuImage/tutorial1.png"));
            tutorial2 = ImageIO.read(new FileInputStream("res/MainmenuImage/tutorial2.png"));
            setting1 = ImageIO.read(new FileInputStream("res/MainmenuImage/settingbutton1.png"));
            setting2 = ImageIO.read(new FileInputStream("res/MainmenuImage/settingbutton2.png"));
            tutorialicon1 = ImageIO.read(new FileInputStream("res/MainmenuImage/tutorialicon.png"));
            Continue1 = ImageIO.read(new FileInputStream("res/MainmenuImage/continue1.png"));
            Continue2 = ImageIO.read(new FileInputStream("res/MainmenuImage/continue2.png"));
            continueicon1 = ImageIO.read(new FileInputStream("res/MainmenuImage/continueicon.png"));
            back1 = ImageIO.read(new FileInputStream("res/MainmenuImage/back1.png"));
            back2 = ImageIO.read(new FileInputStream("res/MainmenuImage/back2.png"));
            backiconimg1 = ImageIO.read(new FileInputStream("res/MainmenuImage/backiconimg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void buttonTutorialEnterpause() {
        check = "buttonTutorialEnter";
    }
    public void buttonSettingEnterpause() {
        check = "buttonSettingEnter";
    }
    public void buttonContinueEnterpause() {
        check = "buttonContinueEnter";
    }
    public void buttonBackEnterpause() {
        check = "buttonBackEnter";
    }
    public void rollbackpause() {
        check = null;
    }
    public void Init() {
        check = "";
    }
    public void update() {
        if (check == "buttonTutorialEnter") {
            tutorial = tutorial2;
            tutorialicon = tutorialicon1;
        } else if (check == "buttonSettingEnter") {
            setting = setting2;
        } else if (check == "buttonContinueEnter") {
            Continue = Continue2;
            continueicon = continueicon1;
        } else if (check == "buttonBackEnter") {
            Back = back2;
            backiconimg = backiconimg1;
        } else {
            backiconimg = null;
            Back = back1;
            tutorial = tutorial1;
            setting = setting1;
            Continue = Continue1;
            tutorialicon = null;
            continueicon = null;
        }
    }
    public void draw(Graphics2D g2) {
        g2.drawImage(NextBackGround, 0, 0, (int) (768 * Main.ex), (int) (576 * Main.ey), null);
        g2.drawImage(tutorial, (int) (260 * Main.ex), (int) (270 * Main.ey), (int) (247 * Main.ex), (int) (40 * Main.ey), null);
        g2.drawImage(setting, (int) (710 * Main.ex), (int) (13 * Main.ey), (int) (40 * Main.ex), (int) (40 * Main.ey), null);
        g2.drawImage(tutorialicon, (int) (520 * Main.ex), (int) (270 * Main.ey), (int) (40 * Main.ex), (int) (40 * Main.ey), null);
        g2.drawImage(Continue, (int) (260 * Main.ex), (int) (210 * Main.ey), (int) (247 * Main.ex), (int) (45 * Main.ey), null);
        g2.drawImage(continueicon, (int) (520 * Main.ex), (int) (210 * Main.ey), (int) (45 * Main.ex), (int) (45 * Main.ey), null);
        g2.drawImage(Back, (int) (320 * Main.ex), (int) (330 * Main.ey), (int) (128 * Main.ex), (int) (40 * Main.ey), null);
        g2.drawImage(backiconimg, (int) (464 * Main.ex), (int) (330 * Main.ey), (int) (40 * Main.ex), (int) (40 * Main.ey), null);
        super.paintComponent(g2);
    }
}
