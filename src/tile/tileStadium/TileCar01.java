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
        this.BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x);
        setTopY(y);
        setRightX(x+65);
        setBottomY(y+33);
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(tileManager.tile[10].image,  getLeftX() * gamePanel.scale,  getTopY() * gamePanel.scale, 65 * gamePanel.scale, 33 * gamePanel.scale, null);
    }
}
