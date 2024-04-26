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


        tileContainer = new Tile[50];
        background = new Tile();
        background.image = gamePanel.tileManager.tile[33].image;
        background.setWidth((int) (1000 * gamePanel.scale));
        background.setHeight((int) (1000 * gamePanel.scale));


        playerX = (int) (300 * gamePanel.scale);
        playerY = (int) (600 * gamePanel.scale);
        
        TileLoad();
    }

    private void TileLoad() {
        tileContainer = new Tile[5];

        background = new Tile();
        BufferedImage bacImage;
        try {
            bacImage = ImageIO.read(new FileInputStream("res/tile/Section2_demo.png"));
            background.image = bacImage;
            background.setWidth(bacImage.getWidth());
            background.setHeight(bacImage.getHeight());
        } catch (IOException e) {
            e.printStackTrace();
        }

        D3 = new Tile(new Rectangle(463, 1974, 1088, 387), "D3", "Obstacle", null, null);
        D5 = new Tile(new Rectangle(486, 1497, 1088, 390), "D5", "Obstacle", null, null);
        D9 = new Tile(new Rectangle(2030, 251, 1226, 402), "D9", "Obstacle", null, null);

        addTile(background);
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