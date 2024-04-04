package tile.tileNormalClassroom;

import main.GamePanel;
import tile.Tile;
import tile.TileManager;

import java.awt.*;

public class TileTableTeacherClassroom extends Tile {
    public int x,y;
    GamePanel gamePanel;
    TileManager tileManager;
    public TileTableTeacherClassroom(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;

        this.gamePanel=gamePanel;
        tileManager = new TileManager(gamePanel);
        BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x+30) * gamePanel.scale);
        setBottomY((y+62) * gamePanel.scale);
    }

    public void draw(Graphics2D g2) {
        tileManager.draw(g2, tileManager.tile[2].image,  getLeftX(),  getTopY(), 30 * gamePanel.scale, 62 * gamePanel.scale);
    }
}
