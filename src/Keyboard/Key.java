package Keyboard;

public class Key {
    int key; // W, A, S, Enter (VK_W VK_A VK_Enter)
    String keyName;
    String keyTag; // Up, Down, Fire, Interact

    public Key(int key, String keyName, String keyTag) {
        this.key = key;
        this.keyTag = keyTag;
        this.keyName = keyName;
    }

    public int getKey() {
        return key;
    }

    public String getKeyTag() {
        return keyTag;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setKeyTag(String keyTag) {
        this.keyTag = keyTag;
    }
    
}