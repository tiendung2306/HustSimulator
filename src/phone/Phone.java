package phone;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.FileInputStream;

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
            phone = ImageIO.read(new FileInputStream("res/Phone/phone_icon_ehust.png"));
    
        }   catch(Exception e) {
            
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(phone, gamePanel.screenWidth / 3, gamePanel.screenHeight / 6, (int)(gamePanel.screenWidth / 3), (int)(gamePanel.screenHeight / 1.35), null);
    }
}
