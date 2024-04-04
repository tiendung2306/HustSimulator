package area;

import main.GamePanel;
import map.Map;
import tile.Tile;
import tile.TileManager;
import tile.tileComputerRoom.TileComputerStudent;
import tile.tileComputerRoom.TileComputerTeacher;
import tile.tileNormalClassroom.TileDoorClassroom;
import tile.tileNormalClassroom.TileTableClassroom;
import tile.tileNormalClassroom.TileTableTeacherClassroom;

import java.awt.*;

public class ComputerRoom extends Map {
    GamePanel gamePanel;
    TileManager tileManager;
    TileTableClassroom[] tileTable;
    TileDoorClassroom tileDoor01;
    TileDoorClassroom tileDoor02;
    TileTableTeacherClassroom tileTableTeacher;
    TileComputerStudent[] tileComputerStudents;
    TileComputerTeacher tileComputerTeacher;

    public ComputerRoom(GamePanel gamePanel) {
        super();
        this.gamePanel = gamePanel;
        tileContainer = new Tile[50];
        tileManager = new TileManager(gamePanel);
        this.tileManager.getTileImage();
        tileTable = new TileTableClassroom[10];
        tileComputerStudents = new TileComputerStudent[20];
        tileComputerTeacher = new TileComputerTeacher(gamePanel,274,182);
        tileDoor01 = new TileDoorClassroom(gamePanel,30,28);
        tileDoor02 = new TileDoorClassroom(gamePanel,261,28);
        tileTableTeacher = new TileTableTeacherClassroom(gamePanel,273,177);
        setUpTable();
        setUpTileComputerRoom();

    }

    public void setUpTileComputerRoom() {
        numTileContainer = 5;
        mapIndex = 2;
        tileContainer[0] = tileManager.tile[1];
        tileContainer[1] = tileManager.tile[2];
        tileContainer[2] = tileManager.tile[14];
        tileContainer[3] = tileManager.tile[3];
        tileContainer[4] = tileManager.tile[4];
    }

    private void setUpTable() {
        int x1 = 33, y1 = 103;
        int x_mt = 35;
        int y1_mt = 102, y2_mt = 122;

        int count =0;
        for(int i = 0; i < 10; i++) {
            ++count;
            if(count<=5) {
                tileTable[i] = new TileTableClassroom(gamePanel,x1,y1);
                tileComputerStudents[2*i] = new TileComputerStudent(gamePanel,x_mt,y1_mt);
                tileComputerStudents[2*i+1] = new TileComputerStudent(gamePanel,x_mt,y2_mt);
                x1 += 42;
                x_mt += 42;
            }
            if(count == 5) {
                y1 = 178;
                x1 = 33;
                x_mt = 35;
                y1_mt = 177;
                y2_mt = 297;
            }
            if(count > 5) {
                tileTable[i] = new TileTableClassroom(gamePanel,x1,y1);
                tileComputerStudents[2*i] = new TileComputerStudent(gamePanel,x_mt,y1_mt);
                tileComputerStudents[2*i+1] = new TileComputerStudent(gamePanel,x_mt,y2_mt);
                x1 += 42;
                x_mt += 42;
            }
        }
    }



    public void draw(Graphics2D g2) {

        tileManager.draw(g2, tileManager.tile[17].image,0,0,320*gamePanel.scale,240*gamePanel.scale);
        for(int i = 0; i < 10; i++) {
            tileTable[i].draw(g2);
        }
        for(int i = 0; i < 20; i++) {
            tileComputerStudents[i].draw(g2);
        }
        tileDoor01.draw(g2);
        tileDoor02.draw(g2);
        tileTableTeacher.draw(g2);
        tileComputerTeacher.draw(g2);
    }
}