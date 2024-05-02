package npc;

import main.GamePanel;
import tile.*;
import animation.*;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.Rectangle;

public class Npc extends Tile{
    GamePanel gamePanel;
    Animation_player stand_animation;


    public Npc(GamePanel gamePanel, int x, int y, int width, int height){
        this.gamePanel = gamePanel;
        LeftX = x; 
        RightX = x + width;
        TopY = y;
        BottomY = y + height;
        this.width = width;
        this.height = height;
        Load_animation();
    }

    private void Load_animation(){
        // stand_animation = new Animation_player(gamePanel, "res/NPC/teacher1 ", 7, 2.0, new Rectangle(x, y, 100, 100));
    }

}
