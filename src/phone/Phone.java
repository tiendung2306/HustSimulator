package phone;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.awt.*;


import main.GamePanel;

public class Phone {

    GamePanel gamePanel;
    BufferedImage phone;

    public Phone(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        init();
    }

    void init() {
        getImage();
    }

    void getImage() {
        try {
            phone = ImageIO.read(new FileInputStream("res/Phone/phone_icon_ehust_2k.png"));

        } catch (Exception e) {

        }
    }

    public void draw(Graphics2D g2) {
        Color myColor = new Color(45, 39, 39, 190);
        g2.setColor(myColor);
        g2.fillRect(0, 0, gamePanel.screenWidth, gamePanel.screenHeight);
        g2.drawImage(phone, gamePanel.screenWidth / 3, gamePanel.screenHeight / 20, 286, 512, null);
    }
}
