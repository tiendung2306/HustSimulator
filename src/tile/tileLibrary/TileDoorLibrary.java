package tile.tileLibrary;

import main.GamePanel;
import tile.Tile;

public class TileDoorLibrary extends Tile {
    public int x,y;
    GamePanel gamePanel;

    public TileDoorLibrary(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;
        this.gamePanel=gamePanel;
        Name = "Door Library";
        Type = "Teleport";
        image = gamePanel.tileManager.tile[13].image;
        this.BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x+92) * gamePanel.scale);
        setBottomY((y+37) * gamePanel.scale);
        setWidth(92 * gamePanel.scale);
        setHeight(37 * gamePanel.scale);
    }

}
