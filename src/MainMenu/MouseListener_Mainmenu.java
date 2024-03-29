package MainMenu;

//import DeveloperTest.Thai;
//import main.GamePanel;
import main.GamePanel;
import main.Main;

import java.awt.event.MouseEvent;

public class MouseListener_Mainmenu implements java.awt.event.MouseListener {
    GamePanel gamePanel;
    Main_Menu mainMenu = new Main_Menu();
    NextMainMenu nextMainMenu = new NextMainMenu();
    AudioSetting audioSetting = new AudioSetting();
    public MouseListener_Mainmenu(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x_click = (int) e.getPoint().getX();
        int y_click = (int) e.getPoint().getY();
        System.out.println(x_click);
        System.out.println(y_click);
        if (Main.topGameState() == "MainMenu") {
            if ((x_click > 340) && (y_click > 478) && (x_click < 420) && (y_click < 501)) {
                System.exit(0);
            } else if ((x_click > 311) && (y_click > 425) && (x_click < 456) && (y_click < 464)) {
                Main.pushGameState("NextMainMenu");
            } else if ((x_click > 710) && (y_click > 13) && (x_click < 750) && (y_click < 53)) {
                Main.pushGameState("Setting");
            } else if ((x_click > 260) && (y_click > 299) && (x_click < 507) && (y_click < 337)) {
                Main.pushGameState("Tutorial");
            } else if ((x_click > 244) && (y_click > 237) && (x_click < 527) && (y_click < 276)) {
                Main.pushGameState("NewGame");
            }
        }
         else if (Main.topGameState() == "NextMainMenu") {
            if ((x_click > 710) && (y_click > 13) && (x_click < 750) && (y_click < 53)) {
                Main.pushGameState("Setting");
            }
            else if ((x_click > 10) && (y_click > 10) && (x_click < 50) && (y_click < 50))
            {
                Main.popGameState();
            } else if ((x_click > 262) && (y_click > 331) && (x_click < 504) && (y_click < 366)) {
                Main.pushGameState("tutorial");
            }
        } else if (Main.topGameState() == "Setting") {
            if ((x_click > 10) && (y_click > 10) && (x_click < 50) && (y_click < 50))
                Main.popGameState();
            else if ((x_click > 200) && (y_click > 192) && (x_click < 565) && (y_click < 226)) {
                Main.pushGameState("videosetting");
            } else if ((x_click > 201) && (y_click > 253) && (x_click < 566) && (y_click < 287)) {
                Main.pushGameState("audiosetting");
            } else if ((x_click > 251) && (y_click > 313) && (x_click < 514) && (y_click < 345)) {
                Main.pushGameState("keysetting");
            }
        } else if (Main.topGameState() == "audiosetting") {
            if ((x_click > 10) && (y_click > 10) && (x_click < 50) && (y_click < 50))
                Main.popGameState();
            else if ((x_click > 220) && (y_click > 251) && (x_click < 620) && (y_click < 297))
                AudioSetting.volumesliderpointX = (x_click - 23);
            else if ((x_click > 169) && (y_click > 260) && (x_click < 204) && (y_click < 296))
                AudioSetting.checkmute = (-1)*AudioSetting.checkmute;
        }

    }
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}

