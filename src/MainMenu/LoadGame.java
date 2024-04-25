package MainMenu;

import main.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class LoadGame extends JPanel {
    private BufferedImage LoadGameBackGround, back, exitImg, exitImg1, select, rectengle_1, rectengle_2, rectengle_3, rectengle1, rectengle2, chap1, chap2, chap3, inrec1, inrec2, inrec3, inrecchap_1, inrecchap_2, inrecchap_3;
    private String date1 = "", time1 = "", date2 = "", time2 = "", date3 = "", time3 = "", playingtime2 = "", playingtime3 = "", playingtime1 = "";
    public LoadGame() {
        getImage();
        readFileLoadGame();
    }


    public void getImage() {
        try {
            LoadGameBackGround = ImageIO.read(new FileInputStream("res/MainmenuImage/settingbackgroundmo.png"));
            back = ImageIO.read(new FileInputStream("res/MainmenuImage/backicon.png"));
            exitImg1 = ImageIO.read(new FileInputStream("res/player/character_move_left (1).png"));
            select = ImageIO.read(new FileInputStream("res/MainmenuImage/selectsavedgame.png"));
            rectengle1 = ImageIO.read(new FileInputStream("res/MainmenuImage/rectengle.png"));
            rectengle2 = ImageIO.read(new FileInputStream("res/MainmenuImage/Rectangle_1.png"));
            chap1 = ImageIO.read(new FileInputStream("res/MainmenuImage/chap1.png"));
            chap2 = ImageIO.read(new FileInputStream("res/MainmenuImage/chap2.png"));
            chap3 = ImageIO.read(new FileInputStream("res/MainmenuImage/chap3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean check1_loadgame = false, check2_loadgame = false, check3_loadgame = false;
    private String check = "null";
    public void LoadGamerollback() {
        check = "null";
    }
    public void buttonLoadGameReturnEnter() {
        check = "buttonReturnEnter";
    }
    public void Init() {
        check = "";
    }
    public void readFileLoadGame(){
        try {
            BufferedReader source = new BufferedReader(new InputStreamReader(new FileInputStream("src/txt/loadGame.txt")));
            int cnt = 1;
            while (true) {
                String linebreak = source.readLine();
                if (linebreak.length() == 0) {
                    break;
                } else {
                    boolean next = true;
                    while (next) {
                        String line = source.readLine();
                        String values[] = line.split(" ");
                        switch (values[0]) {
                            case "chap":
                                if (cnt == 1) {
                                    check1_loadgame = true;
                                    if (Integer.parseInt(values[1]) == 1) inrecchap_1 = chap1;
                                    else if (Integer.parseInt(values[1]) == 2) inrecchap_1 = chap2;
                                    else if (Integer.parseInt(values[1]) == 3) inrecchap_1 = chap3;
                                } else if (cnt == 2) {
                                    check2_loadgame = true;
                                    if (Integer.parseInt(values[1]) == 1) inrecchap_2 = chap1;
                                    else if (Integer.parseInt(values[1]) == 2) inrecchap_2 = chap2;
                                    else if (Integer.parseInt(values[1]) == 3) inrecchap_2 = chap3;
                                } else if (cnt == 3) {
                                    check3_loadgame = true;
                                    if (Integer.parseInt(values[1]) == 1) inrecchap_3 = chap1;
                                    else if (Integer.parseInt(values[1]) == 2) inrecchap_3 = chap2;
                                    else if (Integer.parseInt(values[1]) == 3) inrecchap_3 = chap3;
                                }
                                break;
                            case "time":
                                if (cnt == 1) {
                                    playingtime1 = values[1];
                                } else if (cnt == 2) {
                                    playingtime2 = values[1];
                                } else if (cnt == 3) {
                                    playingtime3 = values[1];
                                }
                                break;
                            case "date":
                                if (cnt == 1) {
                                    date1 = values[2];
                                    time1 = values[1];
                                } else if (cnt == 2) {
                                    date2 = values[2];
                                    time2 = values[1];
                                } else if (cnt == 3) {
                                    date3 = values[2];
                                    time3 = values[1];
                                }
                                break;
                            case "end":
                                next = false;
                                cnt++;
                                break;
                        }
                    }
                }
            }
            source.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void update() {
       if (check == "buttonReturnEnter")
           exitImg = exitImg1;
       else {
           exitImg = null;
       }
       if (check1_loadgame) {
           rectengle_1 = rectengle2;
           inrec1 = inrecchap_1;
       }
       else {
           rectengle_1 = rectengle1;
           inrec1 = null;
       }
        if (check2_loadgame) {
            rectengle_2 = rectengle2;
            inrec2 = inrecchap_2;
        }
        else {
            rectengle2 = rectengle1;
            inrec2 = null;
        }
        if (check3_loadgame) {
            rectengle_3 = rectengle2;
            inrec3 = inrecchap_3;
        }
        else {
            rectengle_3 = rectengle1;
            inrec3 = null;
        }
    }
    public void draw(Graphics2D g2) {
        g2.drawImage(LoadGameBackGround, 0, 0, (int) (768 * Main.ex), (int) (576 * Main.ey), null);
        g2.drawImage(back, (int) (10 * Main.ex), (int) (10 * Main.ey), (int) (40 * Main.ex), (int) (40 * Main.ey), null);
        g2.drawImage(exitImg, (int) (60 * Main.ex), (int) (12 * Main.ey), (int) (40 * Main.ex), (int) (40 * Main.ey), null);
        g2.drawImage(select, (int) (210 * Main.ex), (int) (60 * Main.ey), (int) (350 * Main.ex), (int) (70 * Main.ey), null);
        g2.setFont(new Font("Arial", Font.ITALIC, (int) (25 * Main.ex)));
        g2.setColor(Color.gray);
        g2.drawString("Empty", (float) (345 * Main.ex), (float) (210 * Main.ey));
        g2.drawString("Empty", (float) (345 * Main.ex), (float) (340 * Main.ey));
        g2.drawString("Empty", (float) (345 * Main.ex), (float) (470 * Main.ey));
        g2.drawImage(rectengle_1, (int) (214 * Main.ex), (int) (150 * Main.ey), (int) (340 * Main.ex), (int) (110 * Main.ey), null);
        g2.drawImage(rectengle_2, (int) (214 * Main.ex), (int) (280 * Main.ey), (int) (340 * Main.ex), (int) (110 * Main.ey), null);
        g2.drawImage(rectengle_3, (int) (214 * Main.ex), (int) (410 * Main.ey), (int) (340 * Main.ex), (int) (110 * Main.ey), null);
        g2.drawImage(inrec1, (int) (240 * Main.ex), (int) (165 * Main.ey), (int) (220 * Main.ex), (int) (80 * Main.ey), null);
        g2.drawImage(inrec2, (int) (240 * Main.ex), (int) (295 * Main.ey), (int) (220 * Main.ex), (int) (80 * Main.ey), null);
        g2.drawImage(inrec3, (int) (240 * Main.ex), (int) (425 * Main.ey), (int) (220 * Main.ex), (int) (80 * Main.ey), null);
        g2.setFont(new Font("Arial", Font.BOLD, (int) (12 * Main.ex)));
        g2.setColor(Color.black);
        g2.drawString(date1, (float) (465 * Main.ex), (float) (177 * Main.ey));
        g2.drawString(time1, (float) (465 * Main.ex), (float) (192 * Main.ey));
        g2.drawString(playingtime1, (float) (465 * Main.ex), (float) (241 * Main.ey));
        g2.drawString(time2, (float) (465 * Main.ex), (float) (307 * Main.ey));
        g2.drawString(date1, (float) (465 * Main.ex), (float) (322 * Main.ey));
        g2.drawString(playingtime2, (float) (465 * Main.ex), (float) (371 * Main.ey));
        g2.drawString(time3, (float) (465 * Main.ex), (float) (437 * Main.ey));
        g2.drawString(date1, (float) (465 * Main.ex), (float) (452 * Main.ey));
        g2.drawString(playingtime3, (float) (465 * Main.ex), (float) (501 * Main.ey));
        super.paintComponent(g2);
    }

}
