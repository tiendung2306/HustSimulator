package area;

import main.GamePanel;
import map.Map;
import tile.Tile;
import tile.TileManager;
import tile.tileStadium.*;

import java.awt.*;

public class Stadium extends Map {
    GamePanel gp;
    TileManager tileManager ;
    TileWall01 tileWall01;
    TileWall02 tileWall02;
    TileCar01 tileCar01;
    TileCar02 tileCar02;
    TileBall tileBall;
    public Stadium(GamePanel gp) {
        this.gp=gp;
        tileManager = new TileManager(gp);
        numTileContainer = 12;
        mapIndex = 4;
        tileContainer = new Tile[50][50];
        this.tileManager.getTileImage();
        tileWall01 = new TileWall01(gp,0,70);
        tileWall02 = new TileWall02(gp,241,69);
        tileCar01 = new TileCar01(gp,39,158);
        tileCar02 = new TileCar02(gp,218,180);
        tileBall = new TileBall(gp,152,42);
    }

    // Phương thức vẽ map
    public void draw(Graphics2D g2) {
        g2.drawImage(tileManager.tile[18].image,0,0,320*gp.scale,240*gp.scale,null);
        tileWall01.draw(g2);
        tileWall02.draw(g2);
        tileCar01.draw(g2);
        tileCar02.draw(g2);
        tileBall.draw(g2);

    }
}