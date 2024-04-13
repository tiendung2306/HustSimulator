package tile;

import java.awt.image.BufferedImage;

public class Tile{
    public BufferedImage image;
    public String Name;
    public int numOwn;
    public String Type;
    public String Description;
    int LeftX, RightX, TopY, BottomY;

    int width, height;

    public Tile() {

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
