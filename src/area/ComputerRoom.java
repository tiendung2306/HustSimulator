package area;

import main.GamePanel;
import map.Map;
import tile.Tile;


import java.awt.*;

public class ComputerRoom extends Map {
    GamePanel gamePanel;
    public Tile tileDoor01,tileDoor02,tileTableTeacher,tileWallComputerRoom,tileComputerTeacher;
    public Tile [] tileTable;
    public Tile [] tileComputerStudents;
    Tile background;



    public ComputerRoom(GamePanel gamePanel) {
        super();
        this.gamePanel = gamePanel;
        width = (int)(21 * 16 * gamePanel.scale);
        height = (int)(16 * 16 * gamePanel.scale);
        // maxMapCol = 21;
        // maxMapRow = 18;
        tileContainer = new Tile[50];
        background = new Tile();
        background.image = gamePanel.tileManager.tile[17].image;
        setDefaultValues();
    }

    public void setDefaultValues() {
        playerX = (int) (35 * GamePanel.scale);
        playerY = (int) (64 * GamePanel.scale);
        gamePanel.tileManager.getTileImage();
        background.setWidth((int) (320 * GamePanel.scale));
        background.setHeight((int) (240 * GamePanel.scale));
        tileTable = new Tile[10];
        tileComputerTeacher = new Tile(gamePanel,274,182,28,28,"Teacher Computer","Interact","","res/tile/may_tinh_gv.png",1);
        tileDoor01 = new Tile(gamePanel,30,28,41,51,"Door Classroom","Teleport","","res/tile/cua_ra_vao.png",1);
        tileDoor02 = new Tile(gamePanel,261,28,41,51,"Door Classroom","Teleport","","res/tile/cua_ra_vao.png",1);
        tileTableTeacher = new Tile(gamePanel,273,177,30,62,"Table Teacher","Obstacle","","res/tile/ban_gv.png",1);
        tileWallComputerRoom = new Tile(gamePanel,0,0,320,79,"","Obstacle","","res/tile/no_thing.png",1);
        tileComputerStudents = new Tile[20];
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
                tileTable[i] = new Tile(gamePanel,x1,y1,20,46,"Table Student","Obstacle","","res/tile/ban_hs.png",1);
                tileComputerStudents[2 * i] = new Tile(gamePanel,x_mt,y1_mt,16,16,"Student Computer","Interact","","res/tile/may_tinh_hs.png",1);
                tileComputerStudents[2 * i + 1] = new Tile(gamePanel,x_mt,y2_mt,16,16,"Student Computer","Interact","","res/tile/may_tinh_hs.png",1);
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
                tileTable[i] = new Tile(gamePanel,x1,y1,20,46,"Table Student","Obstacle","","res/tile/ban_hs.png",1);
                tileComputerStudents[2 * i] = new Tile(gamePanel,x_mt,y1_mt,16,16,"Student Computer","Interact","","res/tile/may_tinh_hs.png",1);
                tileComputerStudents[2 * i + 1] = new Tile(gamePanel,x_mt,y2_mt,16,16,"Student Computer","Interact","","res/tile/may_tinh_hs.png",1);
                x1 += 42;
                x_mt += 42;
            }
        }
    }

    public void resetTile(){
        width = (int) (21 * 16 * GamePanel.scale);
        height = (int) (16 * 16 * GamePanel.scale);
        if(gamePanel.currentMap == this) {
            playerX = (int) ((gamePanel.player.getMapX() / prevScale) * GamePanel.scale);
            playerY = (int) ((gamePanel.player.getMapY() / prevScale) * GamePanel.scale);
        } else {
            playerX = (int) (35 * GamePanel.scale);
            playerY = (int) (64 * GamePanel.scale);
        }
        prevScale = (int) GamePanel.scale;
        background.setWidth((int) (320 * GamePanel.scale));
        background.setHeight((int) (240 * GamePanel.scale));
        for (int i = 0; i < numTileContainer; ++i) {
            tileContainer[i].reSizeTile();
        }
    }



    public void draw(Graphics2D g2) {
        gamePanel.tileManager.draw(g2, background);
        for (int i = 0; i < numTileContainer; ++i)
            gamePanel.tileManager.draw(g2, tileContainer[i]);
    }
}
