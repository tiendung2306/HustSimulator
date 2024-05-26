package Content;

import main.GamePanel;
import main.Main;
import sound.SoundManager;
import time.TimeSystem;

public class Chapter1 extends Chapter {
    public boolean IntroFinished = false, laptopMission = false, studentIDMission = false, noodleMission = false,
            hoSoMission = false;
    long prevTime = 0;
    public Boolean isTeleportable = false;
    public Boolean checkSound_chap1_01 = true, checkSound_chap1_02 = true;
    public static Boolean checkEndChapter = true;

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

    void Intro() {// Cho nhạc vào đấy
        if (checkSound_chap1_01) {
            SoundManager.loopSound("nhac_nen01");
            checkSound_chap1_01 = false;
        }
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
            nextTimeline();
    }

    void Timeline1() {
        IntroFinished = true;
        if (completedAct == 0) {
            TimeSystem.setCurrentTime("07:00");
            // Question("Đạo hàm của arctan(x) là cái ci???", "1/(1+x)", "1/(1-x)");
            // if(gamePanel.question.getAnswer() != 0) {
            // completedAct++;
            // }
            Dialogue("Đây là căn phòng của ta sao?");
        }
        if (completedAct == 1)
            Dialogue("Nó khá nhỏ so với tòa lâu đài của ta ở kiếp trước. Nhưng nó chứa khá là nhiều thứ thú vị!");
        missionDescription
                .setMissionDescription("Tìm Laptop, thẻ sinh viên và đọc thông tin của chúng(Ấn B để mở balo)");
        if (completedAct == 2) {
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
        if (completedAct == 3)
            Dialogue("Đại khái thì ta đã nắm bắt được mọi thứ xung quanh.");
        if (completedAct == 4)
            Dialogue("Tạm gác việc cứu thế giới lại vậy, ta cần cứu đói đã!");
        if (completedAct == 5)
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
                if (checkSound_chap1_02) {
                    SoundManager.playSound("an_mi");
                    checkSound_chap1_01 = false;
                }
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
                gamePanel.myRoom.tilePhone.isMission = false;
            }
        }
        if (completedAct == 4) {
            if (!phone.isDrawPhone) {
                Dialogue("Có thư tình báo!!!");
                missionDescription.setMissionDescription("Kiểm tra tin nhắn");
                phone.setNewMessage("chapter1_1");
                phone.isOpenMessager = false;
                prevTime = TimeSystem.getCurrentSystemTimeInMilliseconds();
            }
        }
        if (completedAct == 5 && phone.isOpenMessager && !phone.isDrawPhone) {
            if (!inventory.isExist("Hồ sơ")) {
                Dialogue("Bắt đầu hành trình làm anh hùng của thế giới mới thôi!");
                gamePanel.myRoom.tilehoso.isMission = true;
                missionDescription.setMissionDescription("Nhặt bộ hồ sơ nhập học");
            } else {
                gamePanel.myRoom.tilehoso.isMission = false;
                ++completedAct;
            }
            phone.clearMessage();
        }
        if (completedAct == 6 && inventory.isExist("Hồ sơ")) {
            Dialogue("Hội thợ săn nằm ở tòa C2, đến đăng ký tân thủ vào lúc 7h30");
            gamePanel.directionIndicator.addArrow(
                    (gamePanel.myRoom.tileDoorMyRoom.getLeftX() + gamePanel.myRoom.tileDoorMyRoom.getRightX()) / 2
                            - gamePanel.directionIndicator.width / 2,
                    gamePanel.myRoom.tileDoorMyRoom.getBottomY() - gamePanel.directionIndicator.height);
            missionDescription.setMissionDescription("Tương tác với cửa phòng để di chuyển đến Section 1");
            isTeleportable = true;
        }
        if (completedAct == 7 && gamePanel.currentMap == gamePanel.section_1) {
            gamePanel.directionIndicator.resetArrow();
            missionDescription.setMissionDescription("Tìm hội trường C2");
            gamePanel.directionIndicator.addArrow(
                    gamePanel.section_1.hallway_entry.getRightX() - gamePanel.directionIndicator.width / 2,
                    (gamePanel.section_1.hallway_entry.getBottomY() + gamePanel.section_1.hallway_entry.getTopY()) / 2
                            - gamePanel.directionIndicator.height / 2);
            isTeleportable = false;
            completedAct++;
        }
        if (completedAct == 8 && gamePanel.currentMap == gamePanel.c2_hallway) {
            gamePanel.directionIndicator.resetArrow();
            ++completedAct;
        }
        if (completedAct == 9) {
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
            ++completedAct;
        }
        if (completedAct == 10 && gamePanel.currentMap == gamePanel.c2_hall) {
            completedAct++;
            gamePanel.directionIndicator.resetArrow();
        }
        if (completedAct == 11) {
            Dialogue("Ta muốn trở thành chúa tể bóng tối, thì đăng ký ở quầy nào đây.");
            missionDescription.setMissionDescription(
                    "Đến hàng thứ 2 từ trái sang để nộp hồ sơ(Sử dụng tập tài liệu sau khi tương tác với cô giáo)");
        }
        if (completedAct == 12) {
            if (collision.interactItem.Name.equals("Desk")) {
                ui.setDialogueCharacter("Main Character");
                Dialogue("Chào cô, tôi tới đây để đăng ký tân binh!");
            }
        }
        if (completedAct == 13) {
            ui.setDialogueCharacter("Teacher1");
            Dialogue("Đâu, để cô xem nào");
        }
        if (completedAct == 14) {
            Dialogue("Tên, tuổi, địa chỉ, ... ");
        }
        if (completedAct == 15) {
            Dialogue("Oke đủ rồi, cô nhận hồ sơ của em rồi nhé. Em về đi");
        }
        if (completedAct == 16) {
            ui.setDialogueCharacter("Main Character");
            Dialogue("Đa tạ!");
            prevTime = TimeSystem.getCurrentSystemTimeInMilliseconds();
        }
        if (completedAct == 17 && TimeSystem.getCurrentSystemTimeInMilliseconds() - prevTime >= 2500) {
            ui.setDialogueCharacter("Empty");
            Dialogue("Căn bản là xong, thôi về ngủ.");
            missionDescription.setMissionDescription("Mở điện thoại, dịch chuyển về nhà");
        }
        if (completedAct == 18 && gamePanel.currentMap == gamePanel.myRoom) {
            if (checkEndChapter) {
                Main.pushGameState("EndChapter");
                SoundManager.stopSound("nhac_nen01");
                SoundManager.playSound("xong_chapter");
                EndChapter.checkChapter = "1";
                checkEndChapter = false;
            }
            Dialogue("Hoàn thành chapter 1");
        }
        if (completedAct == 19)
            nextTimeline();
    }

    void Timeline4() {
        if (!checkSound_chap1_01) {
            SoundManager.stopSound("nhac_nen01");
            checkSound_chap1_01 = true;
        }
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

    void Question(String question, String answer1, String answer2) {
        if (gamePanel.question.getAnswer() != 0)
            return;
        gamePanel.question.setQuestion(question, answer1, answer2);
        if (Main.topGameState().equals("GamePlay"))
            Main.pushGameState("Dialogue");
    }
}
