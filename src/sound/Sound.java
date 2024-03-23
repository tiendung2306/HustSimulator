package sound;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    Clip clip;

    String soundName = "";
    URL soundURL;

    public Sound() {

    }

    public Sound(String name, String url) {
        this.soundName = name;
        try {
            File f = new File(url);
            this.soundURL = f.toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void setURL(String url) {
        soundURL = getClass().getResource(url);
    }

    public void setSoundName(String soundName) {
        this.soundName = soundName;
    }

    public String getSoundName() {
        return soundName;
    }

    public URL getSoundURL() {
        return soundURL;
    }

    public void setFile() {
        try {

            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void play() {
        setFile();
        clip.setFramePosition(0); // make sound play smoothly I guess xD
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY); // loop infinity times
    }

    public void stop() {
        if(this.clip != null)
            clip.stop();
    }
}