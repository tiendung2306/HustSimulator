package phone;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import Keyboard.KeyboardManager;
import Mouse.MouseManager;
// import java.awt.geom.Rectangle2D;

import java.io.FileInputStream;
import java.awt.*;

import main.GamePanel;
import main.Main;
import time.TimeSystem;

public class Phone {

    GamePanel gamePanel;
    public boolean isDrawPhone = false;
    public boolean isNewMessage = false;

    String phoneStates[] = { "Screen Saver", "Main Menu", "fHUST", "Message", "Setting", "Map" };
    String phoneState = "Screen Saver";

    BufferedImage phone;
    BufferedImage arrowUp;
    BufferedImage arrowDown;
    BufferedImage phoneWithWallpaper;
    BufferedImage logoFhust;
    BufferedImage logoMessager;
    BufferedImage logoSetting;
    BufferedImage messagerNoNewMessage;
    BufferedImage messagerNewMessage;
    BufferedImage screenSaver;
    BufferedImage mapIcon;
    Schedule schedule = new Schedule();

    int phoneStartX;
    int phoneStartY;
    int phoneWidth;
    int phoneHeight;

    int emptyLineSpaceHeight;

    int textBoxHeight;
    int firstTextBoxHeight;
    int firstTextBoxWidth;

    int secondTextBoxHeight;
    int secondTextBoxWidth;

    int arrowWidth;
    int arrowHeight;

    int logoSize;
    int firstLogoX, firstLogoY;
    int spaceSizeBetween2Logo;
    int spaceSizeBetweenLogoAndName;

    int currentPhonePage = 1; // default la 1
    Boolean isArrowUpExist = false;
    Boolean isArrowDownExist = false;

    public Boolean isOpenFhust = false;
    public Boolean isOpenMessager = false;

    public Phone(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        init();
    }

    void init() {
        schedule.Init();
        getImage();

        screenResize();
    }

    public void screenResize() {
        phoneWidth = (int) Math.max(phone.getWidth() / 10 * 2, phone.getWidth() / 10 * GamePanel.screenWidth / 680);
        phoneHeight = (int) Math.max(phone.getHeight() / 10 * 2, phone.getHeight() / 10 * GamePanel.screenWidth / 680);
        phoneStartX = (int) (GamePanel.screenWidth / 2 - phoneWidth / 2);
        phoneStartY = (int) (GamePanel.screenHeight / 2 - phoneHeight / 2);

        emptyLineSpaceHeight = phone.getHeight() / 100 * 1; // chieu cao giua hai dong ke nhau

        textBoxHeight = phoneHeight * 21 / 100;

        firstTextBoxHeight = phoneStartY + phoneHeight * 34 / 100; // muon chinh chieu cao chu thi sua moi dong nay
        firstTextBoxWidth = phoneStartX + phoneWidth * 17 / 100;

        secondTextBoxHeight = firstTextBoxHeight + textBoxHeight; // khong sua dong nay`
        secondTextBoxWidth = firstTextBoxWidth;

        arrowWidth = 20;
        arrowHeight = 13;

        logoSize = phoneWidth / 7;
        firstLogoX = phoneStartX + (int) (phoneWidth / 4.7);
        firstLogoY = phoneStartY + phoneHeight / 7;
        spaceSizeBetween2Logo = phoneWidth / 13;
        spaceSizeBetweenLogoAndName = phoneHeight / 40;
    }

    public void setPhoneState(String stateName) {
        phoneState = stateName;
        MouseManager.resetLastReleasedPos();
    }

    public void update() {
        if (!isDrawPhone)
            return;
        if(isDrawPhone) {
            if(KeyboardManager.getReleasedKey() == KeyEvent.VK_ESCAPE) isDrawPhone = false;
        }
        checkClicked();
    }

