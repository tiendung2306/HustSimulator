package Collision;

import entity.Entity;
import main.GamePanel;
import tile.ExtraTile;
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
    boolean ccw(int xO, int yO, int xA, int yA, int xB, int yB){
        return ((xA - xO) * (yB - yO) <= (yA - yO) * (xB - xO));

    }
    boolean checkInside(int pointX, int pointY, int tileLeftX, int tileRightX, int tileTopY, int tileBottomY) {
        return (pointX >= tileLeftX && pointX <= tileRightX && pointY >= tileTopY && pointY <= tileBottomY);
    }
    boolean checkInsidePolygon(int pointX, int pointY, ExtraTile extraTile){
        for (int i = 0; i < extraTile.numPoint; ++i)
            if (!ccw(pointX, pointY, extraTile.x[i], extraTile.y[i], extraTile.x[i + 1], extraTile.y[i + 1]))
                return false;
        return true;
    }
    public String defineExtraTile(int entityLeftX, int entityRightX, int entityTopY, int entityBottomY, ExtraTile extraTile){
        boolean cornerLeftTop = checkInsidePolygon(entityLeftX, entityTopY, extraTile);
        boolean cornerRightTop = checkInsidePolygon(entityRightX, entityTopY, extraTile);
        boolean cornerLeftBottom = checkInsidePolygon(entityLeftX, entityBottomY, extraTile);
        boolean cornerRightBottom = checkInsidePolygon(entityRightX, entityBottomY, extraTile);
        if (cornerLeftTop || cornerRightTop || cornerLeftBottom || cornerRightBottom)
            return "collision";
        for (int i = 0; i < extraTile.numPoint; ++i)
            if (checkInside(extraTile.x[i], extraTile.y[i], entityLeftX, entityRightX, entityTopY, entityBottomY))
                return "collision";
        return "no-collision";

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
                if(considerTile.Type == "Marker")
                    considerTile.isCollision = false;

                else{

                    collisionTile[numCollision] = considerTile;
                    collisionTile[numCollision].isCollision = true;
                    tileIndex[numCollision] = i;
                    typeCollision[numCollision++] = type;
                }
            }
            else considerTile.isCollision = false;
        }
        for (int i = 0; i < map.numExtraTile; ++i){
            ExtraTile extraTile = map.extraTile[i];
            int entityLeftX = entity.getHitArea().x;
            int entityRightX = entity.getHitArea().x + entity.getHitArea().width;
            int entityTopY = entity.getHitArea().y;
            int entityBottomY = entity.getHitArea().y + entity.getHitArea().height;

            String type = defineExtraTile(entityLeftX,entityRightX,entityTopY,entityBottomY,extraTile);
            if (!type.equals("no-collision")){
                collisionTile[numCollision] = extraTile;
                collisionTile[numCollision].isCollision = true;
                typeCollision[numCollision++] = type;
            }
        }
    }
}
