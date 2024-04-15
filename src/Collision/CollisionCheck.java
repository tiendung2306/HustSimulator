package Collision;

import entity.Entity;
import main.GamePanel;
import tile.Tile;
import map.Map;

public class CollisionCheck {
    GamePanel gamePanel;
    int numCollision;

    int[] tileIndex;
    Tile[] collisionTile;
    String[] typeCollision;
    public CollisionCheck(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        collisionTile = new Tile[50];
        typeCollision = new String[50];
        tileIndex = new int[50];
    }
    boolean checkInside(int pointX, int pointY, int tileLeftX, int tileRightX, int tileTopY, int tileBottomY) {
        return (pointX >= tileLeftX && pointX <= tileRightX && pointY >= tileTopY && pointY <= tileBottomY);
    }
    public String defineType(int entityLeftX, int entityRightX, int entityTopY, int entityBottomY, int targetLeftX, int targetRightX, int targetTopY, int targetBottomY) {

        boolean cornerLeftTop = checkInside(entityLeftX, entityTopY, targetLeftX, targetRightX, targetTopY, targetBottomY);
        boolean cornerRightTop = checkInside(entityRightX, entityTopY, targetLeftX, targetRightX, targetTopY, targetBottomY);
        boolean cornerLeftBottom = checkInside(entityLeftX, entityBottomY, targetLeftX, targetRightX, targetTopY, targetBottomY);
        boolean cornerRightBottom = checkInside(entityRightX, entityBottomY, targetLeftX, targetRightX, targetTopY, targetBottomY);

        boolean reCornerLeftTop =  checkInside(targetLeftX, targetTopY, entityLeftX, entityRightX, entityTopY, entityBottomY);
        boolean reCornerRightTop =  checkInside(targetRightX, targetTopY, entityLeftX, entityRightX, entityTopY, entityBottomY);
        boolean reCornerLeftBottom =  checkInside(targetLeftX, targetBottomY, entityLeftX, entityRightX, entityTopY, entityBottomY);
        boolean reCornerRightBottom =  checkInside(targetRightX, targetBottomY, entityLeftX, entityRightX, entityTopY, entityBottomY);

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
        numCollision = 0;
        for (int  i = 0; i < map.numTileContainer; ++i) {
            Tile considerTile = map.tileContainer[i];
            int tileLeftX = considerTile.getLeftX();
            int tileRightX = considerTile.getRightX();
            int tileTopY = considerTile.getTopY();
            int tileBottomY = considerTile.getBottomY();

            int entityLeftX = entity.getHitArea().x;
            int entityRightX = entity.getHitArea().x + entity.getHitArea().width;
            int entityTopY = entity.getHitArea().y;
            int entityBottomY = entity.getHitArea().y + entity.getHitArea().height;

            String type = defineType(entityLeftX, entityRightX, entityTopY, entityBottomY, tileLeftX, tileRightX, tileTopY, tileBottomY);
            if (!type.equals("no-collision")) {
                collisionTile[numCollision] = considerTile;
                tileIndex[numCollision] = i;
                typeCollision[numCollision++] = type;
            }
        }
    }
}
