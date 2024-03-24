package main;

import java.awt.event.MouseEvent;

public class MouseMotionListener implements java.awt.event.MouseMotionListener {
    GamePanel gamePanel;
    Main_Menu mainMenu;
    NextMainMenu nextMainMenu;
    public MouseMotionListener(GamePanel gamePanel, Main_Menu mainMenu, NextMainMenu nextMainMenu) {
        this.gamePanel = gamePanel;
        this.mainMenu = mainMenu;
        this.nextMainMenu = nextMainMenu;
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
            if ((x_enter > 260) && (y_enter > 299) && (x_enter < 507) && (y_enter < 337)) {
                nextMainMenu.buttonTutorialEnter();
            } else if ((x_enter > 244) && (y_enter > 237) && (x_enter < 527) && (y_enter < 276)) {
                nextMainMenu.buttonNewgameEnter();
            }else if ((x_enter > 710) && (y_enter > 13) && (x_enter < 750) && (y_enter < 53)) {
                nextMainMenu.buttonSettingEnter();
            } else
                nextMainMenu.rollbacknext();

        }
    }
}
