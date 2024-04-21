package main;

import Keyboard.KeyboardManager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    public boolean upPressed, downPressed, leftPressed, rightPressed, isInteract, isPhonePressed;

    public void keyTyped(KeyEvent e){

    }

    public void keyPressed(KeyEvent e){

        int code = e.getKeyCode();

        if(code == KeyboardManager.getKey("UP")){
            upPressed = true;
        }
        if(code == KeyboardManager.getKey("DOWN")){
            downPressed = true;
        }
        if(code == KeyboardManager.getKey("LEFT")){
            leftPressed = true;
        }
        if(code == KeyboardManager.getKey("RIGHT")){
            rightPressed = true;
        }
        if(code == KeyboardManager.getKey("PAUSE")){
            if (Main.topGameState().equals("GamePause")){
                Main.popGameState();
            }
            else Main.pushGameState("GamePause");
        }
        if((Main.topGameState().equals("GamePlay") || Main.topGameState().equals("Inventory")) && code == KeyboardManager.getKey("INVENTORY")){
            if (Main.topGameState().equals("Inventory"))
                Main.popGameState();
            else Main.pushGameState("Inventory");
        }
        // if(code == KeyboardManager.getKey("PHONE")){
        //     isPhonePressed = true;
        // }
    }

    public void keyReleased(KeyEvent e){

        int code = e.getKeyCode();

        if(code == KeyboardManager.getKey("UP")){
            upPressed = false;
        }
        if(code == KeyboardManager.getKey("DOWN")){
            downPressed = false;
        }
        if(code == KeyboardManager.getKey("LEFT")){
            leftPressed = false;
        }
        if(code == KeyboardManager.getKey("RIGHT")){
            rightPressed = false;
        }
        if(code == KeyboardManager.getKey("PHONE")){
            isPhonePressed = true;
        }
        if(code == KeyboardManager.getKey("INTERACT")){
            if (Main.topGameState().equals("Dialogue"))
            {
                Main.popGameState();
                isInteract = false;
            }
            else isInteract = true;
        }
    }

}
