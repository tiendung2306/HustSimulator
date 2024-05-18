package Content;

import main.GamePanel;
import main.Main;
import time.TimeSystem;

public class Chapter2 extends Chapter {

    long prevTime = 0;
    boolean isAtClassMrsToan = true, isAtClassMrHoa = true, isAtBed = true;
    Boolean isStart = false;

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
        if (completedAct == 0) {
            if(!isStart) {
                isStart = true;
                prevTime = TimeSystem.getCurrentSystemTimeInMilliseconds();
            }
            if (TimeSystem.getCurrentSystemTimeInMilliseconds() - prevTime >= 100)
                completedAct++;
        }
        if (completedAct == 1)
            Dialogue("Ngày thứ 2 kể từ khi ta chuyển sinh vào thế giới này.");
        if (completedAct == 2)
            Dialogue("Sự yên bình này, cũng khá là tuyệt vời đấy chứ.");
        if (completedAct == 3)
            Dialogue("Ta đã chính thức trở thành thợ săn kể từ hôm nay.");
        if (completedAct == 4)
            Dialogue("Từng là Anh Hùng mà nay lại phải cày cuốc như một tân binh. Trớ trêu thật!");
        if (completedAct == 5) {
            Dialogue("Thôi thì hết cách rồi, để xem nhiệm vụ đầu tiên hội đưa ra cho ta là gì.");
            missionDescription.setMissionDescription("Kiểm tra lịch học ở trong app Fhust.");
            gamePanel.myRoom.tilePhone.isMission = true;
            phone.isOpenFhust = false;
            TimeSystem.goNextDay();
        }
        if (completedAct == 6) {
            if (phone.isOpenFhust && !phone.isDrawPhone) {
                Dialogue("Nhiệm vụ đầu tiên đã phải đối đầu với Boss Nguyễn Thị Toàn và Lê Quang Hòa sao?");
                missionDescription.setMissionDescription("");
                prevTime = TimeSystem.getCurrentSystemTimeInMilliseconds();
            }
        }
        if (completedAct == 7)
            Dialogue("Theo thông tin tình báo thì Nguyễn Thị Toàn là Boss của khu vực 37,...");
        if (completedAct == 8)
            Dialogue("Đã có biết bao thợ săn phải nằm lại dưới lưỡi bút của cô.");
        if (completedAct == 9)
            Dialogue("Còn Boss Lê Quang Hòa vẫn luôn là một ẩn số mà đến nay hội vẫn chưa khai phá được.");
        if (completedAct == 10)
            Dialogue("Khó nhằn đây!");
        if (completedAct == 11)
            Dialogue("Nhưng đối với vị anh hùng như ta, nhiệm vụ này cũng chỉ là Piece of Caek!");
        if (completedAct == 12)
            nextTimeline();
    }

    void Timeline1() {
        if (completedAct == 0) {
            missionDescription.setMissionDescription(
                    "Di chuyển tới tòa D3-5 tại Section 2, tham gia lớp học cô Nguyễn Thị Toàn.");
            // isAtClassMrsToan = false;
            ++completedAct;
        }
        if (completedAct == 1) {
            if (isAtClassMrsToan) {
                ui.setDialogueBackground("Classroom");
                ui.setDialogueCharacter("Mrs Toan");
                Dialogue("Anh tê, dừ là buổi mô rồi anh mì mò mặt đến lớp? Tôi tích cho anh 1 dấu.");
                isAtClassMrsToan = false;
            }
        }
        if (completedAct == 2) {
            ui.setDialogueCharacter("Empty");
            Dialogue("Aiss, chưa gì đã dính tuyệt chiêu của Boss, mình phải cẩn thận hơn.");
        }
        if (completedAct == 3) {
            ui.setDialogueCharacter("Mrs Toan");
            Dialogue("Ci anh vừa mới tới mô rồi, anh lên bảng giải câu ni được thì tha cho anh.");
        }
        if (completedAct == 4) {
            Dialogue("Đạo hàm của ác tan là cấy chi?");
        }
        if (completedAct == 5) {
            ui.setDialogueCharacter("Empty");
            Dialogue(
                    "Mình có nghe nhầm không? Câu hỏi này ở thế giới mình đến cả đứa trẻ 5 tuổi cũng trả lời được mà.");
        }
        if (completedAct == 6) {
            Dialogue("Hệ thống, giúp ta trả lời câu hỏi này.");
        }
        if (completedAct == 7) {
            ui.setDialogueCharacter("System");
            Dialogue("Đã rõ! Câu trả lời là 1/(1+x).");
        }
        if (completedAct == 8) {
            ui.setDialogueCharacter("Main Character");
            Dialogue("Thưa cô, đáp án chính là 1/(1+x).");
        }
        if (completedAct == 9) {
            ui.setDialogueCharacter("Mrs Toan");
            Dialogue("Sai");
        }
        if (completedAct == 10) {
            ui.setDialogueCharacter("Cat Meme");
            Dialogue("...");
        }
        if (completedAct == 11) {
            ui.setDialogueCharacter("System");
            Dialogue("...");
        }
        if (completedAct == 12) {
            ui.setDialogueCharacter("Mrs Toan");
            Dialogue("Anh về chộ đi, trớp trớp thật. Nỏ mần được cấy ci nên hồn.");
        }
        if (completedAct == 13) {
            ui.setDialogueCharacter("Mrs Toan");
            Dialogue("Học hành cho nên thân buổi sau tui gọi anh tiếp.");
        }
        if (completedAct == 14)
            nextTimeline();
    }

    void Timeline2() {
        if (completedAct == 0) {
            ui.setDialogueBackground("Empty");
            ui.setDialogueCharacter("Empty");
            Dialogue("Nguy hiểm thật sự, quả là ma pháp tà đạo!");
            missionDescription.setMissionDescription("Tham gia lớp Triết Học của thầy Lê Quang Hòa.");
        }
        if (completedAct == 1) {
            if (isAtClassMrHoa) {
                ui.setDialogueBackground("Classroom");
                ui.setDialogueCharacter("Mr Hoa");
                Dialogue(
                        "Hạt lúa người ta gọi là cái khẳng định, nhưng khi hạt lúa nó được gieo nảy mầm và lên cây lúa, thì cây lúa là cái phủ định của hạt lúa...");
                // isAtClassMrHoa = false;
            }
        }
        if (completedAct == 2) {
            Dialogue("và cây lúa lại tiếp tục vận động phát triển đến một lúc nào đó nó trổ bông những bông lúa...");
        }
        if (completedAct == 3) {
            Dialogue(
                    "thì bông lúa ấy lại là cái phủ định của phủ định thông qua cái phủ định trung gian là phủ định và so với cái phủ định lần 1 là cái khẳng định.");
        }
        if (completedAct == 4) {
            ui.setDialogueCharacter("Empty");
            Dialogue("...");
        }
        if (completedAct == 5) {
            Dialogue("Ngôn ngữ gì vậy?");
        }
        if (completedAct == 6) {
            Dialogue("Hôm nay tới đây là đủ rồi");
        }
        if (completedAct == 7) {
            ui.setDialogueBackground("Empty");
            missionDescription.setMissionDescription("Di chuyển về nhà và ngủ đi");
            ++completedAct;
        }
        if (completedAct == 8) {
            if (isAtBed)
                nextTimeline();
        }
    }

    void Timeline3() {

    }

    public void update() {
        if (!Main.topGameState().equals("GamePlay") && !Main.topGameState().equals("Inventory")
                && !Main.topGameState().equals("Dialogue") && !Main.topGameState().equals("Dialogue"))
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
}
