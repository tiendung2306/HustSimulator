package Intentory;

import java.awt.*;
import java.awt.image.BufferedImage;

public class InventoryComponent {
    BufferedImage image;
    Rectangle BoundingBox;
    String name;
    public InventoryComponent(){
        BoundingBox = new Rectangle();
        name = "";
    }
}
