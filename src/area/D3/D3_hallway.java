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


public class D3_hallway extends Map {
    Tile spawn_point1, spawn_point2, spawn_point3;
    public Tile D3_1stfloor_stair1, D3_1stfloor_stair2;

    public D3_hallway(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        
        SetDefaultValues();
    }

    private void SetDefaultValues(){
        TileLoad();
        ObjectLoad("D3_hallway");
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
            BufferedImage background_Image = ImageIO.read(new FileInputStream("res/tile/D3_hallway_layer(1).png"));
            background = new Tile(new Rectangle(0, 0, background_Image.getWidth(), background_Image.getHeight()), "background", "", null, background_Image);

        } catch (IOException e) {
            e.printStackTrace();
        }

        spawn_point1 = new Tile(new Rectangle(335 , 399 , 32 , 49 ), "", "", null, null);
        spawn_point2 = new Tile(new Rectangle(1048 , 398 , 32 , 50), "", "", null, null);
        spawn_point3 = new Tile(new Rectangle(1780 , 388 , 35 , 54), "", "", null, null);

        D3_1stfloor_stair1 = new Tile(new Rectangle(299 , 358 , 9 , 44), "D3_1stfloor_stair1", "Teleport", null, null);
        D3_1stfloor_stair2 = new Tile(new Rectangle(1890 , 429 , 7 , 28), "D3_1stfloor_stair2", "Teleport", null, null);

        addTile(D3_1stfloor_stair1);
        addTile(D3_1stfloor_stair2);
        addTile(new Tile(new Rectangle(243 , 33 , 157 , 27), "D3_exit", "Teleport", null, null));
        addTile(new Tile(new Rectangle(378 , 410 , 24 , 47), "D3_exit", "Teleport", null, null));
        addTile(new Tile(new Rectangle(914 , 410 , 26 , 73), "D3_exit", "Teleport", null, null));
        addTile(new Tile(new Rectangle(940 , 453 , 261 , 44), "D3_exit", "Teleport", null, null));
        addTile(new Tile(new Rectangle(1201 , 410 , 30 , 74), "D3_exit", "Teleport", null, null));
        addTile(new Tile(new Rectangle(923 , 250 , 297 , 27), "D3_exit", "Teleport", null, null));
        addTile(new Tile(new Rectangle(1743 , 176 , 120 , 27), "D3_exit", "Teleport", null, null));
        addTile(new Tile(new Rectangle(1744 , 410 , 24 , 47), "D3_exit", "Teleport", null, null));

        addTile(new Tile(new Rectangle(1220 , 174 , 522 , 175), "wall", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(386 , 225 , 538 , 123), "wall", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(148 , 359 , 151 , 99), "wall", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(0 , 0 , 245 , 315), "wall", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(1861 , 181 , 28 , 253), "wall", "Obstacle", null, null));

        addTile(new Tile(new Rectangle(400 , 0 , 45 , 227), "map_barrier", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(0 , 458 , 404 , 33), "map_barrier", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(378 , 401 , 562 , 9), "map_barrier", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(1201 , 401 , 567 , 9), "map_barrier", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(1743 , 457 , 278 , 29), "map_barrier", "Obstacle", null, null));
        
        map_exchange_effect = new Animation_player(gamePanel, "res/effect/Map_exchange/type2/frame ", 4, 0.8, new Rectangle((int)(GamePanel.screenWidth / 4), (int)(GamePanel.screenHeight / 2 - GamePanel.screenWidth / 4), (int)(GamePanel.screenWidth / 2), (int)(GamePanel.screenWidth / 2)));

    }

    public void open(String type){
        reSizeMap();
        if(type == "enter_from_stair1"){
            SetPlayerPos(spawn_point1);
        }
        else if(type == "enter_from_stair2"){
            SetPlayerPos(spawn_point2);
        }
        else if(type == "enter_from_stair3"){
            SetPlayerPos(spawn_point3);
        }
        loadMap(gamePanel);
    }

    @Override public void reSizeMap(){
        ReSize(gamePanel.player.getBoundingBoxHeight() * 1.0 * background.image.getHeight() / (50 * background.getHeight()));
    }

    // Phương thức vẽ map
    // public void draw(Graphics2D g2) {
    //     gamePanel.tileManager.draw(g2, layer_1);
    //     gamePanel.tileManager.draw(g2, layer_2);
    //     gamePanel.tileManager.draw(g2, layer_3);

    //     // for (int i = 0; i < numTileContainer; ++i)
    //     //     gamePanel.tileManager.draw(g2, tileContainer[i]);
    // }
}
