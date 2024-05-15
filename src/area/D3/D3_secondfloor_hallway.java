package area.D3;

import main.GamePanel;
import map.Map;
import tile.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import animation.Animation_player;

import java.io.*;


public class D3_secondfloor_hallway extends Map {
    Tile layer_1, layer_2, layer_3;
    Tile spawn_point1, spawn_point2, spawn_point3;
    GamePanel gamePanel;
    public int curr_floor = 2;


    public D3_secondfloor_hallway(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        
        SetDefaultValues();
    }

    private void SetDefaultValues(){
        TileLoad();
        SetOriginalSize();
        ReSize(gamePanel.player.getBoundingBoxHeight() * 1.0 * layer_1.image.getHeight() / (50 * layer_1.getHeight()));
    }
    
    private void SetOriginalSize(){

        width = layer_1.getWidth();
        height = layer_1.getHeight();
    }

    private void ReSize(double scale){
        layer_1.setWidth((int)(layer_1.getWidth() * scale));
        layer_1.setHeight((int)(layer_1.getHeight() * scale));

        layer_2.setWidth((int)(layer_2.getWidth() * scale));
        layer_2.setHeight((int)(layer_2.getHeight() * scale));

        layer_3.setWidth((int)(layer_3.getWidth() * scale));
        layer_3.setHeight((int)(layer_3.getHeight() * scale));

        spawn_point1.resize(scale);
        spawn_point2.resize(scale);
        spawn_point3.resize(scale);


        for(int i = 0; i < numTileContainer; i++){
            tileContainer[i].resize(scale);

        }
        
        width = layer_1.getWidth();
        height = layer_1.getHeight();

    }

    private void SetPlayerPos(Tile spawn_point){
        playerX = spawn_point.getLeftX();
        playerY = spawn_point.getTopY();
    }

    private void TileLoad() {
        tileContainer = new Tile[50];

        try {
            BufferedImage layer_1_Image = ImageIO.read(new FileInputStream("res/tile/D3_secondfloor_hallway_layer(1).png"));
            layer_1 = new Tile(new Rectangle(0, 0, layer_1_Image.getWidth(), layer_1_Image.getHeight()), "layer_1", "", null, layer_1_Image);
            BufferedImage layer_2_Image = ImageIO.read(new FileInputStream("res/tile/D3_secondfloor_hallway_layer(2).png"));
            layer_2 = new Tile(new Rectangle(0, 0, layer_2_Image.getWidth(), layer_2_Image.getHeight()), "layer_2", "", null, layer_2_Image);
            BufferedImage layer_3_Image = ImageIO.read(new FileInputStream("res/tile/D3_secondfloor_hallway_layer(3).png"));
            layer_3 = new Tile(new Rectangle(0, 0, layer_3_Image.getWidth(), layer_3_Image.getHeight()), "layer_3", "", null, layer_3_Image);

        } catch (IOException e) {
            e.printStackTrace();
        }

        spawn_point1 = new Tile(new Rectangle(291 , 252 , 28 , 44), "", "", null, null);
        spawn_point2 = new Tile(new Rectangle(327 , 399 , 30 , 47), "", "", null, null);
        spawn_point3 = new Tile(new Rectangle(1832 , 400 , 27 , 42), "", "", null, null);
        
        addTile(new Tile(new Rectangle(273 , 402 , 8 , 17), "D3_stair_up1", "Teleport", null, null));
        addTile(new Tile(new Rectangle(1891 , 387 , 6 , 40), "D3_stair_down2", "Teleport", null, null));
        addTile(new Tile(new Rectangle(1891 , 427 , 7 , 27), "D3_stair_up2", "Teleport", null, null));
        addTile(new Tile(new Rectangle(273 , 420 , 8 , 36), "D3_stair_down1", "Teleport", null, null));
        addTile(new Tile(new Rectangle(244 , 60 , 157 , 142), "D3->D3-5_secondfloor_link", "Teleport", null, null));


        addTile(new Tile(new Rectangle(388 , 225 , 1357 , 126), "wall", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(1672 , 173 , 71 , 51), "wall", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(1863 , 180 , 157 , 207), "wall", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(0 , 0 , 245 , 314), "wall", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(149 , 382 , 129 , 75), "wall", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(277 , 382 , 32 , 19), "wall", "Obstacle", null, null));

        addTile(new Tile(new Rectangle(402 , 4 , 20 , 220), "map_barrier", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(0 , 456 , 401 , 19), "map_barrier", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(379 , 399 , 1391 , 76), "map_barrier", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(1743 , 455 , 278 , 21), "map_barrier", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(1743 , 172 , 119 , 31), "map_barrier", "Obstacle", null, null));
    
        map_exchange_effect = new Animation_player(gamePanel, "res/effect/Map_exchange/type2/frame ", 4, 0.8, new Rectangle((int)(GamePanel.screenWidth / 4), (int)(GamePanel.screenHeight / 2 - GamePanel.screenWidth / 4), (int)(GamePanel.screenWidth / 2), (int)(GamePanel.screenWidth / 2)));

    
    }

    public void open(String type){
        if(type == "enter_from_stair1"){
            SetPlayerPos(spawn_point2);
        }
        else if(type == "enter_from_stair2"){
            SetPlayerPos(spawn_point3);
        }
        else if(type == "enter_from_D3_5"){
            SetPlayerPos(spawn_point1);
        }
        loadMap(gamePanel);
    }

    // Phương thức vẽ map
    public void draw(Graphics2D g2) {
        gamePanel.tileManager.draw(g2, layer_1);
        gamePanel.player.draw(g2);
        gamePanel.tileManager.draw(g2, layer_2);
        gamePanel.tileManager.draw(g2, layer_3);

        // for (int i = 0; i < numTileContainer; ++i)
        //     gamePanel.tileManager.draw(g2, tileContainer[i]);
    }
}
