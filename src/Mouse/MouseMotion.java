package Mouse;

import java.awt.event.MouseEvent;

public class MouseMotion implements java.awt.event.MouseMotionListener{
    public static int currentX, currentY;
    
    @Override
    public void mouseDragged(MouseEvent e) {
        currentX = e.getX();
        currentY = e.getY();
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
        currentX = e.getX();
        currentY = e.getY();
    }

    protected int get_mouseX(){
        return currentX;
    }

    protected int get_mouseY(){
        return currentY;
    }
}
