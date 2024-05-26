package MainMenu;

import java.awt.event.MouseEvent;

import main.GamePanel;
import main.Main;
import sound.SoundManager;

public class MouseListener_Mainmenu implements java.awt.event.MouseListener {
    GamePanel gamePanel;
    Main_Menu mainMenu = GamePanel.mainMenu;
    NextMainMenu nextMainMenu = GamePanel.nextMainMenu;
    AudioSetting audioSetting = GamePanel.audioSetting;
    KeySetting keySetting = GamePanel.keySetting;
    VideoSetting videoSetting = GamePanel.videoSetting;
    Setting setting = GamePanel.setting;
    LoadGame loadGame = GamePanel.loadGame;
    PauseGame pauseGame = GamePanel.pauseGame;
    LoadGame2 loadGame2 = GamePanel.loadGame2;
    Tutorial tutorial = GamePanel.tutorial;

    public MouseListener_Mainmenu(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void mouseClicked(MouseEvent e) {
        //System.out.println(e.getPoint().getX());
        //System.out.println(e.getPoint().getY());
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
                mainMenu.rollback();
                nextMainMenu.Init();
            } else if ((x_click > 710 * Main.ex) && (y_click > 13 * Main.ey) && (x_click < 750 * Main.ex)
                    && (y_click < 53 * Main.ey)) {
                Main.pushGameState(Main.states[2]);
                mainMenu.rollback();
                setting.Init();
            }
        } else if (Main.topGameState().equals(Main.states[1])) {
            if ((x_click > 710 * Main.ex) && (y_click > 13 * Main.ey) && (x_click < 750 * Main.ex)
                    && (y_click < 53 * Main.ey)) {
                Main.pushGameState(Main.states[2]);
                nextMainMenu.Init();
            } else if ((x_click > 10 * Main.ex) && (y_click > 10 * Main.ey) && (x_click < 50 * Main.ex)
                    && (y_click < 50 * Main.ey)) {
                Main.popGameState();
                nextMainMenu.Init();
            } else if ((x_click > 244 * Main.ex) && (y_click > 210 * Main.ey) && (x_click < 527 * Main.ex)
                    && (y_click < 246 * Main.ey)) {
                Main.pushGameState(Main.states[7]);
                nextMainMenu.Init();
            } else if ((x_click > 260 * Main.ex) && (y_click > 270 * Main.ey) && (x_click < 507 * Main.ex)
                    && (y_click < 310 * Main.ey)) {
                Main.pushGameState(Main.states[12]);
                nextMainMenu.Init();
            } else if ((x_click > 260 * Main.ex) && (y_click > 330 * Main.ey) && (x_click < 507 * Main.ex)
                    && (y_click < 367 * Main.ey)) {
                Main.pushGameState(Main.states[6]);
                nextMainMenu.Init();
            }
        } else if (Main.topGameState().equals(Main.states[2])) {
            if ((x_click > 10 * Main.ex) && (y_click > 10 * Main.ey) && (x_click < 50 * Main.ex) // neu an back
                    && (y_click < 50 * Main.ey)) {
                Main.popGameState();
                setting.Init();
            } else if ((x_click > 200 * Main.ex) && (y_click > 192 * Main.ey) && (x_click < 565 * Main.ex)
                    && (y_click < 226 * Main.ey)) {
                Main.pushGameState(Main.states[5]);
                setting.Init();
            } else if ((x_click > 201 * Main.ex) && (y_click > 253 * Main.ey) && (x_click < 566 * Main.ex)
                    && (y_click < 287 * Main.ey)) {
                AudioSetting.volumesliderpointX = 542 * Main.ex;
                Main.pushGameState(Main.states[3]);
                setting.Init();
            } else if ((x_click > 251 * Main.ex) && (y_click > 313 * Main.ey) && (x_click < 514 * Main.ex)
                    && (y_click < 345 * Main.ey)) {
                Main.pushGameState(Main.states[4]);
                setting.Init();
            }
        } else if (Main.topGameState().equals(Main.states[3])) {
            if ((x_click > 10 * Main.ex) && (y_click > 10 * Main.ey) && (x_click < 50 * Main.ex)
                    && (y_click < 50 * Main.ey)) {
                Main.popGameState();
                audioSetting.audiorollback();
            } else if ((x_click > 240 * Main.ex) && (y_click > 251 * Main.ey) && (x_click < 600 * Main.ex)
                    && (y_click < 297 * Main.ey))
                AudioSetting.volumesliderpointX = (x_click - 23 * Main.ex);
            else if ((x_click > 169 * Main.ex) && (y_click > 260 * Main.ey) && (x_click < 204 * Main.ex)
                    && (y_click < 296 * Main.ey))
                AudioSetting.checkmute = (-1) * AudioSetting.checkmute;
        } else if (Main.topGameState().equals(Main.states[4])) {
            if (KeySetting.checkPressAKey) {
                if ((x_click > 10 * Main.ex) && (y_click > 10 * Main.ey) && (x_click < 50 * Main.ex)
                        && (y_click < 50 * Main.ey)) {
                    Main.popGameState();
                    keySetting.keysettingrollback();
                    keySetting.Init();
                } else if ((x_click > 37 * Main.ex) && (y_click > 87 * Main.ey) && (x_click < 135 * Main.ex)
                        && (y_click < 125 * Main.ey))
                    keySetting.keysetting_squareupchange();
                else if ((x_click > 37 * Main.ex) && (y_click > 137 * Main.ey) && (x_click < 135 * Main.ex)
                        && (y_click < 175 * Main.ey))
                    keySetting.keysetting_squaredownchange();
                else if ((x_click > 637 * Main.ex) && (y_click > 67 * Main.ey) && (x_click < 735 * Main.ex)
                        && (y_click < 125 * Main.ey))
                    keySetting.keysetting_squareleftchange();
                else if ((x_click > 637 * Main.ex) && (y_click > 137 * Main.ey) && (x_click < 735 * Main.ex)
                        && (y_click < 175 * Main.ey))
                    keySetting.keysetting_squarerightchange();
                else if ((x_click > 37 * Main.ex) && (y_click > 397 * Main.ey) && (x_click < 135 * Main.ex)
                        && (y_click < 435 * Main.ey))
                    keySetting.keysetting_square1change();
                else if ((x_click > 637 * Main.ex) && (y_click > 397 * Main.ey) && (x_click < 735 * Main.ex)
                        && (y_click < 435 * Main.ey))
                    keySetting.keysetting_square2change();
                else if ((x_click > 37 * Main.ex) && (y_click > 447 * Main.ey) && (x_click < 135 * Main.ex)
                        && (y_click < 485 * Main.ey))
                    keySetting.keysetting_square3change();
                else if ((x_click > 637 * Main.ex) && (y_click > 447 * Main.ey) && (x_click < 735 * Main.ex)
                        && (y_click < 485 * Main.ey))
                    keySetting.keysetting_square4change();
                else if ((x_click > 37 * Main.ex) && (y_click > 497 * Main.ey) && (x_click < 135 * Main.ex)
                        && (y_click < 535 * Main.ey))
                    keySetting.keysetting_square5change();
                else if ((x_click > 637 * Main.ex) && (y_click > 497 * Main.ey) && (x_click < 735 * Main.ex)
                        && (y_click < 535 * Main.ey))
                    keySetting.keysetting_square6change();
            }
        } else if (Main.topGameState().equals(Main.states[5])) {
            if ((x_click > 10 * Main.ex) && (y_click > 10 * Main.ey) && (x_click < 50 * Main.ex)
                    && (y_click < 50 * Main.ey)) {
                Main.popGameState();
                videoSetting.Init();
            } else if ((x_click > 417 * Main.ex) && (y_click > 281 * Main.ey) && (x_click < 448 * Main.ex)
                    && (y_click < 301 * Main.ey)) {
                if (!VideoSetting.checkResolution) {
                    VideoSetting.x1280x960 = "1280 x 960";
                    VideoSetting.x1792x1344 = "1792 x 1344";
                    VideoSetting.x2304x1728 = "2304 x 1728";
                    VideoSetting.x1024x768 = "1024 x 768";
                    VideoSetting.x768x576 = "768 x 576";
                    VideoSetting.x1536x1152 = "1536 x 1152";
                    VideoSetting.checkResolution = true;
                } else {
                    VideoSetting.x1280x960 = "";
                    VideoSetting.x1792x1344 = "";
                    VideoSetting.x2304x1728 = "";
                    VideoSetting.x1024x768 = "";
                    VideoSetting.x768x576 = "";
                    VideoSetting.x1536x1152 = "";
                    VideoSetting.checkResolution = false;
                }
            } else if ((x_click > 599 * Main.ex) && (y_click > 29 * Main.ey) && (x_click < 731 * Main.ex)
                    && (y_click < 81 * Main.ey)) {
                Main.ex = Main.next_ex;
                Main.ey = Main.next_ey;
                GamePanel.scale = GamePanel.next_scale;
                GamePanel.screenHeight = GamePanel.next_screenHeight;
                GamePanel.screenWidth = GamePanel.next_screenWidth;
                gamePanel.screenResize();
                Main.window.setSize((int) (GamePanel.screenWidth + 14), (int) (GamePanel.screenHeight + 37));
                Main.window.setLocationRelativeTo(null);
            }
            if (VideoSetting.checkResolution) {
                if ((x_click > 256 * Main.ex) && (y_click > 313 * Main.ey) && (x_click < 370 * Main.ex)
                        && (y_click < 338 * Main.ey)) {
                    VideoSetting.resolutionstr = "768 x 576";
                    VideoSetting.x1280x960 = "";
                    VideoSetting.x1792x1344 = "";
                    VideoSetting.x2304x1728 = "";
                    VideoSetting.x1024x768 = "";
                    VideoSetting.x768x576 = "";
                    VideoSetting.x1536x1152 = "";
                    Main.prev_ex = Main.ex;
                    Main.prev_ey = Main.ey;
                    Main.next_ex = 1;
                    Main.next_ey = 1;
                    GamePanel.prev_scale = GamePanel.scale;
                    GamePanel.next_scale = 3 * Main.next_ex;
                    GamePanel.prev_screenHeight = GamePanel.screenHeight;
                    GamePanel.prev_screenWidth = GamePanel.screenWidth;
                    GamePanel.next_screenWidth = 768;
                    GamePanel.next_screenHeight = 576;
                    videoSetting.videorollback();
                    VideoSetting.checkResolution = false;
                } else if ((x_click > 257 * Main.ex) && (y_click > 353 * Main.ey) && (x_click < 383 * Main.ex)
                        && (y_click < 378 * Main.ey)) {
                    VideoSetting.resolutionstr = "1024 x 768";
                    VideoSetting.x1280x960 = "";
                    VideoSetting.x1792x1344 = "";
                    VideoSetting.x2304x1728 = "";
                    VideoSetting.x1024x768 = "";
                    VideoSetting.x768x576 = "";
                    VideoSetting.x1536x1152 = "";
                    Main.prev_ex = Main.ex;
                    Main.prev_ey = Main.ey;
                    Main.next_ex = (double) 4 / 3;
                    Main.next_ey = (double) 4 / 3;
                    GamePanel.next_scale = 3 * Main.next_ex;
                    GamePanel.prev_scale = GamePanel.scale;
                    GamePanel.prev_screenHeight = GamePanel.screenHeight;
                    GamePanel.prev_screenWidth = GamePanel.screenWidth;
                    GamePanel.next_screenWidth = 1024;
                    GamePanel.next_screenHeight = 768;
                    videoSetting.videorollback();
                    VideoSetting.checkResolution = false;
                } else if ((x_click > 256 * Main.ex) && (y_click > 394 * Main.ey) && (x_click < 398 * Main.ex)
                        && (y_click < 420 * Main.ey)) {
                    VideoSetting.resolutionstr = "1536 x 1152";
                    VideoSetting.x1280x960 = "";
                    VideoSetting.x1792x1344 = "";
                    VideoSetting.x2304x1728 = "";
                    VideoSetting.x1024x768 = "";
                    VideoSetting.x768x576 = "";
                    VideoSetting.x1536x1152 = "";
                    Main.prev_ex = Main.ex;
                    Main.prev_ey = Main.ey;
                    Main.next_ex = 2;
                    Main.next_ey = 2;
                    GamePanel.next_scale = 3 * Main.next_ex;
                    GamePanel.prev_scale = GamePanel.scale;
                    GamePanel.prev_screenHeight = GamePanel.screenHeight;
                    GamePanel.prev_screenWidth = GamePanel.screenWidth;
                    GamePanel.next_screenWidth = 1536;
                    GamePanel.next_screenHeight = 1152;
                    videoSetting.videorollback();
                    VideoSetting.checkResolution = false;
                } else if ((x_click > 482 * Main.ex) && (y_click > 313 * Main.ey) && (x_click < 610 * Main.ex)
                        && (y_click < 338 * Main.ey)) {
                    VideoSetting.resolutionstr = "1280 x 960";
                    VideoSetting.x1280x960 = "";
                    VideoSetting.x1792x1344 = "";
                    VideoSetting.x2304x1728 = "";
                    VideoSetting.x1024x768 = "";
                    VideoSetting.x768x576 = "";
                    VideoSetting.x1536x1152 = "";
                    Main.prev_ex = Main.ex;
                    Main.prev_ey = Main.ey;
                    Main.next_ex = (double) 5 / 3;
                    Main.next_ey = (double) 5 / 3;
                    GamePanel.next_scale = 3 * Main.next_ex;
                    GamePanel.prev_scale = GamePanel.scale;
                    GamePanel.prev_screenHeight = GamePanel.screenHeight;
                    GamePanel.prev_screenWidth = GamePanel.screenWidth;
                    GamePanel.next_screenWidth = 1280;
                    GamePanel.next_screenHeight = 960;
                    videoSetting.videorollback();
                    VideoSetting.checkResolution = false;
                } else if ((x_click > 481 * Main.ex) && (y_click > 354 * Main.ey) && (x_click < 622 * Main.ex)
                        && (y_click < 378 * Main.ey)) {
                    VideoSetting.resolutionstr = "1792 x 1344";
                    VideoSetting.x1280x960 = "";
                    VideoSetting.x1792x1344 = "";
                    VideoSetting.x2304x1728 = "";
                    VideoSetting.x1024x768 = "";
                    VideoSetting.x768x576 = "";
                    VideoSetting.x1536x1152 = "";
                    Main.prev_ex = Main.ex;
                    Main.prev_ey = Main.ey;
                    Main.next_ex = (double) 7 / 3;
                    Main.next_ey = (double) 7 / 3;
                    GamePanel.next_scale = 3 * Main.next_ex;
                    GamePanel.prev_scale = GamePanel.scale;
                    GamePanel.prev_screenHeight = GamePanel.screenHeight;
                    GamePanel.prev_screenWidth = GamePanel.screenWidth;
                    GamePanel.next_screenWidth = 1792;
                    GamePanel.next_screenHeight = 1344;
                    videoSetting.videorollback();
                    VideoSetting.checkResolution = false;
                } else if ((x_click > 482 * Main.ex) && (y_click > 394 * Main.ey) && (x_click < 623 * Main.ex)
                        && (y_click < 418 * Main.ey)) {
                    VideoSetting.resolutionstr = "2304 x 1728";
                    VideoSetting.x1280x960 = "";
                    VideoSetting.x1792x1344 = "";
                    VideoSetting.x2304x1728 = "";
                    VideoSetting.x1024x768 = "";
                    VideoSetting.x768x576 = "";
                    VideoSetting.x1536x1152 = "";
                    Main.prev_ex = Main.ex;
                    Main.prev_ey = Main.ey;
                    Main.next_ex = 3;
                    Main.next_ey = 3;
                    GamePanel.next_scale = 3 * Main.next_ex;
                    GamePanel.prev_scale = GamePanel.scale;
                    GamePanel.prev_screenHeight = GamePanel.screenHeight;
                    GamePanel.prev_screenWidth = GamePanel.screenWidth;
                    GamePanel.next_screenWidth = 2304;
                    GamePanel.next_screenHeight = 1728;
                    videoSetting.videorollback();
                    VideoSetting.checkResolution = false;
                }
            }
        } else if (Main.topGameState().equals(Main.states[12])) {
            if ((x_click > 10 * Main.ex) && (y_click > 10 * Main.ey) && (x_click < 50 * Main.ex)
                    && (y_click < 50 * Main.ey)) {
                Main.popGameState();
                loadGame.buttonLoadGameReturnEnter();
                loadGame.Init();
            } else if ((x_click > 213 * Main.ex) && (y_click > 149 * Main.ey) && (x_click < 554 * Main.ex)
                    && (y_click < 260 * Main.ey)) {
                gamePanel.loadSaveGameSystem.loadGameSlot(1);
                loadGame.readFileLoadGame();
            } else if ((x_click > 213 * Main.ex) && (y_click > 279 * Main.ey) && (x_click < 554 * Main.ex)
                    && (y_click < 390 * Main.ey)) {
                gamePanel.loadSaveGameSystem.loadGameSlot(2);
            } else if ((x_click > 213 * Main.ex) && (y_click > 409 * Main.ey) && (x_click < 554 * Main.ex)
                    && (y_click < 520 * Main.ey)) {
                gamePanel.loadSaveGameSystem.loadGameSlot(3);
            }
        } else if (Main.topGameState().equals("PauseGame")) {
            if ((x_click > 260 * Main.ex) && (y_click > 270 * Main.ey) && (x_click < 507 * Main.ex)
                    && (y_click < 307 * Main.ey)) {
                Main.pushGameState(Main.states[6]);
                pauseGame.Init();
            } else if ((x_click > 324 * Main.ex) && (y_click > 390 * Main.ey) && (x_click < 444 * Main.ex)
                    && (y_click < 417 * Main.ey)) {
                Main.pushGameState(Main.states[0]);
                gamePanel.exitgame();
                SoundManager.stopAllSound();
                pauseGame.Init();
            } else if ((x_click > 710 * Main.ex) && (y_click > 13 * Main.ey) && (x_click < 750 * Main.ex)
                    && (y_click < 53 * Main.ey)) {
                Main.pushGameState(Main.states[2]);
                pauseGame.Init();
            } else if ((x_click > 260 * Main.ex) && (y_click > 210 * Main.ey) && (x_click < 507 * Main.ex)
                    && (y_click < 250 * Main.ey)) {
                Main.popGameState();
                pauseGame.Init();
            } else if ((x_click > 324 * Main.ex) && (y_click > 330 * Main.ey) && (x_click < 444 * Main.ex)
                    && (y_click < 357 * Main.ey)) {
                Main.pushGameState(Main.states[16]);
                pauseGame.Init();
            }
        } else if (Main.topGameState().equals(Main.states[16])) {
            if ((x_click > 10 * Main.ex) && (y_click > 10 * Main.ey) && (x_click < 50 * Main.ex)
                    && (y_click < 50 * Main.ey)) {
                Main.popGameState();
                loadGame2.buttonLoadGameReturnEnter();
                loadGame2.Init();
            } else if ((x_click > 213 * Main.ex) && (y_click > 149 * Main.ey) && (x_click < 554 * Main.ex)
                    && (y_click < 260 * Main.ey)) {
                gamePanel.loadSaveGameSystem.saveGameSlot(1);
                Main.pushGameState(Main.states[0]);
                loadGame.readFileLoadGame();
                pauseGame.Init();
            } else if ((x_click > 213 * Main.ex) && (y_click > 279 * Main.ey) && (x_click < 554 * Main.ex)
                    && (y_click < 390 * Main.ey)) {
                gamePanel.loadSaveGameSystem.saveGameSlot(2);
                Main.pushGameState(Main.states[0]);
                loadGame.readFileLoadGame();
                pauseGame.Init();
            } else if ((x_click > 213 * Main.ex) && (y_click > 409 * Main.ey) && (x_click < 554 * Main.ex)
                    && (y_click < 520 * Main.ey)) {
                gamePanel.loadSaveGameSystem.saveGameSlot(3);
                Main.pushGameState(Main.states[0]);
                loadGame.readFileLoadGame();
                pauseGame.Init();
            }
        } else if (Main.topGameState().equals(Main.states[6])) {
            if ((x_click > 10 * Main.ex) && (y_click > 10 * Main.ey) && (x_click < 50 * Main.ex)
                    && (y_click < 50 * Main.ey)) {
                Main.popGameState();
                tutorial.Init();
            } else if ((x_click > 689 * Main.ex) && (y_click > 261 * Main.ey) && (x_click < 721 * Main.ex)
                    && (y_click < 301 * Main.ey)) {
                Tutorial.isIntro = !(Tutorial.isIntro);
            } else if ((x_click > 44 * Main.ex) && (y_click > 261 * Main.ey) && (x_click < 76 * Main.ex)
                    && (y_click < 301 * Main.ey)) {
                Tutorial.isIntro = !(Tutorial.isIntro);
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
