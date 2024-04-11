package tile.tileMyRoom;

import main.GamePanel;
import tile.Tile;

public class TileBed extends Tile {
    public int x,y;
    GamePanel gamePanel;

    public TileBed(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;
        this.gamePanel=gamePanel;
        Name = "My Bed";
        Type = "Interact";
        image = gamePanel.tileManager.tile[27].image;
        BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x + 106) * gamePanel.scale);
        setBottomY((y + 74) * gamePanel.scale);
        setWidth(106 * gamePanel.scale);
        setHeight(77 * gamePanel.scale);
    }
}
