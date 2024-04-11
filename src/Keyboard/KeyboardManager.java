/*
 * keyboardManager.getKey("UP") //tra ve phim w
 */

package Keyboard;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.KeyListener;

public class KeyboardManager implements KeyListener {
    static ArrayList<Key> keys = new ArrayList<Key>();

    public void init() { // tell me if you want add new key
        keys.add(new Key(KeyEvent.VK_W, "UP"));
        keys.add(new Key(KeyEvent.VK_A, "LEFT"));
        keys.add(new Key(KeyEvent.VK_S, "DOWN"));
        keys.add(new Key(KeyEvent.VK_D, "RIGHT"));
        keys.add(new Key(KeyEvent.VK_F, "INTERACT"));
        keys.add(new Key(KeyEvent.VK_ESCAPE, "PAUSE"));
        keys.add(new Key(KeyEvent.VK_B, "INVENTORY"));
        keys.add(new Key(KeyEvent.VK_X, "POP"));
        keys.add(new Key(KeyEvent.VK_P, "PHONE"));
    }

    public int getKey(String keyTag) {
        for (Key k : keys) {
            if (k.getKeyTag() == keyTag) {
                return k.getKey();
            }
        }
        return -1; // chua khai bao phim nay`
    }

    public void setKey(int key, String keyTag) {
        for (Key k : keys) {
            if (k.getKeyTag() == keyTag) {
                k.setKey(key);
                return;
            }
        }
    }

    public void keyTyped(KeyEvent e) { // nay la nguoi dung an roi tha ra

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Right key typed");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Left key typed");
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
    }
}