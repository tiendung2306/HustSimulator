package tile.tileNormalClassroom;

import main.GamePanel;
import tile.Tile;

import java.awt.*;

public class TileDoorClassroom extends Tile {
    public int x,y;
    GamePanel gamePanel;

    public TileDoorClassroom(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;
        this.gamePanel=gamePanel;
        Name = "Door Classroom";
        Type = "Teleport";
        image = gamePanel.tileManager.tile[14].image;
        BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x+41) * gamePanel.scale);
        setBottomY((y+51) * gamePanel.scale);
        setWidth(41 * gamePanel.scale);
        setHeight(51 * gamePanel.scale);
    }
}
