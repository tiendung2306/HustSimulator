package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    public int mapX, mapY;
    public int speed;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;
    public int stepCounter = 0;
    public int stepNum = 1;
    public Rectangle validArea;
    public int collisionOn = 0;
}
