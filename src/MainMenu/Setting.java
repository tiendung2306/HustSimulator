package MainMenu;

import main.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Setting {

    Thread gameThread;
    public BufferedImage exitImg, exitImg1, SettingBackGround, audio, audio1, audio2, video, video1, video2, key, key1,
            key2, back, videoicon, videoicon1, audioicon, audioicon1, keyicon, keyicon1;
    private String check = null;

    public Setting() {
        getImage();
    }
    public void getImage() {
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

    public void buttonVideoEnter() {
        check = "buttonVideoEnter";
    }

    public void buttonKeyEnter() {
        check = "buttonKeyEnter";
    }

    public void buttonAudioEnter() {
        check = "buttonAudioEnter";
    }

    public void buttonReturnEnter() {
        check = "buttonReturnEnter";
    }

    public void rollbacksetting() {
        check = null;
    }

    public void Init() {
        check = "";
    }

    public void update() {
        if (check == "buttonVideoEnter") {
            video = video2;
            videoicon = videoicon1;
        } else if (check == "buttonAudioEnter") {
            audio = audio2;
            audioicon = audioicon1;
        } else if (check == "buttonKeyEnter") {
            key = key2;
            keyicon = keyicon1;
        } else if (check == "buttonReturnEnter") {
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
        g2.drawImage(SettingBackGround, 0, 0, (int) (768 * Main.ex), (int) (576 * Main.ey), null);
        g2.drawImage(key, (int) (250 * Main.ex), (int) (310 * Main.ey), (int) (267 * Main.ex), (int) (40 * Main.ey), null);
        g2.drawImage(audio, (int) (200 * Main.ex), (int) (250 * Main.ey), (int) (367 * Main.ex), (int) (40 * Main.ey), null);
        g2.drawImage(video, (int) (200 * Main.ex), (int) (190 * Main.ey), (int) (367 * Main.ex), (int) (40 * Main.ey), null);
        g2.drawImage(back, (int) (10 * Main.ex), (int) (10 * Main.ey), (int) (40 * Main.ex), (int) (40 * Main.ey), null);
        g2.drawImage(exitImg, (int) (60 * Main.ex), (int) (12 * Main.ey), (int) (40 * Main.ex), (int) (40 * Main.ey), null);
        g2.drawImage(keyicon, (int) (530 * Main.ex), (int) (305 * Main.ey), (int) (45 * Main.ex), (int) (45 * Main.ey), null);
        g2.drawImage(audioicon, (int) (580 * Main.ex), (int) (250 * Main.ey), (int) (45 * Main.ex), (int) (45 * Main.ey), null);
        g2.drawImage(videoicon, (int) (580 * Main.ex), (int) (190 * Main.ey), (int) (45 * Main.ex), (int) (45 * Main.ey), null);
    }
}