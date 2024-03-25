package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    public int mapX, mapY;
    public int speed;
    public BufferedImage up1, up2, up3, stand_up;
    public BufferedImage down1, down2, down3, stand_down;
    public BufferedImage left1, left2, left3, stand_left;
    public BufferedImage right1, right2 , right3, stand_right;
    public String direction;
    public int stepCounter = 0;
    public int stepNum = 1;
    public Rectangle validArea;
    public int collisionOn = 0;
}
