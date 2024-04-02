package tile.tileLibrary;

import main.GamePanel;
import tile.Tile;
import tile.TileManager;

import java.awt.*;

public class TileTableLibrary extends Tile {
    public int x,y;
    GamePanel gamePanel;
    TileManager tileManager;

    public TileTableLibrary(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;
        this.gamePanel=gamePanel;
        Name = "Table Library";
        tileManager = new TileManager(gamePanel);
        this.BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x+30) * gamePanel.scale);
        setBottomY((y+30) * gamePanel.scale);
    }

    public void draw(Graphics2D g2) {
        tileManager.draw(g2, tileManager.tile[5].image,  getLeftX(),  getTopY(), 30 * gamePanel.scale, 30 * gamePanel.scale);
    }
}
