package map;

import area.NormalClassroom;
import main.GamePanel;
import area.ComputerRoom;
import area.Stadium;
import area.Library;
import tile.TileManager;

public class MapManager {
    GamePanel gamePanel;

    NormalClassroom classroom01;
    ComputerRoom classroom02;
    Library thuVien;
    Stadium svd;
    TileManager tileManager;
    public MapManager(GamePanel gamePanel) {
        this.gamePanel=gamePanel;
        classroom01 = new NormalClassroom(gamePanel);
        classroom02 = new ComputerRoom(gamePanel);
        thuVien = new Library(gamePanel);
        svd = new Stadium(gamePanel);
        tileManager = new TileManager(gamePanel);
    }

    public void setupTileClassroom01() {
        classroom01.tileContainer[0][1] = tileManager.tile[0];
        classroom01.tileContainer[1][1] = tileManager.tile[1];
        classroom01.tileContainer[2][1] = tileManager.tile[32];
        classroom01.tileContainer[3][1] = tileManager.tile[2];
        classroom01.tileContainer[4][1] = tileManager.tile[6];
        classroom01.tileContainer[5][1] = tileManager.tile[39];
        classroom01.tileContainer[6][1] = tileManager.tile[5];
        classroom01.tileContainer[7][1]= tileManager.tile[3];
        classroom01.tileContainer[8][1] = tileManager.tile[4];
    }

    public void setupTileClassroom02 () {
        classroom02.tileContainer[0][2] = tileManager.tile[0];
        classroom02.tileContainer[1][2] = tileManager.tile[1];
        classroom02.tileContainer[2][2] = tileManager.tile[32];
        classroom02.tileContainer[3][2] = tileManager.tile[2];
        classroom02.tileContainer[4][2] = tileManager.tile[6];
        classroom02.tileContainer[5][2] = tileManager.tile[39];
        classroom02.tileContainer[6][2] = tileManager.tile[5];
        classroom02.tileContainer[7][2] = tileManager.tile[3];
        classroom02.tileContainer[8][2] = tileManager.tile[4];
        classroom02.tileContainer[9][2] = tileManager.tile[7];
    }


    public void setupTileThuVIen() {
        classroom01.tileContainer[0][3] = tileManager.tile[9];
        classroom01.tileContainer[1][3] = tileManager.tile[38];
        classroom01.tileContainer[2][3] = tileManager.tile[34];
        classroom01.tileContainer[3][3] = tileManager.tile[16];
        classroom01.tileContainer[4][3] = tileManager.tile[12];
        classroom01.tileContainer[5][3] = tileManager.tile[13];
        classroom01.tileContainer[6][3] = tileManager.tile[14];
        classroom01.tileContainer[7][3] = tileManager.tile[15];
        classroom01.tileContainer[8][3] = tileManager.tile[10];
        classroom01.tileContainer[9][3] = tileManager.tile[11];
    }

    public void setupTileSvd() {
        classroom01.tileContainer[20][4] = tileManager.tile[36];
        classroom01.tileContainer[21][4] = tileManager.tile[35];
        classroom01.tileContainer[22][4] = tileManager.tile[37];
        classroom01.tileContainer[23][4] = tileManager.tile[20];
        classroom01.tileContainer[24][4] = tileManager.tile[17];
        classroom01.tileContainer[25][4] = tileManager.tile[21];
        classroom01.tileContainer[26][4] = tileManager.tile[22];
        classroom01.tileContainer[27][4] = tileManager.tile[40];
        classroom01.tileContainer[28][4] = tileManager.tile[18];
        classroom01.tileContainer[29][4] = tileManager.tile[19];
        classroom01.tileContainer[30][4] = tileManager.tile[23];
        classroom01.tileContainer[31][4] = tileManager.tile[31];
    }
}