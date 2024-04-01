package area;

import main.GamePanel;
import map.Map;
import tile.TileManager;
import tile.Tile;
import tile.tileNormalClassroom.TileDoorClassroom;
import tile.tileNormalClassroom.TileTableClassroom;
import tile.tileNormalClassroom.TileTableTeacherClassroom;

import java.awt.*;

public class NormalClassroom extends Map {
    GamePanel gamePanel;
    TileManager tileManager;
    TileTableClassroom[] tileTable;
    TileDoorClassroom tileDoor01;
    TileDoorClassroom tileDoor02;
    TileTableTeacherClassroom tileTableTeacher;

    public NormalClassroom(GamePanel gamePanel) {
        super();
        this.gamePanel = gamePanel;
        tileContainer = new Tile[50];
        tileManager = new TileManager(gamePanel);
        tileTable = new TileTableClassroom[10];
        tileDoor01 = new TileDoorClassroom(gamePanel, 30, 28);
        tileDoor02 = new TileDoorClassroom(gamePanel, 261, 28);
        tileTableTeacher = new TileTableTeacherClassroom(gamePanel, 273, 177);
        setUpTable();
        setUpTileNormalClassroom();
    }
    public void setUpTileNormalClassroom() {
        numTileContainer = 3;
        mapIndex = 1;
        tileContainer[0] = tileManager.tile[1];
        tileContainer[1] = tileManager.tile[2];
        tileContainer[2] = tileManager.tile[14];
    }

    private void setUpTable() {
        int x1 = 33;
        int y1 = 103;
        int count = 0;
        for (int i = 0; i < 10; i++) {
            count++;
            if (count <= 5) {
                tileTable[i] = new TileTableClassroom(gamePanel, x1, y1);
                x1 += 42;
            }
            if (count == 5) {
                y1 = 178;
                x1 = 33;
            }
            if (count > 5) {
                tileTable[i] = new TileTableClassroom(gamePanel, x1, y1);
                x1 += 42;
            }
        }
    }

    public void draw(Graphics2D g2) {

        tileManager.draw(g2, tileManager.tile[17].image, 0, 0, 320 * gamePanel.scale, 240 * gamePanel.scale);
        //for (int i = 0; i < 10; i++) {
            tileTable[0].draw(g2);
        //}
        tileDoor01.draw(g2);
        tileDoor02.draw(g2);
        tileTableTeacher.draw(g2);
    }
}