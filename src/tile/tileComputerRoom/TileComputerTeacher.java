package tile.tileComputerRoom;

import main.GamePanel;
import tile.Tile;

public class TileComputerTeacher extends Tile {
    public int x,y;
    GamePanel gamePanel;
    public TileComputerTeacher(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;
        this.gamePanel=gamePanel;
        Name = "Teacher Computer";
        Type = "Interact";
        image = gamePanel.tileManager.tile[4].image;
        this.BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x + 28) * gamePanel.scale);
        setBottomY((y + 28) * gamePanel.scale);
        setWidth(28 * gamePanel.scale);
        setHeight(28 * gamePanel.scale);
    }

}
