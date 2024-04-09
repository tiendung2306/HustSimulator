package tile.tileStadium;

import main.GamePanel;
import tile.Tile;

public class TileBall extends Tile {
    public int x,y;
    GamePanel gamePanel;

    public TileBall(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;
        this.gamePanel=gamePanel;
        Name = "Ball";
        Type = "Collected";
        image = gamePanel.tileManager.tile[12].image;
        BoundingBox();
    }
    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x + 14) * gamePanel.scale);
        setBottomY((y + 14) * gamePanel.scale);
        setWidth(14 * gamePanel.scale);
        setHeight(14 * gamePanel.scale);
    }

}
