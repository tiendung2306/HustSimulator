/*
 * keyboardManager.getKey("UP") //tra ve phim w
 */

package Keyboard;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.KeyListener;

public class KeyboardManager implements KeyListener {
    static ArrayList<Key> keys = new ArrayList<Key>();
    static int releasedKey = -1;
    static char releasedKeyName;

    public void init() { // tell me if you want add new key
        keys.add(new Key(KeyEvent.VK_W, "W", "UP"));
        keys.add(new Key(KeyEvent.VK_A, "A", "LEFT"));
        keys.add(new Key(KeyEvent.VK_S, "S", "DOWN"));
        keys.add(new Key(KeyEvent.VK_D, "D", "RIGHT"));
        keys.add(new Key(KeyEvent.VK_F, "F", "INTERACT"));
        keys.add(new Key(KeyEvent.VK_SPACE, "SPACE", "INTERACT"));
        keys.add(new Key(KeyEvent.VK_ENTER, "ENTER", "INTERACT"));
        keys.add(new Key(KeyEvent.VK_ESCAPE, "ESC", "PAUSE"));
        keys.add(new Key(KeyEvent.VK_B, "B", "INVENTORY"));
        keys.add(new Key(KeyEvent.VK_P, "P", "PHONE"));
    }

    static public int getKey(String keyTag) {
        for (Key k : keys) {
            if (k.getKeyTag().equals(keyTag)) {
                return k.getKey();
            }
        }
        return -1; // chua khai bao phim nay`
    }
    static public String getTypeKey(int code) {
        for (Key k : keys) {
            if (k.getKey() == code) {
                return k.getKeyTag();
            }
        }
        return "";
    }

    static public String getKeyName(String keyTag) {
        // System.out.println(keyTag);
        if(keys.size() != 0)    System.out.println(keys.get(0).getKeyName());
        for (Key k : keys) {
            if (k.getKeyTag() == keyTag) {
                return k.getKeyName();
            }
        }
        return ""; // chua khai bao phim nay`

    }

    static public void setKey(int key, String keyTag) {
        for (Key k : keys) {
            if (k.getKeyTag() == keyTag) {
                k.setKey(key);
                return;
            }
        }
    }

    public void keyTyped(KeyEvent e) { // nay la nguoi dung an roi tha ra

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            //System.out.println("Right key typed");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            //System.out.println("Left key typed");
        }

    }

    public void keyPressed(KeyEvent e) { // neu nguoi dung dang giu phim

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            // System.out.println("Right key pressed");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            // System.out.println("Left key pressed");
        }

    }

    public void keyReleased(KeyEvent e) { // neu nguoi dung vua tha tay khoi phim do
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            // System.out.println("Right key Released");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            // System.out.println("Left key Released");
        }
        releasedKey = e.getKeyCode();
        releasedKeyName = e.getKeyChar();
    }

    static public void resetReleasedKey() {
        releasedKey = -1;
    }

    static public int getReleasedKey() {
        return releasedKey;
    }

    static public char getReleasedKeyName() {
        return Character.toUpperCase(releasedKeyName);
    }
}