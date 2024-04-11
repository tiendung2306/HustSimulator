package MainMenu;

//import DeveloperTest.Thai;
//import main.GamePanel;
import main.GamePanel;
import main.Main;

import java.awt.event.MouseEvent;

public class MouseListener_Mainmenu implements java.awt.event.MouseListener {
    GamePanel gamePanel;
    Main_Menu mainMenu = GamePanel.mainMenu;
    NextMainMenu nextMainMenu = GamePanel.nextMainMenu;
    AudioSetting audioSetting = GamePanel.audioSetting;
    KeySetting keySetting = GamePanel.keySetting;
    VideoSetting videoSetting = GamePanel.videoSetting;
    Setting setting = GamePanel.setting;

    public MouseListener_Mainmenu(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void mouseClicked(MouseEvent e) {
        // int x_click = (int) e.getPoint().getX();
        // int y_click = (int) e.getPoint().getY();
        // // System.out.println(x_click);
        // // System.out.println(y_click);
        // if (Main.topGameState().equals(Main.states[0])) {
        //     if ((x_click > 340 * Main.ex) && (y_click > 478 * Main.ex) && (x_click < 420 * Main.ex)
        //             && (y_click < 501 * Main.ex)) {
        //         System.exit(0);
        //     } else if ((x_click > 311 * Main.ex) && (y_click > 425 * Main.ex) && (x_click < 456 * Main.ex)
        //             && (y_click < 464 * Main.ex)) {
        //         Main.pushGameState(Main.states[1]);
        //         nextMainMenu.Init();
        //     } else if ((x_click > 710 * Main.ex) && (y_click > 13 * Main.ex) && (x_click < 750 * Main.ex)
        //             && (y_click < 53 * Main.ex)) {
        //         Main.pushGameState(Main.states[2]);
        //         setting.Init();
        //     }
        // } else if (Main.topGameState().equals(Main.states[1])) {
        //     if ((x_click > 710 * Main.ex) && (y_click > 13 * Main.ex) && (x_click < 750 * Main.ex)
        //             && (y_click < 53 * Main.ex)) {
        //         Main.pushGameState(Main.states[2]);
        //         setting.Init();
        //     } else if ((x_click > 10 * Main.ex) && (y_click > 10 * Main.ex) && (x_click < 50 * Main.ex)
        //             && (y_click < 50 * Main.ex))
        //         Main.popGameState();
        //     else if ((x_click > 262 * Main.ex) && (y_click > 331 * Main.ex) && (x_click < 504 * Main.ex)
        //             && (y_click < 366 * Main.ex))
        //         Main.pushGameState(Main.states[6]);
        //     else if ((x_click > 260 * Main.ex) && (y_click > 299 * Main.ex) && (x_click < 507 * Main.ex)
        //             && (y_click < 337 * Main.ex)) {
        //         Main.pushGameState(Main.states[6]);
        //     } else if ((x_click > 244 * Main.ex) && (y_click > 237 * Main.ex) && (x_click < 527 * Main.ex)
        //             && (y_click < 276 * Main.ex)) {
        //         Main.pushGameState(Main.states[7]);
        //     }
        // } else if (Main.topGameState().equals(Main.states[2])) {
        //     if ((x_click > 10 * Main.ex) && (y_click > 10 * Main.ex) && (x_click < 50 * Main.ex) // neu an back
        //             && (y_click < 50 * Main.ex))
        //         Main.popGameState();
        //     else if ((x_click > 200 * Main.ex) && (y_click > 192 * Main.ex) && (x_click < 565 * Main.ex)
        //             && (y_click < 226 * Main.ex)) {
        //         Main.pushGameState(Main.states[5]);
        //         videoSetting.Init();
        //     } else if ((x_click > 201 * Main.ex) && (y_click > 253 * Main.ex) && (x_click < 566 * Main.ex)
        //             && (y_click < 287 * Main.ex)) {
        //         Main.pushGameState(Main.states[3]);
        //         audioSetting.Init();
        //     } else if ((x_click > 251 * Main.ex) && (y_click > 313 * Main.ex) && (x_click < 514 * Main.ex)
        //             && (y_click < 345 * Main.ex)) {
        //         Main.pushGameState(Main.states[4]);
        //         keySetting.Init();
        //     }
        // } else if (Main.topGameState().equals(Main.states[3])) {
        //     if ((x_click > 10 * Main.ex) && (y_click > 10 * Main.ex) && (x_click < 50 * Main.ex)
        //             && (y_click < 50 * Main.ex))
        //         Main.popGameState();
        //     else if ((x_click > 240 * Main.ex) && (y_click > 251 * Main.ex) && (x_click < 600 * Main.ex)
        //             && (y_click < 297 * Main.ex))
        //         AudioSetting.volumesliderpointX = (x_click - 23 * Main.ex);
        //     else if ((x_click > 169 * Main.ex) && (y_click > 260 * Main.ex) && (x_click < 204 * Main.ex)
        //             && (y_click < 296 * Main.ex))
        //         AudioSetting.checkmute = (-1) * AudioSetting.checkmute;
        // } else if (Main.topGameState().equals(Main.states[4])) {
        //     if ((x_click > 10 * Main.ex) && (y_click > 10 * Main.ex) && (x_click < 50 * Main.ex)
        //             && (y_click < 50 * Main.ex))
        //         Main.popGameState();
        // } else if (Main.topGameState().equals(Main.states[5])) {
        //     if ((x_click > 10 * Main.ex) && (y_click > 10 * Main.ex) && (x_click < 50 * Main.ex)
        //             && (y_click < 50 * Main.ex))
        //         Main.popGameState();
        // }
    }

    public void mousePressed(MouseEvent e) {
        int x_click = (int) e.getPoint().getX();
        int y_click = (int) e.getPoint().getY();
         System.out.println(x_click);
         System.out.println(y_click);
        if (Main.topGameState().equals(Main.states[0])) {
            if ((x_click > 340 * Main.ex) && (y_click > 478 * Main.ex) && (x_click < 420 * Main.ex)
                    && (y_click < 501 * Main.ex)) {
                System.exit(0);
            } else if ((x_click > 311 * Main.ex) && (y_click > 425 * Main.ex) && (x_click < 456 * Main.ex)
                    && (y_click < 464 * Main.ex)) {
                Main.pushGameState(Main.states[1]);
                nextMainMenu.Init();
            } else if ((x_click > 710 * Main.ex) && (y_click > 13 * Main.ex) && (x_click < 750 * Main.ex)
                    && (y_click < 53 * Main.ex)) {
                Main.pushGameState(Main.states[2]);
                setting.Init();
            }
        } else if (Main.topGameState().equals(Main.states[1])) {
            if ((x_click > 710 * Main.ex) && (y_click > 13 * Main.ex) && (x_click < 750 * Main.ex)
                    && (y_click < 53 * Main.ex)) {
                Main.pushGameState(Main.states[2]);
                setting.Init();
            } else if ((x_click > 10 * Main.ex) && (y_click > 10 * Main.ex) && (x_click < 50 * Main.ex)
                    && (y_click < 50 * Main.ex))
                Main.popGameState();
            else if ((x_click > 244 * Main.ex) && (y_click > 210 * Main.ex) && (x_click < 527 * Main.ex)
                    && (y_click < 246 * Main.ex))
                Main.pushGameState(Main.states[8]);
            else if ((x_click > 260 * Main.ex) && (y_click > 270 * Main.ex) && (x_click < 507 * Main.ex)
                    && (y_click < 310 * Main.ex)) {
                Main.pushGameState(Main.states[8]);
            } else if ((x_click > 260 * Main.ex) && (y_click > 330 * Main.ex) && (x_click < 507 * Main.ex)
                    && (y_click < 367 * Main.ex)) {
                Main.pushGameState(Main.states[6]);
            }
        } else if (Main.topGameState().equals(Main.states[2])) {
            if ((x_click > 10 * Main.ex) && (y_click > 10 * Main.ex) && (x_click < 50 * Main.ex) // neu an back
                    && (y_click < 50 * Main.ex))
                Main.popGameState();
            else if ((x_click > 200 * Main.ex) && (y_click > 192 * Main.ex) && (x_click < 565 * Main.ex)
                    && (y_click < 226 * Main.ex)) {
                Main.pushGameState(Main.states[5]);
                videoSetting.Init();
            } else if ((x_click > 201 * Main.ex) && (y_click > 253 * Main.ex) && (x_click < 566 * Main.ex)
                    && (y_click < 287 * Main.ex)) {
                Main.pushGameState(Main.states[3]);
                audioSetting.Init();
            } else if ((x_click > 251 * Main.ex) && (y_click > 313 * Main.ex) && (x_click < 514 * Main.ex)
                    && (y_click < 345 * Main.ex)) {
                Main.pushGameState(Main.states[4]);
                keySetting.Init();
            }
        } else if (Main.topGameState().equals(Main.states[3])) {
            if ((x_click > 10 * Main.ex) && (y_click > 10 * Main.ex) && (x_click < 50 * Main.ex)
                    && (y_click < 50 * Main.ex))
                Main.popGameState();
            else if ((x_click > 240 * Main.ex) && (y_click > 251 * Main.ex) && (x_click < 600 * Main.ex)
                    && (y_click < 297 * Main.ex))
                AudioSetting.volumesliderpointX = (x_click - 23 * Main.ex);
            else if ((x_click > 169 * Main.ex) && (y_click > 260 * Main.ex) && (x_click < 204 * Main.ex)
                    && (y_click < 296 * Main.ex))
                AudioSetting.checkmute = (-1) * AudioSetting.checkmute;
        } else if (Main.topGameState().equals(Main.states[4])) {
            if (KeySetting.checkpressakey)
            {
                if ((x_click > 10 * Main.ex) && (y_click > 10 * Main.ex) && (x_click < 50 * Main.ex)
                        && (y_click < 50 * Main.ex))
                    Main.popGameState();
                else if ((x_click > 67 * Main.ex) && (y_click > 87 * Main.ex) && (x_click < 105 * Main.ex)
                        && (y_click < 125 * Main.ex))
                    keySetting.keysetting_squareupchange();
                else if ((x_click > 67 * Main.ex) && (y_click > 137 * Main.ex) && (x_click < 105 * Main.ex)
                        && (y_click < 175 * Main.ex))
                    keySetting.keysetting_squaredownchange();
                else if ((x_click > 667 * Main.ex) && (y_click > 67 * Main.ex) && (x_click < 705 * Main.ex)
                        && (y_click < 125 * Main.ex))
                    keySetting.keysetting_squareleftchange();
                else if ((x_click > 667 * Main.ex) && (y_click > 137 * Main.ex) && (x_click < 705 * Main.ex)
                        && (y_click < 175 * Main.ex))
                    keySetting.keysetting_squarerightchange();
            }
        } else if (Main.topGameState().equals(Main.states[5])) {
            if ((x_click > 10 * Main.ex) && (y_click > 10 * Main.ex) && (x_click < 50 * Main.ex)
                    && (y_click < 50 * Main.ex))
                Main.popGameState();
            else if ((x_click > 240 * Main.ex) && (y_click > 251 * Main.ex) && (x_click < 600 * Main.ex)
                    && (y_click < 297 * Main.ex))
                VideoSetting.qualitysliderpointX = (x_click - 23 * Main.ex);
        }
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

}
