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
    public MouseMotionListener_Mainmenu(GamePanel gamePanel, Main_Menu mainMenu, NextMainMenu nextMainMenu, Setting setting, AudioSetting audioSetting) {
        this.gamePanel = gamePanel;
        this.mainMenu = mainMenu;
        this.nextMainMenu = nextMainMenu;
        this.setting = setting;
        this.audioSetting = audioSetting;
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        int x_drag = e.getX();
        int y_drag = e.getY();
        if (Main.topGameState() == "audiosetting") {
            if (AudioSetting.checkenterslider == true) {
                if ((x_drag >= 240) && (x_drag <= 600))
                audioSetting.volumesliderpointX(x_drag - 23);
            }
        }
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x_enter = e.getX();
        int y_enter = e.getY();
        if (Main.topGameState() == "MainMenu") {
            if ((x_enter > 311) && (y_enter > 425) && (x_enter < 456) && (y_enter < 464)) {
                mainMenu.buttonPlayEnter();
            } else if ((x_enter > 340) && (y_enter > 478) && (x_enter < 420) && (y_enter < 501)) {
                mainMenu.buttonExitEnter();
            } else if ((x_enter > 710) && (y_enter > 13) && (x_enter < 750) && (y_enter < 53)) {
                mainMenu.buttonSettingEnter();
            } else {
                mainMenu.rollback();
            }
        } else if (Main.topGameState() == "NextMainMenu") {
            if ((x_enter > 260) && (y_enter > 330) && (x_enter < 507) && (y_enter < 367)) {
                nextMainMenu.buttonTutorialEnter();
            } else if ((x_enter > 244) && (y_enter > 210) && (x_enter < 527) && (y_enter < 246)) {
                nextMainMenu.buttonNewgameEnter();
            } else if ((x_enter > 710) && (y_enter > 13) && (x_enter < 750) && (y_enter < 53)) {
                nextMainMenu.buttonSettingEnter();
            } else if ((x_enter > 260) && (y_enter > 270) && (x_enter < 507) && (y_enter < 310)) {
                nextMainMenu.buttonContinueEnter();
            } else if ((x_enter > 10) && (y_enter > 10) && (x_enter < 50) && (y_enter < 50)) {
                nextMainMenu.buttonReturnEnter();
            } else
                nextMainMenu.rollbacknext();
        } else if (Main.topGameState() == "Setting") {
            if ((x_enter > 200) && (y_enter > 192) && (x_enter < 567) && (y_enter < 226)) {
                setting.buttonVideoEnter();
            } else if ((x_enter > 200) && (y_enter > 251) && (x_enter < 566) && (y_enter < 290)) {
                setting.buttonAudioEnter();
            } else if ((x_enter > 249) && (y_enter > 312) && (x_enter < 516) && (y_enter < 347)) {
                setting.buttonKeyEnter();
            } else if ((x_enter > 10) && (y_enter > 10) && (x_enter < 50) && (y_enter < 50)) {
                setting.buttonReturnEnter();
            } else
                setting.rollbacksetting();
        } else if (Main.topGameState() == "audiosetting") {
            if ((x_enter > 220) && (y_enter > 251) && (x_enter < 620) && (y_enter < 297)) {
                AudioSetting.checkenterslider = true;
                audioSetting.checkcomment();
            } else if ((x_enter > 10) && (y_enter > 10) && (x_enter < 50) && (y_enter < 50)) {
                audioSetting.buttonReturnEnter();
                AudioSetting.checkenterslider = false;
            } else if ((x_enter > 169) && (y_enter > 260) && (x_enter < 204) && (y_enter < 296)) {
                audioSetting.muteEnter();
            } else {
                AudioSetting.checkenterslider = false;
                audioSetting.audiorollback();
            }
        }
    }
}
