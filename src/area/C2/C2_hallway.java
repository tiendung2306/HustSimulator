package area.C2;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import animation.Animation_player;
import main.GamePanel;
import map.Map;
import tile.Tile;


public class C2_hallway extends Map {
    Tile spawn_point1, spawn_point2;
    Animation_player map_exchange_effect1, map_exchange_effect2;
    public Tile c2_hallEntry1, c2_hallEntry2, c2_hallEntry3;


    public C2_hallway(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        
        SetDefaultValues();
    }

    private void SetDefaultValues(){
        TileLoad();
        ObjectLoad("C2_Hallway");
        SetOriginalSize();
        ReSize(gamePanel.player.getBoundingBoxHeight() * 1.0 * background.image.getHeight() / (50 * background.getHeight()));
    }
    
    private void SetOriginalSize(){

        width = background.getWidth();
        height = background.getHeight();
    }

    private void ReSize(double scale){
        background.setWidth((int)(background.getWidth() * scale));
        background.setHeight((int)(background.getHeight() * scale));

        spawn_point1.resize(scale);
        spawn_point2.resize(scale);

        map_exchange_effect1.resize(GamePanel.screenWidth / (2 * map_exchange_effect1.getWidth()));
        map_exchange_effect2.resize(GamePanel.screenWidth / (2 * map_exchange_effect2.getWidth()));




        for(int i = 0; i < numTileContainer; i++){
            tileContainer[i].resize(scale);

        }
        
        width = background.getWidth();
        height = background.getHeight();

    }

    private void SetPlayerPos(Tile spawn_point){
        playerX = spawn_point.LeftX;
        playerY = spawn_point.TopY;
    }

    private void TileLoad() {
        tileContainer = new Tile[50];

        try {
            BufferedImage background_Image = ImageIO.read(new FileInputStream("res/tile/C2_Hallway_background.png"));
            background = new Tile(new Rectangle(0, 0, background_Image.getWidth(), background_Image.getHeight()), "Background", "", null, background_Image);

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        spawn_point1 = new Tile(new Rectangle(555 , 586 , 32 , 46), "", "", null, null);
        spawn_point2 = new Tile(new Rectangle(447 , 251 , 32 , 46), "", "", null, null);

        c2_hallEntry1 = new Tile(new Rectangle( 369 , 192 , 191 , 83 ), "C2_Hall_entry", "Teleport", null, null);
        c2_hallEntry2 = new Tile(new Rectangle( 568 , 191 , 190 , 84 ), "C2_Hall_entry", "Teleport", null, null);
        c2_hallEntry3 = new Tile(new Rectangle( 768 , 191 , 191 , 84 ), "C2_Hall_entry", "Teleport", null, null);
        addTile(new Tile(new Rectangle( 200 , 172 , 763 , 99 ), "wall", "Obstacle", null, null));
        addTile(c2_hallEntry1);
        addTile(c2_hallEntry2);
        addTile(c2_hallEntry3);
        addTile(new Tile(new Rectangle( 89 , 354 , 116 , 6 ), "fence", "Obstacle", null, null));
        addTile(new Tile(new Rectangle( 93 , 238 , 107 , 24 ), "fence", "Obstacle", null, null));
        addTile(new Tile(new Rectangle( 73 , 173 , 21 , 99 ), "pillar", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(491 , 605 , 159 , 34), "C2_Hallway_exit", "Teleport", null, null));

        addTile(new Tile(new Rectangle( 0 , 172 , 74 , 80 ), "map_barrier", "Obstacle", null, null));
        addTile(new Tile(new Rectangle( 0 , 411 , 67 , 37 ), "map_barrier", "Obstacle", null, null));
        addTile(new Tile(new Rectangle( 67 , 374 , 146 , 77 ), "map_barrier", "Obstacle", null, null));
        addTile(new Tile(new Rectangle( 212 , 442 , 255 , 218 ), "map_barrier", "Obstacle", null, null));
        addTile(new Tile(new Rectangle( 677 , 444 , 215 , 213 ), "map_barrier", "Obstacle", null, null));
        addTile(new Tile(new Rectangle( 748 , 435 , 129 , 49 ), "map_barrier", "Obstacle", null, null));
        addTile(new Tile(new Rectangle( 787 , 374 , 193 , 95 ), "map_barrier", "Obstacle", null, null));
    
        map_exchange_effect1 = new Animation_player(gamePanel, "res/effect/Map_exchange/type2/frame ", 4, 0.8, new Rectangle((int)(GamePanel.screenWidth / 4), (int)(GamePanel.screenHeight / 2 - GamePanel.screenWidth / 4), (int)(GamePanel.screenWidth / 2), (int)(GamePanel.screenWidth / 2)));
        map_exchange_effect2 = new Animation_player(gamePanel, "res/effect/Map_exchange/type3/frame ", 4, 0.8, new Rectangle((int)(GamePanel.screenWidth / 4), (int)(GamePanel.screenHeight / 2 - GamePanel.screenWidth / 4), (int)(GamePanel.screenWidth / 2), (int)(GamePanel.screenWidth / 2)));
    
    }

    @Override public void reSizeMap(){
        ReSize(gamePanel.player.getBoundingBoxHeight() * 1.0 * background.image.getHeight() / (50 * background.getHeight()));
    }

    public void open(String type){
        reSizeMap();

        if(type == "enter_from_stair"){ 
            SetPlayerPos(spawn_point1);
            map_exchange_effect = map_exchange_effect1;
        }
        else if(type == "enter_from_door"){
            SetPlayerPos(spawn_point2);
            map_exchange_effect = map_exchange_effect2;
        }
        loadMap(gamePanel);
    }

}


