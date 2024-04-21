package area;

import main.GamePanel;
import map.Map;
import tile.Tile;
import tile.TileSection;
import java.awt.*;

public class NormalClassroom extends Map {
    GamePanel gamePanel;
    Tile background;
    TileSection tileDoor01,tileDoor02,tileTableTeacher,tileWallNormalClassroom;
    TileSection [] tileTable;

    public NormalClassroom(GamePanel gamePanel) {
        super();
        this.gamePanel = gamePanel;
        maxMapCol = 21;
        maxMapRow = 18;
        playerX = (int) (35 * gamePanel.scale);
        playerY = (int) (64 * gamePanel.scale);
        tileContainer = new Tile[50];
        background = new Tile();
        background.image = gamePanel.tileManager.tile[17].image;
        background.setWidth((int) (320 * gamePanel.scale));
        background.setHeight((int) (240 * gamePanel.scale));
        tileTable = new TileSection[10];
        tileDoor01 = new TileSection(gamePanel,30,28,41,51,"Door Classroom","Teleport","","res/tile/cua_ra_vao.png");
        tileDoor02 = new TileSection(gamePanel,261,28,41,51,"Door Classroom","Teleport","","res/tile/cua_ra_vao.png");
        tileTableTeacher = new TileSection(gamePanel,273,177,30,62,"Teacher Table Classroom","Obstacle","","res/tile/ban_gv.png");
        tileWallNormalClassroom = new TileSection(gamePanel,0,0,320,79,"","Obstacle","","res/tile/no_thing.png");
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
                tileTable[i] = new TileSection(gamePanel,x1,y1,20,46,"Table Classroom","Obstacle","","res/tile/ban_hs.png");
                x1 += 42;
            }
            if (count == 5) {
                y1 = 178;
                x1 = 33;
            }
            if (count > 5) {
                tileTable[i] = new TileSection(gamePanel,x1,y1,20,46,"Table Classroom","Obstacle","","res/tile/ban_hs.png");
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