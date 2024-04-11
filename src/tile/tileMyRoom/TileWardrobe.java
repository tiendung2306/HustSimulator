package tile.tileMyRoom;

import main.GamePanel;
import tile.Tile;

public class TileWardrobe extends Tile {
    public int x,y;
    GamePanel gamePanel;

    public TileWardrobe(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;
        this.gamePanel = gamePanel;
        Name = "My Wardrobe";
        Type = "Interact";
        image = gamePanel.tileManager.tile[31].image;
        BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x + 78) * gamePanel.scale);
        setBottomY((y + 88) * gamePanel.scale);
        setWidth(78 * gamePanel.scale);
        setHeight(93 * gamePanel.scale);
    }
}
