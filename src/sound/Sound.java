package sound;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound {
    Clip clip;

    String soundName = "";
    String url_str;
    URL soundURL;
    FloatControl floatControl;
    boolean runned = false;

    public Sound() {

    }

    public Sound(String name, String url) {
        this.soundName = name;
        this.url_str = url;
        try {
            File f = new File(url);
            this.soundURL = f.toURI().toURL();
            // floatControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public String getUrl_str() {
        return url_str;
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
            floatControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
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
        if (this.clip != null) {
            clip.stop();
            clip.close();
        }
    }

    public boolean checkStop() {
        if(this.clip != null) {
            if(this.clip.isRunning())   this.runned = true;
            if(this.runned && !this.clip.isRunning()) {
                clip.close();
                return true;
            }
        }
        return false;
    }
}