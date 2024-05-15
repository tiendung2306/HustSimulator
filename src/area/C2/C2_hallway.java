package area.C2;

import main.GamePanel;
import map.Map;
import tile.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import animation.Animation_player;

import java.io.*;


public class C2_hallway extends Map {
    GamePanel gamePanel;
    Tile first_floor, second_floor;
    Tile spawn_point1, spawn_point2;
    Animation_player map_exchange_effect1, map_exchange_effect2;


    public C2_hallway(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        
        SetDefaultValues();
    }

    private void SetDefaultValues(){
        TileLoad();
        SetOriginalSize();
        ReSize(gamePanel.player.getBoundingBoxHeight() * 1.0 * first_floor.image.getHeight() / (50 * first_floor.getHeight()));
    }
    
    private void SetOriginalSize(){

        width = first_floor.getWidth();
        height = first_floor.getHeight();
    }

    private void ReSize(double scale){
        first_floor.setWidth((int)(first_floor.getWidth() * scale));
        first_floor.setHeight((int)(first_floor.getHeight() * scale));

        second_floor.setWidth((int)(second_floor.getWidth() * scale));
        second_floor.setHeight((int)(second_floor.getHeight() * scale));

        spawn_point1.resize(scale);
        spawn_point2.resize(scale);


        for(int i = 0; i < numTileContainer; i++){
            tileContainer[i].resize(scale);

        }
        
        width = first_floor.getWidth();
        height = first_floor.getHeight();

    }

    private void SetPlayerPos(Tile spawn_point){
        playerX = spawn_point.LeftX;
        playerY = spawn_point.TopY;
    }

    private void TileLoad() {
        tileContainer = new Tile[15];

        try {
            BufferedImage first_floor_Image = ImageIO.read(new FileInputStream("res/tile/C2_hallway (1).png"));
            first_floor = new Tile(new Rectangle(0, 0, first_floor_Image.getWidth(), first_floor_Image.getHeight()), "Background", "", null, first_floor_Image);
            BufferedImage second_floor_Image = ImageIO.read(new FileInputStream("res/tile/C2_hallway (2).png"));
            second_floor = new Tile(new Rectangle(0, 0, second_floor_Image.getWidth(), second_floor_Image.getHeight()), "Background", "", null, second_floor_Image);

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        spawn_point1 = new Tile(new Rectangle(555 , 586 , 32 , 46), "", "", null, null);
        spawn_point2 = new Tile(new Rectangle(447 , 251 , 32 , 46), "", "", null, null);

        addTile(new Tile(new Rectangle( 200 , 172 , 763 , 99 ), "wall", "Obstacle", null, null));
        addTile(new Tile(new Rectangle( 369 , 192 , 191 , 83 ), "C2_Hall_entry", "Teleport", null, null));
        addTile(new Tile(new Rectangle( 568 , 191 , 190 , 84 ), "C2_Hall_entry", "Teleport", null, null));
        addTile(new Tile(new Rectangle( 768 , 191 , 191 , 84 ), "C2_Hall_entry", "Teleport", null, null));
        addTile(new Tile(new Rectangle( 93 , 238 , 107 , 24 ), "fence", "Obstacle", null, null));
        addTile(new Tile(new Rectangle( 73 , 173 , 21 , 99 ), "pillar", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(492 , 639 , 158 , 26), "C2_Hallway_exit", "Teleport", null, null));

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

    public void open(String type){
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

    // Phương thức vẽ map
    public void draw(Graphics2D g2) {
        gamePanel.tileManager.draw(g2, first_floor);
        // gamePanel.tileManager.draw(g2, second_floor);

        // for (int i = 0; i < numTileContainer; ++i)
        //     gamePanel.tileManager.draw(g2, tileContainer[i]);
    }
}


