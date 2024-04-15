package area;

import main.GamePanel;
import map.Map;
import tile.Tile;
import tile.tileLibrary.*;

import java.awt.*;

public class Library extends Map {
    GamePanel gamePanel;
    TileBookcase01 tileBookcase01_1;
    TileBookcase01 tileBookcase01_2;
    TileBookcase02 tileBookcase02;
    TileBookcase03 tileBookcase03;
    TileChairLibrary[] tileChairLibrary;
    TileTableLibrary[] tileTableLibrary;
    TileDoorLibrary tileDoorLibrary;
    TileWallLibrary tileWallLibrary;
    Tile background;

    public Library(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        maxMapCol = 21;
        maxMapRow = 18;
        playerX = 160 * gamePanel.scale;
        playerY = 34 * gamePanel.scale;
        tileContainer = new Tile[50];
        background = new Tile();
        background.image = gamePanel.tileManager.tile[19].image;
        background.setWidth(320 * gamePanel.scale);
        background.setHeight(240 * gamePanel.scale);
        tileBookcase01_1 = new TileBookcase01(gamePanel,40,34);
        tileBookcase01_2 = new TileBookcase01(gamePanel,44,53);
        tileBookcase02 = new TileBookcase02(gamePanel,0,77);
        tileBookcase03 = new TileBookcase03(gamePanel,44,170);
        tileChairLibrary = new TileChairLibrary[6];
        tileTableLibrary = new TileTableLibrary[6];
        tileDoorLibrary = new TileDoorLibrary(gamePanel,127,12);
        tileWallLibrary = new TileWallLibrary(gamePanel,0,0);
        setUpTable();
        setUpTileLibrary();
    }

    public void setUpTileLibrary() {
        numTileContainer = 0;
        mapIndex = 3;
        addTile(tileWallLibrary);
        addTile(tileBookcase01_1);
        addTile(tileBookcase01_2);
        addTile(tileBookcase02);
        addTile(tileBookcase03);
        addTile(tileDoorLibrary);
        for(int i = 0; i < 6; i++)
            addTile(tileChairLibrary[i]);
        for(int i = 0; i < 6; i++)
            addTile(tileTableLibrary[i]);
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

        gamePanel.tileManager.draw(g2, background);
        for (int i = 0; i < numTileContainer; ++i)
            gamePanel.tileManager.draw(g2, tileContainer[i]);
    }
}
