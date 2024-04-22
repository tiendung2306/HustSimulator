package GUI;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.*;

import main.GamePanel;
import main.Main;

public class MissionDescription {
    GamePanel gamePanel;
    String missionDescriptionText = "Làm gì đó đi ní ơi!!!";

    public MissionDescription(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void setMissionDescription(String text) {
        missionDescriptionText = text;
    }

    public void screenResize() {
    }

    public void draw(Graphics2D g2) {
        if (!Main.topGameState().equals("GamePlay"))
            return;
        g2.setFont(new Font("Arial", Font.BOLD, (int)(GamePanel.screenWidth / 55)));
        int width = g2.getFontMetrics().stringWidth(missionDescriptionText);
        FontMetrics fm = g2.getFontMetrics();
        Rectangle2D rect = fm.getStringBounds(missionDescriptionText, g2);

        g2.setColor(Color.WHITE);
        g2.fillRect((int) (GamePanel.screenWidth - width - GamePanel.screenWidth / 75),
                (int) (GamePanel.screenHeight / 6 - fm.getAscent()),
                (int) rect.getWidth(),
                (int) rect.getHeight());

        g2.setColor(Color.DARK_GRAY);
        g2.drawString(missionDescriptionText, (float) (GamePanel.screenWidth - width - GamePanel.screenWidth / 75), (float) (GamePanel.screenHeight / 6));

    }
}
