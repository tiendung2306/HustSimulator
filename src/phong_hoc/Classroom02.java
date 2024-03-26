package phong_hoc;

import main.GamePanel;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Classroom02 extends JPanel {
    GamePanel gp;
    //Tile[] tile;    //Mảng 1 chiều của lớp 1 ô
    TileManager tileManager=new TileManager(gp);
    int[][] mapTileNum = tileManager.typeTile;
    public Classroom02(GamePanel gp) {
        this.gp = gp;
        this.tileManager.getTileImage();
        this.tileManager.loadMap("/phong_hoc/phong_hoc.txt");
    }


    //Phương thức đọc dữ liệu trong file.txt

    public void draw(Graphics2D g2) {
        int col =0;
        int row = 0;
        int x=0;
        int y=0;

        while(col < gp.maxScreenCol && row <gp.maxScreenRow) {
            int tileNum2= mapTileNum[col][row];
            //Lệnh để vẽ 1 ô
            g2.drawImage(tileManager.tile[tileNum2].image,x,y,gp.tileSize, gp.tileSize,null);
            col++;
            x+=gp.tileSize;
            if(col == gp.maxScreenCol) {
                col=0;
                x=0;
                row++;
                y+=gp.tileSize;
            }
        }
        g2.drawImage(tileManager.tile[4].image,25* gp.scale,4*gp.scale,50*gp.scale,16*gp.scale,null);
        g2.drawImage(tileManager.tile[4].image,98*gp.scale,4*gp.scale,50*gp.scale, 16*gp.scale,null);
        g2.drawImage(tileManager.tile[4].image,174*gp.scale,4*gp.scale,50*gp.scale, 16*gp.scale,null);
        g2.drawImage(tileManager.tile[9].image,0,77*gp.scale,256*gp.scale, 3*gp.scale,null);
        g2.drawImage(tileManager.tile[6].image,16*gp.scale,29*gp.scale,41*gp.scale, 51*gp.scale,null);
        g2.drawImage(tileManager.tile[6].image,204*gp.scale,29*gp.scale,41*gp.scale, 51*gp.scale,null);
        g2.drawImage(tileManager.tile[8].image,210*gp.scale,134*gp.scale,24*gp.scale, 58*gp.scale,null);
        g2.drawImage(tileManager.tile[5].image,83*gp.scale,26*gp.scale,38*gp.scale, 40*gp.scale,null);
        g2.drawImage(tileManager.tile[5].image,140*gp.scale,26*gp.scale,38*gp.scale, 40*gp.scale,null);
        int dem=0;
        int x_ban=25,y_ban=87;
        int x_mt_hs=27,y_mt_hs_1=84,y_mt_hs_2=104;
        while(true) {
            dem++;
            if(dem<=5) {
                g2.drawImage(tileManager.tile[7].image, x_ban * gp.scale, y_ban * gp.scale, 16 * gp.scale, 42 * gp.scale, null);
                g2.drawImage(tileManager.tile[10].image,x_mt_hs*gp.scale,y_mt_hs_1*gp.scale,16*gp.scale, 16*gp.scale,null);
                g2.drawImage(tileManager.tile[10].image,x_mt_hs*gp.scale,y_mt_hs_2*gp.scale,16*gp.scale, 16*gp.scale,null);
                x_mt_hs+=35;
                x_ban += 35;
            }
            if(dem == 5) {
                x_ban=x_ban-35;
                x_mt_hs=x_mt_hs-35;
            }
            if(dem>5) {
                y_ban=151;
                y_mt_hs_1=148;
                y_mt_hs_2=168;
                g2.drawImage(tileManager.tile[7].image, x_ban * gp.scale, y_ban * gp.scale, 16 * gp.scale, 42 * gp.scale, null);
                g2.drawImage(tileManager.tile[10].image,x_mt_hs*gp.scale,y_mt_hs_1*gp.scale,16*gp.scale, 16*gp.scale,null);
                g2.drawImage(tileManager.tile[10].image,x_mt_hs*gp.scale,y_mt_hs_2*gp.scale,16*gp.scale, 16*gp.scale,null);
                x_ban -= 35;
                x_mt_hs-=35;
            }
            if(dem==10) {
                break;
            }
        }
        g2.drawImage(tileManager.tile[11].image,208*gp.scale,137*gp.scale,28*gp.scale, 28*gp.scale,null);

    }
}
