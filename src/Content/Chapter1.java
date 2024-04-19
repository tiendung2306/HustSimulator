package Content;
import Inventory.Inventory;
import main.GamePanel;
import main.Main;
import main.UI;

public class Chapter1 {
    GamePanel gamePanel;
    UI ui;
    boolean isDrawBackground;
    int currentTimeline, completedAct;
    public boolean isPlot = false, bagMission = false, laptopMission = false, studentIDMission = false;
    public Chapter1(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        this.ui = gamePanel.ui;
        currentTimeline = 0;
        completedAct = 0;
    }
    void nextTimeline(){
        ++currentTimeline;
        completedAct = 0;
    }
    void Intro(){
        drawBackground();
        if (completedAct == 0)
            Dialogue("Chuyện gì vừa xảy ra vậy...");
        if (completedAct == 1)
            Dialogue("Mình đang là anh hùng trong cuộc chiến chống lại quỷ vương mà. Đây là đâu?");
        if (completedAct == 2)
            Dialogue("Đúng rồi, mình đã bị quỷ vương đánh bại và chuyển sinh vào cơ thể cậu sinh viên này ở một thế giới kì lạ");
        if (completedAct == 3)
            Dialogue("Theo như tìm hiểu thì ngôn ngữ ở đây có vẻ không khác ở thế giới cũ là bao");
        if (completedAct == 4)
            nextTimeline();
    }
    void Timeline1(){

        isPlot = true;

    }
    public void update(){
        switch (currentTimeline){
            case 0: Intro();
            case 1: Timeline1();
        }
    }
    void Dialogue(String str){
        if (!Main.topGameState().equals("Dialogue")){
            ++completedAct;
            ui.currentDialogue = str;
            Main.pushGameState("Dialogue");
        }
    }
    void drawBackground(){
        if (isDrawBackground)
            ui.drawBackground(null);
    }
}
