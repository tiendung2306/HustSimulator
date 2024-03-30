package section_selection;
import java.awt.Graphics;
import java.util.Vector;

import section_selection.shape.*;

class Section {
    String tag;
    Vector<Shape> hitboxs;
    Section_selection area_selection;

    public Section(Section_selection area_selection, String tag, Vector<Shape> hitboxs)  {
        this.area_selection = area_selection;
        this.tag = tag;
        this.hitboxs = hitboxs;
    }

    protected boolean HoverCheck(int mouseX, int mouseY){
        Point point = new Point(mouseX, mouseY);
        for(Shape shape : hitboxs){
            if(shape.HoverCheck(point) == true)
                return true;
        }

        return false;
    
    }

    protected void OnHover(Graphics graphics){
            graphics.fillRect(500, 500, 500, 500);

            

    }
}