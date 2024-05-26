package area.D3;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import animation.Animation_player;
import main.GamePanel;
import map.Map;
import tile.Tile;


public class D3_secondfloor_hallway extends Map {
    Tile spawn_point1, spawn_point2, spawn_point3;
    public int curr_floor = 2;
    public Tile d3_stair_up1, d3_stair_up2;
    public Tile d3_stair_down1, d3_stair_down2;
    public Tile d3_5_secondfloor_entry;


    public D3_secondfloor_hallway(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        
        SetDefaultValues();
    }

    private void SetDefaultValues(){
        TileLoad();
        ObjectLoad("D3_secondfloor_hallway");
        SetOriginalSize();
        reSizeMap();
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
        spawn_point3.resize(scale);


        for(int i = 0; i < numTileContainer; i++){
            tileContainer[i].resize(scale);

        }
        
        width = background.getWidth();
        height = background.getHeight();

    }

    private void SetPlayerPos(Tile spawn_point){
        playerX = spawn_point.getLeftX();
        playerY = spawn_point.getTopY();
    }

    private void TileLoad() {
        tileContainer = new Tile[50];

        try {
            BufferedImage background_Image = ImageIO.read(new FileInputStream("res/tile/D3_secondfloor_hallway_layer(1).png"));
            background = new Tile(new Rectangle(0, 0, background_Image.getWidth(), background_Image.getHeight()), "background", "", null, background_Image);

        } catch (IOException e) {
            e.printStackTrace();
        }

        spawn_point1 = new Tile(new Rectangle(291 , 252 , 28 , 44), "", "", null, null);
        spawn_point2 = new Tile(new Rectangle(327 , 399 , 30 , 47), "", "", null, null);
        spawn_point3 = new Tile(new Rectangle(1832 , 400 , 27 , 42), "", "", null, null);
        
        d3_stair_up1 = new Tile(new Rectangle(273 , 402 , 8 , 17), "D3_stair_up1", "Teleport", null, null);
        d3_stair_up2 = new Tile(new Rectangle(1891 , 427 , 7 , 27), "D3_stair_up2", "Teleport", null, null);
        d3_stair_down1 = new Tile(new Rectangle(1891 , 387 , 6 , 40), "D3_stair_down2", "Teleport", null, null);
        d3_stair_down2 = new Tile(new Rectangle(273 , 420 , 8 , 36), "D3_stair_down1", "Teleport", null, null);
        d3_5_secondfloor_entry = new Tile(new Rectangle(244 , 60 , 157 , 142), "D3->D3-5_secondfloor_link", "Teleport", null, null);
        addTile(d3_stair_up1);
        addTile(d3_stair_down1);
        addTile(d3_stair_up2);
        addTile(d3_stair_down2);
        addTile(d3_5_secondfloor_entry);


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
        reSizeMap();
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

    @Override public void reSizeMap(){
        ReSize(gamePanel.player.getBoundingBoxHeight() * 1.0 * background.image.getHeight() / (50 * background.getHeight()));
    }

    // // Phương thức vẽ map
    // public void draw(Graphics2D g2) {
    //     gamePanel.tileManager.draw(g2, layer_1);
    //     gamePanel.player.draw(g2);
    //     gamePanel.tileManager.draw(g2, layer_2);
    //     gamePanel.tileManager.draw(g2, layer_3);

    //     // for (int i = 0; i < numTileContainer; ++i)
    //     //     gamePanel.tileManager.draw(g2, tileContainer[i]);
    // }
}
