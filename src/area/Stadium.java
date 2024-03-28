package area;

import main.GamePanel;
import map.Map;
import tile.Tile;
import tile.TileManager;
import tile.tileStadium.*;

import java.awt.*;

public class Stadium extends Map {
    GamePanel gamePanel;
    TileManager tileManager ;
    TileWall01 tileWall01;
    TileWall02 tileWall02;
    TileCar01 tileCar01;
    TileCar02 tileCar02;
    TileBall tileBall;
    int x_car_while = 39;
    int x_car_red = 218;
    public Stadium(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        tileManager = new TileManager(gamePanel);
        numTileContainer = 12;
        mapIndex = 4;
        tileContainer = new Tile[50][50];
        this.tileManager.getTileImage();
        tileWall01 = new TileWall01(gamePanel,0,70);
        tileWall02 = new TileWall02(gamePanel,241,69);
        tileCar01 = new TileCar01(gamePanel,39,158);
        tileCar02 = new TileCar02(gamePanel,218,200);
        tileBall = new TileBall(gamePanel,152,42);
    }

    // Phương thức vẽ map
    public void draw(Graphics2D g2) {
        x_car_while++;
        tileCar01.setLeftX(x_car_while) ;
        if(x_car_while > 350) {
            x_car_while = -70;
        }
        x_car_red++;
        tileCar02.setLeftX(x_car_red) ;
        if(x_car_red > 350) {
            x_car_red = -70;
        }
        System.out.println(tileCar01.getLeftX());
        g2.drawImage(tileManager.tile[18].image,0,0,320*gamePanel.scale,240*gamePanel.scale,null);
        tileWall01.draw(g2);
        tileWall02.draw(g2);
        tileCar01.draw(g2);
        tileCar02.draw(g2);
        tileBall.draw(g2);

    }
}