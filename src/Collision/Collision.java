package Collision;

import area.D3_5.D3_5_hallway_secondfloor;
import entity.Entity;
import main.GamePanel;
import main.Main;
import main.UI;
import map.Map;
import tile.Tile;

public class Collision {
    public CollisionCheck collisionCheck;
    public UI ui;
    GamePanel gamePanel;
    int[] tileIndex;
    int numCollision;
    public Tile interactItem = new Tile();
    Tile[] collisionTile;

    public Collision(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.ui = gamePanel.ui;
        collisionCheck = new CollisionCheck(gamePanel);
    }

    public void update() {
        numCollision = collisionCheck.numCollision;
        collisionTile = collisionCheck.collisionTile;
        tileIndex = collisionCheck.tileIndex;
        pushDialog();
        if (numCollision == 1 && collisionTile[0].Type.equals("Interact"))
            interactItem = collisionTile[0];
        for (int i = 0; i < numCollision; ++i) {
            if (collisionTile[i].Type.equals("Collected"))
                collectItem(i);
            if (collisionTile[i].Type.equals("Teleport")) {
                teleport(collisionTile[i].Name);

            }
        }
    }

    void teleport(String name) {
        switch (name) {
            case "Door My Room":
                gamePanel.section_selection.open(true);
                break;
                
            case "Door Classroom":
                gamePanel.stadium.loadMap(gamePanel);
                break;
            
            case "C2_Hallway":
                gamePanel.c2_hallway.open();
                break;    
            
            case "C2_Hall_entry":
                gamePanel.c2_hall.open();
                break;

            case "C2_Hallway_exit":
                gamePanel.section_1.open();
                break; 

            case "D3_Hallway":
                gamePanel.d3_hallway.open();
                break;      

            case "D3_exit":
                gamePanel.section_2.open();
                break; 

            case "D3_1stfloor_stair":
                gamePanel.d3_secondfloor_hallway.open();
                break;        

            case "D3_stair_down":
                if(gamePanel.d3_secondfloor_hallway.curr_floor == 2)
                    gamePanel.d3_hallway.open();
                else{
                    gamePanel.d3_secondfloor_hallway.curr_floor -= 1;
                    gamePanel.d3_secondfloor_hallway.open();
                }
                break;

            case "D3_stair_up":
                if(gamePanel.d3_secondfloor_hallway.curr_floor != 5){
                    gamePanel.d3_secondfloor_hallway.curr_floor += 1;
                    gamePanel.d3_secondfloor_hallway.open();
                }
                break;

            case "D3->D3-5_secondfloor_link":
                gamePanel.d3_5_hallway_secondfloor.curr_floor = gamePanel.d3_secondfloor_hallway.curr_floor;
                gamePanel.d3_5_hallway_secondfloor.open();
                break;

            case "D3<-D3_5_secondfloor_link":
                gamePanel.d3_secondfloor_hallway.curr_floor = gamePanel.d3_5_hallway_secondfloor.curr_floor;
                gamePanel.d3_secondfloor_hallway.open();
                break;
                
            case "D3-5_...01":
                if(gamePanel.d3_5_hallway_secondfloor.curr_floor == 3)
                    gamePanel.normalClassroom.loadMap(gamePanel);
                break;

            default:
                break;
        }
    }

    public boolean isCollision(String str) {
        for (int i = 0; i < numCollision; ++i)
            if (collisionTile[i].Name.equals(str))
                return true;
        return false;
    }

    public void pushDialog() {
        /*boolean checkDoor = false;
        for (int i = 0; i < numCollision; ++i)
            if (collisionTile[i].Type.equals("Teleport")) {
                checkDoor = true;
                break;
            }*/
        if (!Main.topGameState().equals("Dialog") && !gamePanel.phone.isDrawPhone)
            Main.pushGameState("Dialog");
        switch (collisionTile[0].Type) {
            case "Teleport": {
                ui.currentDialog = "Bạn vừa dịch chuyển tới ";
                break;
            }
            case "Collected": {
                ui.currentDialog = "Bạn vừa thu thập ";
                break;
            }
            case "Interact": {
                ui.currentDialog = "Bạn đang tương tác với ";
                break;
            }
            case "Obstacle": {
                ui.currentDialog = "Bạn đang va chạm với ";
                break;
            }
        }
        for (int i = 0; i < numCollision; ++i) {
            if (i > 0 && !collisionTile[i - 1].Name.equals("") && !collisionTile[i].Name.equals(""))
                ui.currentDialog += " and ";
            if (!collisionTile[i].Name.equals(""))
            {
                if (collisionTile[i].Name.equals("Door My Room"))
                    ui.currentDialog += "Hanoi University of Tạch Môn!";
                else ui.currentDialog += collisionTile[i].Name;
            }
        }
    }

    public void collectItem(int index) {
        gamePanel.inventory.pushToInventory(collisionTile[index]);
        gamePanel.currentMap.deleteTile(tileIndex[index]);
        gamePanel.player.ButtonInteract = false;
    }

    public void scanCollision(Entity entity, Map map) {
        collisionCheck.scanCollision(entity, map);
    }

    public int getNumCollision() {
        return collisionCheck.numCollision;
    }

    public Tile[] getCollisionTile() {
        return collisionCheck.collisionTile;
    }
}
