package Mouse;

// import javafx.scene.paint.Color;
import javax.swing.*;

import main.GamePanel;

import java.awt.*;
import java.awt.event.*;
// import javafx.util.*;

public class MouseManager implements MouseListener {
    private GamePanel gamePanel;
    
    private MouseMotion mouseMotion = new MouseMotion();

    public static boolean isLeftMouseHeld = false;
    public static boolean isMiddleMouseHeld = false;
    public static boolean isRightMouseHeld = false;
    public static boolean isRightMouseClick = false;
    public static boolean isLeftMouseClick = false;

    public static int lastClickedX, lastClickedY; //toa do lan click chuot gan nhat theo truc x va y tren man hinh
    public static int lastReleasedX, lastReleasedY; //toa do lan released chuot gan nhat theo truc x va y tren man hinh


    // static boolean isLeftMouseRelease = false;
    // static boolean isMiddleMouseRelease = false;
    // static boolean isRightMouseRelease = false;

    // static boolean isLeftMouseClicked = false;
    // static boolean isMiddleMouseClicked = false;
    // static boolean isRightMouseClicked = false;
    public MouseManager(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        gamePanel.addMouseListener(this);
        gamePanel.addMouseMotionListener(mouseMotion);
    }


    public int mouseCurrentX() {
        return mouseMotion.get_mouseX();
    }

    public int mouseCurrentY() {
        return mouseMotion.get_mouseY();
    }

    public static void resetLastReleasedPos() {
        lastReleasedX = -1;
        lastReleasedY = -1;
    }

    public void mouseClicked(MouseEvent e) {

        lastClickedX = e.getX();
        lastClickedY = e.getY();
    }

    public void mouseEntered(MouseEvent e) {
        // pane.setBackground(Color.YELLOW);
    }

    public void mouseExited(MouseEvent e) {
        // pane.setBackground(Color.MAGENTA);
    }

    public void mousePressed(MouseEvent e) {

        if (e.getButton() == MouseEvent.BUTTON1){
            // System.out.println("Left button hold");
            isLeftMouseHeld = true;
        } else if (e.getButton() == MouseEvent.BUTTON2){
            // System.out.println("Middle button hold");
            isMiddleMouseHeld = true;
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            // System.out.println("Right button hold");
            isRightMouseHeld = true;
        } 
    }

    public void mouseReleased(MouseEvent e) {

        // int a = e.getX();
        // int b = e.getY();
        // System.out.println("You have RELEASED the mouse at (" + a + "," + b + ") - (X,Y)");

        if (e.getButton() == MouseEvent.BUTTON1){
            // System.out.println("Left button release");
            isLeftMouseClick = true;
            isLeftMouseHeld = false;
        } else if (e.getButton() == MouseEvent.BUTTON2){
            // System.out.println("Middle button release");
            isMiddleMouseHeld = false;
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            // System.out.println("Right button release");
            isRightMouseHeld = false;
            isRightMouseClick = true;
        }
        lastReleasedX = e.getX();
        lastReleasedY = e.getY();
    }
}
