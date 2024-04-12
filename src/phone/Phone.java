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
    Schedule schedule = new Schedule();

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
        int phoneStartX = gamePanel.screenWidth / 3;
        int phoneStartY = gamePanel.screenHeight / 20;
        int phone_width = phone.getWidth() / 10 * 2;
        int phone_height = phone.getHeight() / 10 * 2;

        int emptyLineSpaceHeight = phone.getHeight() / 100 * 1; //chieu cao giua hai dong ke nhau

        int firstTextBoxHeight = phoneStartY + phone_height / 100 * 35; //muon chinh chieu cao chu thi sua moi dong nay
        int firstTextBoxWidth = phoneStartX + phone_width / 100 * 23;

        int secondTextBoxHeight = firstTextBoxHeight + phone_height / 100 * 21; //khong sua dong nay`
        int secondTextBoxWidth = firstTextBoxWidth;
        

        g2.drawImage(phone, phoneStartX, phoneStartY, phone_width, phone_height, null);
        g2.setFont(new Font("TimesRoman", Font.PLAIN, 15)); 
        g2.drawString(schedule.nmcntt_th1.subjectName, firstTextBoxWidth, firstTextBoxHeight);
        g2.drawString(schedule.nmcntt_th1.timeAndLocation, firstTextBoxWidth, firstTextBoxHeight + emptyLineSpaceHeight);

        g2.drawString(schedule.nmcntt_th2.subjectName, secondTextBoxWidth, secondTextBoxHeight);
        g2.drawString(schedule.nmcntt_th2.timeAndLocation, secondTextBoxWidth, secondTextBoxHeight + emptyLineSpaceHeight);
    }
}
