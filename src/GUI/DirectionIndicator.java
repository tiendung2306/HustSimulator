package GUI;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

import main.GamePanel;
import time.TimeSystem;

class Arrow {
    int X, Y, width, height;

    public Arrow(int X, int Y, int width, int height) {
        this.X = X;
        this.Y = Y;
        this.width = width;
        this.height = height;
    }
}

public class DirectionIndicator {
    BufferedImage arrow, arrow1, arrow2, arrow3, arrow4, phone;
    BufferedImage currentImage;
    Arrow[] arrows = new Arrow[1000]; // mang bat dau tu 1
    int arrowCount = 0;
    GamePanel gamePanel;
    public int width, height;

    public DirectionIndicator(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        getImage();
        width = 40;
        height = width * arrow.getHeight() / arrow.getWidth();
    }

    public void update() {
        if ((TimeSystem.getCurrentSystemTimeInMilliseconds() / 100) % 7 == 0)
            currentImage = arrow;
        else if ((TimeSystem.getCurrentSystemTimeInMilliseconds() / 100) % 7 == 2)
            currentImage = arrow1;
        else if ((TimeSystem.getCurrentSystemTimeInMilliseconds() / 100) % 7 == 3)
            currentImage = arrow2;
        else if ((TimeSystem.getCurrentSystemTimeInMilliseconds() / 100) % 7 == 4)
            currentImage = arrow3;
        else if ((TimeSystem.getCurrentSystemTimeInMilliseconds() / 100) % 7 == 5)
            currentImage = arrow4;
        // System.out.println((TimeSystem.getCurrentSystemTimeInMilliseconds() / 1000) %
        // 5);
    }

    void getImage() {
        try {
            phone = ImageIO.read(new FileInputStream("res/Phone/phone_icon_ehust_2k.png"));
            arrow = ImageIO.read(new FileInputStream("res/GUI/arrow_down(0).png"));
            arrow1 = ImageIO.read(new FileInputStream("res/GUI/arrow_down(1).png"));
            arrow2 = ImageIO.read(new FileInputStream("res/GUI/arrow_down(2).png"));
            arrow3 = ImageIO.read(new FileInputStream("res/GUI/arrow_down(3).png"));
            arrow4 = ImageIO.read(new FileInputStream("res/GUI/arrow_down(4).png"));

            currentImage = arrow;
        } catch (Exception e) {

        }
    }

    public void addArrow(int X, int Y) {
        arrows[++arrowCount] = new Arrow(X, Y, width, height);
    }

    public void resetArrow() {
        arrowCount = 0;
    }

    public void drawArrow(Graphics2D g2) {
        // g2.drawImage(currentImage, 12, 22, width, height, null);
        for (int i = 1; i <= arrowCount; i++) {
            draw(g2, arrows[i].X, arrows[i].Y);
        }
    }

    void draw(Graphics2D g2, int X, int Y) {
        int mapX = X;
        int mapY = Y;
        int screenX = mapX - gamePanel.player.getMapX() + gamePanel.player.getBoundingBoxX();
        int screenY = mapY - gamePanel.player.getMapY() + gamePanel.player.getBoundingBoxY();
        g2.drawImage(currentImage, screenX, screenY, width, height, null);
        // g2.drawRect(screenX, screenY, width, height);
    }
}
