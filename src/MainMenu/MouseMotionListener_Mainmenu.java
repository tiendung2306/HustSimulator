package MainMenu;

//import DeveloperTest.Thai;
import main.GamePanel;
import main.Main;

import java.awt.event.MouseEvent;

public class MouseMotionListener_Mainmenu implements java.awt.event.MouseMotionListener {
    GamePanel gamePanel;
    Main_Menu mainMenu;
    NextMainMenu nextMainMenu;
    Setting setting;
    AudioSetting audioSetting;
    KeySetting keySetting;
    VideoSetting videoSetting;
    public MouseMotionListener_Mainmenu(GamePanel gamePanel, Main_Menu mainMenu, NextMainMenu nextMainMenu, Setting setting, AudioSetting audioSetting, KeySetting keySetting, VideoSetting videoSetting) {
        this.gamePanel = gamePanel;
        this.mainMenu = mainMenu;
        this.nextMainMenu = nextMainMenu;
        this.setting = setting;
        this.audioSetting = audioSetting;
        this.keySetting = keySetting;
        this.videoSetting = videoSetting;
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        int x_drag = e.getX();
        //int y_drag = e.getY();
        if (Main.topGameState().equals("audiosetting")) {
            if (AudioSetting.checkenterslider) {
                if ((x_drag >= 240*Main.ex) && (x_drag <= 600*Main.ex))
                    audioSetting.volumesliderpointX(x_drag - 23*Main.ex);
            }
        }
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        int x_enter = e.getX();
        int y_enter = e.getY();
        if (Main.topGameState().equals("MainMenu")) {
            if ((x_enter > 311*Main.ex) && (y_enter > 425*Main.ex) && (x_enter < 456*Main.ex) && (y_enter < 464*Main.ex))
                mainMenu.buttonPlayEnter();
            else if ((x_enter > 340*Main.ex) && (y_enter > 478*Main.ex) && (x_enter < 420*Main.ex) && (y_enter < 501*Main.ex))
                mainMenu.buttonExitEnter();
            else if ((x_enter > 710*Main.ex) && (y_enter > 13*Main.ex) && (x_enter < 750*Main.ex) && (y_enter < 53*Main.ex))
                mainMenu.buttonSettingEnter();
            else
                mainMenu.rollback();
        } else if (Main.topGameState().equals("NextMainMenu")) {
            if ((x_enter > 260*Main.ex) && (y_enter > 330*Main.ex) && (x_enter < 507*Main.ex) && (y_enter < 367*Main.ex))
                nextMainMenu.buttonTutorialEnter();
            else if ((x_enter > 244*Main.ex) && (y_enter > 210*Main.ex) && (x_enter < 527*Main.ex) && (y_enter < 246*Main.ex))
                nextMainMenu.buttonNewgameEnter();
            else if ((x_enter > 710*Main.ex) && (y_enter > 13*Main.ex) && (x_enter < 750*Main.ex) && (y_enter < 53*Main.ex))
                nextMainMenu.buttonSettingEnter();
            else if ((x_enter > 260*Main.ex) && (y_enter > 270*Main.ex) && (x_enter < 507*Main.ex) && (y_enter < 310*Main.ex))
                nextMainMenu.buttonContinueEnter();
            else if ((x_enter > 10*Main.ex) && (y_enter > 10*Main.ex) && (x_enter < 50*Main.ex) && (y_enter < 50*Main.ex))
                nextMainMenu.buttonReturnEnter();
            else
                nextMainMenu.rollbacknext();
        } else if (Main.topGameState().equals("Setting")) {
            if ((x_enter > 200*Main.ex) && (y_enter > 192*Main.ex) && (x_enter < 567*Main.ex) && (y_enter < 226*Main.ex))
                setting.buttonVideoEnter();
            else if ((x_enter > 200*Main.ex) && (y_enter > 251*Main.ex) && (x_enter < 566*Main.ex) && (y_enter < 290*Main.ex))
                setting.buttonAudioEnter();
            else if ((x_enter > 249*Main.ex) && (y_enter > 312*Main.ex) && (x_enter < 516*Main.ex) && (y_enter < 347*Main.ex))
                setting.buttonKeyEnter();
            else if ((x_enter > 10*Main.ex) && (y_enter > 10*Main.ex) && (x_enter < 50*Main.ex) && (y_enter < 50*Main.ex))
                setting.buttonReturnEnter();
            else
                setting.rollbacksetting();
        } else if (Main.topGameState().equals("audiosetting")) {
            if ((x_enter > 220*Main.ex) && (y_enter > 251*Main.ex) && (x_enter < 620*Main.ex) && (y_enter < 297*Main.ex)) {
                AudioSetting.checkenterslider = true;
                audioSetting.checkcomment();
            } else if ((x_enter > 10*Main.ex) && (y_enter > 10*Main.ex) && (x_enter < 50*Main.ex) && (y_enter < 50*Main.ex)) {
                audioSetting.buttonReturnEnter();
                AudioSetting.checkenterslider = false;
            } else if ((x_enter > 169*Main.ex) && (y_enter > 260*Main.ex) && (x_enter < 204*Main.ex) && (y_enter < 296*Main.ex))
                audioSetting.muteEnter();
            else {
                AudioSetting.checkenterslider = false;
                audioSetting.audiorollback();
            }
        } else if (Main.topGameState().equals("keysetting")) {
            if ((x_enter > 10*Main.ex) && (y_enter > 10*Main.ex) && (x_enter < 50*Main.ex) && (y_enter < 50*Main.ex))
                keySetting.buttonReturnEnter();
        } else if (Main.topGameState().equals("videosetting")) {
            if ((x_enter > 10*Main.ex) && (y_enter > 10*Main.ex) && (x_enter < 50*Main.ex) && (y_enter < 50*Main.ex))
                videoSetting.buttonReturnEnter();
        }
    }
}

