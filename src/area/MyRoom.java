package area;

import main.GamePanel;
import map.Map;
import tile.Tile;
import tile.TileSection;


import java.awt.*;

public class MyRoom extends Map {
    Tile background;
    GamePanel gamePanel;
    TileSection tileBed,tilePC,tileTable,tileBookshelf,tileWardrobe, tileKitchen,tilePan,tileWallMyRoom,
            tileFridge,tileDoorMyRoom,tileKettle,tileStudentCard,tileLaptop,tilePhone;
    TileSection[] tileChair;


    public MyRoom(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        maxMapCol = 29;
        maxMapRow = 18;
        playerX = (int) (215 * gamePanel.scale);
        playerY = (int) (75 * gamePanel.scale);
        tileContainer = new Tile[50];
        background = new Tile();
        background.image = gamePanel.tileManager.tile[20].image;
        background.setWidth((int) (450 * gamePanel.scale));
        background.setHeight((int) (240 * gamePanel.scale));
        tileBed = new TileSection(gamePanel,26,176,87,54,"My Bed","Interact","","res/tile/my_bed.png");
        tilePC = new TileSection(gamePanel,164,159,102,61,"My PC","Interact","","res/tile/dan_pc.png");
        tileTable = new TileSection(gamePanel,315,145,34,62,"My Table","Interact","","res/tile/table_my_room.png");
        tileFridge = new TileSection(gamePanel,378,22,55,74,"My Fridge","Interact","","res/tile/tu_lanh.png");
        tileBookshelf = new TileSection(gamePanel,100,48,84,49,"My Bookshelf","Interact","","res/tile/tu_do_my_room.png");
        tileWardrobe = new TileSection(gamePanel,0,30,55,70,"My Wardrobe","Interact","","res/tile/tu_quan_ao.png");
        tileKitchen = new TileSection(gamePanel,416,108,34,135,"My Kitchen","Interact","","res/tile/cho_nau_an.png");
        tileDoorMyRoom = new TileSection(gamePanel,205,29,49,61,"Door My Room","Teleport","","res/tile/door_my_room.png");
        tilePan = new TileSection(gamePanel,413,155,30,20,"Pan","Interact","","res/tile/chao.png");
        tileWallMyRoom = new TileSection(gamePanel,0,0,460,91,"","Obstacle","","res/tile/no_thing.png");
        tileKettle = new TileSection(gamePanel,60,85,25,15,"Kettle","Collected","DCM 37 38 RACH","res/tile/am_dun_nuoc.png");
        tileLaptop = new TileSection(gamePanel,78,100,23,17,"Laptop gaming MSI Titan GT77 12UHS 204VN","Collected","135990000 VNĐ","res/tile/laptop_lor.png");
        tileStudentCard = new TileSection(gamePanel,50,120,13,8,"Student Card","Collected","DCM 37 38 RACH","res/tile/the_sinh_vien.png");
        tilePhone = new TileSection(gamePanel,162,187,8,15,"Iphone 1000000 ProMax","Collected","DCM 37 38 RACH","res/tile/phone_lor.png");

        tileChair =new TileSection[4];


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
                tileChair[i] = new TileSection(gamePanel,x,y,13,13,"My Chair","Obstacle","res/tile/chair_my_room.png");

                y += 45;
            }
            if(dem == 2) {
                x = 350;
                y = 148;
            }
            if(dem>2) {
                tileChair[i] = new TileSection(gamePanel,x,y,13,13,"My Chair","Obstacle","res/tile/chair_my_room.png");
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
        addTile(tilePan);
        addTile(tileKettle);
        addTile(tileLaptop);
        addTile(tileStudentCard);
        addTile(tilePhone);
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
