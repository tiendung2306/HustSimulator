package area;

import main.GamePanel;
import map.Map;
import tile.Tile;
import tile.tileMyRoom.TileWallMyRoom;
import tile.tileNormalClassroom.TileDoorClassroom;
import tile.tileNormalClassroom.TileTableClassroom;
import tile.tileNormalClassroom.TileTableTeacherClassroom;
import tile.tileNormalClassroom.TileWallNormalClassroom;

import java.awt.*;

public class NormalClassroom extends Map {
    GamePanel gamePanel;
    TileTableClassroom[] tileTable;
    TileDoorClassroom tileDoor01;
    TileDoorClassroom tileDoor02;
    TileTableTeacherClassroom tileTableTeacher;
    Tile background;
    TileWallNormalClassroom tileWallNormalClassroom;

    public NormalClassroom(GamePanel gamePanel) {
        super();
        this.gamePanel = gamePanel;
        maxMapCol = 21;
        maxMapRow = 18;
        playerX = 35 * gamePanel.scale;
        playerY = 64 * gamePanel.scale;
        tileContainer = new Tile[50];
        background = new Tile();
        background.image = gamePanel.tileManager.tile[17].image;
        background.setWidth(320 * gamePanel.scale);
        background.setHeight(240 * gamePanel.scale);
        tileTable = new TileTableClassroom[10];
        tileDoor01 = new TileDoorClassroom(gamePanel, 30, 28);
        tileDoor02 = new TileDoorClassroom(gamePanel, 261, 28);
        tileTableTeacher = new TileTableTeacherClassroom(gamePanel, 273, 177);
        tileWallNormalClassroom = new TileWallNormalClassroom(gamePanel,0,0);
        setUpTable();
        setUpTileNormalClassroom();
    }
    public void setUpTileNormalClassroom() {
        numTileContainer = 0;
        mapIndex = 1;
        addTile(tileWallNormalClassroom);
        addTile(tileTableTeacher);
        addTile(tileDoor01);
        addTile(tileDoor02);
        for (int i = 0; i < 10; i++)
            addTile(tileTable[i]);
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

        gamePanel.tileManager.draw(g2, background);
        for (int i = 0; i < numTileContainer; ++i)
            gamePanel.tileManager.draw(g2, tileContainer[i]);
    }
}