package entity;
import main.GamePanel;
import main.KeyHandler;
import map.Map;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import static java.lang.Math.sqrt;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    Map map;
    public int screenX, screenY;
    public Player(GamePanel gp, KeyHandler keyH, Map map){

        this.gp = gp;
        this.keyH = keyH;
        this.map = map;

        screenX = gp.screenWidth/2 - gp.tileSize/2;
        screenY = gp.screenHeight/2 - gp.tileSize/2;

        validArea = new Rectangle();
        validArea.x = gp.tileSize / 6;
        validArea.y = gp.tileSize / 3;
        validArea.width = gp.tileSize - validArea.y;
        validArea.height = gp.tileSize - validArea.y;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){

        mapX = 500;
        mapY = 500;
        speed = 4;
        speedSlant = 3;
        direction = "down";
    }
    public void getPlayerImage(){

         try{
              upleft1 = ImageIO.read(new FileInputStream("res/player/boy_up_1.png"));
              upleft2 = ImageIO.read(new FileInputStream("res/player/boy_up_2.png"));
              upright1 = ImageIO.read(new FileInputStream("res/player/boy_up_1.png"));
              upright2 = ImageIO.read(new FileInputStream("res/player/boy_up_2.png"));
              downleft1 = ImageIO.read(new FileInputStream("res/player/boy_down_1.png"));
              downleft2 = ImageIO.read(new FileInputStream("res/player/boy_down_2.png"));
              downright1 = ImageIO.read(new FileInputStream("res/player/boy_down_1.png"));
              downright2 = ImageIO.read(new FileInputStream("res/player/boy_down_2.png"));
              up1 = ImageIO.read(new FileInputStream("res/player/boy_up_1.png"));
              up2 = ImageIO.read(new FileInputStream("res/player/boy_up_2.png"));
              down1 = ImageIO.read(new FileInputStream("res/player/boy_down_1.png"));
              down2 = ImageIO.read(new FileInputStream("res/player/boy_down_2.png"));
              left1 = ImageIO.read(new FileInputStream("res/player/boy_left_1.png"));
              left2 = ImageIO.read(new FileInputStream("res/player/boy_left_2.png"));
              right1 = ImageIO.read(new FileInputStream("res/player/boy_right_1.png"));
              right2 = ImageIO.read(new FileInputStream("res/player/boy_right_2.png"));
         } catch(IOException e){
             e.printStackTrace();
         }
    }
    public void update(){
        int countPressed = 0;
        if (keyH.upPressed)
            ++countPressed;
        if (keyH.downPressed)
            ++countPressed;
        if (keyH.leftPressed)
            ++countPressed;
        if (keyH.rightPressed)
            ++countPressed;
        if (countPressed > 0) {
            if (countPressed == 1){
                if (keyH.upPressed) {
                    direction = "up";
                    mapY -= speed;
                }
                if (keyH.downPressed) {
                    direction = "down";
                    mapY += speed;
                }
                if (keyH.leftPressed) {
                    direction = "left";
                    mapX -= speed;
                }
                if (keyH.rightPressed) {
                    direction = "right";
                    mapX += speed;
                }
            }
            else {
                if (!(keyH.upPressed && keyH.downPressed) && !(keyH.leftPressed && keyH.rightPressed))
                {
                    if (keyH.upPressed && keyH.leftPressed)
                    {
                        direction = "upleft";
                        mapY -= speedSlant;
                        mapX -= speedSlant;
                    }
                    if (keyH.upPressed && keyH.rightPressed)
                    {
                        direction = "upright";
                        mapY -= speedSlant;
                        mapX += speedSlant;
                    }
                    if (keyH.downPressed && keyH.leftPressed)
                    {
                        direction = "downleft";
                        mapY += speedSlant;
                        mapX -= speedSlant;
                    }
                    if (keyH.downPressed && keyH.rightPressed)
                    {
                        direction = "downright";
                        mapY += speedSlant;
                        mapX += speedSlant;
                    }
                }
            }
            //gp.collisionPlayer.findTile(this, map);
            if (true)
            {
                stepCounter++;
                if (stepCounter > 8){
                    stepNum = 3 - stepNum;
                    stepCounter = 0;
                }
            }
            else {
                switch (direction) {
                    case "up":
                        mapY += speed;
                    case "down":
                        mapY -= speed;
                    case "left":
                        mapX += speed;
                    case "right":
                        mapX -= speed;
                }
            }
        }

    }
    public void draw(Graphics2D g2){
        BufferedImage image = null;
        switch (direction) {
            case "up":
                if (stepNum == 1){
                    image = up1;
                }
                if (stepNum == 2){
                    image = up2;
                }
                break;
            case "down":
                if (stepNum == 1){
                    image = down1;
                }
                if (stepNum == 2){
                    image = down2;
                }
                break;
            case "left":
                if (stepNum == 1){
                    image = left1;
                }
                if (stepNum == 2){
                    image = left2;
                }
                break;
            case "right":
                if (stepNum == 1){
                    image = right1;
                }
                if (stepNum == 2){
                    image = right2;
                }
                break;
            case "upleft":
                if (stepNum == 1){
                    image = upleft1;
                }
                if (stepNum == 2){
                    image = upleft2;
                }
                break;
            case "upright":
                if (stepNum == 1){
                    image = upright1;
                }
                if (stepNum == 2){
                    image = upright2;
                }
                break;
            case "downleft":
                if (stepNum == 1){
                    image = downleft1;
                }
                if (stepNum == 2){
                    image = downleft2;
                }
                break;
            case "downright":
                if (stepNum == 1){
                    image = downright1;
                }
                if (stepNum == 2){
                    image = downright2;
                }
                break;
        }
        int posX = screenX;
        int posY = screenY;
        g2.drawImage(image, posX, posY, gp.tileSize, gp.tileSize, null);
    }
}
