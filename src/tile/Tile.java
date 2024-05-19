package tile;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import main.GamePanel;

import javax.imageio.ImageIO;

public class Tile{
    GamePanel gamePanel;
    int x,y;
    public int width_tile,height_tile;
    public double scale_collect;
    public String name_path,name_path2;

    public BufferedImage image, imageEffcet;
    public String Name,name,type,description;
    public int numOwn;
    public String Type;
    public String Description;
    public int LeftX, RightX, TopY, BottomY;

    public int width, height;
    public boolean isCollision;
    public boolean isMission;

    public Tile() {
        Name = "Empty";
    }

    public Tile(GamePanel gamePanel, int x, int y, int width_tile, int height_tile, String name, String type, String description, String name_path,String name_path2,double scale_collect) {
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

    public Tile(GamePanel gamePanel, int x, int y, int width_tile, int height_tile, String name, String type, String description, String name_path,double scale_collect) {
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
        Name = name;
        Type = type;
        try {
            image = ImageIO.read(new FileInputStream(name_path));
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public void reSizeTile() {
        BoundingBox();
    }

    public void copyTile(Tile tile){
        Name = tile.Name;
        image = tile.image;
        numOwn = tile.numOwn;
        Type = tile.Type;
        Description = tile.Description;
        width = tile.width;
        height = tile.height;
        imageEffcet = tile.imageEffcet;
    }


    public Tile(Rectangle box, String name, String type, String description, BufferedImage image) {
        LeftX = box.x;
        RightX = box.x + box.width;
        TopY = box.y;
        BottomY = box.y + box.height;
        width = box.width;
        height = box.height;
        numOwn = 0;
        Name = name;
        Type = type;
        Description = description;
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public int getLeftX() {
        return LeftX;
    }

    public void setLeftX(int leftX) {
        LeftX = leftX;
    }

    public int getRightX() {
        return RightX;
    }

    public void setRightX(int rightX) {
        RightX = rightX;
    }

    public int getTopY() {
        return TopY;
    }

    public void setTopY(int topY) {
        TopY = topY;
    }

    public int getBottomY() {
        return BottomY;
    }

    public void setBottomY(int bottomY) {
        BottomY = bottomY;
    }
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void resize(double scale) {
        setLeftX((int) (LeftX * scale));
        setTopY((int) (TopY * scale));
        setWidth((int) (width * scale));
        setHeight((int) (height * scale));
        setRightX((int) ((LeftX + width)));
        setBottomY((int) ((TopY + height)));
    }
}
