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



    public Npc(GamePanel gamePanel, Rectangle hitbox){
        this.gamePanel = gamePanel;
        this.displaybox = hitbox;
        LeftX = hitbox.x;
        RightX = hitbox.x + hitbox.width;
        TopY = hitbox.y;
        BottomY = hitbox.y + hitbox.height;
        width = hitbox.width;
        height = hitbox.height;

        Type = "Interact";
        Name = "Npc";

        Load_animation();
    }

    private void Load_animation(){
        animation = new Animation_player(gamePanel, "res/NPC/teacher1/Frame ", 7, 1.0, displaybox);
    }

    private void update(){
        displaybox.x = LeftX - gamePanel.player.getMapX() + gamePanel.player.getBoundingBoxX();
        displaybox.y = TopY - gamePanel.player.getMapY() + gamePanel.player.getBoundingBoxY();
    }

    private void draw(Graphics graphics){
        animation.operation(graphics);
    }

    public void resize(double scale){
        super.resize(scale); 

        displaybox.x *= scale;
        displaybox.y *= scale;
        displaybox.width *= scale;
        displaybox.height *= scale;

    }

    public void operation(Graphics graphics){
        update();
        draw(graphics);
    }

}
