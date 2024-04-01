
package entity;
import main.CollisionPlayer;
import main.GamePanel;
import main.KeyHandler;
import map.Map;
import animation.Animation_player;

import java.awt.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

import tile.Tile;
import tile.TileManager;
public class Player extends Entity{

    public Animation_player animation_player_stand_RIGHT;
    GamePanel gamepanel;
    KeyHandler keyhandler;
    Map map;
    CollisionPlayer collision;
    public int screenX, screenY;
    boolean leftBorder, rightBorder, topBorder, bottomBorder;

    public Animation_player animation_player_UP ;
    public Animation_player animation_player_DOWN;
    public Animation_player animation_player_RIGHT;
    public Animation_player animation_player_LEFT;

    public Animation_player curr_animation_player;
    TileManager tileManager;

    public Player(GamePanel gamepanel, KeyHandler keyhandler, Map map, TileManager tilemanager){
        
        this.map = map;
        this.gamepanel = gamepanel;
        this.keyhandler = keyhandler;
        this.collision = gamepanel.collision;
        this . tileManager = tilemanager;
        leftBorder = false;
        rightBorder = false;
        bottomBorder = false;
        topBorder = false;

        hitArea = new Rectangle();
        boundingBox = new Rectangle();
        boundingBox.width = gamepanel.tileSize * 2;
        boundingBox.height = gamepanel.tileSize * 2;
        hitArea.x = boundingBox.width / 4;
        hitArea.y = boundingBox.height / 2;
        hitArea.width = boundingBox.width / 2;
        hitArea.height = boundingBox.height / 2;
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
        System.out.print(hitArea.x);
        System.out.print(" ");
        System.out.print(hitArea.x + hitArea.width);
        System.out.print(" ");
        System.out.print(hitArea.y);
        System.out.print(" ");
        System.out.println(hitArea.y + hitArea.height);
        int countPressed = 0;
        if (keyhandler.upPressed)
            ++countPressed;
        if (keyhandler.downPressed)
            ++countPressed;
        if (keyhandler.leftPressed)
            ++countPressed;
        if (keyhandler.rightPressed)
            ++countPressed;
        int newMapX = mapX, newMapY = mapY;
        if (countPressed > 0) {
            if (countPressed == 1){
                if (keyhandler.upPressed) {
                    direction = "up";
                    if (!topBorder)
                        newMapY -= speed;
                }
                if (keyhandler.downPressed) {
                    direction = "down";
                    if (!bottomBorder)
                        newMapY += speed;
                }
                if (keyhandler.leftPressed) {
                    direction = "left";
                    if (!leftBorder)
                        newMapX -= speed;
                }
                if (keyhandler.rightPressed) {
                    direction = "right";
                    if (!rightBorder)
                        newMapX += speed;
                }
            }
            else {
                if (!(keyhandler.upPressed && keyhandler.downPressed) && !(keyhandler.leftPressed && keyhandler.rightPressed))
                {
                    if (keyhandler.upPressed && keyhandler.leftPressed)
                    {
                        direction = "upleft";
                        if (!topBorder)
                            newMapY -= speedSlant;
                        if (!leftBorder)
                            newMapX -= speedSlant;
                    }
                    if (keyhandler.upPressed && keyhandler.rightPressed)
                    {
                        direction = "upright";
                        if (!topBorder)
                            newMapY -= speedSlant;
                        if (!rightBorder)
                            newMapX += speedSlant;
                    }
                    if (keyhandler.downPressed && keyhandler.leftPressed)
                    {
                        direction = "downleft";
                        if (!bottomBorder)
                            newMapY += speedSlant;
                        if (!leftBorder)
                            newMapX -= speedSlant;
                    }
                    if (keyhandler.downPressed && keyhandler.rightPressed)
                    {
                        direction = "downright";
                        if (!bottomBorder)
                            newMapY += speedSlant;
                        if (!rightBorder)
                            newMapX += speedSlant;
                    }
                }
            }
            hitArea.x = newMapX + boundingBox.width / 4;
            hitArea.y = newMapY + boundingBox.height / 2;
            collision.scanCollision(this, map);
            if (collision.getNumCollision() == 0){
                mapX = newMapX;
                mapY = newMapY;
                switch (direction) {
                    case "up": curr_animation_player = animation_player_UP;break;
                    case "down": curr_animation_player = animation_player_DOWN;break;
                    case "left": curr_animation_player = animation_player_LEFT;break;
                    case "right": curr_animation_player = animation_player_RIGHT;break;
                    }
                }
        }
        else {
            direction = "stand_right";
            curr_animation_player = animation_player_stand_RIGHT;
        }
        boundingBox.x = min(screenX, mapX);
        boundingBox.y = min(screenY, mapY);
        boundingBox.x += max(0,mapX - (gamepanel.mapWidth - gamepanel.screenWidth / 2) + boundingBox.width);
        boundingBox.y += max(0,mapY - (gamepanel.mapHeight - gamepanel.screenWidth / 2) + boundingBox.height);
        hitArea.x = mapX + boundingBox.width / 4;
        hitArea.y = mapY + boundingBox.height / 2;
        leftBorder = (boundingBox.x <= 0);
        rightBorder = (boundingBox.x >= gamepanel.screenWidth - boundingBox.width);
        topBorder = (boundingBox.y <= 0);
        bottomBorder = (boundingBox.y >= gamepanel.screenHeight - boundingBox.height);
    }
    public void draw(Graphics2D g2){
        tileManager.drawRect(g2, hitArea.x, hitArea.y, hitArea.width, hitArea.height);
        curr_animation_player.operation(g2);
    }
}

