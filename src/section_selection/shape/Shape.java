package section_selection.shape;

import java.security.PublicKey;
import java.util.Vector;

public class Shape  {
    String type;

    Convex_Polygon polygon;
    public Shape(Vector<Point> points) {
        type = "Polygon";
        polygon = new Convex_Polygon(points);
    }

    public Rectangle rectangle;
    public Shape(int x, int y, int width, int height){
        type = "Rectangle";
        rectangle = new Rectangle(x, y, width, height);
    }

    public boolean HoverCheck(Point check_point){
        switch (type) {
            case "Polygon":
                return polygon.HoverCheck(check_point);
            case "Rectangle":
                return rectangle.HoverCheck(check_point);
            default:
                System.out.println("undefined type of shape");
                return false;
        }
    }

    public void update(double X_scale, double Y_scale){
        switch (type) {
            case "Polygon":
                polygon.update();
            case "Rectangle":
                rectangle.update(X_scale, Y_scale);
            default:
                System.out.println("undefined type of shape");
        }
    }

    public int getX(){
        return rectangle.x;
    }
    public int getY(){
        return rectangle.y;
    }
    public int getWidth(){
        return rectangle.width;
    }
    public int getHeight(){
        return rectangle.height;
    }
}

