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
        Name = "Bookcase 02";
        tileManager = new TileManager(gamePanel);
        this.BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x+16) * gamePanel.scale);
        setBottomY((y+140) * gamePanel.scale);
    }

    public void draw(Graphics2D g2) {
        tileManager.draw(g2, tileManager.tile[8].image,  getLeftX(),  getTopY(), 16 * gamePanel.scale, 140 * gamePanel.scale);
    }
}
