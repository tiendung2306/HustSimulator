package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Mouse.MouseManager;
import main.GamePanel;
import main.Main;

public class Question {
    GamePanel gamePanel;
    String question = "";
    public String answer1 = "", answer2 = "";

    int step = 0;
    boolean reverse;
    int iconX = (int) (207 * GamePanel.scale), iconY = (int) (170 * GamePanel.scale);

    public Boolean isDisplayQuestion = false;
    Boolean isResetMouse;
    int answer = 0;

    public Question(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        isResetMouse = false;
        answer = 0;
    }

    public void setQuestion(String question, String answer1, String answer2) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        isDisplayQuestion = true;
        if(!isResetMouse)    {
            MouseManager.resetLastReleasedPos();
            isResetMouse = true;
        }
    }

    public void closeQuestion() {
        isDisplayQuestion = false;
        isResetMouse = false;
        Main.popGameState();
        System.out.println(Main.topGameState());
    }

    public void resetAnswer() {
        answer = 0;
    }

    public void screenResize() {

    }

    public void update() {
        if(!isDisplayQuestion)  return;
        checkReleased();
    }

    public void draw(Graphics2D g2) {
        if (!Main.topGameState().equals("Dialogue") || !isDisplayQuestion)
            return;
        g2.setFont(new Font("Arial", Font.PLAIN, 40));
        g2.setColor(Color.white);
        drawQuestionScreen(g2, question);
        drawAnswerScreen(g2, answer1, 1);
        drawAnswerScreen(g2, answer2, 2);
    }

    public void drawBackground(Graphics2D g2) {
        if (gamePanel.ui.backgroundDialogue == null)
            return;
        g2.drawImage(gamePanel.ui.backgroundDialogue, 0, 0, (int) GamePanel.screenWidth, (int) GamePanel.screenHeight, null);
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
        int y = (int) (GamePanel.screenHeight - height - 75 * GamePanel.scale);
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
        // ++step;
        // if (step == 8) {
        //     if (!reverse) {
        //         iconX += (int) GamePanel.scale;
        //         // skipX += (int) GamePanel.scale;
        //         if (iconX >= 209 * GamePanel.scale) {
        //             reverse = true;
        //         }
        //     } else {
        //         iconX -= (int) GamePanel.scale;
        //         // skipX -= (int) GamePanel.scale;
        //         if (iconX <= 207 * GamePanel.scale) {
        //             reverse = false;
        //         }
        //     }
        //     step = 0;
        // }
    }

    public void drawAnswerScreen(Graphics2D g2, String text, int numOfAnswer) {
        int x = 32 * (int) GamePanel.scale;
        int width = (int) (GamePanel.screenWidth - 64 * GamePanel.scale);
        int height = (int) (32 * GamePanel.scale);
        int y;
        if (numOfAnswer == 1)
            y = (int) (GamePanel.screenHeight - 73 * GamePanel.scale);
        else
            y = (int) (GamePanel.screenHeight - 39 * GamePanel.scale);
        int FontSize = (int) (GamePanel.scale * 9);
        int FontPixel = (int) (GamePanel.scale * 4);
//        drawBackground(g2);
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
        // ++step;
        // if (step == 8) {
        //     if (!reverse) {
        //         iconX += (int) GamePanel.scale;
        //         // skipX += (int) GamePanel.scale;
        //         if (iconX >= 209 * GamePanel.scale) {
        //             reverse = true;
        //         }
        //     } else {
        //         iconX -= (int) GamePanel.scale;
        //         // skipX -= (int) GamePanel.scale;
        //         if (iconX <= 207 * GamePanel.scale) {
        //             reverse = false;
        //         }
        //     }
        //     step = 0;
        // }
    }

    public void checkReleased() {
        if (MouseManager.lastReleasedX >= 32 * (int) GamePanel.scale
                && MouseManager.lastReleasedX <= 32 * (int) GamePanel.scale
                        + (int) (GamePanel.screenWidth - 64 * GamePanel.scale)) {
            if (MouseManager.lastReleasedY >= (int) (GamePanel.screenHeight - 73 * GamePanel.scale)
                    && MouseManager.lastReleasedY <= (int) (GamePanel.screenHeight - 73 * GamePanel.scale)
                            + (int) (32 * GamePanel.scale)) {
                // System.out.println("click vao cau tra loi 1");
                answer = 1;
                MouseManager.resetLastReleasedPos();
                closeQuestion();
            }
            if (MouseManager.lastReleasedY >= (int) (GamePanel.screenHeight - 39 * GamePanel.scale)
                    && MouseManager.lastReleasedY <= (int) (GamePanel.screenHeight - 39 * GamePanel.scale)
                            + (int) (32 * GamePanel.scale)) {
                // System.out.println("click vao cau tra loi 2");
                MouseManager.resetLastReleasedPos();
                answer = 2;
                closeQuestion();
            }
        }
    }

    public int getAnswer() { //= 0 neu chua chon dap an, = 1 hoac = 2 neu chon dap an 1/2
        return answer;
    }
}
