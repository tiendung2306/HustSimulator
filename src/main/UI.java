package main;

import tile.Tile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class UI {
    GamePanel gamePanel;
    Graphics2D g2;
    Font arial_40;
    public String currentDialog = "";
    public String text = "";
    JPanel textPanel;
    JTextArea textArea;
    BufferedImage nextIcon;
    int iconX = 207 * gamePanel.scale, iconY = 170 * gamePanel.scale, step = 0;
    boolean reverse;
    public UI(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        getImage();
    }
    void getImage(){
        try {
            nextIcon = ImageIO.read(new FileInputStream("res/Dialog/next-icon.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        if (Main.topGameState().equals("GamePause")){
            drawPauseScreen();
        }
        if (Main.topGameState().equals("Dialog")){
            drawDialogScreen();
        }
        if (Main.topGameState().equals("Dialogue")){
            drawDialogueScreen();
        }
        if (Main.topGameState().equals("GamePlay")) {
            if (gamePanel.player.ButtonInteract){
                drawInteractButton();
            }
        }
    }
    public void drawPauseScreen(){
        String text = "PAUSED";
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = (int) (gamePanel.screenWidth / 2 - length / 2);
        int y = (int) (gamePanel.screenHeight / 2);
        g2.drawString(text, x, y);
    }
    public void drawDialogScreen(){
        int x = 32 * (int)gamePanel.scale;
        int width = (int) (gamePanel.screenWidth - 64 * gamePanel.scale);
        int height = (int) (64 * gamePanel.scale);
        int y = (int) (gamePanel.screenHeight - height - 8 * gamePanel.scale);
        int FontSize = 28;
        int FontPixel = 12;
        drawSubWindow(x,y,width,height);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, FontSize));
        x += 16 * gamePanel.scale;
        y += 16 * gamePanel.scale;
        String str = "";
        int strSize = 0;
        for (int i = 0; i < currentDialog.length(); ++i){
            strSize += FontPixel;
            if (currentDialog.charAt(i) == ' '){
                for (int j = i + 1; j <= currentDialog.length(); ++j)
                    if (j == currentDialog.length() || currentDialog.charAt(j) == ' '){
                        if (strSize + (j - i - 1) * FontPixel >= width - 36 * gamePanel.scale){
                            g2.drawString(str, x, y);
                            str = "";
                            y += 40;
                            strSize = 0;
                        }
                        break;
                    }
                if (strSize > 0)
                    str += ' ';
            } else str += currentDialog.charAt(i);
        }
        if (strSize > 0)
            g2.drawString(str, x, y);
    }
    public void drawDialogueScreen(){
        int x = 32 * (int)gamePanel.scale;
        int width = (int) (gamePanel.screenWidth - 64 * gamePanel.scale);
        int height = (int) (64 * gamePanel.scale);
        int y = (int) (gamePanel.screenHeight - height - 8 * gamePanel.scale);
        int FontSize = 28;
        int FontPixel = 12;
        drawSubWindow(x,y,width,height);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, FontSize));
        //timer.start();
        x += 16 * gamePanel.scale;
        y += 16 * gamePanel.scale;
        String str = "";
        int strSize = 0;
        for (int i = 0; i < currentDialog.length(); ++i){
            strSize += FontPixel;
            if (currentDialog.charAt(i) == ' '){
                for (int j = i + 1; j <= currentDialog.length(); ++j)
                    if (j == currentDialog.length() || currentDialog.charAt(j) == ' '){
                        if (strSize + (j - i - 1) * FontPixel >= width - 36 * gamePanel.scale){
                            g2.drawString(str, x, y);
                            str = "";
                            y += 40;
                            strSize = 0;
                        }
                        break;
                    }
                if (strSize > 0)
                    str += ' ';
            } else str += currentDialog.charAt(i);
        }
        if (strSize > 0)
            g2.drawString(str, x, y);
        ++step;
        if (step == 8) {
            if (!reverse) {
                iconX += gamePanel.scale;
                if (iconX == 209 * gamePanel.scale) {
                    reverse = true;
                }
            } else {
                iconX -= gamePanel.scale;
                if (iconX == 207 * gamePanel.scale) {
                    reverse = false;
                }
            }
            step = 0;
        }
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 12));
        g2.drawString("Press Space", 183 * gamePanel.scale, 175 * gamePanel.scale);
        g2.drawImage(nextIcon, iconX, iconY, 10 * gamePanel.scale, 7 * gamePanel.scale, null);
    }
    int i;
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            char character[] = text.toCharArray();
            int arrayNumber = character.length;

            String addedCharacter = String.valueOf(character[i]);
            textArea.append(addedCharacter);

            i++;
            if (i == arrayNumber){
                i = 0;
                timer.stop();
            }
        }
    });
    public void drawInteractButton(){
        String text =  "F";
        g2.setColor(Color.BLACK);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 11));
        int x = gamePanel.player.getBoundingBoxX() + gamePanel.player.getBoundingBoxWidth();
        int y = gamePanel.player.getBoundingBoxY();
        int width = (int) ((int) g2.getFontMetrics().getStringBounds(text, g2).getWidth() + 8 * gamePanel.scale);
        int height = (int) (8 * gamePanel.scale);
        drawSubInteractButton((int) (x - 4 * gamePanel.scale), (int) (y - height / 2 - gamePanel.scale),width,height);
        g2.drawString(text, x, y);
    }
    public void drawSubWindow(int x, int y, int width, int height){
        Color c = new Color(0,0,0, 100);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
    }
    public void drawSubInteractButton(int x, int y, int width, int height){
        Color c = new Color(0,0,0, 100);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 25, 25);

        c = new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(2));
        g2.drawRoundRect(x + 2, y + 2, width - 4, height - 4, 25, 25);
    }
    public void drawBackground(BufferedImage image){
        g2.drawImage(image, 0, 0, (int)gamePanel.screenWidth, (int)gamePanel.screenHeight, null);
    }
}
