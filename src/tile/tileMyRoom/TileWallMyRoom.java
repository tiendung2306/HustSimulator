package tile.tileMyRoom;

import main.GamePanel;
import tile.Tile;

public class TileWallMyRoom extends Tile {
    public int x,y;
    GamePanel gamePanel;

    public TileWallMyRoom(GamePanel gamePanel, int x, int y) {
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
        setRightX((x+460) * gamePanel.scale);
        setBottomY((y+89) * gamePanel.scale);
        setWidth(600 * gamePanel.scale);
        setHeight(0 * gamePanel.scale);
    }
}
