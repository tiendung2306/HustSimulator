package tile.tileMyRoom;

import main.GamePanel;
import tile.Tile;

public class TilePan extends Tile {
    public int x,y;
    GamePanel gamePanel;

    public TilePan(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;
        this.gamePanel=gamePanel;
        Name = "My Pan";
        Type = "Interact";
        image = gamePanel.tileManager.tile[23].image;
        BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x + 41) * gamePanel.scale);
        setBottomY((y + 28) * gamePanel.scale);
        setWidth(41 * gamePanel.scale);
        setHeight(28 * gamePanel.scale);
    }
}
