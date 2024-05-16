package npc;

import main.GamePanel;
import tile.*;
import animation.*;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Npc extends Tile{
    GamePanel gamePanel;
    Rectangle displaybox;
    Animation_player stand_animation;



    public Npc(GamePanel gamePanel, int x, int y, int width, int height){
        this.gamePanel = gamePanel;
        LeftX = x; 
        RightX = x + width;
        TopY = y;
        BottomY = y + height;
        this.width = width;
        this.height = height;
        displaybox = new Rectangle(x, y, width, height);
        Load_animation();
    }

    private void Load_animation(){
        stand_animation = new Animation_player(gamePanel, "res/NPC/teacher1/Frame ", 7, 1.0, displaybox);
    }

    private void update(){
        displaybox.x = LeftX - gamePanel.player.getMapX() + gamePanel.player.getBoundingBoxX();
        displaybox.y = TopY - gamePanel.player.getMapY() + gamePanel.player.getBoundingBoxY();
    }

    private void draw(Graphics graphics){
        stand_animation.operation(graphics);
    }

    public void operation(Graphics graphics){
        update();
        draw(graphics);
    }

}
