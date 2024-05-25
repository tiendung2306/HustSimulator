package npc;

import main.GamePanel;
import tile.Tile;
import animation.*;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Npc extends Tile{
    GamePanel gamePanel;
    Rectangle displaybox = new Rectangle();
    Animation_player animation;



    public Npc(GamePanel gamePanel, Rectangle hitbox, String type, String name){
        this.gamePanel = gamePanel;
        this.displaybox = hitbox;
        Name = name;
        Type = type;
        x = hitbox.x;
        y = hitbox.y;
        LeftX = hitbox.x;
        RightX = hitbox.x + hitbox.width;
        TopY = hitbox.y;
        BottomY = hitbox.y + hitbox.height;
        width = hitbox.width;
        height = hitbox.height;

        Type = "Interact";

        Load_animation();
    }

    private void Load_animation(){
        switch (Name) {
            case "teacher1":
                animation = new Animation_player(gamePanel, "res/NPC/teacher1/Frame ", 7, 1.0, displaybox);
                break;
            
            case "security_man":
                animation = new Animation_player(gamePanel, "res/NPC/security_man/frame ", 4, 0.8, displaybox);
                break;
            case "Mrs Toan":
                animation = new Animation_player(gamePanel,"res/NPC/MrsToan/Frame ", 14, 1.2, displaybox);
            default:
                break;
        }
    }

    private void update(){
        displaybox.x = LeftX - gamePanel.player.getMapX() + gamePanel.player.getBoundingBoxX();
        displaybox.y = TopY - gamePanel.player.getMapY() + gamePanel.player.getBoundingBoxY();
        displaybox.width = width;
        displaybox.height = height;
    }

    private void draw(Graphics graphics){
        animation.operation(graphics);
    }

    public void operation(Graphics graphics){
        System.out.println(getLeftX());
        update();
        draw(graphics);
    }

}
