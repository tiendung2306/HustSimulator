package entity;

import java.awt.*;

public class Entity {

    int mapX, mapY;
    int speed, speedSlant;
    String direction;
    public String[] dialogue;
    public void setMapX(int mapX) {
        this.mapX = mapX;
    }

    public void setMapY(int mapY) {
        this.mapY = mapY;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getMapX() {
        return mapX;
    }

    public int getMapY() {
        return mapY;
    }

    public int getSpeed() {
        return speed;
    }

    public String getDirection() {
        return direction;
    }
    public Rectangle getHitArea() {
        return hitArea;
    }
    public int getBoundingBoxX(){ return boundingBox.x;}
    public int getBoundingBoxY(){ return boundingBox.y;}
    public int getBoundingBoxWidth(){ return boundingBox.width;}
    public int getBoundingBoxHeight(){ return boundingBox.height;}
    Rectangle hitArea;
    public Rectangle boundingBox;
}