    void getImage() {
        try {
            phone = ImageIO.read(new FileInputStream("res/Phone/phone_icon_ehust_2k.png"));
            arrowUp = ImageIO.read(new FileInputStream("res/Phone/arrow_up.png"));
            arrowDown = ImageIO.read(new FileInputStream("res/Phone/arrow_down.png"));
            phoneWithWallpaper = ImageIO.read(new FileInputStream("res/Phone/phone_with_wallpaper.png"));
            logoFhust = ImageIO.read(new FileInputStream("res/Phone/logo_fHUST.png"));
            logoMessager = ImageIO.read(new FileInputStream("res/Phone/logo_messager_app.png"));
            logoSetting = ImageIO.read(new FileInputStream("res/Phone/setting_icon.png"));
            messagerNoNewMessage = ImageIO.read(new FileInputStream("res/Phone/messager_no_new_message.png"));
            messagerNewMessage = ImageIO.read(new FileInputStream("res/Phone/messager_chapter1_1.png"));
            screenSaver = ImageIO.read(new FileInputStream("res/Phone/screen_saver.png"));
            mapIcon = ImageIO.read(new FileInputStream("res/Phone/map_icon.png"));
        } catch (Exception e) {

        }
    }

    void resetOnNewDay() {
        isArrowDownExist = false;
        isArrowUpExist = false;
        currentPhonePage = 1;
    }

    public void clearMessage() {
        isNewMessage = false;
    }

    public void setNewMessage(String messageName) {
        isNewMessage = true;
        if (messageName == "chapter1_1") {
            try {
                messagerNewMessage = ImageIO.read(new FileInputStream("res/Phone/messager_chapter1_1.png"));
            } catch (Exception e) {
            }
        }
    }

    void drawSubjectInformationOnPhone(Graphics2D g2, int day, int peroid, int X, int Y) {
        if (schedule.getDailySchedule(day, peroid) == null)
            return;
        g2.drawString(schedule.getDailySchedule(TimeSystem.day, peroid).subjectName, X, Y);
        g2.drawString(schedule.getDailySchedule(TimeSystem.day, peroid).timeAndLocation, X, Y + emptyLineSpaceHeight);
    }

    void drawAllSubjectInformationOnPhone(Graphics2D g2) {
        g2.setFont(new Font("Times New Roman", Font.PLAIN, phoneWidth / 19));
        if (currentPhonePage == 1) {
            if (schedule.numOfPeroidPerDay[TimeSystem.day] >= 1)
                drawSubjectInformationOnPhone(g2, TimeSystem.day, 1, firstTextBoxWidth, firstTextBoxHeight);
            if (schedule.numOfPeroidPerDay[TimeSystem.day] >= 2)
                drawSubjectInformationOnPhone(g2, TimeSystem.day, 2, secondTextBoxWidth, secondTextBoxHeight);
        } else if (currentPhonePage == 2) {
            if (schedule.numOfPeroidPerDay[TimeSystem.day] >= 3)
                drawSubjectInformationOnPhone(g2, TimeSystem.day, 3, firstTextBoxWidth, firstTextBoxHeight);
            if (schedule.numOfPeroidPerDay[TimeSystem.day] >= 4)
                drawSubjectInformationOnPhone(g2, TimeSystem.day, 4, secondTextBoxWidth, secondTextBoxHeight);
        }

        // dong` nay` de in ra ngay hien tai, de test
        // g2.drawString(Integer.toString(TimeSystem.day), firstTextBoxWidth / 10 * 13,
        // firstTextBoxHeight - emptyLineSpaceHeight);
    }

    void drawArrow(Graphics2D g2) {
        if (currentPhonePage == 2) {
            g2.drawImage(arrowUp, phoneStartX + phoneWidth / 2 - 15, firstTextBoxHeight - textBoxHeight * 49 / 100,
                    arrowWidth,
                    arrowHeight,
                    null);
            isArrowUpExist = true;
            isArrowDownExist = false;
        }
        if (currentPhonePage == 1 && schedule.numOfPeroidPerDay[TimeSystem.day] >= 3) {
            g2.drawImage(arrowDown, phoneStartX + phoneWidth / 2 - 15, secondTextBoxHeight + textBoxHeight * 62 / 100,
                    arrowWidth,
                    arrowHeight, null);
            isArrowDownExist = true;
            isArrowUpExist = false;
        }
    }

    private void clickOnDownArrow() {
        // System.out.println("down arrow clicked");
        currentPhonePage = 2;
    }

    private void clickOnUpArrow() {
        // System.out.println("up arrow clicked");
        currentPhonePage = 1;
    }

