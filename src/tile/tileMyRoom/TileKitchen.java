package tile.tileMyRoom;

import main.GamePanel;
import tile.Tile;

public class TileKitchen extends Tile {
    public int x,y;
    GamePanel gamePanel;

    public TileKitchen(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;
        this.gamePanel=gamePanel;
        Name = "Kitchen";
        Type = "Obstacle";
        image = gamePanel.tileManager.tile[25].image;
        BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x + 34) * gamePanel.scale);
        setBottomY((y + 135) * gamePanel.scale);
        setWidth(34 * gamePanel.scale);
        setHeight(135 * gamePanel.scale);
    }
}
