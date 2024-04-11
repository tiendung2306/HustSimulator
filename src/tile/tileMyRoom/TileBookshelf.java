package tile.tileMyRoom;

import main.GamePanel;
import tile.Tile;

public class TileBookshelf extends Tile {
    public int x,y;
    GamePanel gamePanel;

    public TileBookshelf(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;
        this.gamePanel=gamePanel;
        Name = "My Bookshelf";
        Type = "Interact";
        image = gamePanel.tileManager.tile[29].image;
        BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x + 105) * gamePanel.scale);
        setBottomY((y + 58) * gamePanel.scale);
        setWidth(105 * gamePanel.scale);
        setHeight(63 * gamePanel.scale);
    }
}
