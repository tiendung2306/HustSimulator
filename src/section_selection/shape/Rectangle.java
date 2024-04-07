package section_selection.shape;

public class Rectangle {
    public int x, y, width, height;

    public Rectangle(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    protected void update(double X_scale, double Y_scale){
        x *= X_scale;
        y *= Y_scale;
        width *= X_scale;
        height *= Y_scale;

    }

    protected boolean HoverCheck(Point chech_point){
        if((x <= chech_point.x) && (chech_point.x <= x + width) && (y <= chech_point.y) && (chech_point.y <= y + height))
            return true;
        else
            return false;
            
    }

    
    
}
