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
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x+28) * gamePanel.scale);
        setBottomY((y+28) * gamePanel.scale);
    }

    public void draw(Graphics2D g2) {
        tileManager.draw(g2, tileManager.tile[4].image,  getLeftX(),  getTopY(), 28 * gamePanel.scale, 28 * gamePanel.scale);
    }
}
