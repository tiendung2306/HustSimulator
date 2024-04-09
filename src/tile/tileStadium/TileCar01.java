package tile.tileStadium;

import main.GamePanel;
import tile.Tile;

public class TileCar01 extends Tile {
    public int x,y;
    GamePanel gamePanel;

    public TileCar01(GamePanel gamePanel, int x, int y) {
        this.x = x;
        this.y = y;
        this.gamePanel=gamePanel;
        Name = "Car 01";
        Type = "Obstacle";
        image = gamePanel.tileManager.tile[10].image;
        BoundingBox();
    }

    public void BoundingBox() {
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x+65) * gamePanel.scale);
        setBottomY((y+33) * gamePanel.scale);
        setWidth(65 * gamePanel.scale);
        setHeight(33 * gamePanel.scale);
    }

}
