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
            if ((x_click > 340*Main.ex) && (y_click > 478*Main.ex) && (x_click < 420*Main.ex) && (y_click < 501*Main.ex)) {
                System.exit(0);
            } else if ((x_click > 311*Main.ex) && (y_click > 425*Main.ex) && (x_click < 456*Main.ex) && (y_click < 464*Main.ex)) {
                Main.pushGameState("NextMainMenu");
            } else if ((x_click > 710*Main.ex) && (y_click > 13*Main.ex) && (x_click < 750*Main.ex) && (y_click < 53*Main.ex)) {
                Main.pushGameState("Setting");
            } else if ((x_click > 260*Main.ex) && (y_click > 299*Main.ex) && (x_click < 507*Main.ex) && (y_click < 337*Main.ex)) {
                Main.pushGameState("Tutorial");
            } else if ((x_click > 244*Main.ex) && (y_click > 237*Main.ex) && (x_click < 527*Main.ex) && (y_click < 276*Main.ex)) {
                Main.pushGameState("NewGame");
            }
        }
         else if (Main.topGameState() == "NextMainMenu") {
            if ((x_click > 710*Main.ex) && (y_click > 13*Main.ex) && (x_click < 750*Main.ex) && (y_click < 53*Main.ex))
                Main.pushGameState("Setting");
            else if ((x_click > 10*Main.ex) && (y_click > 10*Main.ex) && (x_click < 50*Main.ex) && (y_click < 50*Main.ex))
                Main.popGameState();
            else if ((x_click > 262*Main.ex) && (y_click > 331*Main.ex) && (x_click < 504*Main.ex) && (y_click < 366*Main.ex))
                Main.pushGameState("tutorial");
        } else if (Main.topGameState() == "Setting") {
            if ((x_click > 10*Main.ex) && (y_click > 10*Main.ex) && (x_click < 50*Main.ex) && (y_click < 50*Main.ex))
                Main.popGameState();
            else if ((x_click > 200*Main.ex) && (y_click > 192*Main.ex) && (x_click < 565*Main.ex) && (y_click < 226*Main.ex))
                Main.pushGameState("videosetting");
            else if ((x_click > 201*Main.ex) && (y_click > 253*Main.ex) && (x_click < 566*Main.ex) && (y_click < 287*Main.ex))
                Main.pushGameState("audiosetting");
            else if ((x_click > 251*Main.ex) && (y_click > 313*Main.ex) && (x_click < 514*Main.ex) && (y_click < 345*Main.ex))
                Main.pushGameState("keysetting");
        } else if (Main.topGameState() == "audiosetting") {
            if ((x_click > 10*Main.ex) && (y_click > 10*Main.ex) && (x_click < 50*Main.ex) && (y_click < 50*Main.ex))
                Main.popGameState();
            else if ((x_click > 220*Main.ex) && (y_click > 251*Main.ex) && (x_click < 620*Main.ex) && (y_click < 297*Main.ex))
                AudioSetting.volumesliderpointX = (x_click - 23*Main.ex);
            else if ((x_click > 169*Main.ex) && (y_click > 260*Main.ex) && (x_click < 204*Main.ex) && (y_click < 296*Main.ex))
                AudioSetting.checkmute = (-1)*AudioSetting.checkmute;
        } else if (Main.topGameState() == "keysetting") {
            if ((x_click > 10*Main.ex) && (y_click > 10*Main.ex) && (x_click < 50*Main.ex) && (y_click < 50*Main.ex))
                Main.popGameState();
        } else if (Main.topGameState() == "videosetting") {
            if ((x_click > 10*Main.ex) && (y_click > 10*Main.ex) && (x_click < 50*Main.ex) && (y_click < 50*Main.ex))
                Main.popGameState();
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

