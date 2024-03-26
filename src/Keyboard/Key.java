package Keyboard;

import java.awt.event.KeyEvent;

public class Key {
    int key; // W, A, S, Enter (VK_W VK_A VK_Enter)
    String keyTag; // Up, Down, Fire, Interact

    public Key(int key, String keyTag) {
        this.key = key;
        this.keyTag = keyTag;
    }

    public int getKey() {
        return key;
    }

    public String getKeyTag() {
        return keyTag;
    }
    public void setKey(int key) {
        this.key = key;
    }

    public void setKeyTag(String keyTag) {
        this.keyTag = keyTag;
    }
    
}