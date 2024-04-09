package tile.tileStadium;

import main.GamePanel;
import tile.Tile;

public class TileWall02 extends Tile {
    public int x,y;
    GamePanel gamePanel;

    public TileWall02(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;
        this.gamePanel=gamePanel;
        Name = "Wall 02";
        Type = "Obstacle";
        image = gamePanel.tileManager.tile[16].image;
        BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x+79) * gamePanel.scale);
        setBottomY((y+46) * gamePanel.scale);
        setWidth(79 * gamePanel.scale);
        setHeight(46 * gamePanel.scale);
    }
}
