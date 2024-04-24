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
    LoadGame loadGame;

    public MouseMotionListener_Mainmenu(GamePanel gamePanel, Main_Menu mainMenu, NextMainMenu nextMainMenu,
            Setting setting, AudioSetting audioSetting, KeySetting keySetting, VideoSetting videoSetting, LoadGame loadGame) {
        this.gamePanel = gamePanel;
        this.mainMenu = mainMenu;
        this.nextMainMenu = nextMainMenu;
        this.setting = setting;
        this.audioSetting = audioSetting;
        this.keySetting = keySetting;
        this.videoSetting = videoSetting;
        this.loadGame = loadGame;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x_drag = e.getX();
        // int y_drag = e.getY();
        if (Main.topGameState().equals(Main.states[3])) {
            if (AudioSetting.checkenterslider) {
                if ((x_drag >= 240 * Main.ex) && (x_drag <= 602 * Main.ex))
                    audioSetting.volumesliderpointX((int) (x_drag - 23 * Main.ex));
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x_enter = e.getX();
        int y_enter = e.getY();
        if (Main.topGameState().equals(Main.states[0])) {
            if ((x_enter > 311 * Main.ex) && (y_enter > 425 * Main.ey) && (x_enter < 456 * Main.ex)
                    && (y_enter < 464 * Main.ey))
                mainMenu.buttonPlayEnter();
            else if ((x_enter > 340 * Main.ex) && (y_enter > 478 * Main.ey) && (x_enter < 420 * Main.ex)
                    && (y_enter < 501 * Main.ey))
                mainMenu.buttonExitEnter();
            else if ((x_enter > 710 * Main.ex) && (y_enter > 13 * Main.ey) && (x_enter < 750 * Main.ex)
                    && (y_enter < 53 * Main.ey))
                mainMenu.buttonSettingEnter();
            else
                mainMenu.rollback();
        } else if (Main.topGameState().equals(Main.states[1])) {
            if ((x_enter > 260 * Main.ex) && (y_enter > 330 * Main.ey) && (x_enter < 507 * Main.ex)
                    && (y_enter < 367 * Main.ey))
                nextMainMenu.buttonTutorialEnter();
            else if ((x_enter > 244 * Main.ex) && (y_enter > 210 * Main.ey) && (x_enter < 527 * Main.ex)
                    && (y_enter < 246 * Main.ey))
                nextMainMenu.buttonNewgameEnter();
            else if ((x_enter > 710 * Main.ex) && (y_enter > 13 * Main.ey) && (x_enter < 750 * Main.ex)
                    && (y_enter < 53 * Main.ey))
                nextMainMenu.buttonSettingEnter();
            else if ((x_enter > 260 * Main.ex) && (y_enter > 270 * Main.ey) && (x_enter < 507 * Main.ex)
                    && (y_enter < 310 * Main.ey))
                nextMainMenu.buttonContinueEnter();
            else if ((x_enter > 10 * Main.ex) && (y_enter > 10 * Main.ey) && (x_enter < 50 * Main.ex)
                    && (y_enter < 50 * Main.ey))
                nextMainMenu.buttonReturnEnter();
            else
                nextMainMenu.rollbacknext();
        } else if (Main.topGameState().equals(Main.states[2])) {
            if ((x_enter > 200 * Main.ex) && (y_enter > 192 * Main.ey) && (x_enter < 567 * Main.ex)
                    && (y_enter < 226 * Main.ey))
                setting.buttonVideoEnter();
            else if ((x_enter > 200 * Main.ex) && (y_enter > 251 * Main.ey) && (x_enter < 566 * Main.ex)
                    && (y_enter < 290 * Main.ey))
                setting.buttonAudioEnter();
            else if ((x_enter > 249 * Main.ex) && (y_enter > 312 * Main.ey) && (x_enter < 516 * Main.ex)
                    && (y_enter < 347 * Main.ey))
                setting.buttonKeyEnter();
            else if ((x_enter > 10 * Main.ex) && (y_enter > 10 * Main.ey) && (x_enter < 50 * Main.ex)
                    && (y_enter < 50 * Main.ey))
                setting.buttonReturnEnter();
            else
                setting.rollbacksetting();
        } else if (Main.topGameState().equals(Main.states[3])) {
            if ((x_enter > 220 * Main.ex) && (y_enter > 251 * Main.ey) && (x_enter < 620 * Main.ex)
                    && (y_enter < 297 * Main.ey)) {
                AudioSetting.checkenterslider = true;
                audioSetting.checkcomment();
            } else if ((x_enter > 10 * Main.ex) && (y_enter > 10 * Main.ey) && (x_enter < 50 * Main.ex)
                    && (y_enter < 50 * Main.ey)) {
                audioSetting.buttonReturnEnter();
                AudioSetting.checkenterslider = false;
            } else if ((x_enter > 169 * Main.ex) && (y_enter > 260 * Main.ey) && (x_enter < 204 * Main.ex)
                    && (y_enter < 296 * Main.ey))
                audioSetting.muteEnter();
            else {
                AudioSetting.checkenterslider = false;
                audioSetting.audiorollback();
            }
        } else if (Main.topGameState().equals(Main.states[4])) {
            if (KeySetting.checkPressAKey)
            {
                if ((x_enter > 10 * Main.ex) && (y_enter > 10 * Main.ey) && (x_enter < 50 * Main.ex)
                        && (y_enter < 50 * Main.ey))
                    keySetting.buttonReturnEnter();
                else if ((x_enter > 67 * Main.ex) && (y_enter > 87 * Main.ey) && (x_enter < 105 * Main.ex)
                        && (y_enter < 125 * Main.ey))
                    keySetting.keysetting_squareup();
                else if ((x_enter > 67 * Main.ex) && (y_enter > 137 * Main.ey) && (x_enter < 105 * Main.ex)
                        && (y_enter < 175 * Main.ey))
                    keySetting.keysetting_squaredown();
                else if ((x_enter > 667 * Main.ex) && (y_enter > 67 * Main.ey) && (x_enter < 705 * Main.ex)
                        && (y_enter < 125 * Main.ey))
                    keySetting.keysetting_squareleft();
                else if ((x_enter > 667 * Main.ex) && (y_enter > 137 * Main.ey) && (x_enter < 705 * Main.ex)
                        && (y_enter < 175 * Main.ey))
                    keySetting.keysetting_squareright();
                else if ((x_enter > 67 * Main.ex) && (y_enter > 397 * Main.ey) && (x_enter < 105 * Main.ex)
                        && (y_enter < 435 * Main.ey))
                    keySetting.keysetting_square1();
                else if ((x_enter > 667 * Main.ex) && (y_enter > 397 * Main.ey) && (x_enter < 705 * Main.ex)
                        && (y_enter < 435 * Main.ey))
                    keySetting.keysetting_square2();
                else if ((x_enter > 67 * Main.ex) && (y_enter > 447 * Main.ey) && (x_enter < 105 * Main.ex)
                        && (y_enter < 485 * Main.ey))
                    keySetting.keysetting_square3();
                else if ((x_enter > 667 * Main.ex) && (y_enter > 447 * Main.ey) && (x_enter < 705 * Main.ex)
                        && (y_enter < 485 * Main.ey))
                    keySetting.keysetting_square4();
                else if ((x_enter > 67 * Main.ex) && (y_enter > 497 * Main.ey) && (x_enter < 105 * Main.ex)
                        && (y_enter < 535 * Main.ey))
                    keySetting.keysetting_square5();
                else if ((x_enter > 667 * Main.ex) && (y_enter > 497 * Main.ey) && (x_enter < 705 * Main.ex)
                        && (y_enter < 535 * Main.ey))
                    keySetting.keysetting_square6();
                else keySetting.keysettingrollback();
            }
        } else if (Main.topGameState().equals(Main.states[5])) {
            if ((x_enter > 10 * Main.ex) && (y_enter > 10 * Main.ey) && (x_enter < 50 * Main.ex)
                    && (y_enter < 50 * Main.ey)) {
                videoSetting.buttonvideoReturnEnter();
            } else if ((x_enter > 599 * Main.ex) && (y_enter > 29 * Main.ey) && (x_enter < 731 * Main.ex)
                    && (y_enter < 81 * Main.ey)) {
                videoSetting.buttonSaveEnter();
            } else if ((x_enter > 256 * Main.ex) && (y_enter > 313 * Main.ey) && (x_enter < 370 * Main.ex)
                    && (y_enter < 338 * Main.ey) && VideoSetting.checkResolution) {
                videoSetting.x768x576enter();
            } else if ((x_enter > 257 * Main.ex) && (y_enter > 353 * Main.ey) && (x_enter < 383 * Main.ex)
                    && (y_enter < 378 * Main.ey) && VideoSetting.checkResolution) {
                videoSetting.x1024x768enter();
            } else if ((x_enter > 256 * Main.ex) && (y_enter > 394 * Main.ey) && (x_enter < 398 * Main.ex)
                    && (y_enter < 420 * Main.ey) && VideoSetting.checkResolution) {
                videoSetting.x1536x1152enter();
            } else if ((x_enter > 482 * Main.ex) && (y_enter > 313 * Main.ey) && (x_enter < 610 * Main.ex)
                    && (y_enter < 338 * Main.ey) && VideoSetting.checkResolution) {
                videoSetting.x1280x960enter();
            } else if ((x_enter > 481 * Main.ex) && (y_enter > 354 * Main.ey) && (x_enter < 622 * Main.ex)
                    && (y_enter < 378 * Main.ey) && VideoSetting.checkResolution) {
                videoSetting.x1792x1344enter();
            } else if ((x_enter > 482 * Main.ex) && (y_enter > 394 * Main.ey) && (x_enter < 623 * Main.ex)
                    && (y_enter < 418 * Main.ey) && VideoSetting.checkResolution) {
                videoSetting.x2304x1728enter();
            } else {
                videoSetting.videorollback();
            }
        } else if (Main.topGameState().equals(Main.states[12])) {
            if ((x_enter > 10 * Main.ex) && (y_enter > 10 * Main.ey) && (x_enter < 50 * Main.ex)
                    && (y_enter < 50 * Main.ey))
                loadGame.buttonLoadGameReturnEnter();
            else loadGame.LoadGamerollback();
        }
    }
}
