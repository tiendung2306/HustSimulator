
package entity;
import main.GamePanel;
import main.KeyHandler;
import map.Map;
import animation.Animation_player;

import java.awt.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Player extends Entity{

    public Animation_player animation_player_stand_RIGHT;
    GamePanel gamepanel;
    KeyHandler keyhandler;
    Map map;
    public int screenX, screenY;
    boolean leftBorder, rightBorder, topBorder, bottomBorder;

    public Animation_player animation_player_UP ;
    public Animation_player animation_player_DOWN;
    public Animation_player animation_player_RIGHT;
    public Animation_player animation_player_LEFT;

    public Animation_player curr_animation_player;

    public Player(GamePanel gamepanel, KeyHandler keyhandler,  Map map){
        
        this.map = map;
        this.gamepanel = gamepanel;
        this.keyhandler = keyhandler;
        leftBorder = false;
        rightBorder = false;
        bottomBorder = false;
        topBorder = false;

        validArea = new Rectangle();
        boundingBox = new Rectangle();
        validArea.x = gamepanel.tileSize / 6;
        validArea.y = gamepanel.tileSize / 3;
        validArea.width = gamepanel.tileSize - validArea.y;
        validArea.height = gamepanel.tileSize - validArea.y;
        boundingBox.width = gamepanel.tileSize * 3;
        boundingBox.height = gamepanel.tileSize * 3;
        screenX = gamepanel.screenWidth/2 - boundingBox.width/2;
        screenY = gamepanel.screenHeight/2 - boundingBox.height/2;
        boundingBox.x = screenX;
        boundingBox.y = screenY;

        setDefaultValues();
    }


    public void setDefaultValues() {
        mapX = 600;
        mapY = 300;
        speed = 4;
        direction = "stand_right";
        speedSlant = 3;

        animation_player_stand_RIGHT = new Animation_player(gamepanel, "res/player/character_stand_right ", 3, 0.5, boundingBox);

        animation_player_UP = new Animation_player(gamepanel, "res/player/character_move_up ", 4, 0.8, boundingBox);
        animation_player_DOWN = new Animation_player(gamepanel, "res/player/character_move_down ", 4, 0.8, boundingBox);
        animation_player_RIGHT = new Animation_player(gamepanel, "res/player/character_move_right ", 4, 0.8, boundingBox);
        animation_player_LEFT = new Animation_player(gamepanel, "res/player/character_move_left ", 4, 0.8, boundingBox);

        curr_animation_player = animation_player_stand_RIGHT;

    }
    
    public void update(){
        int countPressed = 0;
        if (keyhandler.upPressed)
            ++countPressed;
        if (keyhandler.downPressed)
            ++countPressed;
        if (keyhandler.leftPressed)
            ++countPressed;
        if (keyhandler.rightPressed)
            ++countPressed;
        if (countPressed > 0) {
            if (countPressed == 1){
                if (keyhandler.upPressed) {
                    direction = "up";
                    if (!topBorder)
                        mapY -= speed;
                }
                if (keyhandler.downPressed) {
                    direction = "down";
                    if (!bottomBorder)
                        mapY += speed;
                }
                if (keyhandler.leftPressed) {
                    direction = "left";
                    if (!leftBorder)
                        mapX -= speed;
                }
                if (keyhandler.rightPressed) {
                    direction = "right";
                    if (!rightBorder)
                        mapX += speed;
                }
            }
            else {
                if (!(keyhandler.upPressed && keyhandler.downPressed) && !(keyhandler.leftPressed && keyhandler.rightPressed))
                {
                    if (keyhandler.upPressed && keyhandler.leftPressed)
                    {
                        direction = "upleft";
                        if (!topBorder)
                            mapY -= speedSlant;
                        if (!leftBorder)
                            mapX -= speedSlant;
                    }
                    if (keyhandler.upPressed && keyhandler.rightPressed)
                    {
                        direction = "upright";
                        if (!topBorder)
                            mapY -= speedSlant;
                        if (!rightBorder)
                            mapX += speedSlant;
                    }
                    if (keyhandler.downPressed && keyhandler.leftPressed)
                    {
                        direction = "downleft";
                        if (!bottomBorder)
                            mapY += speedSlant;
                        if (!leftBorder)
                            mapX -= speedSlant;
                    }
                    if (keyhandler.downPressed && keyhandler.rightPressed)
                    {
                        direction = "downright";
                        if (!bottomBorder)
                            mapY += speedSlant;
                        if (!rightBorder)
                            mapX += speedSlant;
                    }
                }
            }
            //gp.collisionPlayer.findTile(this, map);
            if (false) {
                switch (direction) {
                    case "up":
                        if (!topBorder) mapY += speed;
                        break;
                    case "down":
                        if (!bottomBorder) mapY -= speed;
                        break;
                    case "left":
                        if (!leftBorder) mapX += speed;
                        break;
                    case "right":
                        if (!rightBorder) mapX -= speed;
                        break;
                }
            }
            else {
                switch (direction) {
                    case "up": curr_animation_player = animation_player_UP;break;
                    case "down": curr_animation_player = animation_player_DOWN;break;
                    case "left": curr_animation_player = animation_player_LEFT;break;
                    case "right": curr_animation_player = animation_player_RIGHT;break;
                    }
                }
        }
        boundingBox.x = min(screenX, mapX);
        boundingBox.y = min(screenY, mapY);
        boundingBox.x += max(0,mapX - (gamepanel.mapWidth - gamepanel.screenWidth / 2) + boundingBox.width);
        boundingBox.y += max(0,mapY - (gamepanel.mapHeight - gamepanel.screenWidth / 2) + boundingBox.height);
        System.out.print(gamepanel.screenWidth);
        System.out.print(" ");
        System.out.println(boundingBox.x);
        leftBorder = (boundingBox.x <= 0);
        rightBorder = (boundingBox.x >= gamepanel.screenWidth - boundingBox.width);
        topBorder = (boundingBox.y <= 0);
        bottomBorder = (boundingBox.y >= gamepanel.screenHeight - boundingBox.height);
    }
    public void draw(Graphics g2){
        curr_animation_player.operation(g2);
    }
}

