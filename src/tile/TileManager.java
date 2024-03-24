package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int[][] typeTile;
    public TileManager(GamePanel gp) {

        this.gp = gp;

        tile = new Tile[10];
        typeTile = new int[gp.maxMapCol][gp.maxMapRow];

        getTileImage();
    }
    public void getTileImage() {

        try {

            tile[0] = new Tile();
            tile[0].image = ImageIO.read(new FileInputStream("res/tile/ban_gv.png"));
            tile[0].typeCollision = 0;

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(new FileInputStream("res/tile/ban_gv.png"));
            tile[1].typeCollision = 1;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(new FileInputStream("res/tile/ban_gv.png"));
            tile[2].typeCollision = 2;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(new FileInputStream("res/tile/ban_gv.png"));
            tile[3].typeCollision = 3;

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2) {

        int mapCol = 0, mapRow = 0;

        while (mapCol < gp.maxMapCol && mapRow < gp.maxMapRow) {

            int mapX = mapCol * gp.tileSize;
            int mapY = mapRow * gp.tileSize;

            int screenX = mapX - gp.player.mapX + gp.player.screenX;
            int screenY = mapY - gp.player.mapY + gp.player.screenY;
            if     (mapX + gp.tileSize > gp.player.mapX - gp.player.screenX &&
                    mapX - gp.tileSize < gp.player.mapX + gp.player.screenX &&
                    mapY + gp.tileSize > gp.player.mapY - gp.player.screenY &&
                    mapY - gp.tileSize < gp.player.mapY + gp.player.screenY) {
                g2.drawImage(tile[typeTile[mapCol][mapRow]].image, screenX, screenY, gp.tileSize, gp.tileSize, null);

            }

            ++mapCol;
            if (mapCol == gp.maxMapCol) {
                mapCol = 0;
                ++mapRow;
            }
        }
    }
}
