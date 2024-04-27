package area;

import main.GamePanel;
import map.Map;
import tile.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class Section_2 extends Map {
    Tile background, D3, D5, D3_5, D7, D9;
    GamePanel gamePanel;


    public Section_2(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        
        SetDefaultValues();
    }

    private void SetDefaultValues(){
        TileLoad();
        SetOriginalSize();
        ReSize(gamePanel.player.getBoundingBoxHeight() * 1.0 * 2605 / (40 * background.getHeight()));
        SetPlayerPos();
    }

    private void SetOriginalSize(){
        background.setWidth(background.image.getWidth());
        background.setHeight(background.image.getHeight());

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
            BufferedImage bacImage = ImageIO.read(new FileInputStream("res/tile/Section2_demo.png"));
            background = new Tile(new Rectangle(0, 0, bacImage.getWidth(), bacImage.getHeight()), "Background", "", null, bacImage);

        } catch (IOException e) {
            e.printStackTrace();
        }

        D3 = new Tile(new Rectangle(463, 1974, 1088, 387), "D3", "Obstacle", null, null);
        D5 = new Tile(new Rectangle(486, 1497, 1088, 390), "D5", "Obstacle", null, null);
        D9 = new Tile(new Rectangle(2030, 251, 1226, 402), "D9", "Obstacle", null, null);

        addTile(D3);
        addTile(D5);
        addTile(D9);


    }


    // Phương thức vẽ map
    public void draw(Graphics2D g2) {
        gamePanel.tileManager.draw(g2, background);

        // for (int i = 0; i < numTileContainer; ++i)
        //     gamePanel.tileManager.draw(g2, tileContainer[i]);
    }
}