package area;

import main.GamePanel;
import map.Map;
import tile.ExtraTile;
import tile.Tile;
import tile.TileSection;

import java.awt.*;

import animation.Animation_player;

public class MyRoom extends Map {
    Tile background;
    GamePanel gamePanel;
    public TileSection tileBed, tilePC, tileTable, tileBookshelf, tileWardrobe, tileKitchen, tilePan, tileWallMyRoom,
            tileFridge, tileDoorMyRoom, tileNoodle, tileStudentCard, tileLaptop, tilePhone, tilehoso;
    public TileSection[] tileChair;

    public MyRoom(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        // maxMapCol = 29;
        // maxMapRow = 18;
        width = (int) (29 * 16 * gamePanel.scale);
        height = (int) (18 * 16 * gamePanel.scale);
        tileContainer = new Tile[50];
        extraTile = new ExtraTile[10];
        background = new Tile();
        background.image = gamePanel.tileManager.tile[20].image;
        // addExtraTile("src/txt/test.txt");
        setDefaultValues();
    }

    public void setTileChair() {
        int x = 300;
        int y = 148;
        int dem = 0;
        for (int i = 0; i < 4; i++) {
            dem++;
            if (dem <= 2) {
                tileChair[i] = new TileSection(gamePanel, x, y, 13, 13, "My Chair", "Obstacle", "",
                        "res/tile/chair_my_room.png", 1);

                y += 45;
            }
            if (dem == 2) {
                x = 350;
                y = 148;
            }
            if (dem > 2) {
                tileChair[i] = new TileSection(gamePanel, x, y, 13, 13, "My Chair", "Obstacle", "",
                        "res/tile/chair_my_room.png", 1);
                y += 45;
            }
        }
    }

    public void setUpTileMyRoom() {
        numTileContainer = 0;
        mapIndex = 5;
        addTile(tileDoorMyRoom);
        addTile(tileWallMyRoom);
        addTile(tileBed);
        addTile(tilePC);
        addTile(tileTable);
        for (int i = 0; i < 4; i++) {
            addTile(tileChair[i]);
        }
        addTile(tileFridge);
        addTile(tileBookshelf);
        addTile((tileWardrobe));
        addTile(tileKitchen);
        addTile(tilePan);
        addTile(tileNoodle);
        addTile(tileLaptop);
        addTile(tileStudentCard);
        addTile(tilePhone);
        addTile(tilehoso);

    }

    public void setDefaultValues() {
        playerX = (int) (215 * GamePanel.scale);
        playerY = (int) (75 * GamePanel.scale);
        background.setWidth((int) (450 * GamePanel.scale));
        background.setHeight((int) (242 * GamePanel.scale));
        tileBed = new TileSection(gamePanel, 26, 176, 87, 54, "My Bed", "Interact", "", "res/tile/my_bed.png", 1);
        tilePC = new TileSection(gamePanel, 164, 159, 102, 61, "My PC", "Interact", "", "res/tile/dan_pc.png",
                "res/tile/dan_pc.png", 1);
        tileTable = new TileSection(gamePanel, 315, 145, 34, 62, "My Table", "Interact", "",
                "res/tile/table_my_room.png", 1);
        tileFridge = new TileSection(gamePanel, 378, 23, 55, 74, "My Fridge", "Interact", "", "res/tile/tu_lanh.png",
                1);
        tileBookshelf = new TileSection(gamePanel, 100, 48, 84, 49, "My Bookshelf", "Interact", "",
                "res/tile/tu_do_my_room.png", 1);
        tileWardrobe = new TileSection(gamePanel, 0, 30, 55, 70, "My Wardrobe", "Interact", "",
                "res/tile/tu_quan_ao.png", 1);
        tileKitchen = new TileSection(gamePanel, 416, 108, 34, 135, "My Kitchen", "Interact", "",
                "res/tile/cho_nau_an.png", 1);
        tileDoorMyRoom = new TileSection(gamePanel, 205, 30, 49, 61, "Door My Room", "Teleport", "",
                "res/tile/door_my_room.png", 1);
        tilePan = new TileSection(gamePanel, 413, 155, 30, 20, "Pan", "Interact", "", "res/tile/chao.png", 1);
        tileWallMyRoom = new TileSection(gamePanel, 0, 0, 460, 91, "", "Obstacle", "", "res/tile/no_thing.png", 1);
        tileNoodle = new TileSection(gamePanel, 60, 85, 36, 36, "Noodle", "Collected", "Mì tôm Omachi",
                "res/tile/mi_tom01.png", "res/tile/mi_tom02.png", (double) 1 / 3);
        tileStudentCard = new TileSection(gamePanel, 50, 120, 39, 27, "Student ID", "Collected", "DCM 37 38 RACH",
                "res/tile/thehs01.png", "res/tile/thehs02.png", (double) 1 / 3);
        tileChair = new TileSection[4];
        tilehoso = new TileSection(gamePanel, 340, 160, 39, 60, "Hồ sơ", "Collected", "Hồ sơ dùng để nhập học",
                "res/tile/hoso01.png", "res/tile/hoso02.png", (double) 1 / 3);
        tileLaptop = new TileSection(gamePanel, 78, 100, 66, 45, "Acer Predator 21X", "Collected", "230.000.000 VNĐ",
                "res/tile/lap_top01.png", "res/tile/lap_top02.png", (double) 1 / 3);
        tilePhone = new TileSection(gamePanel, 162, 187, 24, 39, "Iphone 100 ProMax", "Collected",
                "Vũ khí đánh bại Ma Vương", "res/tile/phone01.png", "res/tile/phone02.png", (double) 1 / 3);

        setTileChair();
        setUpTileMyRoom();
    }

    // Phương thức vẽ map
    public void draw(Graphics2D g2) {
        gamePanel.tileManager.draw(g2, background);
        for (int i = 0; i < numTileContainer; ++i)
            gamePanel.tileManager.draw(g2, tileContainer[i]);
        /*
         * for (int i = 0; i < numExtraTile; ++i){
         * for (int j = 0; j < extraTile[i].numPoint; ++j){
         * int screenX = extraTile[i].x[j] - gamePanel.player.getMapX() +
         * gamePanel.player.getBoundingBoxX();
         * int screenY = extraTile[i].y[j] - gamePanel.player.getMapY() +
         * gamePanel.player.getBoundingBoxY();
         * int screenX2 = extraTile[i].x[j + 1] - gamePanel.player.getMapX() +
         * gamePanel.player.getBoundingBoxX();
         * int screenY2 = extraTile[i].y[j + 1] - gamePanel.player.getMapY() +
         * gamePanel.player.getBoundingBoxY();
         * g2.drawLine(screenX, screenY, screenX2, screenY2);
         * }
         * }
         */
    }
}
