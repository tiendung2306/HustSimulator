package tile;

public class ExtraTile extends Tile{
    public int numPoint;
    public int[] x, y;
    public ExtraTile(){
        x = new int[20];
        y = new int[20];
    }

    public void resize(double scale){
        for(int i = 0; i < 20; i++){
            x[i] = (int)(x[i] * scale);
            y[i] = (int)(y[i] * scale);

        }
    }
}
