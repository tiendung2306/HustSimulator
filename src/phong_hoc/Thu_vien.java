package phong_hoc;

import main.GamePanel;
import map.Map;
import tile.Tile;
import tile.TileManager;

import java.awt.*;

public class Thu_vien extends Map {
    GamePanel gp;
    TileManager tileManager ;

    public Thu_vien(GamePanel gp) {
        this.gp=gp;
        tileManager = new TileManager(gp);
        numTileContainer =10;
        tileContainer_thu_vien = new Tile[50];
        //mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        this.tileManager.getTileImage();
        tileManager.loadMap("/txt/thu_vien.txt");
    }



    // Phương thức vẽ map
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

        g2.drawImage(tileManager.tile[34].image,94* gp.scale,13*gp.scale,92*gp.scale,35*gp.scale,null);
        g2.drawImage(tileManager.tile[16].image,16* gp.scale,2*gp.scale,46*gp.scale,26*gp.scale,null);
        g2.drawImage(tileManager.tile[12].image,209* gp.scale,1*gp.scale,29*gp.scale,29*gp.scale,null);
        g2.drawImage(tileManager.tile[13].image,33* gp.scale,35*gp.scale,78*gp.scale,59*gp.scale,null);
        g2.drawImage(tileManager.tile[14].image,0* gp.scale,54*gp.scale,15*gp.scale,130*gp.scale,null);
        g2.drawImage(tileManager.tile[15].image,33* gp.scale,128*gp.scale,81*gp.scale,61*gp.scale,null);
        g2.drawImage(tileManager.tile[10].image,145* gp.scale,65*gp.scale,31*gp.scale,31*gp.scale,null);
        g2.drawImage(tileManager.tile[10].image,145* gp.scale,113*gp.scale,31*gp.scale,31*gp.scale,null);
        g2.drawImage(tileManager.tile[10].image,145* gp.scale,160*gp.scale,31*gp.scale,31*gp.scale,null);
        g2.drawImage(tileManager.tile[10].image,210* gp.scale,65*gp.scale,31*gp.scale,31*gp.scale,null);
        g2.drawImage(tileManager.tile[10].image,210* gp.scale,113*gp.scale,31*gp.scale,31*gp.scale,null);
        g2.drawImage(tileManager.tile[10].image,210* gp.scale,160*gp.scale,31*gp.scale,31*gp.scale,null);
        g2.drawImage(tileManager.tile[11].image,170* gp.scale,73*gp.scale,28*gp.scale,28*gp.scale,null);
        g2.drawImage(tileManager.tile[11].image,170* gp.scale,121*gp.scale,28*gp.scale,28*gp.scale,null);
        g2.drawImage(tileManager.tile[11].image,170* gp.scale,169*gp.scale,28*gp.scale,28*gp.scale,null);
        g2.drawImage(tileManager.tile[11].image,234* gp.scale,73*gp.scale,28*gp.scale,28*gp.scale,null);
        g2.drawImage(tileManager.tile[11].image,234* gp.scale,121*gp.scale,28*gp.scale,28*gp.scale,null);
        g2.drawImage(tileManager.tile[11].image,234* gp.scale,169*gp.scale,28*gp.scale,28*gp.scale,null);
    }
}
