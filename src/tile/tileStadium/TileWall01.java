package tile.tileStadium;

import main.GamePanel;
import tile.Tile;
import tile.TileManager;

import java.awt.*;

public class TileWall01 extends Tile {
    public int x,y;
    GamePanel gamePanel;
    TileManager tileManager;

    public TileWall01(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;

        this.gamePanel=gamePanel;
        tileManager = new TileManager(gamePanel);
        this.BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x);
        setTopY(y);
        setRightX(x+203);
        setBottomY(y+45);
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(tileManager.tile[15].image,  getLeftX() * gamePanel.scale,  getTopY() * gamePanel.scale, 203 * gamePanel.scale, 45 * gamePanel.scale, null);
    }
}
