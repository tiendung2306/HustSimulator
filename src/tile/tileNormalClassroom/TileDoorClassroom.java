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
        Name = "Door Classroom";
        tileManager = new TileManager(gamePanel);
        BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x+41) * gamePanel.scale);
        setBottomY((y+51) * gamePanel.scale);
    }

    public void draw(Graphics2D g2) {
        tileManager.draw(g2, tileManager.tile[14].image,  getLeftX(),  getTopY(), 41 * gamePanel.scale, 51 * gamePanel.scale);
    }
}
