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

}
