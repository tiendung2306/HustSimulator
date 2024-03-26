package phong_hoc;

import main.GamePanel;
import map.Map;
import tile.Tile;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class Classroom02 extends Map {
    GamePanel gp;
    TileManager tileManager ;
    public Classroom02(GamePanel gp) {
        this.gp=gp;
        tileManager = new TileManager(gp);
        numTileContainer = 10;
        tileContainer_classroom02 = new Tile[50];
        //mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        this.tileManager.getTileImage();
        tileManager.loadMap("/txt/phong_hoc.txt");
    }


    //Phương thức đọc dữ liệu trong file.txt

    public void draw(Graphics2D g2) {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
            int tileNum = tileManager.typeTile[col][row];
            //Lệnh để vẽ 1 ô
            g2.drawImage(tileManager.tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;
            if (col == gp.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
        g2.drawImage(tileManager.tile[2].image,25* gp.scale,4*gp.scale,50*gp.scale,16*gp.scale,null);
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
        int x_mt_hs=33,y_mt_hs_1=95,y_mt_hs_2=109;
        while(true) {
            dem++;
            if(dem<=5) {
                g2.drawImage(tileManager.tile[4].image, x_ban * gp.scale, y_ban * gp.scale, 16 * gp.scale, 32 * gp.scale, null);
                g2.drawImage(tileManager.tile[7].image,x_mt_hs*gp.scale,y_mt_hs_1*gp.scale,13*gp.scale, 13*gp.scale,null);
                g2.drawImage(tileManager.tile[7].image,x_mt_hs*gp.scale,y_mt_hs_2*gp.scale,13*gp.scale, 13*gp.scale,null);
                x_mt_hs+=32;
                x_ban += 32;
            }
            if(dem == 5) {
                x_ban=x_ban-32;
                x_mt_hs=x_mt_hs-32;
            }
            if(dem>5) {
                y_ban=160;
                y_mt_hs_1=159;
                y_mt_hs_2=173;
                g2.drawImage(tileManager.tile[4].image, x_ban * gp.scale, y_ban * gp.scale, 16 * gp.scale, 32 * gp.scale, null);
                g2.drawImage(tileManager.tile[7].image,x_mt_hs*gp.scale,y_mt_hs_1*gp.scale,13*gp.scale, 13*gp.scale,null);
                g2.drawImage(tileManager.tile[7].image,x_mt_hs*gp.scale,y_mt_hs_2*gp.scale,13*gp.scale, 13*gp.scale,null);
                x_ban -= 32;
                x_mt_hs-=32;
            }
            if(dem==10) {
                break;
            }
        }
        g2.drawImage(tileManager.tile[8].image,208*gp.scale,137*gp.scale,28*gp.scale, 28*gp.scale,null);

    }
}
