package tile.tileLibrary;

import main.GamePanel;
import tile.Tile;

public class TileBookcase02 extends Tile {
    public int x,y;
    GamePanel gamePanel;

    public TileBookcase02(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;
        this.gamePanel=gamePanel;
        Name = "Bookcase 02";
        Type = "Interact";
        image = gamePanel.tileManager.tile[8].image;
        BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x+16) * gamePanel.scale);
        setBottomY((y+140) * gamePanel.scale);
        setWidth(16 * gamePanel.scale);
        setHeight(140 * gamePanel.scale);
    }

}
