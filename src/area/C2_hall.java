package area;

import main.GamePanel;
import main.Main;
import map.Map;
import tile.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;


public class C2_hall extends Map {
    Tile background;
    GamePanel gamePanel;


    public C2_hall(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        
        SetDefaultValues();
    }

    private void SetDefaultValues(){
        TileLoad();
        SetOriginalSize();
        ReSize(gamePanel.player.getBoundingBoxHeight() * 1.0 * 1000 / (50 * background.getHeight()));
        SetPlayerPos();
    }
    
    private void SetOriginalSize(){

        width = background.getWidth();
        height = background.getHeight();
    }

    private void ReSize(double scale){
        background.setWidth((int)(background.getWidth() * scale));
        background.setHeight((int)(background.getHeight() * scale));



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
        tileContainer = new Tile[5];

        try {
            BufferedImage bacImage = ImageIO.read(new FileInputStream("res/tile/C2_hall.png"));
            background = new Tile(new Rectangle(0, 0, bacImage.getWidth(), bacImage.getHeight()), "Background", "", null, bacImage);

        } catch (IOException e) {
            e.printStackTrace();
        }




    }

    public void open(){
        Main.pushGameState("Section");
        loadMap(gamePanel);
    }

    public void close(){
        Main.popGameState();
    }

    // Phương thức vẽ map
    public void draw(Graphics2D g2) {
        gamePanel.tileManager.draw(g2, background);
        // for (int i = 0; i < numTileContainer; ++i)
        //     gamePanel.tileManager.draw(g2, tileContainer[i]);
    }
}
