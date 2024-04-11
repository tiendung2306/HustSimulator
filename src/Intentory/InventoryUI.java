package Intentory;
import tile.Tile;
import java.awt.*;
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
        //g2.drawRect(screenX, screenY, width, height);
    }
    public void drawIcon(Graphics2D g2, Rectangle boundingBox, Tile tile){
        g2.drawImage(tile.image, boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height, null);
    }
}
