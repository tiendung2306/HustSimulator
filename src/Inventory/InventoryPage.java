package Inventory;

import tile.Tile;
public class InventoryPage {
    Tile[][] slot;
    public InventoryPage(){
        slot = new Tile[3][3];
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 3; ++j){
                slot[i][j] = new Tile();
                slot[i][j].Name = "Empty";
            }
    }
}
