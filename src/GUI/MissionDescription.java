package GUI;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.imageio.ImageIO;

import Mouse.MouseManager;

import java.io.IOException;

import java.awt.*;

import main.GamePanel;
import main.Main;
import main.UI;
import phone.Phone;

public class MissionDescription {
    GamePanel gamePanel;
    String missionDescriptionText = "Làm gì đó đi ní ơi!!!";
    BufferedImage missionIcon;
    BufferedImage newMissionIcon;
    int width, height;
    Phone phone;
    UI ui;
    public Boolean isMissionDescriptionDrawing = false;
    Boolean isNewMission = false;

    public MissionDescription(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.phone = gamePanel.phone;
        this.ui = gamePanel.ui;
        getImage();
        init();
    }

    public void setMissionDescription(String text) {
        if (!missionDescriptionText.equals(text) && text.length() > 0)
            isNewMission = true;
        missionDescriptionText = text;
    }

    public void init() {
        width = (int) (GamePanel.screenWidth / 18);
        height = missionIcon.getHeight() * width / missionIcon.getWidth();
    }

    public void getImage() {
        try {
            missionIcon = ImageIO.read(new FileInputStream("res/GUI/mission_icon.png"));
            newMissionIcon = ImageIO.read(new FileInputStream("res/GUI/new_mission_icon.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void update() {
        if (!Main.topGameState().equals("GamePlay"))
            return;
        checkClicked();
    }

    public void checkClicked() {
        if (!Main.topGameState().equals("GamePlay"))
            return;
        if (this.phone.isDrawPhone)
            return;
        if (MouseManager.lastReleasedX >= (int) (GamePanel.screenWidth - width - GamePanel.screenWidth / 70)
                && MouseManager.lastReleasedX <= (int) (GamePanel.screenWidth - width - GamePanel.screenWidth / 70)
                        + width
                && MouseManager.lastReleasedY >= (int) (GamePanel.screenHeight / 20)
                && MouseManager.lastReleasedY <= (int) (GamePanel.screenHeight / 20) + height) {
            isNewMission = false;
            if (!missionDescriptionText.equals(""))
                Dialogue("Hệ thống: " + missionDescriptionText);
        }
        MouseManager.resetLastReleasedPos();
    }

    void Dialogue(String str) {
        if (Main.topGameState().equals("GamePlay")) {
            ui.currentDialog = str;
            ui.text = str;
            Main.pushGameState("Dialogue");
            isMissionDescriptionDrawing = true;
        }
    }

    public void screenResize() {
        init();
    }

    public void draw(Graphics2D g2) {
        if (!Main.topGameState().equals("GamePlay"))
            return;
        if (isNewMission)
            g2.drawImage(newMissionIcon, (int) (GamePanel.screenWidth - width - GamePanel.screenWidth / 70),
                    (int) (GamePanel.screenHeight / 20), width, height, null);
        else
            g2.drawImage(missionIcon, (int) (GamePanel.screenWidth - width - GamePanel.screenWidth / 70),
                    (int) (GamePanel.screenHeight / 20), width, height, null);
        // g2.setFont(new Font("Arial", Font.BOLD, (int)(GamePanel.screenWidth / 55)));
        // int width = g2.getFontMetrics().stringWidth(missionDescriptionText);
        // FontMetrics fm = g2.getFontMetrics();
        // Rectangle2D rect = fm.getStringBounds(missionDescriptionText, g2);

        // g2.setColor(Color.WHITE);
        // g2.fillRect((int) (GamePanel.screenWidth - width - GamePanel.screenWidth /
        // 75),
        // (int) (GamePanel.screenHeight / 6 - fm.getAscent()),
        // (int) rect.getWidth(),
        // (int) rect.getHeight());

        // g2.setColor(Color.DARK_GRAY);
        // g2.drawString(missionDescriptionText, (float) (GamePanel.screenWidth - width
        // - GamePanel.screenWidth / 75), (float) (GamePanel.screenHeight / 6));

    }
}
