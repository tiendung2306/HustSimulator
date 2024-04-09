package tile.tileLibrary;

import main.GamePanel;
import tile.Tile;

public class TileTableLibrary extends Tile {
    public int x,y;
    GamePanel gamePanel;

    public TileTableLibrary(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;
        this.gamePanel=gamePanel;
        Name = "Table Library";
        Type = "Interact";
        image = gamePanel.tileManager.tile[5].image;
        this.BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x+30) * gamePanel.scale);
        setBottomY((y+30) * gamePanel.scale);
        setWidth(30 * gamePanel.scale);
        setHeight(30 * gamePanel.scale);
    }

}
