package tile;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;

import animation.Animation_player;
import map.Map;

public class Object {
    String type;
    String name;
    
    double transparency;
    Vector <Tile> foot = new Vector<Tile>();
    Vector <Tile> body = new Vector<Tile>();

    Tile image;
    Tile display_box;
    Animation_player animation_player;

    Map map;

    public Object(Map map){
        this.map = map;
    }
    public void setName(String Name){
        name = Name;
    }

    public void setType(String Type){
        type = Type;
    }
    
    public void setTrans(double trans){
        transparency = trans;
    }

    public String getType(){
        return type;
    }

    public void setImageBox(Rectangle imgbox, int frames, double run_time){
        switch (type) {
            case "animated":
                imgLoad(imgbox, frames, run_time);
                break;

            case "non-animated":
                imgLoad(imgbox, 0, 0);
                break;
            
            default:
                break;
        }
    }

    public void addBodyHitbox(Rectangle rec){
        Tile tmp = new Tile(rec, name + "body", "Marker", null, null);
        body.add(tmp);
        map.addTile(tmp);
    }

    public void addFootHitbox(Rectangle rec){
        Tile tmp = new Tile(rec, name + "foot", "Obstacle", null, null);
        foot.add(tmp);
        map.addTile(tmp);
    }

    private void imgLoad(Rectangle imgbox, int frames, double run_time){
        switch (type) {
            case "animated":
                display_box = new Tile(new Rectangle(imgbox.x, imgbox.y, imgbox.width, imgbox.height), "", "Marker", null, null);
                map.addTile(display_box);
                String frame_path = "res/tile/object/" + name + "/frame";
                animation_player = new Animation_player(map.gamePanel, frame_path, frames, run_time, imgbox);
                break;
        
            case "non-animated":
                try {
                    String img_path = "res/tile/object/" + name + ".png";
                    BufferedImage img = ImageIO.read(new FileInputStream(img_path));
                    image = new Tile(imgbox, name, "Marker", null, img);
                    map.addTile(image);
        
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            default:
                break;
        }

    }

    private void update(){
        int x = display_box.LeftX - map.gamePanel.player.getMapX() + map.gamePanel.player.getBoundingBoxX();
        int y = display_box.TopY - map.gamePanel.player.getMapY() + map.gamePanel.player.getBoundingBoxY();
        animation_player.setPlayarea(new Rectangle(x, y, display_box.width, display_box.height));

    }


    private void display(Graphics2D graphics2d){

        for(Tile tile : body){
            if(tile.isCollision == true){
                graphics2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)(transparency)));
                break;
            }
        }
        switch (type) {
            case "animated":
                update();
                animation_player.operation(graphics2d);
                break;

            case "non-animated":
                map.gamePanel.tileManager.draw(graphics2d, image);
                break;
        
            default:
                break;
        }
        graphics2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
            
    }

    public Vector<Tile> getFoot(){
        return foot;
    }

    public void operation(Graphics2D graphics2d){
        display(graphics2d);

    }
    
}
