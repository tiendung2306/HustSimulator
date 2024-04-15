package tile.tileMyRoom;

import main.GamePanel;
import tile.Tile;

public class TileChair extends Tile {
    public int x,y;
    GamePanel gamePanel;

    public TileChair(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;
        this.gamePanel = gamePanel;
        Name = "My Chair";
        Type = "Obstacle";
        image = gamePanel.tileManager.tile[24].image;
        BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x + 13) * gamePanel.scale);
        setBottomY((y + 13) * gamePanel.scale);
        setWidth(13 * gamePanel.scale);
        setHeight(13 * gamePanel.scale);
    }
}
