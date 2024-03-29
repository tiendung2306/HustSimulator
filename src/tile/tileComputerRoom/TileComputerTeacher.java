package tile.tileComputerRoom;

import main.GamePanel;
import tile.Tile;
import tile.TileManager;

import java.awt.*;

public class TileComputerTeacher extends Tile {
    public int x,y;
    GamePanel gamePanel;
    TileManager tileManager;
    public TileComputerTeacher(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;

        this.gamePanel=gamePanel;
        tileManager = new TileManager(gamePanel);
        this.BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x);
        setTopY(y);
        setRightX(x+28);
        setBottomY(y+28);
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(tileManager.tile[4].image,  getLeftX() * gamePanel.scale,  getTopY() * gamePanel.scale, 28 * gamePanel.scale, 28 * gamePanel.scale, null);
    }
}
