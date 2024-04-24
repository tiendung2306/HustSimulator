package section_selection;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Text {
    Section_selection section_selection;
    String text;
    Font font;
    int top, bottom, left, right;//%

    public Text(String text, Font font, Section_selection section_selection){
        this.section_selection = section_selection;
        this.text = text;
        this.font = font;
        top = bottom = left = right = 0;
    }

    protected void scale(double scale_X){
        font = new Font(font.getName(), font.getStyle(), (int)(font.getSize() * scale_X));
    }

    protected void setText(String text){
        this.text = text;
    }

    protected void setTop(int top){
        this.top = top;
        bottom = 0;
    }

    protected void setBottom(int bottom){
        this.bottom = bottom;
        top = 0;
    }

    protected void setLeft(int left){
        this.left = left;
        right = 0;
    }

    protected void setRight(int right){
        this.right = right;
        left = 0;
    }

    protected void centerY(){
        left = right = 0;
    }

    protected void centerX(){
        top = bottom = 0;
    }


    protected void display(Graphics graphics, Rectangle surface){
        graphics.setFont(font);
        int width = graphics.getFontMetrics(font).stringWidth(text);

        int ascent = graphics.getFontMetrics(font).getAscent();
        int descent = graphics.getFontMetrics(font).getDescent();
        int height = graphics.getFontMetrics(font).getHeight() - ascent + descent;

        int x;
        if(left == 0 && right == 0)
            x = (int)((surface.width - width) * 1.0 / 2);
        else if(right == 0)
            x = (int)(surface.width * left * 1.0 / 100);
        else
            x = (int)(surface.width - surface.width * right * 1.0 / 100) - width;

        int y;
        if(bottom == 0 & top == 0)
            y = (int)((surface.height + height) * 1.0 / 2);
        else if(bottom == 0)
            y = (int)(surface.height * top * 1.0 / 100) + height;
        else
            y = (int)(surface.height - surface.height * bottom * 1.0 / 100);
        // System.out.println(x);
        graphics.drawString(text,section_selection.bg_X + x + surface.x, section_selection.bg_Y + y + surface.y);
    }
}
