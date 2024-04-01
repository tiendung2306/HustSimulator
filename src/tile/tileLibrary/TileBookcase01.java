package tile.tileLibrary;

import main.GamePanel;
import tile.Tile;
import tile.TileManager;

import java.awt.*;

public class TileBookcase01 extends Tile {
    public int x,y;
    GamePanel gamePanel;
    TileManager tileManager;

    public TileBookcase01(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;

        this.gamePanel=gamePanel;
        tileManager = new TileManager(gamePanel);
        this.BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x+78) * gamePanel.scale);
        setBottomY((y+59) * gamePanel.scale);
    }

    public void draw(Graphics2D g2) {
        tileManager.draw(g2, tileManager.tile[7].image,  getLeftX(),  getTopY(), 78 * gamePanel.scale, 59 * gamePanel.scale);
    }
}
