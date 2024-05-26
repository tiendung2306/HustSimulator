package area;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import animation.Animation_player;
import main.GamePanel;
import main.Main;
import map.Map;
import tile.Tile;

public class Section_2 extends Map {
    Tile D3, D5, D3_5, D7, D9;
    public Tile hallway_entry_1, hallway_entry_2, hallway_entry_3;
    Tile spawn_point;


    public Section_2(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        
        SetDefaultValues();
    }

    private void SetDefaultValues(){
        TileLoad();
        ObjectLoad("Section2");
        SetOriginalSize();
        reSizeMap();
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

        map_exchange_effect.resize(GamePanel.screenWidth / (2 * map_exchange_effect.getWidth()));


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
        tileContainer = new Tile[60];

        try {
            BufferedImage bacImage = ImageIO.read(new FileInputStream("res/tile/Section2_demo.png"));
            background = new Tile(new Rectangle(0, 0, bacImage.getWidth(), bacImage.getHeight()), "Background", "", null, bacImage);

        } catch (IOException e) {
            e.printStackTrace();
        }

        hallway_entry_1 = new Tile(new Rectangle(417 , 2159 , 55 , 29), "D3_Hallway_entry_stair1", "Teleport", null, null);
        hallway_entry_2 = new Tile(new Rectangle(833 , 2154 , 198 , 33), "D3_Hallway_entry_stair2", "Teleport", null, null);
        hallway_entry_3 = new Tile(new Rectangle(1223 , 2139 , 26 , 20), "D3_Hallway_entry_stair3", "Teleport", null, null);
        
        spawn_point = new Tile(new Rectangle(860 , 2225 , 23 , 44), "", "", null, null);

        addTile(hallway_entry_1);
        addTile(hallway_entry_2);
        addTile(hallway_entry_3);

        addTile(new Tile(new Rectangle(129 , 2205 , 82 , 10), "park_entry_machine", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(155 , 2180 , 30 , 49), "park_entry_machine", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(157 , 2229 , 25 , 8), "park_entry_machine", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(229 , 2204 , 76 , 10), "park_entry_machine", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(253 , 2179 , 30 , 49), "park_entry_machine", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(256 , 2229 , 25 , 9), "park_entry_machine", "Obstacle", null, null));

        map_exchange_effect = new Animation_player(gamePanel, "res/effect/Map_exchange/type1/frame ", 4, 0.8, new Rectangle((int)(GamePanel.screenWidth / 4), (int)(GamePanel.screenHeight / 2 - GamePanel.screenWidth / 4), (int)(GamePanel.screenWidth / 2), (int)(GamePanel.screenWidth / 2)));


    }
    
    public void open(){
        reSizeMap();
        loadMap(gamePanel);
    }

    public void close(){
        Main.popGameState();
    }

    @Override public void reSizeMap(){
        ReSize(gamePanel.player.getBoundingBoxHeight() * 1.0 * 2605 / (40 * background.getHeight()));
    }
    // Phương thức vẽ map
    // public void draw(Graphics2D g2) {
    //     gamePanel.tileManager.draw(g2, background);

    //     // for (int i = 0; i < numTileContainer; ++i)
    //     //     gamePanel.tileManager.draw(g2, tileContainer[i]);
    // }
}
