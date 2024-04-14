package section_selection.shape;

public class Point {
    int x, y;

    public Point(int x, int y) {

        this.x = x;
        this.y = y;

    }

    protected void scale(double X_scale, double Y_scale){
        x = (int)(x * X_scale);
        y = (int)(y * Y_scale);
    }
}
