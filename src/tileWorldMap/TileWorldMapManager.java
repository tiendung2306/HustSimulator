package tileWorldMap;

import main.GamePanel;
import tile.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public class TileWorldMapManager {
    GamePanel gamePanel;
    public Tile[] tile;
    public TileWorldMapManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        tile = new Tile[60];
        getTileImage();
    }

    public void getTileImage() {
        try {
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(new FileInputStream("res/Map/KHU_VUC_3.png"));

        }catch (IOException e) {
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
