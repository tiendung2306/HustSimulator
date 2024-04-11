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
        Name = "My PC";
        Type = "Interact";
        image = gamePanel.tileManager.tile[25].image;
        BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x + 42) * gamePanel.scale);
        setBottomY((y + 178) * gamePanel.scale);
        setWidth(42 * gamePanel.scale);
        setHeight(178 * gamePanel.scale);
    }
}
