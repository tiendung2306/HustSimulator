package area;

import entity.Player;
import main.GamePanel;
import map.Map;
import tile.Tile;
import tile.tileComputerRoom.TileComputerStudent;
import tile.tileComputerRoom.TileComputerTeacher;
import tile.tileComputerRoom.TileWallComputerRoom;
import tile.tileNormalClassroom.TileDoorClassroom;
import tile.tileNormalClassroom.TileTableClassroom;
import tile.tileNormalClassroom.TileTableTeacherClassroom;

import java.awt.*;

public class ComputerRoom extends Map {
    GamePanel gamePanel;
    TileTableClassroom[] tileTable;
    TileDoorClassroom tileDoor01;
    TileDoorClassroom tileDoor02;
    TileTableTeacherClassroom tileTableTeacher;
    TileComputerStudent[] tileComputerStudents;
    TileComputerTeacher tileComputerTeacher;
    TileWallComputerRoom tileWallComputerRoom;
    Tile background;


    public ComputerRoom(GamePanel gamePanel) {
        super();
        this.gamePanel = gamePanel;
        maxMapCol = 21;
        maxMapRow = 18;
        playerX = 35 * gamePanel.scale;
        playerY = 64 * gamePanel.scale;
        tileContainer = new Tile[50];
        gamePanel.tileManager.getTileImage();
        background = new Tile();
        background.image = gamePanel.tileManager.tile[17].image;
        background.setWidth(320 * gamePanel.scale);
        background.setHeight(240 * gamePanel.scale);
        tileTable = new TileTableClassroom[10];
        tileComputerStudents = new TileComputerStudent[20];
        tileComputerTeacher = new TileComputerTeacher(gamePanel,274,182);
        tileDoor01 = new TileDoorClassroom(gamePanel,30,28);
        tileDoor02 = new TileDoorClassroom(gamePanel,261,28);
        tileTableTeacher = new TileTableTeacherClassroom(gamePanel,273,177);
        tileWallComputerRoom = new TileWallComputerRoom(gamePanel,0,0);
        setUpTable();
        setUpTileComputerRoom();


    }

    public void setUpTileComputerRoom() {
        numTileContainer = 0;
        mapIndex = 2;
        addTile(tileWallComputerRoom);
        addTile(tileDoor01);
        addTile(tileDoor02);
        addTile(tileComputerTeacher);
        addTile(tileTableTeacher);
        for(int i = 0; i < 10; i++)
            addTile(tileTable[i]);
        for(int i = 0; i < 20; i++)
            addTile(tileComputerStudents[i]);
    }

    private void setUpTable() {
        int x1 = 33, y1 = 103;
        int x_mt = 35;
        int y1_mt = 102, y2_mt = 122;

        int count =0;
        for(int i = 0; i < 10; i++) {
            ++count;
            if(count <= 5) {
                tileTable[i] = new TileTableClassroom(gamePanel,x1,y1);
                tileComputerStudents[2 * i] = new TileComputerStudent(gamePanel, x_mt, y1_mt);
                tileComputerStudents[2 * i + 1] = new TileComputerStudent(gamePanel, x_mt, y2_mt);
                x1 += 42;
                x_mt += 42;
            }
            if(count == 5) {
                y1 = 178;
                x1 = 33;
                x_mt = 35;
                y1_mt = 177;
                y2_mt = 197;
            }
            if(count > 5) {
                tileTable[i] = new TileTableClassroom(gamePanel,x1,y1);
                tileComputerStudents[2 * i] = new TileComputerStudent(gamePanel, x_mt, y1_mt);
                tileComputerStudents[2 * i + 1] = new TileComputerStudent(gamePanel, x_mt, y2_mt);
                x1 += 42;
                x_mt += 42;
            }
        }
    }



    public void draw(Graphics2D g2) {
        gamePanel.tileManager.draw(g2, background);
        for (int i = 0; i < numTileContainer; ++i)
            gamePanel.tileManager.draw(g2, tileContainer[i]);
    }
}
