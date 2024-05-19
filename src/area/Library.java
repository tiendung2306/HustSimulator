package area;

import main.GamePanel;
import map.Map;
import tile.Tile;
import tile.TileSection;
import java.awt.*;

public class Library extends Map {
    GamePanel gamePanel;

    public Tile tileBookcase01_1,tileBookcase01_2,tileBookcase02,tileBookcase03,tileDoorLibrary,tileWallLibrary;
    public Tile[] tileChairLibrary,tileTableLibrary;
    public Tile npcGirl;
    Tile background;

    public Library(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        width = (int)(21 * 16 * gamePanel.scale);
        height = (int)(16 * 16 * gamePanel.scale);
        tileContainer = new Tile[50];
        background = new Tile();
        background.image = gamePanel.tileManager.tile[19].image;
        setDefaultValues();
    }

    public void setDefaultValues() {
        playerX = (int) (160 * GamePanel.scale);
        playerY = (int) (34 * GamePanel.scale);
        background.setWidth((int) (320 * GamePanel.scale));
        background.setHeight((int) (240 * GamePanel.scale));
        tileBookcase01_1 = new Tile(gamePanel,40,34,78,59,"Bookcase 01","Interact","","res/tile/tu_sach01.png",1);
        tileBookcase01_2 = new Tile(gamePanel,44,53,78,59,"Bookcase 01","Interact","","res/tile/tu_sach01.png",1);
        tileBookcase02 = new Tile(gamePanel,0,77,16,140,"Bookcase 02","Interact","","res/tile/tu_sach02.png",1);
        tileBookcase03 = new Tile(gamePanel,44,170,81,61,"Bookcase 03","Interact","","res/tile/tu_sach03.png",1);
        tileDoorLibrary = new Tile(gamePanel,127,12,92,37,"Door Library","Teleport","","res/tile/cua_thu_vien.png",1);
        tileWallLibrary = new Tile(gamePanel,0,0,320,49,"","","","res/tile/no_thing.png",1);
        tileChairLibrary = new Tile[6];
        tileTableLibrary = new Tile[6];
        npcGirl = new Tile(gamePanel, 100, 100, 16, 41, "NPC Girl", "NPC", "", "res/NPC/NPCGirl/NPCGirl (2).png",1);
        setUpTable();
        setUpTileLibrary();
    }

    public void setUpTileLibrary() {
        numTileContainer = 0;
        mapIndex = 3;
        addTile(tileDoorLibrary);
        addTile(tileWallLibrary);
        addTile(tileBookcase01_1);
        addTile(tileBookcase01_2);
        addTile(tileBookcase02);
        addTile(tileBookcase03);
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
                tileChairLibrary[i] = new Tile(gamePanel,x1,y1,30,30,"Table Library","Interact","","res/tile/ban_thu_vien.png",1);
                tileTableLibrary[i] = new Tile(gamePanel,x2,y2,16,16,"Chair Library","Interact","","res/tile/ghe_thu_vien.png",1);
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
                tileChairLibrary[i] = new Tile(gamePanel,x1,y1,30,30,"Table Library","Interact","","res/tile/ban_thu_vien.png",1);
                tileTableLibrary[i] = new Tile(gamePanel,x2,y2,16,16,"Chair Library","Interact","","res/tile/ghe_thu_vien.png",1);
                y1 += 64;
                y2 += 64;
            }
        }
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

        gamePanel.tileManager.draw(g2, background);
        for (int i = 0; i < numTileContainer; ++i)
            gamePanel.tileManager.draw(g2, tileContainer[i]);
    }
}
