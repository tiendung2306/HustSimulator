package tile.tileStadium;

import main.GamePanel;
import tile.Tile;
import tile.TileManager;

import java.awt.*;

public class TileBall extends Tile {
    public int x,y;
    GamePanel gamePanel;
    TileManager tileManager;

    public TileBall(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;
        this.gamePanel=gamePanel;
        Name = "Ball";
        tileManager = new TileManager(gamePanel);
        BoundingBox();
    }
    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x + 14) * gamePanel.scale);
        setBottomY((y + 14) * gamePanel.scale);
    }

    public void draw(Graphics2D g2) {
        tileManager.draw(g2, tileManager.tile[12].image,  getLeftX(),  getTopY(), 14 * gamePanel.scale, 14 * gamePanel.scale);
    }
}
