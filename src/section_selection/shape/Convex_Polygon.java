package section_selection.shape;

import java.awt.Graphics;
import java.util.Vector;

public class Convex_Polygon {

    Vector<Point> points;
    Point center = new Point(0, 0);

    public Convex_Polygon(Vector<Point> points) {
        this.points = points;
        for(Point point : points){
            center.x += point.x;
            center.y += point.y;
        }
        center.x /= points.size();
        center.y /= points.size();

    }
    protected void scale(double X_scale, double Y_scale){
        for(Point point : points){
            point.scale(X_scale, Y_scale);
        }
        center.scale(X_scale, Y_scale);
    }

    protected boolean HoverCheck(Point check_point){
        int i = 0, j = 1;
        while (i < points.size()) {
            Point point1 = points.get(i);
            Point point2 = points.get(j);
            int equation1 = (point1.y - point2.y) * (check_point.x - point1.x) + (point2.x - point1.x) * (check_point.y - point1.y);
            int equation2 = (point1.y - point2.y) * (center.x - point1.x) + (point2.x - point1.x) * (center.y - point1.y);

            if(equation1 * equation2 < 0)
                return false;
            i++; j++;
            if(j == points.size())
                j = 0;
        }
        return true;
    }

    protected void display(Graphics graphics){
        int i = 0, j = 1;
        while (i < points.size()) {
            Point point1 = points.get(i);
            Point point2 = points.get(j);
            graphics.drawLine(point1.x, point1.y, point2.x, point2.y);
            graphics.drawLine(point1.x, point1.y, center.x, center.y);

            i++; j++;
            if(j == points.size())
                j = 0;
        }
    }
}



