package area;

import main.GamePanel;
import map.Map;
import tile.Tile;
import tile.tileStadium.*;

import java.awt.*;

public class Stadium extends Map {
    GamePanel gamePanel;
    TileWall01 tileWall01;
    TileWall02 tileWall02;
    TileCar01 tileCar01;
    TileCar02 tileCar02;
    TileBall tileBall;
    Tile background;
    int x_car_white = 39;
    int x_car_red = 218;
    public Stadium(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        tileContainer = new Tile[50];
        background = new Tile();
        background.image = gamePanel.tileManager.tile[18].image;
        background.setWidth(320 * gamePanel.scale);
        background.setHeight(240 * gamePanel.scale);
        tileWall01 = new TileWall01(gamePanel,0,70);
        tileWall02 = new TileWall02(gamePanel,241,69);
        tileCar01 = new TileCar01(gamePanel,39,158);
        tileCar02 = new TileCar02(gamePanel,218,200);
        tileBall = new TileBall(gamePanel,152,42);
        setUpTileStadium();

    }

    public void setUpTileStadium() {
        numTileContainer = 0;
        mapIndex = 4;
        addTile(tileCar01);
        addTile(tileCar02);
        addTile(tileBall);
        addTile(tileWall01);
        addTile(tileWall02);
    }

    // Phương thức vẽ map
    public void draw(Graphics2D g2) {
        x_car_white++;
        tileCar01.setLeftX(x_car_white * gamePanel.scale);
        tileCar01.setRightX((x_car_white + 65) * gamePanel.scale) ;
        if(x_car_white > 350) {
            x_car_white = -70;
        }
        x_car_red++;
        tileCar02.setLeftX(x_car_red * gamePanel.scale) ;
        tileCar02.setRightX((x_car_red + 77) * gamePanel.scale) ;
        if(x_car_red > 350) {
            x_car_red = -70;
        }
        gamePanel.tileManager.draw(g2, background);
        for (int i = 0; i < numTileContainer; ++i)
            gamePanel.tileManager.draw(g2, tileContainer[i]);

    }
}