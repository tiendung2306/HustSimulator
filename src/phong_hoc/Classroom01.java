package phong_hoc;

import main.GamePanel;
import map.Map;
import tile.TileManager;
import tile.Tile;

import javax.swing.*;
import java.awt.*;


public class Classroom01 extends Map {
    GamePanel gp; 
    TileManager tileManager;

    public Classroom01(GamePanel gp) {
        super();
        this.gp = gp;
        numTileContainer = 9;
        tileContainer = new Tile[50];
        //mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        tileManager = new TileManager(gp);
        this.tileManager.getTileImage(); 
        tileManager.loadMap("/txt/phong_hoc.txt");
    }



    public void draw(Graphics2D g2) {
        int col = 0;
        int row = 0;
        int mapX = 0;
        int mapY = 0;

        while (col < gp.maxMapCol && row < gp.maxMapRow) {
            int tileNum = tileManager.typeTile[col][row];
            //Lệnh để vẽ 1 ô
            int screenX = mapX - gp.player.getMapX() + gp.player.screenX;
            int screenY = mapY - gp.player.getMapY() + gp.player.screenY;
            g2.drawImage(tileManager.tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            col++;
            mapX += gp.tileSize;
            if (col == gp.maxScreenCol) {
                col = 0;
                mapX = 0;
                row++;
                mapY += gp.tileSize;
            }
        }
        //int screenX = mapX - gp.player.getMapX() + gp.player.screenX;
        //int screenY = mapY - gp.player.getMapY() + gp.player.screenY;
        //System.out.println(screenX);
        //System.out.println(screenY);
        //g2.drawImage(tileManager.tile[6].image, screenX, screenY, 4 * gp.scale, 50 * gp.scale, null);
        /*g2.drawImage(tileManager.tile[2].image,25* gp.scale,4*gp.scale,50*gp.scale,16*gp.scale,null);
        g2.drawImage(tileManager.tile[2].image,98*gp.scale,4*gp.scale,50*gp.scale, 16*gp.scale,null);
        g2.drawImage(tileManager.tile[2].image,174*gp.scale,4*gp.scale,50*gp.scale, 16*gp.scale,null);
        g2.drawImage(tileManager.tile[6].image,0,77*gp.scale,256*gp.scale, 3*gp.scale,null);
        g2.drawImage(tileManager.tile[39].image,16*gp.scale,29*gp.scale,41*gp.scale, 51*gp.scale,null);
        g2.drawImage(tileManager.tile[39].image,204*gp.scale,29*gp.scale,41*gp.scale, 51*gp.scale,null);
        g2.drawImage(tileManager.tile[5].image,209*gp.scale,130*gp.scale,26*gp.scale, 62*gp.scale,null);
        g2.drawImage(tileManager.tile[3].image,83*gp.scale,26*gp.scale,38*gp.scale, 40*gp.scale,null);
        g2.drawImage(tileManager.tile[3].image,140*gp.scale,26*gp.scale,38*gp.scale, 40*gp.scale,null);
        int dem=0;
        int x_ban=32,y_ban=96;
        while(true) {
            dem++;
            if(dem<=5) {
                g2.drawImage(tileManager.tile[4].image, x_ban * gp.scale, y_ban * gp.scale, 16 * gp.scale, 32 * gp.scale, null);
                x_ban += 32;
            }
            if(dem == 5) {
                x_ban=x_ban-32;
            }
            if(dem>5) {
                y_ban=160;
                g2.drawImage(tileManager.tile[4].image, x_ban * gp.scale, y_ban * gp.scale, 16 * gp.scale, 32 * gp.scale, null);
                x_ban -= 32;
            }
            if(dem==10) {
                break;
            }
        }*/
    }
}