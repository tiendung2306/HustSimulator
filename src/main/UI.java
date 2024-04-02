package main;

import java.awt.*;

public class UI {
    GamePanel gamePanel;
    Graphics2D g2;
    Font arial_40;
    public String currentDialogue = "";
    public UI(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
    }
    public void draw(Graphics2D g2){
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        if (Main.topGameState().equals("GamePause")){
            drawPauseScreen();
        }
        if (Main.topGameState().equals("Dialogue")){
            drawDialogueScreen();
        }
    }
    public void drawPauseScreen(){
        String text = "PAUSED";
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gamePanel.screenWidth / 2 - length / 2;
        int y = gamePanel.screenHeight / 2;
        g2.drawString(text, x, y);
    }
    public void drawDialogueScreen(){
        int x = gamePanel.tileSize * 2;
        int width = gamePanel.screenWidth - gamePanel.tileSize * 4;
        int height = gamePanel.tileSize * 4;
        int y = gamePanel.screenHeight - height - gamePanel.tileSize / 2;
        int FontSize = 28;
        int FontPixel = 12;
        drawSubWindow(x,y,width,height);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, FontSize));
        x += gamePanel.tileSize;
        y += gamePanel.tileSize;
        String str = "";
        int strSize = 0;
        for (int i = 0; i < currentDialogue.length(); ++i){
            strSize += FontPixel;
            if (currentDialogue.charAt(i) == ' '){
                for (int j = i + 1; j <= currentDialogue.length(); ++j)
                    if (j == currentDialogue.length() || currentDialogue.charAt(j) == ' '){
                        if (strSize + (j - i - 1) * FontPixel >= width - gamePanel.tileSize * 2){
                            g2.drawString(str, x, y);
                            str = "";
                            y += 40;
                            strSize = 0;
                        }
                        break;
                    }
                if (strSize > 0)
                    str += ' ';
            } else str += currentDialogue.charAt(i);
        }
        if (strSize > 0)
            g2.drawString(str, x, y);
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
}
