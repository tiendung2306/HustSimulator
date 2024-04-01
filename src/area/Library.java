package area;

import main.GamePanel;
import map.Map;
import tile.Tile;
import tile.TileManager;
import tile.tileLibrary.*;
import tile.tileNormalClassroom.TileTableClassroom;

import java.awt.*;

public class Library extends Map {
    GamePanel gamePanel;
    TileManager tileManager ;
    TileBookcase01 tileBookcase01_1;
    TileBookcase01 tileBookcase01_2;
    TileBookcase02 tileBookcase02;
    TileBookcase03 tileBookcase03;
    TileChairLibrary[] tileChairLibrary;
    TileTableLibrary[] tileTableLibrary;
    TileDoorLibrary tileDoorLibrary;

    public Library(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        tileManager = new TileManager(gamePanel);
        tileContainer = new Tile[50];
        this.tileManager.getTileImage();
        tileBookcase01_1 = new TileBookcase01(gamePanel,40,34);
        tileBookcase01_2 = new TileBookcase01(gamePanel,44,53);
        tileBookcase02 = new TileBookcase02(gamePanel,0,77);
        tileBookcase03 = new TileBookcase03(gamePanel,44,170);
        tileChairLibrary = new TileChairLibrary[6];
        tileTableLibrary = new TileTableLibrary[6];
        tileDoorLibrary = new TileDoorLibrary(gamePanel,127,12);
        setUpTable();
        setUpTileLibrary();
    }

    public void setUpTileLibrary() {
        numTileContainer = 6;
        mapIndex = 3;
        tileContainer[0] = tileManager.tile[5];
        tileContainer[1] = tileManager.tile[6];
        tileContainer[2] = tileManager.tile[7];
        tileContainer[3] = tileManager.tile[8];
        tileContainer[4] = tileManager.tile[9];
        tileContainer[5] = tileManager.tile[13];
    }

    private void setUpTable() {
        int x1 = 177;
        int y1 = 82;
        int x2 = 208;
        int y2 = 97;
        int count =0;
        for(int i = 0; i < 6; i++) {
            count++;
            if(count<=3) {
                tileTableLibrary[i] = new TileTableLibrary(gamePanel,x1,y1);
                tileChairLibrary[i] = new TileChairLibrary(gamePanel,x2,y2);
                y1 += 64;
                y2 += 64;
            }
            if(count == 3) {
                x1 = 256;
                y1 = 82;
                x2 = 288;
                y2 = 97;
            }
            if(count > 3) {
                tileTableLibrary[i] = new TileTableLibrary(gamePanel,x1,y1);
                tileChairLibrary[i] = new TileChairLibrary(gamePanel,x2,y2);
                y1 += 64;
                y2 += 64;
            }
        }
    }



    // Phương thức vẽ map
    public void draw(Graphics2D g2) {
        tileManager.draw(g2, tileManager.tile[19].image,0,0,320*gamePanel.scale,240*gamePanel.scale);
        tileBookcase01_1.draw(g2);
        tileBookcase01_2.draw(g2);
        tileBookcase02.draw(g2);
        tileBookcase03.draw(g2);
        tileDoorLibrary.draw(g2);
        for(int i=0;i<6;i++) {
            tileChairLibrary[i].draw(g2);
            tileTableLibrary[i].draw(g2);
        }
    }
}
