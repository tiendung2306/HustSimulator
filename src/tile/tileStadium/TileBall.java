package tile.tileStadium;

import main.GamePanel;
import tile.Tile;
import tile.TileManager;

import java.awt.*;

public class TileBall extends Tile {
    public int x,y;
    GamePanel gamePanel;
    TileManager tileManager;
    int scale;

    public TileBall(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;
        this.scale = gamePanel.scale;

        this.gamePanel=gamePanel;
        tileManager = new TileManager(gamePanel);
        BoundingBox();
    }
    public void BoundingBox() {
        setLeftX(x * scale);
        setTopY(y * scale);
        setRightX((x + 14) * scale);
        setBottomY((y + 14) * scale);
    }

    public void draw(Graphics2D g2) {
        tileManager.draw(g2, tileManager.tile[12].image,  getLeftX(),  getTopY(), 14 * scale, 14 * scale);
    }
}
