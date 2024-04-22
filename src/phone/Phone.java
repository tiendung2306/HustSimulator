package phone;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import Mouse.MouseManager;

import java.io.FileInputStream;
import java.awt.*;

import main.GamePanel;
import main.Main;
import time.TimeSystem;

public class Phone {

    GamePanel gamePanel;
    public boolean isDrawPhone = false;
    public boolean isNewMessage = false;

    String phoneStates[] = { "Main Menu", "fHUST", "Message", "Setting" };
    String phoneState = "Main Menu";

    BufferedImage phone;
    BufferedImage arrowUp;
    BufferedImage arrowDown;
    BufferedImage phoneWithWallpaper;
    BufferedImage logoFhust;
    BufferedImage logoMessager;
    BufferedImage logoSetting;
    BufferedImage messagerNoNewMessage;
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
        phoneWidth = (int) Math.max(phone.getWidth() / 10 * 2, phone.getWidth() / 10 * gamePanel.screenWidth / 680);
        phoneHeight = (int) Math.max(phone.getHeight() / 10 * 2, phone.getHeight() / 10 * gamePanel.screenWidth / 680);
        phoneStartX = (int) (gamePanel.screenWidth / 2 - phoneWidth / 2);
        phoneStartY = (int) (gamePanel.screenHeight / 2 - phoneHeight / 2);

        emptyLineSpaceHeight = phone.getHeight() / 100 * 1; // chieu cao giua hai dong ke nhau

        textBoxHeight = phoneHeight / 100 * 21;

        firstTextBoxHeight = phoneStartY + phoneHeight / 100 * 35; // muon chinh chieu cao chu thi sua moi dong nay
        firstTextBoxWidth = phoneStartX + phoneWidth / 100 * 23;

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

