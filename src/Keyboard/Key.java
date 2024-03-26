package Keyboard;

import java.awt.event.KeyEvent;

public class Key {
    int key;
    String keyAction;

    public Key(int key, String keyAction) {
        this.key = key;
        this.keyAction = keyAction;
    }

    public int getKey() {
        return key;
    }

    public String getKeyAction() {
        return keyAction;
    }
    public void setKey(int key) {
        this.key = key;
    }

    public void setKeyAction(String keyAction) {
        this.keyAction = keyAction;
    }
    
}