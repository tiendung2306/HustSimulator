package area;

import main.GamePanel;
import map.Map;
import tile.ExtraTile;
import tile.Tile;

import java.awt.*;

public class MyRoom extends Map {
    Tile background;
    GamePanel gamePanel;
    public Tile tileBed, tilePC, tileTable, tileBookshelf, tileWardrobe, tileKitchen, tilePan, tileWallMyRoom,
            tileFridge, tileDoorMyRoom, tileNoodle, tileStudentCard, tileLaptop, tilePhone, tilehoso;
    public Tile[] tileChair;

    public MyRoom(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        width = (int) (29 * 16 * GamePanel.scale);
        height = (int) (16 * 16 * GamePanel.scale);
        tileContainer = new Tile[50];
        extraTile = new ExtraTile[10];
        background = new Tile();
        background.image = gamePanel.tileManager.tile[20].image;
        // addExtraTile("src/txt/cauthang1.txt");
        setDefaultValues();
    }

    public void setTileChair() {
        int x = 300;
        int y = 148;
        int dem = 0;
        for (int i = 0; i < 4; i++) {
            dem++;
            if (dem <= 2) {
                tileChair[i] = new Tile(gamePanel, x, y, 13, 13, "My Chair", "Obstacle", "",
                        "res/tile/chair_my_room.png", 1);

                y += 45;
            }
            if (dem == 2) {
                x = 350;
                y = 148;
            }
            if (dem > 2) {
                tileChair[i] = new Tile(gamePanel, x, y, 13, 13, "My Chair", "Obstacle", "",
                        "res/tile/chair_my_room.png", 1);
                y += 45;
            }
        }
    }

    public void setDefaultValues() {
        playerX = (int) (215 * GamePanel.scale);
        playerY = (int) (75 * GamePanel.scale);
        background.setWidth((int) (450 * GamePanel.scale));
        background.setHeight((int) (242 * GamePanel.scale));
        tileBed = new Tile(gamePanel, 26, 176, 87, 54, "My Bed", "Interact", "", "res/tile/my_bed.png", 1);
        tilePC = new Tile(gamePanel, 164, 159, 102, 61, "My PC", "Interact", "", "res/tile/dan_pc.png", 1);
        tileTable = new Tile(gamePanel, 315, 145, 34, 62, "My Table", "Interact", "",
                "res/tile/table_my_room.png", 1);
        tileFridge = new Tile(gamePanel, 378, 23, 55, 74, "My Fridge", "Interact", "", "res/tile/tu_lanh.png",
                1);
        tileBookshelf = new Tile(gamePanel, 100, 48, 84, 49, "My Bookshelf", "Interact", "",
                "res/tile/tu_do_my_room.png", 1);
        tileWardrobe = new Tile(gamePanel, 0, 30, 55, 70, "My Wardrobe", "Interact", "",
                "res/tile/tu_quan_ao.png", 1);
        tileKitchen = new Tile(gamePanel, 416, 108, 34, 135, "My Kitchen", "Interact", "",
                "res/tile/cho_nau_an.png", 1);
        tileDoorMyRoom = new Tile(gamePanel, 205, 29, 49, 62, "Door My Room", "Teleport", "",
                "res/tile/door_my_room.png", 1);
        tilePan = new Tile(gamePanel, 413, 155, 30, 20, "Pan", "Interact", "", "res/tile/chao.png", 1);
        tileWallMyRoom = new Tile(gamePanel, 0, 0, 460, 91, "", "Obstacle", "", "res/tile/no_thing.png", 1);
        tileNoodle = new Tile(gamePanel, 414, 130, 36, 36, "Noodle", "Collected", "Mì tôm Omachi",
                "res/tile/mi_tom01.png", "res/tile/mi_tom02.png", (double) 1 / 3);
        tileStudentCard = new Tile(gamePanel, 315, 158, 39, 27, "Student ID", "Collected",
                "Đại học Bách Khoa Hà Nội, S+ hữu hạn Giải Tích, 5.0 GPA.",
                "res/tile/thehs01.png", "res/tile/thehs02.png", (double) 1 / 3);
        tileChair = new Tile[4];
        tilehoso = new Tile(gamePanel, 338, 160, 39, 60, "Hồ sơ", "Collected", "Hồ sơ dùng để nhập học",
                "res/tile/hoso01.png", "res/tile/hoso02.png", (double) 1 / 3);
        tileLaptop = new Tile(gamePanel, 92, 190, 66, 45, "Acer Predator 21X", "Collected", "230.000.000 VNĐ",
                "res/tile/lap_top01.png", "res/tile/lap_top02.png", (double) 1 / 3);
        tilePhone = new Tile(gamePanel, 162, 187, 24, 39, "Iphone 100 ProMax", "Collected",
                "Vũ khí đánh bại Ma Vương", "res/tile/phone01.png", "res/tile/phone02.png", (double) 1 / 3);

        setTileChair();
        setUpTileMyRoom();
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

    public void resetTile() {
        width = (int) (29 * 16 * GamePanel.scale);
        height = (int) (16 * 16 * GamePanel.scale);
        if (gamePanel.currentMap == this) {
            playerX = (int) ((gamePanel.player.getMapX() / prevScale) * GamePanel.scale);
            playerY = (int) ((gamePanel.player.getMapY() / prevScale) * GamePanel.scale);
        } else {
            playerX = (int) (215 * GamePanel.scale);
            playerY = (int) (75 * GamePanel.scale);
        }
        prevScale = (int) GamePanel.scale;
        background.setWidth((int) (450 * GamePanel.scale));
        background.setHeight((int) (242 * GamePanel.scale));
        for (int i = 0; i < numTileContainer; ++i) {
            tileContainer[i].reSizeTile();
        }
    }

    // Phương thức vẽ map
    public void draw(Graphics2D g2) {
        gamePanel.tileManager.draw(g2, background);
        for (int i = 0; i < numTileContainer; ++i)
            gamePanel.tileManager.draw(g2, tileContainer[i]);

        gamePanel.player.draw(g2);

    }
}
