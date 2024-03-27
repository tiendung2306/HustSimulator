package map;

import main.GamePanel;
import phong_hoc.Classroom01;
import phong_hoc.Classroom02;
import phong_hoc.Svd;
import phong_hoc.Thu_vien;
import tile.Tile;
import tile.TileManager;

public class MapManager {
    GamePanel gamePanel;

    Classroom01 classroom01;
    Classroom02 classroom02;
    Thu_vien thuVien;
    Svd svd;
    TileManager tileManager;
    public MapManager(GamePanel gamePanel) {
        this.gamePanel=gamePanel;
        classroom01 = new Classroom01(gamePanel);
        classroom02 = new Classroom02(gamePanel);
        thuVien = new Thu_vien(gamePanel);
        svd = new Svd(gamePanel);
        tileManager = new TileManager(gamePanel);
    }

    public void setupTileClassroom01() {
        classroom01.tileContainer[0]=tileManager.tile[0];
        classroom01.tileContainer[1]=tileManager.tile[1];
        classroom01.tileContainer[2]=tileManager.tile[32];
        classroom01.tileContainer[3]=tileManager.tile[2];
        classroom01.tileContainer[4]=tileManager.tile[6];
        classroom01.tileContainer[5]=tileManager.tile[39];
        classroom01.tileContainer[6]=tileManager.tile[5];
        classroom01.tileContainer[7]=tileManager.tile[3];
        classroom01.tileContainer[8]=tileManager.tile[4];
    }

    public void setupTileClassroom02 () {
        classroom02.tileContainer[0]=tileManager.tile[0];
        classroom02.tileContainer[1]=tileManager.tile[1];
        classroom02.tileContainer[2]=tileManager.tile[32];
        classroom02.tileContainer[3]=tileManager.tile[2];
        classroom02.tileContainer[4]=tileManager.tile[6];
        classroom02.tileContainer[5]=tileManager.tile[39];
        classroom02.tileContainer[6]=tileManager.tile[5];
        classroom02.tileContainer[7]=tileManager.tile[3];
        classroom02.tileContainer[8]=tileManager.tile[4];
        classroom02.tileContainer[9]=tileManager.tile[7];
    }


    public void setupTileThuVIen() {
        classroom01.tileContainer[0]=tileManager.tile[9];
        classroom01.tileContainer[1]=tileManager.tile[38];
        classroom01.tileContainer[2]=tileManager.tile[34];
        classroom01.tileContainer[3]=tileManager.tile[16];
        classroom01.tileContainer[4]=tileManager.tile[12];
        classroom01.tileContainer[5]=tileManager.tile[13];
        classroom01.tileContainer[6]=tileManager.tile[14];
        classroom01.tileContainer[7]=tileManager.tile[15];
        classroom01.tileContainer[8]=tileManager.tile[10];
        classroom01.tileContainer[9]=tileManager.tile[11];
    }

    public void setupTileSvd() {
        classroom01.tileContainer[0]=tileManager.tile[36];
        classroom01.tileContainer[1]=tileManager.tile[35];
        classroom01.tileContainer[2]=tileManager.tile[37];
        classroom01.tileContainer[3]=tileManager.tile[20];
        classroom01.tileContainer[4]=tileManager.tile[17];
        classroom01.tileContainer[5]=tileManager.tile[21];
        classroom01.tileContainer[6]=tileManager.tile[22];
        classroom01.tileContainer[7]=tileManager.tile[40];
        classroom01.tileContainer[8]=tileManager.tile[18];
        classroom01.tileContainer[9]=tileManager.tile[19];
        classroom01.tileContainer[10]=tileManager.tile[23];
        classroom01.tileContainer[11]=tileManager.tile[31];
    }
}
