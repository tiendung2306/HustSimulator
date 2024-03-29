package MainMenu;

import main.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Setting extends JPanel implements Runnable {

    Thread gameThread;
    public BufferedImage exitImg,exitImg1,SettingBackGround,audio, audio1,audio2, video, video1, video2, key, key1, key2, back, videoicon, videoicon1, audioicon, audioicon1, keyicon, keyicon1;
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
            SettingBackGround = ImageIO.read(new FileInputStream("res/MainmenuImage/settingbackground.png"));
            audio1 = ImageIO.read(new FileInputStream("res/MainmenuImage/audiosetting1.png"));
            audio2 = ImageIO.read(new FileInputStream("res/MainmenuImage/audiosetting2.png"));
            video1 = ImageIO.read(new FileInputStream("res/MainmenuImage/videosetting1.png"));
            video2 = ImageIO.read(new FileInputStream("res/MainmenuImage/videosetting2.png"));
            key1 = ImageIO.read(new FileInputStream("res/MainmenuImage/keysetting1.png"));
            key2 = ImageIO.read(new FileInputStream("res/MainmenuImage/keysetting2.png"));
            back = ImageIO.read(new FileInputStream("res/MainmenuImage/backicon.png"));
            audioicon1 = ImageIO.read(new FileInputStream("res/MainmenuImage/audioicon.png"));
            keyicon1 = ImageIO.read(new FileInputStream("res/MainmenuImage/keyboardicon.png"));
            videoicon1 = ImageIO.read(new FileInputStream("res/MainmenuImage/videosetting11.png"));
            exitImg1 = ImageIO.read(new FileInputStream("res/player/character_move_left (1).png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String setting_check;
    public void buttonVideoEnter() {
        setting_check = "buttonVideoEnter";
    }
    public void buttonKeyEnter() {
        setting_check = "buttonKeyEnter";
    }
    public void buttonAudioEnter() {
        setting_check = "buttonAudioEnter";
    }
    public void buttonReturnEnter(){
        setting_check = "buttonReturnEnter";
    }
    public void rollbacksetting() {
        setting_check = null;
    }
    public void update() {
        if (setting_check == "buttonVideoEnter") {
            video = video2;
            videoicon = videoicon1;
        } else if (setting_check == "buttonAudioEnter") {
            audio = audio2;
            audioicon = audioicon1;
        } else if (setting_check == "buttonKeyEnter") {
            key = key2;
            keyicon = keyicon1;
        } else if (setting_check == "buttonReturnEnter") {
            exitImg = exitImg1;
        } else {
            key = key1;
            video = video1;
            audio = audio1;
            videoicon = null;
            audioicon = null;
            keyicon = null;
            exitImg = null;
        }

    }
    public void draw(Graphics2D g2) {
        g2.drawImage(SettingBackGround, 0, 0, 768*Main.ex, 576*Main.ex, null);
        g2.drawImage(key, 250*Main.ex, 310*Main.ex, 267*Main.ex,40*Main.ex, null);
        g2.drawImage(audio, 200*Main.ex, 250*Main.ex, 367*Main.ex,40*Main.ex, null);
        g2.drawImage(video, 200*Main.ex, 190*Main.ex, 367*Main.ex,40*Main.ex, null);
        g2.drawImage(back, 10*Main.ex, 10*Main.ex, 40*Main.ex, 40*Main.ex, null);
        g2.drawImage(exitImg, 60*Main.ex, 12*Main.ex, 40*Main.ex, 40*Main.ex, null);
        g2.drawImage(keyicon, 530*Main.ex, 305*Main.ex, 45*Main.ex,45*Main.ex, null);
        g2.drawImage(audioicon, 580*Main.ex, 250*Main.ex, 45*Main.ex,45*Main.ex, null);
        g2.drawImage(videoicon, 580*Main.ex, 190*Main.ex, 45*Main.ex,45*Main.ex, null);
        super.paintComponent(g2);
    }
}