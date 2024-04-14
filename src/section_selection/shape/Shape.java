package section_selection.shape;

import java.awt.Graphics;
import java.util.Vector;

public class Shape  {
    String type;

    public Convex_Polygon polygon;
    public Shape(Vector <Point> points) {
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

    public void scale(double X_scale, double Y_scale){
        switch (type) {
            case "Polygon":
                polygon.scale(X_scale, Y_scale);
                break;
            case "Rectangle":
                rectangle.scale(X_scale, Y_scale);
                break;
            default:
                System.out.println("undefined type of shapee");
        }
    }

    public void display(Graphics graphics){
        switch (type) {
            case "Polygon":
                polygon.display(graphics);
                break;
            case "Rectangle":
                rectangle.display(graphics);
                break;
            default:
                System.out.println("undefined type of shapee");    
            }
    }

}

