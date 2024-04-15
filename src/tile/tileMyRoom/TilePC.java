package tile.tileMyRoom;

import main.GamePanel;
import tile.Tile;

public class TilePC extends Tile {
    public int x,y;
    GamePanel gamePanel;

    public TilePC(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;
        this.gamePanel=gamePanel;
        Name = "My PC";
        Type = "Interact";
        image = gamePanel.tileManager.tile[32].image;
        BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x + 102) * gamePanel.scale);
        setBottomY((y + 55) * gamePanel.scale);
        setWidth(102 * gamePanel.scale);
        setHeight(61 * gamePanel.scale);
    }
}
