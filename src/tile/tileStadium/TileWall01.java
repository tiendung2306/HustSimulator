package tile.tileStadium;

import main.GamePanel;
import tile.Tile;

public class TileWall01 extends Tile {
    public int x,y;
    GamePanel gamePanel;

    public TileWall01(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;
        this.gamePanel=gamePanel;
        Name = "Wall 01";
        Type = "Obstacle";
        image = gamePanel.tileManager.tile[15].image;
        BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x+203) * gamePanel.scale);
        setBottomY((y+45) * gamePanel.scale);
        setWidth(203 * gamePanel.scale);
        setHeight(45 * gamePanel.scale);
    }
}
