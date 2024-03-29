package main;

import entity.Entity;
import tile.TileManager;
import tile.Tile;
import map.Map;

public class CollisionPlayer {
    GamePanel gamePanel;
    int numCollision;

    public int getNumCollision() {
        return numCollision;
    }

    public void setNumCollision(int numCollision) {
        this.numCollision = numCollision;
    }

    public Tile[] getCollisionTile() {
        return collisionTile;
    }

    public void setCollisionTile(Tile[] collisionTile) {
        this.collisionTile = collisionTile;
    }

    Tile[] collisionTile;
    TileManager tileManager;
    public CollisionPlayer(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        tileManager = new TileManager(gamePanel);
        numCollision = 0;
        collisionTile = new Tile[50];
    }
    boolean checkInside(int pointX, int pointY, int tileLeftX, int tileRightX, int tileBottomY, int tileTopY) {
        return (pointX >= tileLeftX && pointX <= tileRightX && pointY >= tileBottomY && pointY <= tileTopY);
    }
    public boolean checkCollision(int tileLeftX, int tileRightX, int tileBottomY, int tileTopY, int entityLeftX, int entityRightX, int entityTopY, int entityBottomY) {
        return ( checkInside(entityLeftX, entityBottomY, tileLeftX, tileRightX, tileBottomY, tileTopY) ||
                checkInside(entityLeftX, entityTopY, tileLeftX, tileRightX, tileBottomY, tileTopY) ||
                checkInside(entityRightX, entityBottomY, tileLeftX, tileRightX, tileBottomY, tileTopY) ||
                checkInside(entityRightX, entityTopY, tileLeftX, tileRightX, tileBottomY, tileTopY)  ||
                checkInside(tileLeftX, tileBottomY, entityLeftX, entityRightX, entityBottomY, entityTopY) ||
                checkInside(tileLeftX, tileTopY, entityLeftX, entityRightX, entityBottomY, entityTopY) ||
                checkInside(tileRightX, tileBottomY, entityLeftX, entityRightX, entityBottomY, entityTopY) ||
                checkInside(tileRightX, tileTopY, entityLeftX, entityRightX, entityBottomY, entityTopY) );
    }
    public void findTile(Entity entity, Map map){

        for (int  i = 0; i < map.numTileContainer; ++i) {
            Tile considerTile = map.tileContainer[i][map.mapIndex]; //?????????
            int tileLeftX = considerTile.getLeftX();
            int tileRightX = considerTile.getRightX();
            int tileTopY = considerTile.getTopY();
            int tileBottomY = considerTile.getBottomY();

            int entityLeftX = entity.getMapX() + entity.getValidArea().x;
            int entityRightX = entity.getMapX() + entity.getValidArea().x + entity.getValidArea().width;
            int entityTopY = entity.getMapY() + entity.getValidArea().y;
            int entityBottomY = entity.getMapY() + entity.getValidArea().y + entity.getValidArea().height;

            if (checkCollision(tileLeftX, tileRightX, tileBottomY, tileTopY, entityLeftX, entityRightX, entityTopY, entityBottomY))
                collisionTile[++numCollision] = considerTile;
        }
    }
}
