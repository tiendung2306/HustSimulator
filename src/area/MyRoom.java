package area;

import main.GamePanel;
import map.Map;
import tile.Tile;
import tile.tileMyRoom.*;

import java.awt.*;

public class MyRoom extends Map {
    Tile background;
    GamePanel gamePanel;
    TileBed tileBed;
    TilePC tilePC;
    TileTable tileTable;
    TileFridge tileFridge;
    TileChair[] tileChair;
    TileBookshelf tileBookshelf;
    TileWardrobe tileWardrobe;
    TileKitchen tileKitchen;

    public MyRoom(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        tileContainer = new Tile[50];
        background = new Tile();
        background.image = gamePanel.tileManager.tile[20].image;
        background.setWidth(562 * gamePanel.scale);
        background.setHeight(317 * gamePanel.scale);
        tileBed = new TileBed(gamePanel,22,215);
        tilePC = new TilePC(gamePanel,195,202);
        tileTable = new TileTable(gamePanel,388,175);
        tileFridge = new TileFridge(gamePanel,470,30);
        tileChair = new TileChair[5];
        tileBookshelf = new TileBookshelf(gamePanel,126,65);
        tileWardrobe = new TileWardrobe(gamePanel,0,51);
        tileKitchen = new TileKitchen(gamePanel,520,139);

        setTileChair();
        setUpTileMyRoom();
    }

    public void setTileChair() {
        int x = 365;
        int y = 180;
        int dem = 0;
        for(int i=0;i<4;i++) {
            dem ++;
            if(dem<=2) {
                tileChair[i] = new TileChair(gamePanel,x,y);
                y += 55;
            }
            if(dem == 2) {
                x = 435;
                y = 180;
            }
            if(dem>2) {
                tileChair[i] = new TileChair(gamePanel,x,y);
                y += 55;
            }
        }
    }
    public void setUpTileMyRoom() {
        numTileContainer = 0;
        mapIndex = 5;
        addTile(tileBed);
        addTile(tilePC);
        addTile(tileTable);
        addTile(tileFridge);
        addTile(tileBookshelf);
        addTile((tileWardrobe));
        addTile(tileKitchen);
        for(int i = 0; i < 4; i++) {
            addTile(tileChair[i]);
        }
    }

    // Phương thức vẽ map
    public void draw(Graphics2D g2) {

        gamePanel.tileManager.draw(g2, background);
        for (int i = 0; i < numTileContainer; ++i)
            gamePanel.tileManager.draw(g2, tileContainer[i]);
    }
}
