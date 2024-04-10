package Intentory;
import tile.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import main.GamePanel;

public class InventoryUI {
    GamePanel gamePanel;
    public InventoryUI(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    public void draw(Graphics2D g2, InventoryComponent comp) {
        int screenX = comp.BoundingBox.x;
        int screenY = comp.BoundingBox.y;
        int width = comp.BoundingBox.width;
        int height = comp.BoundingBox.height;
        g2.drawImage(comp.image, screenX, screenY, width, height, null);
    }
}
