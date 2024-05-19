package Content;

import main.GamePanel;
import main.Main;
import time.TimeSystem;

public class Chapter1 extends Chapter {
    public boolean IntroFinished = false, laptopMission = false, studentIDMission = false, noodleMission = false,
            hoSoMission = false;
    long prevTime = 0;
    public Boolean isTeleportable = false;

    public Chapter1(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.ui = gamePanel.ui;
        this.inventory = gamePanel.inventory;
        this.collision = gamePanel.collision;
        this.phone = gamePanel.phone;
        this.missionDescription = gamePanel.missionDescription;
        currentTimeline = 0;
        completedAct = 0;
        this.isTeleportable = false;
    }

    void nextTimeline() {
        ++currentTimeline;
        completedAct = 0;
    }

    void Intro() {
        if (completedAct == 0)
            Dialogue("Chuyện gì vừa xảy ra vậy...");
        if (completedAct == 1)
            Dialogue("Ta đang là anh hùng trong cuộc chiến chống lại quỷ vương mà. Đây là đâu?");
        if (completedAct == 2)
            Dialogue(
                    "Đúng rồi, mình đã bị quỷ vương đánh bại và chuyển sinh vào cơ thể cậu sinh viên này ở một thế giới kì lạ");
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
        if (completedAct == 0) {
            TimeSystem.setCurrentTime("07:00");
            Dialogue("Đây là căn phòng của ta sao?");
        }
        if (completedAct == 1)
            Dialogue("Nó khá nhỏ so với tòa lâu đài ở kiếp trước. Nhưng nó chứa khá là nhiều thứ thú vị!");
        if (completedAct == 2)
            Dialogue("Thế giới này chứa những đồ vật hoạt động bằng một thứ người ta gọi là Khoa Học.");
        if (completedAct == 3)
            Dialogue("Cái thứ Khoa học này so với Ma Pháp tồn tại ở thế giới cũ khá là giống nhau.");
        if (completedAct == 4)
            Dialogue("Biết tìm kiếm thông tin ở đâu đây?");
        missionDescription
                .setMissionDescription("Tìm Laptop, thẻ sinh viên và đọc thông tin của chúng(Ấn B để mở balo)");
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
            missionDescription
                    .setMissionDescription("Tìm mì tôm và lại nấu ăn đi (Sử dụng Mì tôm sau khi đã tương tác với Bếp)");
            if (!noodleMission) {
                gamePanel.myRoom.tileNoodle.isMission = true;
                gamePanel.myRoom.tilePan.isMission = true;
            }
            if (collision.interactItem.Name.equals("Pan") && inventory.isUsingItem
                    && inventory.usingItem.Name.equals("Noodle")) {
                gamePanel.myRoom.tileNoodle.isMission = false;
                gamePanel.myRoom.tilePan.isMission = false;
                gamePanel.inventory.deleteFromInventory(gamePanel.inventory.currentIndex, gamePanel.inventory.slotX,
                        gamePanel.inventory.slotY);
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
                missionDescription.setMissionDescription("Tìm kiếm điện thoại");
                gamePanel.myRoom.tilePhone.isMission = true;
            } else
                completedAct++;
        }
        if (completedAct == 3) {
            if (inventory.isExist("Iphone 100 ProMax")) {
                if (Main.topGameState().equals("GamePlay"))
                    Dialogue(
                            "Quả là một thiết bị tinh vi được tích hợp ma pháp điện. Kẻ sáng chế ra thứ này đúng là một thiên tài.");
                missionDescription.setMissionDescription("Kiểm tra app fHUST(Ấn P để mở điện thoại)");
                gamePanel.myRoom.tilePhone.isMission = false;
                phone.isOpenFhust = false;
            }
        }
        if (completedAct == 4) {
            if (phone.isOpenFhust && !phone.isDrawPhone) {
                Dialogue("Nếu thứ này ta có thể đem sang thế giới cũ, 10 tên ma vương cũng không thể đánh lại.");
                missionDescription.setMissionDescription("");
                prevTime = TimeSystem.getCurrentSystemTimeInMilliseconds();
            }
        }
        if (completedAct == 5)
            Dialogue("Nhưng sao nó cứ kêu hoài thế nhỉ?");
        if (completedAct == 6 && TimeSystem.getCurrentSystemTimeInMilliseconds() - prevTime >= 500) {
            Dialogue("Có thư tình báo!!!");
            missionDescription.setMissionDescription("Kiểm tra tin nhắn");
            phone.setNewMessage("chapter1_1");
            phone.isOpenMessager = false;
        }
        if (completedAct == 7 && phone.isOpenMessager && !phone.isDrawPhone) {
            if (!inventory.isExist("Hồ sơ")) {
                Dialogue("Đi lấy tập hồ sơ nhập học rồi đi nộp thôi nào");
                missionDescription.setMissionDescription("Nhặt bộ hồ sơ nhập học");
            } else
                completedAct++;
            phone.clearMessage();
        }
        if (completedAct == 8 && inventory.isExist("Hồ sơ")) {
            Dialogue("Hội thợ săn nằm ở tòa C2, đến đăng ký tân thủ vào lúc 7h30");
            gamePanel.directionIndicator.addArrow(
                    (gamePanel.myRoom.tileDoorMyRoom.getLeftX() + gamePanel.myRoom.tileDoorMyRoom.getRightX()) / 2
                            - gamePanel.directionIndicator.width / 2,
                    gamePanel.myRoom.tileDoorMyRoom.getBottomY() - gamePanel.directionIndicator.height);
            missionDescription.setMissionDescription(
                    "Tương tác với cửa phòng để di chuyển đến trường(Dịch chuyển đến Section 1)");
            isTeleportable = true;
        }
        if (completedAct == 9 && gamePanel.currentMap == gamePanel.section_1) {
            gamePanel.directionIndicator.resetArrow();
            missionDescription.setMissionDescription("Tìm hội trường C2");
            gamePanel.directionIndicator.addArrow(
                    gamePanel.section_1.hallway_entry.getRightX() - gamePanel.directionIndicator.width / 2,
                    (gamePanel.section_1.hallway_entry.getBottomY() + gamePanel.section_1.hallway_entry.getTopY()) / 2
                            - gamePanel.directionIndicator.height / 2);
            isTeleportable = false;
            completedAct++;
        }
        if (completedAct == 10 && gamePanel.currentMap == gamePanel.c2_hallway) {
            gamePanel.directionIndicator.resetArrow();
            Dialogue("Mình đã đến nơi rồi!");
        }
        if (completedAct == 11) {
            Dialogue("Bây giờ mình cần phải đi vào trong hội trường C2 để nộp hồ sơ, đi thôi nào!");
            gamePanel.directionIndicator.addArrow(
                    (gamePanel.c2_hallway.c2_hallEntry1.getRightX() + gamePanel.c2_hallway.c2_hallEntry1.getLeftX()) / 2
                            - gamePanel.directionIndicator.width / 2,
                    gamePanel.c2_hallway.c2_hallEntry1.getBottomY()
                            - gamePanel.directionIndicator.height);
            gamePanel.directionIndicator.addArrow(
                    (gamePanel.c2_hallway.c2_hallEntry2.getRightX() + gamePanel.c2_hallway.c2_hallEntry2.getLeftX()) / 2
                            - gamePanel.directionIndicator.width / 2,
                    gamePanel.c2_hallway.c2_hallEntry2.getBottomY()
                            - gamePanel.directionIndicator.height);
            gamePanel.directionIndicator.addArrow(
                    (gamePanel.c2_hallway.c2_hallEntry3.getRightX() + gamePanel.c2_hallway.c2_hallEntry3.getLeftX()) / 2
                            - gamePanel.directionIndicator.width / 2,
                    gamePanel.c2_hallway.c2_hallEntry3.getBottomY()
                            - gamePanel.directionIndicator.height);
            missionDescription.setMissionDescription("Di chuyển vào trong hội trường C2");
        }
        if (completedAct == 12 && gamePanel.currentMap == gamePanel.c2_hall) {
            completedAct++;
            gamePanel.directionIndicator.resetArrow();
        }
        if (completedAct == 13) {
            Dialogue("Theo thông báo của trường thì mình phải nộp hồ sơ ở hàng số 3 tính từ trái qua");
            missionDescription.setMissionDescription(
                    "Đến hàng thứ 3 từ trái sang để nộp hồ sơ(Sử dụng tập tài liệu sau khi tương tác với cô giáo)");
        }
        if (completedAct == 14) {
            if (collision.interactItem.Name.equals("Desk")) {
                Dialogue("Chào cô, em tới đây để đăng ký tân binh!");
            }
        }
        if (completedAct == 15) {
            ui.setDialogueCharacter("Teacher1");
            Dialogue("Đâu, để cô xem nào");
        }
        if (completedAct == 16) {
            Dialogue("Tên, tuổi, địa chỉ, giấy hoãn nghĩa vụ quân sự, ... ");
        }
        if (completedAct == 17) {
            Dialogue("Oke đủ rồi, cô nhận hồ sơ của em rồi nhé. Em về đi");
        }
        if (completedAct == 18) {
            ui.setDialogueCharacter("Main Character");
            Dialogue("Cảm ơn cô!");
            prevTime = TimeSystem.getCurrentSystemTimeInMilliseconds();
        }
        if (completedAct == 19 && TimeSystem.getCurrentSystemTimeInMilliseconds() - prevTime >= 2500) {
            ui.setDialogueCharacter("Empty");
            Dialogue("Căn bản là xong, thôi về ngủ.");
            missionDescription.setMissionDescription("Mở điện thoại, dịch chuyển về nhà");
        }
        if (completedAct == 20 && gamePanel.currentMap == gamePanel.myRoom) {
            Dialogue("Hoàn thành chapter 1");
        }
        if (completedAct == 21)
            nextTimeline();
    }

    void Timeline4() {
        gamePanel.currentChapter = gamePanel.chapter2;
        gamePanel.chapter2.completedAct = 0;
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
            case 2: {
                Timeline2();
                break;
            }
            case 3: {
                Timeline3();
                break;
            }
            case 4: {
                Timeline4();
                break;
            }
        }
    }

    void Dialogue(String str) {
        if (Main.topGameState().equals("GamePlay")) {
            ui.currentDialog = str;
            Main.pushGameState("Dialogue");
            ui.i = 0;
            ui.timer.setDelay(30);
            ui.isFinishDialogue = false;
            ui.timer.start();
        }
    }
}
