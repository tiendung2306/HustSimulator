package area;

import main.GamePanel;
import map.Map;
import tile.Tile;

import java.awt.*;

public class Section_3 extends Map {
    GamePanel gamePanel;
    Tile background;

    public Section_3(GamePanel gamePanel) {
        super();
        this.gamePanel = gamePanel;
        maxMapCol = 64;
        maxMapRow = 65;
        playerX = 266 * gamePanel.scale;
        playerY = 660 * gamePanel.scale;
        tileContainer = new Tile[50];
        gamePanel.tileManager.getTileImage();
        background = new Tile();
        background.image = gamePanel.tileManager.tile[1].image;
        background.setWidth(1000 * gamePanel.scale);
        background.setHeight(1000 * gamePanel.scale);
    }


    public void draw(Graphics2D g2) {
        gamePanel.tileManager.draw(g2, background);
//        for (int i = 0; i < numTileContainer; ++i)
//            gamePanel.tileWorldMapManager.draw(g2, tileContainer[i]);
    }
}
