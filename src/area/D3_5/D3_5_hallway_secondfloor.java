package area.D3_5;

import main.GamePanel;
import main.Main;
import map.Map;
import tile.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;


public class D3_5_hallway_secondfloor extends Map {
    Tile layer_1, layer_2;
    GamePanel gamePanel;
    public int curr_floor = 2;
    Tile[] floor_layer = new Tile[5];


    public D3_5_hallway_secondfloor(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        
        SetDefaultValues();
    }

    private void SetDefaultValues(){
        TileLoad();
        SetOriginalSize();
        ReSize(gamePanel.player.getBoundingBoxHeight() * 1.0 * layer_1.image.getHeight(gamePanel) / (50 * layer_1.getHeight()));
        SetPlayerPos();
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

        for(int i = 1; i <= 4; i++){
            floor_layer[i].resize(scale);
        }

        for(int i = 0; i < numTileContainer; i++){
            tileContainer[i].resize(scale);

        }
        
        width = layer_1.getWidth();
        height = layer_1.getHeight();

    }

    private void SetPlayerPos(){
        playerX = (int) (width * 1.0 / 2);
        playerY = (int) (height * 1.0 / 2);
    }

    private void TileLoad() {
        tileContainer = new Tile[50];

        try {
            BufferedImage layer_1_Image = ImageIO.read(new FileInputStream("res/tile/D3_5_hallway_secondfloor_layer(1).png"));
            layer_1 = new Tile(new Rectangle(0, 0, layer_1_Image.getWidth(), layer_1_Image.getHeight()), "layer_1", "", null, layer_1_Image);
            BufferedImage layer_2_Image = ImageIO.read(new FileInputStream("res/tile/D3_5_hallway_secondfloor_layer(2).png"));
            layer_2 = new Tile(new Rectangle(0, 0, layer_2_Image.getWidth(), layer_2_Image.getHeight()), "layer_2", "", null, layer_2_Image);
            
            for(int i = 1; i <= 4; i++){
                int floor_index = i + 1;
                String path = "res/tile/D3-5_floor_layer(" + floor_index + ").png";
                BufferedImage floor_layer_Image = ImageIO.read(new FileInputStream(path));
                floor_layer[i] = new Tile(new Rectangle(0, 0, floor_layer_Image.getWidth(), floor_layer_Image.getHeight()), "floor_layer", "", null, floor_layer_Image);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        addTile(new Tile(new Rectangle( 0 , 124 , 258 , 49 ), "D3<-D3_5_secondfloor_link", "Teleport", null, null));
        addTile(new Tile(new Rectangle(0 , 0 , 796 , 122), "wall", "Obstacle", null, null));
        addTile(new Tile(new Rectangle(318 , 72 , 36 , 52), "D3-5_...01", "Teleport", null, null));
        addTile(new Tile(new Rectangle(451 , 70 , 36 , 54), "D3-5_...02", "Teleport", null, null));
        addTile(new Tile(new Rectangle(588 , 69 , 37 , 53), "D3-5_...03", "Teleport", null, null));
        addTile(new Tile(new Rectangle(721 , 70 , 36 , 54), "D3-5_...04", "Teleport", null, null));
    }

    public void open(){
        loadMap(gamePanel);
    }

    // Phương thức vẽ map
    public void draw(Graphics2D g2) {
        gamePanel.tileManager.draw(g2, layer_1);
        gamePanel.tileManager.draw(g2, floor_layer[curr_floor - 1]);
        gamePanel.tileManager.draw(g2, layer_2);

        // for (int i = 0; i < numTileContainer; ++i)
        //     gamePanel.tileManager.draw(g2, tileContainer[i]);
    }
}
