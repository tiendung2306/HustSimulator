package tile.tileNormalClassroom;

import main.GamePanel;
import tile.Tile;
import tile.TileManager;

import java.awt.*;

public class TileTableClassroom extends Tile {
    public int x,y;
    GamePanel gamePanel;
    TileManager tileManager;
    public TileTableClassroom(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;

        this.gamePanel=gamePanel;
        tileManager = new TileManager(gamePanel);
        this.BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x);
        setTopY(y);
        setRightX(x+20);
        setBottomY(y+46);
    }

    public void draw(Graphics2D g2) {
        tileManager.draw(g2, tileManager.tile[1].image,  getLeftX() * gamePanel.scale,  getTopY() * gamePanel.scale, 20 * gamePanel.scale, 46 * gamePanel.scale);
    }
}
