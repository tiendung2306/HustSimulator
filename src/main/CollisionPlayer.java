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
    String[] typeCollision;
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
    public String defineType(int entityLeftX, int entityRightX, int entityBottomY, int entityTopY, int targetLeftX, int targetRightX, int targetBottomY, int targetTopY) {

        boolean cornerLeftTop = checkInside(entityLeftX, entityTopY, targetLeftX, targetRightX, targetBottomY, targetTopY);
        boolean cornerRightTop = checkInside(entityRightX, entityTopY, targetLeftX, targetRightX, targetBottomY, targetTopY);
        boolean cornerLeftBottom = checkInside(entityLeftX, entityBottomY, targetLeftX, targetRightX, targetBottomY, targetTopY);
        boolean cornerRightBottom = checkInside(entityRightX, entityBottomY, targetLeftX, targetRightX, targetBottomY, targetTopY);

        boolean reCornerLeftTop =  checkInside(targetLeftX, targetTopY, entityLeftX, entityRightX, entityBottomY, entityTopY);
        boolean reCornerRightTop =  checkInside(targetRightX, targetTopY, entityLeftX, entityRightX, entityBottomY, entityTopY);
        boolean reCornerLeftBottom =  checkInside(targetRightX, targetTopY, entityLeftX, entityRightX, entityBottomY, entityTopY);
        boolean reCornerRightBottom =  checkInside(targetRightX, targetTopY, entityLeftX, entityRightX, entityBottomY, entityTopY);

        if (cornerLeftTop && cornerRightTop && cornerLeftBottom && cornerRightBottom)
            return "inside";
        if ((cornerLeftTop && cornerRightTop) || (reCornerLeftBottom && reCornerRightBottom))
            return "top";
        if ((cornerLeftTop && cornerLeftBottom) || (reCornerRightBottom && reCornerRightTop))
            return "left";
        if ((cornerLeftBottom && cornerRightBottom) || (reCornerLeftTop && reCornerRightTop))
            return "bottom";
        if ((cornerRightTop && cornerRightBottom) || (reCornerLeftBottom && reCornerLeftTop))
            return "right";
        if (cornerLeftTop)
            return "left-top";
        if (cornerRightTop)
            return "right-top";
        if (cornerLeftBottom)
            return "left-bottom";
        if (cornerRightBottom)
            return "right-bottom";
        return "no-collision";
    }
    public void scanCollision(Entity entity, Map map){

        for (int  i = 0; i < map.numTileContainer; ++i) {
            Tile considerTile = map.tileContainer[i];
            int tileLeftX = considerTile.getLeftX();
            int tileRightX = considerTile.getRightX();
            int tileTopY = considerTile.getTopY();
            int tileBottomY = considerTile.getBottomY();

            int entityLeftX = entity.getMapX() + entity.getValidArea().x;
            int entityRightX = entity.getMapX() + entity.getValidArea().x + entity.getValidArea().width;
            int entityTopY = entity.getMapY() + entity.getValidArea().y;
            int entityBottomY = entity.getMapY() + entity.getValidArea().y + entity.getValidArea().height;

            String type = defineType(entityLeftX, entityRightX, entityTopY, entityBottomY, tileLeftX, tileRightX, tileBottomY, tileTopY);

            if (!type.equals("no-collision")) {
                collisionTile[++numCollision] = considerTile;
                typeCollision[numCollision] = type;
            }
        }
    }
}
