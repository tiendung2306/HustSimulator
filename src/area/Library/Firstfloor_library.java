package area.Library;

import main.GamePanel;
import map.Map;
import tile.ExtraTile;
import tile.Tile;

import java.awt.*;

public class Firstfloor_library extends Map {
    Tile background;
    Tile wall01,wall02,wall03,wall04,wall05,wall06,tileColumn01,tileColumn02,wall07,wall08,wall09,wall10,wall11,wall12,tileTalbe;
    GamePanel gamePanel;
    public Firstfloor_library(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        width = (int) (63.5 * 16 * GamePanel.scale);
        height = (int) (38.5 * 16 * GamePanel.scale);
        tileContainer = new Tile[50];
        extraTile = new ExtraTile[20];
        background = new Tile();
        background.image = gamePanel.tileManager.tile[2].image;
        setDefaultValues();
    }

    public void setDefaultValues() {
        playerX = (int) (500 * GamePanel.scale);
        playerY = (int) (555 * GamePanel.scale);
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
        tileTalbe = new Tile(gamePanel,478, 522, 55, 42, "Bàn quét mã sinh viên", "Interact", "", "res/tile/no_thing.png", 1);
        tileColumn01 = new Tile(gamePanel,129, 44, 37, 140, "", "Obstacle", "", "res/tile/no_thing.png", 1);
        tileColumn02 = new Tile(gamePanel,838, 44, 37, 140, "", "Obstacle", "", "res/tile/no_thing.png", 1);
        setUpTileFirstfloor_library();
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
        addExtraTile("src/txt/cauthang1.txt");
    }


    // Phương thức vẽ map
    public void draw(Graphics2D g2) {
        gamePanel.tileManager.draw(g2, background);
        for (int i = 0; i < numTileContainer; ++i)
            gamePanel.tileManager.draw(g2, tileContainer[i]);

        gamePanel.player.draw(g2);
        
    }
}
