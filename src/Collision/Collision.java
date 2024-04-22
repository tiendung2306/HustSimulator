package Collision;

import entity.Entity;
import main.GamePanel;
import main.Main;
import main.UI;
import tile.Tile;
import map.Map;

import java.util.Objects;

public class Collision {
    public CollisionCheck collisionCheck;
    public UI ui;
    GamePanel gamePanel;
    int numCollision;
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
        for (int i = 0; i < numCollision; ++i)
            if (collisionTile[i].Type.equals("Collected"))
                collectItem(i);
    }
    public void pushDialogue(){
        if (!Main.topGameState().equals("Dialogue"))
            Main.pushGameState("Dialogue");
        switch(collisionTile[0].Type){
            case "Teleport" : {
                ui.currentDialogue = "Teleport to ";
                break;
            }
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
        }
        for (int i = 0; i < numCollision; ++i){
            if (i > 0 && !collisionTile[i-1].Name.equals("") && !collisionTile[i].Name.equals(""))
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
    public int[] getTileIndex(){return collisionCheck.tileIndex; }
}
