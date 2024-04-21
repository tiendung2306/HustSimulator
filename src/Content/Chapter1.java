package Content;

import main.GamePanel;
import main.Main;
import main.UI;
import phone.Phone;
import Inventory.Inventory;
import tile.Tile;
import Collision.Collision;

public class Chapter1 {
    GamePanel gamePanel;
    UI ui;

    Inventory inventory;
    Collision collision;
    Phone phone;

    boolean isDrawBackground;
    public int currentTimeline, completedAct;
    public boolean IntroFinished = false, phoneMission = false, laptopMission = false, studentIDMission = false,
            noodleMission = false;

    public Chapter1(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.ui = gamePanel.ui;
        this.inventory = gamePanel.inventory;
        this.collision = gamePanel.collision;
        this.phone = gamePanel.phone;
        currentTimeline = 0;
        completedAct = 0;
    }

    void nextTimeline() {
        ++currentTimeline;
        completedAct = 0;
    }

    void Intro() {
        // drawBackground();
        if (completedAct == 0)
            Dialogue("Chuyện gì vừa xảy ra vậy...");
        if (completedAct == 1)
            Dialogue("Mình đang là anh hùng trong cuộc chiến chống lại quỷ vương mà. Đây là đâu?");
        if (completedAct == 2)
            Dialogue(
                    "Đúng rồi, mình đã bị quỷ vương đánh bại và chuyển sinh vào cơ thể cậu sinh viên này ở một thế giới kì lạ");
        if (completedAct == 3)
            Dialogue("Theo như tìm hiểu thì ngôn ngữ ở đây có vẻ không khác ở thế giới cũ là bao");
        if (completedAct == 4)
            Dialogue("Bắt đầu tìm hiểu xung quanh thôi");
        if (completedAct == 5)
            nextTimeline();
    }

    void Timeline1() {
        IntroFinished = true;
        if (completedAct == 0) {
            if (inventory.isGettingInformation
                    && inventory.infoItem.Name.equals("Laptop gaming MSI Titan GT77 12UHS 204VN"))
                laptopMission = true;
            if (inventory.isGettingInformation && inventory.infoItem.Name.equals("Student ID"))
                studentIDMission = true;
            if (laptopMission && studentIDMission)
                ++completedAct;
        }
        if (completedAct == 1)
            nextTimeline();
    }

    void Timeline2() {
        if (completedAct == 0) {
            if (collision.interactItem.Name.equals("Pan") && inventory.isUsingItem
                    && inventory.usingItem.Name.equals("Kettle")) {
                noodleMission = true;
                ++completedAct;
            }
        }
        if (completedAct == 1) {
            while (Main.GameState.size() > 1 && !Main.topGameState().equals("GamePlay"))
                Main.popGameState();
            nextTimeline();
        }
    }

    void Timeline3() {
        if (completedAct == 0) {
            if (!inventory.isExist("Iphone 1000000 ProMax")) { // phai co dien thoai trong balo
                Dialogue("Điện thoại của tôi đâu rồi nhỉ");
            } else
                completedAct++;
        } else if (completedAct == 1) {
            Dialogue("Mình phải mở điện thoại ra kiểm tra xem hôm nay có tiết học gì không nào");
            phone.isOpenFhust = false;
        } else if (completedAct == 2) {
            if(phone.isOpenFhust == true && phone.isDrawPhone == false) {
                Dialogue("Vậy là hôm nay mình không có lịch học");
            }
        }
        if (completedAct == 3)
            nextTimeline();
    }
    public void update(){
        if (!Main.topGameState().equals("GamePlay") && !Main.topGameState().equals("Inventory") && !Main.topGameState().equals("Dialog") && !Main.topGameState().equals("Dialogue"))
            return;
        switch (currentTimeline) {
            case 0: {
                Intro();
                break;
            }
            case 1: {
                Timeline1();
                break;
            }
            case 2: {
                Timeline2();
                break;
            }
            case 3: {
                Timeline3();
                break;
            }
        }
    }

    void Dialogue(String str) {
        if (!Main.topGameState().equals("Dialogue")) {
            ui.currentDialog = str;
            Main.pushGameState("Dialogue");
        }
    }

    void drawBackground() {
        if (isDrawBackground)
            ui.drawBackground(null);
    }
}
