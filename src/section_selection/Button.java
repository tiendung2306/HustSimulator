package section_selection;

public class Button extends Section {
    public Button(Section_selection section_selection)  {
        super(section_selection);

    }

    
    @Override protected void OnClick(){
        if(tag == "backButton")
            section_selection.close();

        else if(tag == "homeButton"){
            if(section_selection.gamePanel.currentMap != section_selection.gamePanel.myRoom){
                section_selection.gamePanel.currentMap = section_selection.gamePanel.myRoom;
                section_selection.gamePanel.currentMap.loadMap(section_selection.gamePanel);
                section_selection.close();

            }
        }
    }
}
