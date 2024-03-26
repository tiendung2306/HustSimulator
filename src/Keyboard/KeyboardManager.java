package Keyboard;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KeyboardManager {
    static ArrayList<Key> keys = new ArrayList<Key>();

    public void init() {
        keys.add(new Key(KeyEvent.VK_W, "UP"));
        keys.add(new Key(KeyEvent.VK_A, "LEFT"));
        keys.add(new Key(KeyEvent.VK_S, "DOWN"));
        keys.add(new Key(KeyEvent.VK_D, "RIGHT"));
    }

    public int getKey(String keyAction) {
        for(Key k : keys) {
            if(k.getKeyAction() == keyAction) {
                return k.getKey();
            }
        }
        return -1; //chua khai bao phim nay`
    }

    public void setKey(int key, String keyAction) {
        for(Key k : keys) {
            if(k.getKeyAction() == keyAction) {
                k.setKey(key);
                return;
            }
        }
    }
}