package tile.tileLibrary;

import main.GamePanel;
import tile.Tile;

public class TileBookcase03 extends Tile {
    public int x,y;
    GamePanel gamePanel;

    public TileBookcase03(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;
        this.gamePanel=gamePanel;
        Name = "Bookcase 03";
        Type = "Interact";
        image = gamePanel.tileManager.tile[9].image;
        BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x+81) * gamePanel.scale);
        setBottomY((y+61) * gamePanel.scale);
        setWidth(81 * gamePanel.scale);
        setHeight(61 * gamePanel.scale);
    }

}
