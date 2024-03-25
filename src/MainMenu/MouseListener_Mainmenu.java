package MainMenu;

import DeveloperTest.Thai;
//import main.GamePanel;
import main.Main;

import java.awt.event.MouseEvent;

public class MouseListener_Mainmenu implements java.awt.event.MouseListener {
    Thai thai;
    Main_Menu mainMenu = new Main_Menu();
    NextMainMenu nextMainMenu = new NextMainMenu();
    public MouseListener_Mainmenu(Thai thai) {
        this.thai = thai;
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
            }
        } else if (Main.topGameState() == "Setting") {
            if ((x_click > 10) && (y_click > 10) && (x_click < 50) && (y_click < 50))
            {
                Main.popGameState();
            }
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

