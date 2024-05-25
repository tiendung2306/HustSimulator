package area;

import main.GamePanel;
import main.Main;
import map.Map;
import tile.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import animation.Animation_player;

import java.io.*;


public class Section_3 extends Map {
    Tile background, Library, BK_ALUMNI_HOUSE, Tien_Lake, Unknown;
    public Tile npcGirl;
    GamePanel gamePanel;
    Tile spawn_point;


    public Section_3(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        
        SetDefaultValues();
    }

    private void SetDefaultValues(){
        TileLoad();
        SetOriginalSize();
        ReSize(gamePanel.player.getBoundingBoxHeight() * 1.0 * 2605 / (40 * background.getHeight()));
        SetPlayerPos();
    }
    
    private void SetOriginalSize(){
        background.setWidth(background.image.getWidth());
        background.setHeight(background.image.getHeight());

        width = background.getWidth();
        height = background.getHeight();
    }

    private void ReSize(double scale){
        background.setWidth((int)(background.getWidth() * scale));
        background.setHeight((int)(background.getHeight() * scale));


        spawn_point.resize(scale);
        for(int i = 0; i < numTileContainer; i++){
            tileContainer[i].resize(scale);

        }
        
        width = background.getWidth();
        height = background.getHeight();

    }

    private void SetPlayerPos(){
        playerX = spawn_point.getLeftX();
        playerY = spawn_point.getTopY();
    }

    private void TileLoad() {
        tileContainer = new Tile[9];

        try {
            BufferedImage bacImage = ImageIO.read(new FileInputStream("res/tile/Section3_demo.png"));
            background = new Tile(new Rectangle(0, 0, bacImage.getWidth(), bacImage.getHeight()), "Background", "", null, bacImage);

        } catch (IOException e) {
            e.printStackTrace();
        }


        spawn_point = new Tile(new Rectangle(850 , 1800 , 23 , 44), "", "", null, null);
        Tien_Lake = new Tile(new Rectangle(231, 789, 1227, 903), "Tien_Lake", "Obstacle", null, null);
        BK_ALUMNI_HOUSE = new Tile(new Rectangle(1836, 1335, 699, 675), "BK_ALUMNI_HOUSE", "Obstacle", null, null);
        Unknown = new Tile(new Rectangle(2685, 1161, 309, 942), "Unknown", "Obstacle", null, null);
        Library = new Tile(new Rectangle(1662, 186, 1644, 807), "Library", "Obstacle", null, null);
        npcGirl = new Tile(gamePanel, 100, 100, 16, 41, "NPC Girl", "NPC", "", "res/NPC/NPCGirl/NPCGirl (2).png",1);
        addTile(new Tile(new Rectangle(765,1662,55,69),"Library_entry 1","Teleport","Di vao thu vien 1",null));
        addTile(new Tile(new Rectangle(870,1662,55,72),"Library_entry 2","Teleport","Di vao thu vien 2",null));


        addTile(Tien_Lake);
        addTile(BK_ALUMNI_HOUSE);
        addTile(Unknown);
        addTile(Library);
        addTile(npcGirl);
        map_exchange_effect = new Animation_player(gamePanel, "res/effect/Map_exchange/type1/frame ", 4, 0.8, new Rectangle((int)(GamePanel.screenWidth / 4), (int)(GamePanel.screenHeight / 2 - GamePanel.screenWidth / 4), (int)(GamePanel.screenWidth / 2), (int)(GamePanel.screenWidth / 2)));


    }

    public void open(){
        loadMap(gamePanel);
    }

    public void close(){
        Main.popGameState();
    }

    // Phương thức vẽ map
    public void draw(Graphics2D g2) {

        gamePanel.tileManager.draw(g2, background);
        for (int i = 0; i < numTileContainer; ++i)
            gamePanel.tileManager.draw(g2, tileContainer[i]);
    }
}
