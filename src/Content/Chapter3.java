package Content;

import main.GamePanel;
import main.Main;
import sound.SoundManager;
import tile.Tile;
import time.TimeSystem;

public class Chapter3 extends Chapter{

    long prevTime = 0;
    public Boolean checkSound_chap3_01 = true, checkSound_chap3_02 = true, checkEndChapter = true;
    public boolean isAtLibrary = false;
    public Chapter3(GamePanel gamePanel) {
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
        if (checkSound_chap3_01) {
            SoundManager.loopSound("nhac_nen03");
            checkSound_chap3_01 = false;
        }
        if (completedAct == 0)
            Dialogue("Great day to go to the library");
        if (completedAct == 1) {
            Dialogue("Practice makes perfect");
            missionDescription.setMissionDescription("Tới phòng tự học tại tầng 3 thư viện!");
            isAtLibrary = false;
        }
        if (completedAct == 2){
            if (isAtLibrary){
                gamePanel.library.addTile(gamePanel.library.npcGirl);
                ++completedAct;
                isAtLibrary = false;
            }
            prevTime = TimeSystem.getCurrentSystemTimeInMilliseconds();
        }
        if (completedAct == 3 && TimeSystem.getCurrentSystemTimeInMilliseconds() - prevTime >= 500){
            if(checkSound_chap3_02) {
                SoundManager.playSound("wow");
                SoundManager.pauseSound("nhac_nen03");
                checkSound_chap3_02 = false;
            }
            ui.setReelsCharacter("Surprise Meme");
            Main.pushGameState("Reels");
            ++completedAct;
            prevTime = TimeSystem.getCurrentSystemTimeInMilliseconds();
        }
        if (completedAct == 4 && TimeSystem.getCurrentSystemTimeInMilliseconds() - prevTime >= 2300){
            checkSound_chap3_02 = true;
            if (Main.topGameState().equals("Reels"))
                Main.popGameState();
            ++completedAct;
        }
        if (completedAct == 5){
            if(checkSound_chap3_02) {
                SoundManager.playSound("tim_dap");
                checkSound_chap3_02 = false;
            }
            ui.setReelsCharacter("Girl Reading Book");
            Main.pushGameState("Reels");
            prevTime = TimeSystem.getCurrentSystemTimeInMilliseconds();
            ++completedAct;
        }
        if (completedAct == 6 && TimeSystem.getCurrentSystemTimeInMilliseconds() - prevTime >= 4400){
            if(!checkSound_chap3_02) {
                SoundManager.resumeSound("nhac_nen03",true);
                checkSound_chap3_02 = true;
            }
            if (Main.topGameState().equals("Reels"))
                Main.popGameState();
            ++completedAct;
            prevTime = TimeSystem.getCurrentSystemTimeInMilliseconds();
        }
        if (completedAct == 7 && TimeSystem.getCurrentSystemTimeInMilliseconds() - prevTime >= 500){
            Dialogue("Ăn cướp!!!");
        }
        if (completedAct == 8){
            Dialogue("Nàng đã cướp mất trái tim ta rồi!");
            missionDescription.setMissionDescription("Lại tán đi!");
        }
        if (completedAct == 9){
            if (collision.interactItem.Name.equals("NPC Girl"))
            {
                if(checkSound_chap3_02) {
                    SoundManager.loopSound("tan_gai");
                    SoundManager.pauseSound("nhac_nen03");
                    checkSound_chap3_02 = false;
                }
                ui.setDialogueCharacter("Main Character");
                ui.setDialogueBackground("Library");
                Dialogue("N...nàng ăn cơm chưa?");
            }
        }
        if (completedAct == 10) {
            checkSound_chap3_02 = true;
            ui.setDialogueCharacter("NPC Girl");
            Dialogue("???");
        }
        if (completedAct == 11){
            ui.setDialogueCharacter("Main Character");
            Dialogue("Hôm nay chẳng có mưa rơi");
        }
        if (completedAct == 12){
            Dialogue("Cho anh xin phép mời nàng ôn thi!");
        }
        if (completedAct == 13){
            ui.setDialogueCharacter("NPC Girl");
            Dialogue("???");
        }
        if (completedAct == 14){
            Dialogue("Thằng dở hơi");
        }
        if (completedAct == 15){
            ui.setDialogueCharacter("Main Character");
            Dialogue("Ơ kìa, nàng chạy đi đâu đấy?");
            if (gamePanel.library.tileContainer[gamePanel.library.numTileContainer - 1] == gamePanel.library.npcGirl) {
                gamePanel.library.deleteTile(gamePanel.library.numTileContainer - 1);
                gamePanel.player.ButtonInteract = false;
            }
        }
        if (completedAct == 16){
            nextTimeline();
        }
    }

