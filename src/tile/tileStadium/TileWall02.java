package tile.tileStadium;

import main.GamePanel;
import tile.Tile;
import tile.TileManager;

import java.awt.*;

public class TileWall02 extends Tile {
    public int x,y;
    GamePanel gamePanel;
    TileManager tileManager;

    public TileWall02(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;

        this.gamePanel=gamePanel;
        tileManager = new TileManager(gamePanel);
        BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x+79) * gamePanel.scale);
        setBottomY((y+46) * gamePanel.scale);
    }

    public void draw(Graphics2D g2) {
        tileManager.draw(g2, tileManager.tile[16].image,  getLeftX(),  getTopY(), 79 * gamePanel.scale, 46 * gamePanel.scale);
    }
}
