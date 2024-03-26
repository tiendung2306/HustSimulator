package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;

import animation.Animation_player;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity{
    GamePanel gamepanel;
    KeyHandler keyhandler;
    public int screenX, screenY;

    public Animation_player animation_player_stand_RIGHT;


    public Animation_player animation_player_UP ;
    public Animation_player animation_player_DOWN;
    public Animation_player animation_player_RIGHT;
    public Animation_player animation_player_LEFT;

    public Animation_player curr_animation_player;

    // public String state; 


    public Player(GamePanel gamepanel, KeyHandler keyhandler){

        this.gamepanel = gamepanel;
        this.keyhandler = keyhandler;

        screenX = gamepanel.screenWidth/2 - gamepanel.tileSize/2;
        screenY = gamepanel.screenHeight/2 - gamepanel.tileSize/2;

        validArea = new Rectangle();
        validArea.x = gamepanel.tileSize / 6;
        validArea.y = gamepanel.tileSize / 3;
        validArea.width = gamepanel.tileSize - validArea.y;
        validArea.height = gamepanel.tileSize - validArea.y;

        getPlayerImage();
        setDefaultValues();
    }
    public void setDefaultValues(){

        mapX = 500;
        mapY = 500;
        speed = 4;
        direction = "stand_right";
        curr_animation_player = animation_player_stand_RIGHT;
    }
    public void getPlayerImage(){

        animation_player_stand_RIGHT = new Animation_player(gamepanel, "res/player/character_stand_right ", 3, 0.5, validArea);

        animation_player_UP = new Animation_player(gamepanel, "res/player/character_move_up ", 4, 0.8, validArea);
        animation_player_DOWN = new Animation_player(gamepanel, "res/player/character_move_down ", 4, 0.8, validArea);
        animation_player_RIGHT = new Animation_player(gamepanel, "res/player/character_move_right ", 4, 0.8, validArea);
        animation_player_LEFT = new Animation_player(gamepanel, "res/player/character_move_left ", 4, 0.8, validArea);

    }
    public void update(){
        if (keyhandler.upPressed || keyhandler.downPressed || keyhandler.leftPressed || keyhandler.rightPressed) {
            if (keyhandler.upPressed){
                direction = "up";
            }
            else if (keyhandler.downPressed){
                direction = "down";
            }
            else if (keyhandler.leftPressed){
                direction = "left";
            }
            else {
                direction = "right";
            }
            collisionOn = 0;
            gamepanel.checkCollision.checkTile(this);
            if (collisionOn == 0)
            {
                switch (direction){
                    case "up": curr_animation_player = animation_player_UP; break;
                    case "down": curr_animation_player = animation_player_DOWN; break;
                    case "left": curr_animation_player = animation_player_LEFT; break;
                    case "right": 
                        curr_animation_player = animation_player_RIGHT;
                        break;

                    case "stand_right": 
                        curr_animation_player = animation_player_stand_RIGHT; 
                        break;

                }
            }
        }

    }
    public void draw(Graphics g2){
        curr_animation_player.operation(g2);

    }
}
