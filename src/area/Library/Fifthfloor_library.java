package area.Library;

import animation.Animation_player;
import main.GamePanel;
import map.Map;
import sound.SoundManager;
import tile.ExtraTile;
import tile.Tile;

import java.awt.*;

public class Fifthfloor_library extends Map {
    Tile background;
    Tile wall01, wall02, wall03, wall04, wall05, tileStair01, tileTable01, tileTable02, tileTable03,
            tileTable04, tileTable05, tileTable06;
    public Tile tileStair02;
    GamePanel gamePanel;
    Animation_player map_exchange_effect2;

    public Fifthfloor_library(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        width = (int) (62.5 * 16 * GamePanel.scale);
        height = (int) (37.5 * 16 * GamePanel.scale);
        tileContainer = new Tile[50];
        extraTile = new ExtraTile[20];
        background = new Tile();
        background.image = gamePanel.tileManager.tile[5].image;
        setDefaultValues();
    }

    public void setDefaultValues() {
        background.setWidth((int) (1000 * GamePanel.scale));
        background.setHeight((int) (600 * GamePanel.scale));
        wall01 = new Tile(gamePanel, 0, 0, 901, 106, "", "Obstacle", "", "res/tile/no_thing.png", 1);
        wall02 = new Tile(gamePanel, 0, 174, 99, 306, "", "Obstacle", "", "res/tile/no_thing.png", 1);
        wall03 = new Tile(gamePanel, 0, 539, 1000, 59, "", "Obstacle", "", "res/tile/no_thing.png", 1);
        wall04 = new Tile(gamePanel, 885, 176, 117, 304, "", "Obstacle", "", "res/tile/no_thing.png", 1);
        wall05 = new Tile(gamePanel, 942, 17, 20, 64, "", "Obstacle", "", "res/tile/no_thing.png", 1);
        tileStair01 = new Tile(gamePanel, 902, 17, 40, 64, "", "Obstacle", "", "res/tile/no_thing.png", 1);
        tileStair02 = new Tile(gamePanel, 962, 17, 37, 64, "Cau thang 5 -> 4", "Teleport", "Cau thang xuong tang 4",
                "res/tile/no_thing.png", 1);
        tileTable01 = new Tile(gamePanel, 236, 465, 198, 120, "", "Obstacle", "", "res/tile/ban ghe thu vien 1.png",
                (double) 1 / 3);
        tileTable02 = new Tile(gamePanel, 685, 465, 198, 120, "", "Obstacle", "", "res/tile/ban ghe thu vien 1.png",
                (double) 1 / 3);
        tileTable03 = new Tile(gamePanel, 146, 222, 120, 198, "", "Obstacle", "", "res/tile/ban ghe thu vien 2.png",
                (double) 1 / 3);
        tileTable04 = new Tile(gamePanel, 146, 375, 120, 198, "", "Obstacle", "", "res/tile/ban ghe thu vien 2.png",
                (double) 1 / 3);
        tileTable05 = new Tile(gamePanel, 792, 222, 120, 198, "", "Obstacle", "", "res/tile/ban ghe thu vien 3.png",
                (double) 1 / 3);
        tileTable06 = new Tile(gamePanel, 792, 375, 120, 198, "", "Obstacle", "", "res/tile/ban ghe thu vien 3.png",
                (double) 1 / 3);
        setUpTileFifthfloor_library();
        map_exchange_effect2 = new Animation_player(gamePanel, "res/effect/Map_exchange/type2/frame ", 4, 0.8,
                new Rectangle((int) (GamePanel.screenWidth / 4),
                        (int) (GamePanel.screenHeight / 2 - GamePanel.screenWidth / 4),
                        (int) (GamePanel.screenWidth / 2), (int) (GamePanel.screenWidth / 2)));

    }

    public void setUpTileFifthfloor_library() {
        numTileContainer = 0;
        mapIndex = 7;
        addTile(wall01);
        addTile(wall02);
        addTile(wall03);
        addTile(wall04);
        addTile(wall05);
        addTile(tileStair01);
        addTile(tileStair02);
        addTile(tileTable01);
        addTile(tileTable02);
        addTile(tileTable03);
        addTile(tileTable04);
        addTile(tileTable05);
        addTile(tileTable06);
        addExtraTile("src/txt/tvtang3.txt");

    }

    public void resetTile() {
        width = (int) (62.5 * 16 * GamePanel.scale);
        height = (int) (37.5 * 16 * GamePanel.scale);
        if (gamePanel.currentMap == this) {
            playerX = (int) ((gamePanel.player.getMapX() / prevScale) * GamePanel.scale);
            playerY = (int) ((gamePanel.player.getMapY() / prevScale) * GamePanel.scale);
            prevScale = (int) GamePanel.scale;
        }
        background.setWidth((int) (1000 * GamePanel.scale));
        background.setHeight((int) (600 * GamePanel.scale));
        for (int i = 0; i < numTileContainer; ++i) {
            tileContainer[i].reSizeTile();
        }
        addExtraTile("src/txt/tvtang3.txt");
        map_exchange_effect2.resize(GamePanel.screenWidth / (2 * map_exchange_effect2.getWidth()));
    }

    public void open(String type) {
        if (type.equals("Cau thang len tang 5")) {
            playerX = (int) (965 * GamePanel.scale);
            playerY = (int) (72 * GamePanel.scale);
            map_exchange_effect = map_exchange_effect2;
            SoundManager.playSound("footstep_up_stairs");
        }
        loadMap(gamePanel);
    }

    // Phương thức vẽ map
    public void draw(Graphics2D g2) {
        gamePanel.tileManager.draw(g2, background);
        for (int i = 0; i < numTileContainer; ++i)
            gamePanel.tileManager.draw(g2, tileContainer[i]);

        gamePanel.directionIndicator.drawArrow(g2);
        gamePanel.player.draw(g2);

    }
}
