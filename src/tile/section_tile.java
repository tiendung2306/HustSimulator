package tile;

import javax.print.DocFlavor.STRING;
import java.awt.image.BufferedImage;
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
        setLeftX(x * gamePanel.scale);
        setTopY(y * gamePanel.scale);
        setRightX((x+20) * gamePanel.scale);
        setBottomY((y+46) * gamePanel.scale);
        setWidth(20 * gamePanel.scale);
        setHeight(46 * gamePanel.scale);
    }

}

