package main;

import java.awt.event.MouseEvent;

public class MouseListener implements java.awt.event.MouseListener {
    GamePanel gamePanel;
    Main_Menu mainMenu = new Main_Menu();
    NextMainMenu nextMainMenu = new NextMainMenu();
    public MouseListener(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x_click = (int) e.getPoint().getX();
        int y_click = (int) e.getPoint().getY();
        System.out.println(x_click);
        System.out.println(y_click);
        if (Main.Gametime == "MainMenu") {
            if ((x_click > 340) && (y_click > 481) && (x_click < 420) && (y_click < 501)) {
                System.exit(0);
            } else if ((x_click > 311) && (y_click > 425) && (x_click < 456) && (y_click < 464)) {
                Main.Gametime = "NextMainMenu";
            } else if ((x_click > 710) && (y_click > 13) && (x_click < 750) && (y_click < 53)) {
                Main.Gametime = "Setting";
            } else if ((x_click > 260) && (y_click > 299) && (x_click < 507) && (y_click < 337)) {
                Main.Gametime = "Tutorial";
            } else if ((x_click > 244) && (y_click > 237) && (x_click < 527) && (y_click < 276)) {
                Main.Gametime = "NewGame";
            }
        }
         else if (Main.Gametime == "NextMainMenu") {
            if ((x_click > 710) && (y_click > 13) && (x_click < 750) && (y_click < 53))
            {
                Main.Gametime = "Setting";
            }
            else if ((x_click > 10) && (y_click > 10) && (x_click < 50) && (y_click < 50))
            {

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

