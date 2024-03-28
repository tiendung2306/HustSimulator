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

    public void setupTileNormalClassroom() {
        classroom01.tileContainer[0][1] = tileManager.tile[1];
        classroom01.tileContainer[1][1] = tileManager.tile[2];
        classroom01.tileContainer[2][1] = tileManager.tile[14];
    }

    public void setupTileClassroom02 () {
        classroom02.tileContainer[0][2] = tileManager.tile[1];
        classroom02.tileContainer[1][2] = tileManager.tile[2];
        classroom02.tileContainer[2][2] = tileManager.tile[14];
        classroom02.tileContainer[3][2] = tileManager.tile[3];
        classroom02.tileContainer[4][2] = tileManager.tile[4];
    }


    public void setupTileLibrary() {
        classroom01.tileContainer[0][3] = tileManager.tile[5];
        classroom01.tileContainer[1][3] = tileManager.tile[6];
        classroom01.tileContainer[2][3] = tileManager.tile[7];
        classroom01.tileContainer[3][3] = tileManager.tile[8];
        classroom01.tileContainer[4][3] = tileManager.tile[9];
        classroom01.tileContainer[5][3] = tileManager.tile[13];
    }

    public void setupTileStadium() {
        classroom01.tileContainer[20][4] = tileManager.tile[10];
        classroom01.tileContainer[21][4] = tileManager.tile[11];
        classroom01.tileContainer[22][4] = tileManager.tile[12];
        classroom01.tileContainer[23][4] = tileManager.tile[15];
        classroom01.tileContainer[24][4] = tileManager.tile[16];
    }
}