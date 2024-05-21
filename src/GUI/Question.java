package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GamePanel;
import main.Main;

public class Question {
    GamePanel gamePanel;
    String question = "";
    String answer1 = "", answer2 = "";

    BufferedImage backgroundDialogue;

    int step = 0;
    boolean reverse;
    int iconX = (int) (207 * GamePanel.scale), iconY = (int) (170 * GamePanel.scale);

    public Boolean isDisplayQuestion = false;

    public Question(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        backgroundDialogue = gamePanel.ui.backgroundDialogue;
    }

    public void setQuestion(String question, String answer1, String answer2) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        isDisplayQuestion = true;
    }

    public void closeQuestion() {
        isDisplayQuestion = false;
    }

    public void screenResize() {

    }

    public void draw(Graphics2D g2) {
        if (!Main.topGameState().equals("Dialogue") || !isDisplayQuestion)
            return;
        g2.setFont(new Font("Arial", Font.PLAIN, 40));
        g2.setColor(Color.white);
        drawQuestionScreen(g2, question);
        // if (Main.topGameState().equals("GamePlay")) {
        // if (gamePanel.player.ButtonInteract && !gamePanel.phone.isDrawPhone) {
        // drawInteractButton();
        // }
        // }
    }

    public void drawBackground(Graphics2D g2) {
        if (backgroundDialogue == null)
            return;
        g2.drawImage(backgroundDialogue, 0, 0, (int) GamePanel.screenWidth, (int) GamePanel.screenHeight, null);
        Color myColor = new Color(45, 39, 39, 190);
        g2.setColor(myColor);
        g2.fillRect(0, 0, (int) GamePanel.screenWidth, (int) GamePanel.screenHeight);
    }

    public void drawSubWindow(Graphics2D g2, int x, int y, int width, int height) {
        Color c = new Color(0, 0, 0, 100);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
    }

    public void drawQuestionScreen(Graphics2D g2, String text) {
        int x = 32 * (int) GamePanel.scale;
        int width = (int) (GamePanel.screenWidth - 64 * GamePanel.scale);
        int height = (int) (64 * GamePanel.scale);
        int y = (int) (GamePanel.screenHeight - height - 50 * GamePanel.scale);
        int FontSize = (int) (GamePanel.scale * 9);
        int FontPixel = (int) (GamePanel.scale * 4);
        drawBackground(g2);
        // drawCharacterDialogue();
        drawSubWindow(g2, x, y, width, height);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, FontSize));
        x += (int) (16 * GamePanel.scale);
        y += (int) (16 * GamePanel.scale);
        String str = "";
        int strSize = 0;
        for (int i = 0; i < text.length(); ++i) {
            strSize += FontPixel;
            if (text.charAt(i) == ' ') {
                for (int j = i + 1; j <= text.length(); ++j)
                    if (j == text.length() || text.charAt(j) == ' ') {
                        if (strSize + (j - i - 1) * FontPixel >= width - 36 * GamePanel.scale) {
                            g2.drawString(str, x, y);
                            str = "";
                            y += 40;
                            strSize = 0;
                        }
                        break;
                    }
                if (strSize > 0)
                    str += ' ';
            } else
                str += text.charAt(i);
        }
        if (strSize > 0)
            g2.drawString(str, x, y);
        ++step;
        if (step == 8) {
            if (!reverse) {
                iconX += (int) GamePanel.scale;
                // skipX += (int) GamePanel.scale;
                if (iconX >= 209 * GamePanel.scale) {
                    reverse = true;
                }
            } else {
                iconX -= (int) GamePanel.scale;
                // skipX -= (int) GamePanel.scale;
                if (iconX <= 207 * GamePanel.scale) {
                    reverse = false;
                }
            }
            step = 0;
        }
        // g2.setFont(g2.getFont().deriveFont(Font.PLAIN, (int) (GamePanel.scale * 4)));
        // g2.drawString("Press Space", (int) (182 * GamePanel.scale), (int) (175 * GamePanel.scale));
        // g2.drawImage(nextIcon, iconX, iconY, (int) (10 * GamePanel.scale), (int) (7 *
        // GamePanel.scale), null);
        // g2.setFont(g2.getFont().deriveFont(Font.PLAIN, (int) (GamePanel.scale * 7)));
        // g2.drawImage(skipWord, (int) (27 * GamePanel.scale), (int) (11 *
        // GamePanel.scale), (int) (15 * GamePanel.scale),
        // (int) (5 * GamePanel.scale), null);
        // g2.drawImage(skipIcon, skipX, skipY, (int) (17 * GamePanel.scale), (int) (7 *
        // GamePanel.scale), null);
    }
}
