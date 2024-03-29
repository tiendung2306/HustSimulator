/*
 * soundManager.addSound(new Sound("piano_music", "res/sound/pianos-by-jtwayne-7-174717.wav"));
 * soundManager.loopSound("piano_music");
 */

package sound;

import java.util.ArrayList;

public class SoundManager {

    private static float prevVolume = 0;
    private static float currVolume = 0;
    static boolean mute = false;

    public static ArrayList<Sound> sounds = new ArrayList<Sound>();
    public static ArrayList<Sound> currRunningSounds = new ArrayList<Sound>();

    public SoundManager() {

    }

    public void addSound(Sound sound) {
        sounds.add(sound);
    }

    public void removeSound(Sound sound) { //cam thang nao dung`, thang nao muon dung` ham` nay phai hoi t truoc
        sounds.remove(sound);
    }

    public void playSound(String name) { // Phat am thanh 1 lan
        for (Sound s : sounds) {
            if (s.soundName.equals(name)) {
                String url = s.getUrl_str();
                Sound tmp = new Sound(name, url);
                currRunningSounds.add(tmp);
                tmp.play();
            }
        }
    }

    public void loopSound(String name) { // phat am thanh vo han lan
        for (Sound s : sounds) {
            if (s.soundName.equals(name)) {
                String url = s.getUrl_str();
                Sound tmp = new Sound(name, url);
                currRunningSounds.add(tmp);
                tmp.play();
                tmp.loop();
            }
        }
    }

    public void stopSound(String name) { // dung am thanh
        ArrayList<Sound> deleted_sound = new ArrayList<Sound>();
        for (int i = 0; i < currRunningSounds.size(); i++) {
            Sound s = currRunningSounds.get(i);
            if (s.soundName.equals(name)) {
                s.stop();
                deleted_sound.add(s);
            }
        }
        for (Sound s : deleted_sound) {
            currRunningSounds.remove(s);
        }
    }

    public void stopAllSound() {
        ArrayList<Sound> deleted_sound = new ArrayList<Sound>();
        for (int i = 0; i < currRunningSounds.size(); i++) {
            Sound s = currRunningSounds.get(i);
            s.stop();
            deleted_sound.add(s);
        }
        for (Sound s : deleted_sound) {
            currRunningSounds.remove(s);
        }
    }

    public void update() {
        ArrayList<Sound> deleted_sound = new ArrayList<Sound>();
        for (int i = 0; i < currRunningSounds.size(); i++) {
            Sound s = currRunningSounds.get(i);
            if (s.checkStop()) {
                // System.out.println(s.clip.isRunning());
                // System.out.println(s.getSoundName());
                // System.out.println("da xoa!!!");
                deleted_sound.add(s);
            }
        }
        for (Sound s : deleted_sound) {
            currRunningSounds.remove(s);
        }
    }


    // 0.0 -> 1.0
    public void volumeUp() {
        currVolume += 1.0f;
        if (currVolume > 6.0f)
            currVolume = 6.0f;
        for (Sound s : currRunningSounds) {
            try {
                s.floatControl.setValue(currVolume);
            } catch (Exception e) {

            }
        }
        // System.out.println(currVolume);
    }

    public void volumeDown() {
        currVolume -= 1.0f;
        if (currVolume < -80.0f)
            currVolume = -80.0f;
        for (Sound s : currRunningSounds) {
            try {
                s.floatControl.setValue(currVolume);
            } catch (Exception e) {

            }
        }
        // System.out.println(currVolume);
    }

    public void volumeMute() {
        if (mute == false) {
            prevVolume = currVolume;
            currVolume = -80.0f;
            for (Sound s : currRunningSounds) {
                try {
                    s.floatControl.setValue(currVolume);
                } catch (Exception e) {

                }
            }
            mute = true;
        } else if (mute == true) {
            currVolume = prevVolume;
            for (Sound s : currRunningSounds) {
                try {
                    s.floatControl.setValue(currVolume);
                } catch (Exception e) {

                }
            }
            mute = false;
        }
        // System.out.println(currVolume);
    }

}
