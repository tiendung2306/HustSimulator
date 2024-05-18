package area.Library;

import main.GamePanel;
import map.Map;
import tile.ExtraTile;
import tile.Tile;

import java.awt.*;

public class Firstfloor_library extends Map {
    Tile background;
    GamePanel gamePanel;


    public Firstfloor_library(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        width = (int) (63.5 * 16 * GamePanel.scale);
        height = (int) (38.5 * 16 * GamePanel.scale);
        background = new Tile();
        background.image = gamePanel.tileManager.tile[2].image;
        setDefaultValues();
    }


    public void setDefaultValues() {
        playerX = (int) (500 * GamePanel.scale);
        playerY = (int) (500 * GamePanel.scale);
        background.setWidth((int) (1000 * GamePanel.scale));
        background.setHeight((int) (600 * GamePanel.scale));

        setUpTileFirstfloor_library();
    }

    public void setUpTileFirstfloor_library() {

    }



    // Phương thức vẽ map
    public void draw(Graphics2D g2) {
        gamePanel.tileManager.draw(g2, background);
        for (int i = 0; i < numTileContainer; ++i)
            gamePanel.tileManager.draw(g2, tileContainer[i]);
    }
}
