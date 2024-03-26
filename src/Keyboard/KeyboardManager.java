/*
 * keyboardManager.getKey("UP") //tra ve phim w
 */

package Keyboard;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KeyboardManager {
    static ArrayList<Key> keys = new ArrayList<Key>();

    public void init() { // tell me if you want add new key
        keys.add(new Key(KeyEvent.VK_W, "UP"));
        keys.add(new Key(KeyEvent.VK_A, "LEFT"));
        keys.add(new Key(KeyEvent.VK_S, "DOWN"));
        keys.add(new Key(KeyEvent.VK_D, "RIGHT"));
        keys.add(new Key(KeyEvent.VK_E, "Interact"));
    }

    public int getKey(String keyTag) {
        for(Key k : keys) {
            if(k.getKeyTag() == keyTag) {
                return k.getKey();
            }
        }
        return -1; //chua khai bao phim nay`
    }

    public void setKey(int key, String keyTag) {
        for(Key k : keys) {
            if(k.getKeyTag() == keyTag) {
                k.setKey(key);
                return;
            }
        }
    }
}