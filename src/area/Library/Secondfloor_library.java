package area.Library;

import animation.Animation_player;
import entity.Player;
import main.GamePanel;
import map.Map;
import sound.SoundManager;
import tile.ExtraTile;
import tile.Tile;

import java.awt.*;

public class Secondfloor_library extends Map {
    Tile background;
    Tile wall01,wall02,wall03,wall04,wall05,tileStair01,tileStair02,tileStair03,tileStair04,tileTable01,tileTable02,tileTable03,tileTable04,tileTable05,tileTable06;
    GamePanel gamePanel;
    Animation_player map_exchange_effect1, map_exchange_effect2;
    public Secondfloor_library(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        width = (int) (62.5 * 16 * GamePanel.scale);
        height = (int) (37.5 * 16 * GamePanel.scale);
        tileContainer = new Tile[50];
        extraTile = new ExtraTile[20];
        background = new Tile();
        background.image = gamePanel.tileManager.tile[1].image;
        setDefaultValues();
    }

    public void setDefaultValues() {
//        playerX = (int) (500 * GamePanel.scale);
//        playerY = (int) (500 * GamePanel.scale);
        background.setWidth((int) (1000 * GamePanel.scale));
        background.setHeight((int) (600 * GamePanel.scale));
        wall01 = new Tile(gamePanel, 0, 0, 901, 107, "", "Obstacle", "", "res/tile/no_thing.png", 1);
        wall02 = new Tile(gamePanel, 0, 174, 99, 306, "", "Obstacle", "", "res/tile/no_thing.png", 1);
        wall03 = new Tile(gamePanel, 0, 539, 1000, 59, "", "Obstacle", "", "res/tile/no_thing.png", 1);
        wall04 = new Tile(gamePanel, 885, 176, 117, 304, "", "Obstacle", "", "res/tile/no_thing.png", 1);
        wall05 = new Tile(gamePanel, 942, 17, 20, 64, "", "Obstacle", "", "res/tile/no_thing.png", 1);
        tileStair01 = new Tile(gamePanel, 902, 17, 40, 64, "Cau thang 2 -> 3", "Teleport", "Cau thang len tang 3", "res/tile/no_thing.png", 1);
        tileStair02 = new Tile(gamePanel, 962, 17, 37, 64, "Cau thang 2 -> 1", "Teleport", "Cau thang xuong tang 1", "res/tile/no_thing.png", 1);
        tileStair03 = new Tile(gamePanel, 354, 210, 3, 51, "Cau thang 2 -> 1", "Teleport", "Cau thang to 1 xuong", "res/tile/no_thing.png", 1);
        tileStair04 = new Tile(gamePanel, 629, 210, 3, 51, "Cau thang 2 -> 1", "Teleport", "Cau thang to 2 xuong", "res/tile/no_thing.png", 1);
        tileTable01 = new Tile(gamePanel, 236, 465, 198, 120, "", "Obstacle", "", "res/tile/ban ghe thu vien 1.png", (double) 1 /3);
        tileTable02 = new Tile(gamePanel, 685, 465, 198, 120, "", "Obstacle", "", "res/tile/ban ghe thu vien 1.png", (double) 1 /3);
        tileTable03 = new Tile(gamePanel, 146, 222, 120, 198, "", "Obstacle", "", "res/tile/ban ghe thu vien 2.png", (double) 1 /3);
        tileTable04 = new Tile(gamePanel, 146, 375, 120, 198, "", "Obstacle", "", "res/tile/ban ghe thu vien 2.png", (double) 1 /3);
        tileTable05 = new Tile(gamePanel, 801, 222, 120, 198, "", "Obstacle", "", "res/tile/ban ghe thu vien 3.png", (double) 1 /3);
        tileTable06 = new Tile(gamePanel, 801, 375, 120, 198, "", "Obstacle", "", "res/tile/ban ghe thu vien 3.png", (double) 1 /3);

        setUpTileSecondfloor_library();
        map_exchange_effect1 = new Animation_player(gamePanel, "res/effect/Map_exchange/type1/frame ", 4, 0.8, new Rectangle((int)(GamePanel.screenWidth / 4), (int)(GamePanel.screenHeight / 2 - GamePanel.screenWidth / 4), (int)(GamePanel.screenWidth / 2), (int)(GamePanel.screenWidth / 2)));
        map_exchange_effect2 = new Animation_player(gamePanel, "res/effect/Map_exchange/type2/frame ", 4, 0.8, new Rectangle((int)(GamePanel.screenWidth / 4), (int)(GamePanel.screenHeight / 2 - GamePanel.screenWidth / 4), (int)(GamePanel.screenWidth / 2), (int)(GamePanel.screenWidth / 2)));

    }

    public void setUpTileSecondfloor_library() {
        numTileContainer = 0;
        mapIndex = 6;
        addTile(wall01);
        addTile(wall02);
        addTile(wall03);
        addTile(wall04);
        addTile(wall05);
        addTile(tileStair01);
        addTile(tileStair02);
        addTile(tileStair03);
        addTile(tileStair04);
        addTile(tileTable01);
        addTile(tileTable02);
        addTile(tileTable03);
        addTile(tileTable04);
        addTile(tileTable05);
        addTile(tileTable06);
        addExtraTile("src/txt/tvtang2.txt");

    }

    public void open(String type) {
        if(type.equals("Cau thang to 1 len")) {
            playerX = (int) (362 * GamePanel.scale);
            playerY = (int) (218 * GamePanel.scale);
            map_exchange_effect = map_exchange_effect1;
            SoundManager.playSound("foot_step");
        }
        if(type.equals("Cau thang to 2 len")) {
            playerX = (int) (603 * GamePanel.scale);
            playerY = (int) (218 * GamePanel.scale);
            map_exchange_effect = map_exchange_effect1;
            SoundManager.playSound("foot_step");
        }
        if(type.equals("Cau thang len tang 2")) {
            playerX = (int) (965 * GamePanel.scale);
            playerY = (int) (72 * GamePanel.scale);
            map_exchange_effect = map_exchange_effect2;
            SoundManager.playSound("footstep_up_stairs");
        }
        if(type.equals("Cau thang xuong tang 2")) {
            playerX = (int) (918 * GamePanel.scale);
            playerY = (int) (72 * GamePanel.scale);
            map_exchange_effect = map_exchange_effect2;
            SoundManager.playSound("footstep_down_stairs");
        }
        loadMap(gamePanel);
    }

    public void resetTile(){
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
        map_exchange_effect1.resize(GamePanel.screenWidth / (2 * map_exchange_effect1.getWidth()));
        map_exchange_effect2.resize(GamePanel.screenWidth / (2 * map_exchange_effect2.getWidth()));
    }

        // Phương thức vẽ map
    public void draw(Graphics2D g2) {
        gamePanel.tileManager.draw(g2, background);
        for (int i = 0; i < numTileContainer; ++i)
            gamePanel.tileManager.draw(g2, tileContainer[i]);
    }
}
