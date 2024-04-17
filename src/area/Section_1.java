package area;

import main.GamePanel;
import map.Map;
import tile.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;


public class Section_1 extends Map {
    Tile background;
    GamePanel gamePanel;


    public Section_1(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        TileLoad();
    }

    private void TileLoad() {
        background = new Tile();
        BufferedImage bacImage;
        try {
            bacImage = ImageIO.read(new FileInputStream("res/tile/Section1_demo.png"));
            background.image = bacImage;
            background.setWidth(bacImage.getWidth() );
            background.setHeight(bacImage.getHeight() );
        } catch (IOException e) {
            e.printStackTrace();
        }
        

    }

    // Phương thức vẽ map
    public void draw(Graphics2D g2) {

        gamePanel.tileManager.draw(g2, background);
        // for (int i = 0; i < numTileContainer; ++i)
        //     gamePanel.tileManager.draw(g2, tileContainer[i]);
    }
}