    void checkClicked() {
        if (!Main.topGameState().equals("GamePlay"))
            return;
        switch (phoneState) {
            case "Screen Saver":
                if (MouseManager.lastReleasedX >= phoneStartX + phoneWidth / 2 - phoneWidth / 12
                        && MouseManager.lastReleasedX <= phoneStartX + phoneWidth / 2 - phoneWidth / 12 + phoneWidth / 6
                        && MouseManager.lastReleasedY >= phoneStartY + phoneHeight * 76 / 90
                        && MouseManager.lastReleasedY <= phoneStartY + phoneHeight * 76 / 90 + phoneHeight / 11) {

                    phoneState = "Main Menu";
                }
                break;
            case "fHUST":
                if (isArrowUpExist) {
                    if (MouseManager.lastReleasedX >= phoneStartX + phoneWidth / 2 - 15
                            && MouseManager.lastReleasedX <= phoneStartX + phoneWidth / 2 - 15 + arrowWidth) {
                        if (MouseManager.lastReleasedY >= firstTextBoxHeight - textBoxHeight * 49 / 100
                                && MouseManager.lastReleasedY <= firstTextBoxHeight - textBoxHeight * 49 / 100
                                        + arrowHeight) {
                            clickOnUpArrow();
                        }
                    }
                }
                if (isArrowDownExist) {
                    if (MouseManager.lastReleasedX >= phoneStartX + phoneWidth / 2 - 15
                            && MouseManager.lastReleasedX <= phoneStartX + phoneWidth / 2 - 15 + arrowWidth) {
                        if (MouseManager.lastReleasedY >= secondTextBoxHeight + textBoxHeight * 62 / 100
                                && MouseManager.lastReleasedY <= secondTextBoxHeight + textBoxHeight * 62 / 100
                                        + arrowHeight) {
                            clickOnDownArrow();
                        }
                    }
                }

                if (MouseManager.lastReleasedX >= phoneStartX + phoneWidth / 2 - phoneWidth / 12
                        && MouseManager.lastReleasedX <= phoneStartX + phoneWidth / 2 - phoneWidth / 12 + phoneWidth / 6
                        && MouseManager.lastReleasedY >= phoneStartY + phoneHeight * 76 / 90
                        && MouseManager.lastReleasedY <= phoneStartY + phoneHeight * 76 / 90 + phoneHeight / 11) {
                    // nhan va nut home(dung de chuyen sang ngay tiep theo) (dung cho muc dich test
                    // game)
                    // TimeSystem.day++;
                    // if (TimeSystem.day >= 7)
                    // TimeSystem.day = 1;
                    // resetOnNewDay();
                    // MouseManager.resetLastReleasedPos();

                    phoneState = "Main Menu";
                }
                break;

            case "Main Menu":
                if (MouseManager.lastReleasedX >= firstLogoX && MouseManager.lastReleasedX <= firstLogoX + logoSize
                        && MouseManager.lastReleasedY >= firstLogoY
                        && MouseManager.lastReleasedY <= firstLogoY + logoSize) {
                    phoneState = "fHUST";
                    currentPhonePage = 1;
                    isOpenFhust = true;
                } else if (MouseManager.lastReleasedX >= firstLogoX + logoSize + spaceSizeBetween2Logo
                        && MouseManager.lastReleasedX <= firstLogoX + 2 * logoSize + spaceSizeBetween2Logo
                        && MouseManager.lastReleasedY >= firstLogoY
                        && MouseManager.lastReleasedY <= firstLogoY + logoSize) {
                    phoneState = "Messager";
                    isOpenMessager = true;
                } else if (MouseManager.lastReleasedX >= firstLogoX + 2 * logoSize + 2 * spaceSizeBetween2Logo
                        && MouseManager.lastReleasedX <= firstLogoX + 3 * logoSize + 2 * spaceSizeBetween2Logo
                        && MouseManager.lastReleasedY >= firstLogoY
                        && MouseManager.lastReleasedY <= firstLogoY + logoSize) {
                    Main.pushGameState("Setting");
                    MouseManager.resetLastReleasedPos();
                } else if (MouseManager.lastReleasedX >= firstLogoX
                        && MouseManager.lastReleasedX <= firstLogoX + logoSize
                        && MouseManager.lastReleasedY >= firstLogoY + logoSize + spaceSizeBetweenLogoAndName * 2
                        && MouseManager.lastReleasedY <= firstLogoY + logoSize + spaceSizeBetweenLogoAndName * 2
                                + logoSize) {
                    phoneState = "Map";
                }
                break;
            case "Setting":

                break;
            case "Messager":
                if (MouseManager.lastReleasedX >= phoneStartX + phoneWidth / 2 - phoneWidth / 12
                        && MouseManager.lastReleasedX <= phoneStartX + phoneWidth / 2 - phoneWidth / 12 + phoneWidth / 6
                        && MouseManager.lastReleasedY >= phoneStartY + phoneHeight * 76 / 90
                        && MouseManager.lastReleasedY <= phoneStartY + phoneHeight * 76 / 90 + phoneHeight / 11) {

                    phoneState = "Main Menu";
                }
                break;
        }

    }

