package map;

import tile.Tile;

public class Map {
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
