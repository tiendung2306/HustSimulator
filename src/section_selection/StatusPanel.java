package section_selection;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class StatusPanel {
    Section_selection section_selection;
    Rectangle contex_box = new Rectangle(45, 1174, 1044, 495);
    Text defaut, sectionTag, sectionStatus, sectionDescription;
    Boolean onhover = false;


    public StatusPanel(Section_selection section_selection){
        this.section_selection = section_selection;

        defaut = new Text("CHƯA CHỈ ĐỊNH", new Font("Dialog", Font.BOLD, 90), section_selection);
        sectionTag = new Text("", new Font("Dialog", Font.BOLD, 120), section_selection);
        sectionStatus = new Text("", new Font("Dialog", Font.BOLD, 80), section_selection);
        sectionDescription = new Text("", new Font("Dialog", Font.BOLD, 80), section_selection);

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
        switch (section.tag) {
            case "Section1":
                sectionTag.setText("KHU VỰC 1");
                break;

            case "Section2":
                sectionTag.setText("KHU VỰC 2");
                break;
            
            case "Section3":
                sectionTag.setText("KHU VỰC 3");
                break;
        
            default:
                break;
        }
        if(section.unlock == true)
            sectionStatus.setText("Trạng thái : Mở");
        else
            sectionStatus.setText("Trạng thái : Khóa");
        sectionDescription.setText("Mô tả: " + section.description);

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