    void drawAppLogo(Graphics2D g2, BufferedImage logoImage, String name, int X, int Y, int offsetNameX) {
        // System.out.println(phoneWidth);
        g2.drawImage(logoImage, X, Y, logoSize,
                logoSize, null);
        g2.setFont(new Font("TimesRoman", Font.BOLD, phoneWidth / 22));
        g2.drawString(name, X + offsetNameX, Y + logoSize + spaceSizeBetweenLogoAndName);
    }

    public void draw(Graphics2D g2) {
        if (!isDrawPhone)
            return;
        if (!Main.topGameState().equals("GamePlay"))
            return;
        Color myColor = new Color(45, 39, 39, 190);
        g2.setColor(myColor);
        g2.fillRect(0, 0, (int) GamePanel.screenWidth, (int) GamePanel.screenHeight); // ve lop background mo sau cai
                                                                                      // dien thoai

        switch (phoneState) {
            case "Screen Saver":
                g2.drawImage(screenSaver, phoneStartX, phoneStartY, phoneWidth, phoneHeight, null);
                myColor = new Color(255, 255, 255);
                g2.setColor(myColor);
                g2.setFont(new Font("Verdana", Font.PLAIN, (int) (phoneWidth / 6)));
                int width = g2.getFontMetrics().stringWidth(TimeSystem.currentTime);
                // FontMetrics fm = g2.getFontMetrics();
                // Rectangle2D rect = fm.getStringBounds(TimeSystem.currentTime, g2);
                g2.drawString(TimeSystem.currentTime, phoneStartX + phoneWidth / 2 - width / 2,
                        phoneStartY + phoneHeight / 3);
                g2.setColor(myColor);
                break;
            case "fHUST":
                myColor = new Color(0, 0, 0);
                g2.setColor(myColor);

                g2.drawImage(phone, phoneStartX, phoneStartY, phoneWidth, phoneHeight, null);

                drawArrow(g2);

                drawAllSubjectInformationOnPhone(g2);
                // g2.fillRect(phoneStartX + phoneWidth / 2 - phoneWidth / 12, phoneStartY +
                // phoneHeight * 76 / 90, phoneWidth / 6, phoneHeight / 11); //test vi tri nut
                // home
                break;

            case "Main Menu":
                myColor = new Color(0, 0, 0);
                g2.setColor(myColor);

                g2.drawImage(phoneWithWallpaper, phoneStartX, phoneStartY, phoneWidth, phoneHeight, null);

                drawAppLogo(g2, logoFhust, "fHUST", firstLogoX, firstLogoY, 2);
                drawAppLogo(g2, logoMessager, "Messager", firstLogoX + logoSize + spaceSizeBetween2Logo, firstLogoY,
                        -4);
                drawAppLogo(g2, logoSetting, "Settings", firstLogoX + 2 * logoSize + 2 * spaceSizeBetween2Logo,
                        firstLogoY, 0);
                drawAppLogo(g2, mapIcon, "Map", firstLogoX,
                        firstLogoY + logoSize + spaceSizeBetweenLogoAndName * 2, logoSize / 5);
                break;
            case "Messager":
                if (!isNewMessage) { // neu khong co tin nhan moi
                    myColor = new Color(0, 0, 0);
                    g2.setColor(myColor);
                    g2.drawImage(messagerNoNewMessage, phoneStartX, phoneStartY, phoneWidth, phoneHeight, null);
                    g2.setFont(new Font("Arial", Font.ITALIC, 18));
                    g2.drawString("Không có tin nhắn mới", phoneStartX + phoneWidth * 37 / 200,
                            phoneStartY + phoneHeight / 3);
                } else {
                    g2.drawImage(messagerNewMessage, phoneStartX, phoneStartY, phoneWidth, phoneHeight, null);
                }
                break;
            case "Map":
                gamePanel.section_selection.open(false);
                break;
        }
    }
}
