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
    
}

