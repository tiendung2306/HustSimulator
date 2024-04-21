package Collision;

import entity.Entity;
import main.GamePanel;
import main.Main;
import main.UI;
import tile.Tile;
import map.Map;

public class Collision {
    public CollisionCheck collisionCheck;
    public UI ui;
    GamePanel gamePanel;
    int numCollision;
    public boolean inventoryAllow = false;
    public Tile interactItem = new Tile();
    Tile[] collisionTile;
    int[] tileIndex;
    public Collision(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        this.ui = gamePanel.ui;
        collisionCheck = new CollisionCheck(gamePanel);
    }
    public void update(){
        numCollision = collisionCheck.numCollision;
        collisionTile = collisionCheck.collisionTile;
        tileIndex = collisionCheck.tileIndex;
        pushDialogue();
        if (numCollision == 1 && collisionTile[0].Type.equals("Interact"))
        {
            inventoryAllow = true;
            interactItem = collisionTile[0];
        }
        else inventoryAllow = false;
        for (int i = 0; i < numCollision; ++i)
            if (collisionTile[i].Type.equals("Collected"))
                collectItem(i);
    }
    public void pushDialogue(){
        if (!Main.topGameState().equals("Dialogue"))
            Main.pushGameState("Dialogue");
        switch(collisionTile[0].Type){
            case "Collected" : {
                ui.currentDialogue = "You've collected a ";
                break;
            }
            case "Interact" : {
                ui.currentDialogue = "You're interacting with ";
                break;
            }
            case "Obstacle" : {
                ui.currentDialogue = "You're hitting ";
                break;
            }
            case "Teleport" : {
                ui.currentDialogue = "Teleport to ";
                break;
            }
        }
        for (int i = 0; i < numCollision; ++i){
            if (i > 0 && collisionTile[i].Name.equals(""))
                ui.currentDialogue += " and ";
            if(!collisionTile[i].Name.equals(""))
                ui.currentDialogue += collisionTile[i].Name;
        }
    }
    public void collectItem(int index){
        gamePanel.inventory.pushToInventory(collisionTile[index]);
        gamePanel.currentMap.deleteTile(tileIndex[index]);
        gamePanel.player.ButtonInteract = false;
    }
    public void scanCollision(Entity entity, Map map){
        collisionCheck.scanCollision(entity,map);
    }
    public int getNumCollision() {
        return collisionCheck.numCollision;
    }

    public Tile[] getCollisionTile() {
        return collisionCheck.collisionTile;
    }
}
