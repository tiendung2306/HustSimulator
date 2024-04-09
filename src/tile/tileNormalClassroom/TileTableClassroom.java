package tile.tileNormalClassroom;

import main.GamePanel;
import tile.Tile;

public class TileTableClassroom extends Tile {
    public int x,y;
    GamePanel gamePanel;
    public TileTableClassroom(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;
        this.gamePanel=gamePanel;
        Name = "Table Classroom";
        Type = "Obstacle";
        image = gamePanel.tileManager.tile[1].image;
        BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x+20) * gamePanel.scale);
        setBottomY((y+46) * gamePanel.scale);
        setWidth(20 * gamePanel.scale);
        setHeight(46 * gamePanel.scale);
    }

}
