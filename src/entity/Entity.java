package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    int mapX, mapY;
    int speed;
    int speedSlant;
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

    public Rectangle getHitArea() {
        return hitArea;
    }

    public void setHitArea(Rectangle validArea) {
        this.hitArea = validArea;
    }
    public int getBoundingBoxX(){ return boundingBox.x;}
    public int getBoundingBoxY(){ return boundingBox.y;}
    public int getBoundingBoxWidth(){ return boundingBox.width;}
    public int getBoundingBoxHeight(){ return boundingBox.height;}
    Rectangle hitArea;
    public Rectangle boundingBox;
}