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
        this.BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x);
        setTopY(y);
        setRightX(x+79);
        setBottomY(y+46);
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(tileManager.tile[16].image,  getLeftX() * gamePanel.scale,  getTopY() * gamePanel.scale, 79 * gamePanel.scale, 46 * gamePanel.scale, null);
    }
}
