package GUI;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.*;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.Main;
import time.TimeSystem;

public class TimeBoard {
    BufferedImage timeBoard;
    GamePanel gamePanel;
    int timeBoardWidth;
    int timeBoardHeight;
    public TimeBoard(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        init();
    }

    void init() {
        getImage();
        timeBoardWidth = 150;
        timeBoardHeight = (int)(timeBoard.getHeight() * timeBoardWidth / timeBoard.getWidth());
    }

    void getImage() {
        try {
            timeBoard = ImageIO.read(new FileInputStream("res/TimeBoard/TimeBoard(1).png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        if(!Main.topGameState().equals("GamePlay")) return;
        g2.drawImage(timeBoard, gamePanel.screenWidth - timeBoardWidth, 0, timeBoardWidth, timeBoardHeight, null);
        g2.setFont(new Font("Verdana", Font.PLAIN, 24));
        g2.drawString(TimeSystem.currentTime, gamePanel.screenWidth - timeBoardWidth * 24 / 32, timeBoardHeight / 3 * 2);

    }
}