    void Timeline1() {
        if (completedAct == 0){
            ui.setDialogueCharacter("Empty");
            Dialogue("Phải chăng nàng ngại?");
        }
        if (completedAct == 1){
            Dialogue("Nàng ấy ở đâu được nhỉ?");
        }
        if (completedAct == 2){
            if(checkSound_chap3_02) {
                SoundManager.stopSound("tan_gai");
                SoundManager.resumeSound("nhac_nen03",true);
                checkSound_chap3_02 = false;
            }
            collision.interactItem = new Tile();
            missionDescription.setMissionDescription("Tìm cô ấy đi, tình yêu cuộc đời đấy! (Có thể là ở Hồ Tiền)");
            //gamePanel.section_3.addTile(gamePanel.section_3.npcGirl);
            ++completedAct;
        }
        if (completedAct == 3){
            checkSound_chap3_02 = true;
            nextTimeline();
        }
    }
    void Timeline2(){
        if (completedAct == 0){
            if (collision.interactItem.Name.equals("NPC Girl"))
            {
                if(checkSound_chap3_02) {
                    SoundManager.stopSound("nhac_nen03");
                    SoundManager.playSound("tang_hoa");
                    checkSound_chap3_02 = false;
                }
                ui.setReelsCharacter("Cat Giving Flower");
                Main.pushGameState("Reels");
                prevTime = TimeSystem.getCurrentSystemTimeInMilliseconds();
                ++completedAct;
            }
        }
        if (completedAct == 1 && TimeSystem.getCurrentSystemTimeInMilliseconds() - prevTime >= 8000){
            checkSound_chap3_02 = true;
            if (Main.topGameState().equals("Reels"))
                Main.popGameState();
            prevTime = TimeSystem.getCurrentSystemTimeInMilliseconds();
            ++completedAct;
        }
        if (completedAct == 2 && TimeSystem.getCurrentSystemTimeInMilliseconds() - prevTime >= 300){
            ui.setDialogueCharacter("Main Character");
            ui.setDialogueBackground("Lake");
            if(checkSound_chap3_02) {
                SoundManager.loopSound("puon_cuoi");
                checkSound_chap3_02 = false;
            }
            Dialogue("Nàng thì đẹp tựa đóa hoa");
        }
        if (completedAct == 3){
            checkSound_chap3_02 = true;
            Dialogue("Ta A Giải tích thật là hợp nhau!");
        }
        if (completedAct == 4){
            Dialogue("Cho ta làm quen nhé.");
        }
        if (completedAct == 5){
            ui.setDialogueCharacter("NPC Girl");
            Dialogue("Không.");
            prevTime = TimeSystem.getCurrentSystemTimeInMilliseconds();
        }
        if (completedAct == 6 && TimeSystem.getCurrentSystemTimeInMilliseconds() - prevTime >= 300){
            ui.setDialogueCharacter("Empty");
            Dialogue("Ta biết nàng ấy thích ta, nhưng lại cố tỏ ra vô tình. Quả là cô gái thú vị!");
        }
        if (completedAct == 7){
            Dialogue("Thôi được rồi.");
        }
        if (completedAct == 8){
            Dialogue("Hôm nay tới đây là đủ rồi");
        }
        if (completedAct == 9){
            if(checkSound_chap3_02) {
                SoundManager.stopSound("puon_cuoi");
                SoundManager.resumeSound("nhac_nen03",true);
                checkSound_chap3_02 = false;
            }
            ui.setDialogueBackground("Empty");
            missionDescription.setMissionDescription("Di chuyển về nhà và ngủ đi");
            ++completedAct;
        }
        if (completedAct == 10){
            if (collision.interactItem.Name.equals("My Bed"))
                nextTimeline();
        }
    }
    void Timeline3(){
        Dialogue("Hoàn thành Chapter 3");
        if (checkEndChapter) {
            Main.pushGameState("EndChapter");
            SoundManager.stopSound("nhac_nen03");
            SoundManager.playSound("xong_chapter");
            EndChapter.checkChapter = "3";
            checkEndChapter = false;
        }
    }
    public void update() {
        if (!Main.topGameState().equals("GamePlay") && !Main.topGameState().equals("Inventory")
                && !Main.topGameState().equals("Dialogue") && !Main.topGameState().equals("Dialogue") && !Main.topGameState().equals("Reels"))
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
