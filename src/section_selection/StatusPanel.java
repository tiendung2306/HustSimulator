package section_selection;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class StatusPanel {
    Section_selection section_selection;
    Rectangle contex_box = new Rectangle(45, 1174, 1044, 495);
    Text defaut = new Text("NO SECTION SELECTED", new Font("Dialog", Font.BOLD, 90));
    Boolean onhover = false;
    Text sectionTag = new Text("", new Font("Dialog", Font.BOLD, 120));
    Text sectionStatus = new Text("", new Font("Dialog", Font.BOLD, 80));
    Text sectionDescription = new Text("", new Font("Dialog", Font.BOLD, 80));


    public StatusPanel(Section_selection section_selection){
        this.section_selection = section_selection;

        sectionTag.setTop(15);
        sectionStatus.setTop(45);
        sectionStatus.setLeft(1);
        sectionDescription.setTop(75);
        sectionDescription.setLeft(1);

    }

    protected void scale(double scale_X, double scale_Y){
        contex_box.x = (int)(contex_box.x * scale_X);
        contex_box.width = (int)(contex_box.width * scale_X);

        contex_box.y = (int)(contex_box.y * scale_Y);
        contex_box.height = (int)(contex_box.height * scale_Y);

        defaut.scale(scale_X);
        sectionTag.scale(scale_X);
        sectionStatus.scale(scale_X);
        sectionDescription.scale(scale_X);
 
    }

    protected void setHoverOn(Section section){
        onhover = true;
        sectionTag.setText(section.tag);
        if(section.unlock == true)
            sectionStatus.setText("Status: Avaiable");
        else
            sectionStatus.setText("Status: Unavaiable");
        sectionDescription.setText("Description: " + section.description);

    }


    protected void display(Graphics graphics){

        if(onhover == true){
            sectionTag.display(graphics, contex_box);
            sectionStatus.display(graphics, contex_box);
            sectionDescription.display(graphics, contex_box);

        }
        else
            defaut.display(graphics, contex_box);

        onhover = false;

        // graphics.drawRect(contex_box.x, contex_box.y, contex_box.width, contex_box.height);
    }
}
