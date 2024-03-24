package main;

import entity.Entity;

public class CollisionChecker {
    GamePanel gamePanel;
    public CollisionChecker(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    public void checkTile(Entity entity){

        int entityLeftMapX = entity.mapX + entity.validArea.x;
        int entityRightMapX = entity.mapX + entity.validArea.x + entity.validArea.width;
        int entityTopMapY = entity.mapY + entity.validArea.y;
        int entityBottomMapY = entity.mapY + entity.validArea.y + entity.validArea.height;

        int entityLeftCol = entityLeftMapX / gamePanel.tileSize;
        int entityRightCol = entityRightMapX / gamePanel.tileSize;
        int entityTopRow = entityTopMapY / gamePanel.tileSize;
        int entityBottomRow = entityBottomMapY / gamePanel.tileSize;
        int tile1, tile2;
        switch (entity.direction) {
            case "up":
                if (entityTopMapY - entity.speed <= 0)
                {
                    entity.collisionOn = 1;
                    break;
                }
                entityTopRow = (entityTopMapY - entity.speed) / gamePanel.tileSize;
                tile1 = gamePanel.tileManager.typeTile[entityLeftCol][entityTopRow];
                tile2 = gamePanel.tileManager.typeTile[entityRightCol][entityTopRow];
                if (gamePanel.tileManager.tile[tile1].typeCollision > 0 || gamePanel.tileManager.tile[tile2].typeCollision > 0){
                    entity.collisionOn = 1;
                }
                break;
            case "down":
                if (entityBottomMapY + entity.speed >= gamePanel.mapHeight)
                {
                    entity.collisionOn = 1;
                    break;
                }
                entityBottomRow = (entityBottomMapY + entity.speed) / gamePanel.tileSize;
                tile1 = gamePanel.tileManager.typeTile[entityLeftCol][entityBottomRow];
                tile2 = gamePanel.tileManager.typeTile[entityRightCol][entityBottomRow];
                if (gamePanel.tileManager.tile[tile1].typeCollision > 0 || gamePanel.tileManager.tile[tile2].typeCollision > 0){
                    entity.collisionOn = 1;
                }
                break;
            case "left":
                if (entityLeftMapX - entity.speed <= 0)
                {
                    entity.collisionOn = 1;
                    break;
                }
                entityLeftCol = (entityLeftMapX - entity.speed) / gamePanel.tileSize;
                tile1 = gamePanel.tileManager.typeTile[entityLeftCol][entityTopRow];
                tile2 = gamePanel.tileManager.typeTile[entityLeftCol][entityBottomRow];
                if (gamePanel.tileManager.tile[tile1].typeCollision > 0 || gamePanel.tileManager.tile[tile2].typeCollision > 0){
                    entity.collisionOn = 1;
                }
                break;
            case "right":
                if (entityRightMapX + entity.speed >= gamePanel.mapWidth)
                {
                    entity.collisionOn = 1;
                    break;
                }
                entityRightCol = (entityRightMapX + entity.speed) / gamePanel.tileSize;
                tile1 = gamePanel.tileManager.typeTile[entityRightCol][entityTopRow];
                tile2 = gamePanel.tileManager.typeTile[entityRightCol][entityBottomRow];
                if (gamePanel.tileManager.tile[tile1].typeCollision > 0 || gamePanel.tileManager.tile[tile2].typeCollision > 0){
                    entity.collisionOn = 1;
                }
                break;
        }
    }
}
