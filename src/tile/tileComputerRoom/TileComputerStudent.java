package tile.tileComputerRoom;

import main.GamePanel;
import tile.Tile;

public class TileComputerStudent extends Tile {
    public int x,y;
    GamePanel gamePanel;

    public TileComputerStudent(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;
        this.gamePanel=gamePanel;
        Name = "Student Computer";
        Type = "Interact";
        image = gamePanel.tileManager.tile[3].image;
        BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x + 16) * gamePanel.scale);
        setBottomY((y + 16) * gamePanel.scale);
        setWidth(16 * gamePanel.scale);
        setHeight(16 * gamePanel.scale);
    }
}