    public void update() {
        if (!isDrawPhone)
            return;
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

        } catch (Exception e) {

        }
    }

    void resetOnNewDay() {
        isArrowDownExist = false;
        isArrowUpExist = false;
        currentPhonePage = 1;
    }

    void drawSubjectInformationOnPhone(Graphics2D g2, int day, int peroid, int X, int Y) {
        if (schedule.getDailySchedule(day, peroid) == null)
            return;
        g2.drawString(schedule.getDailySchedule(TimeSystem.day, peroid).subjectName, X, Y);
        g2.drawString(schedule.getDailySchedule(TimeSystem.day, peroid).timeAndLocation, X, Y + emptyLineSpaceHeight);
    }

    void drawAllSubjectInformationOnPhone(Graphics2D g2) {
        g2.setFont(new Font("TimesRoman", Font.PLAIN, 15));
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
            g2.drawImage(arrowUp, phoneStartX + phoneWidth / 2 - 15, firstTextBoxHeight - textBoxHeight / 100 * 55,
                    arrowWidth,
                    arrowHeight,
                    null);
            isArrowUpExist = true;
            isArrowDownExist = false;
        }
        if (currentPhonePage == 1 && schedule.numOfPeroidPerDay[TimeSystem.day] >= 3) {
            g2.drawImage(arrowDown, phoneStartX + phoneWidth / 2 - 15, secondTextBoxHeight + textBoxHeight / 100 * 67,
                    arrowWidth,
                    arrowHeight, null);
            isArrowDownExist = true;
            isArrowUpExist = false;
        }
    }

    public void makeNewMessage(String[] myMessage, String[] recievedMessage) {
        isNewMessage = true;
    }

    public void clearMessage() {
        isNewMessage = false;
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
            case "fHUST":
                if (isArrowUpExist) {
                    if (MouseManager.lastReleasedX >= phoneStartX + phoneWidth / 2 - 15
                            && MouseManager.lastReleasedX <= phoneStartX + phoneWidth / 2 - 15 + arrowWidth) {
                        if (MouseManager.lastReleasedY >= firstTextBoxHeight - textBoxHeight / 100 * 55
                                && MouseManager.lastReleasedY <= firstTextBoxHeight - textBoxHeight / 100 * 55
                                        + arrowHeight) {
                            clickOnUpArrow();
                        }
                    }
                }
                if (isArrowDownExist) {
                    if (MouseManager.lastReleasedX >= phoneStartX + phoneWidth / 2 - 15
                            && MouseManager.lastReleasedX <= phoneStartX + phoneWidth / 2 - 15 + arrowWidth) {
                        if (MouseManager.lastReleasedY >= secondTextBoxHeight + textBoxHeight / 100 * 67
                                && MouseManager.lastReleasedY <= secondTextBoxHeight + textBoxHeight / 100 * 67
                                        + arrowHeight) {
                            clickOnDownArrow();
                        }
                    }
                }

                if (MouseManager.lastReleasedX >= 378 && MouseManager.lastReleasedX <= 423
                        && MouseManager.lastReleasedY >= 456
                        && MouseManager.lastReleasedY <= 508) {
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
                    isOpenFhust = true;
                } else if (MouseManager.lastReleasedX >= firstLogoX + logoSize + spaceSizeBetween2Logo
                        && MouseManager.lastReleasedX <= firstLogoX + 2 * logoSize + spaceSizeBetween2Logo
                        && MouseManager.lastReleasedY >= firstLogoY
                        && MouseManager.lastReleasedY <= firstLogoY + logoSize) {
                    phoneState = "Messager";
                } else if (MouseManager.lastReleasedX >= firstLogoX + 2 * logoSize + 2 * spaceSizeBetween2Logo
                        && MouseManager.lastReleasedX <= firstLogoX + 3 * logoSize + 2 * spaceSizeBetween2Logo
                        && MouseManager.lastReleasedY >= firstLogoY
                        && MouseManager.lastReleasedY <= firstLogoY + logoSize) {
                    Main.pushGameState("Setting");
                    MouseManager.resetLastReleasedPos();
                }
                break;
            case "Setting":

                break;
            case "Messager":
                if (MouseManager.lastReleasedX >= 378 && MouseManager.lastReleasedX <= 423
                        && MouseManager.lastReleasedY >= 456
                        && MouseManager.lastReleasedY <= 508) {
                    phoneState = "Main Menu";
                }
                break;
        }

    }

    void drawAppLogo(Graphics2D g2, BufferedImage logoImage, String name, int X, int Y, int offsetNameX) {
        g2.drawImage(logoImage, X, Y, logoSize,
                logoSize, null);
        g2.setFont(new Font("TimesRoman", Font.BOLD, 13));
        g2.drawString(name, X + offsetNameX, Y + logoSize + spaceSizeBetweenLogoAndName);
    }

    public void draw(Graphics2D g2) {
        if (!isDrawPhone)
            return;
        if (!Main.topGameState().equals("GamePlay"))
            return;
        Color myColor = new Color(45, 39, 39, 190);
        g2.setColor(myColor);
        g2.fillRect(0, 0, (int) gamePanel.screenWidth, (int) gamePanel.screenHeight); // ve lop background mo sau cai dien thoai

        switch (phoneState) {
            case "fHUST":
                myColor = new Color(0, 0, 0);
                g2.setColor(myColor);

                g2.drawImage(phone, phoneStartX, phoneStartY, phoneWidth, phoneHeight, null);

                drawArrow(g2);

                drawAllSubjectInformationOnPhone(g2);
                break;

            case "Main Menu":
                myColor = new Color(0, 0, 0);
                g2.setColor(myColor);

                g2.drawImage(phoneWithWallpaper, phoneStartX, phoneStartY, phoneWidth, phoneHeight, null);

                drawAppLogo(g2, logoFhust, "fHUST", firstLogoX, firstLogoY, 1);
                drawAppLogo(g2, logoMessager, "Messager", firstLogoX + logoSize + spaceSizeBetween2Logo, firstLogoY,
                        -4);
                drawAppLogo(g2, logoSetting, "Settings", firstLogoX + 2 * logoSize + 2 * spaceSizeBetween2Logo,
                        firstLogoY, 0);
                break;
            case "Messager":
                if (!isNewMessage) {
                    myColor = new Color(0, 0, 0);
                    g2.setColor(myColor);
                    g2.drawImage(messagerNoNewMessage, phoneStartX, phoneStartY, phoneWidth, phoneHeight, null);
                    g2.setFont(new Font("Arial", Font.ITALIC, 18));
                    g2.drawString("Không có tin nhắn mới", phoneStartX + phoneWidth * 37 / 200,
                            phoneStartY + phoneHeight / 3);
                    break;
                }
        }

    }
}
