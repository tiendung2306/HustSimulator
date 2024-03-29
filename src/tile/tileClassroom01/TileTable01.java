package tile.tileClassroom01;

import main.GamePanel;
import tile.Tile;
import tile.TileManager;

import java.awt.*;

public class TileTable01 extends Tile {
    public int x,y;
    GamePanel gamePanel;
    TileManager tileManager;
    public TileTable01(GamePanel gamePanel,int x,int y) {
        this.x = x;
        this.y = y;

        this.gamePanel=gamePanel;
        tileManager = new TileManager(gamePanel);
        BoundingBox();
    }

    public void BoundingBox() {
        tileManager.tile[4].setLeftX(x);
        tileManager.tile[4].setTopY(y);
        tileManager.tile[4].setRightX(x+16);
        tileManager.tile[4].setBottomY(y+32);
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(tileManager.tile[4].image,  tileManager.tile[4].getLeftX() * gamePanel.scale,  tileManager.tile[4].getTopY() * gamePanel.scale, 16 * gamePanel.scale, 32 * gamePanel.scale, null);
    }
}
