package Collision;

import main.GamePanel;
import main.Main;
import main.UI;
import tile.Tile;

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
        numCollision = collisionCheck.getNumCollision();
        collisionTile = collisionCheck.getCollisionTile();
        tileIndex = collisionCheck.getTileIndex();
        pushDialogue();
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
            if (i > 0)
                ui.currentDialogue += " and ";
            ui.currentDialogue += collisionTile[i].Name;
        }
    }
    public void collectItem(int index){
        gamePanel.inventory.pushToInventory(collisionTile[index]);
        gamePanel.currentMap.deleteTile(tileIndex[index]);
        gamePanel.player.ButtonInteract = false;
    }
}
