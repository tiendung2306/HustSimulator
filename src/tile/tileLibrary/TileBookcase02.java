package tile.tileLibrary;

import main.GamePanel;
import tile.Tile;
import tile.TileManager;

import java.awt.*;

public class TileBookcase02 extends Tile {
    public int x,y;
    GamePanel gamePanel;
    TileManager tileManager;

    public TileBookcase02(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;

        this.gamePanel=gamePanel;
        tileManager = new TileManager(gamePanel);
        this.BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x);
        setTopY(y);
        setRightX(x+16);
        setBottomY(y+140);
    }

    public void draw(Graphics2D g2) {
        tileManager.draw(g2, tileManager.tile[8].image,  getLeftX() * gamePanel.scale,  getTopY() * gamePanel.scale, 16 * gamePanel.scale, 140 * gamePanel.scale);
    }
}
