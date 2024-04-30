package Content;

import main.GamePanel;
import GUI.MissionDescription;
import Collision.Collision;
import main.UI;
import phone.Phone;
import Inventory.Inventory;
public class Chapter {
    GamePanel gamePanel;
    UI ui;
    Inventory inventory;
    Phone phone;
    boolean isDrawBackground;
    public int currentTimeline, completedAct;
    MissionDescription missionDescription;
    Collision collision;
    public void update(){
        if (this == gamePanel.chapter1)
            gamePanel.chapter1.update();
        if (this == gamePanel.chapter2)
            gamePanel.chapter2.update();
    }

}
