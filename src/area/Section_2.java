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

public class Section_2 extends Map {
    Tile background, D3, D5, D3_5, D7, D9;
    Tile hallway_entry_1, hallway_entry_2, hallway_entry_3;
    Tile spawn_point;
    GamePanel gamePanel;


    public Section_2(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        
        SetDefaultValues();
    }

    private void SetDefaultValues(){
        TileLoad();
        SetOriginalSize();
        ReSize(gamePanel.player.getBoundingBoxHeight() * 1.0 * 2605 / (40 * background.getHeight()));
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

        SetPlayerPos();

    }

    private void SetPlayerPos(){
        playerX = spawn_point.getLeftX();
        playerY = spawn_point.getTopY();
    }

    private void TileLoad() {
        tileContainer = new Tile[6];

        try {
            BufferedImage bacImage = ImageIO.read(new FileInputStream("res/tile/Section2_demo.png"));
            background = new Tile(new Rectangle(0, 0, bacImage.getWidth(), bacImage.getHeight()), "Background", "", null, bacImage);

        } catch (IOException e) {
            e.printStackTrace();
        }

        D3 = new Tile(new Rectangle(463, 1974, 1088, 387), "D3", "Obstacle", null, null);
        D5 = new Tile(new Rectangle(486, 1497, 1088, 390), "D5", "Obstacle", null, null);
        D9 = new Tile(new Rectangle(2030, 251, 1226, 402), "D9", "Obstacle", null, null);

        hallway_entry_1 = new Tile(new Rectangle(691 , 2344 , 25 , 23), "D3_Hallway_entry_stair1", "Teleport", null, null);
        hallway_entry_2 = new Tile(new Rectangle(908 , 2355 , 198 , 38), "D3_Hallway_entry_stair2", "Teleport", null, null);
        hallway_entry_3 = new Tile(new Rectangle(1297 , 2345 , 26 , 21), "D3_Hallway_entry_stair3", "Teleport", null, null);
        
        spawn_point = new Tile(new Rectangle(988 , 2438 , 30 , 47), "", "", null, null);

        addTile(hallway_entry_1);
        addTile(hallway_entry_2);
        addTile(hallway_entry_3);
        
        addTile(D3);
        addTile(D5);
        addTile(D9);

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

        // for (int i = 0; i < numTileContainer; ++i)
        //     gamePanel.tileManager.draw(g2, tileContainer[i]);
    }
}
