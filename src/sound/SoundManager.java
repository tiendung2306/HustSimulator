package sound;

import java.util.ArrayList;

public class SoundManager {

    public static ArrayList<Sound> sounds = new ArrayList<Sound>();

    public void addSound(Sound sound) {
        sounds.add(sound);
    }

    public void removeSound(Sound sound) {
        sounds.remove(sound);
    }

    public void playSound(String name) {
        for(Sound s: sounds) {
            if(s.soundName.equals(name)) {
                s.play();
            }
        }
    }

    public void loopSound(String name) {
        for(Sound s: sounds) {
            if(s.soundName.equals(name)) {
                s.play();
                s.loop();
            }
        }
    }

    public void stopSound(String name) {
        for(Sound s: sounds) {
            if(s.soundName.equals(name)) {
                s.stop();
            }
        }
    }

    public void stopAllSound() {
        for(Sound s: sounds) {
            s.stop();
        }
    }

}
