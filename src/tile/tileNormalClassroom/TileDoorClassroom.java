package tile.tileNormalClassroom;

import main.GamePanel;
import tile.Tile;
import tile.TileManager;

import java.awt.*;

public class TileDoorClassroom extends Tile {
    public int x,y;
    GamePanel gamePanel;
    TileManager tileManager;

    public TileDoorClassroom(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;

        this.gamePanel=gamePanel;
        tileManager = new TileManager(gamePanel);
        this.BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x);
        setTopY(y);
        setRightX(x+41);
        setBottomY(y+51);
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(tileManager.tile[14].image,  getLeftX() * gamePanel.scale,  getTopY() * gamePanel.scale, 41 * gamePanel.scale, 51 * gamePanel.scale, null);
    }
}
