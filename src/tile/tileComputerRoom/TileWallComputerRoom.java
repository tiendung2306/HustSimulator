package tile.tileComputerRoom;

import main.GamePanel;
import tile.Tile;

public class TileWallComputerRoom extends Tile {
    public int x,y;
    GamePanel gamePanel;

    public TileWallComputerRoom(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;
        this.gamePanel=gamePanel;
        Name = "Wall";
        Type = "Obstacle";
        image = gamePanel.tileManager.tile[0].image;
        BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x+320) * gamePanel.scale);
        setBottomY((y+75) * gamePanel.scale);
        setWidth(320 * gamePanel.scale);
        setHeight(0 * gamePanel.scale);
    }
}
