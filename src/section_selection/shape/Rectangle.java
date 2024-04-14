package section_selection.shape;

import java.awt.Graphics;

public class Rectangle {
    public int x, y, width, height;

    public Rectangle(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    protected void scale(double X_scale, double Y_scale){
        x = (int)(x * X_scale);
        y = (int)(y * Y_scale);
        width = (int)(width * X_scale);
        height = (int)(height * Y_scale);

    }

    protected void  display(Graphics graphics){
        graphics.drawRect(x, y, width, height);
        
    }

    protected boolean HoverCheck(Point chech_point){
        if((x <= chech_point.x) && (chech_point.x <= x + width) && (y <= chech_point.y) && (chech_point.y <= y + height))
            return true;
        else
            return false;
            
    }

    
    
}
