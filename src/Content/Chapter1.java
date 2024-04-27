package Content;

import main.GamePanel;
import main.Main;
import time.TimeSystem;

public class Chapter1 extends Chapter {
    public boolean IntroFinished = false, laptopMission = false, studentIDMission = false, noodleMission = false;
    long prevTime = 0;

    public Chapter1(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.ui = gamePanel.ui;
        this.inventory = gamePanel.inventory;
        this.collision = gamePanel.collision;
        this.phone = gamePanel.phone;
        this.missionDescription = gamePanel.missionDescription;
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
            Dialogue("Ta đang là anh hùng trong cuộc chiến chống lại quỷ vương mà. Đây là đâu?");
        if (completedAct == 2)
            Dialogue("Đúng rồi, mình đã bị quỷ vương đánh bại và chuyển sinh vào cơ thể cậu sinh viên này ở một thế giới kì lạ");
        if (completedAct == 3)
            Dialogue("Eimi, Yua, không biết 2 cô ấy có ổn không?");
        if (completedAct == 4)
            Dialogue("Mong rằng những giây phút hi sinh cuối cùng đủ thời gian giúp họ trốn thoát.");
        if (completedAct == 5)
            Dialogue("Phải tìm cách để trở lại thế giới cũ!!");
        if (completedAct == 6)
            Dialogue("...");
        if (completedAct == 7)
            Dialogue("Dòng chảy Ma Pháp ở thế giới này thật hỗn loạn, ta không thể khai triển sức mạnh được.");
        if (completedAct == 8)
            Dialogue("Thật may ngôn ngữ ở đây có vẻ không khác ở thế giới cũ là bao.");
        if (completedAct == 9)
            Dialogue("Bắt đầu tìm hiểu xung quanh thôi!");
        if (completedAct == 10)
            nextTimeline();
    }

    void Timeline1() {
        IntroFinished = true;
        if (completedAct == 0){
            Dialogue("Đây là căn phòng của ta sao?");
            TimeSystem.setCurrentTime("07:00");
        }
        if (completedAct == 1)
            Dialogue("Nó khá nhỏ so với tòa lâu đài ở kiếp trước. Nhưng nó chứa khá là nhiều thứ thú vị!");
        if (completedAct == 2)
            Dialogue("Thế giới này chứa những đồ vật hoạt động bằng một thứ người ta gọi là Khoa Học.");
        if (completedAct == 3)
            Dialogue("Cái thứ Khoa học này so với Ma Pháp tồn tại ở thế giới cũ khá là giống nhau.");
        if (completedAct == 4)
            Dialogue("Biết tìm kiếm thông tin ở đâu đây?");
        missionDescription.setMissionDescription("Tìm Laptop, thẻ sinh viên và đọc thông tin của chúng(Ấn B để mở balo)");
        if (completedAct == 5) {
            if (!studentIDMission)
                gamePanel.myRoom.tileStudentCard.isMission = true;
            if (!laptopMission)
                gamePanel.myRoom.tileLaptop.isMission = true;
            if (inventory.isGettingInformation
                    && inventory.infoItem.Name.equals("Acer Predator 21X"))
                laptopMission = true;
            if (inventory.isGettingInformation && inventory.infoItem.Name.equals("Student ID"))
                studentIDMission = true;
            if (laptopMission && studentIDMission) {
                ++completedAct;
                gamePanel.myRoom.tileStudentCard.isMission = false;
                gamePanel.myRoom.tileLaptop.isMission = false;
            }
        }
        if (completedAct == 6)
            Dialogue("Đại khái thì ta đã nắm bắt được mọi thứ xung quanh.");
        if (completedAct == 7)
            Dialogue("Ọc ọc ọc");
        if (completedAct == 8)
            Dialogue("...");
        if (completedAct == 9)
            Dialogue("Tạm gác việc cứu thế giới lại vậy, ta cần cứu đói đã!");
        if (completedAct == 10)
            nextTimeline();
    }

