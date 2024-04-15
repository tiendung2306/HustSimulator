package worldMap;

import main.GamePanel;
import map.Map;
import tile.Tile;
import tile.tileMyRoom.*;

import java.awt.*;

public class Section_2 extends Map {
    Tile background;
    GamePanel gamePanel;


    public Section_2(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        maxMapCol = 64;
        maxMapRow = 65;
        tileContainer = new Tile[50];
        background = new Tile();
        background.image = gamePanel.tileManager.tile[33].image;
        background.setWidth(1000 * gamePanel.scale);
        background.setHeight(1000 * gamePanel.scale);

        setUpTileMyRoom();
    }

    public void setUpTileMyRoom() {
        numTileContainer = 0;
        mapIndex = 5;
    }

    // Phương thức vẽ map
    public void draw(Graphics2D g2) {

        gamePanel.tileManager.draw(g2, background);
        for (int i = 0; i < numTileContainer; ++i)
            gamePanel.tileManager.draw(g2, tileContainer[i]);
    }
}
