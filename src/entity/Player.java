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

    public Animation_player animation_player_UP ;
    public Animation_player animation_player_DOWN;
    public Animation_player animation_player_RIGHT;
    public Animation_player animation_player_LEFT;

    public Animation_player curr_animation_player;


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
        direction = "right";
        curr_animation_player = animation_player_RIGHT;
    }
    public void getPlayerImage(){

        // animation_player_UP ;
        animation_player_DOWN = new Animation_player(gamepanel, "res/player/character_move_down ", 4, 0.8, validArea);
        animation_player_RIGHT = new Animation_player(gamepanel, "res/player/character_move_right ", 4, 0.8, validArea);
        // animation_player_LEFT;

        // try{
            
        //     stand_up = ImageIO.read(new FileInputStream("res/player/boy_up_1.png"));
        //     up1 = ImageIO.read(new FileInputStream("res/player/boy_up_1.png"));
        //     up2 = ImageIO.read(new FileInputStream("res/player/boy_up_2.png"));
        //     up3 = ImageIO.read(new FileInputStream("res/player/boy_up_2.png"));

        //     down1 = ImageIO.read(new FileInputStream("res/player/boy_down_1.png"));
        //     down2 = ImageIO.read(new FileInputStream("res/player/boy_down_2.png"));
        //     down3 = ImageIO.read(new FileInputStream("res/player/boy_down_2.png"));

        //     left1 = ImageIO.read(new FileInputStream("res/player/boy_left_1.png"));
        //     left2 = ImageIO.read(new FileInputStream("res/player/boy_left_2.png"));
        //     left3 = ImageIO.read(new FileInputStream("res/player/boy_left_2.png"));

        //     right1 = ImageIO.read(new FileInputStream("res/player/boy_right_1.png"));
        //     right2 = ImageIO.read(new FileInputStream("res/player/boy_right_2.png"));
        //     right3 = ImageIO.read(new FileInputStream("res/player/boy_right_2.png"));


        // } catch(IOException e){
        //     e.printStackTrace();
        // }
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
                    case "right": curr_animation_player = animation_player_RIGHT; break;
                }
                stepCounter++;
                if (stepCounter > 8){
                    stepNum = 3 - stepNum;
                    stepCounter = 0;
                }
            }
        }

    }
    public void draw(Graphics2D g2){
        curr_animation_player.operation(g2);

        // BufferedImage image = null;
        // switch (direction) {
        //     case "up":
        //         if (stepNum == 1){
        //             image = up1;
        //         }
        //         if (stepNum == 2){
        //             image = up2;
        //         }
        //         break;
        //     case "down":
        //         if (stepNum == 1){
        //             image = down1;
        //         }
        //         if (stepNum == 2){
        //             image = down2;
        //         }
        //         break;
        //     case "left":
        //         if (stepNum == 1){
        //             image = left1;
        //         }
        //         if (stepNum == 2){
        //             image = left2;
        //         }
        //         break;
        //     case "right":
        //         if (stepNum == 1){
        //             image = right1;
        //         }
        //         if (stepNum == 2){
        //             image = right2;
        //         }
        //         break;
        // }
        // int posX = screenX;
        // int posY = screenY;
        // g2.drawImage(image, posX, posY, gamepanel.tileSize, gamepanel.tileSize, null);
    }
}
