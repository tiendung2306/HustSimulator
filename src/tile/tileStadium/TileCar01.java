package tile.tileStadium;

import main.GamePanel;
import tile.Tile;
import tile.TileManager;

import java.awt.*;

public class TileCar01 extends Tile {
    public int x,y;
    GamePanel gamePanel;
    TileManager tileManager;

    public TileCar01(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;

        this.gamePanel=gamePanel;
        tileManager = new TileManager(gamePanel);
        BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x+65) * gamePanel.scale);
        setBottomY((y+33) * gamePanel.scale);
    }

    public void draw(Graphics2D g2) {
        tileManager.draw(g2, tileManager.tile[10].image,  getLeftX(),  getTopY(), 65 * gamePanel.scale, 33 * gamePanel.scale);
    }
}
