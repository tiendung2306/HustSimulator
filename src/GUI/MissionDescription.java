package GUI;

import java.awt.Graphics2D;
import java.awt.*;

import main.GamePanel;
import main.Main;

public class MissionDescription {
    GamePanel gamePanel;
    String missionDescriptionText = "Làm gì đó đi ní ơi";

    public MissionDescription(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void setMissionDescription(String text) {
        missionDescriptionText = text;
    }    

    public void draw(Graphics2D g2) {
        if(!Main.topGameState().equals("GamePlay")) return;
        g2.setFont(new Font("Arial", Font.BOLD, 16));
        g2.setColor(Color.DARK_GRAY);
        int width = g2.getFontMetrics().stringWidth(missionDescriptionText);
        g2.drawString(missionDescriptionText, (int) (gamePanel.screenWidth - width - 2), 105);

    }
}
