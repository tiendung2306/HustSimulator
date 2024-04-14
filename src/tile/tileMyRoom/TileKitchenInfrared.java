package tile.tileMyRoom;

import main.GamePanel;
import tile.Tile;

public class TileKitchenInfrared extends Tile {
    public int x,y;
    GamePanel gamePanel;

    public TileKitchenInfrared(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;
        this.gamePanel=gamePanel;
        Name = "Kitchen Infrared";
        Type = "Interact";
        image = gamePanel.tileManager.tile[22].image;
        BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x + 52) * gamePanel.scale);
        setBottomY((y + 32) * gamePanel.scale);
        setWidth(52 * gamePanel.scale);
        setHeight(32 * gamePanel.scale);
    }
}
