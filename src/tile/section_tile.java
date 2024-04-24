package tile;

import javax.imageio.ImageIO;
import java.io.*;
import main.GamePanel;

public class section_tile extends Tile {
    public int x,y, w, h;
    GamePanel gamePanel;
    public section_tile(GamePanel gamePanel, int x, int y, String name, String type, int w, int h, String image_path) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        this.gamePanel=gamePanel;
        Name = "Table Classroom";
        Type = "Obstacle";
        try {
            image = ImageIO.read(new FileInputStream(image_path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BoundingBox();
    }

    public void BoundingBox() {
        setLeftX((int) (x * GamePanel.scale));
        setTopY((int) (y * GamePanel.scale));
        setRightX((int) ((x+20) * GamePanel.scale));
        setBottomY((int) ((y+46) * GamePanel.scale));
        setWidth((int) (20 * GamePanel.scale));
        setHeight((int) (46 * GamePanel.scale));
    }

}

