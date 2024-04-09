package main;

import Keyboard.KeyboardManager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    public boolean upPressed, downPressed, leftPressed, rightPressed, isInteract, isPop;
    KeyboardManager keyboardManager = new KeyboardManager();

    public void keyTyped(KeyEvent e){

    }

    public void keyPressed(KeyEvent e){

        int code = e.getKeyCode();

        if(code == keyboardManager.getKey("UP")){
            upPressed = true;
        }
        if(code == keyboardManager.getKey("DOWN")){
            downPressed = true;
        }
        if(code == keyboardManager.getKey("LEFT")){
            leftPressed = true;
        }
        if(code == keyboardManager.getKey("RIGHT")){
            rightPressed = true;
        }
        if(code == keyboardManager.getKey("PAUSE")){
            if (Main.topGameState().equals("GamePause")){
                Main.popGameState();
            }
            else Main.pushGameState("GamePause");
        }
        if(code == keyboardManager.getKey("INTERACT")){
            isInteract = !isInteract;
        }
        if(code == keyboardManager.getKey("INVENTORY")){
            if (Main.topGameState().equals("Inventory"))
                Main.popGameState();
            else Main.pushGameState("Inventory");
        }
        if(code == keyboardManager.getKey("POP")){
            isPop = true;
        }
    }

    public void keyReleased(KeyEvent e){

        int code = e.getKeyCode();

        if(code == keyboardManager.getKey("UP")){
            upPressed = false;
        }
        if(code == keyboardManager.getKey("DOWN")){
            downPressed = false;
        }
        if(code == keyboardManager.getKey("LEFT")){
            leftPressed = false;
        }
        if(code == keyboardManager.getKey("RIGHT")){
            rightPressed = false;
        }
        if(code == keyboardManager.getKey("POP")){
            isPop = false;
        }
    }

}
