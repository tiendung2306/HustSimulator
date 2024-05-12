package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class TileSection extends Tile {
    public int x,y,width_tile,height_tile;
    public double scale_collect;
    public String name,type,name_path,description,name_path2;
    GamePanel gamePanel;


    public TileSection(GamePanel gamePanel, int x, int y, int width_tile, int height_tile, String name, String type, String description, String name_path,String name_path2,double scale_collect) {
        this.x = x;
        this.y = y;
        this.scale_collect = scale_collect;
        this.width_tile = width_tile;
        this.height_tile = height_tile;
        this.gamePanel = gamePanel;
        this.name = name;
        this.type = type;
        this.name_path = name_path;
        this.name_path2 = name_path2;
        this.description = description;
        Description = description;
        Name = name;
        Type = type;
        try {
            image = ImageIO.read(new FileInputStream(name_path));
            imageEffcet = ImageIO.read(new FileInputStream(name_path2));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BoundingBox();
    }

    public TileSection(GamePanel gamePanel, int x, int y, int width_tile, int height_tile, String name, String type, String description, String name_path,double scale_collect) {
        this.x = x;
        this.y = y;
        this.scale_collect = scale_collect;
        this.width_tile = width_tile;
        this.height_tile = height_tile;
        this.gamePanel = gamePanel;
        this.name = name;
        this.type = type;
        this.name_path = name_path;
        this.description = description;
        Description = description;
        Name = name;
        Type = type;
        try {
            image = ImageIO.read(new FileInputStream(name_path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BoundingBox();
    }

    public void reSizeTile() {
        BoundingBox();
    }
    public void BoundingBox() {
        setLeftX((int) (x * GamePanel.scale));
        setTopY((int) (y * GamePanel.scale));
        setRightX((int) ((x + width_tile * scale_collect) * GamePanel.scale));
        setBottomY((int) ((y + height_tile * scale_collect) * GamePanel.scale));
        setWidth((int) (width_tile * GamePanel.scale * scale_collect));
        setHeight((int) (height_tile * GamePanel.scale * scale_collect));
    }

}
