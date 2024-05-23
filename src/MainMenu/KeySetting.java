package MainMenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Keyboard.KeyboardManager;
import main.Main;

public class KeySetting {
    private BufferedImage SettingBackGround, back, exitImg, exitImg1, keyboardimg, playerUP, playerDOWN, playerLEFT,
            playerRIGHT, square, enterkey, enterkey1;
    String upKeyName, leftKeyName, rightKeyName, downKeyName;
    String interactKeyName, nextDialogueKeyName1, nextDialogueKeyName2, pauseKeyName, inventoryKeyName, phoneKeyName;

    public KeySetting() {
        getImage();
    }

    String stringNormalization(String s) {
        if(s.length() == 1) s = "    " + s;
        else if(s.length() == 2)    s = "   " + s;
        else if(s.length() == 3)    s = "  " + s;
        return s;
    }

    public void init() {
        upKeyName = stringNormalization(KeyboardManager.getKeyName("UP"));
        downKeyName = stringNormalization(KeyboardManager.getKeyName("DOWN"));
        leftKeyName = stringNormalization(KeyboardManager.getKeyName("LEFT"));
        rightKeyName = stringNormalization(KeyboardManager.getKeyName("RIGHT"));
        interactKeyName = stringNormalization(KeyboardManager.getKeyName("INTERACT"));
        nextDialogueKeyName1 = stringNormalization(KeyboardManager.getKeyName("NEXTDIALOGUE"));
        nextDialogueKeyName2 = stringNormalization(KeyboardManager.getKeyName("NEXTDIALOGUE"));
        pauseKeyName = stringNormalization(KeyboardManager.getKeyName("PAUSE"));
        inventoryKeyName = stringNormalization(KeyboardManager.getKeyName("INVENTORY"));
        phoneKeyName = stringNormalization(KeyboardManager.getKeyName("PHONE"));
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
    private String check = "null";
    String prevCheck = "null";
    private double x_square = 9999 * Main.ex, y_square = 9999 * Main.ey;
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

    public void keysetting_square1() {
        check = "square1";
    }

    public void keysetting_square2() {
        check = "square2";
    }

    public void keysetting_square3() {
        check = "square3";
    }

    public void keysetting_square4() {
        check = "square4";
    }

    public void keysetting_square5() {
        check = "square5";
    }

    public void keysetting_square6() {
        check = "square6";
    }

    public void keysetting_square1change() {
        check = "square1change";
    }

    public void keysetting_square2change() {
        check = "square2change";
    }

    public void keysetting_square3change() {
        check = "square3change";
    }

    public void keysetting_square4change() {
        check = "square4change";
    }

    public void keysetting_square5change() {
        check = "square5change";
    }

    public void keysetting_square6change() {
        check = "square6change";
    }

    String keyToString(int inputKey) {
        if (inputKey == KeyEvent.VK_SPACE)
            return "SPACE";
        if (inputKey == KeyEvent.VK_ESCAPE)
            return "  ESC";
        if (inputKey == KeyEvent.VK_ENTER)
            return "ENTER";
        if (inputKey == KeyEvent.VK_UP)
            return "   UP";
        if (inputKey == KeyEvent.VK_DOWN)
            return "DOWN";
        if (inputKey == KeyEvent.VK_LEFT)
            return " LEFT";
        if (inputKey == KeyEvent.VK_RIGHT)
            return " RIGHT";
        if (inputKey == KeyEvent.VK_SHIFT)
            return "SHIFT";
        if (inputKey >= KeyEvent.VK_A && inputKey <= KeyEvent.VK_Z)
            return "    " + Character.toString(KeyboardManager.getReleasedKeyName());
        return null;
    }

    public void getInputKeyAndBindingKey(String keyName) {
        if (!checkPressAKey) {
            inputKey = KeyboardManager.getReleasedKey();
            if (inputKey != -1) {
                if (keyToString(inputKey) == null) {
                    KeyboardManager.resetReleasedKey();
                    check = "null";
                    checkPressAKey = true;
                    return;
                }
                KeyboardManager.setKey(inputKey, keyName);
                if (keyName.equals("UP"))
                    upKeyName = keyToString(inputKey);
                if (keyName.equals("DOWN"))
                    downKeyName = keyToString(inputKey);
                if (keyName.equals("LEFT"))
                    leftKeyName = keyToString(inputKey);
                if (keyName.equals("RIGHT"))
                    rightKeyName = keyToString(inputKey);
                if (keyName.equals("INTERACT"))
                    interactKeyName = keyToString(inputKey);
                if (keyName.equals("NEXTDIALOGUE1"))
                    nextDialogueKeyName1 = keyToString(inputKey);
                if (keyName.equals("NEXTDIALOGUE2"))
                    nextDialogueKeyName2 = keyToString(inputKey);
                if (keyName.equals("PAUSE"))
                    pauseKeyName = keyToString(inputKey);
                if (keyName.equals("INVENTORY"))
                    inventoryKeyName = keyToString(inputKey);
                if (keyName.equals("PHONE"))
                    phoneKeyName = keyToString(inputKey);
                prevCheck = "null";

                checkPressAKey = true;
                check = "null";
                KeyboardManager.resetReleasedKey();
            }
        }
    }

    public void update() {
        if (check.equals("buttonReturnEnter"))
            exitImg = exitImg1;
        else if (check.equals("squareup")) {
            x_square = 36 * Main.ex;
            y_square = 87 * Main.ey;
        } else if (check.equals("squaredown")) {
            x_square = 36 * Main.ex;
            y_square = 137 * Main.ey;
        } else if (check.equals("squareleft")) {
            x_square = 636 * Main.ex;
            y_square = 87 * Main.ey;
        } else if (check.equals("squareright")) {
            x_square = 636 * Main.ex;
            y_square = 137 * Main.ey;
        } else if (check.equals("square1")) {
            x_square = 36 * Main.ex;
            y_square = 397 * Main.ey;
        } else if (check.equals("square2")) {
            x_square = 636 * Main.ex;
            y_square = 397 * Main.ey;
        } else if (check.equals("square3")) {
            x_square = 36 * Main.ex;
            y_square = 447 * Main.ey;
        } else if (check.equals("square4")) {
            x_square = 636 * Main.ex;
            y_square = 447 * Main.ey;
        } else if (check.equals("square5")) {
            x_square = 36 * Main.ex;
            y_square = 497 * Main.ey;
        } else if (check.equals("square6")) {
            x_square = 636 * Main.ex;
            y_square = 497 * Main.ey;
        } else if (check.equals("squareup1")) {
            if (!prevCheck.equals(check)) {
                KeyboardManager.resetReleasedKey();
                prevCheck = check;
            }
            enterkey = enterkey1;
            checkPressAKey = false;
            getInputKeyAndBindingKey("UP");
        } else if (check.equals("squaredown1")) {
            if (!prevCheck.equals(check)) {
                KeyboardManager.resetReleasedKey();
                prevCheck = check;
            }
            enterkey = enterkey1;
            checkPressAKey = false;
            getInputKeyAndBindingKey("DOWN");
        } else if (check.equals("squareleft1")) {
            if (!prevCheck.equals(check)) {
                KeyboardManager.resetReleasedKey();
                prevCheck = check;
            }
            enterkey = enterkey1;
            checkPressAKey = false;
            getInputKeyAndBindingKey("LEFT");
        } else if (check.equals("squareright1")) {
            if (!prevCheck.equals(check)) {
                KeyboardManager.resetReleasedKey();
                prevCheck = check;
            }
            enterkey = enterkey1;
            checkPressAKey = false;
            getInputKeyAndBindingKey("RIGHT");
        } else if (check.equals("square1change")) {
            if (!prevCheck.equals(check)) {
                KeyboardManager.resetReleasedKey();
                prevCheck = check;
            }
            enterkey = enterkey1;
            checkPressAKey = false;
            getInputKeyAndBindingKey("NEXTDIALOGUE1");
        } else if (check.equals("square2change")) {
            if (!prevCheck.equals(check)) {
                KeyboardManager.resetReleasedKey();
                prevCheck = check;
            }
            enterkey = enterkey1;
            checkPressAKey = false;
            getInputKeyAndBindingKey("INTERACT");
        } else if (check.equals("square3change")) {
            if (!prevCheck.equals(check)) {
                KeyboardManager.resetReleasedKey();
                prevCheck = check;
            }
            enterkey = enterkey1;
            checkPressAKey = false;
            getInputKeyAndBindingKey("NEXTDIALOGUE2");
        } else if (check.equals("square4change")) {
            if (!prevCheck.equals(check)) {
                KeyboardManager.resetReleasedKey();
                prevCheck = check;
            }
            enterkey = enterkey1;
            checkPressAKey = false;
            getInputKeyAndBindingKey("PAUSE");
        } else if (check.equals("square5change")) {
            if (!prevCheck.equals(check)) {
                KeyboardManager.resetReleasedKey();
                prevCheck = check;
            }
            enterkey = enterkey1;
            checkPressAKey = false;
            getInputKeyAndBindingKey("INVENTORY");
        } else if (check.equals("square6change")) {
            if (!prevCheck.equals(check)) {
                KeyboardManager.resetReleasedKey();
                prevCheck = check;
            }
            enterkey = enterkey1;
            checkPressAKey = false;
            getInputKeyAndBindingKey("PHONE");
        } else {
            exitImg = null;
            x_square = 999 * Main.ex;
            y_square = 999 * Main.ey;
            enterkey = null;
        }
    }

    public void Init() {
        check = "";
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(SettingBackGround, 0, 0, (int) (768 * Main.ex), (int) (576 * Main.ey), null);
        g2.drawImage(back, (int) (10 * Main.ex), (int) (10 * Main.ey), (int) (40 * Main.ex), (int) (40 * Main.ey),
                null);
        g2.drawImage(exitImg, (int) (60 * Main.ex), (int) (12 * Main.ey), (int) (40 * Main.ex), (int) (40 * Main.ey),
                null);
        g2.setFont(new Font("Arial", Font.BOLD, (int) (25 * Main.ex)));
        g2.setColor(Color.black);
        g2.drawImage(keyboardimg, (int) (184 * Main.ex), (int) (192 * Main.ey), (int) (400 * Main.ex),
                (int) (200 * Main.ey), null);
        g2.drawRect((int) (40 * Main.ex), (int) (90 * Main.ey), (int) (90 * Main.ex), (int) (30 * Main.ey));
        g2.drawString("UP", (float) (160 * Main.ex), (float) (115 * Main.ey));
        g2.drawRect((int) (640 * Main.ex), (int) (90 * Main.ey), (int) (90 * Main.ex), (int) (30 * Main.ey));
        g2.drawString("LEFT", (float) (530 * Main.ex), (float) (115 * Main.ex));
        g2.drawRect((int) (40 * Main.ex), (int) (140 * Main.ey), (int) (90 * Main.ex), (int) (30 * Main.ey));
        g2.drawString("DOWN", (float) (160 * Main.ex), (float) (165 * Main.ey));
        g2.drawRect((int) (640 * Main.ex), (int) (140 * Main.ey), (int) (90 * Main.ex), (int) (30 * Main.ey));
        g2.drawString("RIGHT", (float) (530 * Main.ex), (float) (165 * Main.ey));
        g2.drawRect((int) (40 * Main.ex), (int) (400 * Main.ey), (int) (90 * Main.ex), (int) (30 * Main.ey));
        g2.drawString("NEXTDIALOGUE1",(float) (160 * Main.ex), (float) (425 * Main.ey) );
        g2.drawRect((int) (40 * Main.ex), (int) (450 * Main.ey), (int) (90 * Main.ex), (int) (30 * Main.ey));
        g2.drawString("INTERACT",(float) (510 * Main.ex), (float) (425 * Main.ey) );
        g2.drawRect((int) (640 * Main.ex), (int) (400 * Main.ey), (int) (90 * Main.ex), (int) (30 * Main.ey));
        g2.drawString("NEXTDIALOGUE2", (float) (160 * Main.ex), (float) (475 * Main.ey));
        g2.drawRect((int) (640 * Main.ex), (int) (450 * Main.ey), (int) (90 * Main.ex), (int) (30 * Main.ey));
        g2.drawString("PAUSE", (float) (510 * Main.ex), (float) (475 * Main.ey));
        g2.drawRect((int) (40 * Main.ex), (int) (500 * Main.ey), (int) (90 * Main.ex), (int) (30 * Main.ey));
        g2.drawString("INVENTORY", (float) (160 * Main.ex), (float) (525 * Main.ey));
        g2.drawRect((int) (640 * Main.ex), (int) (500 * Main.ey), (int) (90 * Main.ex), (int) (30 * Main.ey));
        g2.drawString("PHONE", (float) (510 * Main.ex), (float) (525 * Main.ey));
        g2.setFont(new Font("Arial", Font.ITALIC, (int) (25 * Main.ex)));

        g2.drawString(upKeyName, (float) (43 * Main.ex), (float) (115 * Main.ey));
        g2.drawString(leftKeyName, (float) (644 * Main.ex), (float) (115 * Main.ey));
        g2.drawString(downKeyName, (float) (43 * Main.ex), (float) (165 * Main.ey));
        g2.drawString(rightKeyName, (int) (644 * Main.ex), (int) (165 * Main.ey));
        g2.drawString(interactKeyName, (int) (644 * Main.ex), (int) (424 * Main.ey));
        g2.drawString(nextDialogueKeyName1, (int) (43 * Main.ex), (int) (424 * Main.ey));
        g2.drawString(nextDialogueKeyName2, (int) (43 * Main.ex), (int) (475 * Main.ey));
        g2.drawString(pauseKeyName, (int) (644 * Main.ex), (int) (475 * Main.ey));
        g2.drawString(inventoryKeyName, (int) (43 * Main.ex), (int) (524 * Main.ey));
        g2.drawString(phoneKeyName, (int) (644 * Main.ex), (int) (524 * Main.ey));

        g2.drawImage(playerUP, (int) (246 * Main.ex), (int) (86 * Main.ey), (int) (40 * Main.ex), (int) (40 * Main.ey),
                null);
        g2.drawImage(playerDOWN, (int) (246 * Main.ex), (int) (139 * Main.ey), (int) (40 * Main.ex),
                (int) (40 * Main.ey), null);
        g2.drawImage(playerLEFT, (int) (487 * Main.ex), (int) (86 * Main.ey), (int) (40 * Main.ex),
                (int) (40 * Main.ey), null);
        g2.drawImage(playerRIGHT, (int) (487 * Main.ex), (int) (139 * Main.ey), (int) (40 * Main.ex),
                (int) (40 * Main.ey), null);
        g2.drawImage(square, (int) (x_square), (int) (y_square), (int) (98 * Main.ex), (int) (38 * Main.ey), null);
        g2.drawImage(enterkey, (int) (150 * Main.ex), (int) (207 * Main.ey), (int) (468 * Main.ex),
                (int) (200 * Main.ey), null);
    }

}