    void Timeline2() {
        if (completedAct == 0) {
            missionDescription.setMissionDescription("Tìm mì tôm và lại nấu ăn đi");
            if (!noodleMission){
                gamePanel.myRoom.tileKettle.isMission = true;
                gamePanel.myRoom.tilePan.isMission = true;
            }
            if (collision.interactItem.Name.equals("Pan") && inventory.isUsingItem
                    && inventory.usingItem.Name.equals("Kettle")) {
                gamePanel.myRoom.tileKettle.isMission = false;
                gamePanel.myRoom.tilePan.isMission = false;
                noodleMission = true;
                ++completedAct;
            }
        }
        if (completedAct == 1)
            Dialogue("Sao có thể tồn tại món ăn cao sang mĩ vị như vậy!");
        if (completedAct == 2) {
            while (Main.GameState.size() > 1 && !Main.topGameState().equals("GamePlay"))
                Main.popGameState();
            nextTimeline();
        }
    }

    void Timeline3() {
        if (completedAct == 0)
            Dialogue("Reng reng reng");
        if (completedAct == 1)
            Dialogue("Âm thanh quái quỷ gì vậy?");
        if (completedAct == 2) {
            if (!inventory.isExist("Iphone 100 ProMax")) { // phai co dien thoai trong balo
                Dialogue(" ");
                missionDescription.setMissionDescription("Tìm điện thoại");
                gamePanel.myRoom.tilePhone.isMission = true;
            } else completedAct++;
        }
        if (completedAct == 3) {
            if (inventory.isExist("Iphone 100 ProMax")) {
                if (Main.topGameState().equals("GamePlay"))
                    Dialogue("Một thiết bị tinh vi được tích hợp ma pháp điện. Kẻ sáng chế ra thứ này quả là thiên tài.");
                    missionDescription.setMissionDescription("Kiểm tra app fHUST(Ấn P để mở điện thoại)");
                    gamePanel.myRoom.tilePhone.isMission = false;
                phone.isOpenFhust = false;
            }
        }
        if (completedAct == 4) {
            if (phone.isOpenFhust && !phone.isDrawPhone) {
                Dialogue("Nếu thứ này ta có thể đem sang thế giới cũ, chấp 10 tên ma vương cũng không thể đánh lại.");
                missionDescription.setMissionDescription("");
                prevTime = TimeSystem.getCurrentSystemTimeInMilliseconds();
            }
        }
        if (completedAct == 5)
            Dialogue("Nhưng sao nó cứ kêu hoài thế nhỉ?");
        if (completedAct == 6 && TimeSystem.getCurrentSystemTimeInMilliseconds() - prevTime >= 6000) {
            Dialogue("Có thư tình báo!!!");
            missionDescription.setMissionDescription("Kiểm tra tin nhắn");
            phone.setNewMessage("chapter1_1");
            phone.isOpenMessager = false;
        }
        if (completedAct == 6 && phone.isOpenMessager && !phone.isDrawPhone) {
            Dialogue("Hội dũng giả nằm ở tòa C2, đến đăng ký tân thủ lúc 7h30");
            missionDescription.setMissionDescription("Tương tác với cửa phòng để di chuyển đến trường");
            phone.clearMessage();
            prevTime = TimeSystem.getCurrentSystemTimeInMilliseconds();
        } else if (completedAct == 5 && TimeSystem.getCurrentSystemTimeInMilliseconds() - prevTime >= 4000) {
            gamePanel.currentMap = gamePanel.normalClassroom;
            gamePanel.currentMap.loadMap(gamePanel);
            prevTime = TimeSystem.getCurrentSystemTimeInMilliseconds();
            completedAct++;
        }
        else if(completedAct == 6 && TimeSystem.getCurrentSystemTimeInMilliseconds() - prevTime >= 500) {
            Dialogue("Mình đã đến nơi rồi!");
        }
        if (completedAct == 7)
            nextTimeline();
    }
    

    public void update() {
        if (!Main.topGameState().equals("GamePlay") && !Main.topGameState().equals("Inventory")
                && !Main.topGameState().equals("Dialog") && !Main.topGameState().equals("Dialogue"))
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
            // case 2: {
            //     Timeline2();
            //     break;
            // }
            case 2: {
                Timeline3();
                break;
            }
        }
    }

    void Dialogue(String str) {
        if (Main.topGameState().equals("GamePlay")) {
            ui.currentDialog = str;
            Main.pushGameState("Dialogue");
            ui.i = 0;
            ui.timer.setDelay(40);
            ui.isFinishDialogue = false;
            ui.timer.start();
        }
    }

    void drawBackground() {
        if (isDrawBackground)
            ui.drawBackground(null);
    }
}
