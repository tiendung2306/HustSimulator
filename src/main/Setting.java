package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Setting extends JPanel implements Runnable {

    Thread gameThread;
    public BufferedImage SettingBackGround,audio, audio1,audio2, video, video1, video2, key, key1, key2, back;
    private String check = null;
    public Setting()
    {
        getPlayerImage();
    }
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {
        while (gameThread != null) {
            update();
            repaint();
        }
    }
    public String c_check;
    public void rollback()
    {
        c_check = null;
    }
    public void getPlayerImage(){
        try {
            SettingBackGround = ImageIO.read(getClass().getResourceAsStream("/tile/settingbackground.png"));
            audio1 = ImageIO.read(getClass().getResourceAsStream("/tile/audiosetting1.png"));
            audio2 = ImageIO.read(getClass().getResourceAsStream("/tile/audiosetting2.png"));
            video1 = ImageIO.read(getClass().getResourceAsStream("/tile/videosetting11.png"));
            video2 = ImageIO.read(getClass().getResourceAsStream("/tile/videosetting2.png"));
            key1 = ImageIO.read(getClass().getResourceAsStream("/tile/keysetting1.png"));
            key2 = ImageIO.read(getClass().getResourceAsStream("/tile/keysetting2.png"));
            back = ImageIO.read(getClass().getResourceAsStream("/tile/backicon.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void update() {
        key = key1;
        video = video1;
        audio = audio1;
    }
    public void draw(Graphics2D g2) {
        g2.drawImage(SettingBackGround, 0, 0, 768, 576, null);
        g2.drawImage(key, 250, 300, 267,40, null);
        g2.drawImage(audio, 200, 240, 367,40, null);
        g2.drawImage(video, 200, 100, 50,50, null);
        g2.drawImage(back, 10, 10, 40, 40, null);

        super.paintComponent(g2);
    }
}