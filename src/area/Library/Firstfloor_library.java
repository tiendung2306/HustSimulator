package area.Library;

import animation.Animation_player;
import entity.Player;
import main.GamePanel;
import map.Map;
import sound.SoundManager;
import tile.ExtraTile;
import tile.Tile;

import java.awt.*;

public class Firstfloor_library extends Map {
    Tile background;
    Tile wall01,wall02,wall03,wall04,wall05,wall06,tileColumn01,tileColumn02,wall07,wall08,wall09,wall10,wall11,wall12,tileTalbe,tileStair01,tileStair02,tileStair03;
    GamePanel gamePanel;
    Animation_player map_exchange_effect1, map_exchange_effect2,map_exchange_effect3;

    public Firstfloor_library(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        width = (int) (62.5 * 16 * GamePanel.scale);
        height = (int) (37.5 * 16 * GamePanel.scale);
        tileContainer = new Tile[50];
        extraTile = new ExtraTile[20];
        background = new Tile();
        background.image = gamePanel.tileManager.tile[2].image;
        setDefaultValues();
    }

    public void setDefaultValues() {
        background.setWidth((int) (1000 * GamePanel.scale));
        background.setHeight((int) (600 * GamePanel.scale));
        wall01 = new Tile(gamePanel,0, 0, 223, 113, "", "Obstacle", "", "res/tile/no_thing.png", 1);
        wall02 = new Tile(gamePanel,0, 197, 90, 250, "", "Obstacle", "", "res/tile/no_thing.png", 1);
        wall03 = new Tile(gamePanel,0, 517, 339, 86, "", "Obstacle", "", "res/tile/no_thing.png", 1);
        wall04 = new Tile(gamePanel,652, 517, 349, 86, "", "Obstacle", "", "res/tile/no_thing.png", 1);
        wall05 = new Tile(gamePanel,906, 192, 95, 251, "", "Obstacle", "", "res/tile/no_thing.png", 1);
        wall06 = new Tile(gamePanel,957, 25, 42, 58, "", "Obstacle", "", "res/tile/no_thing.png", 1);
        wall07 = new Tile(gamePanel,783, 0, 122, 112, "", "Obstacle", "", "res/tile/no_thing.png", 1);
        wall08 = new Tile(gamePanel,362, 0, 279, 210, "", "Obstacle", "", "res/tile/no_thing.png", 1);
        wall09 = new Tile(gamePanel,475, 209, 50, 106, "", "Obstacle", "", "res/tile/no_thing.png", 1);
        wall10 = new Tile(gamePanel,340, 522, 43, 42, "", "Obstacle", "", "res/tile/no_thing.png", 1);
        wall11 = new Tile(gamePanel,435, 508, 42, 56, "", "Obstacle", "", "res/tile/no_thing.png", 1);
        wall12 = new Tile(gamePanel,574, 510, 78, 54, "", "Obstacle", "", "res/tile/no_thing.png", 1);
        tileStair01 = new Tile(gamePanel,357, 43, 5, 70, "Cau thang 1 -> 2", "Teleport", "Cau thang to 1 len", "res/tile/no_thing.png", 1);
        tileStair02 = new Tile(gamePanel,643, 43, 5, 70, "Cau thang 1 -> 2", "Teleport", "Cau thang to 2 len", "res/tile/no_thing.png", 1);
        tileStair03 = new Tile(gamePanel,905, 42, 53, 41, "Cau thang 1 -> 2", "Teleport", "Cau thang len tang 2", "res/tile/no_thing.png", 1);

        tileTalbe = new Tile(gamePanel,478, 522, 55, 42, "Bàn quét mã sinh viên", "Interact", "", "res/tile/no_thing.png", 1);
        tileColumn01 = new Tile(gamePanel,129, 44, 37, 140, "", "Obstacle", "", "res/tile/no_thing.png", 1);
        tileColumn02 = new Tile(gamePanel,838, 44, 37, 140, "", "Obstacle", "", "res/tile/no_thing.png", 1);
        setUpTileFirstfloor_library();
        map_exchange_effect3 = new Animation_player(gamePanel, "res/effect/Map_exchange/type3/frame ", 4, 0.8, new Rectangle((int)(GamePanel.screenWidth / 4), (int)(GamePanel.screenHeight / 2 - GamePanel.screenWidth / 4), (int)(GamePanel.screenWidth / 2), (int)(GamePanel.screenWidth / 2)));
        map_exchange_effect2 = new Animation_player(gamePanel, "res/effect/Map_exchange/type2/frame ", 4, 0.8, new Rectangle((int)(GamePanel.screenWidth / 4), (int)(GamePanel.screenHeight / 2 - GamePanel.screenWidth / 4), (int)(GamePanel.screenWidth / 2), (int)(GamePanel.screenWidth / 2)));
        map_exchange_effect1 = new Animation_player(gamePanel, "res/effect/Map_exchange/type1/frame ", 4, 0.8, new Rectangle((int)(GamePanel.screenWidth / 4), (int)(GamePanel.screenHeight / 2 - GamePanel.screenWidth / 4), (int)(GamePanel.screenWidth / 2), (int)(GamePanel.screenWidth / 2)));

    }

    public void setUpTileFirstfloor_library() {
        numTileContainer = 0;
        mapIndex = 6;
        addTile(wall01);
        addTile(wall02);
        addTile(wall03);
        addTile(wall04);
        addTile(wall05);
        addTile(wall06);
        addTile(wall07);
        addTile(wall08);
        addTile(wall09);
        addTile(wall10);
        addTile(wall11);
        addTile(wall12);
        addTile(tileTalbe);
        addTile(tileColumn01);
        addTile(tileColumn02);
        addTile(tileStair01);
        addTile(tileStair02);
        addTile(tileStair03);
        addExtraTile("src/txt/tvtang1.txt");
    }

    public void open(String type){
        if(type.equals("Cau thang xuong tang 1")) {
            playerX = (int) (918 * GamePanel.scale);
            playerY = (int) (72 * GamePanel.scale);
            map_exchange_effect = map_exchange_effect2;
            SoundManager.playSound("footstep_down_stairs");
        }
        if(type.equals("Cau thang to 1 xuong")) {
            playerX = (int) (330 * GamePanel.scale);
            playerY = (int) (57 * GamePanel.scale);
            map_exchange_effect = map_exchange_effect1;
            SoundManager.playSound("foot_step");
        }
        if(type.equals("Cau thang to 2 xuong")) {
            playerX = (int) (651 * GamePanel.scale);
            playerY = (int) (58 * GamePanel.scale);
            map_exchange_effect = map_exchange_effect1;
            SoundManager.playSound("foot_step");
        }
        if(type.equals("Di vao thu vien 1")) {
            playerX = (int) (450 * GamePanel.scale);
            playerY = (int) (560 * GamePanel.scale);
            map_exchange_effect = map_exchange_effect3;
            SoundManager.playSound("open_door");
        }
        if(type.equals("Di vao thu vien 2")) {
            playerX = (int) (520 * GamePanel.scale);
            playerY = (int) (560 * GamePanel.scale);
            map_exchange_effect = map_exchange_effect3;
            SoundManager.playSound("open_door");
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
        map_exchange_effect3.resize(GamePanel.screenWidth / (2 * map_exchange_effect3.getWidth()));
    }

    // Phương thức vẽ map
    public void draw(Graphics2D g2) {
        gamePanel.tileManager.draw(g2, background);
        for (int i = 0; i < numTileContainer; ++i)
            gamePanel.tileManager.draw(g2, tileContainer[i]);
    }
}
