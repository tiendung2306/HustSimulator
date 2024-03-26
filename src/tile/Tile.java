package tile;

import java.awt.image.BufferedImage;

public class Tile {
    public BufferedImage image;
    int LeftX, RightX, BottomY, TopY;
    int speed;
    String direction;
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

    public int getBottomY() {
        return BottomY;
    }

    public void setBottomY(int bottomY) {
        BottomY = bottomY;
    }

    public int getTopY() {
        return TopY;
    }

    public void setTopY(int topY) {
        TopY = topY;
    }
}
