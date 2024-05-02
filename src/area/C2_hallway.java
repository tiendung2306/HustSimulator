package area;

import main.GamePanel;
import main.Main;
import map.Map;
import tile.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;


public class C2_hallway extends Map {
    Tile first_floor, second_floor;
    GamePanel gamePanel;


    public C2_hallway(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        
        SetDefaultValues();
    }

    private void SetDefaultValues(){
        TileLoad();
        SetOriginalSize();
        ReSize(gamePanel.player.getBoundingBoxHeight() * 1.0 * 1000 / (50 * first_floor.getHeight()));
        SetPlayerPos();
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

        for(int i = 0; i < numTileContainer; i++){
            tileContainer[i].resize(scale);

        }
        
        width = first_floor.getWidth();
        height = first_floor.getHeight();

    }

    private void SetPlayerPos(){
        playerX = (int) (width * 1.0 / 2);
        playerY = (int) (height * 1.0 / 2);
    }

    private void TileLoad() {
        tileContainer = new Tile[5];

        try {
            BufferedImage first_floor_Image = ImageIO.read(new FileInputStream("res/tile/C2_hallway (1).png"));
            first_floor = new Tile(new Rectangle(0, 0, first_floor_Image.getWidth(), first_floor_Image.getHeight()), "Background", "", null, first_floor_Image);
            BufferedImage second_floor_Image = ImageIO.read(new FileInputStream("res/tile/C2_hallway (2).png"));
            second_floor = new Tile(new Rectangle(0, 0, second_floor_Image.getWidth(), second_floor_Image.getHeight()), "Background", "", null, second_floor_Image);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void open(){
        Main.pushGameState("GamePlay");
        loadMap(gamePanel);
    }

    public void close(){
        Main.popGameState();
    }

    // Phương thức vẽ map
    public void draw(Graphics2D g2) {
        gamePanel.tileManager.draw(g2, first_floor);
        gamePanel.tileManager.draw(g2, second_floor);

        // for (int i = 0; i < numTileContainer; ++i)
        //     gamePanel.tileManager.draw(g2, tileContainer[i]);
    }
}
