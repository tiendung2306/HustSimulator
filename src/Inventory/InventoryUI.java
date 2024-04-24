package Inventory;
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
        int leftX, topY;
        int width, height;
        if (tile.getWidth() >= tile.getHeight()){
            leftX = boundingBox.x;
            width = boundingBox.width;
            height = width * tile.getHeight() / tile.getWidth();
            topY = boundingBox.y + (boundingBox.height - height) / 2;
        }
        else {
            topY = boundingBox.y;
            height = boundingBox.height;
            width = height * tile.getWidth() / tile.getHeight();
            leftX = boundingBox.x + (boundingBox.width - width) / 2;
        }
        g2.drawImage(tile.image, leftX, topY, width, height, null);
    }
}
