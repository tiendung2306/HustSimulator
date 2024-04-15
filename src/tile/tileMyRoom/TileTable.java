package tile.tileMyRoom;

import main.GamePanel;
import tile.Tile;

public class TileTable extends Tile {
    public int x,y;
    GamePanel gamePanel;

    public TileTable(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;
        this.gamePanel=gamePanel;
        Name = "My Table";
        Type = "Interact";
        image = gamePanel.tileManager.tile[28].image;
        BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x + 34) * gamePanel.scale);
        setBottomY((y + 62) * gamePanel.scale);
        setWidth(34 * gamePanel.scale);
        setHeight(64 * gamePanel.scale);
    }
}
