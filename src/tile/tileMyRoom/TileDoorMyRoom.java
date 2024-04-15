package tile.tileMyRoom;

import main.GamePanel;
import tile.Tile;

public class TileDoorMyRoom extends Tile {
    public int x,y;
    GamePanel gamePanel;

    public TileDoorMyRoom(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;
        this.gamePanel=gamePanel;
        Name = "Door My Room";
        Type = "Teleport";
        image = gamePanel.tileManager.tile[26].image;
        BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x + 49) * gamePanel.scale);
        setBottomY((y + 61) * gamePanel.scale);
        setWidth(49 * gamePanel.scale);
        setHeight(61 * gamePanel.scale);
    }
}
