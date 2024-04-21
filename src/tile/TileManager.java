package tile;

import main.GamePanel;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.*;

public class TileManager {

    GamePanel gamePanel;
    public Tile[] tile;
    public int[][] typeTile;

    public TileManager(GamePanel gamePanel) {

        this.gamePanel = gamePanel;

        tile = new Tile[60];
        typeTile = new int[gamePanel.maxMapCol][gamePanel.maxMapRow];
        getTileImage();
    }

    public void getTileImage() {
        try {

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(new FileInputStream("res/tile/KHU_VUC_3.png"));

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(new FileInputStream("res/tile/backgroud_classroom.png"));

            tile[18] = new Tile();
            tile[18].image = ImageIO.read(new FileInputStream("res/tile/backgroud_svd.png"));

            tile[19] = new Tile();
            tile[19].image = ImageIO.read(new FileInputStream("res/tile/background_library.png"));

            tile[20] = new Tile();
            tile[20].image = ImageIO.read(new FileInputStream("res/tile/background_myroom.png"));

            tile[33] = new Tile();
            tile[33].image = ImageIO.read(new FileInputStream("res/tile/D7 map.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2, Tile tile) {
        int mapX = tile.getLeftX();
        int mapY = tile.getTopY();
        int width = tile.getWidth();
        int height = tile.getHeight();
        int screenX = mapX - gamePanel.player.getMapX() + gamePanel.player.getBoundingBoxX();
        int screenY = mapY - gamePanel.player.getMapY() + gamePanel.player.getBoundingBoxY();
        g2.drawImage(tile.image, screenX, screenY, width, height, null);
        g2.drawRect(screenX, screenY, width, height);

    }

    public void drawRect(Graphics2D g2, int mapX, int mapY, int width, int height) {
        int screenX = mapX - gamePanel.player.getMapX() + gamePanel.player.getBoundingBoxX();
        int screenY = mapY - gamePanel.player.getMapY() + gamePanel.player.getBoundingBoxY();
        g2.drawRect(screenX, screenY, width, height);
    }
}
