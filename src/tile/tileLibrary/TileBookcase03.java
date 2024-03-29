package tile.tileLibrary;

import main.GamePanel;
import tile.Tile;
import tile.TileManager;

import java.awt.*;

public class TileBookcase03 extends Tile {
    public int x,y;
    GamePanel gamePanel;
    TileManager tileManager;

    public TileBookcase03(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;

        this.gamePanel=gamePanel;
        tileManager = new TileManager(gamePanel);
        this.BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x);
        setTopY(y);
        setRightX(x+81);
        setBottomY(y+61);
    }

    public void draw(Graphics2D g2) {
        tileManager.draw(g2, tileManager.tile[9].image,  getLeftX() * gamePanel.scale,  getTopY() * gamePanel.scale, 81 * gamePanel.scale, 61 * gamePanel.scale);
    }
}
