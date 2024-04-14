package section_selection;
import java.awt.Graphics;
import java.util.Vector;

import section_selection.shape.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;


class Section {
    Section_selection section_selection;
    String tag;
    Vector<Shape> hitboxs = new Vector<Shape>();
    Shape boder;
    BufferedImage HoverImg;

    Boolean unlock = false;
    String description;

    public Section(Section_selection section_selection)  {
        this.section_selection = section_selection;

    }
    private void LoadHoverImage(){
        try {
            String path = "res/tile/" + tag + ".png";
            HoverImg = ImageIO.read(new FileInputStream(path));
        }
        catch(IOException e) {
            e.printStackTrace();
        } 

    }

    protected void set_Tag(String tag){
        this.tag = tag;
        LoadHoverImage();
    }

    protected void set_Description(String description){
        this.description = description;
    }

    protected void add_Hitbox(Shape shape){
        hitboxs.add(shape);
    }

    protected void set_Boder(Shape boder){
        this.boder = boder;
    }

    protected void scale(double X_scale, double Y_scale){
        for(Shape shape : hitboxs){
            shape.scale(X_scale, Y_scale);
        }
        boder.scale(X_scale, Y_scale);
    }

    protected boolean HoverCheck(int mouseX, int mouseY){
        Point point = new Point(mouseX, mouseY);

        if(boder.HoverCheck(point)){
            for(Shape shape : hitboxs){
                if(shape.HoverCheck(point) == true)
                    return true;
            }
        }

        return false;
    
    }

    protected void OnHover(Graphics graphics){
        section_selection.statusPanel.setHoverOn(this);
        graphics.drawImage(HoverImg, 0, 0, (int)(HoverImg.getWidth() * section_selection.scale_X), (int)(HoverImg.getHeight() * section_selection.scale_Y), null);
    }

    protected void display(Graphics graphics){
        for(Shape shape : hitboxs){
            shape.display(graphics);
        }
        boder.display(graphics);
    
    }   

}