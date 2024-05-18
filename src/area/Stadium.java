package area;

import main.GamePanel;
import map.Map;
import tile.Tile;


import java.awt.*;

public class Stadium extends Map {
    GamePanel gamePanel;
    public Tile background;
    public Tile tileWall01,tileWall02,tileCar01,tileCar02,tileBall;
    int x_car_white = 39;
    int x_car_red = 218;
    public Stadium(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        width = (int)(21 * 16 * GamePanel.scale);
        height = (int)(16 * 16 * GamePanel.scale);
        tileContainer = new Tile[50];
        background = new Tile();
        background.image = gamePanel.tileManager.tile[18].image;
        setDefaultValues();

    }

    public void setDefaultValues() {
        playerX = (int) (10 * GamePanel.scale);
        playerY = (int) (115 * GamePanel.scale);
        background.setWidth((int) (320 * GamePanel.scale));
        background.setHeight((int) (240 * GamePanel.scale));
        tileWall01 = new Tile(gamePanel,0,70,203,45,"Wall","Obstacle","","res/tile/tuong_va_cua_svd01.png",1);
        tileWall02 = new Tile(gamePanel,241,69,79,46,"Wall","Obstacle","","res/tile/tuong_va_cua_svd02.png",1);
        tileCar01 = new Tile(gamePanel,39,158,65,33,"Car 01","Obstacle","","res/tile/xe_hoi_trang.png",1);
        tileCar02 = new Tile(gamePanel,218,200,77,33,"Car 02","Obstacle","","res/tile/xe_tai_do.png",1);
        tileBall = new Tile(gamePanel,152,42,45,45,"Ball","Collected","Hmm... Just a Ballon D'or! And it's for Lionel Messi!","res/tile/qua_bong01.png","res/tile/qua_bong02.png", (double) 1 /3);
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

    public void resetTile(){
        width = (int) (21 * 16 * GamePanel.scale);
        height = (int) (16 * 16 * GamePanel.scale);
        playerX = (int) ((gamePanel.player.getMapX() / prevScale) * GamePanel.scale);
        playerY = (int) ((gamePanel.player.getMapY() / prevScale) * GamePanel.scale);
        prevScale = (int) GamePanel.scale;
        background.setWidth((int) (320 * GamePanel.scale));
        background.setHeight((int) (240 * GamePanel.scale));
        for (int i = 0; i < numTileContainer; ++i) {
            tileContainer[i].reSizeTile();
        }
    }

    // Phương thức vẽ map
    public void draw(Graphics2D g2) {
        x_car_white++;
        tileCar01.setLeftX((int) (x_car_white * GamePanel.scale));
        tileCar01.setRightX((int) ((x_car_white + 65) * GamePanel.scale)) ;
        if(x_car_white > 350) {
            x_car_white = -70;
        }
        x_car_red++;
        tileCar02.setLeftX((int) (x_car_red *  GamePanel.scale)) ;
        tileCar02.setRightX((int) ((x_car_red + 77) *  GamePanel.scale)) ;
        if(x_car_red > 350) {
            x_car_red = -70;
        }
        gamePanel.tileManager.draw(g2, background);
        for (int i = 0; i < numTileContainer; ++i)
            gamePanel.tileManager.draw(g2, tileContainer[i]);

    }
}