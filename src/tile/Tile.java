package tile;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class Tile{
    public BufferedImage image;
    public String Name;
    public int numOwn;
    public String Type;
    public String Description;
    int LeftX, RightX, TopY, BottomY;

    int width, height;
    public boolean isCollision;
    public boolean isMission;

    public Tile() {
        Name = "Empty";
    }
    public void copyTile(Tile tile){
        Name = tile.Name;
        image = tile.image;
        numOwn = tile.numOwn;
        Type = tile.Type;
        Description = tile.Description;
        width = tile.width;
        height = tile.height;
    }

    public Tile(int leftX, int rightX, int topY, int bottomY, String name, String type, String description, BufferedImage image) {
        LeftX = leftX;
        RightX = rightX;
        TopY = topY;
        BottomY = bottomY;
        width = rightX - leftX;
        height = bottomY - topY;
        numOwn = 0;
        Name = name;
        Type = type;
        Description = description;
        this.image = image;
    }

    public Tile(Rectangle box, String name, String type, String description, BufferedImage image) {
        LeftX = box.x;
        RightX = box.x + box.width;
        TopY = box.y;
        BottomY = box.y + box.height;
        width = box.width;
        height = box.height;
        numOwn = 0;
        Name = name;
        Type = type;
        Description = description;
        this.image = image;
    }

    

    public int getLeftX() {
        return LeftX;
    }

    public void setLeftX(int leftX) {
        LeftX = leftX;
    }

    public int getRightX() {
        return RightX;
    }

    public void setRightX(int rightX) {
        RightX = rightX;
    }

    public int getTopY() {
        return TopY;
    }

    public void setTopY(int topY) {
        TopY = topY;
    }

    public int getBottomY() {
        return BottomY;
    }

    public void setBottomY(int bottomY) {
        BottomY = bottomY;
    }
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
