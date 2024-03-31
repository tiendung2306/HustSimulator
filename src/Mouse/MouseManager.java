package Mouse;

import javafx.scene.paint.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javafx.util.*;

public class MouseManager implements MouseListener {

    public static boolean isLeftMouseHeld = false; // = true neu nguoi dung dang giu chuot trai
    public static boolean isMiddleMouseHeld = false; // = true neu nguoi dung dang giu chuot giua
    public static boolean isRightMouseHeld = false; // = true neu nguoi dung dang giu chuot phai

    public static int lastClickedX, lastClickedY; //toa do lan click chuot gan nhat theo truc x va y


    // static boolean isLeftMouseRelease = false;
    // static boolean isMiddleMouseRelease = false;
    // static boolean isRightMouseRelease = false;

    // static boolean isLeftMouseClicked = false;
    // static boolean isMiddleMouseClicked = false;
    // static boolean isRightMouseClicked = false;

    public void mouseClicked(MouseEvent e) {

        // int x = e.getClickCount();
        // System.out.println("You CLICKED the mouse " + x + " times.");

        // if (e.getButton() == MouseEvent.BUTTON1){
        //     System.out.println("Left button clicked");
        // } else if (e.getButton() == MouseEvent.BUTTON2){
        //     System.out.println("Middle button clicked");
        // } else if (e.getButton() == MouseEvent.BUTTON3) {
        //     System.out.println("Right button clicked");
        // } 

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
        // System.out.println("You have PRESSED the mouse");

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
            isLeftMouseHeld = false;
        } else if (e.getButton() == MouseEvent.BUTTON2){
            // System.out.println("Middle button release");
            isMiddleMouseHeld = false;
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            // System.out.println("Right button release");
            isRightMouseHeld = false;
        } 
    }
}
