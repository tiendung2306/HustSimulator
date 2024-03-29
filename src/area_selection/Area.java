package area_selection;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

class Area {
    String tag;
    Rectangle hitbox;
    Area_selection area_selection;

    public Area(Area_selection area_selection, String tag, Rectangle hitbox)  {
        this.area_selection = area_selection;
        this.tag = tag;
        this.hitbox = hitbox;
    }

    protected boolean HoverCheck(Double mouseX, Double mouseY){
        if(hitbox.x <= mouseX && mouseX <= hitbox.x + hitbox.width)
            if(hitbox.y <= mouseY && mouseY <= hitbox.y + hitbox.height)
                return true;

        return false;
    }

    protected void OnHover(){
        System.out.println("vpa");
    }
}