package tile.tileLibrary;

import main.GamePanel;
import tile.Tile;

import java.awt.*;

public class TileBookcase01 extends Tile {
    public int x,y;
    GamePanel gamePanel;

    public TileBookcase01(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;
        this.gamePanel=gamePanel;
        Name = "Bookcase 01";
        Type = "Interact";
        image = gamePanel.tileManager.tile[7].image;
        BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x+78) * gamePanel.scale);
        setBottomY((y+59) * gamePanel.scale);
        setWidth(78 * gamePanel.scale);
        setHeight(59 * gamePanel.scale);
    }

}
