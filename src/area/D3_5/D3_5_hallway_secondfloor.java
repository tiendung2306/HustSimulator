package area.D3_5;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import animation.Animation_player;
import main.GamePanel;
import map.Map;
import tile.Tile;


public class D3_5_hallway_secondfloor extends Map {
    public int curr_floor = 2;
    Tile[] floor_layer = new Tile[5];
    public Tile d3_5_301_door;


    public D3_5_hallway_secondfloor(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        
        SetDefaultValues();
    }

    private void SetDefaultValues(){
        TileLoad();
        ObjectLoad("D3_5_Hallway");
        SetOriginalSize();
        reSizeMap();
        SetPlayerPos();
    }
    
    private void SetOriginalSize(){

        width = background.getWidth();
        height = background.getHeight();
    }

    private void ReSize(double scale){
        background.setWidth((int)(background.getWidth() * scale));
        background.setHeight((int)(background.getHeight() * scale));

        map_exchange_effect.resize(GamePanel.screenWidth / (2 * map_exchange_effect.getWidth()));

        for(int i = 1; i <= 4; i++){
            floor_layer[i].resize(scale);
        }

        for(int i = 0; i < numTileContainer; i++){
            tileContainer[i].resize(scale);

        }
        
        width = background.getWidth();
        height = background.getHeight();

    }

    private void SetPlayerPos(){
        playerX = (int) (width * 1.0 / 2);
        playerY = (int) (height * 1.0 / 2);
    }

    private void TileLoad() {
        tileContainer = new Tile[50];

        try {
            BufferedImage background_Image = ImageIO.read(new FileInputStream("res/tile/D3_5_hallway_secondfloor_layer(1).png"));
            background = new Tile(new Rectangle(0, 0, background_Image.getWidth(), background_Image.getHeight()), "background", "", null, background_Image);

            for(int i = 1; i <= 4; i++){
                int floor_index = i + 1;
                String path = "res/tile/D3-5_floor_layer(" + floor_index + ").png";
                BufferedImage floor_layer_Image = ImageIO.read(new FileInputStream(path));
                floor_layer[i] = new Tile(new Rectangle(0, 0, floor_layer_Image.getWidth(), floor_layer_Image.getHeight()), "floor_layer", "", null, floor_layer_Image);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        d3_5_301_door = new Tile(new Rectangle(318 , 72 , 36 , 52), "D3-5_...01", "Teleport", null, null);

        addTile(new Tile(new Rectangle( 0 , 124 , 258 , 49 ), "D3<-D3_5_secondfloor_link", "Teleport", null, null));
        addTile(new Tile(new Rectangle(0 , 0 , 796 , 122), "wall", "Obstacle", null, null));
        addTile(d3_5_301_door);
        addTile(new Tile(new Rectangle(451 , 70 , 36 , 54), "D3-5_...02", "Teleport", null, null));
        addTile(new Tile(new Rectangle(588 , 69 , 37 , 53), "D3-5_...03", "Teleport", null, null));
        addTile(new Tile(new Rectangle(721 , 70 , 36 , 54), "D3-5_...04", "Teleport", null, null));
    
        map_exchange_effect = new Animation_player(gamePanel, "res/effect/Map_exchange/type1/frame ", 4, 0.8, new Rectangle((int)(GamePanel.screenWidth / 4), (int)(GamePanel.screenHeight / 2 - GamePanel.screenWidth / 4), (int)(GamePanel.screenWidth / 2), (int)(GamePanel.screenWidth / 2)));
    
    }

    public void open(){
        reSizeMap();
        loadMap(gamePanel);
    }

    @Override public void reSizeMap(){
        ReSize(gamePanel.player.getBoundingBoxHeight() * 1.0 * background.image.getHeight(gamePanel) / (50 * background.getHeight()));
        
    }

    @Override public void floorDisplay(Graphics2D g2){
        gamePanel.tileManager.draw(g2, floor_layer[curr_floor - 1]);
    }

    // Phương thức vẽ map
    // @public void draw(Graphics2D g2) {
    //     gamePanel.tileManager.draw(g2, layer_1);
    //     gamePanel.tileManager.draw(g2, layer_2);

    //     // for (int i = 0; i < numTileContainer; ++i)
    //     //     gamePanel.tileManager.draw(g2, tileContainer[i]);
    // }
}
