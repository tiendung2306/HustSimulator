package entity;
import main.GamePanel;
import main.KeyHandler;
import map.Map;
import animation.Animation_player;

import java.awt.*;

public class Player extends Entity{

    public Animation_player animation_player_stand_RIGHT;
    GamePanel gamepanel;
    KeyHandler keyhandler;
    Map map;
    public int screenX, screenY;

    public Animation_player animation_player_UP ;
    public Animation_player animation_player_DOWN;
    public Animation_player animation_player_RIGHT;
    public Animation_player animation_player_LEFT;

    public Animation_player curr_animation_player;

    public Player(GamePanel gamepanel, KeyHandler keyhandler,  Map map){
        
        this.map = map;
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
        speedSlant = 3;

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
                    mapY -= speed;
                }
                if (keyhandler.downPressed) {
                    direction = "down";
                    mapY += speed;
                }
                if (keyhandler.leftPressed) {
                    direction = "left";
                    mapX -= speed;
                }
                if (keyhandler.rightPressed) {
                    direction = "right";
                    mapX += speed;
                }
            }
            else {
                if (!(keyhandler.upPressed && keyhandler.downPressed) && !(keyhandler.leftPressed && keyhandler.rightPressed))
                {
                    if (keyhandler.upPressed && keyhandler.leftPressed)
                    {
                        direction = "upleft";
                        mapY -= speedSlant;
                        mapX -= speedSlant;
                    }
                    if (keyhandler.upPressed && keyhandler.rightPressed)
                    {
                        direction = "upright";
                        mapY -= speedSlant;
                        mapX += speedSlant;
                    }
                    if (keyhandler.downPressed && keyhandler.leftPressed)
                    {
                        direction = "downleft";
                        mapY += speedSlant;
                        mapX -= speedSlant;
                    }
                    if (keyhandler.downPressed && keyhandler.rightPressed)
                    {
                        direction = "downright";
                        mapY += speedSlant;
                        mapX += speedSlant;
                    }
                }
            }
            //gp.collisionPlayer.findTile(this, map);
            if (true){
                switch (direction) {
                    case "up":
                        mapY += speed;
                        curr_animation_player = animation_player_UP; 
                        break;
                    case "down":
                        mapY -= speed;
                        curr_animation_player = animation_player_DOWN; 
                        break;
                    case "left":
                        mapX += speed;
                        curr_animation_player = animation_player_LEFT; 
                        break;
                    case "right":
                        mapX -= speed;
                        curr_animation_player = animation_player_RIGHT; 
                        break;
                }
            }
        }

    }
    public void draw(Graphics g2){
        curr_animation_player.operation(g2);
    }
}
