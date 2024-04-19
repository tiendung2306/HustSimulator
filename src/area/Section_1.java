package area;

import main.GamePanel;
import map.Map;
import tile.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;


public class Section_1 extends Map {
    Tile background, C1, C2, C9;
    GamePanel gamePanel;


    public Section_1(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        TileLoad();
    }

    private void TileLoad() {
        tileContainer = new Tile[5];

        background = new Tile();
        BufferedImage bacImage;
        try {
            bacImage = ImageIO.read(new FileInputStream("res/tile/Section1_demo.png"));
            background.image = bacImage;
            background.setWidth(bacImage.getWidth());
            background.setHeight(bacImage.getHeight());
        } catch (IOException e) {
            e.printStackTrace();
        }

        C9 = new Tile(new Rectangle(101, 1720, 793, 389), "C9", "Obstacle", null, null);
        C2 = new Tile(new Rectangle(305, 754, 402, 965), "C2", "Obstacle", null, null);
        C1 = new Tile(new Rectangle(472, 238, 1716, 373), "C1", "Obstacle", null, null);

        addTile(background);
        addTile(C9);
        addTile(C2);
        addTile(C1);



    }

    // Phương thức vẽ map
    public void draw(Graphics2D g2) {

        gamePanel.tileManager.draw(g2, background);
        // for (int i = 0; i < numTileContainer; ++i)
        //     gamePanel.tileManager.draw(g2, tileContainer[i]);
    }
}
