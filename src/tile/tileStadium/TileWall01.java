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
        BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x+203) * gamePanel.scale);
        setBottomY((y+45) * gamePanel.scale);
    }

    public void draw(Graphics2D g2) {
        tileManager.draw(g2, tileManager.tile[15].image,  getLeftX(),  getTopY(), 203 * gamePanel.scale, 45 * gamePanel.scale);
    }
}
