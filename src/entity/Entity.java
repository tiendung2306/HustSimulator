package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    int mapX, mapY;
    int speed;
    int speedSlant;
    BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, standstill, upright1, upright2, upleft1, upleft2, downleft1, downleft2, downright1, downright2;
    String direction;
    boolean collisionOn = false;
    public int getMapX() {
        return mapX;
    }

    public void setMapX(int mapX) {
        this.mapX = mapX;
    }

    public int getMapY() {
        return mapY;
    }

    public void setMapY(int mapY) {
        this.mapY = mapY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Rectangle getValidArea() {
        return validArea;
    }

    public void setValidArea(Rectangle validArea) {
        this.validArea = validArea;
    }
    public int getBoundingBoxX(){ return boundingBox.x;}
    public int getBoundingBoxY(){ return boundingBox.y;}
    public int getBoundingBoxWidth(){ return boundingBox.width;}
    public int getBoundingBoxHeight(){ return boundingBox.height;}
    Rectangle validArea;
    public Rectangle boundingBox;
}
