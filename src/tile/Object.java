package tile;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;

import map.Map;

public class Object {
    String type;
    String name;

    Vector <Tile> foot = new Vector<Tile>();
    Vector <Tile> body = new Vector<Tile>();
    Tile image;

    Map map;

    public Object(Map map, String type, String name, Rectangle imgbox, Rectangle[] body_hitbox, Rectangle[] foot_hitbox){
        this.map = map;
        this.type = type;
        this.name = name;
        imgLoad(imgbox);

        for(Rectangle rec : body_hitbox){
            Tile tmp = new Tile(rec, name + "body", "Marker", null, null);
            body.add(tmp);
            map.addTile(tmp);
        }

        for(Rectangle rec : foot_hitbox){
            Tile tmp = new Tile(rec, name + "foot", "Obstacle", null, null);
            foot.add(tmp);
            map.addTile(tmp);
        }

    }

    private void imgLoad(Rectangle imgbox){

        try {
            String path = "res/tile/object/" + name + ".png";
            BufferedImage img = ImageIO.read(new FileInputStream(path));
            image = new Tile(imgbox, name, "Marker", null, img);
            map.addTile(image);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void display(Graphics2D graphics2d){
        for(Tile tile : body){
            if(tile.isCollision == true){
                graphics2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
                break;
            }
        }
        map.gamePanel.tileManager.draw(graphics2d, image);
        graphics2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
            
    }

    public int getTop(){
        return foot.getLast().TopY;
    }

    public int getBot(){
        return foot.getFirst().BottomY;
    }

    public void operation(Graphics2D graphics2d){
        display(graphics2d);

    }
    
}
