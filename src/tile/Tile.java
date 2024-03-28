package tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    public BufferedImage image;
    int LeftX;
    int RightX ;
    int TopY;
    int BottomY;
    int speed;
    String direction;

    public Tile() {

    }

    public Tile(int leftX, int rightX, int topY, int bottomY) {
        LeftX = leftX;
        RightX = rightX;
        TopY = topY;
        BottomY = bottomY;
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
}
