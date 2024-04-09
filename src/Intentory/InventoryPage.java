package Intentory;

import tile.Tile;

public class InventoryPage {
    Tile[][] slot;
    public InventoryPage(){
        slot = new Tile[5][5];
        for (int i = 0; i < 5; ++i)
            for (int j = 0; j < 5; ++j) {
                slot[i][j] = new Tile();
                slot[i][j].Name = "Empty";
            }
    }
}
