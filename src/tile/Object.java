package tile;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import animation.Animation_player;

public class Object extends Tile{
    String type;
    String name;

    Tile foot, body;
    BufferedImage image, on_hover_image;
    Animation_player animation_player;

    public Object(String type, String name, Rectangle imgbox, Rectangle foot_hitbox){
        
        this.type = type;
        this.name = name;
        // this.imgbox = imgbox
        // this.foot_hitbox
    }

    private void imgLoad(){

        try {
            String path = "res/tile/object/" + name + ".png";
            image = ImageIO.read(new FileInputStream(path));
            on_hover_image = ImageIO.read(new FileInputStream(path));


        } catch (IOException e) {
            e.printStackTrace();
        }


        for(int i = 0; i < on_hover_image.getWidth(); i++){
            for(int j = 0; j < on_hover_image.getHeight(); j++){
                on_hover_image.setRGB(i, j, (on_hover_image.getRGB(i, j) & 0x00FFFFFF) | (127 << 24));
            }
        }
    }

    private void display(Graphics graphics){

    }

    public void operation(){

    }
    
}
