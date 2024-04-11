package tile.tileMyRoom;

import main.GamePanel;
import tile.Tile;

public class TileFridge extends Tile {
    public int x,y;
    GamePanel gamePanel;

    public TileFridge(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;
        this.gamePanel=gamePanel;
        Name = "My PC";
        Type = "Interact";
        image = gamePanel.tileManager.tile[30].image;
        BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x + 63) * gamePanel.scale);
        setBottomY((y + 92) * gamePanel.scale);
        setWidth(63 * gamePanel.scale);
        setHeight(97 * gamePanel.scale);
    }
}
