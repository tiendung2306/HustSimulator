package Content;

import main.GamePanel;
import main.Main;
import sound.SoundManager;
import time.TimeSystem;

public class Chapter2 extends Chapter {

    long prevTime = 0;
    public boolean isAtClassMrsToan = false, isAtClassMrHoa = false;
    boolean isStart = false;
    public Boolean checkSound_chap2_01 = true, checkSound_chap2_02 = true, checkEndChapter = true;

    public Chapter2(GamePanel gamePanel) {
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

    void Timeline0() {
        if (checkSound_chap2_01) {
            SoundManager.loopSound("nhac_nen02");
            checkSound_chap2_01 = false;
        }
        if (completedAct == 0) {
            if (!isStart) {
                isStart = true;
                prevTime = TimeSystem.getCurrentSystemTimeInMilliseconds();
            }
            if (TimeSystem.getCurrentSystemTimeInMilliseconds() - prevTime >= 100) {
                TimeSystem.goNextDay();
                completedAct++;
            }
        }
        if (completedAct == 1)
            Dialogue("Ngày thứ 2 kể từ khi ta chuyển sinh vào thế giới này.");
        if (completedAct == 2)
            Dialogue("Từng là Anh Hùng mà nay lại phải cày cuốc như một tân binh. Trớ trêu thật!");
        if (completedAct == 3) {
            Dialogue("Thôi thì hết cách rồi, để xem nhiệm vụ đầu tiên hội đưa ra cho ta là gì.");
            missionDescription.setMissionDescription("Kiểm tra lịch học ở trong app Fhust.");
            gamePanel.myRoom.tilePhone.isMission = true;
            phone.isOpenFhust = false;
        }
        if (completedAct == 4) {
            if (phone.isOpenFhust && !phone.isDrawPhone) {
                Dialogue("Nhiệm vụ đầu tiên đã phải đối đầu với Boss Nguyễn Thị Toàn và Lê Quang Hòa sao?");
                missionDescription.setMissionDescription("");
                prevTime = TimeSystem.getCurrentSystemTimeInMilliseconds();
            }
        }
        if (completedAct == 5)
            Dialogue("Theo thông tin tình báo thì Nguyễn Thị Toàn là Boss của khu vực 37,...");
        if (completedAct == 6)
            Dialogue("Đã có biết bao thợ săn phải nằm lại dưới lưỡi bút của cô.");
        if (completedAct == 7)
            Dialogue("Còn Boss Lê Quang Hòa vẫn luôn là một ẩn số mà đến nay hội vẫn chưa khai phá được.");
        if (completedAct == 8)
            nextTimeline();
    }

    void Timeline1() {
        if (completedAct == 0) {
            missionDescription.setMissionDescription(
                    "Di chuyển tới tòa D3-5 tại Section 2, tham gia lớp học cô Nguyễn Thị Toàn tại phòng 301.");
            isAtClassMrsToan = false;
            ++completedAct;
        }
        if (completedAct == 1) {
            if (gamePanel.currentMap == gamePanel.myRoom) {
                gamePanel.directionIndicator.addArrow(
                        (gamePanel.myRoom.tileDoorMyRoom.getLeftX() + gamePanel.myRoom.tileDoorMyRoom.getRightX()) / 2
                                - gamePanel.directionIndicator.width / 2,
                        gamePanel.myRoom.tileDoorMyRoom.getBottomY() - gamePanel.directionIndicator.height);
            }
            if (gamePanel.currentMap == gamePanel.section_2) {
                gamePanel.directionIndicator.addArrow(
                        (gamePanel.section_2.hallway_entry_1.getLeftX()
                                + gamePanel.section_2.hallway_entry_1.getRightX()) / 2
                                - gamePanel.directionIndicator.width / 2,
                        gamePanel.section_2.hallway_entry_1.getBottomY() - gamePanel.directionIndicator.height);
                gamePanel.directionIndicator.addArrow(
                        (gamePanel.section_2.hallway_entry_2.getLeftX()
                                + gamePanel.section_2.hallway_entry_2.getRightX()) / 2
                                - gamePanel.directionIndicator.width / 2,
                        gamePanel.section_2.hallway_entry_2.getBottomY() - gamePanel.directionIndicator.height);
                gamePanel.directionIndicator.addArrow(
                        (gamePanel.section_2.hallway_entry_3.getLeftX()
                                + gamePanel.section_2.hallway_entry_3.getRightX()) / 2
                                - gamePanel.directionIndicator.width / 2,
                        gamePanel.section_2.hallway_entry_3.getBottomY() - gamePanel.directionIndicator.height);
            }
            if (gamePanel.currentMap == gamePanel.d3_hallway) {
                gamePanel.directionIndicator.addArrow(
                        gamePanel.d3_hallway.D3_1stfloor_stair1.getRightX()
                                - gamePanel.directionIndicator.width / 2,
                        (gamePanel.d3_hallway.D3_1stfloor_stair1.getTopY()
                                + gamePanel.d3_hallway.D3_1stfloor_stair1.getBottomY()) / 2
                                - gamePanel.directionIndicator.height);
                gamePanel.directionIndicator.addArrow(
                        gamePanel.d3_hallway.D3_1stfloor_stair2.getLeftX()
                                - gamePanel.directionIndicator.width / 2,
                        (gamePanel.d3_hallway.D3_1stfloor_stair2.getTopY()
                                + gamePanel.d3_hallway.D3_1stfloor_stair2.getBottomY()) / 2
                                - gamePanel.directionIndicator.height);
            }
            if (gamePanel.currentMap == gamePanel.d3_secondfloor_hallway) {
                if (gamePanel.d3_secondfloor_hallway.curr_floor < 3) {
                    gamePanel.directionIndicator.addArrow(
                            gamePanel.d3_secondfloor_hallway.d3_stair_up1.getRightX()
                                    - gamePanel.directionIndicator.width / 2,
                            (gamePanel.d3_secondfloor_hallway.d3_stair_up1.getTopY()
                                    + gamePanel.d3_secondfloor_hallway.d3_stair_up1.getBottomY()) / 2
                                    - gamePanel.directionIndicator.height);
                    gamePanel.directionIndicator.addArrow(
                            gamePanel.d3_secondfloor_hallway.d3_stair_up2.getLeftX()
                                    - gamePanel.directionIndicator.width / 2,
                            (gamePanel.d3_secondfloor_hallway.d3_stair_up2.getTopY()
                                    + gamePanel.d3_secondfloor_hallway.d3_stair_up2.getBottomY()) / 2
                                    - gamePanel.directionIndicator.height);
                } else if (gamePanel.d3_secondfloor_hallway.curr_floor == 3) {
                    gamePanel.directionIndicator.addArrow(
                            (gamePanel.d3_secondfloor_hallway.d3_5_secondfloor_entry.getLeftX()
                                    + gamePanel.d3_secondfloor_hallway.d3_5_secondfloor_entry.getRightX())
                                    / 2
                                    - gamePanel.directionIndicator.width / 2,
                            gamePanel.d3_secondfloor_hallway.d3_5_secondfloor_entry.getBottomY()
                                    - gamePanel.directionIndicator.height);
                } else {
                    gamePanel.directionIndicator.addArrow(
                            gamePanel.d3_secondfloor_hallway.d3_stair_down1.getRightX()
                                    - gamePanel.directionIndicator.width / 2,
                            (gamePanel.d3_secondfloor_hallway.d3_stair_down1.getTopY()
                                    + gamePanel.d3_secondfloor_hallway.d3_stair_down1.getBottomY()) / 2
                                    - gamePanel.directionIndicator.height);
                    gamePanel.directionIndicator.addArrow(
                            gamePanel.d3_secondfloor_hallway.d3_stair_down2.getLeftX()
                                    - gamePanel.directionIndicator.width / 2,
                            (gamePanel.d3_secondfloor_hallway.d3_stair_down2.getTopY()
                                    + gamePanel.d3_secondfloor_hallway.d3_stair_down2.getBottomY()) / 2
                                    - gamePanel.directionIndicator.height);
                }
            }
            if (gamePanel.currentMap == gamePanel.d3_5_hallway_secondfloor) {
                if (gamePanel.d3_5_hallway_secondfloor.curr_floor == 3) {
                    gamePanel.directionIndicator.addArrow(
                            (gamePanel.d3_5_hallway_secondfloor.d3_5_301_door.getLeftX()
                                    + gamePanel.d3_5_hallway_secondfloor.d3_5_301_door.getRightX())
                                    / 2
                                    - gamePanel.directionIndicator.width / 2,
                            gamePanel.d3_5_hallway_secondfloor.d3_5_301_door.getBottomY()
                                    - gamePanel.directionIndicator.height);
                }
            }
            if (isAtClassMrsToan) {
                gamePanel.directionIndicator.resetArrow();
                if (checkSound_chap2_02) {
                    SoundManager.pauseSound("nhac_nen02");
                    SoundManager.loopSound("gap_gv");
                    checkSound_chap2_02 = false;
                }
                prevTime = TimeSystem.getCurrentSystemTimeInMilliseconds();
                isAtClassMrsToan = false;
                ++completedAct;
                prevTime = TimeSystem.getCurrentSystemTimeInMilliseconds();
            }
        }
        if (completedAct == 2 && TimeSystem.getCurrentSystemTimeInMilliseconds() - prevTime >= 500) {
            ui.setDialogueBackground("Classroom");
            ui.setDialogueCharacter("Mrs Toan");
            Dialogue("Eng tê, dừ buổi mô rồi eng mì mò mặt đến lớp?");
        }
        if (completedAct == 3) {
            checkSound_chap2_02 = true;
            Dialogue("Eng lên bảng giải câu ni cho tui.");
        }
        if (completedAct == 4) {
            gamePanel.normalClassroom.addTile(gamePanel.normalClassroom.mrsToan);
            missionDescription.setMissionDescription("Innova cô Toàn đi");
            ++completedAct;
        }
        if (completedAct == 5) {
            if (collision.interactItem.Name.equals("Mrs Toan"))
                Dialogue("Trả lời, đạo hàm của arctan là?");
        }
        if (completedAct == 6) {
            Question("Đạo hàm của arctan(x) là cái chi???", "1/(1+x)", "1/(1-x^2)");
            if (gamePanel.question.getAnswer() != 0) {
                completedAct++;
            }
        }
        if (completedAct == 7) {
            ui.setDialogueCharacter("Main Character");
            String str = "Đáp án chính là ";
            if (gamePanel.question.getAnswer() == 1)
                str += gamePanel.question.answer1;
            else
                str += gamePanel.question.answer2;
            Dialogue(str);
        }
        if (completedAct == 8) {
            if (checkSound_chap2_02) {
                SoundManager.playSound("tra_loi_sai");
                checkSound_chap2_02 = false;
            }
            ui.setDialogueCharacter("Mrs Toan");
            Dialogue("Sai");
        }
        if (completedAct == 9) {
            ui.setDialogueCharacter("Cat Meme");
            if (!checkSound_chap2_02) {
                SoundManager.playSound("meme_meo");
                checkSound_chap2_02 = true;
            }
            Dialogue("...");
        }
        if (completedAct == 10) {
            ui.setDialogueCharacter("Mrs Toan");
            Dialogue("Về chộ đi, trớp trớp thật. Nỏ mần được cấy chi nên hồn.");
        }
        if (completedAct == 11)
            nextTimeline();
    }

    void Timeline2() {
        if (completedAct == 0) {
            if (checkSound_chap2_02) {
                SoundManager.resumeSound("nhac_nen02", true);
                SoundManager.pauseSound("gap_gv");
                checkSound_chap2_02 = false;
            }
            ui.setDialogueBackground("Empty");
            ui.setDialogueCharacter("Empty");
            Dialogue("Nguy hiểm thật sự, quả là ma pháp tà đạo!");
            missionDescription.setMissionDescription("Qua phòng 302 tham gia lớp thầy Lê Quang Hòa.");
            isAtClassMrHoa = false;
        }
        if (completedAct == 1) {
            if (isAtClassMrHoa) {
                gamePanel.normalClassroom.deleteTile(gamePanel.normalClassroom.numTileContainer - 1);
                if (!checkSound_chap2_02) {
                    SoundManager.pauseSound("nhac_nen02");
                    SoundManager.resumeSound("gap_gv", true);
                    checkSound_chap2_02 = true;
                }
                prevTime = TimeSystem.getCurrentSystemTimeInMilliseconds();
                ++completedAct;
                isAtClassMrHoa = false;
            }
        }
        if (completedAct == 2 && TimeSystem.getCurrentSystemTimeInMilliseconds() - prevTime >= 500) {
            ui.setDialogueBackground("Classroom");
            ui.setDialogueCharacter("Mr Hoa");
            Dialogue("qwertyuiopasdfghjklzxcvbnm");
        }
        if (completedAct == 3) {
            Dialogue("448877778 777744468855528666777");
        }
        if (completedAct == 4) {
            Dialogue("https://www.youtube.com/watch?v=d Qw4w9WgXcQ");
        }
        if (completedAct == 5) {
            ui.setDialogueCharacter("Empty");
            Dialogue("...");
        }
        if (completedAct == 6) {
            Dialogue("Thôi được rồi.");
        }
        if (completedAct == 7) {
            if (checkSound_chap2_02) {
                SoundManager.resumeSound("nhac_nen02", true);
                SoundManager.stopSound("gap_gv");
                checkSound_chap2_02 = false;
            }
            Dialogue("Hôm nay tới đây là đủ rồi!");
        }
        if (completedAct == 8) {
            checkSound_chap2_02 = true;
            ui.setDialogueBackground("Empty");
            missionDescription.setMissionDescription("Di chuyển về nhà và ngủ đi");
            gamePanel.myRoom.tileBed.isMission = true;
            ++completedAct;
        }
        if (completedAct == 9) {
            if (collision.interactItem.Name.equals("My Bed")) {
                gamePanel.myRoom.tileBed.isMission = false;
                if (checkEndChapter) {
                    Main.pushGameState("EndChapter");
                    SoundManager.stopSound("nhac_nen02");
                    SoundManager.playSound("xong_chapter");
                    EndChapter.checkChapter = "2";
                    checkEndChapter = false;
                }
                Dialogue("Hoàn thành Chapter 2");
            }
        }
        if (completedAct == 10) {
            nextTimeline();
        }
    }

    void Timeline3() {
        gamePanel.currentChapter = gamePanel.chapter3;
        gamePanel.chapter3.completedAct = 0;
    }

    public void update() {
        if (!Main.topGameState().equals("GamePlay") && !Main.topGameState().equals("Inventory")
                && !Main.topGameState().equals("Dialog") && !Main.topGameState().equals("Dialogue"))
            return;
        switch (currentTimeline) {
            case 0: {
                Timeline0();
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
