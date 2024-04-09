package tile.tileNormalClassroom;

import main.GamePanel;
import tile.Tile;

public class TileTableTeacherClassroom extends Tile {
    public int x,y;
    GamePanel gamePanel;
    public TileTableTeacherClassroom(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;
        this.gamePanel=gamePanel;
        Name = "Teacher Table Classroom";
        Type = "Obstacle";
        image = gamePanel.tileManager.tile[2].image;
        BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x+30) * gamePanel.scale);
        setBottomY((y+62) * gamePanel.scale);
        setWidth(30 * gamePanel.scale);
        setHeight(62 * gamePanel.scale);
    }

}
