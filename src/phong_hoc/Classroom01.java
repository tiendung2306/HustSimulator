package phong_hoc;

import main.GamePanel;
import tile.Tile;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Classroom01 extends JPanel {
    GamePanel gp;
    TileManager tileManager;
    Tile[] tile;
    int[][] mapTileNum;
    public Classroom01(GamePanel gp) {
        this.gp = gp;
        tileManager = new TileManager(gp);
        this.tile = tileManager.tile;
        this.tileManager.loadMap("src/phong_hoc/phong_hoc.txt");
        this.mapTileNum = tileManager.typeTile;
    }


    //int[][] mapTileNum = tileManager.typeTile;

    //Phương thức đọc dữ liệu trong file.txt

    // Phương thức vẽ map
    public void draw(Graphics2D g2) {
        int mapCol = 0, mapRow = 0;

        while (mapCol < gp.maxMapCol && mapRow < gp.maxMapRow) {

            int mapX = mapCol * gp.tileSize;
            int mapY = mapRow * gp.tileSize;

            int screenX = mapX - gp.player.getMapX() + gp.player.screenX;
            int screenY = mapY - gp.player.getMapY() + gp.player.screenY;
            if     (mapX + gp.tileSize > gp.player.getMapX() - gp.player.screenX &&
                    mapX - gp.tileSize < gp.player.getMapX() + gp.player.screenX &&
                    mapY + gp.tileSize > gp.player.getMapY() - gp.player.screenY &&
                    mapY - gp.tileSize < gp.player.getMapY() + gp.player.screenY) {
                g2.drawImage(tile[mapTileNum[mapCol][mapRow]].image, screenX, screenY, gp.tileSize, gp.tileSize, null);

            }

            ++mapCol;
            if (mapCol == gp.maxMapCol) {
                mapCol = 0;
                ++mapRow;
            }
        }
//        g2.drawImage(tileManager.tile[4].image,25* gp.scale,4*gp.scale,50*gp.scale,16*gp.scale,null);
//        g2.drawImage(tileManager.tile[4].image,98*gp.scale,4*gp.scale,50*gp.scale, 16*gp.scale,null);
//        g2.drawImage(tileManager.tile[4].image,174*gp.scale,4*gp.scale,50*gp.scale, 16*gp.scale,null);
//        g2.drawImage(tileManager.tile[9].image,0,77*gp.scale,256*gp.scale, 3*gp.scale,null);
//        g2.drawImage(tileManager.tile[6].image,16*gp.scale,29*gp.scale,41*gp.scale, 51*gp.scale,null);
//        g2.drawImage(tileManager.tile[6].image,204*gp.scale,29*gp.scale,41*gp.scale, 51*gp.scale,null);
//        g2.drawImage(tileManager.tile[7].image,25*gp.scale,87*gp.scale,16*gp.scale, 42*gp.scale,null);
//      g2.drawImage(tileManager.tile[7].image,60*gp.scale,87*gp.scale,16*gp.scale, 42*gp.scale,null);
//        g2.drawImage(tileManager.tile[7].image,95*gp.scale,87*gp.scale,16*gp.scale, 42*gp.scale,null);4

//        g2.drawImage(tileManager.tile[7].image,130*gp.scale,87*gp.scale,16*gp.scale, 42*gp.scale,null);
//        g2.drawImage(tileManager.tile[7].image,165*gp.scale,87*gp.scale,16*gp.scale, 42*gp.scale,null);
//        g2.drawImage(tileManager.tile[7].image,25*gp.scale,151*gp.scale,16*gp.scale, 42*gp.scale,null);
//        g2.drawImage(tileManager.tile[7].image,60*gp.scale,151*gp.scale,16*gp.scale, 42*gp.scale,null);
//        g2.drawImage(tileManager.tile[7].image,95*gp.scale,151*gp.scale,16*gp.scale, 42*gp.scale,null);
//        g2.drawImage(tileManager.tile[7].image,130*gp.scale,151*gp.scale,16*gp.scale, 42*gp.scale,null);
//        g2.drawImage(tileManager.tile[7].image,165*gp.scale,151*gp.scale,16*gp.scale, 42*gp.scale,null);
//        g2.drawImage(tileManager.tile[8].image,210*gp.scale,134*gp.scale,24*gp.scale, 58*gp.scale,null);
//        g2.drawImage(tileManager.tile[5].image,83*gp.scale,26*gp.scale,38*gp.scale, 40*gp.scale,null);
//        g2.drawImage(tileManager.tile[5].image,140*gp.scale,26*gp.scale,38*gp.scale, 40*gp.scale,null);

    }
}