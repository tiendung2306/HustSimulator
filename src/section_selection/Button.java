package section_selection;

import main.GamePanel;

public class Button extends Section {
    public Button(Section_selection section_selection)  {
        super(section_selection);

    }

    
    @Override protected void OnClick(){
        if(tag == "backButton")
            section_selection.close();

        else if(tag == "homeButton"){
            if(section_selection.gamePanel.currentMap != section_selection.gamePanel.myRoom){
                section_selection.gamePanel.myRoom.loadMap(section_selection.gamePanel);
                section_selection.gamePanel.currentMap.loadMap(section_selection.gamePanel);
                section_selection.close();

                section_selection.gamePanel.phone.isDrawPhone = false;
                section_selection.gamePanel.player.ButtonInteract = false;

            }
        }
    }
}
