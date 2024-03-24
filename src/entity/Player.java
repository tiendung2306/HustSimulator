package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;
    public int screenX, screenY;
    public Player(GamePanel gp, KeyHandler keyH){

        this.gp = gp;
        this.keyH = keyH;

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
        direction = "down";
    }
    public void getPlayerImage(){

        try{
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
        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            if (keyH.upPressed){
                direction = "up";
            }
            else if (keyH.downPressed){
                direction = "down";
            }
            else if (keyH.leftPressed){
                direction = "left";
            }
            else {
                direction = "right";
            }
            collisionOn = 0;
            gp.checkCollision.checkTile(this);
            if (collisionOn == 0)
            {
                switch (direction){
                    case "up": mapY -= speed; break;
                    case "down": mapY += speed; break;
                    case "left": mapX -= speed; break;
                    case "right": mapX += speed; break;
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
        }
        int posX = screenX;
        int posY = screenY;
        g2.drawImage(image, posX, posY, gp.tileSize, gp.tileSize, null);
    }
}
