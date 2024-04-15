package area;

import entity.Player;
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
    TileDoorMyRoom tileDoorMyRoom;
    TileKitchenInfrared tileKitchenInfrared;
    TileWallMyRoom tileWallMyRoom;


    public MyRoom(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        maxMapCol = 29;
        maxMapRow = 18;
        playerX = 215 * gamePanel.scale;
        playerY = 75 * gamePanel.scale;
        tileContainer = new Tile[50];
        background = new Tile();
        background.image = gamePanel.tileManager.tile[20].image;
        background.setWidth(450 * gamePanel.scale);
        background.setHeight(240 * gamePanel.scale);
        tileBed = new TileBed(gamePanel,26,176);
        tilePC = new TilePC(gamePanel,164,159);
        tileTable = new TileTable(gamePanel,315,145);
        tileFridge = new TileFridge(gamePanel,378,22);
        tileChair = new TileChair[5];
        tileBookshelf = new TileBookshelf(gamePanel,100,48);
        tileWardrobe = new TileWardrobe(gamePanel,0,30);
        tileKitchen = new TileKitchen(gamePanel,416,108);
        tileDoorMyRoom = new TileDoorMyRoom(gamePanel,205,29);
        tileKitchenInfrared = new TileKitchenInfrared(gamePanel,415,157);
        tileWallMyRoom = new TileWallMyRoom(gamePanel,0,0);
        setTileChair();
        setUpTileMyRoom();
    }

    public void setTileChair() {
        int x = 300;
        int y = 148;
        int dem = 0;
        for(int i=0;i<4;i++) {
            dem ++;
            if(dem<=2) {
                tileChair[i] = new TileChair(gamePanel,x,y);
                y += 45;
            }
            if(dem == 2) {
                x = 350;
                y = 148;
            }
            if(dem>2) {
                tileChair[i] = new TileChair(gamePanel,x,y);
                y += 45;
            }
        }
    }
    public void setUpTileMyRoom() {
        numTileContainer = 0;
        mapIndex = 5;
        addTile(tileWallMyRoom);
        addTile(tileBed);
        addTile(tilePC);
        addTile(tileTable);
        addTile(tileFridge);
        addTile(tileBookshelf);
        addTile((tileWardrobe));
        addTile(tileKitchen);
        addTile(tileDoorMyRoom);
        addTile(tileKitchenInfrared);
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
