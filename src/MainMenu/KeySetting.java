package MainMenu;

import Keyboard.KeyboardManager;
import main.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class KeySetting extends JPanel {
    private BufferedImage SettingBackGround, back, exitImg, exitImg1, keyboardimg, playerUP, playerDOWN, playerLEFT, playerRIGHT, square, enterkey, enterkey1;
    String upKeyName, leftKeyName, rightKeyName, downKeyName;

    public KeySetting() {
        getImage();
    }

    public void init() {
        upKeyName = KeyboardManager.getKeyName("UP");
        downKeyName = KeyboardManager.getKeyName("DOWN");
        leftKeyName = KeyboardManager.getKeyName("LEFT");
        rightKeyName = KeyboardManager.getKeyName("RIGHT");
    }

    public void getImage() {
        try {
            SettingBackGround = ImageIO.read(new FileInputStream("res/MainmenuImage/settingbackgroundmo.png"));
            back = ImageIO.read(new FileInputStream("res/MainmenuImage/backicon.png"));
            exitImg1 = ImageIO.read(new FileInputStream("res/player/character_move_left (1).png"));
            keyboardimg = ImageIO.read(new FileInputStream("res/MainmenuImage/keyboardimg.png"));
            playerUP = ImageIO.read(new FileInputStream("res/player/character_move_up (1).png"));
            playerDOWN = ImageIO.read(new FileInputStream("res/player/character_move_down (1).png"));
            playerLEFT = ImageIO.read(new FileInputStream("res/player/character_move_left (1).png"));
            playerRIGHT = ImageIO.read(new FileInputStream("res/player/character_move_right (1).png"));
            square = ImageIO.read(new FileInputStream("res/MainmenuImage/square.png"));
            enterkey1 = ImageIO.read(new FileInputStream("res/MainmenuImage/enterakey.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    int inputKey = -1;
    char inputKeyName;

    Boolean isFirstTimePressAKey = false;
    private String check = null;
    String prevCheck = null;
    private int x_square = 999, y_square = 999;
    public static boolean checkPressAKey = true;
    public void keysettingrollback() {
        check = "null";
    }

    public void buttonReturnEnter() {
        check = "buttonReturnEnter";
    }
    public void keysetting_squareup() {
        check = "squareup";
    }
    public void keysetting_squaredown() {
        check = "squaredown";
    }
    public void keysetting_squareleft() {
        check = "squareleft";
    }
    public void keysetting_squareright() {
        check = "squareright";
    }
    public void keysetting_squareupchange() {
        check = "squareup1";
    }
    public void keysetting_squaredownchange() {
        check = "squaredown1";
    }
    public void keysetting_squareleftchange() {
        check = "squareleft1";
    }
    public void keysetting_squarerightchange() {
        check = "squareright1";
    }
    public void getInputKeyAndBindingKey(String keyName)
    {
        if (!checkPressAKey)
        {
            inputKey = KeyboardManager.getReleasedKey();
            if(inputKey != -1)   {
                inputKeyName = KeyboardManager.getReleasedKeyName();

                KeyboardManager.setKey(inputKey, keyName);
                if(keyName == "UP") upKeyName = Character.toString(inputKeyName);
                if(keyName == "DOWN") downKeyName = Character.toString(inputKeyName);
                if(keyName == "LEFT") leftKeyName = Character.toString(inputKeyName);
                if(keyName == "RIGHT") rightKeyName = Character.toString(inputKeyName);

                prevCheck = null;

                checkPressAKey = true;
                check = "null";
                KeyboardManager.resetReleasedKey();
            }
        }
    }
    public void update() {
        if (check.equals("buttonReturnEnter")) exitImg = exitImg1;
        else if (check.equals("squareup")) {
            x_square = 66;
            y_square = 87;
        } else if (check.equals("squaredown")) {
            x_square = 66;
            y_square = 137;
        } else if (check.equals("squareleft")) {
            x_square = 666;
            y_square = 87;
        } else if (check.equals("squareright")) {
            x_square = 666;
            y_square = 137;
        } else if (check.equals("squareup1")) {
            if(prevCheck != check) {
                KeyboardManager.resetReleasedKey();
                prevCheck = check;
            }
            enterkey = enterkey1;
            checkPressAKey = false;
            getInputKeyAndBindingKey("UP");
        } else if (check.equals("squaredown1")) {
            if(prevCheck != check) {
                KeyboardManager.resetReleasedKey();
                prevCheck = check;
            }
            enterkey = enterkey1;
            checkPressAKey = false;
            getInputKeyAndBindingKey("DOWN");
        } else if (check.equals("squareleft1")) {
            if(prevCheck != check) {
                KeyboardManager.resetReleasedKey();
                prevCheck = check;
            }
            enterkey = enterkey1;
            checkPressAKey = false;
            getInputKeyAndBindingKey("LEFT");
        } else if (check.equals("squareright1")) {
            if(prevCheck != check) {
                KeyboardManager.resetReleasedKey();
                prevCheck = check;
            }
            enterkey = enterkey1;
            checkPressAKey = false;
            getInputKeyAndBindingKey("RIGHT");
        } else {
            exitImg = null;
            x_square = 999;
            y_square = 999;
            enterkey = null;
        }
    }
    public void Init() {
        check = "";
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(SettingBackGround, 0, 0, 768 * Main.ex, 576 * Main.ex, null);
        g2.drawImage(back, 10 * Main.ex, 10 * Main.ex, 40 * Main.ex, 40 * Main.ex, null);
        g2.drawImage(exitImg, 60 * Main.ex, 12 * Main.ex, 40 * Main.ex, 40 * Main.ex, null);
        g2.setFont(new Font("Arial", Font.BOLD, 25 * Main.ex));
        g2.setColor(Color.black);
        g2.drawImage(keyboardimg, 184 * Main.ex, 207 * Main.ex, 400 * Main.ex, 200 * Main.ex, null);
        g2.drawRect(70 * Main.ex, 90 * Main.ex, 30 * Main.ex, 30 * Main.ex);
        g2.drawString("UP",130 * Main.ex,115 * Main.ex);
        g2.drawRect(670 * Main.ex, 90 * Main.ex, 30 * Main.ex, 30 * Main.ex);
        g2.drawString("LEFT",560 * Main.ex,115 * Main.ex);
        g2.drawRect(70 * Main.ex, 140 * Main.ex, 30 * Main.ex, 30 * Main.ex);
        g2.drawString("DOWN",130 * Main.ex,165 * Main.ex);
        g2.drawRect(670 * Main.ex, 140 * Main.ex, 30 * Main.ex, 30 * Main.ex);
        g2.drawString("RIGHT",560 * Main.ex,165 * Main.ex);
        g2.drawRect(70 * Main.ex, 450 * Main.ex, 30 * Main.ex, 30 * Main.ex);
        g2.drawRect(670 * Main.ex, 450 * Main.ex, 30 * Main.ex, 30 * Main.ex);
        g2.setFont(new Font("Arial", Font.ITALIC, 25 * Main.ex));
        g2.drawString(upKeyName,72 * Main.ex,115 * Main.ex);
        g2.drawString(leftKeyName,674 * Main.ex,115 * Main.ex);
        g2.drawString(downKeyName,72 * Main.ex,165 * Main.ex);
        g2.drawString(rightKeyName,674 * Main.ex,165 * Main.ex);
        g2.drawImage(playerUP, 216 * Main.ex, 86 * Main.ex, 40 * Main.ex, 40 * Main.ex, null);
        g2.drawImage(playerDOWN, 216 * Main.ex, 139 * Main.ex, 40 * Main.ex, 40 * Main.ex, null);
        g2.drawImage(playerLEFT, 507 * Main.ex, 86 * Main.ex, 40 * Main.ex, 40 * Main.ex, null);
        g2.drawImage(playerRIGHT, 507 * Main.ex, 139 * Main.ex, 40 * Main.ex, 40 * Main.ex, null);
        g2.drawImage(square, x_square * Main.ex, y_square * Main.ex, 38 * Main.ex, 38 * Main.ex, null);
        g2.drawImage(enterkey, 150 * Main.ex, 207 * Main.ex, 468 * Main.ex, 200 * Main.ex, null);
        super.paintComponent(g2);
    }

}
