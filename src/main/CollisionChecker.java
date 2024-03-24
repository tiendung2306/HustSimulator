package main;

import entity.Entity;

public class CollisionChecker {
    GamePanel gp;
    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }
    public void checkTile(Entity entity){

        int entityLeftMapX = entity.mapX + entity.validArea.x;
        int entityRightMapX = entity.mapX + entity.validArea.x + entity.validArea.width;
        int entityTopMapY = entity.mapY + entity.validArea.y;
        int entityBottomMapY = entity.mapY + entity.validArea.y + entity.validArea.height;

        int entityLeftCol = entityLeftMapX / gp.tileSize;
        int entityRightCol = entityRightMapX / gp.tileSize;
        int entityTopRow = entityTopMapY / gp.tileSize;
        int entityBottomRow = entityBottomMapY / gp.tileSize;
        int tile1, tile2;
        switch (entity.direction) {
            case "up":
                if (entityTopMapY - entity.speed <= 0)
                {
                    entity.collisionOn = 1;
                    break;
                }
                entityTopRow = (entityTopMapY - entity.speed) / gp.tileSize;
                tile1 = gp.tileM.typeTile[entityLeftCol][entityTopRow];
                tile2 = gp.tileM.typeTile[entityRightCol][entityTopRow];
                if (gp.tileM.tile[tile1].typeCollision > 0 || gp.tileM.tile[tile2].typeCollision > 0){
                    entity.collisionOn = 1;
                }
                break;
            case "down":
                if (entityBottomMapY + entity.speed >= gp.mapHeight)
                {
                    entity.collisionOn = 1;
                    break;
                }
                entityBottomRow = (entityBottomMapY + entity.speed) / gp.tileSize;
                tile1 = gp.tileM.typeTile[entityLeftCol][entityBottomRow];
                tile2 = gp.tileM.typeTile[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tile1].typeCollision > 0 || gp.tileM.tile[tile2].typeCollision > 0){
                    entity.collisionOn = 1;
                }
                break;
            case "left":
                if (entityLeftMapX - entity.speed <= 0)
                {
                    entity.collisionOn = 1;
                    break;
                }
                entityLeftCol = (entityLeftMapX - entity.speed) / gp.tileSize;
                tile1 = gp.tileM.typeTile[entityLeftCol][entityTopRow];
                tile2 = gp.tileM.typeTile[entityLeftCol][entityBottomRow];
                if (gp.tileM.tile[tile1].typeCollision > 0 || gp.tileM.tile[tile2].typeCollision > 0){
                    entity.collisionOn = 1;
                }
                break;
            case "right":
                if (entityRightMapX + entity.speed >= gp.mapWidth)
                {
                    entity.collisionOn = 1;
                    break;
                }
                entityRightCol = (entityRightMapX + entity.speed) / gp.tileSize;
                tile1 = gp.tileM.typeTile[entityRightCol][entityTopRow];
                tile2 = gp.tileM.typeTile[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tile1].typeCollision > 0 || gp.tileM.tile[tile2].typeCollision > 0){
                    entity.collisionOn = 1;
                }
                break;
        }
    }
}
