package phong_hoc;

import main.GamePanel;
import tile.TileManager;

import java.awt.*;

public class Svd {
    GamePanel gp;
    public TileManager tileManager = new TileManager(gp);
    int[][] mapTileNum = tileManager.typeTile;
    public Svd(GamePanel gp) {
        this.gp = gp;
        this.tileManager.getTileImage();
    }

    // Phương thức vẽ map
    public void draw(Graphics2D g2) {
        g2.drawImage(tileManager.tile[24].image,0,119*gp.scale,256*gp.scale,73*gp.scale,null);
        g2.drawImage(tileManager.tile[23].image,0,0,209*gp.scale,55*gp.scale,null);
        g2.drawImage(tileManager.tile[26].image,139*gp.scale,0,117*gp.scale,87*gp.scale,null);
        g2.drawImage(tileManager.tile[29].image,0,55*gp.scale,174*gp.scale,40*gp.scale,null);
        g2.drawImage(tileManager.tile[25].image,0,45*gp.scale,174*gp.scale,10*gp.scale,null);
        g2.drawImage(tileManager.tile[30].image,174* gp.scale,44*gp.scale,29*gp.scale,51*gp.scale,null);
        g2.drawImage(tileManager.tile[31].image,241* gp.scale,44*gp.scale,15*gp.scale,51*gp.scale,null);
        g2.drawImage(tileManager.tile[22].image,0,95*gp.scale,256*gp.scale,32*gp.scale,null);
        g2.drawImage(tileManager.tile[27].image,15* gp.scale,111*gp.scale,65*gp.scale,33*gp.scale,null);
        g2.drawImage(tileManager.tile[28].image,144* gp.scale,128*gp.scale,77*gp.scale,33*gp.scale,null);
        g2.drawImage(tileManager.tile[32].image,145* gp.scale,22*gp.scale,15*gp.scale,15*gp.scale,null);
        g2.drawImage(tileManager.tile[33].image,203* gp.scale,83*gp.scale,38*gp.scale,12*gp.scale,null);
    }
}