package area;

import main.GamePanel;
import map.Map;
import tile.Tile;
import tile.TileSection;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class ComputerRoom extends Map {
    GamePanel gamePanel;
    TileSection tileDoor01,tileDoor02,tileTableTeacher,tileWallComputerRoom,tileComputerTeacher;
    TileSection [] tileTable;
    TileSection [] tileComputerStudents;
    Tile background;



    public ComputerRoom(GamePanel gamePanel) {
        super();
        this.gamePanel = gamePanel;
        maxMapCol = 21;
        maxMapRow = 18;
        playerX = (int) (35 * gamePanel.scale);
        playerY = (int) (64 * gamePanel.scale);
        tileContainer = new Tile[50];
        gamePanel.tileManager.getTileImage();
        background = new Tile();
        background.image = gamePanel.tileManager.tile[17].image;
        background.setWidth((int) (320 * gamePanel.scale));
        background.setHeight((int) (240 * gamePanel.scale));
        tileTable = new TileSection[10];
        tileComputerTeacher = new TileSection(gamePanel,274,182,28,28,"Teacher Computer","Interact","","res/tile/may_tinh_gv.png");
        tileDoor01 = new TileSection(gamePanel,30,28,41,51,"Door Classroom","Teleport","","res/tile/cua_ra_vao.png");
        tileDoor02 = new TileSection(gamePanel,261,28,41,51,"Door Classroom","Teleport","","res/tile/cua_ra_vao.png");
        tileTableTeacher = new TileSection(gamePanel,273,177,30,62,"Table Teacher","Obstacle","","res/tile/ban_gv.png");
        tileWallComputerRoom = new TileSection(gamePanel,0,0,320,79,"","Obstacle","","res/tile/no_thing.png");
        tileComputerStudents = new TileSection[20];
        setUpTable();
        setUpTileComputerRoom();
    }

    public void setUpTileComputerRoom() {
        numTileContainer = 0;
        mapIndex = 2;
        addTile(tileDoor01);
        addTile(tileDoor02);
        addTile(tileWallComputerRoom);
        addTile(tileTableTeacher);
        addTile(tileComputerTeacher);
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
                tileTable[i] = new TileSection(gamePanel,x1,y1,20,46,"Table Student","Obstacle","","res/tile/ban_hs.png");
                tileComputerStudents[2 * i] = new TileSection(gamePanel,x_mt,y1_mt,16,16,"Student Computer","Interact","","res/tile/may_tinh_hs.png");
                tileComputerStudents[2 * i + 1] = new TileSection(gamePanel,x_mt,y2_mt,16,16,"Student Computer","Interact","","res/tile/may_tinh_hs.png");
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
                tileTable[i] = new TileSection(gamePanel,x1,y1,20,46,"Table Student","Obstacle","","res/tile/ban_hs.png");
                tileComputerStudents[2 * i] = new TileSection(gamePanel,x_mt,y1_mt,16,16,"Student Computer","Interact","","res/tile/may_tinh_hs.png");
                tileComputerStudents[2 * i + 1] = new TileSection(gamePanel,x_mt,y2_mt,16,16,"Student Computer","Interact","","res/tile/may_tinh_hs.png");
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
