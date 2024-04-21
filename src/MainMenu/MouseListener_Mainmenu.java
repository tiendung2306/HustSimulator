package MainMenu;

//import DeveloperTest.Thai;
//import main.GamePanel;
import main.GamePanel;
import main.Main;

import javax.swing.*;
import java.awt.*;
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
        // int y_click = (int) ;
        // System.out.println(e.getPoint().getX());
        // System.out.println(e.getPoint().getY());
        // if (Main.topGameState().equals(Main.states[0])) {
        // if ((x_click > 340 * Main.ex) && (y_click > 478 * Main.ex) && (x_click < 420
        // * Main.ex)
        // && (y_click < 501 * Main.ex)) {
        // System.exit(0);
        // } else if ((x_click > 311 * Main.ex) && (y_click > 425 * Main.ex) && (x_click
        // < 456 * Main.ex)
        // && (y_click < 464 * Main.ex)) {
        // Main.pushGameState(Main.states[1]);
        // nextMainMenu.Init();
        // } else if ((x_click > 710 * Main.ex) && (y_click > 13 * Main.ex) && (x_click
        // < 750 * Main.ex)
        // && (y_click < 53 * Main.ex)) {
        // Main.pushGameState(Main.states[2]);
        // setting.Init();
        // }
        // } else if (Main.topGameState().equals(Main.states[1])) {
        // if ((x_click > 710 * Main.ex) && (y_click > 13 * Main.ex) && (x_click < 750 *
        // Main.ex)
        // && (y_click < 53 * Main.ex)) {
        // Main.pushGameState(Main.states[2]);
        // setting.Init();
        // } else if ((x_click > 10 * Main.ex) && (y_click > 10 * Main.ex) && (x_click <
        // 50 * Main.ex)
        // && (y_click < 50 * Main.ex))
        // Main.popGameState();
        // else if ((x_click > 262 * Main.ex) && (y_click > 331 * Main.ex) && (x_click <
        // 504 * Main.ex)
        // && (y_click < 366 * Main.ex))
        // Main.pushGameState(Main.states[6]);
        // else if ((x_click > 260 * Main.ex) && (y_click > 299 * Main.ex) && (x_click <
        // 507 * Main.ex)
        // && (y_click < 337 * Main.ex)) {
        // Main.pushGameState(Main.states[6]);
        // } else if ((x_click > 244 * Main.ex) && (y_click > 237 * Main.ex) && (x_click
        // < 527 * Main.ex)
        // && (y_click < 276 * Main.ex)) {
        // Main.pushGameState(Main.states[7]);
        // }
        // } else if (Main.topGameState().equals(Main.states[2])) {
        // if ((x_click > 10 * Main.ex) && (y_click > 10 * Main.ex) && (x_click < 50 *
        // Main.ex) // neu an back
        // && (y_click < 50 * Main.ex))
        // Main.popGameState();
        // else if ((x_click > 200 * Main.ex) && (y_click > 192 * Main.ex) && (x_click <
        // 565 * Main.ex)
        // && (y_click < 226 * Main.ex)) {
        // Main.pushGameState(Main.states[5]);
        // videoSetting.Init();
        // } else if ((x_click > 201 * Main.ex) && (y_click > 253 * Main.ex) && (x_click
        // < 566 * Main.ex)
        // && (y_click < 287 * Main.ex)) {
        // Main.pushGameState(Main.states[3]);
        // audioSetting.Init();
        // } else if ((x_click > 251 * Main.ex) && (y_click > 313 * Main.ex) && (x_click
        // < 514 * Main.ex)
        // && (y_click < 345 * Main.ex)) {
        // Main.pushGameState(Main.states[4]);
        // keySetting.Init();
        // }
        // } else if (Main.topGameState().equals(Main.states[3])) {
        // if ((x_click > 10 * Main.ex) && (y_click > 10 * Main.ex) && (x_click < 50 *
        // Main.ex)
        // && (y_click < 50 * Main.ex))
        // Main.popGameState();
        // else if ((x_click > 240 * Main.ex) && (y_click > 251 * Main.ex) && (x_click <
        // 600 * Main.ex)
        // && (y_click < 297 * Main.ex))
        // AudioSetting.volumesliderpointX = (x_click - 23 * Main.ex);
        // else if ((x_click > 169 * Main.ex) && (y_click > 260 * Main.ex) && (x_click <
        // 204 * Main.ex)
        // && (y_click < 296 * Main.ex))
        // AudioSetting.checkmute = (-1) * AudioSetting.checkmute;
        // } else if (Main.topGameState().equals(Main.states[4])) {
        // if ((x_click > 10 * Main.ex) && (y_click > 10 * Main.ex) && (x_click < 50 *
        // Main.ex)
        // && (y_click < 50 * Main.ex))
        // Main.popGameState();
        // } else if (Main.topGameState().equals(Main.states[5])) {
        // if ((x_click > 10 * Main.ex) && (y_click > 10 * Main.ex) && (x_click < 50 *
        // Main.ex)
        // && (y_click < 50 * Main.ex))
        // Main.popGameState();
        // }
    }

    public void mousePressed(MouseEvent e) {
        int x_click = (int) e.getPoint().getX();
        int y_click = (int) e.getPoint().getY();
        if (Main.topGameState().equals(Main.states[0])) {
            if ((x_click > 340 * Main.ex) && (y_click > 478 * Main.ey) && (x_click < 420 * Main.ex)
                    && (y_click < 501 * Main.ey)) {
                System.exit(0);
            } else if ((x_click > 311 * Main.ex) && (y_click > 425 * Main.ey) && (x_click < 456 * Main.ex)
                    && (y_click < 464 * Main.ey)) {
                Main.pushGameState(Main.states[1]);
                nextMainMenu.Init();
            } else if ((x_click > 710 * Main.ex) && (y_click > 13 * Main.ey) && (x_click < 750 * Main.ex)
                    && (y_click < 53 * Main.ey)) {
                Main.pushGameState(Main.states[2]);
                setting.Init();
            }
        } else if (Main.topGameState().equals(Main.states[1])) {
            if ((x_click > 710 * Main.ex) && (y_click > 13 * Main.ey) && (x_click < 750 * Main.ex)
                    && (y_click < 53 * Main.ey)) {
                Main.pushGameState(Main.states[2]);
                setting.Init();
            } else if ((x_click > 10 * Main.ex) && (y_click > 10 * Main.ey) && (x_click < 50 * Main.ex)
                    && (y_click < 50 * Main.ey))
                Main.popGameState();
            else if ((x_click > 244 * Main.ex) && (y_click > 210 * Main.ey) && (x_click < 527 * Main.ex)
                    && (y_click < 246 * Main.ey))
                Main.pushGameState(Main.states[7]);
            else if ((x_click > 260 * Main.ex) && (y_click > 270 * Main.ey) && (x_click < 507 * Main.ex)
                    && (y_click < 310 * Main.ey)) {
                Main.pushGameState(Main.states[7]);
            } else if ((x_click > 260 * Main.ex) && (y_click > 330 * Main.ey) && (x_click < 507 * Main.ex)
                    && (y_click < 367 * Main.ey)) {
                Main.pushGameState(Main.states[6]);
            }
        } else if (Main.topGameState().equals(Main.states[2])) {
            if ((x_click > 10 * Main.ex) && (y_click > 10 * Main.ey) && (x_click < 50 * Main.ex) // neu an back
                    && (y_click < 50 * Main.ey))
                Main.popGameState();
            else if ((x_click > 200 * Main.ex) && (y_click > 192 * Main.ey) && (x_click < 565 * Main.ex)
                    && (y_click < 226 * Main.ey)) {
                Main.pushGameState(Main.states[5]);
                videoSetting.Init();
            } else if ((x_click > 201 * Main.ex) && (y_click > 253 * Main.ey) && (x_click < 566 * Main.ex)
                    && (y_click < 287 * Main.ey)) {
                Main.pushGameState(Main.states[3]);
                audioSetting.Init();
            } else if ((x_click > 251 * Main.ex) && (y_click > 313 * Main.ey) && (x_click < 514 * Main.ex)
                    && (y_click < 345 * Main.ey)) {
                Main.pushGameState(Main.states[4]);
                keySetting.Init();
            }
        } else if (Main.topGameState().equals(Main.states[3])) {
            if ((x_click > 10 * Main.ex) && (y_click > 10 * Main.ey) && (x_click < 50 * Main.ex)
                    && (y_click < 50 * Main.ey))
                Main.popGameState();
            else if ((x_click > 240 * Main.ex) && (y_click > 251 * Main.ey) && (x_click < 600 * Main.ex)
                    && (y_click < 297 * Main.ey))
                AudioSetting.volumesliderpointX = (x_click - 23 * Main.ex);
            else if ((x_click > 169 * Main.ex) && (y_click > 260 * Main.ey) && (x_click < 204 * Main.ex)
                    && (y_click < 296 * Main.ey))
                AudioSetting.checkmute = (-1) * AudioSetting.checkmute;
        } else if (Main.topGameState().equals(Main.states[4])) {
            if (KeySetting.checkPressAKey) {
                if ((x_click > 10 * Main.ex) && (y_click > 10 * Main.ey) && (x_click < 50 * Main.ex)
                        && (y_click < 50 * Main.ey))
                    Main.popGameState();
                else if ((x_click > 67 * Main.ex) && (y_click > 87 * Main.ey) && (x_click < 105 * Main.ex)
                        && (y_click < 125 * Main.ey))
                    keySetting.keysetting_squareupchange();
                else if ((x_click > 67 * Main.ex) && (y_click > 137 * Main.ey) && (x_click < 105 * Main.ex)
                        && (y_click < 175 * Main.ey))
                    keySetting.keysetting_squaredownchange();
                else if ((x_click > 667 * Main.ex) && (y_click > 67 * Main.ey) && (x_click < 705 * Main.ex)
                        && (y_click < 125 * Main.ey))
                    keySetting.keysetting_squareleftchange();
                else if ((x_click > 667 * Main.ex) && (y_click > 137 * Main.ey) && (x_click < 705 * Main.ex)
                        && (y_click < 175 * Main.ey))
                    keySetting.keysetting_squarerightchange();
            }
        } else if (Main.topGameState().equals(Main.states[5])) {
            if ((x_click > 10 * Main.ex) && (y_click > 10 * Main.ey) && (x_click < 50 * Main.ex)
                    && (y_click < 50 * Main.ey))
                Main.popGameState();
            else if (((x_click > 555 * Main.ex) && (y_click > 202 * Main.ey) && (x_click < 572 * Main.ex)
                    && (y_click < 226 * Main.ey)) ||
                    ((x_click > 286 * Main.ex) && (y_click > 202 * Main.ey) && (x_click < 303 * Main.ex)
                            && (y_click < 228 * Main.ey))) {
                if (VideoSetting.fullscreenstr.equals("WINDOW"))
                    VideoSetting.fullscreenstr = "FULLSCREEN";
                else
                    VideoSetting.fullscreenstr = "WINDOW";
                if (VideoSetting.fullscreenstrX == 358)
                    VideoSetting.fullscreenstrX = 316;
                else
                    VideoSetting.fullscreenstrX = 358;
            } else if ((x_click > 417 * Main.ex) && (y_click > 391 * Main.ey) && (x_click < 448 * Main.ex)
                    && (y_click < 411 * Main.ey)) {
                if (!VideoSetting.checkResolution) {
                    VideoSetting.x2560x1440 = "2560 x 1440";
                    VideoSetting.x1920x1080 = "1920 x 1080";
                    VideoSetting.x1280x720 = "1280 x 720";
                    VideoSetting.x1024x768 = "1024 x 768";
                    VideoSetting.x768x576 = "768 x 576";
                    VideoSetting.x1536x1152 = "1536 x 1152";
                    VideoSetting.checkResolution = true;
                } else {
                    VideoSetting.x2560x1440 = "";
                    VideoSetting.x1920x1080 = "";
                    VideoSetting.x1280x720 = "";
                    VideoSetting.x1024x768 = "";
                    VideoSetting.x768x576 = "";
                    VideoSetting.x1536x1152 = "";
                    VideoSetting.checkResolution = false;
                }
            } else if ((x_click > 599 * Main.ex) && (y_click > 29 * Main.ey) && (x_click < 731 * Main.ex)
                    && (y_click < 81 * Main.ey)) {
                Main.ex = Main.next_ex;
                Main.ey = Main.next_ey;
                GamePanel.screenHeight = GamePanel.next_screenHeight;
                GamePanel.screenWidth = GamePanel.next_screenWidth;
                gamePanel.screenResize();
                Main.window.setSize((int) GamePanel.screenWidth, (int) GamePanel.screenHeight);
                Main.window.setLocationRelativeTo(null);

                // if (VideoSetting.fullscreenstr.equals("FULLSCREEN")){
                // GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                // GraphicsDevice gd = ge.getDefaultScreenDevice();
                // gd.setFullScreenWindow(Main.window);
                //// SwingUtilities.updateComponentTreeUI(Main.window);
                // DisplayMode oldMode = gd.getDisplayMode();
                // DisplayMode newMode = new
                // DisplayMode(GamePanel.screenWidth,GamePanel.screenHeight,oldMode.getBitDepth(),oldMode.getRefreshRate());
                // // gd.setDisplayMode(newMode);
                //// Main.window.setUndecorated(true);
                // Main.ex = (double) Main.window.getWidth()/768;
                // Main.ey = (double) Main.window.getHeight()/576;
                // } else {
                // Main.window.setSize(GamePanel.screenWidth,GamePanel.screenHeight);
                // Main.window.setLocationRelativeTo(null);
                // Main.ex = (double) GamePanel.screenWidth/768; Main.ey = (double)
                // GamePanel.screenHeight/576;
                // }
            }
            if (VideoSetting.checkResolution) {
                if ((x_click > 225 * Main.ex) && (y_click > 423 * Main.ey) && (x_click < 370 * Main.ex)
                        && (y_click < 448 * Main.ey)) {
                    VideoSetting.resolutionstr = "768 x 576";
                    VideoSetting.x2560x1440 = "";
                    VideoSetting.x1920x1080 = "";
                    VideoSetting.x1280x720 = "";
                    VideoSetting.x1024x768 = "";
                    VideoSetting.x768x576 = "";
                    VideoSetting.x1536x1152 = "";
                    Main.prev_ex = Main.ex;
                    Main.prev_ey = Main.ey;
                    Main.next_ex = 1;
                    Main.next_ey = 1;
                    GamePanel.prev_screenHeight = GamePanel.screenHeight;
                    GamePanel.prev_screenWidth = GamePanel.screenWidth;
                    GamePanel.next_screenWidth = 768;
                    GamePanel.next_screenHeight = 576;
                    VideoSetting.checkResolution = false;
                } else if ((x_click > 257 * Main.ex) && (y_click > 463 * Main.ey) && (x_click < 383 * Main.ex)
                        && (y_click < 488 * Main.ey)) {
                    VideoSetting.resolutionstr = "1024 x 768";
                    VideoSetting.x2560x1440 = "";
                    VideoSetting.x1920x1080 = "";
                    VideoSetting.x1280x720 = "";
                    VideoSetting.x1024x768 = "";
                    VideoSetting.x768x576 = "";
                    VideoSetting.x1536x1152 = "";
                    Main.prev_ex = Main.ex;
                    Main.prev_ey = Main.ey;
                    Main.next_ex = (double) 4 / 3;
                    Main.next_ey = (double) 4 / 3;
                    GamePanel.prev_screenHeight = GamePanel.screenHeight;
                    GamePanel.prev_screenWidth = GamePanel.screenWidth;
                    GamePanel.next_screenWidth = 1024;
                    GamePanel.next_screenHeight = 786;
                    VideoSetting.checkResolution = false;
                } else if ((x_click > 256 * Main.ex) && (y_click > 504 * Main.ey) && (x_click < 398 * Main.ex)
                        && (y_click < 530 * Main.ey)) {
                    VideoSetting.resolutionstr = "1536 x 1152";
                    VideoSetting.x2560x1440 = "";
                    VideoSetting.x1920x1080 = "";
                    VideoSetting.x1280x720 = "";
                    VideoSetting.x1024x768 = "";
                    VideoSetting.x768x576 = "";
                    VideoSetting.x1536x1152 = "";
                    Main.prev_ex = Main.ex;
                    Main.prev_ey = Main.ey;
                    Main.next_ex = 2;
                    Main.next_ey = 2;
                    GamePanel.prev_screenHeight = GamePanel.screenHeight;
                    GamePanel.prev_screenWidth = GamePanel.screenWidth;
                    GamePanel.next_screenWidth = 1536;
                    GamePanel.next_screenHeight = 1152;
                    VideoSetting.checkResolution = false;
                } else if ((x_click > 482 * Main.ex) && (y_click > 423 * Main.ey) && (x_click < 610 * Main.ex)
                        && (y_click < 448 * Main.ey)) {
                    VideoSetting.resolutionstr = "1280 x 720";
                    VideoSetting.x2560x1440 = "";
                    VideoSetting.x1920x1080 = "";
                    VideoSetting.x1280x720 = "";
                    VideoSetting.x1024x768 = "";
                    VideoSetting.x768x576 = "";
                    VideoSetting.x1536x1152 = "";
                    Main.prev_ex = Main.ex;
                    Main.prev_ey = Main.ey;
                    Main.next_ex = (double) 5 / 3;
                    Main.next_ey = 1.25;
                    GamePanel.prev_screenHeight = GamePanel.screenHeight;
                    GamePanel.prev_screenWidth = GamePanel.screenWidth;
                    GamePanel.next_screenWidth = 1280;
                    GamePanel.next_screenHeight = 720;
                    VideoSetting.checkResolution = false;
                } else if ((x_click > 481 * Main.ex) && (y_click > 464 * Main.ey) && (x_click < 622 * Main.ex)
                        && (y_click < 488 * Main.ey)) {
                    VideoSetting.resolutionstr = "1920 x 1080";
                    VideoSetting.x2560x1440 = "";
                    VideoSetting.x1920x1080 = "";
                    VideoSetting.x1280x720 = "";
                    VideoSetting.x1024x768 = "";
                    VideoSetting.x768x576 = "";
                    VideoSetting.x1536x1152 = "";
                    Main.prev_ex = Main.ex;
                    Main.prev_ey = Main.ey;
                    Main.next_ex = 2.5;
                    Main.next_ey = 1.875;
                    GamePanel.prev_screenHeight = GamePanel.screenHeight;
                    GamePanel.prev_screenWidth = GamePanel.screenWidth;
                    GamePanel.next_screenWidth = 1920;
                    GamePanel.next_screenHeight = 1080;
                    VideoSetting.checkResolution = false;
                } else if ((x_click > 482 * Main.ex) && (y_click > 504 * Main.ey) && (x_click < 623 * Main.ex)
                        && (y_click < 528 * Main.ey)) {
                    VideoSetting.resolutionstr = "2560 x 1440";
                    VideoSetting.x2560x1440 = "";
                    VideoSetting.x1920x1080 = "";
                    VideoSetting.x1280x720 = "";
                    VideoSetting.x1024x768 = "";
                    VideoSetting.x768x576 = "";
                    VideoSetting.x1536x1152 = "";
                    Main.prev_ex = Main.ex;
                    Main.prev_ey = Main.ey;
                    Main.next_ex = (double) 10 / 3;
                    Main.next_ey = 2.5;
                    GamePanel.prev_screenHeight = GamePanel.screenHeight;
                    GamePanel.prev_screenWidth = GamePanel.screenWidth;
                    GamePanel.next_screenWidth = 2560;
                    GamePanel.next_screenHeight = 1440;
                    VideoSetting.checkResolution = false;
                }
            }
        }
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

}
