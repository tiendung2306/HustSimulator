package MainMenu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class AudioSetting extends JPanel implements Runnable {

    Thread gameThread;
    private BufferedImage SettingBackGround, back, exitImg, exitImg1, line, player, comment, comment1,volume,volumeX, volume0, volume1, volume2, volume3, mutecmt, mutecmt1;
    private int i;

    public AudioSetting()
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
            back = ImageIO.read(new FileInputStream("res/MainmenuImage/backicon.png"));
            exitImg1 = ImageIO.read(new FileInputStream("res/player/character_move_left (1).png"));
            line = ImageIO.read(new FileInputStream("res/MainmenuImage/straightline.png"));
            comment1 = ImageIO.read(new FileInputStream("res/MainmenuImage/comment.png"));
            player = ImageIO.read(new FileInputStream("res/player/character_move_down (4).png"));
            volume0 = ImageIO.read(new FileInputStream("res/MainmenuImage/zerovolume.png"));
            volume1 = ImageIO.read(new FileInputStream("res/MainmenuImage/lowvolume.png"));
            volume2 = ImageIO.read(new FileInputStream("res/MainmenuImage/mediumvolume.png"));
            volume3 = ImageIO.read(new FileInputStream("res/MainmenuImage/maxvolume.png"));
            volumeX = ImageIO.read(new FileInputStream("res/MainmenuImage/volumemute.png"));
            mutecmt1 = ImageIO.read(new FileInputStream("res/MainmenuImage/comment.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int volumesliderpointX = 230;
    public int mute_unmutestring = 163;
    public static boolean checkenterslider = false;
    public static int checkmute = 1;
    private String check = null, mutestring, mutestring1;
    private int numbervolume = 999;
    public void volumesliderpointX(int i) {
        check = "volumesliderpointclick";
        this.i = i;
    }
    public void checkcomment() {
        check = "checkcomment";
    }
    public void audiorollback() {
        check = null;
    }
    public void buttonReturnEnter() {
        check = "buttonReturnEnter";
    }
    public void muteEnter() {
        check = "muteEnter";
    }
    public void update() {
        if(check == "volumesliderpointclick")
        {
            volumesliderpointX = i;
        } else if (check == "checkcomment") {
            comment = comment1;
            numbervolume = 231;
        } else if (check == "buttonReturnEnter") {
            exitImg = exitImg1;
        } else if (check == "muteEnter") {
            mutecmt = mutecmt1;
            mutestring = mutestring1;
        } else {
            comment = null;
            exitImg = null;
            mutecmt = null;
            mutestring = "";
            numbervolume = 999;
        }
        if (checkmute > 0) {
            if ((int)((volumesliderpointX-217)/3.6) < 34 && (int)((volumesliderpointX-217)/3.6) > 0)
                volume = volume1;
            else if ((int)((volumesliderpointX-217)/3.6) >= 34 && (int)((volumesliderpointX-217)/3.6) < 67)
                volume = volume2;
            else if ((int)((volumesliderpointX-217)/3.6) >= 67)
                volume = volume3;
            else volume = volume0;
            mutestring1 = "Mute";
            mute_unmutestring = 166;
        } else {
            volume = volumeX;
            mutestring1 = "Unmute";
            mute_unmutestring = 156;
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(SettingBackGround, 0, 0, 768, 576, null);
        g2.drawImage(back, 10, 10, 40, 40, null);
        g2.drawImage(exitImg, 60, 12, 40, 40, null);
        g2.drawImage(line, 240, 250, 360,60, null);
        g2.drawImage(player, volumesliderpointX, 250, 50,50, null);
        g2.setFont(new Font("Arial", Font.BOLD, 14));
        g2.setColor(Color.white);
        g2.drawImage(comment, volumesliderpointX + 9, 215, 30,30, null);
        if ((int)((volumesliderpointX-217)/3.6) == 100)
            g2.drawString(""+(int)((volumesliderpointX-217)/3.6),volumesliderpointX + 12,numbervolume);
        else if ((int)((volumesliderpointX-217)/3.6) > 9)
            g2.drawString(""+(int)((volumesliderpointX-217)/3.6),volumesliderpointX + 16,numbervolume);
        else g2.drawString("0"+(int)((volumesliderpointX-217)/3.6),volumesliderpointX + 16,numbervolume);
        g2.drawImage(volume, 170, 254, 50,50, null);
        g2.drawImage(mutecmt, 153, 205, 60,50, null);
        g2.drawString(mutestring,mute_unmutestring,229);

        super.paintComponent(g2);
    }


    
}

