package area.D3;

import main.GamePanel;
import main.Main;
import map.Map;
import tile.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;


public class D3_hallway extends Map {
    Tile layer_1, layer_2, layer_3;
    Tile spawn_point;
    GamePanel gamePanel;


    public D3_hallway(GamePanel gamePanel) {
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

        spawn_point.resize(scale);

        for(int i = 0; i < numTileContainer; i++){
            tileContainer[i].resize(scale);

        }
        
        width = layer_1.getWidth();
        height = layer_1.getHeight();

        SetPlayerPos();

    }

    private void SetPlayerPos(){
        playerX = spawn_point.getLeftX();
        playerY = spawn_point.getTopY();
    }

    private void TileLoad() {
        tileContainer = new Tile[50];

        try {
            BufferedImage layer_1_Image = ImageIO.read(new FileInputStream("res/tile/D3_hallway_layer(1).png"));
            layer_1 = new Tile(new Rectangle(0, 0, layer_1_Image.getWidth(), layer_1_Image.getHeight()), "layer_1", "", null, layer_1_Image);
            BufferedImage layer_2_Image = ImageIO.read(new FileInputStream("res/tile/D3_hallway_layer(2).png"));
            layer_2 = new Tile(new Rectangle(0, 0, layer_2_Image.getWidth(), layer_2_Image.getHeight()), "layer_2", "", null, layer_2_Image);
            BufferedImage layer_3_Image = ImageIO.read(new FileInputStream("res/tile/D3_hallway_layer(3).png"));
            layer_3 = new Tile(new Rectangle(0, 0, layer_3_Image.getWidth(), layer_3_Image.getHeight()), "layer_3", "", null, layer_3_Image);

        } catch (IOException e) {
            e.printStackTrace();
        }

        spawn_point = new Tile(new Rectangle(1042 , 397 , 36 , 52), "", "", null, null);

        addTile(new Tile(new Rectangle(299 , 358 , 9 , 44), "D3_1stfloor_stair", "Teleport", null, null));
        addTile(new Tile(new Rectangle(1890 , 429 , 7 , 28), "D3_1stfloor_stair", "Teleport", null, null));
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


    }

    public void open(){
        loadMap(gamePanel);
    }

    // Phương thức vẽ map
    public void draw(Graphics2D g2) {
        gamePanel.tileManager.draw(g2, layer_1);
        gamePanel.tileManager.draw(g2, layer_2);
        gamePanel.tileManager.draw(g2, layer_3);

        // for (int i = 0; i < numTileContainer; ++i)
        //     gamePanel.tileManager.draw(g2, tileContainer[i]);
    }
}
