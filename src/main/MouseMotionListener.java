package main;

import java.awt.event.MouseEvent;

public class MouseMotionListener implements java.awt.event.MouseMotionListener {
    GamePanel gamePanel;
    Main_Menu mainMenu;
    NextMainMenu nextMainMenu;
    Setting setting = new Setting();
    public MouseMotionListener(GamePanel gamePanel, Main_Menu mainMenu, NextMainMenu nextMainMenu, Setting setting) {
        this.gamePanel = gamePanel;
        this.mainMenu = mainMenu;
        this.nextMainMenu = nextMainMenu;
        this.setting = setting;
    }
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x_enter = (int) e.getX();
        int y_enter = (int) e.getY();
        if (Main.Gametime == "MainMenu") {
            if ((x_enter > 311) && (y_enter > 425) && (x_enter < 456) && (y_enter < 464)) {
                mainMenu.buttonPlayEnter();
            } else if ((x_enter > 340) && (y_enter > 481) && (x_enter < 420) && (y_enter < 501)) {
                mainMenu.buttonExitEnter();
            } else if ((x_enter > 710) && (y_enter > 13) && (x_enter < 750) && (y_enter < 53)) {
                mainMenu.buttonSettingEnter();
            } else {
                mainMenu.rollback();
            }
        }
        else if (Main.Gametime == "NextMainMenu") {
            if ((x_enter > 260) && (y_enter > 330) && (x_enter < 507) && (y_enter < 367)) {
                nextMainMenu.buttonTutorialEnter();
            } else if ((x_enter > 244) && (y_enter > 210) && (x_enter < 527) && (y_enter < 246)) {
                nextMainMenu.buttonNewgameEnter();
            }else if ((x_enter > 710) && (y_enter > 13) && (x_enter < 750) && (y_enter < 53)) {
                nextMainMenu.buttonSettingEnter();
            } else if ((x_enter > 260) && (y_enter > 270) && (x_enter < 507) && (y_enter < 310)) {
                nextMainMenu.buttonContinueEnter();
            } else
                nextMainMenu.rollbacknext();
        }
        else if (Main.Gametime == "Setting") {
            if ((x_enter > 200) && (y_enter > 192) && (x_enter < 567) && (y_enter < 226)) {
                setting.buttonVideoEnter();
            } else if ((x_enter > 200) && (y_enter > 251) && (x_enter < 566) && (y_enter < 290)) {
                setting.buttonAudioEnter();
            } else if ((x_enter > 249) && (y_enter > 312) && (x_enter < 516) && (y_enter < 347)) {
                setting.buttonKeyEnter();
            } else
                setting.rollbacksetting();
        }
    }
}
