package map;

import main.GamePanel;
import tile.Tile;

public class Map {
    GamePanel gamePanel;
    public int mapIndex;
    public int numTileContainer;
    public Tile [] tileContainer;
    public void addTile(Tile tile){
        tileContainer[numTileContainer++] = tile;
    }
    public void deleteTile(int index){
        --numTileContainer;
        for (int i = index; i < numTileContainer; ++i)
            tileContainer[i] = tileContainer[i + 1];
    }

}
